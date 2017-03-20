package com.parzivail.util.driven;

import com.parzivail.pswm.PSWM;
import com.parzivail.pswm.handler.KeyHandler;
import com.parzivail.pswm.handler.NetworkHandler;
import com.parzivail.pswm.network.MessageCreateBlasterBolt;
import com.parzivail.pswm.network.MessageDrivableControl;
import com.parzivail.pswm.sound.MovingSoundShip;
import com.parzivail.pswm.sound.PSoundEvents;
import com.parzivail.pswm.utils.BlasterBoltType;
import com.parzivail.pswm.utils.BlasterPosition;
import com.parzivail.util.lwjgl.Vector3f;
import com.parzivail.util.math.RotatedAxes;
import com.parzivail.util.ui.GFX;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public abstract class Pilotable extends Entity implements IEntityAdditionalSpawnData
{
	public ShipData data;
	public float throttle;

	public float prevRotationRoll;
	public double serverYaw, serverPitch, serverRoll;
	public RotatedAxes prevAxes;
	public RotatedAxes axes;

	public Vector3f angularVelocity = new Vector3f(0F, 0F, 0F);

	@SideOnly(Side.CLIENT)
	public EntityCamera camera;

	public double serverPosX, serverPosY, serverPosZ;
	public int serverPositionTransitionTicker;

	public Pilotable(World world)
	{
		super(world);
		data = createShipInfo();
		axes = new RotatedAxes();
		prevAxes = new RotatedAxes();
		preventEntitySpawning = true;
		setSize(2F, 2F);
		//yOffset = 6F / 16F;
		ignoreFrustumCheck = true;
		setRenderDistanceWeight(200);
		setupShipData();
	}

	protected void setupShipData()
	{

	}

	private ShipData createShipInfo()
	{
		return new ShipData();
	}

	public Pilotable(World world, double x, double y, double z)
	{
		this(world);
		setPosition(x, y, z);
		prevPosX = x;
		prevPosY = y;
		prevPosZ = z;
	}

	@Override
	public boolean processInitialInteract(EntityPlayer player, EnumHand hand)
	{
		if (this.getPassengers().isEmpty())
		{
			if (world.isRemote)
				playMovingSound(player);
			else
				player.startRiding(this);
			// TODO
			//StatTrack.addStat("ride-" + this.getCommandSenderName().replaceAll("\\W", ""));
			return true;
		}
		return false;
	}

	@SideOnly(Side.CLIENT)
	public void playMovingSound(EntityPlayer player)
	{

	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tag)
	{
		tag.setFloat("RotationYaw", axes.getYaw());
		tag.setFloat("RotationPitch", axes.getPitch());
		tag.setFloat("RotationRoll", axes.getRoll());
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tag)
	{
		prevRotationYaw = tag.getFloat("RotationYaw");
		prevRotationPitch = tag.getFloat("RotationPitch");
		prevRotationRoll = tag.getFloat("RotationRoll");
		axes = new RotatedAxes(prevRotationYaw, prevRotationPitch, prevRotationRoll);
	}

	@Override
	public void writeSpawnData(ByteBuf data)
	{
		data.writeFloat(axes.getYaw());
		data.writeFloat(axes.getPitch());
		data.writeFloat(axes.getRoll());
	}

	@Override
	public void readSpawnData(ByteBuf data)
	{
		try
		{
			axes.setAngles(data.readFloat(), data.readFloat(), data.readFloat());
			prevRotationYaw = axes.getYaw();
			prevRotationPitch = axes.getPitch();
			prevRotationRoll = axes.getRoll();
		}
		catch (Exception e)
		{
			super.setDead();
			e.printStackTrace();
		}

		if (this.camera == null)
		{
			camera = new EntityCamera(world, this);
			world.spawnEntity(camera);
		}
	}

	@SideOnly(Side.CLIENT)
	public EntityLivingBase getCamera()
	{
		return camera;
	}

	@Override
	protected boolean canTriggerWalking()
	{
		return false;
	}

	@Override
	protected void entityInit()
	{
	}

	@Override
	public AxisAlignedBB getCollisionBox(Entity entity)
	{
		return null;
	}

	@Override
	public boolean canBePushed()
	{
		return false;
	}

	@Override
	public double getMountedYOffset()
	{
		return -0.3D;
	}

	@Override
	public void setDead()
	{
		super.setDead();

		if (world.isRemote)
			camera.setDead();
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)
	{
	}

	@Override
	public boolean canBeCollidedWith()
	{
		return !isDead;
	}

	@Override
	public void applyEntityCollision(Entity entity)
	{
		if (!isPartOfThis(entity))
			super.applyEntityCollision(entity);
	}

	public void setPositionRotationAndMotion(double x, double y, double z, float yaw, float pitch, float roll, double motX, double motY, double motZ, float velYaw, float velPitch, float velRoll, float throt, float steeringYaw)
	{
		setRotation(yaw, pitch, roll);

		//setPosition(x, y, z);

		angularVelocity = new Vector3f(velYaw, velPitch, velRoll);
		throttle = throt;
	}

	@Override
	public void setVelocity(double d, double d1, double d2)
	{
		motionX = d;
		motionY = d1;
		motionZ = d2;
	}

	public Vector3f getInWorldPositionOf(Vector3f modelCoordinate)
	{
		Vector3f localPosition = new Vector3f(modelCoordinate.x / 8f, modelCoordinate.y / 8f, modelCoordinate.z / 8f);
		Vector3f relativePosition = axes.findLocalVectorGlobally(localPosition);
		return new Vector3f(posX + relativePosition.x, posY + relativePosition.y, posZ + relativePosition.z);
	}

	public Vector3f getLookVec3f()
	{
		return axes.getXAxis();
	}

	@Override
	public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
	{
		// TODO
		this.setDead();//StarWarsMod.network.sendToServer(new MessageDamageShip(this, p_70097_1_, p_70097_2_));
		return true;
	}

	public void processDamage(String damageType, float amount)
	{
		if (amount > data.shieldHealth)
		{
			data.shipHealth -= amount - data.shieldHealth;
			data.shieldHealth = 0;
		}
		else
			data.shipHealth -= amount;

		// TODO: StarWarsMod.network.sendToDimension(new MessageShipData(this), dimension);
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		this.ticksExisted++;

		prevRotationYaw = axes.getYaw();
		prevRotationPitch = axes.getPitch();
		prevRotationRoll = axes.getRoll();
		prevAxes = axes.clone();

		if (getInternalControllingPassenger() == null && world.isRemote)
		{
			this.throttle = 0;
			NetworkHandler.INSTANCE.sendToServer(new MessageDrivableControl(this));
		}

		//Work out if this is the client side and the entity is driving
		boolean thePlayerIsDrivingThis = getInternalControllingPassenger() instanceof EntityPlayer && PSWM.proxy.isThePlayer((EntityPlayer)getInternalControllingPassenger());

		//Player is not driving this. Update its position from server update packets
		//		if (world.isRemote && !thePlayerIsDrivingThis)
		//		{
		//			//The drivable is currently moving towards its server position. Continue doing so.
		//			if (serverPositionTransitionTicker > 0)
		//			{
		//				double x = posX + (serverPosX - posX) / serverPositionTransitionTicker;
		//				double y = posY + (serverPosY - posY) / serverPositionTransitionTicker;
		//				double z = posZ + (serverPosZ - posZ) / serverPositionTransitionTicker;
		//				double dYaw = MathHelper.wrapDegrees(serverYaw - axes.getYaw());
		//				double dPitch = MathHelper.wrapDegrees(serverPitch - axes.getPitch());
		//				double dRoll = MathHelper.wrapDegrees(serverRoll - axes.getRoll());
		//				rotationYaw = (float)(axes.getYaw() + dYaw / serverPositionTransitionTicker);
		//				rotationPitch = (float)(axes.getPitch() + dPitch / serverPositionTransitionTicker);
		//				float rotationRoll = (float)(axes.getRoll() + dRoll / serverPositionTransitionTicker);
		//				--serverPositionTransitionTicker;
		//				setPosition(x, y, z);
		//				setRotation(rotationYaw, rotationPitch, rotationRoll);
		//			}
		//		}

		this.angularVelocity.scale(data.angularDragCoefficient);
		if (Math.abs(this.angularVelocity.x) < 0.01f)
			this.angularVelocity.x = 0;
		if (Math.abs(this.angularVelocity.z) < 0.01f)
			this.angularVelocity.z = 0;

		//Calculate movement on the client and then send position, rotation etc to the server
		if (thePlayerIsDrivingThis)
			KeyHandler.handleVehicleMovement();

		int ht = this.world.getHeight((int)this.posX, (int)this.posZ) - 1;

		if (this.world.getBlockState(new BlockPos((int)this.posX, ht, (int)this.posZ)).getBlock() == Blocks.WATER && this.world.isRemote && getControllingPassenger() != null)
		{
			for (int i = 0; i < 70; i++)
			{
				double motionX = PSWM.rngGeneral.nextGaussian() * 0.03D;
				//double motionY = 0.03 * this.move;
				double motionY = 0.03;
				motionY *= Math.max(1, 10 - (this.posY - ht));
				double motionZ = PSWM.rngGeneral.nextGaussian() * 0.03D;

				float sXa = MathHelper.cos((float)Math.toRadians(this.axes.getYaw())) * 7;
				float sZa = MathHelper.sin((float)Math.toRadians(this.axes.getYaw())) * 7;

				float sXb = MathHelper.cos((float)Math.toRadians(this.axes.getYaw() + 180)) * 7;
				float sZb = MathHelper.sin((float)Math.toRadians(this.axes.getYaw() + 180)) * 7;

				float width = 1f;

				EnumParticleTypes n = EnumParticleTypes.WATER_WAKE;
				EnumParticleTypes n2 = EnumParticleTypes.EXPLOSION_NORMAL;

				this.world.spawnParticle(n, this.posX + sXa + PSWM.rngGeneral.nextFloat() * width * 2.0F - width, ht + PSWM.rngGeneral.nextFloat() * 0.2f, this.posZ + sZa + PSWM.rngGeneral.nextFloat() * width * 2.0F - width, motionX, motionY, motionZ);
				this.world.spawnParticle(n, this.posX + sXb + PSWM.rngGeneral.nextFloat() * width * 2.0F - width, ht + PSWM.rngGeneral.nextFloat() * 0.2f, this.posZ + sZb + PSWM.rngGeneral.nextFloat() * width * 2.0F - width, motionX, motionY, motionZ);

				if (i % 5 == 0)
				{
					this.world.spawnParticle(n2, this.posX + sXa + PSWM.rngGeneral.nextFloat() * width * 2.0F - width, ht + PSWM.rngGeneral.nextFloat() * 0.2f, this.posZ + sZa + PSWM.rngGeneral.nextFloat() * width * 2.0F - width, motionX, motionY, motionZ);
					this.world.spawnParticle(n2, this.posX + sXb + PSWM.rngGeneral.nextFloat() * width * 2.0F - width, ht + PSWM.rngGeneral.nextFloat() * 0.2f, this.posZ + sZb + PSWM.rngGeneral.nextFloat() * width * 2.0F - width, motionX, motionY, motionZ);
				}

			}
		}

		this.rotateRoll(this.angularVelocity.z);
		this.rotatePitch(this.angularVelocity.x);
		this.rotateYaw(this.angularVelocity.y);

		this.rotationYaw = axes.getYaw() - 90;
		this.rotationPitch = axes.getPitch();

		calculateMotion();
		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);

		if (thePlayerIsDrivingThis)
		{
			serverPosX = posX;
			serverPosY = posY;
			serverPosZ = posZ;
			serverYaw = axes.getYaw();
			NetworkHandler.INSTANCE.sendToServer(new MessageDrivableControl(this));
		}
	}

	@Override
	public void move(MoverType type, double x, double y, double z)
	{
		if (this.noClip)
		{
			this.setEntityBoundingBox(this.getEntityBoundingBox().offset(x, y, z));
			this.resetPositionToBB();
		}
		else
		{
			this.world.theProfiler.startSection("move");
			double d0 = this.posX;
			double d1 = this.posY;
			double d2 = this.posZ;

			double d3 = x;
			double d4 = y;
			double d5 = z;
			boolean flag = this.onGround;

			if ((type == MoverType.SELF || type == MoverType.PLAYER) && flag)
			{
				for (double d6 = 0.05D; x != 0.0D && this.world.getCollisionBoxes(this, this.getEntityBoundingBox().offset(x, (double)(-this.stepHeight), 0.0D)).isEmpty(); d3 = x)
				{
					if (x < 0.05D && x >= -0.05D)
					{
						x = 0.0D;
					}
					else if (x > 0.0D)
					{
						x -= 0.05D;
					}
					else
					{
						x += 0.05D;
					}
				}

				for (; z != 0.0D && this.world.getCollisionBoxes(this, this.getEntityBoundingBox().offset(0.0D, (double)(-this.stepHeight), z)).isEmpty(); d5 = z)
				{
					if (z < 0.05D && z >= -0.05D)
					{
						z = 0.0D;
					}
					else if (z > 0.0D)
					{
						z -= 0.05D;
					}
					else
					{
						z += 0.05D;
					}
				}

				for (; x != 0.0D && z != 0.0D && this.world.getCollisionBoxes(this, this.getEntityBoundingBox().offset(x, (double)(-this.stepHeight), z)).isEmpty(); d5 = z)
				{
					if (x < 0.05D && x >= -0.05D)
					{
						x = 0.0D;
					}
					else if (x > 0.0D)
					{
						x -= 0.05D;
					}
					else
					{
						x += 0.05D;
					}

					d3 = x;

					if (z < 0.05D && z >= -0.05D)
					{
						z = 0.0D;
					}
					else if (z > 0.0D)
					{
						z -= 0.05D;
					}
					else
					{
						z += 0.05D;
					}
				}
			}

			List<AxisAlignedBB> list1 = this.world.getCollisionBoxes(this, this.getEntityBoundingBox().addCoord(x, y, z));
			AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();

			if (y != 0.0D)
			{
				int i = 0;

				for (int j = list1.size(); i < j; ++i)
				{
					y = list1.get(i).calculateYOffset(this.getEntityBoundingBox(), y);
				}

				this.setEntityBoundingBox(this.getEntityBoundingBox().offset(0.0D, y, 0.0D));
			}

			if (x != 0.0D)
			{
				int j4 = 0;

				for (int l4 = list1.size(); j4 < l4; ++j4)
				{
					x = list1.get(j4).calculateXOffset(this.getEntityBoundingBox(), x);
				}

				if (x != 0.0D)
				{
					this.setEntityBoundingBox(this.getEntityBoundingBox().offset(x, 0.0D, 0.0D));
				}
			}

			if (z != 0.0D)
			{
				int k4 = 0;

				for (int i5 = list1.size(); k4 < i5; ++k4)
				{
					z = list1.get(k4).calculateZOffset(this.getEntityBoundingBox(), z);
				}

				if (z != 0.0D)
				{
					this.setEntityBoundingBox(this.getEntityBoundingBox().offset(0.0D, 0.0D, z));
				}
			}

			boolean flag1 = this.onGround || d4 != y && d4 < 0.0D;

			if (this.stepHeight > 0.0F && flag1 && (d3 != x || d5 != z))
			{
				double d11 = x;
				double d7 = y;
				double d8 = z;
				AxisAlignedBB axisalignedbb1 = this.getEntityBoundingBox();
				this.setEntityBoundingBox(axisalignedbb);
				y = (double)this.stepHeight;
				List<AxisAlignedBB> list = this.world.getCollisionBoxes(this, this.getEntityBoundingBox().addCoord(d3, y, d5));
				AxisAlignedBB axisalignedbb2 = this.getEntityBoundingBox();
				AxisAlignedBB axisalignedbb3 = axisalignedbb2.addCoord(d3, 0.0D, d5);
				double d9 = y;
				int l = 0;

				for (int i1 = list.size(); l < i1; ++l)
				{
					d9 = list.get(l).calculateYOffset(axisalignedbb3, d9);
				}

				axisalignedbb2 = axisalignedbb2.offset(0.0D, d9, 0.0D);
				double d15 = d3;
				int j1 = 0;

				for (int k1 = list.size(); j1 < k1; ++j1)
				{
					d15 = list.get(j1).calculateXOffset(axisalignedbb2, d15);
				}

				axisalignedbb2 = axisalignedbb2.offset(d15, 0.0D, 0.0D);
				double d16 = d5;
				int l1 = 0;

				for (int i2 = list.size(); l1 < i2; ++l1)
				{
					d16 = list.get(l1).calculateZOffset(axisalignedbb2, d16);
				}

				axisalignedbb2 = axisalignedbb2.offset(0.0D, 0.0D, d16);
				AxisAlignedBB axisalignedbb4 = this.getEntityBoundingBox();
				double d17 = y;
				int j2 = 0;

				for (int k2 = list.size(); j2 < k2; ++j2)
				{
					d17 = list.get(j2).calculateYOffset(axisalignedbb4, d17);
				}

				axisalignedbb4 = axisalignedbb4.offset(0.0D, d17, 0.0D);
				double d18 = d3;
				int l2 = 0;

				for (int i3 = list.size(); l2 < i3; ++l2)
				{
					d18 = list.get(l2).calculateXOffset(axisalignedbb4, d18);
				}

				axisalignedbb4 = axisalignedbb4.offset(d18, 0.0D, 0.0D);
				double d19 = d5;
				int j3 = 0;

				for (int k3 = list.size(); j3 < k3; ++j3)
				{
					d19 = list.get(j3).calculateZOffset(axisalignedbb4, d19);
				}

				axisalignedbb4 = axisalignedbb4.offset(0.0D, 0.0D, d19);
				double d20 = d15 * d15 + d16 * d16;
				double d10 = d18 * d18 + d19 * d19;

				if (d20 > d10)
				{
					x = d15;
					z = d16;
					y = -d9;
					this.setEntityBoundingBox(axisalignedbb2);
				}
				else
				{
					x = d18;
					z = d19;
					y = -d17;
					this.setEntityBoundingBox(axisalignedbb4);
				}

				int l3 = 0;

				for (int i4 = list.size(); l3 < i4; ++l3)
				{
					y = list.get(l3).calculateYOffset(this.getEntityBoundingBox(), y);
				}

				this.setEntityBoundingBox(this.getEntityBoundingBox().offset(0.0D, y, 0.0D));

				if (d11 * d11 + d8 * d8 >= x * x + z * z)
				{
					x = d11;
					y = d7;
					z = d8;
					this.setEntityBoundingBox(axisalignedbb1);
				}
			}

			this.world.theProfiler.endSection();
			this.world.theProfiler.startSection("rest");
			this.resetPositionToBB();
			this.isCollidedHorizontally = d3 != x || d5 != z;
			this.isCollidedVertically = d4 != y;
			this.onGround = this.isCollidedVertically && d4 < 0.0D;
			this.isCollided = this.isCollidedHorizontally || this.isCollidedVertically;
			int j5 = MathHelper.floor(this.posX);
			int k = MathHelper.floor(this.posY - 0.20000000298023224D);
			int k5 = MathHelper.floor(this.posZ);
			BlockPos blockpos = new BlockPos(j5, k, k5);
			IBlockState iblockstate = this.world.getBlockState(blockpos);

			if (iblockstate.getMaterial() == Material.AIR)
			{
				BlockPos blockpos1 = blockpos.down();
				IBlockState iblockstate1 = this.world.getBlockState(blockpos1);
				Block block1 = iblockstate1.getBlock();

				if (block1 instanceof BlockFence || block1 instanceof BlockWall || block1 instanceof BlockFenceGate)
				{
					iblockstate = iblockstate1;
					blockpos = blockpos1;
				}
			}

			this.updateFallState(y, this.onGround, iblockstate, blockpos);

			if (d3 != x)
			{
				this.motionX = 0.0D;
			}

			if (d5 != z)
			{
				this.motionZ = 0.0D;
			}

			Block block = iblockstate.getBlock();

			if (d4 != y)
			{
				block.onLanded(this.world, this);
			}

			if (this.canTriggerWalking() && !flag && !this.isRiding())
			{
				double d12 = this.posX - d0;
				double d13 = this.posY - d1;
				double d14 = this.posZ - d2;

				if (block != Blocks.LADDER)
				{
					d13 = 0.0D;
				}

				if (block != null && this.onGround)
				{
					block.onEntityWalk(this.world, blockpos, this);
				}

				this.distanceWalkedModified = (float)((double)this.distanceWalkedModified + (double)MathHelper.sqrt(d12 * d12 + d14 * d14) * 0.6D);
				this.distanceWalkedOnStepModified = (float)((double)this.distanceWalkedOnStepModified + (double)MathHelper.sqrt(d12 * d12 + d13 * d13 + d14 * d14) * 0.6D);

			}

			try
			{
				this.doBlockCollisions();
			}
			catch (Throwable throwable)
			{
				CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Checking entity block collision");
				CrashReportCategory crashreportcategory = crashreport.makeCategory("Entity being checked for collision");
				this.addEntityCrashInfo(crashreportcategory);
				throw new ReportedException(crashreport);
			}

			this.world.theProfiler.endSection();
		}
	}

	@Override
	public void fall(float distance, float damageMultiplier)
	{
	}

	/**
	 * Takes a vector (such as the origin of a seat / gun) and translates it from local coordinates to global coordinates
	 */
	public Vector3f rotate(Vector3f inVec)
	{
		return axes.findLocalVectorGlobally(inVec);
	}

	/**
	 * Takes a vector (such as the origin of a seat / gun) and translates it from local coordinates to global coordinates
	 */
	public Vector3f rotateModel(Vector3f inVec)
	{
		Vector3f vec = new Vector3f(inVec);
		vec.scale(1 / 16f);
		float x = vec.x;
		float z = vec.z;
		vec.set(z, vec.y, -x);
		return axes.findLocalVectorGlobally(vec);
	}

	/**
	 * Takes a vector (such as the origin of a seat / gun) and translates it from local coordinates to global coordinates
	 */
	public Vector3f rotateModelInWorld(Vector3f inVec)
	{
		return Vector3f.add(rotateModel(inVec), new Vector3f(this.posX, this.posY, this.posZ), null);
	}

	/**
	 * Takes a vector (such as the origin of a seat / gun) and translates it from local coordinates to global coordinates
	 */
	public Vector3f rotate(Vec3d inVec)
	{
		return rotate(inVec.xCoord, inVec.yCoord, inVec.zCoord);
	}

	/**
	 * Takes a vector (such as the origin of a seat / gun) and translates it from local coordinates to global coordinates
	 */
	public Vector3f rotate(double x, double y, double z)
	{
		return rotate(new Vector3f((float)x, (float)y, (float)z));
	}

	//Rotate the plane locally by some angle about the yaw axis
	public void rotateYaw(float rotateBy)
	{
		if (Math.abs(rotateBy) < 0.01F)
			return;
		axes.rotateLocalYaw(rotateBy);
		updatePrevAngles();
	}

	//Rotate the plane locally by some angle about the pitch axis
	public void rotatePitch(float rotateBy)
	{
		if (Math.abs(rotateBy) < 0.01F)
			return;
		axes.rotateLocalPitch(rotateBy);
		updatePrevAngles();
	}

	//Rotate the plane locally by some angle about the roll axis
	public void rotateRoll(float rotateBy)
	{
		if (Math.abs(rotateBy) < 0.01F)
			return;
		axes.rotateLocalRoll(rotateBy);
		updatePrevAngles();
	}

	public void updatePrevAngles()
	{
		//Correct angles that crossed the +/- 180 line, so that rendering doesnt make them swing 360 degrees in one tick.
		double dYaw = axes.getYaw() - prevRotationYaw;
		if (dYaw > 180)
			prevRotationYaw += 360F;
		if (dYaw < -180)
			prevRotationYaw -= 360F;

		double dPitch = axes.getPitch() - prevRotationPitch;
		if (dPitch > 180)
			prevRotationPitch += 360F;
		if (dPitch < -180)
			prevRotationPitch -= 360F;

		double dRoll = axes.getRoll() - prevRotationRoll;
		if (dRoll > 180)
			prevRotationRoll += 360F;
		if (dRoll < -180)
			prevRotationRoll -= 360F;
	}

	public void setRotation(float rotYaw, float rotPitch, float rotRoll)
	{
		axes.setAngles(rotYaw, rotPitch, rotRoll);
	}

	//Used to stop self collision
	public boolean isPartOfThis(Entity ent)
	{
		return ent == this || this.getPassengers().contains(ent);
	}

	@Override
	public Entity getControllingPassenger()
	{
		return getInternalControllingPassenger();
	}

	public Entity getInternalControllingPassenger()
	{
		if (this.getPassengers().isEmpty())
			return null;
		return this.getPassengers().get(0);
	}

	public boolean isControlling(EntityPlayer thePlayer)
	{
		return getInternalControllingPassenger() != null && thePlayer != null && getInternalControllingPassenger().getEntityId() == thePlayer.getEntityId();
	}

	public void acceptInput(ShipInput input)
	{
		if (!(this.getInternalControllingPassenger() instanceof EntityPlayer))
			return;

		switch (input)
		{
			case RollLeft:
				this.angularVelocity.z += 2;
				break;
			case RollRight:
				this.angularVelocity.z -= 2;
				break;
			case PitchDown:
				this.angularVelocity.x += 1;
				break;
			case PitchUp:
				this.angularVelocity.x -= 1;
				break;
			case BankLeft:
				this.angularVelocity.y -= 1;
				break;
			case BankRight:
				this.angularVelocity.y += 1;
				break;
			case ThrottleUp:
				this.throttle += this.data.maxThrottle * this.data.throttleStep;
				this.throttle = MathHelper.clamp(this.throttle, 0, this.data.maxThrottle);
				break;
			case ThrottleDown:
				this.throttle -= this.data.maxThrottle * this.data.throttleStep;
				this.throttle = MathHelper.clamp(this.throttle, 0, this.data.maxThrottle);
				break;
			case BlasterFire:
				NetworkHandler.INSTANCE.sendToServer(new MessageCreateBlasterBolt((EntityPlayer)this.getInternalControllingPassenger(), BlasterBoltType.XWING, null, BlasterPosition.getNextXwingPosition()));
				PSWM.mc.getSoundHandler().playSound(new MovingSoundShip((EntityPlayer)this.getInternalControllingPassenger(), this, getBlasterSound(), false, false));
				break;
			case SFoil:
				if (this instanceof PilotableSFoils)
					this.getDataManager().set(PilotableSFoils.S_FOILS_OPEN, !this.getDataManager().get(PilotableSFoils.S_FOILS_OPEN));
				break;
			case SpecialWeapon:
				break;
			case ResetPitchRoll:
				this.axes.setAngles(axes.getYaw(), 0, 0);
				break;
		}
	}

	private SoundEvent getBlasterSound()
	{
		return PSoundEvents.BLASTER_KX9;
	}

	public void keyTyped(char eventCharacter, int eventKey, boolean eventKeyState)
	{
		if (this.getControllingPassenger() == null)
			return;

		if (eventKey == PSWM.mc.gameSettings.keyBindSneak.getKeyCode() && getControllingPassenger() != null)
		{
			getControllingPassenger().dismountRidingEntity();
			// TODO: PSWM.network.sendToServer(new MessageSetMount(this.riddenByEntity, null));
			GFX.changeCameraRoll(0);
			PSWM.mc.displayGuiScreen(null);
		}
		else if (eventKey == 1)
		{
			PSWM.mc.displayGuiScreen(null);
			PSWM.mc.displayInGameMenu();
		}
		else if (eventKey == 59)
		{
			PSWM.mc.gameSettings.hideGUI = !PSWM.mc.gameSettings.hideGUI;
		}
		else if (eventKey == 61)
		{
			PSWM.mc.gameSettings.showDebugInfo = !PSWM.mc.gameSettings.showDebugInfo;
		}
		else if (eventKey == 63)
		{
			PSWM.mc.gameSettings.thirdPersonView = (PSWM.mc.gameSettings.thirdPersonView + 1) % 2;
		}
		else if (eventKey == 66)
		{
			PSWM.mc.gameSettings.smoothCamera = !PSWM.mc.gameSettings.smoothCamera;
		}
		else if (eventKey == PSWM.mc.gameSettings.keyBindInventory.getKeyCode())
		{
			PSWM.mc.displayGuiScreen(new GuiInventory(PSWM.mc.player));
		}
		else if (eventKey == PSWM.mc.gameSettings.keyBindChat.getKeyCode())
		{
			PSWM.mc.displayGuiScreen(new GuiChat());
		}
		else if (eventKey == PSWM.mc.gameSettings.keyBindCommand.getKeyCode())
		{
			PSWM.mc.displayGuiScreen(new GuiChat("/"));
		}
	}

	protected void calculateMotion()
	{
		Vector3f forwards = (Vector3f)axes.getXAxis().normalise();

		// TODO: Apply gravity
		//		PlanetInformation info = PlanetInformation.getPlanet(this.worldObj.provider.dimensionId);
		//		float g = info == null ? 0.98f / 20f : info.getGravity();
		float g = 0.98f / 20f;

		motionY -= g * (1 - (throttle / data.maxThrottle));

		//Add the corrected pos
		motionX += throttle * forwards.x;
		motionY += throttle * forwards.y;
		motionZ += throttle * forwards.z;

		// TODO: float drag = info == null ? 0.75f : info.getAtmosphericDrag();
		float drag = 0.75f;

		//Apply drag
		motionX *= drag;
		motionY *= drag;
		motionZ *= drag;
	}

	@Override
	public void updatePassenger(Entity passenger)
	{
		super.updatePassenger(passenger);
	}

	public void applyYawToEntity(Entity entityToUpdate, float lYaw)
	{
		float rYaw = lYaw - 90;
		entityToUpdate.setRenderYawOffset(rYaw);
		float f = MathHelper.wrapDegrees(entityToUpdate.rotationYaw - rYaw);
		float f1 = MathHelper.clamp(f, -105.0F, 105.0F);
		entityToUpdate.prevRotationYaw += f1 - f;
		entityToUpdate.rotationYaw += f1 - f;
		entityToUpdate.setRotationYawHead(entityToUpdate.rotationYaw);
	}

	public void acceptJoystickInput()
	{
		KeyHandler.tickJoystick();

		KeyHandler.joystickValue.scale(2);
		Vector3f d = KeyHandler.joystickValue;
		rotatePitch(d.getY());
		rotateYaw(d.getX());
		rotateRoll(d.getZ());

		if (KeyHandler.joystick.getAxisCount() >= 4)
		{
			this.throttle = (-KeyHandler.joystickThrottle + 1) / 2 * this.data.maxThrottle;
			NetworkHandler.INSTANCE.sendToServer(new MessageDrivableControl(this));
		}
	}

	public float getCameraZ()
	{
		return -1;
	}

	public float getCameraY()
	{
		return 0.5f;
	}
}
