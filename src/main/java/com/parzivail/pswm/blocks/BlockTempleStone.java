package com.parzivail.pswm.blocks;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.block.BlockMultiTexture;
import com.parzivail.util.world.HarvestLevel;

import net.minecraft.block.material.Material;

public class BlockTempleStone extends BlockMultiTexture
{
	public BlockTempleStone(boolean lit)
	{
		super("templeStone" + (lit ? "Lit" : ""), new String[] { "", "Brick", "BrickFancy", "SlabTop", "SlabTopDark" }, Material.rock);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		if (lit)
			this.setLightLevel(1);
		setHardness(4.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		setStepSound(soundTypeStone);
	}
}