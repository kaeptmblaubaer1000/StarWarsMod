package com.parzivail.pswm.rendering;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.mobs.MobTusken;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderTusken extends RenderBiped
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/tusken.png");

	public RenderTusken(ModelBiped par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}

	protected void renderCarrying(MobTusken par1MobTusken, float par2)
	{
		super.renderEquippedItems(par1MobTusken, par2);
	}
}
