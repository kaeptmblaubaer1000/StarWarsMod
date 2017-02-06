package com.parzivail.pswm.gui;

import com.parzivail.pswm.PSWM;
import com.parzivail.util.lwjgl.Vector2f;
import com.parzivail.util.ui.GFX;
import com.parzivail.util.ui.GLPalette;
import net.minecraft.client.gui.GuiButton;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Rectangle;

/**
 * Created by colby on 2/5/2017.
 */
public class GuiWindowLayer
{
	PGui parent;
	private Rectangle originalBounds;
	Rectangle bounds;
	String title;
	int layer;

	Rectangle titleBarRectangle;
	private Rectangle btnCloseRectangle;
	private Rectangle btnMinimizeRectangle;

	public boolean minimized;

	private boolean dragging;
	private Vector2f dragOffset;

	boolean[] oldMouse = new boolean[3];
	boolean[] mouse = new boolean[3];

	public GuiWindowLayer(PGui parent, Rectangle bounds, String title)
	{
		this.parent = parent;
		this.bounds = originalBounds = bounds;
		this.title = title;

		this.titleBarRectangle = new Rectangle(0, 0, this.bounds.getWidth(), 5);
		this.btnCloseRectangle = new Rectangle(this.bounds.getWidth() - 4, 1, 4, 4);
		this.btnMinimizeRectangle = new Rectangle(this.bounds.getWidth() - 9, 1, 4, 4);
	}

	public void draw(int mouseX, int mouseY, float partialTicks)
	{
		Vector2f globalMouse = new Vector2f(mouseX, mouseY);
		mouseX -= bounds.getX();
		mouseY -= bounds.getY();

		this.oldMouse = this.mouse.clone();
		this.mouse = new boolean[] { Mouse.isButtonDown(0), Mouse.isButtonDown(1), Mouse.isButtonDown(2) };

		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GFX.scissor(this.bounds.getX() - 1, this.bounds.getY() - 1, this.bounds.getWidth() + 2, this.minimized ? this.titleBarRectangle.getHeight() + 1 : this.bounds.getHeight() + 2);
		for (int i = 0; i < this.mouse.length; i++)
			this.mouse[i] = this.mouse[i] && (!this.minimized || this.titleBarRectangle.contains(mouseX, mouseY) || this.dragging);

		GLPalette.glColorI(GLPalette.BLACK);
		GFX.rectangle(this.bounds, true);

		GLPalette.glColorI(GLPalette.WHITE);
		GFX.rectangle(this.bounds, false);

		GL11.glTranslatef(this.bounds.getX(), this.bounds.getY(), this.layer);

		GL11.glPushMatrix();
		this.drawInterior(mouseX, mouseY, partialTicks);
		GL11.glPopMatrix();

		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GLPalette.glColorI(GLPalette.WHITE);

		GFX.rectangle(this.titleBarRectangle, true);
		GFX.drawText(PSWM.mc.fontRendererObj, this.title, 0.8f, 0.8f, 0.5f, GLPalette.BLACK);

		GLPalette.glColorI(GLPalette.ANALOG_RED);
		GFX.drawFilledCircle(this.bounds.getWidth() - 2.5f, 2.5f, 2);
		if (btnCloseRectangle.contains(mouseX, mouseY))
		{
			GLPalette.glColorI(GLPalette.WHITE);
			GL11.glLineWidth(2);
			GFX.drawLine(this.bounds.getWidth() - 3.5f, 3.5f, this.bounds.getWidth() - 1.5f, 1.5f);
			GFX.drawLine(this.bounds.getWidth() - 3.5f, 1.5f, this.bounds.getWidth() - 1.5f, 3.5f);
			GL11.glLineWidth(1);

			if (mouse[0] && !oldMouse[0])
				parent.removeWindow(this);
		}

		GLPalette.glColorI(GLPalette.ANALOG_BLUE);
		GFX.drawFilledCircle(this.bounds.getWidth() - 7.5f, 2.5f, 2);
		if (btnMinimizeRectangle.contains(mouseX, mouseY))
		{
			GLPalette.glColorI(GLPalette.WHITE);
			GL11.glLineWidth(2);
			GFX.drawLine(this.bounds.getWidth() - 8.5f, 2.5f, this.bounds.getWidth() - 6.5f, 2.5f);
			GL11.glLineWidth(1);

			if (mouse[0] && !oldMouse[0])
				this.minimized = !this.minimized;
		}

		if (mouse[0])
		{
			if (!dragging)
				this.dragOffset = new Vector2f(mouseX, mouseY);
			this.dragging = dragging || this.titleBarRectangle.contains(mouseX, mouseY);
		}
		else
			this.dragging = false;

		if (this.dragging)
			this.bounds.setLocation((int)(globalMouse.x - this.dragOffset.x), (int)(globalMouse.y - this.dragOffset.y));

		GFX.endScissor();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glPopMatrix();
	}

	public void drawInterior(int mouseX, int mouseY, float partialTicks)
	{
	}

	public void actionPerformed(GuiButton button)
	{
	}

	public void updateScreen()
	{
	}

	public void keyTyped(char typedChar, int keyCode)
	{
	}
}
