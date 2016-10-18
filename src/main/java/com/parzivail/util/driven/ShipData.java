package com.parzivail.util.driven;

/**
 * Created by colby on 10/16/2016.
 */
public class ShipData
{
	public int numPassengers = 1;
	public Seat[] seatInfo = new Seat[0];

	public float cameraDistance = 10;
	public float cameraFloatDampening = 0.5f;

	public float angularDragCoefficient = 0.8f;
	public float maxThrottle = 0.4f;
	public float throttleStep = 0.1f;

	public EnergyWeaponData[] energyWeaponData = new EnergyWeaponData[0];
	public PhysicalWeaponData[] physicalWeaponData = new PhysicalWeaponData[0];

	public boolean cloakingActive = false;

	public float shipHealthPercentage = 1;
	public float shieldHealthPercentage = 1;

	public float energyTotalPercentage = 1;
	public float energyPercentDrainPerMinute = 1;

}
