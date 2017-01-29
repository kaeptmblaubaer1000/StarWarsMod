package com.parzivail.pswm.render.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.ModelGunRack;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderGunRack extends RenderPTile
{
	public RenderGunRack()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/gunrack.png"), new ModelGunRack());
	}
}
