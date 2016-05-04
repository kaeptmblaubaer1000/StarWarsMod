package com.parzivail.pswm.tileentities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

import java.util.List;

public class TileEntityBactaTank extends TileEntity
{
	AxisAlignedBB bb;
	int tickStart = 0;
	EntityPlayerMP playerInside = null;

	@Override
	@SideOnly(Side.CLIENT)
	public double getMaxRenderDistanceSquared()
	{
		return 262144;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox()
	{
		if (this.bb == null)
			this.bb = AxisAlignedBB.getBoundingBox(this.xCoord + 0.4f, this.yCoord, this.zCoord + 0.4f, this.xCoord + 0.6f, this.yCoord + 3.8f, this.zCoord + 0.6f);
		return this.bb;
	}

	@Override
	public void updateEntity()
	{
		List<Entity> entities = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.getRenderBoundingBox());
		for (Entity e : entities)
			if (e instanceof EntityPlayerMP)
			{
				EntityPlayerMP player = (EntityPlayerMP)e;
				if (this.playerInside == null)
				{
					this.playerInside = player;
					this.tickStart = this.playerInside.ticksExisted;
					break;
				}
			}

		if (this.playerInside != null)
		{
			this.playerInside.playerNetServerHandler.setPlayerLocation(this.xCoord + 0.5f, this.yCoord + 1f, this.zCoord + 0.5f, this.playerInside.ticksExisted / 5f % 360, 30);
			if ((this.playerInside.ticksExisted - this.tickStart) / 5f >= 360)
			{
				this.playerInside.playerNetServerHandler.setPlayerLocation(this.xCoord, this.yCoord, this.zCoord, this.playerInside.ticksExisted / 5f % 360, 30);
				this.tickStart = 0;
				this.playerInside = null;
			}
		}
		super.updateEntity();
	}

	public EntityPlayer getPlayerInside()
	{
		return this.playerInside;
	}

	public int getTicksInside()
	{
		if (this.playerInside != null)
			return (this.playerInside.ticksExisted - this.tickStart);
		return 0;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\tileentities\TileEntityTable.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */