package com.parzivail.pswm.gui;

import com.parzivail.util.math.Animation;
import net.minecraft.client.gui.FontRenderer;

/**
 * Created by Colby on 12/2/2016.
 */
public class TextScramble extends Text
{
	private String originalText;
	private Animation scrambleAnim;
	private boolean isScrambling;

	public char[] randomChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();

	private int lastTick;
	private char c;

	public TextScramble(FontRenderer font, String text, float x, float y, float scale, int color, int options, int ticksPerChar)
	{
		super(font, text, x, y, scale, color, options);
		this.originalText = text;

		scrambleAnim = new Animation(ticksPerChar * text.length(), false, false);
		scrambleAnim.setOnAnimationEnd(animation ->
		{
			isScrambling = false;
			animation.reset();
		});
	}

	public void scramble()
	{
		if (isScrambling)
			scrambleAnim.stop();
		isScrambling = true;
		scrambleAnim.start();
	}

	private char getRandomChar()
	{
		return randomChars[(int)Math.floor(Math.random() * randomChars.length)];
	}

	public void render()
	{
		if (isScrambling)
		{
			String newText = originalText.substring(0, (int)Math.floor(scrambleAnim.getTick() / (float)scrambleAnim.getLength() * originalText.length()));

			if (lastTick != scrambleAnim.getTick())
				c = getRandomChar();

			newText += c;

			drawText(newText);

			lastTick = scrambleAnim.getTick();
		}
		else
		{
			this.setText(this.originalText);
			super.render();
		}
	}

	public void setTicksPerChar(int ticksPerChar)
	{
		scrambleAnim.setLength(ticksPerChar * originalText.length());
	}

	@Override
	public void setText(String text)
	{
		super.setText(text);
		this.originalText = text;
	}

	public Animation getAnimation()
	{
		return scrambleAnim;
	}
}
