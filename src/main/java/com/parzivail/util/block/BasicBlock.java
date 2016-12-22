package com.parzivail.util.block;

import net.minecraft.block.material.Material;

/**
 * Created by colby on 12/21/2016.
 */
public class BasicBlock extends PBlock
{
	public BasicBlock(String name, Material material)
	{
		super(name, material);
	}

	public BasicBlock(String name)
	{
		super(name, Material.GROUND);
	}
}
