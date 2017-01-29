package com.parzivail.pswm.render.block.hoth;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.hoth.ModelFloorLight2;
import com.parzivail.pswm.render.block.RenderPTile;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderFloorLight2 extends RenderPTile
{
	public RenderFloorLight2()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/floorlight2.png"), new ModelFloorLight2());
	}
}
