package com.parzivail.util;

import net.minecraftforge.client.event.RenderGameOverlayEvent;

import java.util.ArrayList;
import java.util.Iterator;

public class AnimationManager
{
	/**
	 * All active animations
	 **/
	public static ArrayList<Animation> animations = new ArrayList<Animation>();

	public static void render(RenderGameOverlayEvent event)
	{
		Iterator<Animation> i = animations.iterator();

		while (i.hasNext())
		{
			Animation t = i.next();
			if (t.getRenderable())
				t.render(event);
		}
	}

	public static void tick()
	{
		Iterator<Animation> i = animations.iterator();

		while (i.hasNext())
		{
			Animation t = i.next();
			t.tick();
			if (t.getLife() >= t.getMax())
				if (t.getLoop())
					t.tick = 0;
				else
					i.remove();

		}
	}
}
