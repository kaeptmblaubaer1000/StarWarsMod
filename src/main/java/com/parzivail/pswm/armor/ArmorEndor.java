package com.parzivail.pswm.armor;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.models.armor.ModelCompressionArmor;
import com.parzivail.pswm.models.armor.ModelEndorHelmet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ArmorEndor extends ItemArmor
{
	private String[] names = { "Helmet", "Chestplate", "Leggings", "Boots" };
	@SideOnly(Side.CLIENT)
	ModelEndorHelmet h = new ModelEndorHelmet();
	@SideOnly(Side.CLIENT)
	ModelCompressionArmor c = new ModelCompressionArmor(0.4f, this);

	public ArmorEndor(ItemArmor.ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.setUnlocalizedName(Resources.MODID + "." + "endor" + this.names[par4]);
		this.setTextureName(Resources.MODID + ":" + "endor" + this.names[par4]);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemstack, int armorSlot)
	{
		if (armorSlot == 0)
			return h;
		return c;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == StarWarsMod.endorHelmet)
			return Resources.MODID + ":" + "textures/models/endorHelmet.png";
		if (stack.getItem() == StarWarsMod.endorChest || stack.getItem() == StarWarsMod.endorBoots)
			return Resources.MODID + ":" + "textures/models/endorArmorLayer1.png";
		if (stack.getItem() == StarWarsMod.endorLegs)
			return Resources.MODID + ":" + "textures/models/endorArmorLayer2.png";
		return "";
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\armor\ArmorEndor.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */