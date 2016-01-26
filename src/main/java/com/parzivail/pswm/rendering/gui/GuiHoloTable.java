package com.parzivail.pswm.rendering.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.jedirobes.ArmorJediRobes;
import com.parzivail.pswm.network.PacketRobesStringNBT;
import com.parzivail.pswm.tileentities.TileEntityHoloTable;
import com.parzivail.pswm.utils.ForceUtils;
import com.parzivail.util.ui.GlPalette;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiHoloTable extends GuiScreen
{
	private static final ResourceLocation guiTexture = new ResourceLocation(Resources.MODID, "textures/gui/icons2.png");

	private GuiButton buttonBlack;
	private GuiButton buttonWhite;
	private GuiButton buttonOffsetUp;
	private GuiButton buttonOffsetDown;

	private EntityPlayer player;
	private TileEntityHoloTable table;

	public GuiHoloTable(EntityPlayer player, TileEntityHoloTable table)
	{
		this.mc = Minecraft.getMinecraft();
		this.table = table;
		this.player = player;
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if (button.enabled)
			if (button.id == this.buttonBlack.id)
			{
				table.setRGB(0, 0, 0.1f);
			}
			else if (button.id == this.buttonWhite.id)
			{
				table.setRGB(0.8f, 0.8f, 1);
			}
			else if (button.id == this.buttonOffsetUp.id)
			{
				table.setOffset(table.getOffset() - 1);
			}
			else if (button.id == this.buttonOffsetDown.id)
			{
				table.setOffset(table.getOffset() + 1);
			}
	}

	/**
	 * Draws the screen and all the components in it.
	 */
	@Override
	public void drawScreen(int p_571_1_, int p_571_2_, float p_571_3_)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		ScaledResolution r = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);

		this.mc.getTextureManager().bindTexture(guiTexture);
		this.drawTexturedModalRect((r.getScaledWidth() - 248) / 2, (r.getScaledHeight() - 166) / 2, 0, 60, 248, 166);

		int x = r.getScaledWidth() / 2;
		int y = r.getScaledHeight() / 2;
		int dy = y - 80;

		this.drawString(this.mc.fontRenderer, "Holo Color", x - 77, y - 45, GlPalette.WHITE);
		this.drawString(this.mc.fontRenderer, "Holo Y Offset", x + 30, y - 45, GlPalette.WHITE);
		this.drawString(this.mc.fontRenderer, String.valueOf(table.getOffset()), x + 30, y - 34, GlPalette.WHITE);

		super.drawScreen(p_571_1_, p_571_2_, p_571_3_);
	}

	/**
	 * Adds the buttons (and other controls) to the screen in question.
	 */
	@Override
	public void initGui()
	{
		ScaledResolution r = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
		int x = r.getScaledWidth() / 2;
		int y = r.getScaledHeight() / 2;

		this.buttonBlack = new GuiButton(0, x - 73, y - 30, 40, 20, "Dark");
		this.buttonList.add(this.buttonBlack);

		this.buttonWhite = new GuiButton(1, x - 73, y - 8, 40, 20, "Light");
		this.buttonList.add(this.buttonWhite);

		this.buttonOffsetUp = new GuiButton(2, x + 30, y - 8, 20, 20, "<");
		this.buttonList.add(this.buttonOffsetUp);

		this.buttonOffsetDown = new GuiButton(3, x + 50, y - 8, 20, 20, ">");
		this.buttonList.add(this.buttonOffsetDown);
		/*
		 * if (p_73869_2_ == 1) { this.mc.displayGuiScreen((GuiScreen)null);
		 * this.mc.setIngameFocus(); }
		 */
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\gui\GuiMV.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */