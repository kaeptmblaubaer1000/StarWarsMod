package com.parzivail.pswm.entities;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.force.Cron;
import com.parzivail.pswm.force.powers.PowerBase;
import com.parzivail.pswm.items.ItemQuestLog;
import com.parzivail.pswm.items.weapons.ItemLightsaber;
import com.parzivail.pswm.network.MessageSpawnClientParticle;
import com.parzivail.pswm.tileentities.TileEntityTarget;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public abstract class EntityBlasterBoltBase extends EntityThrowable
{
	private EntityLivingBase sender;
	private int timeAlive = 0;
	protected float damage = 5.0f;
	protected float speed = 4.5f;
	private Entity target;

	private static final int DATA_DX = 11;
	private static final int DATA_DY = 12;
	private static final int DATA_DZ = 13;
	private static final int DATA_LENGTH = 14;
	private static final int DATA_COLOR = 15;

	public EntityBlasterBoltBase(World par1World, double par2, double par4, double par6, float damage)
	{
		super(par1World, par2, par4, par6);
		this.damage = damage;
	}

	public void setTarget(Entity target)
	{
		this.target = target;
	}

	public Entity getTarget()
	{
		return target;
	}

	private void trackTarget()
	{
		if (this.target != null)
		{
			this.renderDistanceWeight = 10.0D;
			double d0 = this.target.posX - this.posX;
			double d1 = this.target.boundingBox.minY + this.target.height / 3.0F - this.posY;
			double d2 = this.target.posZ - this.posZ;
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

		for (int i = 0; i < 10; i++)
		{
			double motionX = -this.motionX * 0.08f;
			double motionY = this.rand.nextDouble() * 0.05f;
			double motionZ = -this.motionZ * 0.08f;
			StarWarsMod.network.sendToDimension(new MessageSpawnClientParticle("smoke", this.posX + (this.rand.nextFloat() - 0.5f) / 3, this.posY + (this.rand.nextFloat() - 0.5f) / 3, this.posZ + (this.rand.nextFloat() - 0.5f) / 3, motionX, motionY, motionZ), this.worldObj.provider.dimensionId);

			motionX = -this.motionX * 0.02f;
			motionY = this.rand.nextDouble() * 0.02f;
			motionZ = -this.motionZ * 0.02f;
			StarWarsMod.network.sendToDimension(new MessageSpawnClientParticle("blockdust_" + Block.getIdFromBlock(block) + "_" + this.worldObj.getBlockMetadata(blockX, blockY, blockZ), this.posX + (this.rand.nextFloat() - 0.5f) / 3, this.posY + (this.rand.nextFloat() - 0.5f) / 3, this.posZ + (this.rand.nextFloat() - 0.5f) / 3, motionX, motionY, motionZ), this.worldObj.provider.dimensionId);
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

				if (entityPlayer.isBlocking() && entityPlayer.inventory.getCurrentItem() != null && entityPlayer.inventory.getCurrentItem().getItem() instanceof ItemLightsaber && ItemLightsaber.isOn(entityPlayer.inventory.getCurrentItem()))
				{
					recreate(entityPlayer);
					pos.entityHit.worldObj.playSound(pos.entityHit.posX, pos.entityHit.posY, pos.entityHit.posZ, Resources.MODID + ":" + "item.lightsaber.deflect", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(this.rand, -0.2D, 0.2D), true);
				}
				else if (Cron.getHolocron(entityPlayer) != null)
				{
					ItemStack stack = Cron.getHolocron(entityPlayer);
					PowerBase active = Cron.getActive(stack);

					if (active != null && active.name.equalsIgnoreCase("deflect") && active.isRunning)
					{
						deflectFX(this);
						recreate(entityPlayer);
					}
					else
					{
						hit(pos);
					}
				}
				else
				{
					hit(pos);
				}
			}
			else
			{
				hit(pos);
			}
		}
		else if (pos.typeOfHit == MovingObjectType.BLOCK)
		{
			this.hitFX(pos.blockX, pos.blockY, pos.blockZ);
			if (!this.worldObj.isRemote)
			{
				Block b0 = this.worldObj.getBlock(pos.blockX, pos.blockY, pos.blockZ);
				if (b0 == StarWarsMod.blockTarget)
				{
					TileEntityTarget te = (TileEntityTarget)this.worldObj.getTileEntity(pos.blockX, pos.blockY, pos.blockZ);
					te.isHit = true;
					te.hits++;
					te.hitTime = System.currentTimeMillis();
					te.getWorldObj().markBlockForUpdate(te.xCoord, te.yCoord, te.zCoord);
					if (this.sender instanceof EntityPlayer)
					{
						ItemStack questContainer = ItemQuestLog.getQuestContainer((EntityPlayer)this.sender);

						ItemQuestLog.addTargetKill(questContainer);
					}
				}
			}
		}
	}

	public static void deflectFX(Entity entity)
	{
		for (int i = 0; i < 40; i++)
		{
			double motionX = -entity.motionX * 0.08f;
			double motionY = StarWarsMod.rngGeneral.nextDouble() * 0.05f;
			double motionZ = -entity.motionZ * 0.08f;
			StarWarsMod.network.sendToDimension(new MessageSpawnClientParticle("magicCrit", entity.posX + (StarWarsMod.rngGeneral.nextFloat() - 0.5f) / 3, entity.posY + (StarWarsMod.rngGeneral.nextFloat() - 0.5f) / 3, entity.posZ + (StarWarsMod.rngGeneral.nextFloat() - 0.5f) / 3, motionX, motionY, motionZ), entity.worldObj.provider.dimensionId);
		}
	}

	private void hit(MovingObjectPosition pos)
	{
		pos.entityHit.attackEntityFrom(StarWarsMod.blasterDamageSource, this.damage);
		double f4 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);

		double k = 1;

		if (f4 > 0.0F)
		{
			pos.entityHit.addVelocity(this.motionX * k * 0.6000000238418579D / f4, 0.1D, this.motionZ * k * 0.6000000238418579D / f4);
		}
		this.setDead();
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		trackTarget();

		if (this.timeAlive++ > 100)
			this.setDead();
	}

	public void setSender(EntityLivingBase sender)
	{
		this.sender = sender;
	}

	public abstract void recreate(EntityPlayer hit);

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