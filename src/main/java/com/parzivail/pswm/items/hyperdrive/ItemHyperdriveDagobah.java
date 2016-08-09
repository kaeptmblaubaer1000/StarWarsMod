package com.parzivail.pswm.items.hyperdrive;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.Resources.ConfigOptions;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.network.MessageHyperdrive;
import com.parzivail.util.ui.LangUtils;
import com.parzivail.util.ui.Lumberjack;
import com.parzivail.util.ui.TextUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ItemHyperdriveDagobah extends Item
{
	public String name = "hyperdriveDagobah";

	public ItemHyperdriveDagobah()
	{
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.maxStackSize = 1;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
	{
		list.add(TextUtils.makeItalic(LangUtils.translate("your.ticket.to.the.galaxy")));
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		try
		{
			if (player.isSneaking() && player.dimension != ConfigOptions.dimDagobahId && world.isRemote && player.capabilities.isCreativeMode)
			{
				player.timeUntilPortal = 20;
				StarWarsMod.network.sendToServer(new MessageHyperdrive(player, ConfigOptions.dimDagobahId));
			}
		}
		catch (Exception e)
		{
			Lumberjack.warn("Something went wrong @ hyperdrive.java:34");
			e.printStackTrace();
		}
		return stack;
	}
}
