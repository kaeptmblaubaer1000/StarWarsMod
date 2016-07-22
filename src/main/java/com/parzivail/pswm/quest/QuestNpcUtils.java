package com.parzivail.pswm.quest;

import com.parzivail.pswm.StarWarsItems;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;

/**
 * Created by Colby on 5/5/2016.
 */
public class QuestNpcUtils
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
	}
}
