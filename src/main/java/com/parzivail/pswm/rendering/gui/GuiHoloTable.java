package com.parzivail.pswm.rendering.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.network.MessageHoloTableUpdate;
import com.parzivail.pswm.tileentities.TileEntityHoloTableBase;
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
	private GuiButton buttonRefresh;

	private EntityPlayer player;
	private TileEntityHoloTableBase table;

	int lColumn;
	int rColumn;

	public GuiHoloTable(EntityPlayer player, TileEntityHoloTableBase table)
	{
		this.mc = Minecraft.getMinecraft();
		this.table = table;
		this.player = player;

		this.rColumn = -20;
		this.lColumn = 5;
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if (button.enabled)
			if (button.id == this.buttonBlack.id)
			{
				this.table.setRGB(0.5f, 0.5f, 0.8f);
				this.table.getWorldObj().markBlockForUpdate(this.table.xCoord, this.table.yCoord, this.table.zCoord);
				StarWarsMod.network.sendToServer(new MessageHoloTableUpdate(this.table));
			}
			else if (button.id == this.buttonWhite.id)
			{
				this.table.setRGB(0.7f, 0.7f, 1);
				this.table.getWorldObj().markBlockForUpdate(this.table.xCoord, this.table.yCoord, this.table.zCoord);
				StarWarsMod.network.sendToServer(new MessageHoloTableUpdate(this.table));
			}
			else if (button.id == this.buttonOffsetUp.id)
			{
				this.table.setOffset(this.table.getOffset() - 1);
				this.table.getWorldObj().markBlockForUpdate(this.table.xCoord, this.table.yCoord, this.table.zCoord);
				StarWarsMod.network.sendToServer(new MessageHoloTableUpdate(this.table));
			}
			else if (button.id == this.buttonOffsetDown.id)
			{
				this.table.setOffset(this.table.getOffset() + 1);
				this.table.getWorldObj().markBlockForUpdate(this.table.xCoord, this.table.yCoord, this.table.zCoord);
				StarWarsMod.network.sendToServer(new MessageHoloTableUpdate(this.table));
			}
			else if (button.id == this.buttonRefresh.id)
				this.table.setupMap();
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
		this.drawString(this.mc.fontRenderer, "Holo Color", x - 77 + this.lColumn, y - 45, GlPalette.WHITE);
		this.drawString(this.mc.fontRenderer, "Holo Y Offset", x + 30 + this.rColumn, y - 45, GlPalette.WHITE);
		this.drawCenteredString(this.mc.fontRenderer, String.valueOf(this.table.getOffset()), x + 63 + this.rColumn, y - 24, GlPalette.WHITE);

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

		this.buttonBlack = new GuiButton(0, x - 73 + this.lColumn, y - 30, 40, 20, "Dark");
		this.buttonList.add(this.buttonBlack);

		this.buttonWhite = new GuiButton(1, x - 73 + this.lColumn, y - 8, 40, 20, "Light");
		this.buttonList.add(this.buttonWhite);

		this.buttonOffsetUp = new GuiButton(2, x + 30 + this.rColumn, y - 30, 20, 20, "<");
		this.buttonList.add(this.buttonOffsetUp);

		this.buttonOffsetDown = new GuiButton(3, x + 77 + this.rColumn, y - 30, 20, 20, ">");
		this.buttonList.add(this.buttonOffsetDown);

		this.buttonRefresh = new GuiButton(4, x + 30 + this.rColumn, y - 8, 68, 20, "Refresh");
		this.buttonList.add(this.buttonRefresh);
		/*
		 * if (keyCode == 1) { this.mc.displayGuiScreen((GuiScreen)null);
		 * this.mc.setIngameFocus(); }
		 */
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\gui\GuiMV.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */