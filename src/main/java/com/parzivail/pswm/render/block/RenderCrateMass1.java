package com.parzivail.pswm.render.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.ModelCrateMass1;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderCrateMass1 extends RenderPTile
{
	public RenderCrateMass1()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/cratemass1.png"), new ModelCrateMass1());
	}
}
