package com.parzivail.pswm.sound;

import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;

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
		if (this.player.inventory.getCurrentItem() != null && this.player.inventory.getCurrentItem().getItem() == StarWarsMod.lightsaber)
		{
			float f = MathHelper.sqrt_double(this.player.motionX * this.player.motionX + this.player.motionZ * this.player.motionZ);

			if (f >= 0.01D)
				this.volume = 0.0F + MathHelper.clamp_float(f, 0.0F, 1.0F) * 0.75F;
			else
				this.volume = 0.0F;
		}
		else
			this.donePlaying = true;
	}
}