package com.parzi.starwarsmod.rendering.gui;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.BlockAnvil;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.network.JediRobesBuy;
import com.parzi.starwarsmod.upgrades.ForceLeap;
import com.parzi.starwarsmod.upgrades.ForceStep;
import com.parzi.starwarsmod.upgrades.PowerBase;
import com.parzi.starwarsmod.utils.ElementUtils;
import com.parzi.starwarsmod.armor.ArmorJediRobes;

public class JediGUI extends GuiScreen
{

	private int w = 166;
	private int h = 191;
	private int x;
	private int y;
	private EntityPlayer player;

	private int spinnerIndex = 0;
	private PowerBase[] spinner = ((ArmorJediRobes)StarWarsMod.jediRobes).powers;

	private ResourceLocation backgroundimage = new ResourceLocation(StarWarsMod.MODID + ":" + "textures/gui/default.png");

	public JediGUI(EntityPlayer senderPlayer)
	{
		player = senderPlayer;
	}

	@Override
	public void onGuiClosed()
	{
	}

	@Override
	protected void actionPerformed(GuiButton guiButton)
	{
		switch (guiButton.id)
		{
			case 1:
				if (spinnerIndex > 0) spinnerIndex--;
				break;
			case 2:
				buy();
				break;
			case 3:
				if (spinnerIndex < spinner.length - 1) spinnerIndex++;
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

			StarWarsMod.network.sendToServer(new JediRobesBuy(spinner[spinnerIndex].internalName, currentLvl + 1, spinner[spinnerIndex].internalElement, currentEle - neededEle));
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
		drawDefaultBackground();

		x = (this.width - w) / 2;
		y = (this.height - h) / 2;

		int py = y + 10;

		this.mc.getTextureManager().bindTexture(backgroundimage);
		drawTexturedModalRect(x, y, 0, 0, w, h);

		drawString(mc.fontRenderer, "Jedi Robes Upgrades", x + 10, py, 0xFFFFFF);
		py += 15;
		drawString(mc.fontRenderer, "Jedi Master: ", x + 10, py, 0xFFFFFF);
		drawString(mc.fontRenderer, player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound.getString("owner"), x + 75, py, 0x0F91F0);

		String plants = String.valueOf(player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound.getInteger("plants"));
		String animals = String.valueOf(player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound.getInteger("animals"));
		String earth = String.valueOf(player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound.getInteger("earth"));
		String water = String.valueOf(player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound.getInteger("water"));

		// id, x, y, width, height, text
		GuiButton prev = new GuiButton(1, x + 10, py, 25, 20, "<");
		GuiButton buy = new GuiButton(2, x + 40, py, 25, 20, "BUY");
		GuiButton next = new GuiButton(3, x + 70, py, 25, 20, ">");

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
		drawString(mc.fontRenderer, "Cost: " + (int)Math.pow(2, 6 + player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound.getInteger(spinner[spinnerIndex].internalName)) + " " + spinner[spinnerIndex].displayElement, x + 10, py, ElementUtils.getColorFromElement(spinner[spinnerIndex].displayElement));
		py += 10;
		if (Math.pow(2, 6 + player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound.getInteger(spinner[spinnerIndex].internalName)) > player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound.getInteger(spinner[spinnerIndex].internalElement))
		{
			drawString(mc.fontRenderer, "Too expensive!", x + 10, py, 0xFF5555);
			buy.enabled = false;
		}
		py += 10;
		buttonList.clear();

		buttonList.add(prev);
		buttonList.add(buy);
		buttonList.add(next);

		for (int i = 0; i < buttonList.size(); i++)
		{
			GuiButton b = (GuiButton)buttonList.get(i);
			b.drawButton(mc, b.xPosition, b.yPosition);
		}
	}
}