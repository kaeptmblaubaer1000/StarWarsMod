package com.parzivail.util.math;

import com.parzivail.util.lwjgl.Vector3f;

/**
 * Created by Colby on 5/15/2016.
 */
public class FPoint
{
	public float x, y, z;

	/**
	 * Creates a new 2D point in space
	 *
	 * @param x The x coordinate
	 * @param y The y coordinate
	 */
	public FPoint(float x, float y)
	{
		this.x = x;
		this.y = y;
		this.z = 0;
	}

	/**
	 * Creates a new 3D point in space
	 *
	 * @param x The x coordinate
	 * @param y The y coordinate
	 */
	public FPoint(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Creates a new 3D point in space
	 *
	 * @param vector3f The vector to clone
	 */
	public FPoint(Vector3f vector3f)
	{
		this.x = vector3f.x;
		this.y = vector3f.y;
		this.z = vector3f.z;
	}
}
