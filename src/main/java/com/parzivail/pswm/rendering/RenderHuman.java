package com.parzivail.pswm.rendering;

import com.parzivail.pswm.Resources;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderHuman extends RenderBiped
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID + ":" + "textures/models/npc/parzi.png");
	public static ResourceLocation textureBartender = new ResourceLocation(Resources.MODID + ":" + "textures/models/npc/bartender.png");
	public static ResourceLocation textureCorellian = new ResourceLocation(Resources.MODID + ":" + "textures/models/npc/corellian.png");
	public static ResourceLocation textureMerchant = new ResourceLocation(Resources.MODID + ":" + "textures/models/npc/generalMerchant.png");
	public static ResourceLocation textureSteve = new ResourceLocation(Resources.MODID + ":" + "textures/models/npc/steve.png");
	public static ResourceLocation textureWeaponsDealer = new ResourceLocation(Resources.MODID + ":" + "textures/models/npc/weaponsDealer.png");
	public ResourceLocation overrideTexture = null;

	public RenderHuman(ModelBiped par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
	}

	public RenderHuman(ModelBiped par1ModelBase, float par2, ResourceLocation overrideTexture)
	{
		super(par1ModelBase, par2);
		this.overrideTexture = overrideTexture;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		if (overrideTexture != null)
			return overrideTexture;
		return RenderStaticNpc.texture;
	}
}
