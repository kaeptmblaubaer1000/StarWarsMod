package com.parzi.starwarsmod.sound;

import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.vehicles.VehicleAirBase;

public class SoundFlyingVehicle extends MovingSound
{
	private final VehicleAirBase vehicle;

	public SoundFlyingVehicle(VehicleAirBase vehicle, String sound)
	{
		super(new ResourceLocation(StarWarsMod.MODID, sound));
		this.vehicle = vehicle;
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
		if ((!this.vehicle.wasMoving && !this.vehicle.nowMoving) || !(this.vehicle.riddenByEntity instanceof EntityPlayer) || vehicle.isDead)
			this.donePlaying = true;
	}
}