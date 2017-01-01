package com.parzivail.util.driven;

import com.parzivail.util.lwjgl.Vector3f;

public class Seat
{
	/**
	 * The x, y and z positions of the seat within the plane in model co-ordinates
	 * x is forwards, y is up and z is left
	 */
	public int x, y, z;
	/**
	 * The id of this seat
	 */
	public int id;
	/**
	 * Limits for the look vector of the seat. Range is -360 to 360. Thus any range should lie in here without having to wrap
	 */
	public float minYaw = -360F, maxYaw = 360F;
	/**
	 * Limits for the look vector of the seat. Range is -90 to 90, but don't go beyond +/-89 or the view will mess up at the poles
	 */
	public float minPitch = -89F, maxPitch = 89F;
	/**
	 * For turret mounted seats on tanks, the seat will be positioned differently according to this offset and the yaw of the turret
	 */
	public Vector3f rotatedOffset = new Vector3f();

	/**
	 * Type file driver seat constructor. Line from type file should be of one of the following forms
	 * Driver x y z
	 * Pilot x y z
	 */
	public Seat(int dx, int dy, int dz)
	{
		id = 0;
		x = dx;
		y = dy;
		z = dz;
	}

	/**
	 * Type file driver seat constructor with yaw and pitch limiters
	 */
	public Seat(int dx, int dy, int dz, float yMin, float yMax, float pMin, float pMax)
	{
		id = 0;
		x = dx;
		y = dy;
		z = dz;
		minYaw = yMin;
		maxYaw = yMax;
		minPitch = pMin;
		maxPitch = pMax;
	}
}
