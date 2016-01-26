package com.parzivail.pswm.network;

import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Vec3;

import com.parzivail.pswm.tileentities.TileEntityHoloTable;
import com.parzivail.pswm.tileentities.TileEntityTatooineTable;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageHoloTableUpdate extends Message<MessageHoloTableUpdate>
{
	public int dim;
	public Vec3 position;
	public Vec3 color;
	public int offset;

	public MessageHoloTableUpdate()
	{
	}

	public MessageHoloTableUpdate(TileEntityHoloTable table)
	{
		this.dim = table.getWorldObj().provider.dimensionId;
		this.position = Vec3.createVectorHelper(table.xCoord, table.yCoord, table.zCoord);
		this.color = table.getRGB();
		this.offset = table.getOffset();
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		TileEntityHoloTable table = (TileEntityHoloTable)MinecraftServer.getServer().worldServerForDimension(this.dim).getTileEntity((int)this.position.xCoord, (int)this.position.yCoord, (int)this.position.zCoord);
		table.setOffset(this.offset);
		table.setRGB((float)this.color.xCoord, (float)this.color.yCoord, (float)this.color.zCoord);
		return null;
	}
}
