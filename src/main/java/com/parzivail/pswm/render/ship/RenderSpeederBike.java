package com.parzivail.pswm.render.ship;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.ship.ModelSpeederBike;
import com.parzivail.util.driven.Pilotable;
import com.parzivail.util.driven.RenderStarship;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

/**
 * Created by colby on 1/17/2017.
 */
public class RenderSpeederBike extends RenderStarship
{
	public RenderSpeederBike(RenderManager manager)
	{
		super(manager, new ModelSpeederBike(), new ResourceLocation(Resources.MODID, "textures/models/speederbike.png"));
		this.disableFirst = false;
		this.zOffset = -0.5f;
		this.scale = 1.7f;
	}

	public float getTilt(Pilotable pilotable, double d, double d1, double d2, float f, float f1)
	{
		//GFX.changeCameraRoll(-dYaw / 2f);
		return -MathHelper.wrapDegrees(pilotable.axes.getYaw() - pilotable.prevAxes.getYaw());//(pilotable.dYaw + (pilotable.dYaw - pilotable.prevDYaw) * f1);
	}
}