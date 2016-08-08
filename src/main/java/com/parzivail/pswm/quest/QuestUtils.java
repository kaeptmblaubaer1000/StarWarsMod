package com.parzivail.pswm.quest;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.items.ItemQuestLog;
import com.parzivail.pswm.rendering.RenderHuman;
import com.parzivail.pswm.tileentities.TileEntityStaticNpc;
import com.parzivail.util.vehicle.VehicleBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

/**
 * Created by Colby on 5/5/2016.
 */
public class QuestUtils
{
	public static String makeNpcId(String quest, String side, String skin)
	{
		return quest + ":" + side + ":" + skin;
	}

	public static Quest getNpcQuest(String npcId)
	{
		String[] ids = npcId.split(":");
		return QuestBank.getQuestByName(ids.length == 3 ? ids[0] : "");
	}

	public static String getNpcSide(String npcId)
	{
		String[] ids = npcId.split(":");
		return (ids.length == 3) ? ids[1] : "";
	}

	public static String getNpcSkin(String npcId)
	{
		String[] ids = npcId.split(":");
		return (ids.length == 3) ? ids[2] : "";
	}

	public static void arm(EntityLiving entity, String armor)
	{
		switch (armor)
		{
			case "rebelPilot":
				entity.setCurrentItemOrArmor(4, new ItemStack(StarWarsItems.rebelPilotHelmet, 1));
				entity.setCurrentItemOrArmor(3, new ItemStack(StarWarsItems.rebelPilotChest, 1));
				entity.setCurrentItemOrArmor(2, new ItemStack(StarWarsItems.rebelPilotLegs, 1));
				entity.setCurrentItemOrArmor(1, new ItemStack(StarWarsItems.rebelPilotBoots, 1));
				break;
			case "rebelHoth":
				entity.setCurrentItemOrArmor(4, new ItemStack(StarWarsItems.hothHelmet, 1));
				entity.setCurrentItemOrArmor(3, new ItemStack(StarWarsItems.hothChest, 1));
				entity.setCurrentItemOrArmor(2, new ItemStack(StarWarsItems.hothLegs, 1));
				entity.setCurrentItemOrArmor(1, new ItemStack(StarWarsItems.hothBoots, 1));
				break;
			case "rebelEndor":
				entity.setCurrentItemOrArmor(4, new ItemStack(StarWarsItems.endorHelmet, 1));
				entity.setCurrentItemOrArmor(3, new ItemStack(StarWarsItems.endorChest, 1));
				entity.setCurrentItemOrArmor(2, new ItemStack(StarWarsItems.endorLegs, 1));
				entity.setCurrentItemOrArmor(1, new ItemStack(StarWarsItems.endorBoots, 1));
				break;
			case "stormtrooper":
				entity.setCurrentItemOrArmor(4, new ItemStack(StarWarsItems.stormtrooperHelmet, 1));
				entity.setCurrentItemOrArmor(3, new ItemStack(StarWarsItems.stormtrooperChest, 1));
				entity.setCurrentItemOrArmor(2, new ItemStack(StarWarsItems.stormtrooperLegs, 1));
				entity.setCurrentItemOrArmor(1, new ItemStack(StarWarsItems.stormtrooperBoots, 1));
				break;
			case "sandtrooper":
				entity.setCurrentItemOrArmor(4, new ItemStack(StarWarsItems.sandtrooperHelmet, 1));
				entity.setCurrentItemOrArmor(3, new ItemStack(StarWarsItems.sandtrooperChest, 1));
				entity.setCurrentItemOrArmor(2, new ItemStack(StarWarsItems.sandtrooperLegs, 1));
				entity.setCurrentItemOrArmor(1, new ItemStack(StarWarsItems.sandtrooperBoots, 1));
				break;
			case "snowtrooper":
				entity.setCurrentItemOrArmor(4, new ItemStack(StarWarsItems.snowtrooperHelmet, 1));
				entity.setCurrentItemOrArmor(3, new ItemStack(StarWarsItems.snowtrooperChest, 1));
				entity.setCurrentItemOrArmor(2, new ItemStack(StarWarsItems.snowtrooperLegs, 1));
				entity.setCurrentItemOrArmor(1, new ItemStack(StarWarsItems.snowtrooperBoots, 1));
				break;
			case "tiePilot":
				entity.setCurrentItemOrArmor(4, new ItemStack(StarWarsItems.tiePilotHelmet, 1));
				entity.setCurrentItemOrArmor(3, new ItemStack(StarWarsItems.tiePilotChest, 1));
				entity.setCurrentItemOrArmor(2, new ItemStack(StarWarsItems.tiePilotLegs, 1));
				entity.setCurrentItemOrArmor(1, new ItemStack(StarWarsItems.tiePilotBoots, 1));
				break;
			case "atatPilot":
				entity.setCurrentItemOrArmor(4, new ItemStack(StarWarsItems.atatPilotHelmet, 1));
				entity.setCurrentItemOrArmor(3, new ItemStack(StarWarsItems.atatPilotChest, 1));
				entity.setCurrentItemOrArmor(2, new ItemStack(StarWarsItems.atatPilotLegs, 1));
				entity.setCurrentItemOrArmor(1, new ItemStack(StarWarsItems.atatPilotBoots, 1));
				break;
			case "scoutTrooper":
				entity.setCurrentItemOrArmor(4, new ItemStack(StarWarsItems.scoutTrooperHelmet, 1));
				entity.setCurrentItemOrArmor(3, new ItemStack(StarWarsItems.scoutTrooperChest, 1));
				entity.setCurrentItemOrArmor(2, new ItemStack(StarWarsItems.scoutTrooperLegs, 1));
				entity.setCurrentItemOrArmor(1, new ItemStack(StarWarsItems.scoutTrooperBoots, 1));
				break;
			case "aWingPilot":
				entity.setCurrentItemOrArmor(4, new ItemStack(StarWarsItems.rebelAPilotHelmet, 1));
				entity.setCurrentItemOrArmor(3, new ItemStack(StarWarsItems.rebelAPilotChest, 1));
				entity.setCurrentItemOrArmor(2, new ItemStack(StarWarsItems.rebelAPilotLegs, 1));
				entity.setCurrentItemOrArmor(1, new ItemStack(StarWarsItems.rebelAPilotBoots, 1));
			case "yWingPilot":
				entity.setCurrentItemOrArmor(4, new ItemStack(StarWarsItems.rebelYPilotHelmet, 1));
				entity.setCurrentItemOrArmor(3, new ItemStack(StarWarsItems.rebelYPilotChest, 1));
				entity.setCurrentItemOrArmor(2, new ItemStack(StarWarsItems.rebelYPilotLegs, 1));
				entity.setCurrentItemOrArmor(1, new ItemStack(StarWarsItems.rebelYPilotBoots, 1));
				break;
		}
		/*
		GFX.drawTextShadow(mc.fontRenderer, String.valueOf(QuestUtils.countCredits()), 17, 17, 1, GLPalette.SW_YELLOW);
		GFX.renderItem(2, 13, new ItemStack(StarWarsItems.imperialCredit, 0));*/
	}

	public static int getPlayerBronzeCredits(EntityPlayer player)
	{
		return player.capabilities.isCreativeMode ? Integer.MAX_VALUE : countCredits(player);
	}

	public static int countCredits(EntityPlayer player)
	{
		int credits = 0;
		for (ItemStack stack : player.inventory.mainInventory)
			if (stack != null && stack.getItem() != null)
			{
				if (stack.getItem() == StarWarsItems.imperialCredit)
					credits += stack.stackSize;
				if (stack.getItem() == StarWarsItems.silverImperialCredit)
					credits += stack.stackSize * 64;
				if (stack.getItem() == StarWarsItems.goldImperialCredit)
					credits += stack.stackSize * 4096;
			}
		return credits;
	}

	public static void setRightTexture(TileEntityStaticNpc staticNpc, RenderHuman biped)
	{
		if (staticNpc.getAff().equals(Resources.allegianceBartenderFmt))
			biped.overrideTexture = RenderHuman.textureBartender;
		else if (staticNpc.getAff().equals(Resources.allegianceCorellianFmt))
			biped.overrideTexture = RenderHuman.textureCorellian;
		else if (staticNpc.getAff().equals(Resources.allegianceMerchantFmt))
			biped.overrideTexture = RenderHuman.textureMerchant;
		else if (staticNpc.getAff().equals(Resources.allegianceWeaponDealerFmt))
			biped.overrideTexture = RenderHuman.textureWeaponsDealer;
		else if (staticNpc.getAff().equals(Resources.allegianceImperialFmt))
			biped.overrideTexture = RenderHuman.textureSteve;
		else
			biped.overrideTexture = RenderHuman.texture;
	}

	public static boolean hasOnArmor(EntityPlayer player, Class<? extends ItemArmor> armor)
	{
		for (int i = 0; i < 4; i++)
			if (player.getCurrentArmor(i) == null || !(armor.isInstance(player.getCurrentArmor(i).getItem())))
				return false;
		return true;
	}

	public static boolean canRideInShip(EntityPlayer player, Class<? extends VehicleBase> shipClass)
	{
		if (player.capabilities.isCreativeMode)
			return true;

		String ship = shipClass.getSimpleName();

		ArrayList<String> rebels = new ArrayList<>();
		rebels.add("VehicXWing");
		rebels.add("VehicAWing");
		rebels.add("VehicYWing");
		rebels.add("VehicSnowspeeder");
		ArrayList<String> imperials = new ArrayList<>();
		imperials.add("VehicTIE");
		imperials.add("VehicTIEAdvanced");
		imperials.add("VehicTIEBomber");
		imperials.add("VehicTIEInterceptor");

		switch (ship)
		{
			case "VehicXWing":
				if (ItemQuestLog.getStat(player, QuestStats.LICENSE_XWING) > 0)
					return true;
				break;
			case "VehicAWing":
				if (ItemQuestLog.getStat(player, QuestStats.LICENSE_AWING) > 0)
					return true;
				break;
			case "VehicYWing":
				if (ItemQuestLog.getStat(player, QuestStats.LICENSE_YWING) > 0)
					return true;
				break;
			case "VehicSnowspeeder":
				if (ItemQuestLog.getStat(player, QuestStats.LICENSE_T47) > 0)
					return true;
				break;
			case "VehicTIE":
				if (ItemQuestLog.getStat(player, QuestStats.LICENSE_TIE) > 0)
					return true;
				break;
			case "VehicTIEAdvanced":
				if (ItemQuestLog.getStat(player, QuestStats.LICENSE_TIE_ADVANCED) > 0)
					return true;
				break;
			case "VehicTIEBomber":
				if (ItemQuestLog.getStat(player, QuestStats.LICENSE_TIE_BOMBER) > 0)
					return true;
				break;
			case "VehicTIEInterceptor":
				if (ItemQuestLog.getStat(player, QuestStats.LICENSE_TIE_INTERCEPTOR) > 0)
					return true;
				break;
		}

		if (ItemQuestLog.getStat(player, QuestStats.LICENSE_XWING) > 0 && ItemQuestLog.getStat(player, QuestStats.LICENSE_AWING) > 0 && ItemQuestLog.getStat(player, QuestStats.LICENSE_YWING) > 0 && ItemQuestLog.getStat(player, QuestStats.LICENSE_T47) > 0)
			return true;
		else if (ItemQuestLog.getStat(player, QuestStats.LICENSE_TIE) > 0 && ItemQuestLog.getStat(player, QuestStats.LICENSE_TIE_ADVANCED) > 0 && ItemQuestLog.getStat(player, QuestStats.LICENSE_TIE_BOMBER) > 0 && ItemQuestLog.getStat(player, QuestStats.LICENSE_TIE_INTERCEPTOR) > 0)
			return true;

		return false;
	}
}
