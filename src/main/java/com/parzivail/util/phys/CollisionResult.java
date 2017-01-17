package com.parzivail.util.phys;

import com.parzivail.util.lwjgl.Vector3f;

/**
 * Created by colby on 1/16/2017.
 */
public class CollisionResult
{
	public static final CollisionResult NO_COLLISION = new CollisionResult(false, null);
	public boolean collides;
	public Vector3f collisionVector;

	public CollisionResult(boolean collides, Vector3f collisionVector)
	{
		this.collides = collides;
		this.collisionVector = collisionVector;
	}
}
