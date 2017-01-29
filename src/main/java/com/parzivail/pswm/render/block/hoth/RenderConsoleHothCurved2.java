package com.parzivail.pswm.render.block.hoth;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.hoth.ModelConsoleHothCurved2;
import com.parzivail.pswm.render.block.RenderPTile;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderConsoleHothCurved2 extends RenderPTile
{
	public RenderConsoleHothCurved2()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/consolehothcurved2.png"), new ModelConsoleHothCurved2());
	}
}
