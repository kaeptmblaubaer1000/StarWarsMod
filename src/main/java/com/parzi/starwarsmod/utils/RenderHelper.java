package com.parzi.starwarsmod.utils;

import net.minecraft.client.Minecraft;

public class RenderHelper
{
	private Minecraft mc;

	/**
	 * Initiates a new RenderHelper class
	 *
	 * @param mc
	 *            The minecraft to wrap
	 */
	public RenderHelper(Minecraft mc)
	{
		this.mc = mc;
	}

	/**
	 * Gets the camera mode
	 *
	 * @return Returns true if the camera is in 1st person mode
	 */
	public boolean isFirstPerson()
	{
		return this.mc.gameSettings.thirdPersonView == 0;
	}

	/**
	 * Sets the camera mode
	 */
	public void setCameraMode(int mode)
	{
		this.mc.gameSettings.thirdPersonView = mode;
	}
}