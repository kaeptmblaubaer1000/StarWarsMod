package com.parzivail.pswm.network;

import com.parzivail.pswm.tileentities.TileEntityTarget;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.world.World;

public class MessageUpdateTarget extends PMessage<MessageUpdateTarget>
{
	public World world;
	public int x;
	public int y;
	public int z;
	public boolean isHit;

	public MessageUpdateTarget()
	{
	}

	public MessageUpdateTarget(World world, int x, int y, int z, boolean isHit)
	{
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
		this.isHit = isHit;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (world == null)
			return null;

		TileEntityTarget target = (TileEntityTarget)world.getTileEntity(x, y, z);
		target.isHit = this.isHit;
		target.getWorldObj().markBlockForUpdate(target.xCoord, target.yCoord, target.zCoord);

		return null;
	}
}
