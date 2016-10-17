package com.parzivail.util.driven;

/**
 * Created by colby on 10/16/2016.
 */
public class ShipInfo
{
	public float cameraDistance = 1;
	public int numPassengers = 1;
	public Seat[] seatInfo = new Seat[0];
	public float angularDragCoefficient = 0.8f;
	public float maxThrottle = 0.4f;
	public float throttleStep = 0.1f;
	public float cameraFloatDampening = 0.5f;
}
