package com.parzi.starwarsmod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;

public class ArmorBobaJetpack extends ItemArmor
{
	private String[] names = new String[] { "Helmet", "JetpackChestplate", "Leggings", "Boots" };

	public ArmorBobaJetpack(ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		setUnlocalizedName(StarWarsMod.MODID + "." + "boba" + names[par4]);
		setTextureName(StarWarsMod.MODID + ":" + "boba" + names[par4]);
		setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == StarWarsMod.bobaJetpackChest) { return StarWarsMod.MODID + ":" + "textures/models/bobaArmorLayer1.png"; }
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
			if (!p.capabilities.allowFlying)
			{
				p.capabilities.isFlying = false;
			}
		}
	}
}