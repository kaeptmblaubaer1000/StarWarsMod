package com.parzivail.pswm.blocks;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.block.BlockConnected;
import com.parzivail.util.world.HarvestLevel;
import net.minecraft.block.material.Material;

public class BlockHothSandbag extends BlockConnected
{
	public BlockHothSandbag()
	{
		super("hothSandbag", Material.rock);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		setHardness(4.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		setStepSound(soundTypeSnow);
	}
}