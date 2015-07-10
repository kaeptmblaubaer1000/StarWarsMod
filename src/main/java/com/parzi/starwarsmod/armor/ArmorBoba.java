package com.parzi.starwarsmod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.parzi.starwarsmod.StarWarsMod;

public class ArmorBoba extends ItemArmor
{
	private String[] names = new String[] { "Helmet", "Chestplate", "Leggings", "Boots" };

	public ArmorBoba(ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		setUnlocalizedName(StarWarsMod.MODID + "." + "boba" + names[par4]);
		setTextureName(StarWarsMod.MODID + ":" + "boba" + names[par4]);
		setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == StarWarsMod.bobaHelmet || stack.getItem() == StarWarsMod.bobaChest || stack.getItem() == StarWarsMod.bobaBoots)
		{
			return StarWarsMod.MODID + ":" + "textures/models/bobaArmorLayer1.png";
		}
		else if (stack.getItem() == StarWarsMod.bobaLegs || stack.getItem() == StarWarsMod.bobaJetpackChest) { return StarWarsMod.MODID + ":" + "textures/models/bobaArmorLayer2.png"; }
		return "";
	}
}