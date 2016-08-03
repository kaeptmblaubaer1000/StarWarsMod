package com.parzivail.pswm.network;

import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.quest.QuestUtils;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class MessagePlayerBuyItem extends PMessage<MessagePlayerBuyItem>
{
	public EntityPlayer player;
	public ItemStack[] stacks;
	public int cost;

	public MessagePlayerBuyItem()
	{
	}

	public MessagePlayerBuyItem(EntityPlayer player, ItemStack[] stacks, int cost)
	{
		this.player = player;
		this.stacks = stacks;
		this.cost = cost;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		int amountDeducted = 0;

		if (QuestUtils.getPlayerBronzeCredits(player) < cost)
			return null;

		for (int i = 0; i < player.inventory.mainInventory.length; i++)
		{
			ItemStack c = player.inventory.mainInventory[i];
			if (c != null && c.getItem() != null)
			{
				if (c.getItem() == StarWarsItems.imperialCredit)
				{
					amountDeducted += c.stackSize;
					player.inventory.mainInventory[i] = null;
				}
				else if (c.getItem() == StarWarsItems.silverImperialCredit)
				{
					amountDeducted += c.stackSize * 64;
					player.inventory.mainInventory[i] = null;
				}
				else if (c.getItem() == StarWarsItems.goldImperialCredit)
				{
					amountDeducted += c.stackSize * 4096;
					player.inventory.mainInventory[i] = null;
				}

				if (amountDeducted >= cost)
					break;
			}
		}

		if (amountDeducted > cost)
		{
			int ret = amountDeducted - cost;

			int retGold = 0;
			int retSilver = 0;

			while (ret - 4096 > 0)
			{
				ret -= 4096;
				retGold++;
			}
			while (ret - 64 > 0)
			{
				ret -= 64;
				retSilver++;
			}

			if (retGold > 0)
				if (!this.player.inventory.addItemStackToInventory(new ItemStack(StarWarsItems.goldImperialCredit, retGold)))
					this.player.entityDropItem(new ItemStack(StarWarsItems.goldImperialCredit, retGold), 0);
			if (retSilver > 0)
				if (!this.player.inventory.addItemStackToInventory(new ItemStack(StarWarsItems.silverImperialCredit, retSilver)))
					this.player.entityDropItem(new ItemStack(StarWarsItems.silverImperialCredit, retSilver), 0);
			if (ret > 0)
				if (!this.player.inventory.addItemStackToInventory(new ItemStack(StarWarsItems.imperialCredit, ret)))
					this.player.entityDropItem(new ItemStack(StarWarsItems.imperialCredit, ret), 0);
		}

		for (ItemStack s : stacks)
			if (!this.player.inventory.addItemStackToInventory(s))
				this.player.entityDropItem(s, 0);
		return null;
	}

}