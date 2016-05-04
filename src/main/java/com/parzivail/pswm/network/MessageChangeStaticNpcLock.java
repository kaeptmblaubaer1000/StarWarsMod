package com.parzivail.pswm.network;

import com.parzivail.pswm.tileentities.TileEntityStaticNpc;
import com.parzivail.util.network.PMessage;
import com.parzivail.util.ui.Lumberjack;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class MessageChangeStaticNpcLock extends PMessage<MessageChangeStaticNpcLock>
{
	public Vec3 position;
	public boolean value;
	public World world;

	public MessageChangeStaticNpcLock()
	{
	}

	public MessageChangeStaticNpcLock(TileEntityStaticNpc te, boolean value)
	{
		this.position = Vec3.createVectorHelper(te.xCoord, te.yCoord, te.zCoord);
		this.value = value;
		this.world = te.getWorldObj();
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		TileEntityStaticNpc te = (TileEntityStaticNpc)world.getTileEntity((int)position.xCoord, (int)position.yCoord, (int)position.zCoord);

		te.setLocked(value);

		Lumberjack.log(te.getLocked());

		return null;
	}

}