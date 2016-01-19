package com.parzivail.pswm.sound;

import com.parzivail.pswm.Resources;

import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class SoundSFoil extends MovingSound
{
	private final EntityPlayer player;

	public SoundSFoil(EntityPlayer player, boolean opening)
	{
		super(new ResourceLocation(Resources.MODID, opening ? "vehicle.xwing.sfoilOpen" : "vehicle.xwing.sfoilClose"));
		this.player = player;
		this.field_147666_i = ISound.AttenuationType.NONE;
		this.repeat = false;
		this.field_147665_h = 0;
		this.volume = 1.0F;
	}

	/**
	 * Updates the JList with a new model.
	 */
	@Override
	public void update()
	{
	}
}