package com.parzivail.pswm.rendering;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import com.parzivail.util.ui.RenderHelper;

public class RenderBlockFieldEmitter extends TileEntitySpecialRenderer
{
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
			GL11.glDepthMask(true);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_SRC_ALPHA);

			for (int n = 1; n < i; n++)
			{
				GL11.glPushMatrix();
				GL11.glTranslatef((float)x, (float)y + n, (float)z);
				GL11.glColor4f(0, 0, 1, 1);
				renderCube(Tessellator.instance);
				GL11.glPopMatrix();
			}

			GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
		}
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\RenderBlockTable.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */