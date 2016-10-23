package com.parzivail.pswm.gui;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.driven.Pilotable;
import com.parzivail.util.entity.EntityUtils;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Keyboard;

public class GuiShipKeyCapture extends GuiScreen
{
	public static final boolean[] keyStates = new boolean[Keyboard.KEYBOARD_SIZE];

	public GuiShipKeyCapture()
	{
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
	}

	@Override
	public void handleKeyboardInput()
	{
		if (Keyboard.getEventKeyState() && EntityUtils.getShipRiding(StarWarsMod.mc.thePlayer) instanceof Pilotable)
		{
			((Pilotable)EntityUtils.getShipRiding(StarWarsMod.mc.thePlayer)).keyTyped(Keyboard.getEventCharacter(), Keyboard.getEventKey(), Keyboard.getEventKeyState());
		}
	}

	@Override
	public void onGuiClosed()
	{
		mc.mouseHelper.ungrabMouseCursor();
		mc.renderViewEntity = mc.thePlayer;
	}

	@Override
	public void initGui()
	{
	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}

	@Override
	public void drawScreen(int x, int y, float n)
	{
	}
}