package com.parzi.starwarsmod.sound;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.client.audio.MovingSoundMinecartRiding;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.items.weapons.ItemLightsaber;

public class SoundSFoil extends MovingSound
{
    private final EntityPlayer player;

    public SoundSFoil(EntityPlayer player, boolean opening)
    {
        super(new ResourceLocation(StarWarsMod.MODID, opening ? "vehicle.xwing.sfoilOpen" : "vehicle.xwing.sfoilClose"));
        this.player = player;
        this.field_147666_i = ISound.AttenuationType.NONE;
        this.repeat = false;
        this.field_147665_h = 0;
        this.volume = 1.0F;
    }

    /**
     * Updates the JList with a new model.
     */
    public void update()
    {
    }
}