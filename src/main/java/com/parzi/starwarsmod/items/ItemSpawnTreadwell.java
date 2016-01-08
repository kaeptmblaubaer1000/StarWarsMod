package com.parzi.starwarsmod.items;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.mobs.MobDroidTreadwell;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSpawnTreadwell extends Item
{
	public String name = "spawnTreadwell";

	public ItemSpawnTreadwell()
	{
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.maxStackSize = 1;
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par1, float par2, float par3, float par4)
	{
		if (player.capabilities.isCreativeMode || player.inventory.consumeInventoryItem(StarWarsMod.spawnTreadwell))
			if (!world.isRemote)
			{
				MobDroidTreadwell newDroid = new MobDroidTreadwell(world);
				newDroid.setPosition(x + 0.5D, y + 1, z + 0.5D);
				world.spawnEntityInWorld(newDroid);
			}
		return true;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\items\ItemSpawnTreadwell.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */