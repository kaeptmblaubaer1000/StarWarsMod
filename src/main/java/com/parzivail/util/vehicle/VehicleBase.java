package com.parzivail.util.vehicle;

import com.parzivail.util.math.MathUtils;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class VehicleBase extends EntityLiving
{
	private float[] tiltTable = { 0, 0, 0, 0, 0, 0 };
	public float tilt = 0.0F;
	public float tiltMax = 10;
	public float vehicYOffset = 0.0F;
	public float moveModifier = 1.0F;
	public float frame = 0.0F;
	public float rotationYawLast = 0.0F;
	public float rotationPitchLast = 0.0F;

	private static final DataParameter<Float> YAW = EntityDataManager.createKey(VehicleBase.class, DataSerializers.FLOAT);
	private static final DataParameter<Float> PITCH = EntityDataManager.createKey(VehicleBase.class, DataSerializers.FLOAT);

	public static final int ROT_PLACE_SNAP = 90;

	public VehicleBase(World p_i1689_1_)
	{
		super(p_i1689_1_);
		this.setSize(1F, 1F);
		this.isImmuneToFire = true;
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataManager.register(YAW, 0.0F);
		this.dataManager.register(PITCH, 0.0F);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound p_70109_1_)
	{
		super.writeToNBT(p_70109_1_);
		p_70109_1_.setTag("Rotation", this.newFloatNBTList(this.getRealYaw(), this.rotationPitch));
		p_70109_1_.setFloat("realYaw", this.getRealYaw());
		p_70109_1_.setFloat("realPitch", this.getRealPitch());
		return p_70109_1_;
	}

	@SideOnly(Side.CLIENT)
	public void setAngles(float p_70082_1_, float p_70082_2_)
	{
	}

	public void onPlacedBy(EntityPlayer player)
	{
		if (player != null && player.isSneaking())
			this.setRealYaw(MathUtils.roundToNearest(player.rotationYaw, ROT_PLACE_SNAP));
	}

	@Override
	public void readFromNBT(NBTTagCompound p_70020_1_)
	{
		super.readFromNBT(p_70020_1_);
		this.setRealYaw(p_70020_1_.getFloat("realYaw"));
		this.setRealPitch(p_70020_1_.getFloat("realPitch"));
	}

	public float getRealYaw()
	{
		return this.dataManager.get(YAW);
	}

	public void setRealYaw(float realYaw)
	{
		this.dataManager.set(YAW, realYaw);
	}

	public float getRealPitch()
	{
		return this.dataManager.get(PITCH);
	}

	public void setRealPitch(float realPitch)
	{
		this.dataManager.set(PITCH, realPitch);
	}

	@Override
	protected boolean canDespawn()
	{
		return false;
	}

	@Override
	public boolean canRenderOnFire()
	{
		return false;
	}

	@Override
	public void fall(float distance, float damageMultiplier)
	{

	}

	@Override
	protected void collideWithEntity(Entity entity)
	{
		// TODO
		//		if (entity != this.riddenByEntity && (this.motionX > 0.01f || this.motionY > 0.01f || this.motionZ > 0.01f))
		//			entity.attackEntityFrom(StarWarsMod.roadkillDamageSource, MathHelper.sqrt_float(Math.max(4, 4 * (float)(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ))));
	}

	@Override
	protected void playStepSound(BlockPos pos, Block blockIn)
	{
		// TODO
		//this.playSound(Resources.MODID + ":" + this.getMovingSound(), 0.15F, 1.0F);
	}

	public String getMovingSound()
	{
		return "vehicle.default.move";
	}

	@Override
	protected boolean processInteract(EntityPlayer player, EnumHand hand)
	{
		if (!this.world.isRemote && this.getPassengers().isEmpty())
		{
			player.startRiding(this);
			// TODO
			//StatTrack.addStat("ride-" + this.getCommandSenderName().replaceAll("\\W", ""));
			return true;
		}
		return false;
	}

	@Override
	public boolean isAIDisabled()
	{
		return true;
	}

	@Override
	protected void updateAITasks()
	{
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		this.moveEntityWithHeading(0.0F, 0.0F);

		this.frame += 0.1F;

		this.setRotation(this.rotationYawLast, this.rotationPitchLast);

		if (this.getPassengers().isEmpty())
		{
			this.renderYawOffset = this.rotationYawLast = this.rotationYaw = getRealYaw();
			this.rotationPitch = this.rotationPitchLast = getRealPitch();
		}
		else
		{
			this.setRealYaw(this.getPassengers().get(0).rotationYaw);
			this.setRealPitch(this.getPassengers().get(0).rotationPitch);
		}

		if (world.isAirBlock(new BlockPos((int)posX, (int)posY - 1, (int)posZ)))
		{
			System.arraycopy(this.tiltTable, 1, this.tiltTable, 0, this.tiltTable.length - 1);

			float t = this.rotationYaw - this.prevRotationYaw;

			if (t > this.tiltMax)
				t = this.tiltMax;
			if (t < -this.tiltMax)
				t = -this.tiltMax;

			this.tiltTable[this.tiltTable.length - 1] = t;

			for (float i : this.tiltTable)
				this.tilt += i;

			this.tilt /= this.tiltTable.length;
		}
	}

	@Override
	public void updatePassenger(Entity passenger)
	{
		float offset = this.vehicYOffset;
		passenger.setPosition(this.posX, this.posY + this.getMountedYOffset() + passenger.getYOffset() + offset, this.posZ);
	}
}