package com.parzivail.pswm.world;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class TransferDim extends Teleporter
{
	private WorldServer worldserver;

	public TransferDim(WorldServer worldserver)
	{
		super(worldserver);
		this.worldserver = worldserver;
	}

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

	public void teleport(Entity entity)
	{
		if (entity == null || !(entity instanceof EntityPlayerMP))
			return;
		EntityPlayerMP playerMP = (EntityPlayerMP)entity;
		double dx = this.worldserver.getSpawnPoint().posX;
		double dz = this.worldserver.getSpawnPoint().posZ;
		double dy = 250.0D;
		while (this.worldserver.getBlock((int)dx, (int)dy - 1, (int)dz).equals(net.minecraft.init.Blocks.air) && dy > 0.0D)
			dy -= 1.0D;
		if (dy == 0.0D)
			dy = 128.0D;
		dx += 0.5D;
		dy += 1.0D;
		dz += 0.5D;
		entity.setPosition(dx, dy, dz);
		entity.motionX = entity.motionY = entity.motionZ = 0.0D;
		entity.setPosition(dx, dy, dz);
		if (entity.worldObj.provider.dimensionId != this.worldserver.provider.dimensionId)
			MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension(playerMP, this.worldserver.provider.dimensionId, this);
		entity.setPosition(dx, dy, dz);
	}
}
