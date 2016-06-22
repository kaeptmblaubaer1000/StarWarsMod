package com.parzivail.util.block;

import com.parzivail.pswm.Resources;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;

public class PBlockFence extends BlockFence
{
	public String name;

	public PBlockFence(String name, String texture, Material material)
	{
		super(texture, material);
		this.name = name;
		this.setBlockName(Resources.MODID + "." + this.name);
	}
}