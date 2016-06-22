package com.parzivail.pswm.blocks;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.block.PBlock;
import net.minecraft.block.material.Material;

public class BlockDagobahMud extends PBlock
{
	public BlockDagobahMud()
	{
		super("dagobahMud", Material.ground);
		setBlockTextureName(Resources.MODID + ":" + name);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		setHardness(4.0F);
		setStepSound(soundTypeSand);
	}
}
