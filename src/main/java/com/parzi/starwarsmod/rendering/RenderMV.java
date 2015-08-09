package com.parzi.starwarsmod.rendering;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.models.ModelMV;
import com.parzi.starwarsmod.tileentities.TileEntityMV;

public class RenderMV extends TileEntitySpecialRenderer
{

	// The model of your block
	private final ModelMV model;

	public RenderMV()
	{
		model = new ModelMV();
	}

	private void adjustRotatePivotViaMeta(World world, int x, int y, int z)
	{
		// TileEntityMV tile = (TileEntityMV)world.getTileEntity(x, y, z);
		// GL11.glPushMatrix();
		// GL11.glRotatef(tile.getFacing() * (-90), 0.0F, 0.0F, 1.0F);
		// GL11.glPopMatrix();
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float tickTime)
	{

		GL11.glPushMatrix();

		TileEntityMV mv = (TileEntityMV)te;

		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.2F, (float)z + 0.5F);

		ResourceLocation textures = new ResourceLocation(StarWarsMod.MODID + ":" + "textures/blocks/moistureVaporator.png");

		Minecraft.getMinecraft().renderEngine.bindTexture(textures);

		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0, 0, 1);
		GL11.glRotatef(mv.getFacing() * 90, 0, 1, 0);

		model.windVane1.rotateAngleY = mv.frame / 10;
		model.windVane2.rotateAngleY = mv.frame / 10;
		model.windVaneRod1.rotateAngleY = mv.frame / 10;
		model.windVaneRod2.rotateAngleY = mv.frame / 10;
		model.render((Entity)null, 0, 0, 0, 0, 0, 0.05F);

		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
