package com.parzi.starwarsmod.rendering.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.StarWarsMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiScreenJediRobes extends GuiScreen
{
	private static final ResourceLocation guiTexture = new ResourceLocation(StarWarsMod.MODID, "textures/gui/jediRobes.png");
	private Minecraft mc;
	private ItemStack stack;
	private EntityPlayer player;

	public GuiScreenJediRobes(EntityPlayer player)
	{
		mc = Minecraft.getMinecraft();
		this.stack = player.getEquipmentInSlot(2);
		this.player = player;

		this.width = 495;
		this.height = 331;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(guiTexture);
		int k = (this.mc.displayWidth - this.width) / 2;
		int l = (this.mc.displayHeight - this.height) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.width, this.height);

		super.drawScreen(mouseX, mouseY, partialTicks);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\gui\GuiMV.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */