package com.parzi.util;

import java.util.ArrayList;
import java.util.Iterator;

import com.parzi.util.ui.GuiManager;
import com.parzi.util.ui.GuiToast;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Pre;

public class AnimationManager
{
	/** All active animations **/
	public static ArrayList<Animation> animations = new ArrayList<Animation>();

	public static void tick()
	{
		Iterator<Animation> i = animations.iterator();

		while (i.hasNext())
		{
			Animation t = (Animation)i.next();
			t.tick();
			if (t.getLife() >= t.getMax())
			{
				if (t.getLoop())
					t.tick = 0;
				else
					i.remove();
			}

		}
	}

	public static void render(RenderGameOverlayEvent event)
	{
		Iterator<Animation> i = animations.iterator();

		while (i.hasNext())
		{
			Animation t = (Animation)i.next();
			if (t.getRenderable())
				t.render(event);
		}
	}
}
