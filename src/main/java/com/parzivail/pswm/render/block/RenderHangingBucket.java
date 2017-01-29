package com.parzivail.pswm.render.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.ModelHangingBucket;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderHangingBucket extends RenderPTile
{
	public RenderHangingBucket()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/hangingbucket.png"), new ModelHangingBucket());
	}
}
