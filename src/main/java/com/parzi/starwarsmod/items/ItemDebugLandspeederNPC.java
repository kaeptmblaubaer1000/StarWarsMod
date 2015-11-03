package com.parzi.starwarsmod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.mobs.MobTatooineCommoner;
import com.parzi.starwarsmod.vehicles.VehicLandspeeder;

public class ItemDebugLandspeederNPC extends Item
{
	private String name = "debugLandspeederNPC";

	public ItemDebugLandspeederNPC()
	{
		this.setUnlocalizedName(StarWarsMod.MODID + "." + this.name);
		this.setTextureName(StarWarsMod.MODID + ":" + this.name);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par1, float par2, float par3, float par4)
	{
		VehicLandspeeder landspeeder = new VehicLandspeeder(world, true);
		landspeeder.setPosition(x, y + 1, z);
		MobTatooineCommoner commoner = new MobTatooineCommoner(world);
		commoner.setPosition(x, y + 1, z);
		commoner.ridingEntity = landspeeder;
		landspeeder.riddenByEntity = commoner;
		world.spawnEntityInWorld(landspeeder);
		world.spawnEntityInWorld(commoner);
		System.out.println("Added Landspeeder: " + x + ", " + y + ", " + z);
		return true;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\items\ItemDebugLandspeederNPC.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */