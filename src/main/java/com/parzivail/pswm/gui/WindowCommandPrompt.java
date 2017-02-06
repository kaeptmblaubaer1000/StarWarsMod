package com.parzivail.pswm.gui;

import com.parzivail.pswm.PSWM;
import com.parzivail.util.ui.GFX;
import com.parzivail.util.ui.GLPalette;
import org.lwjgl.util.Rectangle;

/**
 * Created by colby on 2/5/2017.
 */
public class WindowCommandPrompt extends GuiWindowLayer
{
	public WindowCommandPrompt(PGui parent, Rectangle bounds)
	{
		super(parent, bounds, "Command Prompt");
	}

	@Override
	public void drawInterior(int mouseX, int mouseY, float partialTicks)
	{
		GFX.drawText(PSWM.mc.fontRendererObj, "$ whoami", 1, this.titleBarRectangle.getHeight() + 1, 0.5f, GLPalette.WHITE);
		GFX.drawText(PSWM.mc.fontRendererObj, "flynn", 1, this.titleBarRectangle.getHeight() + PSWM.mc.fontRendererObj.FONT_HEIGHT / 2f + 2, 0.5f, GLPalette.WHITE);
	}
}
