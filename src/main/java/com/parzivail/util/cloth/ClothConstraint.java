package com.parzivail.util.cloth;

import com.parzivail.util.lwjgl.Vector3f;

/**
 * Created by colby on 1/16/2017.
 */
public class ClothConstraint
{
	private float restDistance;
	public ClothParticle p1;
	public ClothParticle p2;

	public ClothConstraint(ClothParticle p1, ClothParticle p2)
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
