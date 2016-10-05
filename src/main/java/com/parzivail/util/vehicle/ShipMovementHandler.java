package com.parzivail.util.vehicle;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.network.MessageStarshipUpdateMovement;
import com.parzivail.util.math.RotatedAxes;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Vec3;

/**
 * Created by colby on 9/30/2016.
 */
public class ShipMovementHandler
{
	private static final float PITCH_SPEED = 4;
	private static final float ROLL_SPEED = 4;
	private static final Vec3 EMPTY_VEC = Vec3.createVectorHelper(0, 0, 0);
	public Vec3 velocity;

	private StarshipBase ship;

	private static final GameSettings settings = StarWarsMod.mc.gameSettings;
	public RotatedAxes rotatedAxes;

	public ShipMovementHandler(StarshipBase ship)
	{
		this.ship = ship;
		this.rotatedAxes = new RotatedAxes(0, 0, 0);
	}

	void handleMovement()
	{
		checkVectors();

		if ($(settings.keyBindForward) && ship.riddenByEntity == StarWarsMod.mc.thePlayer)
			ship.rotateRoll(PITCH_SPEED); // No, I don't know why these are backwards. Don't ask.

		if ($(settings.keyBindBack) && ship.riddenByEntity == StarWarsMod.mc.thePlayer) ship.rotateRoll(-PITCH_SPEED);

		if ($(settings.keyBindLeft) && ship.riddenByEntity == StarWarsMod.mc.thePlayer) ship.rotatePitch(ROLL_SPEED);

		if ($(settings.keyBindRight) && ship.riddenByEntity == StarWarsMod.mc.thePlayer) ship.rotatePitch(-ROLL_SPEED);

		if (this.ship.worldObj.isRemote)
			StarWarsMod.network.sendToServer(new MessageStarshipUpdateMovement(this.ship, EMPTY_VEC, velocity));
	}

	private void checkVectors()
	{
		if (velocity == null)
		{
			velocity = Vec3.createVectorHelper(0, 0, 0);
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

	public void loadMovement(NBTTagCompound nbt)
	{
		checkVectors();

		this.velocity.xCoord = nbt.getDouble("vX");
		this.velocity.yCoord = nbt.getDouble("vY");
		this.velocity.zCoord = nbt.getDouble("vZ");
	}

	public void saveMovement(NBTTagCompound nbt)
	{
		checkVectors();

		nbt.setDouble("vX", this.velocity.xCoord);
		nbt.setDouble("vY", this.velocity.yCoord);
		nbt.setDouble("vZ", this.velocity.zCoord);
	}
}
