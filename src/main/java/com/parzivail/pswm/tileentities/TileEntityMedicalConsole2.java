package com.parzivail.pswm.tileentities;

import com.parzivail.pswm.Resources;
import com.parzivail.util.block.TileEntityRotate;
import com.parzivail.util.math.MathUtils;

public class TileEntityMedicalConsole2 extends TileEntityRotate
{
	public int color1 = 0;
	public int color2 = 0;
	public int color3 = 0;
	public int color4 = 0;
	public int color5 = 0;

	@Override
	public void updateEntity()
	{
		if (MathUtils.oneIn(20))
			color1 = MathUtils.getRandomElement(Resources.PANEL_LIGHT_COLORS);
		if (MathUtils.oneIn(50))
			color2 = MathUtils.getRandomElement(Resources.PANEL_LIGHT_COLORS);
		if (MathUtils.oneIn(70))
			color3 = MathUtils.getRandomElement(Resources.PANEL_LIGHT_COLORS);
		if (MathUtils.oneIn(10))
			color4 = MathUtils.getRandomElement(Resources.PANEL_LIGHT_COLORS);
		if (MathUtils.oneIn(100))
			color5 = MathUtils.getRandomElement(Resources.PANEL_LIGHT_COLORS);
	}
}
