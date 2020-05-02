package com.parzivail.pswm.network;

import com.parzivail.pswm.force.ForceUser;
import com.parzivail.pswm.force.exceptions.NotAForceUserException;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class MessageHolocronRefreshClientPowers extends PMessage<MessageHolocronRefreshClientPowers>
{
	public EntityPlayer player;
	public NBTTagCompound compound;

	public MessageHolocronRefreshClientPowers()
	{
	}

	public MessageHolocronRefreshClientPowers(final EntityPlayer player, final NBTTagCompound compound)
	{
		this.player = player;
		this.compound = compound;
	}

	public MessageHolocronRefreshClientPowers(final ForceUser forceUser)
	{
		this.player = forceUser.getPlayer();
		this.compound = forceUser.getPowersNBT();
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (this.player == null)
			return null;

		try
		{
			new ForceUser(player).setPowersNBT(compound);
		}
		catch (NotAForceUserException ignored)
		{
		}
		return null;
	}
}