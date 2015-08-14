package com.parzi.starwarsmod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.parzi.starwarsmod.StarWarsMod;

public class ArmorHothPilot extends ItemArmor
{
	private String[] names = new String[] { "Helmet", "Chestplate", "Leggings", "Boots" };

	public ArmorHothPilot(ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		setUnlocalizedName(StarWarsMod.MODID + "." + "atatPilot" + names[par4]);
		setTextureName(StarWarsMod.MODID + ":" + "atatPilot" + names[par4]);
		setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == StarWarsMod.atatPilotHelmet || stack.getItem() == StarWarsMod.atatPilotChest || stack.getItem() == StarWarsMod.atatPilotBoots)
		{
			return StarWarsMod.MODID + ":" + "textures/models/atatPilotArmorLayer1.png";
		}
		else if (stack.getItem() == StarWarsMod.atatPilotLegs) { return StarWarsMod.MODID + ":" + "textures/models/atatPilotArmorLayer2.png"; }
		return "";
	}
}