package com.parzivail.util.math;

import java.util.function.Consumer;

/**
 * Created by Colby on 5/16/2016.
 */
public class Timer
{
	public static Animation setTimeout(Consumer<Animation> consumer, int timeout)
	{
		Animation a = new Animation(timeout, false, false);
		a.setOnAnimationEnd(consumer);
		a.start();
		return a;
	}

	public static Animation setInterval(Consumer<Animation> consumer, int interval)
	{
		Animation a = new Animation(interval, true, false);
		a.setOnAnimationEnd(consumer);
		a.start();
		return a;
	}
}
