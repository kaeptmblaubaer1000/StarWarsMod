package com.parzi.starwarsmod.sound;

import net.minecraft.client.audio.MovingSound;
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
		this.follow = follow;
	}

	@Override
	public void update()
	{
		if (this.follow != null && this.follow.worldObj != null && this.follow.inventory.getCurrentItem() != null && this.follow.inventory.getCurrentItem().getItem() == StarWarsMod.lightsaber)
		{
			this.xPosF = (float)this.follow.posX;
			this.yPosF = (float)this.follow.posY;
			this.zPosF = (float)this.follow.posZ;
			this.volume = 1;
		}
		else
			this.volume = 0;
	}
}
