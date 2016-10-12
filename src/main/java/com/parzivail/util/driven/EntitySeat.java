package com.parzivail.util.driven;

import com.parzivail.util.lwjgl.Vector3f;
import com.parzivail.util.math.RotatedAxes;
import com.parzivail.util.ui.Lumberjack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

/**
 * Created by colby on 10/11/2016.
 */
public class EntitySeat extends Entity
{
	public Pilotable parent;
	private Seat seatInfo;

	public RotatedAxes looking;
	public RotatedAxes prevLooking;

	@SideOnly(Side.CLIENT)
	public float playerRoll, prevPlayerRoll;

	private float playerYaw, playerPitch;
	private float prevPlayerYaw, prevPlayerPitch;

	public double playerPosX, playerPosY, playerPosZ;
	private double prevPlayerPosX, prevPlayerPosY, prevPlayerPosZ;

	public EntitySeat(World world)
	{
		super(world);
		setSize(1F, 1F);
		prevLooking = new RotatedAxes();
		looking = new RotatedAxes();
	}

	public EntitySeat(World world, Pilotable parent, int seatId)
	{
		this(world);
		this.parent = parent;
		this.seatInfo = parent.getSeatData(seatId);
		playerPosX = prevPlayerPosX = posX;
		playerPosY = prevPlayerPosY = posY;
		playerPosZ = prevPlayerPosZ = posZ;
		looking.setAngles((seatInfo.minYaw + seatInfo.maxYaw) / 2, 0F, 0F);
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		this.parent.angularVelocity.scale(Pilotable.ANGULAR_DRAG_COEFFICIENT);
		if (Math.abs(this.parent.angularVelocity.x) < 0.01f)
			this.parent.angularVelocity.x = 0;
		if (Math.abs(this.parent.angularVelocity.z) < 0.01f)
			this.parent.angularVelocity.z = 0;

		this.parent.rotateRoll(this.parent.angularVelocity.z);
		this.parent.rotatePitch(this.parent.angularVelocity.x);

		Lumberjack.debug(String.format("%s\t%s\t%s\t%s", posX, posY, posZ, isDead));
	}

	/**
	 * Set the position to be that of the drivable plus the local position, rotated
	 */
	public void updatePosition()
	{
		prevPlayerPosX = playerPosX;
		prevPlayerPosY = playerPosY;
		prevPlayerPosZ = playerPosZ;

		prevPlayerYaw = playerYaw;
		prevPlayerPitch = playerPitch;

		//Get the position of this seat on the drivable axes
		Vector3f localPosition = new Vector3f(seatInfo.x / 16F, seatInfo.y / 16F, seatInfo.z / 16F);

		if (parent != null)
		{
			//Rotate the offset vector by the turret yaw
			if (parent.seats != null && parent.seats[0] != null && parent.seats[0].looking != null)
			{
				RotatedAxes yawOnlyLooking = new RotatedAxes(parent.seats[0].looking.getYaw(), 0F, 0F);
				Vector3f rotatedOffset = yawOnlyLooking.findLocalVectorGlobally(seatInfo.rotatedOffset);
				Vector3f.add(localPosition, new Vector3f(rotatedOffset.x, 0F, rotatedOffset.z), localPosition);
			}

			Vector3f relativePosition = parent.axes.findLocalVectorGlobally(localPosition);
			setPosition(parent.posX + relativePosition.x, parent.posY + relativePosition.y, parent.posZ + relativePosition.z);
		}

		if (riddenByEntity != null)
		{
			Vec3 yOffset = parent.rotate(0, riddenByEntity.getYOffset(), 0).toVec3();

			playerPosX = posX + yOffset.xCoord;
			playerPosY = posY + yOffset.yCoord;
			playerPosZ = posZ + yOffset.zCoord;

			riddenByEntity.lastTickPosX = riddenByEntity.prevPosX = prevPlayerPosX;
			riddenByEntity.lastTickPosY = riddenByEntity.prevPosY = prevPlayerPosY;
			riddenByEntity.lastTickPosZ = riddenByEntity.prevPosZ = prevPlayerPosZ;
			riddenByEntity.setPosition(playerPosX, playerPosY, playerPosZ);

			//Calculate the local look axes globally
			RotatedAxes globalLookAxes = parent.axes.findLocalAxesGlobally(looking);
			//Set the entity's rotation based on this
			playerYaw = -90F + globalLookAxes.getYaw();
			playerPitch = globalLookAxes.getRoll();

			if (riddenByEntity instanceof EntityPlayer)
			{
				riddenByEntity.prevRotationYaw = prevPlayerYaw;
				riddenByEntity.prevRotationPitch = prevPlayerPitch;

				riddenByEntity.rotationYaw = playerYaw;
				riddenByEntity.rotationPitch = playerPitch;
			}

			//If the entity is a entity, roll its view accordingly
			if (worldObj.isRemote)
			{
				prevPlayerRoll = playerRoll;
				playerRoll = -globalLookAxes.getRoll();
			}
		}
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float f)
	{
		return parent.attackEntityFrom(source, f);
	}

	@Override
	public boolean interactFirst(EntityPlayer entityplayer) //interact : change back when Forge updates
	{
		if (isDead)
			return false;

		//Put them in the seat
		if (riddenByEntity == null)
		{
			entityplayer.mountEntity(this);
			return true;
		}
		return false;
	}

	@Override
	public void updateRiderPosition()
	{
		if (riddenByEntity instanceof EntityPlayer)
		{
			riddenByEntity.rotationYaw = playerYaw;
			riddenByEntity.rotationPitch = playerPitch;
			riddenByEntity.prevRotationYaw = prevPlayerYaw;
			riddenByEntity.prevRotationPitch = prevPlayerPitch;
		}
		riddenByEntity.posX = playerPosX;
		riddenByEntity.posY = playerPosY;
		riddenByEntity.posZ = playerPosZ;
	}

	@Override
	protected void entityInit()
	{
		// Do nothing.
	}

	public void acceptInput(ShipInput input)
	{
		if (!checkParentNullity() || !isDriver())
			return;
		switch (input)
		{
			case RollLeft:
				this.parent.angularVelocity.z += 4;
				break;
			case RollRight:
				this.parent.angularVelocity.z -= 4;
				break;
			case PitchUp:
				this.parent.angularVelocity.x += 2;
				break;
			case PitchDown:
				this.parent.angularVelocity.x -= 2;
				break;
			case YawLeft:
				break;
			case YawRight:
				break;
			case ThrottleUp:
				this.parent.throttle += this.parent.maxThrottle / 10f;
				this.parent.throttle = MathHelper.clamp_float(this.parent.throttle, 0, this.parent.maxThrottle);
				break;
			case ThrottleDown:
				this.parent.throttle -= this.parent.maxThrottle / 10f;
				this.parent.throttle = MathHelper.clamp_float(this.parent.throttle, 0, this.parent.maxThrottle);
				break;
			case BlasterFire:
				break;
			case SpecialAesthetic:
				break;
			case SpecialWeapon:
				break;
		}
	}

	private boolean checkParentNullity()
	{
		if (this.parent == null)
		{
			Lumberjack.err("Cannot locate parent!");
			return false;
		}
		return true;
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbt)
	{
		int parentId = nbt.getInteger("parentID");
		int seatId = nbt.getInteger("seatID");

		if (parentId != 0)
		{
			Entity e = this.worldObj.getEntityByID(parentId);
			if (e instanceof Pilotable)
				parent = (Pilotable)e;
		}

		if (parent != null)
			seatInfo = parent.getSeatData(seatId);
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbt)
	{
		nbt.setInteger("parentID", (parent != null) ? parent.getEntityId() : 0);
		nbt.setInteger("seatID", (seatInfo != null) ? parent.getEntityId() : 0);
	}

	public boolean isDriver()
	{
		return seatInfo.id == 0;
	}

	public Entity getControllingEntity()
	{
		return riddenByEntity;
	}

	public float getPlayerRoll()
	{
		playerRoll = MathHelper.wrapAngleTo180_float(playerRoll);
		return playerRoll;
	}
}
