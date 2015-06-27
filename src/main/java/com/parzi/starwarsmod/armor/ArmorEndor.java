package com.parzi.starwarsmod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.parzi.starwarsmod.StarWarsMod;

public class ArmorEndor extends ItemArmor
{
	private String[] names = new String[] { "Helmet", "Chestplate", "Leggings", "Boots" };

	public ArmorEndor(ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		setUnlocalizedName(StarWarsMod.MODID + "." + "endor" + names[par4]);
		setTextureName(StarWarsMod.MODID + ":" + "endor" + names[par4]);
		setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == StarWarsMod.endorHelmet || stack.getItem() == StarWarsMod.endorChest || stack.getItem() == StarWarsMod.endorBoots)
		{
			return StarWarsMod.MODID + ":" + "textures/models/endorArmorLayer1.png";
		}
		else if (stack.getItem() == StarWarsMod.endorLegs) { return StarWarsMod.MODID + ":" + "textures/models/endorArmorLayer2.png"; }
		return "";
	}
}