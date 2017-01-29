package com.parzivail.pswm.render.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.ModelDoorHoth;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderDoorHoth extends RenderPTile
{
	public RenderDoorHoth()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/doorhoth.png"), new ModelDoorHoth());
	}
}
