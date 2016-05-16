package com.parzivail.util;

import net.minecraftforge.client.event.RenderGameOverlayEvent;

import java.util.ArrayList;
import java.util.Iterator;

public class AnimationManager
{
	public static ArrayList<Animation> animations = new ArrayList<>();

	/**
	 * Renders all active (renderable) animations
	 *
	 * @param event The game overlay event that is the base of the render
	 */
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

	/**
	 * Ticks all active animations forwards in time
	 */
	public static void tick()
	{
		Iterator<Animation> i = animations.iterator();

		while (i.hasNext())
		{
			Animation t = i.next();
			t.tick();
			if (t.reverse && t.getTick() <= 0)
				if (t.getLoop())
					t.tick = t.getLength();
				else
				{
					if (t.onAnimationEnd != null)
						t.onAnimationEnd.accept(t);
					i.remove();
				}
			else if (!t.reverse && t.getTick() >= t.getLength())
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

	/**
	 * Checks if an animation of a certain class is running and, if so, returns it.
	 *
	 * @param clazz The class of the animation
	 * @return The first matching animation found
	 */
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
