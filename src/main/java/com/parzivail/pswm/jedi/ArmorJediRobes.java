package com.parzivail.pswm.jedi;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.models.armor.ModelCompressionArmor;
import com.parzivail.pswm.rendering.force.ModelJediCloak;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ArmorJediRobes extends ItemArmor
{

	@SideOnly(Side.CLIENT)
	public static ModelCompressionArmor model;

	String name = "newJediRobes";

	public ArmorJediRobes()
	{
		super(StarWarsMod.jediRobesMat, 1, 1);
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemstack, int armorSlot)
	{
		if (model == null)
		{
			model = new ModelCompressionArmor(0.4f, this);
			model.setModel(new ModelJediCloak());
		}
		return model;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return Resources.MODID + ":" + "textures/force/cloak.png";
	}
}