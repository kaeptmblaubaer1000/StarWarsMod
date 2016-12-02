package com.parzivail.pswm.gui;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.math.Animation;
import com.parzivail.util.ui.GFX;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

/**
 * Created by Colby on 12/2/2016.
 */
public class AnimationScrambleText extends Animation
{
	private String text;
	private float x;
	private float y;
	private float scale;
	private int color;

	public char[] randomChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
	private int lastTick;
	private char c;

	public AnimationScrambleText(String text, float x, float y, float scale, int color, int ticksPerChar)
	{
		super(ticksPerChar * text.length(), false, true);
		this.text = text;
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.color = color;

		c = getRandomChar();
	}

	private char getRandomChar()
	{
		return randomChars[(int)Math.floor(Math.random() * randomChars.length)];
	}

	@Override
	public void render(RenderGameOverlayEvent event)
	{
		super.render(event);

		String newText = text.substring(0, (int)Math.floor(tick / (float)length * text.length()));

		if (lastTick != tick)
			c = getRandomChar();

		newText += c;

		GFX.drawText(StarWarsMod.mc.fontRenderer, newText, x, y, scale, color);

		lastTick = tick;
	}
}