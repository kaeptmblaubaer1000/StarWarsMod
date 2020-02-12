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

public abstract class EntityBlasterBoltBaseFX extends EntityThrowable
{
	private static final int DATA_DX = 11;
	private static final int DATA_DY = 12;
	private static final int DATA_DZ = 13;
	private static final int DATA_LENGTH = 14;
	private static final int DATA_COLOR = 15;
	protected float damage = 5.0f;
	protected float speed = 4.5f;
	private Entity target;
	private EntityLivingBase sender;

	public EntityBlasterBoltBaseFX(World world)
	{
		this(world, 0, 0, 0, 0, 0xFF0000, 5.0f);
	}

	public EntityBlasterBoltBaseFX(World world, float dx, float dy, float dz, float length, int rgb, float damage)
	{
		super(world);
		this.damage = damage;
		setSize(0.1f, 0.1f);
		setDx(dx);
		setDy(dy);
		setDz(dz);
		setLength(length);
		setColor(rgb);
	}

	@Override
	protected void entityInit()
	{
		dataWatcher.addObject(DATA_DX, 0f); // dx
		dataWatcher.addObject(DATA_DY, 0f); // dy
		dataWatcher.addObject(DATA_DZ, 0f); // dz
		dataWatcher.addObject(DATA_LENGTH, 1f); // length
		dataWatcher.addObject(DATA_COLOR, 0xFF0000); // length
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		motionX = getDx() * 3;
		motionY = getDy() * 3;
		motionZ = getDz() * 3;

		posX += motionX;
		posY += motionY;
		posZ += motionZ;

		if (ticksExisted > 60)
			setDead();
	}

	@Override
	protected void onImpact(MovingObjectPosition pos)
	{
		if (this.sender == null || this.worldObj == null)
		{
			this.setDead();
			return;
		}

		if (pos.typeOfHit == MovingObjectPosition.MovingObjectType.ENTITY && pos.entityHit != this.sender && pos.entityHit != this.sender.ridingEntity)
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

	public abstract void recreate(EntityPlayer hit);

	private void hit(MovingObjectPosition pos)
	{
		pos.entityHit.attackEntityFrom(StarWarsMod.blasterDamageSource, 50.0f);
		double f4 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);

		double k = 1;

		if (f4 > 0.0F)
		{
			pos.entityHit.addVelocity(this.motionX * k * 0.6000000238418579D / f4, 0.1D, this.motionZ * k * 0.6000000238418579D / f4);
		}
		this.setDead();
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound tag)
	{
		setDx(tag.getFloat("dx"));
		setDy(tag.getFloat("dy"));
		setDz(tag.getFloat("dz"));
		setLength(tag.getFloat("length"));
		setColor(tag.getInteger("color"));
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound tag)
	{
		tag.setFloat("dx", getDx());
		tag.setFloat("dy", getDy());
		tag.setFloat("dz", getDz());
		tag.setFloat("length", getLength());
		tag.setInteger("color", getColor());
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

	public float getDx()
	{
		return dataWatcher.getWatchableObjectFloat(DATA_DX);
	}

	public void setDx(float f)
	{
		dataWatcher.updateObject(DATA_DX, f);
	}

	public float getDy()
	{
		return dataWatcher.getWatchableObjectFloat(DATA_DY);
	}

	public void setDy(float f)
	{
		dataWatcher.updateObject(DATA_DY, f);
	}

	public float getDz()
	{
		return dataWatcher.getWatchableObjectFloat(DATA_DZ);
	}

	public void setDz(float f)
	{
		dataWatcher.updateObject(DATA_DZ, f);
	}

	public float getLength()
	{
		return dataWatcher.getWatchableObjectFloat(DATA_LENGTH);
	}

	public void setLength(float f)
	{
		dataWatcher.updateObject(DATA_LENGTH, f);
	}

	public int getColor()
	{
		return dataWatcher.getWatchableObjectInt(DATA_COLOR);
	}

	public void setColor(int f)
	{
		dataWatcher.updateObject(DATA_COLOR, f);
	}
}

