package com.parzivail.pswm.blocks;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.block.BlockMultiTexture;
import com.parzivail.util.world.HarvestLevel;

import net.minecraft.block.material.Material;

public class BlockTempleStone extends BlockMultiTexture
{
	public BlockTempleStone(boolean lit)
	{
		super("templeStone", new String[] { (lit ? "Lit" : ""), "Brick" + (lit ? "Lit" : ""), "BrickFancy" + (lit ? "Lit" : ""), "SlabTop" + (lit ? "Lit" : ""), "SlabTopDark" + (lit ? "Lit" : "") }, Material.rock);
		setCreativeTab(StarWarsMod.StarWarsTab);
		if (lit)
			this.setLightLevel(1);
		setHardness(4.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		setStepSound(soundTypeStone);
	}
}