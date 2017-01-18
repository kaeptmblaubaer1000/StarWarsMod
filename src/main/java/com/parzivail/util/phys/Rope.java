package com.parzivail.util.phys;

import com.parzivail.util.lwjgl.Vector3f;
import com.parzivail.util.ui.GFX;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

/**
 * Created by colby on 1/16/2017.
 */
public class Rope extends PhysObject
{
	private int resolution;

	public Rope(LocalPhysSettings settings, Vector3f start, Vector3f end, int resolution)
	{
		super(settings);

		if (resolution < 2)
			throw new IllegalArgumentException("Resolution must be 2 or greater!");

		this.resolution = resolution;

		particles = new PhysParticle[resolution];
		constraints = new ArrayList<>();

		for (int i = 0; i < resolution; i++)
		{
			Vector3f p = Vector3f.lerp(start, end, i / (float)resolution);
			particles[i] = new PhysParticle(settings, p);

			if (i > 0)
				constraints.add(new PhysConstraint(particles[i - 1], particles[i]));
		}

		particles[0].setMovable(false);
		particles[1].setMovable(false);
	}

	public void drawShaded()
	{
		GL11.glPushMatrix();
		GL11.glTranslatef(0, 1 / 16f, 0);
		GL11.glBegin(GL11.GL_LINE_STRIP);
		for (PhysConstraint c : constraints)
		{
			GFX.glVertex1v(c.p1.getPos());
			GFX.glVertex1v(c.p2.getPos());
		}
		GL11.glEnd();
		GL11.glPopMatrix();
	}
}
