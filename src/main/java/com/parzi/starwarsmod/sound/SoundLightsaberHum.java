package com.parzi.starwarsmod.sound;

import net.minecraft.client.audio.MovingSound;
import net.minecraft.client.audio.MovingSoundMinecart;
import net.minecraft.client.audio.MovingSoundMinecartRiding;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import com.parzi.starwarsmod.StarWarsMod;

public class SoundLightsaberHum extends MovingSound
{
	EntityPlayer follow;

	public SoundLightsaberHum(EntityPlayer follow)
	{
		super(new ResourceLocation(StarWarsMod.MODID, "item.lightsaber.hum"));
		this.repeat = true;
	}

	@Override
	public void update()
	{
		if (follow != null && follow.worldObj != null && follow.inventory.getCurrentItem() != null && follow.inventory.getCurrentItem().getItem() == StarWarsMod.lightsaber)
		{
			this.xPosF = (float)follow.posX;
			this.yPosF = (float)follow.posY;
			this.zPosF = (float)follow.posZ;
			this.volume = 1;
		}
		else
		{
			this.volume = 0;
		}
	}
}
