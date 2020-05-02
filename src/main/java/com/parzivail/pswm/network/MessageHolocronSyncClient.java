package com.parzivail.pswm.network;

import com.parzivail.pswm.force.Cron;
import com.parzivail.util.common.NotNull;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import com.parzivail.util.nbt.NBTUtil;

import java.lang.invoke.MethodHandle;
import java.util.Optional;

public class MessageHolocronSyncClient extends PMessage<MessageHolocronSyncClient>
{
	public EntityPlayer player;
	public NBTTagCompound compoundTag;

	public MessageHolocronSyncClient(@NotNull EntityPlayer player, @NotNull ItemStack itemStack)
	{
		this.player = player;
		this.compoundTag = itemStack.stackTagCompound;
	}

	public MessageHolocronSyncClient(@NotNull EntityPlayer player)
	{
		this.player = player;
		this.compoundTag = Cron.getHolocron(player).stackTagCompound;
	}

	public MessageHolocronSyncClient()
	{
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		NBTUtil.updateNBT(Cron.getHolocron(player).stackTagCompound, compoundTag);
		return null;
	}

	private static final MethodHandle toBytes = PMessage.builtToBytes.computeIfAbsent(MessageHolocronSyncClient.class, PMessage::createToBytes);
	private static final MethodHandle fromBytes = PMessage.builtFromBytes.computeIfAbsent(MessageHolocronSyncClient.class, PMessage::createFromBytes);

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
