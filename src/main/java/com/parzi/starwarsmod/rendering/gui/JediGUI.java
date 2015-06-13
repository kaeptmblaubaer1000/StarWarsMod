package com.parzi.starwarsmod.rendering.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import com.parzi.starwarsmod.StarWarsMod;

public class JediGUI extends GuiScreen {

	private int w = 166;
	private int h = 191;
	private ItemStack robe;

	private ResourceLocation backgroundimage = new ResourceLocation(
			StarWarsMod.MODID + ":" + "textures/gui/jediRobes.png");

	public JediGUI(ItemStack stack) {
		robe = stack;
	}

	@Override
	public void initGui() {
		super.initGui();
		// make buttons
		// id, x, y, width, height, text
		buttonList.add(new GuiButton(1, 10, 52, 20, 20, "+"));
		buttonList.add(new GuiButton(2, 40, 72, 20, 20, "-"));
	}

	protected void actionPerformed(GuiButton guibutton) {
		// id is the id you give your button
		switch (guibutton.id) {
		case 1:
			break;
		case 2:
			break;
		}
		// Packet code here
		// PacketDispatcher.sendPacketToServer(packet); //send packet
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float renderPartialTicks) {
		drawDefaultBackground();

		this.mc.getTextureManager().bindTexture(backgroundimage);
		int x = (this.width - w) / 2;
		int y = (this.height - h) / 2;
		drawTexturedModalRect(x, y, 0, 0, w, h);

		int py = y + 10;
		drawString(mc.fontRenderer, "Jedi Robe Upgrades", x + 10, py, 0xFFFFFF);
		py += 15;
		drawString(mc.fontRenderer, "Jedi Master: ", x + 10, py, 0xFFFFFF);
		drawString(mc.fontRenderer, robe.stackTagCompound.getString("owner"),
				x + 75, py, 0x0F91F0);

		String plants = String.valueOf(robe.stackTagCompound
				.getInteger("plants"));
		String animals = String.valueOf(robe.stackTagCompound
				.getInteger("animals"));
		String earth = String
				.valueOf(robe.stackTagCompound.getInteger("earth"));
		String water = String
				.valueOf(robe.stackTagCompound.getInteger("water"));

		py += 15;
		drawString(mc.fontRenderer, "Flora: " + plants, x + 10, py, 0x33CC33);
		py += 10;
		drawString(mc.fontRenderer, "Fauna: " + animals, x + 10, py, 0x5B4633);
		py += 10;
		drawString(mc.fontRenderer, "Terra: " + earth, x + 10, py, 0x669999);
		py += 10;
		drawString(mc.fontRenderer, "Aqua: " + water, x + 10, py, 0x4747DA);
	}
}