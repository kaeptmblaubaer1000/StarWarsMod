package com.parzivail.pswm.blocks;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.block.BlockMultiTexture;
import com.parzivail.util.world.HarvestLevel;

import net.minecraft.block.material.Material;

public class BlockTempleStone extends BlockMultiTexture
{
	public BlockTempleStone()
	{
		super("templeStone", new String[] { "", "Brick", "BrickFancy", "SlabTop", "SlabTopDark" }, Material.rock);
		setCreativeTab(StarWarsMod.StarWarsTab);
		setHardness(4.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		setStepSound(soundTypeStone);
	}
}