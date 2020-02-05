package com.parzivail.pswm.blocks;

import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.items.lightsaber.ItemLightsaberCrystal;
import com.parzivail.util.block.BlockMultiTexture;
import com.parzivail.util.world.HarvestLevel;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class BlockCrystalOre extends BlockMultiTexture
{
	public static String[] colors = { "Black", "Blue", "Cyan", "Gray", "Green", "Pink", "Purple", "White", "Yellow", "Prism" };

	public static int[] crystals = new int[colors.length];

	static {
		for (int i = 0; i < colors.length; i++) {
			for (int j = 0; j < ItemLightsaberCrystal.colors.length; j++) {
				if (colors[i].equalsIgnoreCase(ItemLightsaberCrystal.colors[j])) {
					crystals[i] = j;
				}
			}
		}
	}

	public BlockCrystalOre()
	{
		super("crystal", colors, Material.rock);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		setHardness(4.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		setStepSound(soundTypeMetal);
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	{
		return StarWarsItems.lightsaberCrystal;
	}

	@Override
	public int damageDropped(int meta)
	{
		return crystals[meta];
	}
}
