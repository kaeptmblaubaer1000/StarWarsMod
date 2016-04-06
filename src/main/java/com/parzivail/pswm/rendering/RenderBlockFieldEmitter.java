package com.parzivail.pswm.rendering;

import org.lwjgl.opengl.GL11;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.ui.ShaderHelper;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class RenderBlockFieldEmitter extends TileEntitySpecialRenderer
{
	private static void renderCube(Tessellator tes, float x, float y, float z)
	{
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

			// GL11.glDisable(GL11.GL_LIGHTING); // fix for dimming bug!
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_TEXTURE_2D);

			// RenderHelper.disableLightmap();

			GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_SRC_ALPHA);
			// GL11.glColor4f(0.5f, 0.5f, 1f, 0.5f);

			ShaderHelper.setColor(0.5f, 0.5f, 1f, 0.3f);
			ShaderHelper.useShader(ShaderHelper.glowSolid);

			Tessellator tes = Tessellator.instance;

			tes.startDrawingQuads();

			for (int n = 1; n < i; n++)
			{
				float yy = (float)(y + n);
				if (te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord - 1) != StarWarsMod.blockFieldEmitter)
				{
					tes.addVertex(0 + x, 0 + yy, 0 + z);
					tes.addVertex(0 + x, 1 + yy, 0 + z);
					tes.addVertex(1 + x, 1 + yy, 0 + z);
					tes.addVertex(1 + x, 0 + yy, 0 + z);
				}

				if (te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord + 1) != StarWarsMod.blockFieldEmitter)
				{
					tes.addVertex(0 + x, 0 + yy, 1 + z);
					tes.addVertex(1 + x, 0 + yy, 1 + z);
					tes.addVertex(1 + x, 1 + yy, 1 + z);
					tes.addVertex(0 + x, 1 + yy, 1 + z);
				}

				if (te.getWorldObj().getBlock(te.xCoord - 1, te.yCoord, te.zCoord) != StarWarsMod.blockFieldEmitter)
				{
					tes.addVertex(0 + x, 0 + yy, 0 + z);
					tes.addVertex(0 + x, 0 + yy, 1 + z);
					tes.addVertex(0 + x, 1 + yy, 1 + z);
					tes.addVertex(0 + x, 1 + yy, 0 + z);
				}

				if (te.getWorldObj().getBlock(te.xCoord + 1, te.yCoord, te.zCoord) != StarWarsMod.blockFieldEmitter)
				{
					tes.addVertex(1 + x, 0 + yy, 0 + z);
					tes.addVertex(1 + x, 1 + yy, 0 + z);
					tes.addVertex(1 + x, 1 + yy, 1 + z);
					tes.addVertex(1 + x, 0 + yy, 1 + z);
				}
			}

			tes.draw();

			ShaderHelper.releaseShader();

			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glDisable(GL11.GL_BLEND);
			// GL11.glEnable(GL11.GL_LIGHTING); // end of fix

			GL11.glPopMatrix();
		}
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\RenderBlockTable.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */