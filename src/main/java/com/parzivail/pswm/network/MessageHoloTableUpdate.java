package com.parzivail.pswm.network;

import com.parzivail.pswm.tileentities.TileEntityHoloTableBase;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Vec3;

public class MessageHoloTableUpdate extends PMessage<MessageHoloTableUpdate>
{
	public int dim;
	public Vec3 position;
	public int color;
	public int offset;
	public int offsetX;
	public int offsetZ;

	public MessageHoloTableUpdate()
	{
	}

	public MessageHoloTableUpdate(int xCoord, int yCoord, int zCoord, int dim, int color, int oX, int oY, int oZ)
	{
		this.dim = dim;
		this.position = Vec3.createVectorHelper(xCoord, yCoord, zCoord);
		this.color = color;
		this.offset = oY;
		this.offsetX = oX;
		this.offsetZ = oZ;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		TileEntityHoloTableBase table = (TileEntityHoloTableBase)MinecraftServer.getServer().worldServerForDimension(this.dim).getTileEntity((int)this.position.xCoord, (int)this.position.yCoord, (int)this.position.zCoord);
		table.setOffsetY(this.offset);
		table.setOffsetX(this.offsetX);
		table.setOffsetZ(this.offsetZ);
		table.setRGB(this.color);
		table.markDirty();
		return null;
	}
}
