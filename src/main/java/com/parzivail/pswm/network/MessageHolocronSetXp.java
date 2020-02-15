package com.parzivail.pswm.network;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.force.Cron;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

import java.lang.invoke.MethodHandle;

// TODO: get rid of this completely
public class MessageHolocronSetXp extends PMessage<MessageHolocronSetXp>
{
	public EntityPlayer player;
	public int value;

	public MessageHolocronSetXp()
	{
	}

	public MessageHolocronSetXp(EntityPlayer player, int value)
	{
		this.player = player;
		this.value = value;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (this.player == null || this.player.inventory == null || Cron.getHolocron(this.player) == null)
			return null;
		Cron.getHolocron(this.player).stackTagCompound.setInteger(Resources.nbtXp, this.value);
		return null;
	}


	private static final MethodHandle toBytes = PMessage.builtToBytes.computeIfAbsent(MessageHolocronSetXp.class, PMessage::createToBytes);
	private static final MethodHandle fromBytes = PMessage.builtFromBytes.computeIfAbsent(MessageHolocronSetXp.class, PMessage::createFromBytes);

	@Override
	public void fromBytes(ByteBuf buf)
	{
		try
		{
			try
			{
				fromBytes.invokeExact(this, buf);
			}
			catch (Throwable t)
			{
				hideException(t);
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException("Error at reading packet " + this, e);
		}
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		try
		{
			try
			{
				toBytes.invokeExact(this, buf);
			}
			catch (Throwable t)
			{
				hideException(t);
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException("Error at writing packet " + this, e);
		}
	}
}