package com.parzi.starwarsmod.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.models.armor.ModelEndorHelmet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorEndor extends ItemArmor
{
	private String[] names = { "Helmet", "Chestplate", "Leggings", "Boots" };

	public ArmorEndor(ItemArmor.ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.setUnlocalizedName(StarWarsMod.MODID + "." + "endor" + this.names[par4]);
		this.setTextureName(StarWarsMod.MODID + ":" + "endor" + this.names[par4]);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemstack, int armorSlot)
	{
		if (armorSlot == 0)
			return new ModelEndorHelmet();
		return null;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == StarWarsMod.endorHelmet)
			return StarWarsMod.MODID + ":" + "textures/models/endorHelmet.png";
		if (stack.getItem() == StarWarsMod.endorChest || stack.getItem() == StarWarsMod.endorBoots)
			return StarWarsMod.MODID + ":" + "textures/models/endorArmorLayer1.png";
		if (stack.getItem() == StarWarsMod.endorLegs)
			return StarWarsMod.MODID + ":" + "textures/models/endorArmorLayer2.png";
		return "";
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\armor\ArmorEndor.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */