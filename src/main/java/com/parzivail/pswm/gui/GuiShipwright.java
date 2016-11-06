package com.parzivail.pswm.gui;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.ui.GFX;
import com.parzivail.util.ui.GLPalette;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.opengl.GL11;

public class GuiShipwright extends GuiScreen
{
	EntityPlayer player;
	ScaledResolution r;

	public GuiShipwright(EntityPlayer player)
	{
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if (button.visible && button.enabled)
		{
		}
	}

	@Override
	public void initGui()
	{
		r = new ScaledResolution(StarWarsMod.mc, StarWarsMod.mc.displayWidth, StarWarsMod.mc.displayHeight);
	}

	@Override
	public void onGuiClosed()
	{
		super.onGuiClosed();
		StarWarsMod.mc.renderViewEntity.setDead();
		StarWarsMod.mc.renderViewEntity = StarWarsMod.mc.thePlayer;
	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}

	@Override
	public void drawScreen(int x, int y, float n)
	{
		GL11.glPushMatrix();

		GL11.glDisable(GL11.GL_LIGHTING); // fix for dimming bug!
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);

		float inwardness = 15f;

		GLPalette.glColorI(GLPalette.ALMOST_BLACK, 0x55);
		GFX.drawRectangle(inwardness, inwardness, r.getScaledWidth() - 2 * inwardness, r.getScaledHeight() - 2 * inwardness, true);

		// do 3d stuff

		GL11.glPushMatrix();
		GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glTranslatef(0, 0, 5);
		super.drawScreen(x, y, n);

		GLPalette.glColorI(GLPalette.SW_YELLOW);
		GFX.drawLine(inwardness, inwardness, inwardness, inwardness + 20);
		GFX.drawLine(inwardness, inwardness, inwardness + 20, inwardness);

		GFX.drawLine(r.getScaledWidth() - inwardness, r.getScaledHeight() - inwardness, r.getScaledWidth() - inwardness, r.getScaledHeight() - inwardness - 20);
		GFX.drawLine(r.getScaledWidth() - inwardness, r.getScaledHeight() - inwardness, r.getScaledWidth() - inwardness - 20, r.getScaledHeight() - inwardness);

		GFX.drawLine(inwardness, r.getScaledHeight() - inwardness, inwardness, r.getScaledHeight() - inwardness - 20);
		GFX.drawLine(inwardness, r.getScaledHeight() - inwardness, inwardness + 20, r.getScaledHeight() - inwardness);

		GFX.drawLine(r.getScaledWidth() - inwardness, inwardness, r.getScaledWidth() - inwardness, inwardness + 20);
		GFX.drawLine(r.getScaledWidth() - inwardness, inwardness, r.getScaledWidth() - inwardness - 20, inwardness);

		GL11.glPopMatrix();

		GL11.glDisable(GL11.GL_LINE_SMOOTH);
		GL11.glEnable(GL11.GL_LIGHTING); // end of fix

		GL11.glPopMatrix();
	}
}