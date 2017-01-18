package com.parzivail.pswm.utils;

/**
 * Created by Colby on 6/29/2016.
 */
public class BlasterPosition
{
	public static final byte TOP = 1;
	public static final byte BOTTOM = 2;
	public static final byte LEFT = 4;
	public static final byte RIGHT = 8;

	public static final byte BOTH_SIDES = LEFT | RIGHT;

	public static final byte[] XWING_ORDER = { BOTTOM | RIGHT, TOP | RIGHT, BOTTOM | LEFT, TOP | LEFT };
	private static byte xwingIndex = 0;

	public static final byte[] ORDER = { LEFT, RIGHT };
	private static byte index = 0;

	public static byte getNextXwingPosition()
	{
		byte ret = XWING_ORDER[xwingIndex];
		xwingIndex++;
		if (xwingIndex >= XWING_ORDER.length)
			xwingIndex = 0;
		return ret;
	}

	public static byte getNextPosition()
	{
		byte ret = ORDER[index];
		index++;
		if (index >= ORDER.length)
			index = 0;
		return ret;
	}
}
