package com.parzivail.pswm.render.block.hoth;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.hoth.ModelConsoleHothCurved3;
import com.parzivail.pswm.render.block.RenderPTile;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderConsoleHothCurved3 extends RenderPTile
{
	public RenderConsoleHothCurved3()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/consolehothcurved3.png"), new ModelConsoleHothCurved3());
	}
}
