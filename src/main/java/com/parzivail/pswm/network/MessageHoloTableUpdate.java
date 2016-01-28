package com.parzivail.pswm.network;

import java.awt.Color;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Vec3;

import com.parzivail.pswm.tileentities.TileEntityHoloTableBase;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageHoloTableUpdate extends Message<MessageHoloTableUpdate>
{
	public int dim;
	public Vec3 position;
	public Color color;
	public int offset;

	public MessageHoloTableUpdate()
	{
	}

	public MessageHoloTableUpdate(TileEntityHoloTableBase table)
	{
		this.dim = table.getWorldObj().provider.dimensionId;
		this.position = Vec3.createVectorHelper(table.xCoord, table.yCoord, table.zCoord);
		this.color = table.getRGB();
		this.offset = table.getOffset();
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		TileEntityHoloTableBase table = (TileEntityHoloTableBase)MinecraftServer.getServer().worldServerForDimension(this.dim).getTileEntity((int)this.position.xCoord, (int)this.position.yCoord, (int)this.position.zCoord);
		table.setOffset(this.offset);
		table.setRGB(this.color.getRGB());
		return null;
	}
}
