package com.parzi.starwarsmod.sound;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.audio.SoundManager;
import cpw.mods.fml.relauncher.ReflectionHelper;

public class PSoundBank
{
	public static MovingSound lightsaberHum;
	public static MovingSound shipAlarm;
	private SoundHandler handler;
	private SoundManager manager;

	public PSoundBank()
	{
		this.handler = Minecraft.getMinecraft().getSoundHandler();
		this.manager = ReflectionHelper.getPrivateValue(SoundHandler.class, this.handler, "sndManager");
	}

	public boolean isPlaying(ISound sound)
	{
		return this.manager.isSoundPlaying(sound);
	}

	public void play(ISound sound)
	{
		if (this.isPlaying(sound))
			this.handler.stopSound(sound);
		this.handler.playSound(sound);
	}

	public void playIfNotAlready(ISound sound)
	{
		if (!this.isPlaying(sound))
			this.handler.playSound(sound);
	}

	public void stop(ISound sound)
	{
		if (this.isPlaying(sound))
			this.handler.stopSound(sound);
	}
}
