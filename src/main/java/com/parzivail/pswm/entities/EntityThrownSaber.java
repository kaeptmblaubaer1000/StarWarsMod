package com.parzivail.pswm.entities;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.force.CronUtils;
import com.parzivail.pswm.force.powers.PowerBase;
import com.parzivail.pswm.items.weapons.ItemLightsaber;
import com.parzivail.pswm.utils.ForceUtils;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityThrownSaber extends EntityThrowable
{
	private int timeAlive = 0;
	protected float damage = 30.0f;
	protected float speed = 1.5f;
	private boolean isReturning = false;

	private static final int SENDER_DW = 14;
	private static final int ITEMSTACK_DW = 15;

	public EntityThrownSaber(World par1World)
	{
		super(par1World);
		this.setSize(1.5f, 0.1f);
	}

	public EntityThrownSaber(World par1World, EntityLivingBase sender, ItemStack saber)
	{
		super(par1World, sender);
		this.setSize(1.5f, 0.1f);
		this.speed = 3f;
		setSaberStack(saber);
		this.setThrowableHeading(sender.getLookVec().xCoord, sender.getLookVec().yCoord, sender.getLookVec().zCoord, 1.0F, 1.0F);
	}

	@Override
	public void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(SENDER_DW, 0);
		this.dataWatcher.setObjectWatched(SENDER_DW);
		this.dataWatcher.addObject(ITEMSTACK_DW, new ItemStack(Blocks.air, 0));
		this.dataWatcher.setObjectWatched(ITEMSTACK_DW);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		if (this.isEntityInvulnerable())
			return false;
		this.setBeenAttacked();
		if (source.getEntity() != null)
		{
			Vec3 vec3 = source.getEntity().getLookVec();
			if (vec3 != null)
			{
				this.motionX = vec3.xCoord;
				this.motionY = vec3.yCoord;
				this.motionZ = vec3.zCoord;
			}
			return true;
		}
		return false;
	}

	@Override
	protected float getGravityVelocity()
	{
		return 0.0F;
	}

	public EntityLivingBase getSender()
	{
		return (EntityLivingBase)this.worldObj.getEntityByID(dataWatcher.getWatchableObjectInt(SENDER_DW));
	}

	public ItemStack getSaberStack()
	{
		return dataWatcher.getWatchableObjectItemStack(ITEMSTACK_DW);
	}

	@Override
	protected void onImpact(MovingObjectPosition pos)
	{
		if (this.getSender() == null || this.worldObj == null)
		{
			this.setDead();
			return;
		}

		if (pos.typeOfHit == MovingObjectType.ENTITY && pos.entityHit != this.getSender() && pos.entityHit != this.getSender().ridingEntity)
		{
			if (pos.entityHit instanceof EntityPlayer)
			{
				EntityPlayer entityPlayer = (EntityPlayer)pos.entityHit;
				if (CronUtils.getHolocron(entityPlayer) != null)
				{
					PowerBase powerBase = CronUtils.getActive(entityPlayer);

					if (!powerBase.name.equalsIgnoreCase("deflect") && !powerBase.isRunning)
					{
						pos.entityHit.attackEntityFrom(StarWarsMod.saberDamageSource, this.damage);
						pos.entityHit.setFire(8);
						trackSender();
					}
				}
				else if (entityPlayer.isBlocking() && entityPlayer.inventory.getCurrentItem() != null && (entityPlayer.inventory.getCurrentItem().getItem() instanceof ItemLightsaber))
				{
					entityPlayer.playSound(Resources.MODID + ":" + "item.lightsaber.deflect", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(this.rand, -0.2D, 0.2D));
				}
				else
				{
					pos.entityHit.attackEntityFrom(StarWarsMod.saberDamageSource, this.damage);
					pos.entityHit.setFire(8);
					trackSender();
				}
			}
			else
			{
				pos.entityHit.attackEntityFrom(StarWarsMod.blasterDamageSource, this.damage);
				pos.entityHit.setFire(8);
				trackSender();
			}
		}
		else if (pos.typeOfHit == MovingObjectType.BLOCK)
			trackSender();

		if (pos.entityHit == this.getSender() && this.getSender() instanceof EntityPlayer)
		{
			givePlayerSaberBack();
			this.setDead();
		}
	}

	private void givePlayerSaberBack()
	{
		if (getSender() instanceof EntityPlayer)
		{
			getSender().setCurrentItemOrArmor(0, getSaberStack());
		}
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		int max = 8;

		if (getSender() instanceof EntityPlayer)
			max = (int)(8 * (CronUtils.getLevelOf((EntityPlayer)getSender(), "saberThrow") / (float)ForceUtils.powers.get("saberThrow").maxLevel));

		if (this.timeAlive++ >= max || isReturning)
			trackSender();

		if (this.timeAlive > 18)
		{
			givePlayerSaberBack();
			this.setDead();
		}

		if (this.ticksExisted % 2 == 0)
		{
			this.playSound(Resources.MODID + ":" + "item.lightsaber.spin", 1, 1);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound p_70109_1_)
	{
		super.writeToNBT(p_70109_1_);
	}

	@Override
	public void readFromNBT(NBTTagCompound p_70020_1_)
	{
		super.readFromNBT(p_70020_1_);
	}

	public void setSender(EntityLivingBase sender)
	{
		this.dataWatcher.updateObject(SENDER_DW, sender.getEntityId());
		this.dataWatcher.setObjectWatched(SENDER_DW);
	}

	public void setSaberStack(ItemStack stack)
	{
		this.dataWatcher.updateObject(ITEMSTACK_DW, stack);
		this.dataWatcher.setObjectWatched(ITEMSTACK_DW);
	}

	private void trackSender()
	{
		if (this.getSender() != null)
		{
			this.isReturning = true;
			this.renderDistanceWeight = 10.0D;
			double d0 = this.getSender().posX - this.posX;
			double d1 = this.getSender().boundingBox.minY + this.getSender().height / 3.0F - this.posY;
			double d2 = this.getSender().posZ - this.posZ;
			double d3 = MathHelper.sqrt_double(d0 * d0 + d2 * d2);
			if (d3 >= 1.0E-7D)
			{
				float f2 = (float)(Math.atan2(d2, d0) * 180.0D / 3.141592653589793D) - 90.0F;
				float f3 = (float)-(Math.atan2(d1, d3) * 180.0D / 3.141592653589793D);
				double d4 = d0 / d3;
				double d5 = d2 / d3;
				this.setLocationAndAngles(this.posX + d4, this.posY, this.posZ + d5, f2, f3);
				this.yOffset = 0.0F;
				this.setThrowableHeading(d0, d1, d2, 1.0F, 1.0F);
			}
		}
	}

	@Override
	public void setThrowableHeading(double p_70186_1_, double p_70186_3_, double p_70186_5_, float p_70186_7_, float p_70186_8_)
	{
		double f2 = MathHelper.sqrt_double(p_70186_1_ * p_70186_1_ + p_70186_3_ * p_70186_3_ + p_70186_5_ * p_70186_5_);
		p_70186_1_ /= f2;
		p_70186_3_ /= f2;
		p_70186_5_ /= f2;
		this.motionX = p_70186_1_ * this.speed;
		this.motionY = p_70186_3_ * this.speed;
		this.motionZ = p_70186_5_ * this.speed;
		double f3 = MathHelper.sqrt_double(p_70186_1_ * p_70186_1_ + p_70186_5_ * p_70186_5_);
		this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(p_70186_1_, p_70186_5_) * 180.0D / Math.PI);
		this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(p_70186_3_, f3) * 180.0D / Math.PI);
	}
}
