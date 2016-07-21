package com.parzivail.pswm.models;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.rendering.RenderStaticNpc;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;

public class ModelBipedStatic extends ModelBiped
{
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		StarWarsMod.mc.renderEngine.bindTexture(RenderStaticNpc.texture);
		this.bipedHead.render(f5);
		this.bipedBody.render(f5);
		this.bipedRightArm.render(f5);
		this.bipedLeftArm.render(f5);
		this.bipedRightLeg.render(f5);
		this.bipedLeftLeg.render(f5);
		this.bipedHeadwear.render(f5);
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
	}
}
