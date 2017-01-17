package com.parzivail.util.phys;

import com.parzivail.util.lwjgl.Vector3f;
import com.parzivail.util.ui.GFX;
import com.parzivail.util.ui.GLPalette;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

/**
 * Created by colby on 1/16/2017.
 */
public class Cloth extends PhysObject
{
	private int width;
	private int height;

	public Cloth(LocalPhysSettings settings, float width, float height, int resolutionX, int resolutionY)
	{
		super(settings);

		if (resolutionX < 2)
			throw new IllegalArgumentException("X Resolution must be 2 or greater!");
		if (resolutionY < 2)
			throw new IllegalArgumentException("Y Resolution must be 2 or greater!");

		this.width = resolutionX;
		this.height = resolutionY;

		particles = new PhysParticle[resolutionX * resolutionY];
		constraints = new ArrayList<>();

		// creating particles in a grid of particles from (0,0,0) to (width,-height,0)
		for (int x = 0; x < resolutionX; x++)
		{
			for (int y = 0; y < resolutionY; y++)
			{
				Vector3f pos = new Vector3f(width * (x / (float)resolutionX), -height * (y / (float)resolutionY), 0);
				particles[y * resolutionX + x] = new PhysParticle(settings, pos); // insert particle in column x at y'th row
			}
		}

		// Connecting immediate neighbor particles with constraints (distance 1 and sqrt(2) in the grid)
		for (int x = 0; x < resolutionX; x++)
		{
			for (int y = 0; y < resolutionY; y++)
			{
				if (x < resolutionX - 1)
					makeConstraint(getParticle(x, y), getParticle(x + 1, y));
				if (y < resolutionY - 1)
					makeConstraint(getParticle(x, y), getParticle(x, y + 1));
				if (x < resolutionX - 1 && y < resolutionY - 1)
					makeConstraint(getParticle(x, y), getParticle(x + 1, y + 1));
				if (x < resolutionX - 1 && y < resolutionY - 1)
					makeConstraint(getParticle(x + 1, y), getParticle(x, y + 1));
			}
		}


		// Connecting secondary neighbors with constraints (distance 2 and sqrt(4) in the grid)
		for (int x = 0; x < resolutionX; x++)
		{
			for (int y = 0; y < resolutionY; y++)
			{
				if (x < resolutionX - 2)
					makeConstraint(getParticle(x, y), getParticle(x + 2, y));
				if (y < resolutionY - 2)
					makeConstraint(getParticle(x, y), getParticle(x, y + 2));
				if (x < resolutionX - 2 && y < resolutionY - 2)
					makeConstraint(getParticle(x, y), getParticle(x + 2, y + 2));
				if (x < resolutionX - 2 && y < resolutionY - 2)
					makeConstraint(getParticle(x + 2, y), getParticle(x, y + 2));
			}
		}

		for (int x = 0; x < resolutionX; x++)
			getParticle(x, 0).setMovable(false);
	}

	public void drawShaded()
	{
		for (PhysParticle p : particles)
			p.resetNormal();

		for (int x = 0; x < width - 1; x++)
		{
			for (int y = 0; y < height - 1; y++)
			{
				Vector3f normal = calcTriangleNormal(getParticle(x + 1, y), getParticle(x, y), getParticle(x, y + 1));
				getParticle(x + 1, y).addToNormal(normal);
				getParticle(x, y).addToNormal(normal);
				getParticle(x, y + 1).addToNormal(normal);

				normal = calcTriangleNormal(getParticle(x + 1, y + 1), getParticle(x + 1, y), getParticle(x, y + 1));
				getParticle(x + 1, y + 1).addToNormal(normal);
				getParticle(x + 1, y).addToNormal(normal);
				getParticle(x, y + 1).addToNormal(normal);
			}
		}

		GL11.glBegin(GL11.GL_TRIANGLES);
		for (int x = 0; x < width - 1; x++)
		{
			for (int y = 0; y < height - 1; y++)
			{
				drawTriangle(getParticle(x + 1, y), getParticle(x, y), getParticle(x, y + 1), GLPalette.WHITE);
				drawTriangle(getParticle(x + 1, y + 1), getParticle(x + 1, y), getParticle(x, y + 1), GLPalette.WHITE);
			}
		}
		GL11.glEnd();
	}

	public void addWindForce(Vector3f direction)
	{
		for (int x = 0; x < width - 1; x++)
		{
			for (int y = 0; y < height - 1; y++)
			{
				addWindForcesForTriangle(getParticle(x + 1, y), getParticle(x, y), getParticle(x, y + 1), direction);
				addWindForcesForTriangle(getParticle(x + 1, y + 1), getParticle(x + 1, y), getParticle(x, y + 1), direction);
			}
		}
	}

	private PhysParticle getParticle(int x, int y)
	{
		return particles[y * width + x];
	}

	private void makeConstraint(PhysParticle p1, PhysParticle p2)
	{
		constraints.add(new PhysConstraint(p1, p2));
	}

	private Vector3f calcTriangleNormal(PhysParticle p1, PhysParticle p2, PhysParticle p3)
	{
		Vector3f pos1 = new Vector3f(p1.getPos());
		Vector3f pos2 = new Vector3f(p2.getPos());
		Vector3f pos3 = new Vector3f(p3.getPos());

		Vector3f.sub(pos2, pos1, pos2);
		Vector3f.sub(pos3, pos1, pos3);

		return Vector3f.cross(pos2, pos3, null);
	}

	private void addWindForcesForTriangle(PhysParticle p1, PhysParticle p2, PhysParticle p3, Vector3f dir)
	{
		Vector3f normal = calcTriangleNormal(p1, p2, p3);
		Vector3f d = normal.normalise(null);
		normal.scale(Vector3f.dot(d, dir));
		p1.addForce(normal);
		p2.addForce(normal);
		p3.addForce(normal);
	}

	private void drawTriangle(PhysParticle p1, PhysParticle p2, PhysParticle p3, int color)
	{
		GLPalette.glColorI(color);

		GFX.glNormal1v(p1.getNormal().normalise(null));
		GFX.glVertex1v(p1.getPos());

		GFX.glNormal1v(p2.getNormal().normalise(null));
		GFX.glVertex1v(p2.getPos());

		GFX.glNormal1v(p3.getNormal().normalise(null));
		GFX.glVertex1v(p3.getPos());
	}
}
