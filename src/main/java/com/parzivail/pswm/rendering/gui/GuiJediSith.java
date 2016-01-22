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
import com.parzivail.pswm.utils.ForceUtils;
import com.parzivail.util.ui.GlPalette;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiJediSith extends GuiScreen
{
	private static final ResourceLocation guiTexture = new ResourceLocation(Resources.MODID, "textures/gui/icons.png");

	private GuiButtonJedi jediButton;
	private GuiButtonSith sithButton;

	private ItemStack stack;
	private EntityPlayer player;

	public GuiJediSith(EntityPlayer player)
	{
		this.mc = Minecraft.getMinecraft();
		this.stack = player.getEquipmentInSlot(3);
		this.player = player;
	}

	/**
	 * Adds the buttons (and other controls) to the screen in question.
	 */
	@Override
	public void initGui()
	{
		ScaledResolution r = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		int x = r.getScaledWidth() / 2;
		int y = r.getScaledHeight() / 2;

		this.jediButton = new GuiButtonJedi(1, x - 37, y + 15);
		this.buttonList.add(this.jediButton);

		this.sithButton = new GuiButtonSith(2, x + 20, y + 15);
		this.buttonList.add(this.sithButton);
		/*
		 * if (p_73869_2_ == 1) { this.mc.displayGuiScreen((GuiScreen)null);
		 * this.mc.setIngameFocus(); }
		 */
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if (button.enabled)
		{
			if (button.id == this.jediButton.id)
			{
				ForceUtils.addLeaderboardSide("jedi");
				this.mc.displayGuiScreen((GuiScreen)null);
				this.mc.setIngameFocus();
				StarWarsMod.network.sendToServer(new PacketRobesStringNBT(Resources.nbtSide, ArmorJediRobes.SIDE_JEDI, player.dimension, player.getCommandSenderName()));
				stack.stackTagCompound.setString(Resources.nbtSide, ArmorJediRobes.SIDE_JEDI);
			}
			else if (button.id == this.sithButton.id)
			{
				ForceUtils.addLeaderboardSide("sith");
				this.mc.displayGuiScreen((GuiScreen)null);
				this.mc.setIngameFocus();
				StarWarsMod.network.sendToServer(new PacketRobesStringNBT(Resources.nbtSide, ArmorJediRobes.SIDE_SITH, player.dimension, player.getCommandSenderName()));
				stack.stackTagCompound.setString(Resources.nbtSide, ArmorJediRobes.SIDE_SITH);
			}
		}
	}

	/**
	 * Fired when a key is typed. This is the equivalent of
	 * KeyListener.keyTyped(KeyEvent e).
	 */
	@Override
	protected void keyTyped(char p_73869_1_, int p_73869_2_)
	{
		// don't exit on escape, force player to choose
	}

	/**
	 * Draws the screen and all the components in it.
	 */
	@Override
	public void drawScreen(int p_571_1_, int p_571_2_, float p_571_3_)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		ScaledResolution r = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);

		this.mc.getTextureManager().bindTexture(guiTexture);
		this.drawTexturedModalRect((r.getScaledWidth() - 248) / 2, (r.getScaledHeight() - 166) / 2, 0, 60, 248, 166);

		int x = (int)(r.getScaledWidth() / 2);
		int y = (int)(r.getScaledHeight() / 2);
		int dy = y - 80;
		this.drawCenteredString(mc.fontRenderer, "You have a nightmare.", x, dy += 10, GlPalette.WHITE);
		this.drawCenteredString(mc.fontRenderer, "A Dark Man speaks to you.", x, dy += 10, GlPalette.WHITE);
		dy += 10;
		this.drawCenteredString(mc.fontRenderer, "He wants to share his secrets.", x, dy += 10, GlPalette.LIGHT_RED);
		this.drawCenteredString(mc.fontRenderer, "His dark knowledge.", x, dy += 10, GlPalette.RED);
		dy += 10;
		this.drawCenteredString(mc.fontRenderer, "Do you accept?", x, dy += 10, GlPalette.WHITE);

		this.drawString(mc.fontRenderer, "Never.", x - 73, y + 19, GlPalette.WHITE);
		this.drawString(mc.fontRenderer, "Show me.", x + 38, y + 19, GlPalette.WHITE);

		super.drawScreen(p_571_1_, p_571_2_, p_571_3_);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\gui\GuiMV.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */