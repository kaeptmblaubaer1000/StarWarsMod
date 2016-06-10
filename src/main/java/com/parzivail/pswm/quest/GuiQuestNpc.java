package com.parzivail.pswm.quest;

import com.parzivail.pswm.Resources;
import com.parzivail.util.ui.GLPalette;
import com.parzivail.util.ui.TextUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiQuestNpc extends GuiScreen
{
	private static final ResourceLocation background = new ResourceLocation(Resources.MODID, "textures/gui/space.png");

	private EntityPlayer player;

	private DialogTree tree;
	private DialogTree currentTree;
	// private Response currentResponse;

	private GuiButton response1;
	private GuiButton response2;
	private GuiButton response3;
	private GuiButton close;

	String questId;

	public GuiQuestNpc(EntityPlayer player, String questId)
	{
		this.mc = Minecraft.getMinecraft();
		this.player = player;
		this.tree = QuestBank.rebel1.getDialog(player);
		this.currentTree = tree;

		this.questId = questId;

		if (this.tree != null && this.tree.action != null)
			this.tree.action.accept(player);
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
				this.mc.displayGuiScreen(null);
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

		drawBg2();

		int x = r.getScaledWidth() / 2;
		int y = r.getScaledHeight() / 2;
		int yy = 0;
		this.drawCenteredString(fontRendererObj, questId, x, y - 85 + (yy += this.mc.fontRenderer.FONT_HEIGHT), GLPalette.WHITE);
		String[] words = TextUtils.splitIntoLine("blah blah blah", 40); //currentTree.npcHeader
		for (String line : words)
			this.drawCenteredString(this.mc.fontRenderer, line, x, y - 85 + (yy += this.mc.fontRenderer.FONT_HEIGHT), GLPalette.WHITE);

		super.drawScreen(p_571_1_, p_571_2_, p_571_3_);
	}

	public void drawBg2()
	{
		Tessellator tessellator = Tessellator.instance;
		this.mc.getTextureManager().bindTexture(background);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		float f = 200.0F;
		tessellator.startDrawingQuads();
		tessellator.setColorOpaque_I(0xFFFFFFFF);
		tessellator.addVertexWithUV(0.0D, this.height, 0.0D, 0.0D, this.height / f + 1);
		tessellator.addVertexWithUV(this.width, this.height, 0.0D, this.width / f, this.height / f + 1);
		tessellator.addVertexWithUV(this.width, 0.0D, 0.0D, this.width / f, 1);
		tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 1);
		tessellator.draw();
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
