package com.parzivail.util.driven;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.network.MessageDrivableControl;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityPlane extends DrivableBase
{
	/**
	 * The flap positions, used for renderering and for controlling the plane rotations
	 */
	public float flapsYaw, flapsPitchLeft, flapsPitchRight;
	/**
	 * Position of looping engine sound
	 */
	public int soundPosition;
	/**
	 * The angle of the propeller for the renderer
	 */
	public float propAngle;
	/**
	 * Weapon delays
	 */
	public int bombDelay, gunDelay;
	/**
	 * Despawn timer
	 */
	public int ticksSinceUsed = 0;
	/**
	 * Mostly aesthetic model variables. Gear actually has a variable hitbox
	 */
	public boolean varGear = true, varDoor = false, varWing = false;
	/**
	 * Delayer for gear, door and wing buttons
	 */
	public int toggleTimer = 0;

	public EntityPlane(World world)
	{
		super(world);
	}

	public EntityPlane(World world, double x, double y, double z)
	{
		super(world);
		setPosition(x, y, z);
		prevPosX = x;
		prevPosY = y;
		prevPosZ = z;
		initType(false);
	}

	public EntityPlane(World world, double x, double y, double z, EntityPlayer placer)
	{
		this(world, x, y, z);
		rotateYaw(placer.rotationYaw + 90F);
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tag)
	{
		super.writeEntityToNBT(tag);
		tag.setTag("Pos", this.newDoubleNBTList(this.posX, this.posY + 1D, this.posZ));
		tag.setBoolean("VarGear", varGear);
		tag.setBoolean("VarDoor", varDoor);
		tag.setBoolean("VarWing", varWing);
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tag)
	{
		super.readEntityFromNBT(tag);
		varGear = tag.getBoolean("VarGear");
		varDoor = tag.getBoolean("VarDoor");
		varWing = tag.getBoolean("VarWing");
	}

	@Override
	public void setPositionRotationAndMotion(double x, double y, double z, float yaw, float pitch, float roll, double motX, double motY, double motZ, float velYaw, float velPitch, float velRoll, float throt, float steeringYaw)
	{
		super.setPositionRotationAndMotion(x, y, z, yaw, pitch, roll, motX, motY, motZ, velYaw, velPitch, velRoll, throt, steeringYaw);
		flapsYaw = steeringYaw;
	}

	@Override
	public boolean interactFirst(EntityPlayer entityplayer)
	{
		if (isDead)
			return false;

		//Check each seat in order to see if the player can sit in it
		for (int i = 0; i < numPassengers; i++)
		{
			if (seats[i].interactFirst(entityplayer))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		//Work out if this is the client side and the player is driving
		boolean thePlayerIsDrivingThis = worldObj.isRemote && seats[0] != null && seats[0].riddenByEntity instanceof EntityPlayer && StarWarsMod.proxy.isThePlayer((EntityPlayer)seats[0].riddenByEntity);

		//Player is not driving this. Update its position from server update packets 
		if (worldObj.isRemote && !thePlayerIsDrivingThis)
		{
			//The drivable is currently moving towards its server position. Continue doing so.
			if (serverPositionTransitionTicker > 0)
			{
				double x = posX + (serverPosX - posX) / serverPositionTransitionTicker;
				double y = posY + (serverPosY - posY) / serverPositionTransitionTicker;
				double z = posZ + (serverPosZ - posZ) / serverPositionTransitionTicker;
				double dYaw = MathHelper.wrapAngleTo180_double(serverYaw - axes.getYaw());
				double dPitch = MathHelper.wrapAngleTo180_double(serverPitch - axes.getPitch());
				double dRoll = MathHelper.wrapAngleTo180_double(serverRoll - axes.getRoll());
				rotationYaw = (float)(axes.getYaw() + dYaw / serverPositionTransitionTicker);
				rotationPitch = (float)(axes.getPitch() + dPitch / serverPositionTransitionTicker);
				float rotationRoll = (float)(axes.getRoll() + dRoll / serverPositionTransitionTicker);
				--serverPositionTransitionTicker;
				setPosition(x, y, z);
				setRotation(rotationYaw, rotationPitch, rotationRoll);
				//return;
			}
			//If the drivable is at its server position and does not have the next update, it should just simulate itself as a server side plane would, so continue
		}


		for (EntitySeat seat : seats)
		{
			if (seat != null)
				seat.updatePosition();
		}

		//Calculate movement on the client and then send position, rotation etc to the server
		if (thePlayerIsDrivingThis)
		{
			StarWarsMod.network.sendToServer(new MessageDrivableControl(this));
			serverPosX = posX;
			serverPosY = posY;
			serverPosZ = posZ;
			serverYaw = axes.getYaw();
		}

		if (!worldObj.isRemote)// && (Math.abs(posX - prevPosX) > updateSpeed || Math.abs(posY - prevPosY) > updateSpeed || Math.abs(posZ - prevPosZ) > updateSpeed))
		{
			StarWarsMod.network.sendToAllAround(new MessageDrivableControl(this), new NetworkRegistry.TargetPoint(dimension, posX, posY, posZ, 100));
		}
	}
}
