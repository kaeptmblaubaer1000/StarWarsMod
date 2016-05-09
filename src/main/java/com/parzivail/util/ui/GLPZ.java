package com.parzivail.util.ui;

import org.lwjgl.opengl.GL11;

public class GLPZ
{
	public static void glScalef(float scale)
	{
		GL11.glScalef(scale, scale, scale);
	}

	public static void glScaled(double scale)
	{
		GL11.glScaled(scale, scale, scale);
	}

	public static void glColorGrayscale(int color)
	{
		glColorGrayscale(color / 255f);
	}

	public static void glColorGrayscale(float color)
	{
		GL11.glColor3f(color, color, color);
	}
}
