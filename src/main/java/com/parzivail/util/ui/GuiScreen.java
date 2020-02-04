package com.parzivail.util.ui;

import net.minecraft.client.gui.GuiButton;

import java.util.List;

public abstract class GuiScreen extends net.minecraft.client.gui.GuiScreen {
	@SuppressWarnings("unchecked")
	protected List<GuiButton> buttonList = super.buttonList;
}