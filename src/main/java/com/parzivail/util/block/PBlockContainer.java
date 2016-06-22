package com.parzivail.util.block;

import com.parzivail.pswm.Resources;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;

public abstract class PBlockContainer extends BlockContainer
{
	public String name;

	public PBlockContainer(String name, Material material)
	{
		super(material);
		this.name = name;
		this.setBlockName(Resources.MODID + "." + this.name);
	}
}