package com.parzivail.pswm.rendering;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.blocks.ModelAntenna;
import com.parzivail.pswm.tileentities.TileEntityAntenna;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderAntenna extends TileEntitySpecialRenderer
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID + ":" + "textures/models/antenna.png");

	private final ModelAntenna model;

	public RenderAntenna()
	{
		this.model = new ModelAntenna();
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float tickTime)
	{
		GL11.glPushMatrix();
		TileEntityAntenna antenna = (TileEntityAntenna)te;
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.8F, (float)z + 0.5F);
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glScalef(1.5F, 1.5F, 1.5F);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(antenna.getFacing() * 45, 0.0F, 1.0F, 0.0F);
		this.model.render(null, antenna.getFixed() ? 1 : 0, antenna.getOn() ? 1 : 0, antenna.getOpenFrame(), 0.0F, 0.0F, 0.05F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}