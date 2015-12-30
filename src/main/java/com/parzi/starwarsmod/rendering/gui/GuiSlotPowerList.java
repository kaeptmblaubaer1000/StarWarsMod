package com.parzi.starwarsmod.rendering.gui;

import java.util.ArrayList;

import net.minecraft.client.renderer.Tessellator;
import cpw.mods.fml.client.GuiScrollingList;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.LoaderState.ModState;
import cpw.mods.fml.common.ModContainer;

public class GuiSlotPowerList extends GuiScrollingList
{
	private GuiScreenJediRobes parent;
	public ArrayList<GuiPowerListItem> powers;

	public GuiSlotPowerList(GuiScreenJediRobes parent, ArrayList<GuiPowerListItem> powers, int listWidth)
	{
		super(parent.getMinecraftInstance(), listWidth, parent.height, 32, parent.height - 66 + 4, 10, 35);
		this.parent = parent;
		this.powers = powers;
	}

	@Override
	protected int getSize()
	{
		return powers.size();
	}

	@Override
	protected void elementClicked(int var1, boolean var2)
	{
		this.parent.selectIndex(var1);
	}

	@Override
	protected boolean isSelected(int var1)
	{
		return this.parent.indexSelected(var1);
	}

	@Override
	protected void drawBackground()
	{
		this.parent.drawDefaultBackground();
	}

	@Override
	protected int getContentHeight()
	{
		return (this.getSize()) * 35 + 1;
	}

	@Override
	protected void drawSlot(int listIndex, int var2, int var3, int var4, Tessellator var5)
	{
		GuiPowerListItem power = powers.get(listIndex);

		this.parent.getFontRenderer().drawString(this.parent.getFontRenderer().trimStringToWidth(power.unlocalizedName, listWidth - 10), this.left + 3, var3 + 2, 0xFFFFFF);
		this.parent.getFontRenderer().drawString(this.parent.getFontRenderer().trimStringToWidth("Current Level: " + power.currentLevel, listWidth - 10), this.left + 3, var3 + 12, 0xCCCCCC);
		//this.parent.getFontRenderer().drawString(this.parent.getFontRenderer().trimStringToWidth(power.getMetadata() != null ? power.getMetadata().getChildModCountString() : "Metadata not found", listWidth - 10), this.left + 3, var3 + 22, 0xCCCCCC);
	}
}