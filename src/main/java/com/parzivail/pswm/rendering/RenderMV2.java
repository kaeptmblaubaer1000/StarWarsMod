package com.parzivail.pswm.rendering;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.blocks.ModelMV2;
import com.parzivail.pswm.tileentities.TileEntityMV2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class RenderMV2 extends TileEntitySpecialRenderer
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID + ":" + "textures/models/mv2.png");

	private final ModelMV2 model;

	public RenderMV2()
	{
		this.model = new ModelMV2();
	}

	private void adjustRotatePivotViaMeta(World world, int x, int y, int z)
	{
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float tickTime)
	{
		GL11.glPushMatrix();
		TileEntityMV2 mv = (TileEntityMV2)te;
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.8F, (float)z + 0.5F);
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glScalef(1.5F, 1.5F, 1.5F);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(mv.getFacing() * 45, 0.0F, 1.0F, 0.0F);
		//this.model.windVane1.rotateAngleY = mv.frame / 10;
		//this.model.windVane2.rotateAngleY = mv.frame / 10;
		//this.model.windVaneRod1.rotateAngleY = mv.frame / 10;
		//this.model.windVaneRod2.rotateAngleY = mv.frame / 10;
		this.model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.05F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
