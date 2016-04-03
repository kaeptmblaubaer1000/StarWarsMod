package com.parzivail.pswm.armor;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.models.armor.ModelCompressionArmor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ArmorRebelFleet extends ItemArmor
{
	private String[] names = { "Helmet", "Chestplate", "Leggings", "Boots" };
	@SideOnly(Side.CLIENT)
	ModelCompressionArmor c = new ModelCompressionArmor(0.4f, this);

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemstack, int armorSlot)
	{
		return c;
	}

	public ArmorRebelFleet(ItemArmor.ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.setUnlocalizedName(Resources.MODID + "." + "rebelTrooper" + this.names[par4]);
		this.setTextureName(Resources.MODID + ":" + "rebelTrooper" + this.names[par4]);
		// this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == StarWarsMod.fleetHelmet || stack.getItem() == StarWarsMod.fleetChest || stack.getItem() == StarWarsMod.fleetBoots)
			return Resources.MODID + ":" + "textures/models/fleetArmorLayer1.png";
		if (stack.getItem() == StarWarsMod.fleetLegs)
			return Resources.MODID + ":" + "textures/models/fleetArmorLayer2.png";
		return "";
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\armor\Armorfleet.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */