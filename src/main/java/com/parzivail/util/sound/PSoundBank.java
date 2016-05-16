package com.parzivail.util.sound;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.SoundHandler;

/**
 * A class to help control sounds because Minecraft's system sucks.
 */
public class PSoundBank
{
	private SoundHandler handler;

	/**
	 * Creates a new PSoundBank
	 */
	public PSoundBank()
	{
		this.handler = Minecraft.getMinecraft().getSoundHandler();
	}

	/**
	 * Gets whether or not a sound is playing
	 *
	 * @param sound The sound to check
	 * @return True if the sound is playing, false otherwise
	 */
	public boolean isPlaying(ISound sound)
	{
		return this.handler.isSoundPlaying(sound);
	}

	/**
	 * Plays a sound regardless of whether or not the sound is already playing
	 *
	 * @param sound The sound to play
	 */
	public void play(ISound sound)
	{
		if (this.isPlaying(sound))
			this.handler.stopSound(sound);
		this.handler.playSound(sound);
	}

	/**
	 * Plays a sound only if it is not already playing
	 *
	 * @param sound The sound to play
	 */
	public void playIfNotAlready(ISound sound)
	{
		if (!this.isPlaying(sound))
			this.handler.playSound(sound);
	}

	/**
	 * Stops a sound, only if it is playing
	 *
	 * @param sound The sound to stop
	 */
	public void stop(ISound sound)
	{
		if (this.isPlaying(sound))
			this.handler.stopSound(sound);
	}
}
