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

public class ArmorAtstPilot extends ItemArmor
{
	private static String[] names = { "Helmet", "Chestplate", "Leggings", "Boots" };
	@SideOnly(Side.CLIENT)
	ModelCompressionArmor c;

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemstack, int armorSlot)
	{
		if (c == null)
			c = new ModelCompressionArmor(0.4f, this);
		return c;
	}

	public ArmorAtstPilot(ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.setUnlocalizedName(Resources.MODID + "." + "atstPilot" + names[par4]);
		this.setTextureName(Resources.MODID + ":" + "atstPilot" + names[par4]);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (slot == 1)
			return Resources.MODID + ":" + "textures/models/atstPilotArmorLayer2.png";
		return Resources.MODID + ":" + "textures/models/atstPilotArmorLayer1.png";
	}
}
