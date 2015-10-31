package com.parzi.starwarsmod.utils;

import net.minecraft.util.Vec3;

public class Vector3
{
	public float X;
	public float Y;
	public float Z;

	public Vector3(double x, double y, double z)
	{
		this.X = (float)x;
		this.Y = (float)y;
		this.Z = (float)z;
	}

	public Vector3(float x, float y, float z)
	{
		this.X = x;
		this.Y = y;
		this.Z = z;
	}

	public Vector3(int x, int y, int z)
	{
		this.X = x;
		this.Y = y;
		this.Z = z;
	}

	public Vector3(Vec3 vec)
	{
		this.X = (float)vec.xCoord;
		this.Y = (float)vec.yCoord;
		this.Z = (float)vec.zCoord;
	}

	public void add(int b)
	{
		this.X += b;
		this.Y += b;
		this.Z += b;
	}

	public void add(Vector3 b)
	{
		this.X += b.X;
		this.Y += b.Y;
		this.Z += b.Z;
	}

	public float distanceTo(Vector3 b)
	{
		return (float)Math.sqrt(Math.pow(b.X - this.X, 2.0D) + Math.pow(b.Y - this.Y, 2.0D));
	}

	public void divide(int b)
	{
		this.X /= b;
		this.Y /= b;
		this.Z /= b;
	}

	public void divide(Vector3 b)
	{
		this.X /= b.X;
		this.Y /= b.Y;
		this.Z /= b.Z;
	}

	public void multiply(int b)
	{
		this.X *= b;
		this.Y *= b;
		this.Z *= b;
	}

	public void multiply(Vector3 b)
	{
		this.X *= b.X;
		this.Y *= b.Y;
		this.Z *= b.Z;
	}

	public void subtract(int b)
	{
		this.X -= b;
		this.Y -= b;
		this.Z -= b;
	}

	public void subtract(Vector3 b)
	{
		this.X -= b.X;
		this.Y -= b.Y;
		this.Z -= b.Z;
	}

	public Vec3 toVec3()
	{
		return Vec3.createVectorHelper(this.X, this.Y, this.Z);
	}
}