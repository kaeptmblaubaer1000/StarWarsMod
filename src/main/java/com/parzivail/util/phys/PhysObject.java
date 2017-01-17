package com.parzivail.util.phys;

import com.parzivail.util.lwjgl.Vector3f;

import java.util.ArrayList;

/**
 * Created by colby on 1/17/2017.
 */
public class PhysObject
{
	final LocalPhysSettings settings;

	PhysParticle[] particles;
	ArrayList<PhysConstraint> constraints;

	public PhysObject(LocalPhysSettings settings)
	{
		this.settings = settings;
	}

	public void timeStep()
	{
		for (int i = 0; i < settings.constraintIterations; i++) // iterate over all constraints several times
		{
			for (PhysConstraint c : constraints)
				c.satisfyConstraint();
		}

		for (PhysParticle p : particles)
			p.timeStep();
	}

	public void addForce(Vector3f dir)
	{
		for (PhysParticle p : particles)
			p.addForce(dir);
	}

	public void checkCollision()
	{
		for (PhysParticle p : particles)
		{
			CollisionResult result = p.getSceneCollision();
			if (result.collides)
			{
				p.offsetPos(result.collisionVector);
			}
		}
	}
}
