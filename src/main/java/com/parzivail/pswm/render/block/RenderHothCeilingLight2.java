package com.parzivail.pswm.render.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.ModelHothCeilingLight2;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderHothCeilingLight2 extends RenderPTile
{
	public RenderHothCeilingLight2()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/hothceilinglight2.png"), new ModelHothCeilingLight2());
	}
}
