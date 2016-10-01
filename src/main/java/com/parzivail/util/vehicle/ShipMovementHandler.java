package com.parzivail.util.vehicle;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.math.MathUtils;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;

/**
 * Created by colby on 9/30/2016.
 */
public class ShipMovementHandler
{
	public Vec3 velocity;
	public Vec3 rotation;
	private StarshipBase ship;
	private static final GameSettings settings = StarWarsMod.mc.gameSettings;

	public ShipMovementHandler(StarshipBase ship)
	{
		velocity = Vec3.createVectorHelper(0, 0, 0);
		rotation = Vec3.createVectorHelper(0, 0, 0);

		this.ship = ship;
	}

	void handleMovement()
	{
		if ($(settings.keyBindForward))
		{
			velocity = MathUtils.multiply(velocity, MathUtils.multiply(rotation, 0.01f));
		}

		if (ship.riddenByEntity instanceof EntityPlayer)
		{
			rotation = ship.riddenByEntity.getLookVec();
		}
	}

	/**
	 * Returns true if the specified key is pressed. Yes, I'm lazy.
	 *
	 * @param keyBinding The key to query
	 * @return True if the key is pressed
	 */
	private static boolean $(KeyBinding keyBinding)
	{
		return keyBinding.getIsKeyPressed();
	}
}
