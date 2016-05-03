package com.parzivail.pswm.quest;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.items.ItemQuestContainer;
import com.parzivail.util.ui.GLPalette;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiQuestLog extends GuiScreen
{
	private static final ResourceLocation guiTexture = new ResourceLocation(Resources.MODID, "textures/gui/icons3.png");

	private EntityPlayer player;
	private ItemStack questLog;

	public GuiQuestLog(EntityPlayer player)
	{
		this.mc = Minecraft.getMinecraft();
		this.player = player;
		this.questLog = ItemQuestContainer.getQuestContainer(player);
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		// if (button.enabled)
		// if (button.id == this.buttonBlack.id)
		// {
		// }
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
		if (this.questLog == null)
		{
			this.drawCenteredString(this.mc.fontRenderer, "Unable to find Quest Log", x, y - this.mc.fontRenderer.FONT_HEIGHT / 2, GLPalette.WHITE);
		}
		else
		{
			this.drawCenteredString(this.mc.fontRenderer, ItemQuestContainer.getOwner(questLog) + "'s Quest Log", x, y - 75, GLPalette.WHITE);
		}

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

		// this.buttonBlack = new GuiButton(0, x - 73 + this.lColumn, y - 30,
		// 40, 20, "Dark");
		// this.buttonList.add(this.buttonBlack);
	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return true;
	}
}
