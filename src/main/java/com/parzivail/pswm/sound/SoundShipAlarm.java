package com.parzivail.pswm.sound;

import com.parzivail.pswm.Resources;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class SoundShipAlarm extends MovingSound
{
	private final EntityPlayer player;

	public SoundShipAlarm(EntityPlayer player)
	{
		super(new ResourceLocation(Resources.MODID, "vehicle.alarm.loop"));
		this.player = player;
		this.field_147666_i = ISound.AttenuationType.NONE;
		this.repeat = true;
		this.field_147665_h = 0; // repeat delay
	}

	/**
	 * Updates the JList with a new model.
	 */
	@Override
	public void update()
	{
		this.donePlaying = true;
	}
}