package com.parzivail.pswm.network;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.force.Cron;
import com.parzivail.pswm.rendering.force.RenderSithLightning;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

import java.lang.invoke.MethodHandle;

public class MessageHolocronSetClientActive extends PMessage<MessageHolocronSetClientActive>
{
	public EntityPlayer player;
	public String power;

	public MessageHolocronSetClientActive()
	{
	}

	public MessageHolocronSetClientActive(EntityPlayer player, String power)
	{
		this.player = player;
		this.power = power;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (this.player == null)
			return null;

		RenderSithLightning.playerPowers.put(player.getCommandSenderName(), power);

		if (this.player.inventory == null || Cron.getHolocron(player) == null)
			return null;
		Cron.getHolocron(player).stackTagCompound.setString(Resources.nbtWield, power);
		return null;
	}

	private static final MethodHandle toBytes = PMessage.builtToBytes.computeIfAbsent(MessageHolocronSetClientActive.class, PMessage::createToBytes);
	private static final MethodHandle fromBytes = PMessage.builtFromBytes.computeIfAbsent(MessageHolocronSetClientActive.class, PMessage::createFromBytes);

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