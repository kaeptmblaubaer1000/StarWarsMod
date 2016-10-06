package com.parzivail.util.vehicle;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.network.MessageStarshipUpdateMovement;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.Vec3;

/**
 * Created by colby on 9/30/2016.
 */
public class ShipMovementHandler
{
	private static final float PITCH_SPEED = 2;
	private static final float ROLL_SPEED = 5;
	private static final Vec3 EMPTY_VEC = Vec3.createVectorHelper(0, 0, 0);
	private static final double ROLL_DRAG = 0.8;
	private static final double PITCH_DRAG = 0.8;
	public Vec3 velocity;
	public Vec3 rotVel;

	private StarshipBase ship;

	private static final GameSettings settings = StarWarsMod.mc.gameSettings;

	public ShipMovementHandler(StarshipBase ship)
	{
		this.ship = ship;
		velocity = Vec3.createVectorHelper(0, 0, 0);
		rotVel = Vec3.createVectorHelper(0, 0, 0);
	}

	@SideOnly(Side.CLIENT)
	void handleMovement()
	{
		if ($(settings.keyBindForward) && ship.riddenByEntity == StarWarsMod.mc.thePlayer)
			this.rotVel.zCoord += PITCH_SPEED; // No, I don't know why these are backwards. Don't ask.

		if ($(settings.keyBindBack) && ship.riddenByEntity == StarWarsMod.mc.thePlayer)
			this.rotVel.zCoord -= PITCH_SPEED;

		if ($(settings.keyBindLeft) && ship.riddenByEntity == StarWarsMod.mc.thePlayer)
			this.rotVel.xCoord -= ROLL_SPEED;

		if ($(settings.keyBindRight) && ship.riddenByEntity == StarWarsMod.mc.thePlayer)
			this.rotVel.xCoord += ROLL_SPEED;
	}

	void tick()
	{
		this.rotVel.xCoord *= ROLL_DRAG;
		this.rotVel.zCoord *= PITCH_DRAG;

		if (Math.abs(this.rotVel.xCoord) < 0.01f) // Actually roll
			this.rotVel.xCoord = 0;
		else ship.rotatePitch((float)this.rotVel.xCoord);

		if (Math.abs(this.rotVel.zCoord) < 0.01f) // Actually pitch
			this.rotVel.zCoord = 0;
		else ship.rotateRoll((float)this.rotVel.zCoord);

		if (this.ship.worldObj.isRemote)
		{
			StarWarsMod.network.sendToServer(new MessageStarshipUpdateMovement(this.ship));
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
