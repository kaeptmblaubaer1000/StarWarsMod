package com.parzivail.pswm.gui;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.network.MessageHoloTableUpdate;
import com.parzivail.pswm.tileentities.TileEntityHoloTableBase;
import com.parzivail.util.ui.GLPalette;
import com.parzivail.util.ui.GuiScreen;
import com.parzivail.util.ui.LangUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.awt.*;

@SideOnly(Side.CLIENT)
public class GuiHoloTable extends GuiScreen
{
	private static final ResourceLocation guiTexture = new ResourceLocation(Resources.MODID, "textures/gui/icons2.png");

	private GuiButton buttonBlack;
	private GuiButton buttonWhite;
	private GuiButton buttonOffsetYUp;
	private GuiButton buttonOffsetYDown;
	private GuiButton buttonOffsetXUp;
	private GuiButton buttonOffsetXDown;
	private GuiButton buttonOffsetZUp;
	private GuiButton buttonOffsetZDown;
	private GuiButton buttonRefresh;

	private int offsetY;
	private int offsetX;
	private int offsetZ;
	private Color rgb;
	private int dim;
	private int xCoord;
	private int yCoord;
	private int zCoord;

	private int lColumn;
	private int rColumn;

	public GuiHoloTable(TileEntityHoloTableBase table)
	{
		this.mc = Minecraft.getMinecraft();
		this.dim = table.getWorldObj().provider.dimensionId;
		this.offsetX = table.getOffsetX();
		this.offsetY = table.getOffsetY();
		this.offsetZ = table.getOffsetZ();
		this.rgb = table.getRGB();
		this.xCoord = table.xCoord;
		this.yCoord = table.yCoord;
		this.zCoord = table.zCoord;

		this.rColumn = -20;
		this.lColumn = 5;
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if (button.enabled)
			if (button.id == this.buttonBlack.id)
				this.rgb = new Color(0.2f, 0.2f, 0.4f);
			else if (button.id == this.buttonWhite.id)
				this.rgb = new Color(0.4f, 0.4f, 1f);
			else if (button.id == this.buttonOffsetYUp.id)
				this.offsetY--;
			else if (button.id == this.buttonOffsetYDown.id)
				this.offsetY++;
			else if (button.id == this.buttonOffsetXUp.id)
				this.offsetX--;
			else if (button.id == this.buttonOffsetXDown.id)
				this.offsetX++;
			else if (button.id == this.buttonOffsetZUp.id)
				this.offsetZ--;
			else if (button.id == this.buttonOffsetZDown.id)
				this.offsetZ++;
		updateTable();
	}

	private void updateTable()
	{
		StarWarsMod.network.sendToServer(new MessageHoloTableUpdate(xCoord, yCoord, zCoord, dim, rgb.getRGB(), offsetX, offsetY, offsetZ));

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
		this.drawString(this.mc.fontRenderer, LangUtils.translate("holo.color"), x - 33 + this.lColumn, y - 65, GLPalette.WHITE);
		this.drawString(this.mc.fontRenderer, LangUtils.translate("holo.x.offset"), x - 94 + this.rColumn, y, GLPalette.WHITE);
		this.drawString(this.mc.fontRenderer, LangUtils.translate("holo.y.offset"), x - 18 + this.rColumn, y, GLPalette.WHITE);
		this.drawString(this.mc.fontRenderer, LangUtils.translate("holo.z.offset"), x + 58 + this.rColumn, y, GLPalette.WHITE);
		this.drawCenteredString(this.mc.fontRenderer, String.valueOf(offsetX), x - 60 + this.rColumn, y + 16, GLPalette.WHITE);
		this.drawCenteredString(this.mc.fontRenderer, String.valueOf(offsetY), x + 16 + this.rColumn, y + 16, GLPalette.WHITE);
		this.drawCenteredString(this.mc.fontRenderer, String.valueOf(offsetZ), x + 91 + this.rColumn, y + 16, GLPalette.WHITE);

		super.drawScreen(p_571_1_, p_571_2_, p_571_3_);
	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
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

		this.buttonBlack = new GuiButton(0, x - 30 + this.lColumn, y - 50, 40, 20, LangUtils.translate("dark"));
		this.buttonList.add(this.buttonBlack);

		this.buttonWhite = new GuiButton(1, x - 30 + this.lColumn, y - 28, 40, 20, LangUtils.translate("light"));
		this.buttonList.add(this.buttonWhite);

		this.buttonOffsetYUp = new GuiButton(2, x - 18 + this.rColumn, y + 10, 20, 20, "<");
		this.buttonList.add(this.buttonOffsetYUp);

		this.buttonOffsetYDown = new GuiButton(3, x + 30 + this.rColumn, y + 10, 20, 20, ">");
		this.buttonList.add(this.buttonOffsetYDown);

		this.buttonOffsetXUp = new GuiButton(4, x - 94 + this.rColumn, y + 10, 20, 20, "<");
		this.buttonList.add(this.buttonOffsetXUp);

		this.buttonOffsetXDown = new GuiButton(5, x - 46 + this.rColumn, y + 10, 20, 20, ">");
		this.buttonList.add(this.buttonOffsetXDown);

		this.buttonOffsetZUp = new GuiButton(6, x + 58 + this.rColumn, y + 10, 20, 20, "<");
		this.buttonList.add(this.buttonOffsetZUp);

		this.buttonOffsetZDown = new GuiButton(7, x + 104 + this.rColumn, y + 10, 20, 20, ">");
		this.buttonList.add(this.buttonOffsetZDown);

		this.buttonRefresh = new GuiButton(8, x - 18 + this.rColumn, y + 48, 68, 20, LangUtils.translate("refresh"));
		this.buttonList.add(this.buttonRefresh);
		/*
		 * if (keyCode == 1) { this.mc.displayGuiScreen((GuiScreen)null);
		 * this.mc.setIngameFocus(); }
		 */
	}
}
