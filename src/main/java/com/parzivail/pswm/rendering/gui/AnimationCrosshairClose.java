package com.parzivail.pswm.rendering.gui;

import java.awt.Point;

import org.lwjgl.opengl.GL11;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.handlers.ClientEventHandler;
import com.parzivail.util.Animation;
import com.parzivail.util.ui.GlPalette;

import net.minecraft.util.Vec3;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class AnimationCrosshairClose extends Animation
{
	int color;
	
	public AnimationCrosshairClose(int color)
	{
		super(8, false, true);
		ClientEventHandler.isCursorAnim = true;
		this.color = color;
	}

	@Override
	public void render(RenderGameOverlayEvent event)
	{
		super.render(event);

		ClientEventHandler.pgui.drawFancyCursor(event, this.tick / (float)this.length, this.color);
	}

	@Override
	public void tick()
	{
		super.tick();
		if (this.tick == this.length)
		{
			ClientEventHandler.isCursorAnim = false;
			ClientEventHandler.cursorOpen = false;
		}
	}
}
