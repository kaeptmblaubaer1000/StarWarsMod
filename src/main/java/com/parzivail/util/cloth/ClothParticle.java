package com.parzivail.util.cloth;

import com.parzivail.util.lwjgl.Vector3f;

/**
 * Created by colby on 1/16/2017.
 */
public class ClothParticle
{
	private final ClothSettings settings;

	private boolean movable;
	private float mass;
	private Vector3f pos;
	private Vector3f oldPos;
	private Vector3f acceleration;
	private Vector3f accumulatedNormal;

	public ClothParticle(ClothSettings settings, Vector3f pos)
	{
		this.settings = settings;
		this.pos = new Vector3f(pos);
		this.oldPos = new Vector3f(pos);
		this.acceleration = new Vector3f(0, 0, 0);
		this.mass = 1;
		this.movable = true;
		this.accumulatedNormal = new Vector3f(0, 0, 0);
	}

	public void addForce(Vector3f f)
	{
		Vector3f force = new Vector3f(f);
		force.scale(1 / mass);
		Vector3f.add(acceleration, force, acceleration);
	}

	void timeStep()
	{
		if (movable)
		{
			Vector3f temp = new Vector3f(pos);
			// (pos-old_pos)*(1.0-DAMPING) + acceleration*TIME_STEPSIZE2
			Vector3f deltaPos = Vector3f.sub(pos, oldPos, null);
			deltaPos.scale(1f - settings.damping);
			Vector3f accelTimeStep = new Vector3f(acceleration);
			accelTimeStep.scale(settings.timeStepSize2);
			Vector3f.add(pos, Vector3f.add(deltaPos, accelTimeStep, null), pos);
			oldPos = temp;
			acceleration = new Vector3f(0, 0, 0);
		}
	}

	public Vector3f getPos()
	{
		return pos;
	}

	public void resetAceleration()
	{
		acceleration = new Vector3f(0, 0, 0);
	}

	public void offsetPos(Vector3f v)
	{
		if (movable)
			Vector3f.add(pos, v, pos);
	}

	public void setMovable(boolean movable)
	{
		this.movable = movable;
	}

	public void addToNormal(Vector3f normal)
	{
		Vector3f.add(accumulatedNormal, normal.normalise(null), accumulatedNormal);
	}

	public Vector3f getNormal()
	{
		return accumulatedNormal;
	}

	public void resetNormal()
	{
		this.accumulatedNormal = new Vector3f(0, 0, 0);
	}

	public CollisionResult getSceneCollision()
	{
		if (this.pos.z >= 0)
			return new CollisionResult(true, new Vector3f(0, 0, -this.pos.z));
		return CollisionResult.NO_COLLISION;
	}
}
