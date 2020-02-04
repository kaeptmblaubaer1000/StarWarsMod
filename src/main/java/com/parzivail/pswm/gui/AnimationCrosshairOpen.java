package com.parzivail.pswm.gui;

import com.parzivail.pswm.handlers.ClientEventHandler;
import com.parzivail.util.math.Animation;
import com.parzivail.util.ui.GFX;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class AnimationCrosshairOpen extends Animation
{
	private int color;

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

		GFX.drawFancyCursor(event, (this.length - this.tick) / (float)this.length, this.color);
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
