package com.parzi.starwarsmod.sound;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.mobs.MobBith;

import net.minecraft.client.audio.ISound;
import net.minecraft.util.ResourceLocation;


public class SoundCantina implements ISound
{
	private MobBith player;

	public SoundCantina(MobBith player)
	{
		this.player = player;
	}

	@Override
	public ResourceLocation getPositionedSoundLocation()
	{
		return new ResourceLocation(StarWarsMod.MODID, "item.records.Cantina");
	}

	@Override
	public boolean canRepeat()
	{
		return true;
	}

	@Override
	public int getRepeatDelay()
	{
		return 5;
	}

	@Override
	public float getVolume()
	{
		return 1;
	}

	@Override
	public float getPitch()
	{
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public float getXPosF()
	{
		return (float)player.posX;
	}

	@Override
	public float getYPosF()
	{
		return (float)player.posY;
	}

	@Override
	public float getZPosF()
	{
		return (float)player.posZ;
	}

	@Override
	public AttenuationType getAttenuationType()
	{
		return AttenuationType.LINEAR;
	}

}
