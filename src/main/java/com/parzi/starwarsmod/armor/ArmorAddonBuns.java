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
	ModelLeiaBuns model = new ModelLeiaBuns();

	public ArmorAddonBuns(ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		setUnlocalizedName(StarWarsMod.MODID + "." + name);
		setTextureName(StarWarsMod.MODID + ":" + name);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemstack, int armorSlot)
	{

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