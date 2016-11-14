package com.parzivail.pswm.gui;

/**
 * Created by colby on 11/13/2016.
 */
public class FixedSize
{
	private final float wPercent;
	private final float hPercent;

	public FixedSize(float wPercent, float hPercent)
	{
		this.wPercent = wPercent;
		this.hPercent = hPercent;
	}

	public float getWPercent()
	{
		return wPercent;
	}

	public float getHPercent()
	{
		return hPercent;
	}
}
