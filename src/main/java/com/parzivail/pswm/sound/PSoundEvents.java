package com.parzivail.pswm.sound;

import com.parzivail.pswm.Resources;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by colby on 1/19/2017.
 */
public class PSoundEvents
{
	public static SoundEvent XWING_INTERIOR_LOOP;

	/**
	 * Register the {@link SoundEvent}s.
	 */
	public static void registerSounds()
	{
		XWING_INTERIOR_LOOP = registerSound("loop.engine.xwing");
	}

	/**
	 * Register a {@link SoundEvent}.
	 *
	 * @param soundName The SoundEvent's name without the testmod3 prefix
	 * @return The SoundEvent
	 */
	private static SoundEvent registerSound(String soundName)
	{
		final ResourceLocation soundID = new ResourceLocation(Resources.MODID, soundName);
		return GameRegistry.register(new SoundEvent(soundID).setRegistryName(soundID));
	}
}
