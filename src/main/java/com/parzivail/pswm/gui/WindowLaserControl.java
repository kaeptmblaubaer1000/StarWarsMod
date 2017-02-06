package com.parzivail.pswm.gui;

import com.parzivail.util.ui.GFX;
import com.parzivail.util.ui.GLPalette;
import org.lwjgl.util.Rectangle;

/**
 * Created by colby on 2/5/2017.
 */
public class WindowLaserControl extends GuiWindowLayer
{
	public WindowLaserControl(PGui parent, Rectangle bounds)
	{
		super(parent, bounds, "");
		this.backgroundColor = GLPalette.WHEAT;
	}

	@Override
	public void drawInterior(int mouseX, int mouseY, float partialTicks)
	{
		int y = this.titleBarRectangle.getHeight() + 8;
		GFX.drawCenteredString(this.bounds.getWidth() / 2, y, "Aperture Clear?", GLPalette.BLACK);
		GFX.drawCenteredString(this.bounds.getWidth() / 2, y + 12, "< YES >     < NO >", GLPalette.BLACK);
	}
}
