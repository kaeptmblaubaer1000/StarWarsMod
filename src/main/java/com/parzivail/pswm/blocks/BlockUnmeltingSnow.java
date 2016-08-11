package com.parzivail.pswm.blocks;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.block.PBlock;
import net.minecraft.block.material.Material;

public class BlockUnmeltingSnow extends PBlock
{
	public BlockUnmeltingSnow()
	{
		super("hardpackSnow", Material.ground);
		setBlockTextureName(Resources.MODID + ":" + name);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		setHardness(4.0F);
		setStepSound(soundTypeSnow);
	}
}
