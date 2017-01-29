package com.parzivail.pswm.render.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.ModelBlockTable;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderBlockTable extends RenderPTile
{
	public RenderBlockTable()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/blocktable.png"), new ModelBlockTable());
	}
}
