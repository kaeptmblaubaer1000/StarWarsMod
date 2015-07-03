package com.parzi.starwarsmod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.parzi.starwarsmod.StarWarsMod;

public class ArmorRebelPilot extends ItemArmor
{
	private String[] names = new String[] { "Helmet", "Chestplate", "Leggings", "Boots" };

	public ArmorRebelPilot(ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		setUnlocalizedName(StarWarsMod.MODID + "." + "rebelPilot" + names[par4]);
		setTextureName(StarWarsMod.MODID + ":" + "rebelPilot" + names[par4]);
		setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == StarWarsMod.rebelPilotHelmet || stack.getItem() == StarWarsMod.rebelPilotChest || stack.getItem() == StarWarsMod.rebelPilotBoots)
		{
			return StarWarsMod.MODID + ":" + "textures/models/rebelPilotArmorLayer1.png";
		}
		else if (stack.getItem() == StarWarsMod.rebelPilotLegs) { return StarWarsMod.MODID + ":" + "textures/models/rebelPilotArmorLayer2.png"; }
		return "";
	}
}