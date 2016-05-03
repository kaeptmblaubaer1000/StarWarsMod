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
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\blocks\BlockChromiumOre.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */