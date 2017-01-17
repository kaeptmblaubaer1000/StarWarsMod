package com.parzivail.util.phys;

import com.parzivail.util.lwjgl.Vector3f;

/**
 * Created by colby on 1/16/2017.
 */
public class PhysConstraint
{
	private float restDistance;
	public PhysParticle p1;
	public PhysParticle p2;

	public PhysConstraint(PhysParticle p1, PhysParticle p2)
	{
		this.p1 = p1;
		this.p2 = p2;
		Vector3f vec = Vector3f.sub(p1.getPos(), p2.getPos(), null);
		this.restDistance = vec.length();
	}

	public void satisfyConstraint()
	{
		Vector3f p1ToP2 = Vector3f.sub(p2.getPos(), p1.getPos(), null);
		float currentDistance = p1ToP2.length();
		Vector3f correctionVector = new Vector3f(p1ToP2);
		correctionVector.scale(1 - restDistance / currentDistance);

		Vector3f correctionVectorHalf = new Vector3f(correctionVector);
		correctionVectorHalf.scale(0.5f);
		p1.offsetPos(correctionVectorHalf);
		correctionVectorHalf.scale(-1);
		p2.offsetPos(correctionVectorHalf);
	}
}
