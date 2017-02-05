package com.parzivail.pswm.registry;

import com.parzivail.pswm.PSWM;
import com.parzivail.pswm.bank.PBlocks;
import com.parzivail.pswm.bank.PItems;
import com.parzivail.util.common.Lumberjack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by colby on 12/21/2016.
 */
public class CreativeTabRegister
{
	public static void register()
	{
		PSWM.tabBlocks = new CreativeTabs(CreativeTabs.getNextID(), "pswmBlocks")
		{
			@SideOnly(Side.CLIENT)
			public ItemStack getTabIconItem()
			{
				return new ItemStack(PBlocks.infraCrate);
			}
		};

		PSWM.tabWeapons = new CreativeTabs(CreativeTabs.getNextID(), "pswmWeapons")
		{
			@SideOnly(Side.CLIENT)
			public ItemStack getTabIconItem()
			{
				return new ItemStack(PItems.blasterA280);
			}
		};

		Lumberjack.log(PSWM.getNextRegisterMessage("TABS"));
	}
}
