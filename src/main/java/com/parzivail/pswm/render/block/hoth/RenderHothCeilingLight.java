package com.parzivail.pswm.render.block.hoth;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.hoth.ModelHothCeilingLight;
import com.parzivail.pswm.render.block.RenderPTile;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderHothCeilingLight extends RenderPTile
{
	public RenderHothCeilingLight()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/hothceilinglight.png"), new ModelHothCeilingLight());
	}
}
