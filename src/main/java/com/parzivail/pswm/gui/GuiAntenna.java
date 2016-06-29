package com.parzivail.pswm.gui;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.tileentities.TileEntityAntenna;
import com.parzivail.util.ui.ConsoleKnobRange;
import com.parzivail.util.ui.GFX;
import com.parzivail.util.ui.GLPZ;
import com.parzivail.util.ui.GLPalette;
import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import org.lwjgl.opengl.GL11;

public class GuiAntenna extends GuiScreen
{
	EntityPlayer player;
	private TileEntityAntenna antenna;

	private ConsoleKnobRange sliderRX;
	private ConsoleKnobRange sliderRY;
	private ConsoleKnobRange sliderRZ;

	private float w;
	private float h;

	private float bW;
	private float bH;

	private float scale = 0.1f;
	private int blocks = 30;

	private int listBlocks = -1;
	private boolean alreadyGen = false;

	private RenderBlocks renderBlocks = new RenderBlocks();

	public GuiAntenna(EntityPlayer player, TileEntityAntenna antenna)
	{
		this.antenna = antenna;
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if (button.visible && button.enabled)
		{
		}
	}

	@Override
	public void initGui()
	{
		ScaledResolution r = new ScaledResolution(StarWarsMod.mc, StarWarsMod.mc.displayWidth, StarWarsMod.mc.displayHeight);

		w = r.getScaledWidth();
		h = r.getScaledHeight();

		bW = w - 60;
		bH = h - 50;

		int id = 0;

		sliderRX = new ConsoleKnobRange(id++, (int)(25 + this.bW - 70), 10, 20, 0, -45, 45, "X");
		sliderRX.colorFg = GLPalette.ANALOG_RED;
		sliderRY = new ConsoleKnobRange(id++, (int)(25 + this.bW - 35), 10, 20, 0, -180, 180, "Y");
		sliderRY.colorFg = GLPalette.ANALOG_GREEN;
		sliderRZ = new ConsoleKnobRange(id, (int)(25 + this.bW), 10, 20, 0, -45, 45, "Z");
		sliderRZ.colorFg = GLPalette.ANALOG_BLUE;

		this.buttonList.add(sliderRX);
		this.buttonList.add(sliderRY);
		this.buttonList.add(sliderRZ);

		renderBlocks.blockAccess = antenna.getWorldObj();
	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}

	@Override
	public void drawScreen(int x, int y, float n)
	{
		GL11.glPushMatrix();

		GL11.glDisable(GL11.GL_LIGHTING); // fix for dimming bug!
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);

		GLPalette.glColorI(GLPalette.ALMOST_BLACK);
		GFX.drawRectangle(0, 0, w, h, true);

		GLPalette.glColorI(GLPalette.WHITE);

		renderGrid(n);

		renderRotationThing();

		GL11.glPushMatrix();
		GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glTranslatef(0, 0, 5);
		super.drawScreen(x, y, n);
		GL11.glPopMatrix();

		GL11.glDisable(GL11.GL_LINE_SMOOTH);
		GL11.glEnable(GL11.GL_LIGHTING); // end of fix

		GL11.glPopMatrix();
	}

	/**
	 * Renders the rotation indicator thing
	 */
	private void renderRotationThing()
	{
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);

		GL11.glTranslated(this.bW + 25, (int)(25 + this.bH), 15);

		GL11.glRotatef(sliderRX.getValue(), 1, 0, 0);
		GL11.glRotatef(sliderRY.getValue(), 0, 1, 0);
		GL11.glRotatef(sliderRZ.getValue(), 0, 0, 1);

		GLPalette.glColorI(GLPalette.ANALOG_RED);
		GL11.glBegin(GL11.GL_LINE_STRIP);
		GL11.glVertex3d(-15, 0, 0);
		GL11.glVertex3d(-12, 3, 0);
		GL11.glVertex3d(-12, -3, 0);
		GL11.glVertex3d(-15, 0, 0);
		GL11.glVertex3d(15, 0, 0);
		GL11.glEnd();

		GLPalette.glColorI(GLPalette.ANALOG_GREEN);
		GL11.glBegin(GL11.GL_LINE_STRIP);
		GL11.glVertex3d(0, -15, 0);
		GL11.glVertex3d(3, -12, 0);
		GL11.glVertex3d(-3, -12, 0);
		GL11.glVertex3d(0, -15, 0);
		GL11.glVertex3d(0, 15, 0);
		GL11.glEnd();

		GLPalette.glColorI(GLPalette.ANALOG_BLUE);
		GL11.glBegin(GL11.GL_LINE_STRIP);
		GL11.glVertex3d(0, 0, -15);
		GL11.glVertex3d(0, 0, 15);
		GL11.glVertex3d(0, 3, 12);
		GL11.glVertex3d(0, -3, 12);
		GL11.glVertex3d(0, 0, 15);
		GL11.glEnd();

		GL11.glPopMatrix();
	}

	/**
	 * Renders the grid
	 */
	private void renderGrid(float p)
	{
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		RenderHelper.enableStandardItemLighting();
		GL11.glTranslatef(this.w / 2f, this.h / 2f + 50, 200);
		GLPZ.glScalef(25);
		GL11.glRotatef(sliderRX.getValue(), 1, 0, 0);
		GL11.glRotatef(sliderRY.getValue(), 0, 1, 0);
		GL11.glRotatef(sliderRZ.getValue(), 0, 0, 1);

		for (Object e : antenna.getWorldObj().getEntitiesWithinAABB(Entity.class, antenna.getRenderBoundingBox().expand(blocks, blocks, blocks)))
			if (e instanceof Entity)
			{
				if (e == StarWarsMod.mc.thePlayer)
					continue;
				Entity entity = (Entity)e;
				GL11.glPushMatrix();

				GL11.glScalef(1, -1, 1);
				GLPZ.glScalef(scale);
				GL11.glTranslated(entity.posX - antenna.xCoord, entity.posY - antenna.yCoord, entity.posZ - antenna.zCoord);
				GL11.glTranslatef(-1, 0, -1);
				GL11.glColor4f(1, 1, 1, 1);
				com.parzivail.util.ui.RenderHelper.renderEntity(entity, p);
				GL11.glPopMatrix();
			}

		if (!alreadyGen)
		{
			alreadyGen = true;
			listBlocks = GL11.glGenLists(1);
			GL11.glNewList(listBlocks, GL11.GL_COMPILE_AND_EXECUTE);

			Block b;

			GL11.glScalef(1, -1, 1);
			GLPZ.glScalef(scale);
			GL11.glColor4f(1, 1, 1, 1);
			for (int x = -blocks; x < blocks; x++)
				for (int y = -blocks / 2; y < blocks / 2; y++)
					for (int z = -blocks; z < blocks; z++)
						if ((b = antenna.getWorldObj().getBlock(antenna.xCoord + x, antenna.yCoord + y, antenna.zCoord + z)) != null)
						{
							if (b == Blocks.air)
								continue;
							GL11.glPushMatrix();
							GL11.glTranslatef(x, y, z);
							mc.renderEngine.bindTexture(TextureMap.locationBlocksTexture);
							renderBlocks.renderBlockAsItem(b, antenna.getWorldObj().getBlockMetadata(antenna.xCoord + x, antenna.yCoord + y, antenna.zCoord + z), 1);
							GL11.glPopMatrix();
						}
			GL11.glEndList();
		}
		else
		{
			GL11.glCallList(listBlocks);
		}

		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_LIGHTING);

		GL11.glPopMatrix();
	}
}