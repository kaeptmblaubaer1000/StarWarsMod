package com.parzi.starwarsmod.sound;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.parzi.starwarsmod.utils.Lumberjack;
import com.sun.javafx.collections.MappingChange.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.client.audio.MovingSoundMinecartRiding;
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
		handler = Minecraft.getMinecraft().getSoundHandler();
		manager = ReflectionHelper.getPrivateValue(SoundHandler.class, handler, "sndManager");
	}

	public boolean isPlaying(ISound sound)
	{
		return manager.isSoundPlaying(sound);
	}

	public void play(ISound sound)
	{
		if (isPlaying(sound))
			handler.stopSound(sound);
		handler.playSound(sound);
	}

	public void playIfNotAlready(ISound sound)
	{
		if (!isPlaying(sound))
			handler.playSound(sound);
	}

	public void stop(ISound sound)
	{
		if (isPlaying(sound))
			handler.stopSound(sound);
	}
}
