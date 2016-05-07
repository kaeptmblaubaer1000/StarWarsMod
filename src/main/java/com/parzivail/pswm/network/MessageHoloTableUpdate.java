package com.parzivail.pswm.network;

import com.parzivail.pswm.tileentities.TileEntityHoloTableBase;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Vec3;

import java.awt.*;

public class MessageHoloTableUpdate extends PMessage<MessageHoloTableUpdate>
{
	public int dim;
	public Vec3 position;
	public Color color;
	public int offset;
	public int offsetX;
	public int offsetZ;

	public MessageHoloTableUpdate()
	{
	}

	public MessageHoloTableUpdate(TileEntityHoloTableBase table)
	{
		this.dim = table.getWorldObj().provider.dimensionId;
		this.position = Vec3.createVectorHelper(table.xCoord, table.yCoord, table.zCoord);
		this.color = table.getRGB();
		this.offset = table.getOffsetY();
		this.offsetX = table.getOffsetX();
		this.offsetZ = table.getOffsetZ();
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		TileEntityHoloTableBase table = (TileEntityHoloTableBase)MinecraftServer.getServer().worldServerForDimension(this.dim).getTileEntity((int)this.position.xCoord, (int)this.position.yCoord, (int)this.position.zCoord);
		table.setOffsetY(this.offset);
		table.setOffsetX(this.offsetX);
		table.setOffsetZ(this.offsetZ);
		table.setRGB(this.color.getRGB());
		return null;
	}
}
