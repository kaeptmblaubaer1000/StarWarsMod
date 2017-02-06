package com.parzivail.pswm.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by colby on 2/5/2017.
 */
public class PGui extends GuiScreen
{
	ArrayList<GuiWindowLayer> windows = new ArrayList<>();
	ArrayList<GuiWindowLayer> removeQueue = new ArrayList<>();
	ArrayList<GuiWindowLayer> addQueue = new ArrayList<>();

	public void removeWindow(GuiWindowLayer window)
	{
		this.removeQueue.add(window);
	}

	public void addWindow(GuiWindowLayer window)
	{
		this.addQueue.add(window);
	}

	public void removeAllWindows()
	{
		this.removeQueue.addAll(windows);
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException
	{
		this.propogateAction(windows, button);
	}

	private void propogateAction(ArrayList<GuiWindowLayer> windows, GuiButton button)
	{
		for (GuiWindowLayer window : windows)
			if (!window.minimized)
				window.actionPerformed(button);
	}

	private void propogateKeyboard(ArrayList<GuiWindowLayer> windows, char typedChar, int keyCode)
	{
		for (GuiWindowLayer window : windows)
			if (!window.minimized)
				window.keyTyped(typedChar, keyCode);
	}

	private void propogateUpdate(ArrayList<GuiWindowLayer> windows)
	{
		for (GuiWindowLayer window : windows)
			if (!window.minimized)
				window.updateScreen();
	}

	@Override
	public void updateScreen()
	{
		this.propogateUpdate(windows);
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException
	{
		super.keyTyped(typedChar, keyCode);
		this.propogateKeyboard(windows, typedChar, keyCode);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		super.drawScreen(mouseX, mouseY, partialTicks);
		if (this.addQueue.size() > 0)
		{
			this.windows.addAll(addQueue);
			this.addQueue.clear();
		}
		if (this.removeQueue.size() > 0)
		{
			this.windows.removeAll(removeQueue);
			this.removeQueue.clear();
		}
		for (GuiWindowLayer window : windows)
			window.draw(mouseX, mouseY, partialTicks);
	}
}
