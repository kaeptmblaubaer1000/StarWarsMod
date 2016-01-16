package com.parzi.starwarsmod.rendering.gui;

import com.parzi.starwarsmod.handlers.ClientEventHandler;
import com.parzi.util.Animation;
import com.parzi.util.ui.GlPalette;

import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class AnimationCrosshairOpen extends Animation
{
	int color;

	public AnimationCrosshairOpen(int color)
	{
		super(8, false, true);
		ClientEventHandler.isCursorAnim = true;
		this.color = color;
	}

	@Override
	public void render(RenderGameOverlayEvent event)
	{
		super.render(event);
		
		ClientEventHandler.pgui.drawFancyCursor(event, (this.length - this.tick) / (float)this.length, color);
	}

	@Override
	public void tick()
	{
		super.tick();
		if (this.tick == this.length)
		{
			ClientEventHandler.isCursorAnim = false;
			ClientEventHandler.cursorOpen = true;
		}
	}
}
