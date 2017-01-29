package com.parzivail.pswm.render.block.hoth;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.hoth.ModelConsoleHothCurved1;
import com.parzivail.pswm.render.block.RenderPTile;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderConsoleHothCurved1 extends RenderPTile
{
	public RenderConsoleHothCurved1()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/consolehothcurved1.png"), new ModelConsoleHothCurved1());
	}
}
