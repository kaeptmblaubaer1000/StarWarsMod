package com.parzi.starwarsmod.sound;

import com.parzi.util.ui.Lumberjack;

import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.audio.SoundManager;

public class PSoundBank
{
	public static MovingSound lightsaberHum;
	public static MovingSound shipAlarm;
	private SoundHandler handler;
	public SoundManager manager;

	public PSoundBank()
	{
		this.handler = Minecraft.getMinecraft().getSoundHandler();
		try
		{
			this.manager = ReflectionHelper.getPrivateValue(SoundHandler.class, this.handler, "sndManager");
		}
		catch (Exception e)
		{
			Lumberjack.warn("Unable to hook Sound Manager! There will not be ambient sounds.");
			e.printStackTrace();
		}
	}

	public boolean isPlaying(ISound sound)
	{
		if (this.manager == null)
			return false;
		return this.manager.isSoundPlaying(sound);
	}

	public void play(ISound sound)
	{
		if (this.manager == null)
			return;
		if (this.isPlaying(sound))
			this.handler.stopSound(sound);
		this.handler.playSound(sound);
	}

	public void playIfNotAlready(ISound sound)
	{
		if (this.manager == null)
			return;
		if (!this.isPlaying(sound))
			this.handler.playSound(sound);
	}

	public void stop(ISound sound)
	{
		if (this.manager == null)
			return;
		if (this.isPlaying(sound))
			this.handler.stopSound(sound);
	}
}
