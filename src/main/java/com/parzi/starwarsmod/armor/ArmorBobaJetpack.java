package com.parzi.starwarsmod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;

public class ArmorBobaJetpack extends ItemArmor
{
	private String[] names = { "Helmet", "JetpackChestplate", "Leggings", "Boots" };

	public ArmorBobaJetpack(ItemArmor.ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.setUnlocalizedName("starwarsmod.boba" + this.names[par4]);
		this.setTextureName(StarWarsMod.MODID + ":" + "boba" + this.names[par4]);
		this.setCreativeTab(com.parzi.starwarsmod.StarWarsMod.StarWarsTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == com.parzi.starwarsmod.StarWarsMod.bobaJetpackChest) return StarWarsMod.MODID + ":" + "textures/models/bobaArmorLayer1.png";
		return "";
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack)
	{
		player.capabilities.allowFlying = true;
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity player, int i, boolean b)
	{
		if (player instanceof EntityPlayer)
		{
			EntityPlayer p = (EntityPlayer)player;
			p.capabilities.allowFlying = p.capabilities.isCreativeMode || p.inventory.armorInventory[2] != null && p.inventory.armorInventory[2].getItem() instanceof ArmorBobaJetpack;
			if (!p.capabilities.allowFlying) p.capabilities.isFlying = false;
		}
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\armor\ArmorBobaJetpack.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */