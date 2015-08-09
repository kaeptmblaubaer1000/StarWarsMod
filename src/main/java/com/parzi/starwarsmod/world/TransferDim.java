package com.parzi.starwarsmod.world;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class TransferDim extends Teleporter
{

	// Setup Specific Variables
	private WorldServer worldserver;

	public TransferDim(WorldServer worldserver)
	{
		super(worldserver);

		// Setup Variables
		this.worldserver = worldserver;

	}

	// Override Default BS
	@Override
	public boolean placeInExistingPortal(Entity par1Entity, double par2, double par4, double par6, float par8)
	{
		return false;
	}

	@Override
	public void placeInPortal(Entity par1Entity, double par2, double par4, double par6, float par8)
	{
	}

	@Override
	public void removeStalePortalLocations(long par1)
	{
	}

	// Move the Entity to the portal
	public void teleport(Entity entity)
	{
		if (!(entity instanceof EntityPlayerMP) || entity instanceof EntityClientPlayerMP) { return; }

		// Setup Variables
		EntityPlayerMP playerMP = (EntityPlayerMP)entity;

		// Set default location
		double dx = worldserver.getSpawnPoint().posX;
		double dz = worldserver.getSpawnPoint().posZ;

		// Set height to something big
		double dy = 250;

		// Drop down until find solid
		while (worldserver.getBlock((int)dx, (int)dy - 1, (int)dz).equals(Blocks.air) && dy > 0)
		{
			dy--;
		}

		// Last check if dy == 0
		if (dy == 0)
		{
			dy = 128;
		}

		// Offset locations for accuracy
		dx = dx + 0.5d;
		dy = dy + 1.0d;
		dz = dz + 0.5d;
		entity.setPosition(dx, dy, dz);

		// Freeze motion
		entity.motionX = entity.motionY = entity.motionZ = 0.0D;
		entity.setPosition(dx, dy, dz); // silly to do this multiple times, but
		// it kept offseting entity until this
		// was done

		// Set Dimension
		if (entity.worldObj.provider.dimensionId != worldserver.provider.dimensionId)
		{

			MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension(playerMP, worldserver.provider.dimensionId, this);

		}

		entity.setPosition(dx, dy, dz);

	}

}