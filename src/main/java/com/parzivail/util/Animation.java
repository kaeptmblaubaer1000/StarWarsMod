package com.parzivail.util;

import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class Animation
{
	protected int tick = 0;
	protected int length = 0;
	protected boolean loop = false;
	protected boolean isRenderable = false;
	
	public Animation(int length, boolean loop, boolean isRenderable)
	{
		this.length = length;
		this.loop = loop;
		this.isRenderable = isRenderable;
	}
	
	public void tick()
	{
		this.tick++;
	}
	
	public void render(RenderGameOverlayEvent event)
	{
	}
	
	public int getLife()
	{
		return this.tick;
	}
	
	public int getMax()
	{
		return this.length;
	}
	
	public boolean getLoop()
	{
		return this.loop;
	}
	
	public boolean getRenderable()
	{
		return this.isRenderable;
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
}
