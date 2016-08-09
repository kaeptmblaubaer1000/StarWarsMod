package com.parzivail.pswm.armor;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.models.armor.ModelBackpackEndor;
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
	ModelBackpackEndor h2;
	@SideOnly(Side.CLIENT)
	ModelEndorHelmet h;
	@SideOnly(Side.CLIENT)
	ModelCompressionArmor c;

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
		if (itemstack.getItem() == StarWarsItems.endorChest)
		{
			if (h2 == null)
				h2 = new ModelBackpackEndor();
			return h2;
		}
		if (itemstack.getItem() == StarWarsItems.endorHelmet)
		{
			if (h == null)
				h = new ModelEndorHelmet();
			return h;
		}
		if (c == null)
			c = new ModelCompressionArmor(0.4f, this);
		return c;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (slot == 0)
			return Resources.MODID + ":" + "textures/models/endorHelmet.png";
		else if (slot == 2)
			return Resources.MODID + ":" + "textures/models/endorArmorLayer2.png";
		return Resources.MODID + ":" + "textures/models/endorArmorLayer1.png";
	}
}
