package com.parzivail.pswm.rendering;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;

import org.lwjgl.opengl.GL11;

import com.parzivail.pswm.StarWarsMod;

public class RenderHoloTable extends TileEntitySpecialRenderer
{
	public RenderHoloTable()
	{
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float p)
	{
		GL11.glPushMatrix();

		for (Object e : te.getWorldObj().getEntitiesWithinAABB(Entity.class, te.getRenderBoundingBox().expand(50, 50, 50)))
		{
			if (e instanceof Entity)
			{
				Entity entity = (Entity)e;
				GL11.glPushMatrix();
				// 3.125
				Vec3 pos = StarWarsMod.mc.thePlayer.getPosition(p);
				GL11.glTranslated(-pos.xCoord, -pos.yCoord, -pos.zCoord);
				float dx = (float)(te.xCoord - entity.posX) / -16f;
				float dy = (float)(te.yCoord - entity.posY) / 16f;
				float dz = (float)(te.zCoord - entity.posZ) / -16f;
				GL11.glTranslatef(te.xCoord + 0.5f + dx, te.yCoord + 1 + 1 / 16f + dy, te.zCoord + 0.5f + dz);
				GL11.glScalef(1 / 16f, 1 / 16f, 1 / 16f);
				GL11.glColor3f(1, 1, 1);
				renderEntity(entity);
				GL11.glPopMatrix();
			}
		}

		GL11.glPushMatrix();
		Vec3 pos = StarWarsMod.mc.thePlayer.getPosition(p);
		GL11.glTranslated(-pos.xCoord, -pos.yCoord, -pos.zCoord);
		GL11.glTranslatef(te.xCoord + 0.5f, te.yCoord + 1 + 1 / 16f, te.zCoord + 0.5f);
		GL11.glScalef(1 / 16f, 1 / 16f, 1 / 16f);

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_TEXTURE_2D); // fix for dimming bug!
		GL11.glEnable(GL11.GL_LINE_SMOOTH);

		GL11.glLineWidth(0.1f);
		GL11.glColor3f(0.5f, 0.5f, 0.5f);

		for (int i = 0; i < 101; i++)
		{
			GL11.glBegin(GL11.GL_LINES);
			GL11.glVertex3d(i - 50, 0, -50);
			GL11.glVertex3d(i - 50, 0, 50);
			GL11.glEnd();

			GL11.glBegin(GL11.GL_LINES);
			GL11.glVertex3d(-50, 0, i - 50);
			GL11.glVertex3d(50, 0, i - 50);
			GL11.glEnd();
		}

		GL11.glColor3f(0, 1, 0);
		GL11.glBegin(GL11.GL_TRIANGLE_FAN);
		GL11.glVertex3d(-50, -0.01f, 50);
		GL11.glVertex3d(50, -0.01f, -50);
		GL11.glVertex3d(-50, -0.01f, -50);
		GL11.glVertex3d(-50, -0.01f, 50);
		GL11.glVertex3d(50, -0.01f, 50);
		GL11.glVertex3d(50, -0.01f, -50);
		GL11.glEnd();


		GL11.glDisable(GL11.GL_LINE_SMOOTH);
		GL11.glEnable(GL11.GL_TEXTURE_2D); // end of fix
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glColor3f(1, 1, 1);
		GL11.glPopMatrix();

		GL11.glPopMatrix();
	}

	public static void renderEntity(Entity el)
	{
		Tessellator.instance.setBrightness(240);
		GL11.glDisable(GL11.GL_BLEND);

		Render render = RenderManager.instance.getEntityRenderObject(el);
		render.doRender(el, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);

		GL11.glEnable(GL11.GL_BLEND);
		Tessellator.instance.setBrightness(240);
		Tessellator.instance.setColorRGBA(255, 255, 255, 255);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\RenderMV.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */