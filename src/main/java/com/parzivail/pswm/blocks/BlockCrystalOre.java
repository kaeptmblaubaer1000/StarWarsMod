package com.parzivail.pswm.blocks;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.block.BlockMultiTexture;
import com.parzivail.util.world.HarvestLevel;
import net.minecraft.block.material.Material;

public class BlockCrystalOre extends BlockMultiTexture
{
	public static String[] colors = { "Black", "Blue", "Cyan", "Gray", "Green", "Pink", "Purple", "White", "Yellow", "Prism" };

	public BlockCrystalOre()
	{
		super("crystal", colors, Material.rock);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		setHardness(4.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		setStepSound(soundTypeMetal);
	}
}