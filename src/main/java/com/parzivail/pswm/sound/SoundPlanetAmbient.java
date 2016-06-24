package com.parzivail.pswm.sound;

import com.parzivail.pswm.Resources;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;

public class SoundPlanetAmbient extends MovingSound
{
	private EntityPlayer player;

	public static HashMap<Integer, String> ambiences = new HashMap<>();

	static
	{
		ambiences.put(Resources.ConfigOptions.dimTatooineId, "ambient.planet.desert");
		ambiences.put(Resources.ConfigOptions.dimHothId, "ambient.planet.tundra");
		ambiences.put(Resources.ConfigOptions.dimKashyyykId, "ambient.planet.forest");
		ambiences.put(Resources.ConfigOptions.dimYavin4Id, "ambient.planet.jungle");
		ambiences.put(Resources.ConfigOptions.dimEndorId, "ambient.planet.forest");
		ambiences.put(Resources.ConfigOptions.dimIlumId, "ambient.planet.tundra");
		ambiences.put(Resources.ConfigOptions.dimDagobahId, "ambient.planet.swamp");
		ambiences.put(Resources.ConfigOptions.dimMustafarId, "ambient.planet.desert");
	}

	public SoundPlanetAmbient(EntityPlayer player)
	{
		super(new ResourceLocation(Resources.MODID, ambiences.get(player.worldObj.provider.dimensionId)));
		this.player = player;
		this.field_147666_i = AttenuationType.NONE;
		this.repeat = true;
		this.field_147665_h = 0; // repeat delay
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