package com.parzi.starwarsmod.rendering.gui;

import java.awt.Point;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.handlers.ClientEventHandler;
import com.parzi.util.Animation;
import com.parzi.util.ui.GlPalette;

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
