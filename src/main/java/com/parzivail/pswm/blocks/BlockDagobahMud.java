package com.parzivail.pswm.blocks;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockDagobahMud extends Block
{
	public String name = "dagobahMud";

	public BlockDagobahMud()
	{
		super(Material.ground);
		setBlockName(Resources.MODID + "." + name);
		setBlockTextureName(Resources.MODID + ":" + name);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		setHardness(4.0F);
		setStepSound(soundTypeSand);
	}
}
