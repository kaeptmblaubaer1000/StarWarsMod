package com.parzivail.pswm.render.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.ModelAncientJediStatue;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderAncientJediStatue extends RenderPTile
{
	public RenderAncientJediStatue()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/ancientjedistatue.png"), new ModelAncientJediStatue());
	}
}
