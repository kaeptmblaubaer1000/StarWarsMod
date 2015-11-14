package com.parzi.starwarsmod.items.hyperdrive;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.network.TeleportPlayerNetwork;
import com.parzi.starwarsmod.utils.TextUtils;

public class ItemHyperdriveDagobah extends Item
{
	private String name = "hyperdriveDagobah";

	public ItemHyperdriveDagobah()
	{
		this.setUnlocalizedName(StarWarsMod.MODID + "." + this.name);
		this.setTextureName(StarWarsMod.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.maxStackSize = 1;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
	{
		list.add(TextUtils.makeItalic("Your ticket to the galaxy"));
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (player.isSneaking() && player.dimension != StarWarsMod.dimDagobahId)
		{
			player.timeUntilPortal = 20;
			StarWarsMod.network.sendToServer(new TeleportPlayerNetwork(player.getCommandSenderName(), player.dimension, StarWarsMod.dimDagobahId));
		}
		return stack;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\items\hyperdrive\ItemHyperdriveEndor.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */