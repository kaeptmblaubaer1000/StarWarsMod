package com.parzivail.util.cloth;

import com.parzivail.util.lwjgl.Vector3f;
import com.parzivail.util.ui.GFX;
import com.parzivail.util.ui.GLPalette;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

/**
 * Created by colby on 1/16/2017.
 */
public class Cloth
{
	private final ClothSettings settings;

	private int width;
	private int height;

	private ClothParticle[] particles;
	private ArrayList<ClothConstraint> constraints;

	public Cloth(ClothSettings settings, float width, float height, int resolutionX, int resolutionY)
	{
		this.settings = settings;
		this.width = resolutionX;
		this.height = resolutionY;

		particles = new ClothParticle[resolutionX * resolutionY];
		constraints = new ArrayList<>();

		// creating particles in a grid of particles from (0,0,0) to (width,-height,0)
		for (int x = 0; x < resolutionX; x++)
		{
			for (int y = 0; y < resolutionY; y++)
			{
				Vector3f pos = new Vector3f(width * (x / (float)resolutionX), -height * (y / (float)resolutionY), 0);
				particles[y * resolutionX + x] = new ClothParticle(settings, pos); // insert particle in column x at y'th row
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
		for (ClothParticle p : particles)
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

	public void timeStep()
	{
		for (int i = 0; i < settings.constraintIterations; i++) // iterate over all constraints several times
		{
			for (ClothConstraint c : constraints)
				c.satisfyConstraint();
		}

		for (ClothParticle p : particles)
			p.timeStep();
	}

	public void addForce(Vector3f dir)
	{
		for (ClothParticle p : particles)
			p.addForce(dir);
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

	public void checkCollision()
	{
		for (ClothParticle p : particles)
		{
			CollisionResult result = p.getSceneCollision();
			if (result.collides)
			{
				p.offsetPos(result.collisionVector);
			}
		}
	}

	private ClothParticle getParticle(int x, int y)
	{
		return particles[y * width + x];
	}

	private void makeConstraint(ClothParticle p1, ClothParticle p2)
	{
		constraints.add(new ClothConstraint(p1, p2));
	}

	private Vector3f calcTriangleNormal(ClothParticle p1, ClothParticle p2, ClothParticle p3)
	{
		Vector3f pos1 = new Vector3f(p1.getPos());
		Vector3f pos2 = new Vector3f(p2.getPos());
		Vector3f pos3 = new Vector3f(p3.getPos());

		Vector3f.sub(pos2, pos1, pos2);
		Vector3f.sub(pos3, pos1, pos3);

		return Vector3f.cross(pos2, pos3, null);
	}

	private void addWindForcesForTriangle(ClothParticle p1, ClothParticle p2, ClothParticle p3, Vector3f dir)
	{
		Vector3f normal = calcTriangleNormal(p1, p2, p3);
		Vector3f d = normal.normalise(null);
		normal.scale(Vector3f.dot(d, dir));
		p1.addForce(normal);
		p2.addForce(normal);
		p3.addForce(normal);
	}

	private void drawTriangle(ClothParticle p1, ClothParticle p2, ClothParticle p3, int color)
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
