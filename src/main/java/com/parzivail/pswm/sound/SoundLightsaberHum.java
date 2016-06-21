package com.parzivail.pswm.sound;

import com.parzivail.pswm.Resources;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class SoundLightsaberHum extends MovingSound
{
	private final EntityPlayer player;

	public SoundLightsaberHum(EntityPlayer player)
	{
		super(new ResourceLocation(Resources.MODID, "item.lightsaber.hum"));
		this.player = player;
		this.field_147666_i = ISound.AttenuationType.NONE;
		this.repeat = true;
		this.field_147665_h = 0;
		this.volume = 1.0F;
	}

	/**
	 * Updates the JList with a new model.
	 */
	@Override
	public void update()
	{
		// if (!(this.ship.inventory != null &&
		// this.ship.inventory.getCurrentItem() != null &&
		// (this.ship.inventory.getCurrentItem().getItem() ==
		// StarWarsMod.lightsaber ||
		// this.ship.inventory.getCurrentItem().getItem() ==
		// StarWarsMod.sequelLightsaber)))
		// this.donePlaying = true;
	}
}