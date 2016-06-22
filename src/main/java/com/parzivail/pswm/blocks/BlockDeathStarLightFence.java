package com.parzivail.pswm.blocks;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.block.PBlockFence;
import net.minecraft.block.material.Material;

/**
 * Created by Colby on 6/6/2016.
 */
public class BlockDeathStarLightFence extends PBlockFence
{
	public BlockDeathStarLightFence()
	{
		super("deathStarLightFence", Resources.MODID + ":" + "deathStarBlockHangarWallPanel", Material.ground);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		setHardness(4.0F);
		setStepSound(soundTypeMetal);
	}
}
