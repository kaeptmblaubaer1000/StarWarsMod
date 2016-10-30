package com.parzivail.pswm.customship;

/**
 * Created by colby on 10/25/2016.
 */
public abstract class SPhysicalWeapon implements IStarshipWeapon
{
	public enum Type
	{
		MISSILE, // Guided and tracking
		TORPEDO, // Straight shot
		HARPOON, // Hooks onto stuff
		BOMB // Straight down
	}

	public abstract SPhysicalWeapon.Type getType();
}
