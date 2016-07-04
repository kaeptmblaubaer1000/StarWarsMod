package com.parzivail.pswm.quest;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.tileentities.TileEntityStaticNpc;
import com.parzivail.util.math.Animation;
import com.parzivail.util.ui.GFX;
import com.parzivail.util.ui.GLPZ;
import com.parzivail.util.ui.GLPalette;
import com.parzivail.util.ui.TextUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import static com.parzivail.util.ui.GFX.swIcons;

@SideOnly(Side.CLIENT)
public class GuiQuestNpc extends GuiScreen
{
	private static final ResourceLocation background = new ResourceLocation(Resources.MODID, "textures/gui/space.png");

	private EntityPlayer player;
	private TileEntityStaticNpc questGiver;

	private Quest quest;
	private DialogTree currentTree;

	private GuiButton response1;
	private GuiButton response2;
	private GuiButton response3;
	private GuiButton close;

	String questId;

	Animation ticker;

	public GuiQuestNpc(EntityPlayer player, TileEntityStaticNpc questGiver)
	{
		this.mc = Minecraft.getMinecraft();
		this.player = player;

		this.questGiver = questGiver;

		this.quest = QuestNpcUtils.getNpcQuest(questGiver.getId());
		this.currentTree = quest.getDialog(player);
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if (button.enabled)
			if (this.response1 != null && button.id == this.response1.id)
			{
				currentTree = this.currentTree.response1DT;
				initGui();
			}
			else if (this.response2 != null && button.id == this.response2.id)
			{
				currentTree = this.currentTree.response2DT;
				initGui();
			}
			else if (this.response3 != null && button.id == this.response3.id)
			{
				currentTree = this.currentTree.response3DT;
				initGui();
			}
			else if (this.close != null && button.id == this.close.id)
			{
				this.mc.displayGuiScreen(null);
				this.mc.setIngameFocus();
			}
	}

	/**
	 * Draws the screen and all the components in it.
	 */
	@Override
	public void drawScreen(int mX, int mY, float parTicks)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		ScaledResolution r = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);

		drawBg2();

		int x = r.getScaledWidth() / 2;
		int y = r.getScaledHeight() / 2;
		int yy = 5;

		if (currentTree == quest.getDialog(player))
			GFX.drawCenteredText(mc.fontRenderer, questId.substring(0, (int)(questId.length() * ((float)ticker.getTick() / ticker.getLength()))), r.getScaledWidth() / 2f, yy += mc.fontRenderer.FONT_HEIGHT * 2, 2, GLPalette.SW_YELLOW);
		else
			GFX.drawCenteredText(mc.fontRenderer, questId, r.getScaledWidth() / 2f, yy += mc.fontRenderer.FONT_HEIGHT * 2, 2, GLPalette.SW_YELLOW);

		yy += 30;

		String[] words = TextUtils.splitIntoLine(currentTree.npcHeader, 60); //currentTree.npcHeader
		for (String line : words)
			this.drawCenteredString(this.mc.fontRenderer, line.substring(0, (int)(line.length() * ((float)ticker.getTick() / ticker.getLength()))), x, (yy += this.mc.fontRenderer.FONT_HEIGHT), GLPalette.WHITE);

		if (questGiver != null && questGiver.getInternalEntity() != null)
		{
			GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_LIGHTING);
			RenderHelper.enableGUIStandardItemLighting();
			GL11.glTranslatef(50, r.getScaledHeight() / 2f + 48, 10);
			GLPZ.glScalef(40f);
			GL11.glRotatef(questGiver.getInternalEntity().getRotationYawHead(), 0, 1, 0);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(10, 0, 1, 0);
			float old = RendererLivingEntity.NAME_TAG_RANGE;
			RendererLivingEntity.NAME_TAG_RANGE = 0.0F;
			Render render = RenderManager.instance.getEntityRenderObject(questGiver.getInternalEntity());
			render.doRender(questGiver.getInternalEntity(), 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
			RendererLivingEntity.NAME_TAG_RANGE = old;
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
		}

		GL11.glPushMatrix();
		GL11.glTranslatef(r.getScaledWidth() - 80, r.getScaledHeight() / 2f - 18, 10);
		GLPZ.glScalef(3);
		StarWarsMod.mc.renderEngine.bindTexture(swIcons);
		String s = QuestNpcUtils.getNpcSide(questGiver.getId());
		switch (s)
		{
			case Resources.allegianceJediFmt:
				GFX.drawTexture(0, 0, 0, 26, 16, 16);
				break;
			case Resources.allegianceSithFmt:
				GFX.drawTexture(0, 0, 17, 26, 16, 16);
				break;
			case Resources.allegianceRebelFmt:
				GFX.drawTexture(0, 0, 33, 26, 16, 16);
				break;
			case Resources.allegianceImperialFmt:
				GFX.drawTexture(0, 0, 49, 26, 16, 16);
				break;
		}
		GL11.glPopMatrix();

		super.drawScreen(mX, mY, parTicks);
	}

	private void drawBg2()
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
		this.questId = quest.getID();

		if (this.currentTree != null && this.currentTree.action != null)
			this.currentTree.action.accept(player);

		ScaledResolution r = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
		int x = r.getScaledWidth() / 2;
		int y = r.getScaledHeight() / 2;

		this.buttonList.clear();

		if (!currentTree.response1.equals(""))
		{
			String r1 = currentTree.response1;
			this.response1 = new GuiSWOutlineButton(0, x - 130, y - 10, 243, 20, r1);
			this.response1.visible = false;
			this.buttonList.add(this.response1);
		}
		if (!currentTree.response2.equals(""))
		{
			String r2 = currentTree.response2;
			this.response2 = new GuiSWOutlineButton(1, x - 130, y + 20, 243, 20, r2);
			this.response2.visible = false;
			this.buttonList.add(this.response2);
		}
		if (!currentTree.response3.equals(""))
		{
			String r3 = currentTree.response3;
			this.response3 = new GuiSWOutlineButton(2, x - 130, y + 50, 243, 20, r3);
			this.response3.visible = false;
			this.buttonList.add(this.response3);
		}
		if (currentTree.response1.equals("") && currentTree.response2.equals("") && currentTree.response3.equals(""))
		{
			this.close = new GuiSWOutlineButton(3, x - 24, y + 50, 48, 20, "Close");
			this.close.visible = false;
			this.buttonList.add(this.close);
		}

		ticker = new Animation(75, false, false);
		ticker.setOnAnimationEnd(animation -> {
			if (this.response1 != null)
				this.response1.visible = true;
			if (this.close != null)
				this.close.visible = true;
		});
		ticker.start();

		Animation ticker2 = new Animation(90, false, false);
		ticker2.setOnAnimationEnd(animation -> {
			if (this.response2 != null)
				this.response2.visible = true;
		});
		ticker2.start();

		Animation ticker3 = new Animation(105, false, false);
		ticker3.setOnAnimationEnd(animation -> {
			if (this.response3 != null)
				this.response3.visible = true;
		});
		ticker3.start();
	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}
}
