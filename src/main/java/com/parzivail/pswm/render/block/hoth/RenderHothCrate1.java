package com.parzivail.pswm.render.block.hoth;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.hoth.ModelHothCrate1;
import com.parzivail.pswm.render.block.RenderPTile;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderHothCrate1 extends RenderPTile
{
	public RenderHothCrate1()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/hothcrate1.png"), new ModelHothCrate1());
	}
}
