package com.parzi.starwarsmod.rendering.gui;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.handlers.ClientEventHandler;
import com.parzi.starwarsmod.jedirobes.ArmorJediRobes;
import com.parzi.starwarsmod.jedirobes.powers.Power;
import com.parzi.starwarsmod.utils.ForceUtils;
import com.parzi.starwarsmod.utils.LangUtils;
import com.parzi.starwarsmod.utils.TextUtils;
import com.sun.security.ntlm.Client;

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

	private GuiButton learnButton;
	private GuiButton enableButton;

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

			if (stack != null)
			{
				item.power = Power.getPowerFromName(power);
				if (item.power != null)
					item.power.currentLevel = ArmorJediRobes.getLevelOf(stack, item.power.name);
			}

			items.add(item);
		}

		listWidth = Math.min(listWidth, 150);
		this.powerList = new GuiSlotPowerList(this, items, listWidth);
		this.powerList.registerScrollButtons(this.buttonList, 7, 8);

		learnButton = new GuiButton(20, 10, this.height - 60, this.listWidth, 20, "Learn");
		enableButton = new GuiButton(21, 10, this.height - 38, this.listWidth, 20, "Enable");
		this.buttonList.add(learnButton);
		this.buttonList.add(enableButton);
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if (button.enabled)
		{
			if (button.id == enableButton.id)
			{
				ClientEventHandler.activePower = selectedPower.power;
			}
			if (button.id == learnButton.id && selectedPower.power != null)
			{
				Power.getPowerFromName(selectedPower.power.name).currentLevel++;
			}
		}
	}

	public boolean canLearn(Power power)
	{
		if (power == null)
			return false;
		return power.currentLevel < power.maxLevel;
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
			this.drawCenteredString(this.fontRendererObj, String.format("Current Level: %s", (selectedPower.power == null ? 0 : selectedPower.power.currentLevel)), offset, 45, 0xFFFFFF);
			this.drawCenteredString(this.fontRendererObj, String.format("XP/use: %s", (selectedPower.power == null ? 0 : selectedPower.power.getCost())), offset, 55, 0xFFFFFF);
			this.drawCenteredString(this.fontRendererObj, String.format("Recharge Time: %s seconds", (selectedPower.power == null ? 0 : selectedPower.power.rechargeTime)), offset, 65, 0xFFFFFF);
			this.drawCenteredString(this.fontRendererObj, "Description and Use:", offset, 75, 0xDDDDDD);
			this.fontRendererObj.drawSplitString(selectedPower.localizedDesc, offset - 125, 85, 250, 0xDDDDDD);
			GL11.glDisable(GL11.GL_BLEND);

			if (selectedPower.power != null)
			{
				enableButton.enabled = selectedPower.power.currentLevel > 0 && ClientEventHandler.activePower != this.selectedPower.power;
				learnButton.enabled = canLearn(selectedPower.power);
			}
		}
		else
		{
			this.learnButton.enabled = false;
			this.enableButton.enabled = false;
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