package com.parzi.starwarsmod.rendering;

import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;

public class RenderBlasterBolt extends RenderSnowball {
	public RenderBlasterBolt(Item renderAs) {
		super(renderAs);
	}

	/*
	 * @Override protected ResourceLocation getEntityTexture(Entity entity) {
	 * return new ResourceLocation(StarWarsMod.MODID,
	 * "textures/models/blasterBolt.png"); }
	 * 
	 * @Override public void doRender(Entity entity, double d0, double d1,
	 * double d2, float f, float f1) {
	 * 
	 * }
	 */
}