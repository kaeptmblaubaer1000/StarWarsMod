package com.parzivail.pswm.render.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.ModelCrystalCompressor;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderCrystalCompressor extends RenderPTile
{
	public RenderCrystalCompressor()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/crystalcompressor.png"), new ModelCrystalCompressor());
	}
}
