package com.parzivail.pswm.render.ship;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.ship.ModelT13;
import com.parzivail.util.driven.Pilotable;
import com.parzivail.util.driven.RenderStarship;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

/**
 * Created by colby on 1/1/2017.
 */
public class RenderT13 extends RenderStarship
{
	public RenderT13(RenderManager manager)
	{
		super(manager, new ModelT13(), new ResourceLocation(Resources.MODID, "textures/models/t13.png"));
		this.disableFirst = false;
		this.zOffset = -0.65f;
		this.scale = 1.8f;
	}

	@Override
	public float getTilt(Pilotable pilotable, double d, double d1, double d2, float f, float f1)
	{
		return -0.5f * MathHelper.wrapDegrees(pilotable.axes.getYaw() - pilotable.prevAxes.getYaw());
	}
}