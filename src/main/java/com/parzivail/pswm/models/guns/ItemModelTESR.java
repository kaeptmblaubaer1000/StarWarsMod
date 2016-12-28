package com.parzivail.pswm.models.guns;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by colby on 12/27/2016.
 */
public class ItemModelTESR extends TileEntitySpecialRenderer
{
	private ModelBase model;

	public ItemModelTESR(ModelBase model)
	{
		this.model = model;
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage)
	{
		model.render(null, 0, 0, 0, 0, 0, 0.625f);
	}
}
