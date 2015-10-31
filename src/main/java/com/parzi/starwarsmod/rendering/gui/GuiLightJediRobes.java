package com.parzi.starwarsmod.rendering.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.armor.ArmorLightJediRobes;
import com.parzi.starwarsmod.upgrades.PowerBase;
import com.parzi.starwarsmod.utils.ElementUtils;

public class GuiLightJediRobes extends GuiScreen
{
	private int w = 166;
	private int h = 191;
	private int x;
	private int y;
	private EntityPlayer player;
	private GuiButton prev;
	private GuiButton buy;
	private GuiButton next;
	private int lastButtonClick = 0;
	private int spinnerIndex = 0;
	private PowerBase[] spinner = ((ArmorLightJediRobes)StarWarsMod.lightJediRobes).powers;
	private net.minecraft.util.ResourceLocation backgroundimage = new net.minecraft.util.ResourceLocation(StarWarsMod.MODID + ":" + "textures/gui/default.png");

	public GuiLightJediRobes(EntityPlayer senderPlayer)
	{
		this.player = senderPlayer;
	}

	@Override
	protected void actionPerformed(GuiButton guiButton)
	{
		switch (guiButton.id)
		{
			case 1:
				if (this.spinnerIndex > 0) this.spinnerIndex -= 1;
				break;
			case 2:
				this.buy();
				break;
			case 3:
				if (this.spinnerIndex < this.spinner.length - 1) this.spinnerIndex += 1;
				break;
		}
	}

	private void buy()
	{
		if (Math.pow(2.0D, 6 + this.player.inventory.mainInventory[this.player.inventory.currentItem].stackTagCompound.getInteger(this.spinner[this.spinnerIndex].internalName)) <= this.player.inventory.mainInventory[this.player.inventory.currentItem].stackTagCompound.getInteger(this.spinner[this.spinnerIndex].internalElement))
		{
			int currentEle = this.player.inventory.mainInventory[this.player.inventory.currentItem].stackTagCompound.getInteger(this.spinner[this.spinnerIndex].internalElement);
			int neededEle = (int)Math.pow(2.0D, 6 + this.player.inventory.mainInventory[this.player.inventory.currentItem].stackTagCompound.getInteger(this.spinner[this.spinnerIndex].internalName));
			int currentLvl = this.player.inventory.mainInventory[this.player.inventory.currentItem].stackTagCompound.getInteger(this.spinner[this.spinnerIndex].internalName);
			StarWarsMod.network.sendToServer(new com.parzi.starwarsmod.network.JediRobesBuy(this.spinner[this.spinnerIndex].internalName, currentLvl + 1, this.spinner[this.spinnerIndex].internalElement, currentEle - neededEle, this.player.getCommandSenderName(), this.player.dimension));
		}
	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float renderPartialTicks)
	{
		int py = this.y + 10;
		this.mc.getTextureManager().bindTexture(this.backgroundimage);
		this.drawTexturedModalRect(this.x, this.y, 0, 0, this.w, this.h);
		this.drawString(this.mc.fontRenderer, "Jedi Robes Upgrades", this.x + 10, py, 16777215);
		py += 15;
		this.drawString(this.mc.fontRenderer, "Jedi Master: ", this.x + 10, py, 16777215);
		this.drawString(this.mc.fontRenderer, this.player.inventory.mainInventory[this.player.inventory.currentItem].stackTagCompound.getString("owner"), this.x + 75, py, 1020400);
		String plants = String.valueOf(this.player.inventory.mainInventory[this.player.inventory.currentItem].stackTagCompound.getInteger("plants"));
		String animals = String.valueOf(this.player.inventory.mainInventory[this.player.inventory.currentItem].stackTagCompound.getInteger("animals"));
		String earth = String.valueOf(this.player.inventory.mainInventory[this.player.inventory.currentItem].stackTagCompound.getInteger("earth"));
		String water = String.valueOf(this.player.inventory.mainInventory[this.player.inventory.currentItem].stackTagCompound.getInteger("water"));
		py += 15;
		this.drawString(this.mc.fontRenderer, "Flora: " + plants, this.x + 10, py, ElementUtils.floraColor);
		py += 10;
		this.drawString(this.mc.fontRenderer, "Fauna: " + animals, this.x + 10, py, ElementUtils.faunaColor);
		py += 10;
		this.drawString(this.mc.fontRenderer, "Terra: " + earth, this.x + 10, py, ElementUtils.terraColor);
		py += 10;
		this.drawString(this.mc.fontRenderer, "Aqua: " + water, this.x + 10, py, ElementUtils.aquaColor);
		py += 20;
		this.drawString(this.mc.fontRenderer, this.spinner[this.spinnerIndex].displayName + " level " + String.valueOf(this.player.inventory.mainInventory[this.player.inventory.currentItem].stackTagCompound.getInteger(this.spinner[this.spinnerIndex].internalName) + 1), this.x + 10, py, 16777215);
		py += 10;
		this.drawString(this.mc.fontRenderer, "Learning Cost: " + (int)Math.pow(2.0D, 6 + this.player.inventory.mainInventory[this.player.inventory.currentItem].stackTagCompound.getInteger(this.spinner[this.spinnerIndex].internalName)) + " " + this.spinner[this.spinnerIndex].displayElement, this.x + 10, py, ElementUtils.getColorFromElement(this.spinner[this.spinnerIndex].displayElement));
		py += 10;
		if (Math.pow(2.0D, 6 + this.player.inventory.mainInventory[this.player.inventory.currentItem].stackTagCompound.getInteger(this.spinner[this.spinnerIndex].internalName)) > this.player.inventory.mainInventory[this.player.inventory.currentItem].stackTagCompound.getInteger(this.spinner[this.spinnerIndex].internalElement))
		{
			this.drawString(this.mc.fontRenderer, "Not enough knowledge!", this.x + 10, py, 16733525);
			this.buy.enabled = false;
		}
		else
			this.buy.enabled = true;
		py += 10;
		super.drawScreen(mouseX, mouseY, renderPartialTicks);
	}

	@Override
	public void initGui()
	{
		this.x = (this.width - this.w) / 2;
		this.y = (this.height - this.h) / 2;
		int buttonY = this.y + 120;
		this.prev = new GuiButton(1, this.x + 10, buttonY, 25, 20, "<");
		this.buy = new GuiButton(2, this.x + 40, buttonY, 35, 20, "Learn");
		this.next = new GuiButton(3, this.x + 80, buttonY, 25, 20, ">");
		this.buttonList.add(this.prev);
		this.buttonList.add(this.buy);
		this.buttonList.add(this.next);
	}

	@Override
	public void onGuiClosed()
	{
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\gui\GuiLightJediRobes.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */