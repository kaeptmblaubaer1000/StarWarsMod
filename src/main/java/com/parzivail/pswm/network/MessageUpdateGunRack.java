package com.parzivail.pswm.network;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.items.weapons.ItemBlasterHeavy;
import com.parzivail.pswm.items.weapons.ItemBlasterRifle;
import com.parzivail.pswm.tileentities.TileEntityGunRack;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MessageUpdateGunRack extends PMessage<MessageUpdateGunRack>
{
	public World world;
	public int x;
	public int y;
	public int z;
	public EntityPlayer player;

	public MessageUpdateGunRack()
	{
	}

	public MessageUpdateGunRack(World world, int x, int y, int z, EntityPlayer player)
	{
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
		this.player = player;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (player == null || world == null)
			return null;

		if (player.getHeldItem() == null)
		{
			TileEntityGunRack gunRack = (TileEntityGunRack)world.getTileEntity(x, y, z);
			ItemStack itemStack = gunRack.popGun();
			StarWarsMod.network.sendToServer(new MessageSetPlayerHolding(player, itemStack));
			gunRack.markDirty();
		}
		else if (player.getHeldItem().getItem() instanceof ItemBlasterRifle || player.getHeldItem().getItem() instanceof ItemBlasterHeavy)
		{
			TileEntityGunRack gunRack = (TileEntityGunRack)world.getTileEntity(x, y, z);
			gunRack.pushGun(player.getHeldItem());
			StarWarsMod.network.sendToServer(new MessageSetPlayerHolding(player, null));
			gunRack.markDirty();
		}
		return null;
	}
}
