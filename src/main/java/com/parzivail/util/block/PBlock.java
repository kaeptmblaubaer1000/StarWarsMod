package com.parzivail.util.block;

import com.parzivail.pswm.Resources;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class PBlock extends Block
{
	public String name;

	public PBlock(String name, Material material)
	{
		super(material);
		this.name = name;
		this.setBlockName(Resources.MODID + "." + this.name);
	}
}