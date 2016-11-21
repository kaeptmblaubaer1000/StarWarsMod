package com.parzivail.pswm.rendering;

import com.parzivail.pswm.tileentities.TileEntityShipwright;
import com.parzivail.util.ui.GFX;
import com.parzivail.util.ui.GLPalette;
import com.parzivail.util.ui.P3D;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import static com.parzivail.pswm.StarWarsMod.mc;

public class RenderShipwright extends TileEntitySpecialRenderer
{
	//public static ResourceLocation texture = new ResourceLocation(Resources.MODID + ":" + "textures/blocks/moistureVaporator.png");

	//private final ModelMV model;

	public RenderShipwright()
	{
		//this.model = new ModelMV();
	}

	private void adjustRotatePivotViaMeta(World world, int x, int y, int z)
	{
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float tickTime)
	{
		GL11.glPushMatrix();
		TileEntityShipwright t = (TileEntityShipwright)te;
		GL11.glTranslatef((float)x + 0.5F, (float)y + 0.5F, (float)z + 0.5F);
		//Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glPushMatrix();
		P3D.glScalef(0.03f);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		//GL11.glRotatef(t.getFacing() * 45, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(RenderManager.instance.playerViewY, 0, 1, 0);
		GL11.glRotatef(-RenderManager.instance.playerViewX, 1, 0, 0);

		GL11.glPushAttrib(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glTranslatef(mc.fontRenderer.getStringWidth("Shipwright") / -2f, mc.fontRenderer.FONT_HEIGHT / -2f, 0);
		GFX.drawText(mc.fontRenderer, "Shipwright", 0, 0, 1, GLPalette.WHITE);
		GL11.glPopAttrib();

		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
