package com.parzivail.pswm.network;

import com.parzivail.pswm.entities.EntityThrownSaber;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MessageThrowSaber extends PMessage<MessageThrowSaber>
{
	public EntityPlayer sender;
	public ItemStack saber;

	public MessageThrowSaber()
	{
	}

	public MessageThrowSaber(EntityPlayer sender, ItemStack saber)
	{
		this.sender = sender;
		this.saber = saber;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (this.sender == null || this.sender.worldObj == null)
			return null;

		World world = this.sender.worldObj;

		EntityThrownSaber saber1 = new EntityThrownSaber(world, sender, saber);

		saber1.setSender(sender);
		saber1.setSlot(sender.inventory.currentItem);

		sender.setCurrentItemOrArmor(0, null);
		world.spawnEntityInWorld(saber1);

		return null;
	}

}