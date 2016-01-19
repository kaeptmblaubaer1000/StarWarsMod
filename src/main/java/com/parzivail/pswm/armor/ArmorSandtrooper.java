package com.parzivail.pswm.armor;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ArmorSandtrooper extends ItemArmor
{
	private String[] names = { "Helmet", "Chestplate", "Leggings", "Boots" };

	public ArmorSandtrooper(ItemArmor.ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.setUnlocalizedName(Resources.MODID + "." + "sandtrooper" + this.names[par4]);
		this.setTextureName(Resources.MODID + ":" + "sandtrooper" + this.names[par4]);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == StarWarsMod.sandtrooperHelmet || stack.getItem() == StarWarsMod.sandtrooperChest || stack.getItem() == StarWarsMod.sandtrooperBoots)
			return Resources.MODID + ":" + "textures/models/sandtrooperArmorLayer1.png";
		if (stack.getItem() == StarWarsMod.sandtrooperLegs)
			return Resources.MODID + ":" + "textures/models/sandtrooperArmorLayer2.png";
		return "";
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\armor\ArmorSandtrooper.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */