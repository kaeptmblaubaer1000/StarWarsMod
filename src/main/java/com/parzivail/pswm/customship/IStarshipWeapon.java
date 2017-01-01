package com.parzivail.pswm.customship;

import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by colby on 10/17/2016.
 */
public interface IStarshipWeapon extends IStarshipPart
{
	boolean canUse(EntityPlayer user);

	void use(EntityPlayer user);
}
