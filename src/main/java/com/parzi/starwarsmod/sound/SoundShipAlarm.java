package com.parzi.starwarsmod.sound;

import net.minecraft.client.audio.ISound;
import net.minecraft.util.ResourceLocation;

import com.parzi.starwarsmod.StarWarsMod;

public class SoundShipAlarm implements ISound
{
	public SoundShipAlarm()
	{
	}

	@Override
	public boolean canRepeat()
	{
		return true;
	}

	@Override
	public AttenuationType getAttenuationType()
	{
		return AttenuationType.NONE;
	}

	@Override
	public float getPitch()
	{
		return 1;
	}

	@Override
	public ResourceLocation getPositionedSoundLocation()
	{
		return new ResourceLocation(StarWarsMod.MODID, "vehicle.alarm.loop1");
	}

	@Override
	public int getRepeatDelay()
	{
		return 0;
	}

	@Override
	public float getVolume()
	{
		return 1;
	}

	@Override
	public float getXPosF()
	{
		return 0;
	}

	@Override
	public float getYPosF()
	{
		return 0;
	}

	@Override
	public float getZPosF()
	{
		return 0;
	}
}
