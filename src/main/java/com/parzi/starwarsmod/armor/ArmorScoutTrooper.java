package com.parzi.starwarsmod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.parzi.starwarsmod.StarWarsMod;

public class ArmorScoutTrooper extends ItemArmor
{
	private String[] names = new String[] { "Helmet", "Chestplate", "Leggings", "Boots" };

	public ArmorScoutTrooper(ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		setUnlocalizedName(StarWarsMod.MODID + "." + "scoutTrooper" + names[par4]);
		setTextureName(StarWarsMod.MODID + ":" + "scoutTrooper" + names[par4]);
		setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == StarWarsMod.scoutTrooperHelmet || stack.getItem() == StarWarsMod.scoutTrooperChest || stack.getItem() == StarWarsMod.scoutTrooperBoots)
		{
			return StarWarsMod.MODID + ":" + "textures/models/scoutTrooperArmorLayer1.png";
		}
		else if (stack.getItem() == StarWarsMod.scoutTrooperLegs) { return StarWarsMod.MODID + ":" + "textures/models/scoutTrooperArmorLayer2.png"; }
		return "";
	}
}