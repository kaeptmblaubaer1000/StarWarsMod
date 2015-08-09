package com.parzi.starwarsmod.utils;

import net.minecraft.util.Vec3;

public class Vector3
{
	public float X;
	public float Y;
	public float Z;

	public Vector3(double x, double y, double z)
	{
		X = (float)x;
		Y = (float)y;
		Z = (float)z;
	}

	public Vector3(float x, float y, float z)
	{
		X = x;
		Y = y;
		Z = z;
	}

	public Vector3(int x, int y, int z)
	{
		X = x;
		Y = y;
		Z = z;
	}

	public Vector3(Vec3 vec)
	{
		X = (float)vec.xCoord;
		Y = (float)vec.yCoord;
		Z = (float)vec.zCoord;
	}

	public void add(int b)
	{
		X += b;
		Y += b;
		Z += b;
	}

	public void add(Vector3 b)
	{
		X += b.X;
		Y += b.Y;
		Z += b.Z;
	}

	public float distanceTo(Vector3 b)
	{
		return (float)Math.sqrt(Math.pow(b.X - X, 2) + Math.pow(b.Y - Y, 2));
	}

	public void divide(int b)
	{
		X /= b;
		Y /= b;
		Z /= b;
	}

	public void divide(Vector3 b)
	{
		X /= b.X;
		Y /= b.Y;
		Z /= b.Z;
	}

	public void multiply(int b)
	{
		X *= b;
		Y *= b;
		Z *= b;
	}

	public void multiply(Vector3 b)
	{
		X *= b.X;
		Y *= b.Y;
		Z *= b.Z;
	}

	public void subtract(int b)
	{
		X -= b;
		Y -= b;
		Z -= b;
	}

	public void subtract(Vector3 b)
	{
		X -= b.X;
		Y -= b.Y;
		Z -= b.Z;
	}

	public Vec3 toVec3()
	{
		return Vec3.createVectorHelper(X, Y, Z);
	}
}
