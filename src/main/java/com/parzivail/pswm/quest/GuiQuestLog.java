package com.parzivail.pswm.quest;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.dimension.PlanetInformation;
import com.parzivail.pswm.items.ItemQuestContainer;
import com.parzivail.util.ui.GLPalette;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiQuestLog extends GuiScreen
{
	private static final ResourceLocation guiTexture = new ResourceLocation(Resources.MODID, "textures/gui/icons2.png");

	private EntityPlayer player;

	ScaledResolution r;

	private ItemStack qlog;

	public GuiQuestLog(EntityPlayer player)
	{
		this.mc = Minecraft.getMinecraft();
		this.player = player;
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if (button.enabled && button.visible)
		{

		}
	}

	/**
	 * Draws the screen and all the components in it.
	 */
	@Override
	public void drawScreen(int p_571_1_, int p_571_2_, float p_571_3_)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		this.mc.getTextureManager().bindTexture(guiTexture);
		this.drawTexturedModalRect((r.getScaledWidth() - 248) / 2, (r.getScaledHeight() - 166) / 2, 0, 60, 248, 166);

		if (qlog != null)
		{
			int x = r.getScaledWidth() / 2;
			int y = r.getScaledHeight() / 2;
			int yy = 0;
			this.drawCenteredString(fontRendererObj, ItemQuestContainer.getOwner(qlog) + "'s Quest Log", x, y - 85 + (yy += this.mc.fontRenderer.FONT_HEIGHT), GLPalette.WHITE);

			yy += this.mc.fontRenderer.FONT_HEIGHT;

			this.drawString(fontRendererObj, "Courses Plotted:", x - 115, y - 85 + (yy += this.mc.fontRenderer.FONT_HEIGHT), GLPalette.WHITE);
			for (PlanetInformation info : Resources.planetInformation)
			{
				if (ItemQuestContainer.getHasHyperdrive(qlog, info.getInternalName()))
					this.drawString(fontRendererObj, info.getName(), x - 105, y - 85 + (yy += this.mc.fontRenderer.FONT_HEIGHT), GLPalette.WHITE);
			}
		}

		super.drawScreen(p_571_1_, p_571_2_, p_571_3_);
	}

	/**
	 * Adds the buttons (and other controls) to the screen in question.
	 */
	@Override
	public void initGui()
	{
		r = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
		int x = r.getScaledWidth() / 2;
		int y = r.getScaledHeight() / 2;

		qlog = ItemQuestContainer.getQuestContainer(player);
	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return true;
	}
}
