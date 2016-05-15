package com.parzivail.util.ui;

import com.parzivail.util.FPoint;
import net.minecraft.client.gui.FontRenderer;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;

public class Screen2D
{
	/**
	 * Draws a rectangle
	 *
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param filled
	 */
	public static void drawRectangle(float x, float y, float w, float h, boolean filled)
	{
		GL11.glPushMatrix();
		if (filled)
			glBegin(GL11.GL_TRIANGLE_FAN);
		else
			glBegin(GL11.GL_LINE_LOOP);
		GL11.glVertex3d(x, y, 0);
		GL11.glVertex3d(x, y + h, 0);
		GL11.glVertex3d(x + w, y + h, 0);
		GL11.glVertex3d(x + w, y, 0);
		glEnd();
		GL11.glPopMatrix();
	}

	/**
	 * Draws a line
	 *
	 * @param sx
	 * @param sy
	 * @param ex
	 * @param ey
	 */
	public static void drawLine(float sx, float sy, float ex, float ey)
	{
		GL11.glPushMatrix();
		glBegin(GL11.GL_LINE_STRIP);
		GL11.glVertex2d(sx, sy);
		GL11.glVertex2d(ex, ey);
		glEnd();
		GL11.glPopMatrix();
	}

	public static FPoint catmullRomLine(float t, FPoint p1, FPoint p2, FPoint p3, FPoint p4)
	{

		float t2 = t * t;
		float t3 = t * t * t;
		FPoint v = new FPoint(0, 0); // Interpolated point

		/* Catmull Rom spline Calculation */

		v.x = catmulRom(t, p1.x, p2.x, p3.x, p4.x);
		v.y = catmulRom(t, p1.y, p2.y, p3.y, p4.y);

		return v;
	}

	public static float catmulRom(float u, float x0, float x1, float x2, float x3)
	{
		float u2 = u * u;
		float u3 = u2 * u;
		return ((2 * x1) +
				(-x0 + x2) * u +
				(2 * x0 - 5 * x1 + 4 * x2 - x3) * u2 +
				(-x0 + 3 * x1 - 3 * x2 + x3) * u3) * 0.5f;
	}

	public static void drawSpline(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4)
	{
		GL11.glPushMatrix();
		glBegin(GL11.GL_LINE_STRIP);
		for (float t = 0; t < 1; t += 0.01f)
		{
			FPoint v = catmullRomLine(t, new FPoint(x1, y1), new FPoint(x2, y2), new FPoint(x3, y3), new FPoint(x4, y4));
			GL11.glVertex2f(v.x, v.y);
		}
		glEnd();
		GL11.glPopMatrix();
	}

	/**
	 * Draws a filled circle
	 *
	 * @param x
	 * @param y
	 * @param radius
	 */
	public static void drawFilledCircle(float x, float y, float radius)
	{
		GL11.glPushMatrix();
		glBegin(GL11.GL_TRIANGLE_FAN);
		for (int i = 0; i <= 360; i++)
		{
			double nx = Math.sin(i * 3.141526D / 180) * radius;
			double ny = Math.cos(i * 3.141526D / 180) * radius;
			GL11.glVertex2d(nx + x, ny + y);
		}
		glEnd();
		GL11.glPopMatrix();
	}

	/**
	 * Draws a circle
	 *
	 * @param x
	 * @param y
	 * @param radius
	 */
	public static void drawCircle(float x, float y, float radius)
	{
		GL11.glPushMatrix();
		glBegin(GL11.GL_LINE_STRIP);
		for (int i = 0; i <= 360; i++)
		{
			double nx = Math.sin(i * 3.141526D / 180) * radius;
			double ny = Math.cos(i * 3.141526D / 180) * radius;
			GL11.glVertex2d(nx + x, ny + y);
		}
		glEnd();
		GL11.glPopMatrix();
	}

	/**
	 * Draws a dashed circle
	 *
	 * @param x
	 * @param y
	 * @param radius
	 * @param dashLen
	 */
	public static void drawDashedCircle(float x, float y, float radius, int dashLen)
	{
		GL11.glPushMatrix();
		for (int i = 0; i <= 360; i += (3 * dashLen))
		{
			glBegin(GL11.GL_LINE_STRIP);
			for (int j = 0; j <= dashLen; j++)
			{
				double nx = Math.sin((i + j) * 3.141526D / 180) * radius;
				double ny = Math.cos((i + j) * 3.141526D / 180) * radius;
				GL11.glVertex2d(nx + x, ny + y);
			}
			glEnd();
		}
		GL11.glPopMatrix();
	}

	/**
	 * Draws a pie piece circle thing
	 *
	 * @param x
	 * @param y
	 * @param radius
	 * @param percent
	 */
	public static void drawPieCircle(float x, float y, float radius, float percent)
	{
		GL11.glPushMatrix();
		glBegin(GL11.GL_TRIANGLE_FAN);
		GL11.glVertex2d(x, y);
		for (int i = 0; i <= 360 * percent; i++)
		{
			double nx = Math.sin(i * 3.141526D / 180) * radius;
			double ny = Math.cos(i * 3.141526D / 180) * radius;
			GL11.glVertex2d(nx + x, ny + y);
		}
		glEnd();
		GL11.glPopMatrix();
	}

	/**
	 * Draws a pie piece donut thing
	 *
	 * @param x
	 * @param y
	 * @param radius
	 * @param stripSize
	 * @param percent
	 */
	public static void drawPieDonut(float x, float y, float radius, float stripSize, float percent)
	{
		GL11.glPushMatrix();
		glBegin(GL11.GL_TRIANGLE_STRIP);
		for (int i = 0; i <= 360 * percent; i++)
		{
			double nx = Math.sin(i * 3.141526D / 180) * (radius - stripSize);
			double ny = Math.cos(i * 3.141526D / 180) * (radius - stripSize);
			GL11.glVertex2d(nx + x, ny + y);

			nx = Math.sin(i * 3.141526D / 180) * radius;
			ny = Math.cos(i * 3.141526D / 180) * radius;
			GL11.glVertex2d(nx + x, ny + y);
		}
		glEnd();
		GL11.glPopMatrix();
	}

	/**
	 * Draws a LOS message
	 *
	 * @param font
	 * @param x
	 * @param y
	 * @param scale
	 */
	public static void drawLOS(FontRenderer font, float x, float y, float scale)
	{
		GL11.glPushMatrix();
		GL11.glPushMatrix();
		GL11.glTranslatef(x, y, 0);
		GLPalette.glColorI(GLPalette.DARK_GREY);
		glBegin(GL11.GL_TRIANGLE_FAN);
		GL11.glVertex3d(-1, 0, 0);
		GL11.glVertex3d(1, 0, 0);
		GL11.glVertex3d(1, 1, 0);
		GL11.glVertex3d(-1, 1, 0);
		glEnd();
		GLPalette.glColorI(GLPalette.LIGHT_GREY);
		glBegin(GL11.GL_LINE_LOOP);
		GL11.glVertex3d(-0.9f, 0.1f, 0);
		GL11.glVertex3d(0.9f, 0.1f, 0);
		GL11.glVertex3d(0.9f, 0.9f, 0);
		GL11.glVertex3d(-0.9f, 0.9f, 0);
		glEnd();
		GL11.glPopMatrix();
		Screen2D.drawCenteredText(font, "L.O.S.", x + 0.1f, y + 0.7f, 3f, GLPalette.WHITE);
		GL11.glPopMatrix();
	}

	/**
	 * Draws a No Signal message
	 *
	 * @param font
	 * @param x
	 * @param y
	 * @param scale
	 */
	public static void drawNoSignal(FontRenderer font, float x, float y, float scale)
	{
		GL11.glPushMatrix();
		GL11.glPushMatrix();
		GL11.glTranslatef(x, y, 0);
		GLPalette.glColorI(GLPalette.DARK_GREY);
		glBegin(GL11.GL_TRIANGLE_FAN);
		GL11.glVertex3d(-40 * scale, -20 * scale, 0);
		GL11.glVertex3d(40 * scale, -20 * scale, 0);
		GL11.glVertex3d(40 * scale, 20 * scale, 0);
		GL11.glVertex3d(-40 * scale, 20 * scale, 0);
		glEnd();
		GLPalette.glColorI(GLPalette.LIGHT_GREY);
		glBegin(GL11.GL_LINE_LOOP);
		GL11.glVertex3d(-37f * scale, -17f * scale, 0);
		GL11.glVertex3d(37f * scale, -17f * scale, 0);
		GL11.glVertex3d(37f * scale, 17f * scale, 0);
		GL11.glVertex3d(-37f * scale, 17f * scale, 0);
		glEnd();
		GL11.glPopMatrix();
		Screen2D.drawCenteredText(font, "No Signal", x, y - 6 * scale, scale + 0.3f * scale, GLPalette.WHITE);
		GL11.glPopMatrix();
	}

	/**
	 * Draws some text
	 *
	 * @param font
	 * @param s
	 * @param x
	 * @param y
	 * @param scale
	 * @param color
	 */
	public static void drawText(FontRenderer font, String s, float x, float y, float scale, int color)
	{
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glScalef(scale, scale, 1);
		GL11.glTranslatef(x / scale, y / scale, 0);
		font.drawString(s, 0, 0, color);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glPopMatrix();
	}

	/**
	 * Draws some centered text
	 *
	 * @param font
	 * @param s
	 * @param x
	 * @param y
	 * @param scale
	 * @param color
	 */
	public static void drawCenteredText(FontRenderer font, String s, float x, float y, float scale, int color)
	{
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glScalef(scale, scale, 1);
		GL11.glTranslatef(x / scale, y / scale, 0);
		font.drawString(s, -font.getStringWidth(s) / 2, 0, color);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glPopMatrix();
	}

	/**
	 * Double wrapper for {@link Screen2D::drawLine}
	 *
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public static void drawLine(double x1, double y1, double x2, double y2)
	{
		drawLine((float)x1, (float)y1, (float)x2, (float)y2);
	}
}
