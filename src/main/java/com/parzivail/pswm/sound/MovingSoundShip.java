package com.parzivail.pswm.sound;

import com.parzivail.util.driven.Pilotable;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by colby on 1/19/2017.
 */
@SideOnly(Side.CLIENT)
public class MovingSoundShip extends MovingSound
{
	private final EntityPlayer player;
	private final Pilotable ship;
	private final boolean basedOnMotion;

	public MovingSoundShip(EntityPlayer playerRiding, Pilotable ship, SoundEvent sound, boolean loop, boolean basedOnMotion)
	{
		super(sound, SoundCategory.MASTER);
		this.player = playerRiding;
		this.ship = ship;
		this.basedOnMotion = basedOnMotion;
		this.attenuationType = ISound.AttenuationType.NONE;
		this.repeat = loop;
		this.repeatDelay = 0;
	}

	/**
	 * Like the old updateEntity(), except more generic.
	 */
	public void update()
	{
		if (!this.ship.isDead && this.player.isRiding() && this.player.getRidingEntity() == this.ship)
		{
			float f = (float)(this.ship.motionX * this.ship.motionX + this.ship.motionY * this.ship.motionY + this.ship.motionZ * this.ship.motionZ);

			if (basedOnMotion)
			{
				if (f >= 0.1f)
				{
					this.volume = 0.0F + MathHelper.clamp(f / 5f, 0.0F, 1.0F) * 0.75F;
				}
				else
				{
					this.volume = 0.0F;
				}
			}
			else
				volume = 1;
		}
		else
		{
			this.donePlaying = true;
		}
	}
}