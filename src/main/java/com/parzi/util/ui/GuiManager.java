package com.parzi.util.ui;

import java.util.Iterator;

import org.lwjgl.opengl.GL11;

public class GuiManager
{
	public static void tick()
	{
		Iterator<GuiToast> i = GuiToast.toasts.iterator();

		while (i.hasNext())
		{
			GuiToast t = (GuiToast)i.next();
			t.tick();
			if (t.getLife() <= 0)
				i.remove();
		}
	}

	public static void render()
	{
		Iterator<GuiToast> i = GuiToast.toasts.iterator();

		int stack = 0;
		while (i.hasNext())
		{
			GuiToast t = (GuiToast)i.next();
			t.render(stack);
			stack++;
		}
	}
}
