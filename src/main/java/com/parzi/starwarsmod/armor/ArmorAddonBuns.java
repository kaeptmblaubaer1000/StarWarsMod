package com.parzi.starwarsmod.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.models.armor.ModelLeiaBuns;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorAddonBuns extends ItemArmor
{
	private String name = "leiasBuns";

	public ArmorAddonBuns(ItemArmor.ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.setUnlocalizedName(StarWarsMod.MODID + "." + this.name);
		this.setTextureName(StarWarsMod.MODID + ":" + this.name);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemstack, int armorSlot)
	{
		ModelLeiaBuns model = new ModelLeiaBuns();
		model.BunL.showModel = armorSlot == 0;
		model.BunR.showModel = armorSlot == 0;
		model.BunL.rotateAngleX = model.bipedHead.rotateAngleX;
		model.BunL.rotateAngleY = model.bipedHead.rotateAngleY;
		model.BunR.rotateAngleX = model.bipedHead.rotateAngleX;
		model.BunR.rotateAngleY = model.bipedHead.rotateAngleY;
		model.bipedHead.isHidden = true;
		model.bipedHeadwear.isHidden = true;
		model.bipedBody.isHidden = true;
		model.bipedRightArm.isHidden = true;
		model.bipedLeftArm.isHidden = true;
		model.bipedRightLeg.isHidden = true;
		model.bipedLeftLeg.isHidden = true;
		return model;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return StarWarsMod.MODID + ":" + "textures/models/leiaBunsLayer1.png";
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\armor\ArmorAddonBuns.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */