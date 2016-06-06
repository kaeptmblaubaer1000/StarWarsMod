package com.parzivail.pswm.blocks;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;

/**
 * Created by Colby on 6/6/2016.
 */
public class BlockDeathStarLightFence extends BlockFence
{
	public String name = "deathStarLightFence";

	public BlockDeathStarLightFence()
	{
		super(Resources.MODID + ":" + "deathStarBlockHangarWallPanel", Material.ground);
		setBlockName(Resources.MODID + "." + name);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		setHardness(4.0F);
		setStepSound(soundTypeMetal);
	}
}
