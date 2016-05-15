package com.parzivail.util;

import net.minecraftforge.client.event.RenderGameOverlayEvent;

import java.util.function.Consumer;

public class Animation
{
	protected int tick = 0;
	protected int length = 0;
	protected boolean loop = false;
	protected boolean isRenderable = false;
	protected boolean reverse;
	protected Consumer<Animation> onAnimationEnd;

	public Animation(int length, boolean loop, boolean isRenderable)
	{
		this.length = length;
		this.loop = loop;
		this.isRenderable = isRenderable;
	}

	public void setReverse(boolean reverse)
	{
		if (reverse)
		{
			this.reverse = true;
			this.tick = this.length;
		}
		else
		{
			this.reverse = false;
			this.tick = 0;
		}
	}

	public void setOnAnimationEnd(Consumer<Animation> onAnimationEnd)
	{
		this.onAnimationEnd = onAnimationEnd;
	}

	public boolean isReverse()
	{
		return reverse;
	}

	public int getTick()
	{
		return this.tick;
	}

	public boolean getLoop()
	{
		return this.loop;
	}

	public int getMax()
	{
		return this.length;
	}

	public boolean getRenderable()
	{
		return this.isRenderable;
	}

	public boolean isDone()
	{
		return reverse ? this.tick == 0 : this.tick == this.length;
	}

	public void render(RenderGameOverlayEvent event)
	{
	}

	public void start()
	{
		AnimationManager.animations.add(this);
	}

	public void stop()
	{
		if (AnimationManager.animations.contains(this))
			AnimationManager.animations.remove(this);
	}

	public void tick()
	{
		if (reverse)
			this.tick--;
		else
			this.tick++;
	}
}
