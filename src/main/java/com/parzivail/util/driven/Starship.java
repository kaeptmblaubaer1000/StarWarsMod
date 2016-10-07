package com.parzivail.util.driven;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.network.MessageDrivableControl;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Starship extends Pilotable
{
	public Starship(World world)
	{
		super(world);
	}

	public Starship(World world, double x, double y, double z)
	{
		super(world);
		setPosition(x, y, z);
		prevPosX = x;
		prevPosY = y;
		prevPosZ = z;
		initType(false);
	}

	public Starship(World world, double x, double y, double z, EntityPlayer placer)
	{
		this(world, x, y, z);
		rotateYaw(placer.rotationYaw + 90F);
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tag)
	{
		super.writeEntityToNBT(tag);
		tag.setTag("Pos", this.newDoubleNBTList(this.posX, this.posY + 1D, this.posZ));
	}

	@Override
	public boolean interactFirst(EntityPlayer entityplayer)
	{
		if (isDead)
			return false;

		//Check each seat in order to see if the player can sit in it
		for (int i = 0; i < numPassengers; i++)
			if (seats[i].interactFirst(entityplayer))
				return true;
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
			}
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

		if (!worldObj.isRemote)
		{
			StarWarsMod.network.sendToAllAround(new MessageDrivableControl(this), new NetworkRegistry.TargetPoint(dimension, posX, posY, posZ, 100));
		}
	}
}
