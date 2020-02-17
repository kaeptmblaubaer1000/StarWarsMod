package com.parzivail.util.math;

import com.parzivail.util.ui.GLPalette;

import java.awt.*;
import java.util.Comparator;

/**
 * Comparator for two colors, taking into account Hue, Saturation and Brightness
 */
public class IntColorComparator implements Comparator<Integer>
{
	@Override
	public int compare(Integer i1, Integer i2)
	{
		Color c1 = GLPalette.intToColor(i1);
		Color c2 = GLPalette.intToColor(i2);
		float[] hsb1 = Color.RGBtoHSB(c1.getRed(), c1.getGreen(), c1.getBlue(), null);
		float[] hsb2 = Color.RGBtoHSB(c2.getRed(), c2.getGreen(), c2.getBlue(), null);
		if (hsb1[0] < hsb2[0])
			return -1;
		if (hsb1[0] > hsb2[0])
			return 1;
		if (hsb1[1] < hsb2[1])
			return -1;
		if (hsb1[1] > hsb2[1])
			return 1;
		return Float.compare(hsb1[2], hsb2[2]);
	}
}