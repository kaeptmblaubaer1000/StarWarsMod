package com.parzivail.util.driven;

import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by colby on 10/17/2016.
 */
public interface IStarshipWeapon
{
	boolean canUse(EntityPlayer user);

	void use(EntityPlayer user);
}
