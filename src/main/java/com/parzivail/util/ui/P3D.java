package com.parzivail.util.ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

/**
 * Created by Colby on 7/13/2016.
 */
public class P3D
{
	private static void startPolygon(boolean filled)
	{
		if (filled)
			GL11.glBegin(GL11.GL_TRIANGLE_FAN);
		else
			GL11.glBegin(GL11.GL_LINE_LOOP);
	}

	public static void setup2D(Minecraft mc)
	{
		ScaledResolution scaledresolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0.0D, scaledresolution.getScaledWidth_double(), scaledresolution.getScaledHeight_double(), 0.0D, 1000.0D, 3000.0D);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
		GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
	}

	public static void drawRectangle(double x, double y, double w, double h, boolean filled)
	{
		GL11.glPushMatrix();
		startPolygon(filled);
		GL11.glVertex2d(x, y);
		GL11.glVertex2d(x, y + h);
		GL11.glVertex2d(x + w, y + h);
		GL11.glVertex2d(x + w, y);
		GL11.glEnd();
		GL11.glPopMatrix();
	}

	public static void drawRectangle(double x, double y, double z, double w, double h, boolean filled)
	{
		GL11.glPushMatrix();
		startPolygon(filled);
		GL11.glVertex3d(x, y, z);
		GL11.glVertex3d(x, y + h, z);
		GL11.glVertex3d(x + w, y + h, z);
		GL11.glVertex3d(x + w, y, z);
		GL11.glEnd();
		GL11.glPopMatrix();
	}

	public static void drawTriangle(double x, double y, int scale, boolean filled)
	{
		startPolygon(filled);
		GL11.glVertex2d(x, y + scale);
		GL11.glVertex2d(x + scale, y - scale);
		GL11.glVertex2d(x - scale, y - scale);
		GL11.glEnd();
	}

	public static void drawLine(double sx, double sy, double ex, double ey)
	{
		GL11.glPushMatrix();
		GL11.glBegin(GL11.GL_LINE_STRIP);
		GL11.glVertex2d(sx, sy);
		GL11.glVertex2d(ex, ey);
		GL11.glEnd();
		GL11.glPopMatrix();
	}

	public static void drawLine(double sx, double sy, double sz, double ex, double ey, double ez)
	{
		GL11.glPushMatrix();
		GL11.glBegin(GL11.GL_LINE_STRIP);
		GL11.glVertex3d(sx, sy, sz);
		GL11.glVertex3d(ex, ey, ez);
		GL11.glEnd();
		GL11.glPopMatrix();
	}

	public static void drawCircle(double x, double y, double radius, boolean filled)
	{
		GL11.glPushMatrix();
		startPolygon(filled);
		for (int i = 0; i <= 360; i++)
		{
			double nx = MathHelper.sin((float)(i * Math.PI / 180)) * radius;
			double ny = MathHelper.cos((float)(i * Math.PI / 180)) * radius;
			GL11.glVertex2d(nx + x, ny + y);
		}
		GL11.glEnd();
		GL11.glPopMatrix();
	}

	public static void drawDashedCircle(double x, double y, double radius, int dashLen)
	{
		GL11.glPushMatrix();
		for (int i = 0; i <= 360; i += (Math.PI * dashLen))
		{
			GL11.glBegin(GL11.GL_LINE_STRIP);
			for (int j = 0; j <= dashLen; j++)
			{
				double nx = MathHelper.sin((float)((i + j) * Math.PI / 180)) * radius;
				double ny = MathHelper.cos((float)((i + j) * Math.PI / 180)) * radius;
				GL11.glVertex2d(nx + x, ny + y);
			}
			GL11.glEnd();
		}
		GL11.glPopMatrix();
	}

	public static void drawPieCircle(double x, double y, double radius, double percent, boolean filled)
	{
		GL11.glPushMatrix();
		startPolygon(filled);
		GL11.glVertex2d(x, y);
		for (int i = 0; i <= 360 * percent; i++)
		{
			double nx = MathHelper.sin((float)(i * Math.PI / 180)) * radius;
			double ny = MathHelper.cos((float)(i * Math.PI / 180)) * radius;
			GL11.glVertex2d(nx + x, ny + y);
		}
		GL11.glEnd();
		GL11.glPopMatrix();
	}

	public static void drawPieDonut(double x, double y, double radius, double stripSize, double percent, boolean filled)
	{
		GL11.glPushMatrix();
		startPolygon(filled);
		for (int i = 0; i <= 360 * percent; i++)
		{
			double nx = MathHelper.sin((float)(i * Math.PI / 180)) * (radius - stripSize);
			double ny = MathHelper.cos((float)(i * Math.PI / 180)) * (radius - stripSize);
			GL11.glVertex2d(nx + x, ny + y);

			nx = MathHelper.sin((float)(i * Math.PI / 180)) * radius;
			ny = MathHelper.cos((float)(i * Math.PI / 180)) * radius;
			GL11.glVertex2d(nx + x, ny + y);
		}
		GL11.glEnd();
		GL11.glPopMatrix();
	}

	public static void drawText(FontRenderer font, String s, double x, double y, double scale, int color, int shadowColor, int shadowDistance)
	{
		GL11.glPushMatrix();
		GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glScaled(scale, scale, 1);
		GL11.glTranslated(x / scale, y / scale, 0);
		font.drawString(s, shadowDistance, shadowDistance, shadowColor);
		font.drawString(s, 0, 0, color);
		GL11.glPopAttrib();
		GL11.glPopMatrix();
	}

	public static void drawCenteredText(FontRenderer font, String s, double x, double y, double scale, int color, int shadowColor, int shadowDistance)
	{
		GL11.glPushMatrix();
		GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glScaled(scale, scale, 1);
		GL11.glTranslated(x / scale, y / scale, 0);
		font.drawString(s, shadowDistance, shadowDistance, shadowColor);
		font.drawString(s, -font.getStringWidth(s) / 2, 0, color);
		GL11.glPopAttrib();
		GL11.glPopMatrix();
	}

	public static int getRGB(int r, int g, int b)
	{
		int rgb = r;
		rgb = (rgb << 8) + g;
		rgb = (rgb << 8) + b;
		return rgb;
	}

	public static int getRGBA(int r, int g, int b, int a)
	{
		int rgba = a;
		rgba = (rgba << 8) + r;
		rgba = (rgba << 8) + g;
		rgba = (rgba << 8) + b;
		return rgba;
	}

	public static void glScale(double scale)
	{
		GL11.glScaled(scale, scale, scale);
	}

	public static void glColorGrayscale(double color)
	{
		GL11.glColor3d(color, color, color);
	}
}
