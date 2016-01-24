package com.parzivail.util.block;

import net.minecraft.block.material.Material;

public class BlockLitMultiTexture extends BlockMultiTexture
{
	public BlockLitMultiTexture(String base, String[] postfixes, float light, Material material)
	{
		super(base, postfixes, material);
		this.setLightLevel(light);
	}
}