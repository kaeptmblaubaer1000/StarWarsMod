package com.parzivail.pswm.blocks;

import com.parzivail.util.block.PBlock;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by colby on 12/18/2016.
 */
public class BlockInfrastructure extends PBlock
{
	public BlockInfrastructure()
	{
		super("infrastructure", Material.IRON);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
}
