package com.parzivail.pswm.render.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.ModelDeathStarDoor;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderDeathStarDoor extends RenderPTile
{
	public RenderDeathStarDoor()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/deathstardoor.png"), new ModelDeathStarDoor());
	}
}
