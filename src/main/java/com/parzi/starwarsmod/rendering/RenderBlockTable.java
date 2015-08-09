package com.parzi.starwarsmod.rendering;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.models.ModelBlockTable;

public class RenderBlockTable extends TileEntitySpecialRenderer
{

	// The model of your block
	private final ModelBlockTable model;

	public RenderBlockTable()
	{
		model = new ModelBlockTable();
	}

	private void adjustRotatePivotViaMeta(World world, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x, y, z);
		GL11.glPushMatrix();
		GL11.glRotatef(meta * -90, 0.0F, 0.0F, 1.0F);
		GL11.glPopMatrix();
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float tickTime)
	{
		GL11.glPushMatrix();

		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);

		ResourceLocation textures = new ResourceLocation(StarWarsMod.MODID + ":" + "textures/blocks/blockTable.png");

		Minecraft.getMinecraft().renderEngine.bindTexture(textures);

		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glScalef(1.25F, 1.25F, 1.25F);
		model.render((Entity)null, 0, 0, 0, 0, 0, 0.05F);

		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
