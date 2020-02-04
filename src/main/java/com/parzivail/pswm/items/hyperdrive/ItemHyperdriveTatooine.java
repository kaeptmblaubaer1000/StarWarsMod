package com.parzivail.pswm.items.hyperdrive;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.Resources.ConfigOptions;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.dimension.PlanetInformation;
import com.parzivail.pswm.items.ItemQuestLog;
import com.parzivail.pswm.network.MessageHyperdrive;
import com.parzivail.pswm.network.MessageSetPlayerHolding;
import com.parzivail.pswm.network.MessageSetQuestLogNbt;
import com.parzivail.util.ui.GuiToast;
import com.parzivail.util.ui.LangUtils;
import com.parzivail.util.ui.Lumberjack;
import com.parzivail.util.ui.TextUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ItemHyperdriveTatooine extends Item
{
	public String name = "hyperdriveTatooine";

	public ItemHyperdriveTatooine()
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
			if (player.isSneaking() && player.dimension != ConfigOptions.dimTatooineId && world.isRemote)
			{
				player.timeUntilPortal = 20;
				if (ItemQuestLog.getQuestContainer(player) != null)
				{
					ItemQuestLog.setHasHyperdrive(ItemQuestLog.getQuestContainer(player), PlanetInformation.getPlanet("tatooine").getInternalName()); // FIXME: never trust the client
					StarWarsMod.network.sendToServer(new MessageSetQuestLogNbt(player, ItemQuestLog.getQuestContainer(player).stackTagCompound));
					StarWarsMod.network.sendToServer(new MessageSetPlayerHolding(player, null));
					StarWarsMod.network.sendToServer(new MessageHyperdrive(player, ConfigOptions.dimTatooineId));
				}
				else if (player.capabilities.isCreativeMode)
				{
					StarWarsMod.network.sendToServer(new MessageHyperdrive(player, ConfigOptions.dimTatooineId));
				}
				else
				{
					GuiToast.makeText("No Quest Log!", GuiToast.TIME_SHORT).show();
				}
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
