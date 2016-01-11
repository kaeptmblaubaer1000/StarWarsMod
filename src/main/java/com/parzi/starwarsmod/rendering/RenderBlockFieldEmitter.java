package com.parzi.starwarsmod.rendering;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.tileentities.TileEntityFieldEmitter;
import com.parzi.util.ui.Lumberjack;
import com.parzi.util.ui.RenderHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderBlockFieldEmitter extends TileEntitySpecialRenderer
{
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float partialTickTime)
	{
		int i = 1;
		boolean flag = false;
		while (i <= 50)
		{
			if (!te.getWorldObj().isAirBlock(te.xCoord, te.yCoord + i, te.zCoord))
			{
				flag = true;
				break;
			}
			i++;
		}
		if (flag)
		{
			GL11.glPushMatrix();
			GL11.glDepthMask(false);
			GL11.glDisable(GL11.GL_FOG);
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glDisable(GL11.GL_CULL_FACE);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);

			for (int n = 1; n < i; n++)
			{
				GL11.glPushMatrix();
				GL11.glTranslatef((float)x, (float)y + n, (float)z);
				GL11.glColor3f(0, 0, 1);
				renderCube(Tessellator.instance);
				GL11.glPopMatrix();
			}

			GL11.glDisable(GL11.GL_BLEND);
			GL11.glEnable(GL11.GL_CULL_FACE);
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			GL11.glEnable(GL11.GL_FOG);
			GL11.glDepthMask(true);
			GL11.glPopMatrix();
		}
	}

	private static void renderCube(Tessellator tes)
	{
		tes.startDrawingQuads();

		tes.addVertex(0, 0, 0);
		tes.addVertex(0, 1, 0);
		tes.addVertex(1, 1, 0);
		tes.addVertex(1, 0, 0);

		tes.addVertex(0, 0, 1);
		tes.addVertex(1, 0, 1);
		tes.addVertex(1, 1, 1);
		tes.addVertex(0, 1, 1);

		tes.addVertex(0, 0, 0);
		tes.addVertex(0, 0, 1);
		tes.addVertex(0, 1, 1);
		tes.addVertex(0, 1, 0);

		tes.addVertex(1, 0, 0);
		tes.addVertex(1, 1, 0);
		tes.addVertex(1, 1, 1);
		tes.addVertex(1, 0, 1);

		tes.addVertex(0, 0, 0);
		tes.addVertex(1, 0, 0);
		tes.addVertex(1, 0, 1);
		tes.addVertex(0, 0, 1);

		tes.addVertex(0, 1, 0);
		tes.addVertex(0, 1, 1);
		tes.addVertex(1, 1, 1);
		tes.addVertex(1, 1, 0);

		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		RenderHelper.disableLightmap();
		tes.draw();
		RenderHelper.enableLightmap();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_LIGHTING);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\RenderBlockTable.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */