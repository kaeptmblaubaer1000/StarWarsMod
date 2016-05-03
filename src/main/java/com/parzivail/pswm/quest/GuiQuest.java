package com.parzivail.pswm.quest;

import org.lwjgl.opengl.GL11;

import com.parzivail.pswm.Resources;
import com.parzivail.util.ui.GLPalette;
import com.parzivail.util.ui.TextUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GuiQuest extends GuiScreen
{
	private static final ResourceLocation guiTexture = new ResourceLocation(Resources.MODID, "textures/gui/icons3.png");

	private EntityPlayer player;

	private DialogTree tree;
	private DialogTree currentTree;
	// private Response currentResponse;

	private GuiButton response1;
	private GuiButton response2;
	private GuiButton response3;
	private GuiButton close;
	
	String questGiver;

	public GuiQuest(EntityPlayer player)
	{
		this.mc = Minecraft.getMinecraft();
		this.player = player;
		// this.tree = QuestBank.quest3TicketToTheGalaxy.getDialog(player);
		this.currentTree = tree;
		
		// TODO: make the questGiver populated with the NBT tag "id"'s value of the quest block tile entity
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if (button.enabled)
			if (button.id == this.response1.id)
			{
				// currentTree = this.currentTree.response1.npcDialog;
				initGui();
			}
			else if (button.id == this.response2.id)
			{
				// currentTree = this.currentTree.response2.npcDialog;
				initGui();
			}
			else if (button.id == this.response3.id)
			{
				// currentTree = this.currentTree.response3.npcDialog;
				initGui();
			}
			else if (button.id == this.close.id)
			{
				this.mc.displayGuiScreen((GuiScreen)null);
				this.mc.setIngameFocus();
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
		int yy = 0;
		String[] words = TextUtils.splitIntoLine(currentTree.npcHeader, 40);
		for (String line : words)
			this.drawCenteredString(this.mc.fontRenderer, line, x, y - 85 + (yy += this.mc.fontRenderer.FONT_HEIGHT), GLPalette.WHITE);

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

		this.buttonList.clear();

		// if (currentTree.response1 != null)
		// {
		// String r1 = currentTree.response1.text;
		// this.response1 = new GuiQuestButton(0, x - 100, y - 10, 198, 20, r1);
		// this.buttonList.add(this.response1);
		// }
		// if (currentTree.response2 != null)
		// {
		// String r2 = currentTree.response2.text;
		// this.response2 = new GuiQuestButton(1, x - 100, y + 20, 198, 20, r2);
		// this.buttonList.add(this.response2);
		// }
		// if (currentTree.response3 != null)
		// {
		// String r3 = currentTree.response3.text;
		// this.response3 = new GuiQuestButton(2, x - 100, y + 50, 198, 20, r3);
		// this.buttonList.add(this.response3);
		// }
		// if (currentTree.response1 == null && currentTree.response2 == null &&
		// currentTree.response3 == null)
		// {
		// this.close = new GuiQuestButton(3, x - 24, y + 50, 48, 20, "Close");
		// this.buttonList.add(this.close);
		// }
	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return true;
	}
}
