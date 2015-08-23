package com.parzi.starwarsmod.rendering.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.armor.ArmorLightJediRobes;
import com.parzi.starwarsmod.network.JediRobesBuy;
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

	private ResourceLocation backgroundimage = new ResourceLocation(StarWarsMod.MODID + ":" + "textures/gui/default.png");

	public GuiLightJediRobes(EntityPlayer senderPlayer)
	{
		player = senderPlayer;
	}

	@Override
	protected void actionPerformed(GuiButton guiButton)
	{
		switch (guiButton.id)
		{
			case 1:
				if (spinnerIndex > 0)
				{
					spinnerIndex--;
				}
				break;
			case 2:
				buy();
				break;
			case 3:
				if (spinnerIndex < spinner.length - 1)
				{
					spinnerIndex++;
				}
				break;
		}
		// System.out.println("clicked " + guiButton.displayString);
	}

	private void buy()
	{
		if (Math.pow(2, 6 + player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound.getInteger(spinner[spinnerIndex].internalName)) <= player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound.getInteger(spinner[spinnerIndex].internalElement))
		{

			int currentEle = player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound.getInteger(spinner[spinnerIndex].internalElement);
			int neededEle = (int)Math.pow(2, 6 + player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound.getInteger(spinner[spinnerIndex].internalName));

			// player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound
			// .setInteger(spinner[spinnerIndex].internalElement,
			// currentEle - neededEle);

			int currentLvl = player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound.getInteger(spinner[spinnerIndex].internalName);

			// player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound
			// .setInteger(spinner[spinnerIndex].internalName,
			// currentLvl + 1);

			StarWarsMod.network.sendToServer(new JediRobesBuy(spinner[spinnerIndex].internalName, currentLvl + 1, spinner[spinnerIndex].internalElement, currentEle - neededEle, player.getCommandSenderName(), player.dimension));
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
		int py = y + 10;

		mc.getTextureManager().bindTexture(backgroundimage);
		drawTexturedModalRect(x, y, 0, 0, w, h);

		drawString(mc.fontRenderer, "Jedi Robes Upgrades", x + 10, py, 0xFFFFFF);
		py += 15;
		drawString(mc.fontRenderer, "Jedi Master: ", x + 10, py, 0xFFFFFF);
		drawString(mc.fontRenderer, player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound.getString("owner"), x + 75, py, 0x0F91F0);

		String plants = String.valueOf(player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound.getInteger("plants"));
		String animals = String.valueOf(player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound.getInteger("animals"));
		String earth = String.valueOf(player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound.getInteger("earth"));
		String water = String.valueOf(player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound.getInteger("water"));

		py += 15;
		drawString(mc.fontRenderer, "Flora: " + plants, x + 10, py, ElementUtils.floraColor);
		py += 10;
		drawString(mc.fontRenderer, "Fauna: " + animals, x + 10, py, ElementUtils.faunaColor);
		py += 10;
		drawString(mc.fontRenderer, "Terra: " + earth, x + 10, py, ElementUtils.terraColor);
		py += 10;
		drawString(mc.fontRenderer, "Aqua: " + water, x + 10, py, ElementUtils.aquaColor);
		py += 20;
		drawString(mc.fontRenderer, spinner[spinnerIndex].displayName + " level " + String.valueOf(player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound.getInteger(spinner[spinnerIndex].internalName) + 1), x + 10, py, 0xFFFFFF);
		py += 10;
		drawString(mc.fontRenderer, "Learning Cost: " + (int)Math.pow(2, 6 + player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound.getInteger(spinner[spinnerIndex].internalName)) + " " + spinner[spinnerIndex].displayElement, x + 10, py, ElementUtils.getColorFromElement(spinner[spinnerIndex].displayElement));
		py += 10;
		if (Math.pow(2, 6 + player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound.getInteger(spinner[spinnerIndex].internalName)) > player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound.getInteger(spinner[spinnerIndex].internalElement))
		{
			drawString(mc.fontRenderer, "Not enough knowledge!", x + 10, py, 0xFF5555);
			buy.enabled = false;
		}
		else
		{
			buy.enabled = true;
		}
		py += 10;

		super.drawScreen(mouseX, mouseY, renderPartialTicks);
	}

	@Override
	public void initGui()
	{
		x = (width - w) / 2;
		y = (height - h) / 2;

		// id, x, y, width, height, text
		int buttonY = y + 120;
		prev = new GuiButton(1, x + 10, buttonY, 25, 20, "<");
		buy = new GuiButton(2, x + 40, buttonY, 35, 20, "Learn");
		next = new GuiButton(3, x + 80, buttonY, 25, 20, ">");
		buttonList.add(prev);
		buttonList.add(buy);
		buttonList.add(next);
	}

	@Override
	public void onGuiClosed()
	{
	}
}