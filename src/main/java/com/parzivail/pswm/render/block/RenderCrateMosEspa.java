package com.parzivail.pswm.render.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.ModelCrateMosEspa;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderCrateMosEspa extends RenderPTile
{
	public RenderCrateMosEspa()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/cratemosespa.png"), new ModelCrateMosEspa());
	}
}
