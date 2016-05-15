package com.parzivail.util;

import net.minecraftforge.client.event.RenderGameOverlayEvent;

import java.util.ArrayList;
import java.util.Iterator;

public class AnimationManager
{
	/**
	 * All active animations
	 **/
	public static ArrayList<Animation> animations = new ArrayList<>();

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
			if (t.reverse && t.getTick() <= 0)
				if (t.getLoop())
					t.tick = t.getMax();
				else
				{
					if (t.onAnimationEnd != null)
						t.onAnimationEnd.accept(t);
					i.remove();
				}
			else if (!t.reverse && t.getTick() >= t.getMax())
				if (t.getLoop())
					t.tick = 0;
				else
				{
					if (t.onAnimationEnd != null)
						t.onAnimationEnd.accept(t);
					i.remove();
				}

		}
	}

	public static Animation isRunning(Class<? extends Animation> clazz)
	{
		Iterator<Animation> i = animations.iterator();

		while (i.hasNext())
		{
			Animation t = i.next();
			if (clazz.isInstance(t))
				return t;
		}

		return null;
	}
}
