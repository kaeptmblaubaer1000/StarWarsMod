package com.parzivail.pswm.gui;

import net.minecraft.client.gui.GuiScreen;

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
