package com.parzivail.pswm.items.hyperdrive;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.Resources.ConfigOptions;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.network.MessageHyperdrive;
import com.parzivail.util.ui.Lumberjack;
import com.parzivail.util.ui.TextUtils;

public class ItemHyperdriveYavinFour extends Item
{
	public String name = "hyperdriveYavinFour";

	public ItemHyperdriveYavinFour()
	{
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
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
		try
		{
			if (player.isSneaking() && player.dimension != ConfigOptions.dimYavin4Id && world.isRemote)
			{
				player.timeUntilPortal = 20;
				StarWarsMod.network.sendToServer(new MessageHyperdrive(player, ConfigOptions.dimYavin4Id));
			}
		}
		catch (Exception e)
		{
			Lumberjack.log("Something went wrong @ hyperdrive.java:34");
			e.printStackTrace();
		}
		return stack;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\items\hyperdrive\ItemHyperdriveYavinFour.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */