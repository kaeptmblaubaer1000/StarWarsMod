package com.parzivail.pswm.entities;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.Resources.ConfigOptions;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.jedi.JediUtils;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityBlasterBoltBase extends EntityThrowable
{
	private EntityLivingBase sender;
	private int timeAlive = 0;
	protected float damage = 5.0f;
	protected float speed = 4.5f;

	public EntityBlasterBoltBase(World par1World, double par2, double par4, double par6, float damage)
	{
		super(par1World, par2, par4, par6);
		this.damage = damage;
	}

	public EntityBlasterBoltBase(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float damage)
	{
		this(par1World, par2EntityLivingBase, damage);
		this.renderDistanceWeight = 10.0D;
		this.posY = par2EntityLivingBase.posY + par2EntityLivingBase.getEyeHeight() - 0.10000000149011612D;
		double d0 = par3EntityLivingBase.posX - par2EntityLivingBase.posX;
		double d1 = par3EntityLivingBase.boundingBox.minY + par3EntityLivingBase.height / 3.0F - this.posY;
		double d2 = par3EntityLivingBase.posZ - par2EntityLivingBase.posZ;
		double d3 = MathHelper.sqrt_double(d0 * d0 + d2 * d2);
		if (d3 >= 1.0E-7D)
		{
			float f2 = (float)(Math.atan2(d2, d0) * 180.0D / 3.141592653589793D) - 90.0F;
			float f3 = (float)-(Math.atan2(d1, d3) * 180.0D / 3.141592653589793D);
			double d4 = d0 / d3;
			double d5 = d2 / d3;
			this.setLocationAndAngles(par2EntityLivingBase.posX + d4, this.posY, par2EntityLivingBase.posZ + d5, f2, f3);
			this.yOffset = 0.0F;
			this.setThrowableHeading(d0, d1, d2, 1.0F, 1.0F);
		}
	}

	public EntityBlasterBoltBase(World par1World, EntityLivingBase sender, float damage)
	{
		super(par1World, sender);
		this.sender = sender;
		this.damage = damage;
		this.setThrowableHeading(sender.getLookVec().xCoord, sender.getLookVec().yCoord, sender.getLookVec().zCoord, 1.0F, 1.0F);
	}

	public EntityBlasterBoltBase(World par1World, float damage)
	{
		super(par1World);
		this.damage = damage;
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
		return this.sender;
	}

	private void hitFX(int blockX, int blockY, int blockZ)
	{
		Block block = this.worldObj.getBlock(blockX, blockY, blockZ);

		for (int i = 0; i < 40; i++)
		{
			double motionX = -this.motionX * 0.08f;
			double motionY = this.rand.nextDouble() * 0.05f;
			double motionZ = -this.motionZ * 0.08f;
			this.worldObj.spawnParticle("smoke", this.posX + (this.rand.nextFloat() - 0.5f) / 3, this.posY + (this.rand.nextFloat() - 0.5f) / 3, this.posZ + (this.rand.nextFloat() - 0.5f) / 3, motionX, motionY, motionZ);
		}

		for (int i = 0; i < 40; i++)
		{
			double motionX = -this.motionX * 0.02f;
			double motionY = this.rand.nextDouble() * 0.02f;
			double motionZ = -this.motionZ * 0.02f;
			this.worldObj.spawnParticle("blockdust_" + Block.getIdFromBlock(block) + "_" + this.worldObj.getBlockMetadata(blockX, blockY, blockZ), this.posX + (this.rand.nextFloat() - 0.5f) / 3, this.posY + (this.rand.nextFloat() - 0.5f) / 3, this.posZ + (this.rand.nextFloat() - 0.5f) / 3, motionX, motionY, motionZ);
		}

		this.playSound(Resources.MODID + ":" + "fx.bolt.hit", 1, 1);
	}

	@Override
	protected void onImpact(MovingObjectPosition pos)
	{
		if (this.sender == null || this.worldObj == null)
		{
			this.setDead();
			return;
		}

		if (pos.typeOfHit == MovingObjectType.ENTITY && pos.entityHit != this.sender && pos.entityHit != this.sender.ridingEntity)
		{
			if (pos.entityHit instanceof EntityPlayer)
			{
				EntityPlayer entityPlayer = (EntityPlayer)pos.entityHit;
				if (entityPlayer.inventory.armorItemInSlot(2) != null && entityPlayer.inventory.armorItemInSlot(2).getItem() == StarWarsItems.jediRobes)
				{
					ItemStack stack = entityPlayer.inventory.armorItemInSlot(2);

					if (JediUtils.getActive(stack).equalsIgnoreCase("deflect") && JediUtils.getUsingDuration(stack))
					{
						Vec3 vec3 = entityPlayer.getLookVec();
						if (vec3 != null)
						{
							this.setThrowableHeading(vec3.xCoord, vec3.yCoord, vec3.zCoord, 1.0F, 1.0F);
						}
					}
					else
					{
						pos.entityHit.attackEntityFrom(StarWarsMod.blasterDamageSource, this.damage);
						pos.entityHit.setFire(8);
						this.setDead();
					}
				}
				else if (entityPlayer.isBlocking() && entityPlayer.inventory.getCurrentItem() != null && (entityPlayer.inventory.getCurrentItem().getItem() == StarWarsItems.lightsaber))
				{
					Vec3 vec3 = entityPlayer.getLookVec();
					if (vec3 != null)
					{
						this.setThrowableHeading(vec3.xCoord, vec3.yCoord, vec3.zCoord, 1.0F, 1.0F);
					}
					entityPlayer.playSound(Resources.MODID + ":" + "item.lightsaber.deflect", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(this.rand, -0.2D, 0.2D));
				}
				else
				{
					pos.entityHit.attackEntityFrom(StarWarsMod.blasterDamageSource, this.damage);
					pos.entityHit.setFire(8);
					this.setDead();
				}
			}
			else
			{
				pos.entityHit.attackEntityFrom(StarWarsMod.blasterDamageSource, this.damage);
				pos.entityHit.setFire(8);
				this.setDead();
			}
		}

		if (this.worldObj.isRemote)
		{
			if (this.worldObj.getBlock(pos.blockX, pos.blockY + 1, pos.blockZ) == Blocks.air && ConfigOptions.enableBlasterFire)
				this.worldObj.setBlock(pos.blockX, pos.blockY + 1, pos.blockZ, Blocks.fire);
			this.setDead();
			this.hitFX(pos.blockX, pos.blockY, pos.blockZ);
		}
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		if (this.timeAlive++ > 100)
			this.setDead();
	}

	public void setSender(EntityLivingBase sender)
	{
		this.sender = sender;
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
