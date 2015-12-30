package com.parzi.starwarsmod.rendering.gui;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.google.common.base.Strings;
import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.ForceUtils;
import com.parzi.starwarsmod.utils.GlPalette;
import com.parzi.starwarsmod.utils.LangUtils;
import com.parzi.starwarsmod.utils.TextUtils;
import com.sun.corba.se.spi.ior.iiop.GIOPVersion;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.GuiModList;
import cpw.mods.fml.client.GuiSlotModList;
import cpw.mods.fml.client.IModGuiFactory;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.ModContainer.Disableable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiScreenJediRobes extends GuiScreen
{
	private GuiScreen mainMenu;
	private GuiSlotPowerList powerList;
	private int selected = -1;
	private GuiPowerListItem selectedPower;
	private int listWidth = 0;
	private String[] powers;
	private ResourceLocation cachedLogo;
	private Dimension cachedLogoDimensions;

	private ItemStack stack;
	private EntityPlayer player;

	public GuiScreenJediRobes(EntityPlayer player)
	{
		mc = Minecraft.getMinecraft();
		this.stack = player.getEquipmentInSlot(3);
		this.player = player;

		this.powers = ForceUtils.getAllPowers();
	}

	/**
	 * Adds the buttons (and other controls) to the screen in question.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void initGui()
	{
		ArrayList<GuiPowerListItem> items = new ArrayList<GuiPowerListItem>();
		for (String power : powers)
		{
			listWidth = Math.max(listWidth, getFontRenderer().getStringWidth(LangUtils.translate(power)) + 10);
			GuiPowerListItem item = new GuiPowerListItem();
			item.localizedName = LangUtils.translate("force.power." + power);
			item.localizedDesc = LangUtils.translate("force.power." + power + ".desc");
			items.add(item);
		}
		listWidth = Math.min(listWidth, 150);
		this.powerList = new GuiSlotPowerList(this, items, listWidth);
		this.powerList.registerScrollButtons(this.buttonList, 7, 8);
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if (button.enabled)
		{
			switch (button.id)
			{
			}
		}
		super.actionPerformed(button);
	}

	public int drawLine(String line, int offset, int shifty)
	{
		this.fontRendererObj.drawString(line, offset, shifty, 0xd7edea);
		return shifty + 10;
	}

	/**
	 * Draws the screen and all the components in it.
	 */
	@Override
	public void drawScreen(int p_571_1_, int p_571_2_, float p_571_3_)
	{
		this.powerList.drawScreen(p_571_1_, p_571_2_, p_571_3_);
		int offset = (this.listWidth + this.width) / 2;
		this.drawCenteredString(this.fontRendererObj, "Jedi Apprentice " + TextUtils.makeItalic(player.getCommandSenderName()), offset, 16, 0xFFFFFF);
		if (selectedPower != null)
		{
			GL11.glEnable(GL11.GL_BLEND);
			this.drawCenteredString(this.fontRendererObj, selectedPower.localizedName, offset, 35, 0xFFFFFF);
			this.drawCenteredString(this.fontRendererObj, String.format("Current Level: %s", selectedPower.currentLevel), offset, 45, 0xFFFFFF);
			this.drawCenteredString(this.fontRendererObj, "Description and Use:", offset, 55, 0xDDDDDD);
			this.fontRendererObj.drawSplitString(selectedPower.localizedDesc, offset - 125, 65, 250, 0xDDDDDD);
			GL11.glDisable(GL11.GL_BLEND);
		}
		super.drawScreen(p_571_1_, p_571_2_, p_571_3_);
	}

	public void drawBg2()
	{
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_FOG);
        Tessellator tessellator = Tessellator.instance;
        this.mc.getTextureManager().bindTexture(optionsBackground);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        float f = 32.0F;
        tessellator.startDrawingQuads();
        tessellator.setColorOpaque_I(4210752);
        tessellator.addVertexWithUV(0.0D, (double)this.height, 0.0D, 0.0D, (double)((float)this.height / f + 1));
        tessellator.addVertexWithUV((double)this.width, (double)this.height, 0.0D, (double)((float)this.width / f), (double)((float)this.height / f + 1));
        tessellator.addVertexWithUV((double)this.width, 0.0D, 0.0D, (double)((float)this.width / f), 1);
        tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 1);
        tessellator.draw();
	}

	Minecraft getMinecraftInstance()
	{
		/** Reference to the Minecraft object. */
		return mc;
	}

	FontRenderer getFontRenderer()
	{
		/** The FontRenderer used by GuiScreen */
		return fontRendererObj;
	}

	/**
	 * @param var1
	 */
	public void selectIndex(int var1)
	{
		this.selected = var1;
		if (var1 >= 0 && var1 <= powerList.getSize())
		{
			this.selectedPower = powerList.powers.get(selected);
		}
		else
		{
			this.selectedPower = null;
		}
	}

	public boolean indexSelected(int var1)
	{
		return var1 == selected;
	}
}