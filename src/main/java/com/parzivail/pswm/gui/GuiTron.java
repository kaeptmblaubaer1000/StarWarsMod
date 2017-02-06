package com.parzivail.pswm.gui;

import com.parzivail.pswm.PSWM;
import com.parzivail.util.ui.GFX;
import com.parzivail.util.ui.GLPalette;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Rectangle;

/**
 * Created by colby on 2/5/2017.
 */
public class GuiTron extends PGui
{
	ScaledResolution r = new ScaledResolution(PSWM.mc);

	@Override
	public void onResize(Minecraft mcIn, int w, int h)
	{
		super.onResize(mcIn, w, h);
		r = new ScaledResolution(PSWM.mc);
	}

	@Override
	public void initGui()
	{
		super.initGui();
		this.removeAllWindows();
		this.addWindow(new WindowCommandPrompt(this, new Rectangle(50, 50, 100, 150)));
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_TEXTURE_2D);

		GLPalette.glColorI(GLPalette.ALMOST_BLACK);
		GFX.rectangle(0, 0, r.getScaledWidth(), r.getScaledHeight(), true);

		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glPopMatrix();

		super.drawScreen(mouseX, mouseY, partialTicks);
	}
}
