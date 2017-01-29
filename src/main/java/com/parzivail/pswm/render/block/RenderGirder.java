package com.parzivail.pswm.render.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.ModelGirder;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderGirder extends RenderPTile
{
	public RenderGirder()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/girder.png"), new ModelGirder());
	}
}
