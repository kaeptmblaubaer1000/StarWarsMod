package com.parzi.starwarsmod.items.hyperdrive;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.network.TeleportPlayerNetwork;
import com.parzi.starwarsmod.world.TransferDim;

public class ItemHyperdriveEarth extends Item
{
	private String name = "hyperdriveEarth";

	public ItemHyperdriveEarth()
	{
		setUnlocalizedName(StarWarsMod.MODID + "." + name);
		setTextureName(StarWarsMod.MODID + ":" + name);
		setCreativeTab(StarWarsMod.StarWarsTab);
		this.maxStackSize = 1;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		System.out.println(player.getPortalCooldown());
		if (player.isSneaking() && player.dimension != 0)
		{
			player.timeUntilPortal = 20;
			StarWarsMod.network.sendToServer(new TeleportPlayerNetwork(player.getCommandSenderName(), player.dimension, 0));
		}
		return stack;
	}
}
