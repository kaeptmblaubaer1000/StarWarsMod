package com.parzi.util.ui;

import java.util.ArrayList;
import java.util.Iterator;

import org.lwjgl.opengl.GL11;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Pre;

public class GuiManager
{
	/** All active toasts **/
	public static ArrayList<GuiToast> toasts = new ArrayList<GuiToast>();
	
	public static void tick()
	{
		Iterator<GuiToast> i = GuiManager.toasts.iterator();

		while (i.hasNext())
		{
			GuiToast t = (GuiToast)i.next();
			t.tick();
			if (t.getLife() <= 0)
				i.remove();
		}
	}

	public static void render(RenderGameOverlayEvent event)
	{
		Iterator<GuiToast> i = GuiManager.toasts.iterator();

		int stack = GuiManager.toasts.size() - 1;
		while (i.hasNext())
		{
			GuiToast t = (GuiToast)i.next();
			t.render(stack);
			stack--;
		}
	}
}
