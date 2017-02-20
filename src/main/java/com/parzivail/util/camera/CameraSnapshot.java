package com.parzivail.util.camera;

import com.parzivail.util.lwjgl.Vector3f;
import com.parzivail.util.math.FPoint;
import com.parzivail.util.math.RotatedAxes;

import java.util.List;

/**
 * Created by colby on 2/20/2017.
 */
public class CameraSnapshot
{
	public Vector3f position;
	public RotatedAxes rotation;

	public CameraSnapshot(Vector3f position, RotatedAxes rotation)
	{
		this.position = position;
		this.rotation = rotation;
	}

	public static FPoint[] toPositionFPoint(List<CameraSnapshot> cameraSnapshots)
	{
		FPoint[] points = new FPoint[cameraSnapshots.size()];
		for (int i = 0; i < points.length; i++)
			points[i] = new FPoint(cameraSnapshots.get(i).position);
		return points;
	}

	public static FPoint[] toRotationFPoint(List<CameraSnapshot> cameraSnapshots)
	{
		FPoint[] points = new FPoint[cameraSnapshots.size()];
		for (int i = 0; i < points.length; i++)
		{
			RotatedAxes rotatedAxes = cameraSnapshots.get(i).rotation;
			points[i] = new FPoint(rotatedAxes.getYaw() + 180, rotatedAxes.getPitch(), rotatedAxes.getRoll());
		}
		return points;
	}
}
