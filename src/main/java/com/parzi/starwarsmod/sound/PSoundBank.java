package com.parzi.starwarsmod.sound;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.client.audio.SoundHandler;
import cpw.mods.fml.relauncher.ReflectionHelper;

public class PSoundBank
{
	public static MovingSound lightsaberHum;
	public static MovingSound shipAlarm;
	private SoundHandler handler;

	public PSoundBank()
	{
		handler = ReflectionHelper.getPrivateValue(Minecraft.class, Minecraft.getMinecraft(), "mcSoundHandler");

		lightsaberHum = new SoundLightsaberHum(Minecraft.getMinecraft().thePlayer);
		shipAlarm = new SoundShipAlarm(Minecraft.getMinecraft().thePlayer);
	}

	public boolean isPlaying(ISound sound)
	{
		return handler.isSoundPlaying(sound);
	}

	public void play(ISound sound)
	{
		if (handler.isSoundPlaying(sound))
			handler.stopSound(sound);
		handler.playSound(sound);
	}

	public void playIfNotAlready(ISound sound)
	{
		if (!handler.isSoundPlaying(sound))
			handler.playSound(sound);
	}

	public void stop(ISound sound)
	{
		if (handler.isSoundPlaying(sound))
			handler.stopSound(sound);
	}
}
