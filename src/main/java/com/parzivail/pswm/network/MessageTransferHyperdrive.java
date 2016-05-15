package com.parzivail.pswm.network;

import com.parzivail.pswm.dimension.PlanetInformation;
import com.parzivail.pswm.items.ItemQuestContainer;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class MessageTransferHyperdrive extends PMessage<MessageTransferHyperdrive>
{
	public EntityPlayer player;
	public String planet;

	public MessageTransferHyperdrive()
	{
	}

	public MessageTransferHyperdrive(EntityPlayer player, String planet)
	{
		this.player = player;
		this.planet = planet;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		PlanetInformation information = PlanetInformation.getPlanet(planet);
		ItemStack questlog = ItemQuestContainer.getQuestContainer(player);
		if (player.inventory.consumeInventoryItem(information.getHyperdrive()) && questlog != null)
		{
			ItemQuestContainer.setHasHyperdrive(questlog, information.getInternalName());
		}
		return null;
	}
}
