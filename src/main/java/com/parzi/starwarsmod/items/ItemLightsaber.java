package com.parzi.starwarsmod.items;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.MathHelper;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.TextUtils;

public class ItemLightsaber extends ItemSword
{
	public String name = "lightsaber";

	public ItemLightsaber()
	{
		super(StarWarsMod.materialPlasma);
		this.setUnlocalizedName(StarWarsMod.MODID + "." + this.name);
		this.setTextureName(StarWarsMod.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add(TextUtils.makeItalic("This is the formal weapon of a Jedi Knight."));
	}

	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
	{
		entityLiving.playSound(StarWarsMod.MODID + ":" + "item.lightsaber.swing", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(Item.itemRand, -0.2D, 0.2D));
		return super.onEntitySwing(entityLiving, stack);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\items\ItemLightsaber.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */