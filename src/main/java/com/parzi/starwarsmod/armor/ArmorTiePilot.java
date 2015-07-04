package com.parzi.starwarsmod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.parzi.starwarsmod.StarWarsMod;

public class ArmorTiePilot extends ItemArmor
{
	private String[] names = new String[] { "Helmet", "Chestplate", "Leggings", "Boots" };

	public ArmorTiePilot(ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		setUnlocalizedName(StarWarsMod.MODID + "." + "tiePilot" + names[par4]);
		setTextureName(StarWarsMod.MODID + ":" + "tiePilot" + names[par4]);
		setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == StarWarsMod.tiePilotHelmet || stack.getItem() == StarWarsMod.tiePilotChest || stack.getItem() == StarWarsMod.tiePilotBoots)
		{
			return StarWarsMod.MODID + ":" + "textures/models/tiePilotArmorLayer1.png";
		}
		else if (stack.getItem() == StarWarsMod.tiePilotLegs) { return StarWarsMod.MODID + ":" + "textures/models/tiePilotArmorLayer2.png"; }
		return "";
	}
}