package com.parzivail.pswm.network;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.jedi.JediUtils;
import com.parzivail.util.network.PMessage;
import com.parzivail.util.ui.Lumberjack;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;

public class MessageRobesPowerNBT extends PMessage<MessageRobesPowerNBT>
{
	public EntityPlayer player;
	public String key;
	public int value;

	public MessageRobesPowerNBT()
	{
	}

	public MessageRobesPowerNBT(EntityPlayer player, String key, int value)
	{
		this.player = player;
		this.key = key;
		this.value = value;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (this.player == null || this.player.inventory == null)
			return null;
		try
		{
			JediUtils.getHolocron(player).stackTagCompound.getCompoundTag(Resources.nbtPowers).setInteger(this.key, this.value);
		}
		catch (Exception e)
		{
			Lumberjack.warn("Unable to set power NBT!");
			e.printStackTrace();
		}
		return null;
	}

}