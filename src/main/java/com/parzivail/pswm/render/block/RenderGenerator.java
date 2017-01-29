package com.parzivail.pswm.render.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.ModelGenerator;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderGenerator extends RenderPTile
{
	public RenderGenerator()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/generator.png"), new ModelGenerator());
	}
}
