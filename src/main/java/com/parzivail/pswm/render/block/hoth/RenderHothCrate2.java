package com.parzivail.pswm.render.block.hoth;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.hoth.ModelHothCrate2;
import com.parzivail.pswm.render.block.RenderPTile;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderHothCrate2 extends RenderPTile
{
	public RenderHothCrate2()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/hothcrate2.png"), new ModelHothCrate2());
	}
}
