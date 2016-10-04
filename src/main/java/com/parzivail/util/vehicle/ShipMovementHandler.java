package com.parzivail.util.vehicle;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.network.MessageStarshipUpdateMovement;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Quaternion;

/**
 * Created by colby on 9/30/2016.
 */
public class ShipMovementHandler
{
	private static final double PITCH_SPEED = 4;
	private static final double ROLL_SPEED = 4;
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
		rotation.zCoord = MathHelper.wrapAngleTo180_double(rotation.zCoord);

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

	public void applyRotations()
	{
		Vec3 left = Vec3.createVectorHelper(0, 0, 0);
		Vec3 up = Vec3.createVectorHelper(0, 0, 0);
		Vec3 forward = Vec3.createVectorHelper(0, 0, 0);

		anglesToAxes(rotation, left, up, forward);

		GL11.glRotated(rotation.xCoord, left.xCoord, left.yCoord, left.zCoord);
		GL11.glRotated(rotation.yCoord, up.xCoord, up.yCoord, up.zCoord);
		GL11.glRotated(rotation.zCoord, forward.xCoord, forward.yCoord, forward.zCoord);
	}

	void anglesToAxes(Vec3 angles, Vec3 left, Vec3 up, Vec3 forward)
	{
		float DEG2RAD = 3.141593f / 180f;
		float sx, sy, sz, cx, cy, cz, theta;

		// rotation angle about X-axis (pitch)
		theta = (float)(angles.xCoord * DEG2RAD);
		sx = MathHelper.sin(theta);
		cx = MathHelper.cos(theta);

		// rotation angle about Y-axis (yaw)
		theta = (float)(angles.yCoord * DEG2RAD);
		sy = MathHelper.sin(theta);
		cy = MathHelper.cos(theta);

		// rotation angle about Z-axis (roll)
		theta = (float)(angles.zCoord * DEG2RAD);
		sz = MathHelper.sin(theta);
		cz = MathHelper.cos(theta);

		// determine left axis
		left.xCoord = cy * cz;
		left.yCoord = sx * sy * cz + cx * sz;
		left.zCoord = -cx * sy * cz + sx * sz;

		// determine up axis
		up.xCoord = -cy * sz;
		up.yCoord = -sx * sy * sz + cx * cz;
		up.zCoord = cx * sy * sz + sx * cz;

		// determine forward axis
		forward.xCoord = sy;
		forward.yCoord = -sx * cy;
		forward.zCoord = cx * cy;
	}

	public double getPitch()
	{
		return rotation.xCoord;
	}

	public double getRoll()
	{
		return rotation.zCoord;
	}

	public double getPitchRad()
	{
		return Math.toRadians(rotation.xCoord);
	}

	public double getRollRad()
	{
		return Math.toRadians(rotation.zCoord);
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
