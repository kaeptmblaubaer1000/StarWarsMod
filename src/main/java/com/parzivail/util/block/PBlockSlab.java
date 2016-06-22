package com.parzivail.util.block;

import com.parzivail.pswm.Resources;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;

public class PBlockSlab extends BlockSlab
{
	public String name;

	public PBlockSlab(String name, boolean fullBlock, Material material)
	{
		super(fullBlock, material);
		this.name = name;
		this.setBlockName(Resources.MODID + "." + this.name);
	}

	/**
	 * getFullSlabName
	 *
	 * @return Full slab name
	 */
	@Override
	public String func_150002_b(int p_150002_1_)
	{
		return name;
	}
}