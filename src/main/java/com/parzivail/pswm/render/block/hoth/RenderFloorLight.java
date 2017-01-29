package com.parzivail.pswm.render.block.hoth;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.hoth.ModelFloorLight;
import com.parzivail.pswm.render.block.RenderPTile;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderFloorLight extends RenderPTile
{
	public RenderFloorLight()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/floorlight.png"), new ModelFloorLight());
	}
}
