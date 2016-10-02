package com.parzivail.util.vehicle;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.network.MessageStarshipUpdateMovement;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import org.lwjgl.util.vector.Quaternion;

/**
 * Created by colby on 9/30/2016.
 */
public class ShipMovementHandler
{
	private static final double PITCH_SPEED = 1.25;
	private static final double ROLL_SPEED = 1.25;
	public Vec3 velocity;
	public Vec3 rotation;
	public Quaternion rotationQuat;

	private StarshipBase ship;

	private static final int DW_PITCH = 15;
	private static final int DW_ROLL = 16;

	private static final GameSettings settings = StarWarsMod.mc.gameSettings;

	public ShipMovementHandler(StarshipBase ship)
	{
		this.ship = ship;
	}

	void handleMovement()
	{
		checkVectors();

		if ($(settings.keyBindForward) && ship.riddenByEntity == StarWarsMod.mc.thePlayer)
		{
			rotation.xCoord += PITCH_SPEED;
		}

		if ($(settings.keyBindBack) && ship.riddenByEntity == StarWarsMod.mc.thePlayer) rotation.xCoord -= PITCH_SPEED;

		if ($(settings.keyBindLeft) && ship.riddenByEntity == StarWarsMod.mc.thePlayer) rotation.zCoord += ROLL_SPEED;

		if ($(settings.keyBindRight) && ship.riddenByEntity == StarWarsMod.mc.thePlayer) rotation.zCoord -= ROLL_SPEED;

		rotation.xCoord = MathHelper.clamp_double(rotation.xCoord, -90, 90);

		if (this.ship.worldObj.isRemote)
			StarWarsMod.network.sendToServer(new MessageStarshipUpdateMovement(this.ship, rotation, velocity));
	}

	private void checkVectors()
	{
		if (velocity == null)
		{
			velocity = Vec3.createVectorHelper(0, 0, 0);
		}

		if (rotation == null)
		{
			rotation = Vec3.createVectorHelper(0, 0, 0);
		}

		if (rotationQuat == null)
		{
			rotationQuat = new Quaternion(0, 0, 0, 0);
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
		this.rotation.xCoord = nbt.getDouble("rX");
		this.rotation.yCoord = nbt.getDouble("rZ");
		this.rotation.zCoord = nbt.getDouble("rY");

		this.velocity.xCoord = nbt.getDouble("vX");
		this.velocity.yCoord = nbt.getDouble("vY");
		this.velocity.zCoord = nbt.getDouble("vZ");
	}

	public void saveMovement(NBTTagCompound nbt)
	{
		checkVectors();
		nbt.setDouble("rX", this.rotation.xCoord);
		nbt.setDouble("rY", this.rotation.yCoord);
		nbt.setDouble("rZ", this.rotation.zCoord);

		nbt.setDouble("vX", this.velocity.xCoord);
		nbt.setDouble("vY", this.velocity.yCoord);
		nbt.setDouble("vZ", this.velocity.zCoord);
	}
}
