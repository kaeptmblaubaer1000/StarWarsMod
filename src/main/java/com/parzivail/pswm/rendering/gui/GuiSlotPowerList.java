package com.parzivail.pswm.rendering.gui;

import java.util.ArrayList;
import java.util.Arrays;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.utils.ForceUtils;
import com.parzivail.util.ui.GLPalette;

import cpw.mods.fml.client.GuiScrollingList;

public class GuiSlotPowerList extends GuiScrollingList
{
	private static ResourceLocation background;
	private static ResourceLocation background2;
	private GuiScreenJediRobes parent;
	public ArrayList<GuiPowerListItem> powers;
	private Minecraft client;
	private int listWidth;
	private int listHeight;
	private int top;
	private int bottom;
	private int right;
	private int left;
	private int slotHeight;
	private int scrollUpActionId;
	private int scrollDownActionId;
	private int mouseX;
	private int mouseY;
	private float initialMouseClickY = -2.0F;
	private float scrollFactor;
	private float scrollDistance;
	private int selectedIndex = -1;
	private long lastClickTime = 0L;
	private boolean field_25123_p = true;

	private boolean field_27262_q;
	private int field_27261_r;

	public GuiSlotPowerList(GuiScreenJediRobes parent, ArrayList<GuiPowerListItem> powers, int listWidth)
	{
		super(parent.getMinecraftInstance(), listWidth, parent.height, 32, parent.height - 66 + 4, 10, 35);
		this.parent = parent;
		this.powers = powers;

		this.client = parent.getMinecraftInstance();
		this.listWidth = listWidth;
		this.listHeight = parent.height;
		this.top = 32;
		this.bottom = parent.height - 66 + 4;
		this.slotHeight = 35;
		this.left = 10;
		this.right = listWidth + this.left;

		background = new ResourceLocation(Resources.MODID, "textures/gui/space.png");
		background2 = new ResourceLocation(Resources.MODID, "textures/gui/space2.png");
	}

	private void applyScrollLimits()
	{
		int var1 = this.getContentHeight() - (this.bottom - this.top - 4);

		if (var1 < 0)
			var1 /= 2;

		if (this.scrollDistance < 0.0F)
			this.scrollDistance = 0.0F;

		if (this.scrollDistance > var1)
			this.scrollDistance = var1;
	}

	@Override
	protected void drawBackground()
	{
		this.parent.drawDefaultBackground();
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float p_22243_3_)
	{
		this.mouseX = mouseX;
		this.mouseY = mouseY;
		this.drawBackground();
		int listLength = this.getSize();
		int scrollBarXStart = this.left + this.listWidth - 6;
		int scrollBarXEnd = scrollBarXStart + 6;
		int boxLeft = this.left;
		int boxRight = scrollBarXStart - 1;
		int var10;
		int var11;
		int var13;
		int var19;

		float f = 256F;
		float var17 = f;

		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_FOG);
		Tessellator tessellator = Tessellator.instance;
		this.client.getTextureManager().bindTexture(background);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		tessellator.startDrawingQuads();
		tessellator.setColorOpaque_I(0xFFFFFF);
		tessellator.addVertexWithUV(0.0D, this.parent.height, 0.0D, 0.0D, this.parent.height / f + 1);
		tessellator.addVertexWithUV(this.parent.width, this.parent.height, 0.0D, this.parent.width / f, this.parent.height / f + 1);
		tessellator.addVertexWithUV(this.parent.width, 0.0D, 0.0D, this.parent.width / f, 1);
		tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 1);
		tessellator.draw();

		if (Mouse.isButtonDown(0))
		{
			if (this.initialMouseClickY == -1.0F)
			{
				boolean var7 = true;

				if (mouseY >= this.top && mouseY <= this.bottom)
				{
					var10 = mouseY - this.top - this.field_27261_r + (int)this.scrollDistance - 4;
					var11 = var10 / this.slotHeight;

					if (mouseX >= boxLeft && mouseX <= boxRight && var11 >= 0 && var10 >= 0 && var11 < listLength)
					{
						boolean var12 = var11 == this.selectedIndex && System.currentTimeMillis() - this.lastClickTime < 250L;
						this.elementClicked(var11, var12);
						this.selectedIndex = var11;
						this.lastClickTime = System.currentTimeMillis();
					}
					else if (mouseX >= boxLeft && mouseX <= boxRight && var10 < 0)
					{
						this.func_27255_a(mouseX - boxLeft, mouseY - this.top + (int)this.scrollDistance - 4);
						var7 = false;
					}

					if (mouseX >= scrollBarXStart && mouseX <= scrollBarXEnd)
					{
						this.scrollFactor = -1.0F;
						var19 = this.getContentHeight() - (this.bottom - this.top - 4);

						if (var19 < 1)
							var19 = 1;

						var13 = (int)((float)((this.bottom - this.top) * (this.bottom - this.top)) / (float)this.getContentHeight());

						if (var13 < 32)
							var13 = 32;

						if (var13 > this.bottom - this.top - 8)
							var13 = this.bottom - this.top - 8;

						this.scrollFactor /= (float)(this.bottom - this.top - var13) / (float)var19;
					}
					else
						this.scrollFactor = 1.0F;

					if (var7)
						this.initialMouseClickY = mouseY;
					else
						this.initialMouseClickY = -2.0F;
				}
				else
					this.initialMouseClickY = -2.0F;
			}
			else if (this.initialMouseClickY >= 0.0F)
			{
				this.scrollDistance -= (mouseY - this.initialMouseClickY) * this.scrollFactor;
				this.initialMouseClickY = mouseY;
			}
		}
		else
		{
			while (Mouse.next())
			{
				int var16 = Mouse.getEventDWheel();

				if (var16 != 0)
				{
					if (var16 > 0)
						var16 = -1;
					else if (var16 < 0)
						var16 = 1;

					this.scrollDistance += var16 * this.slotHeight / 2;
				}
			}

			this.initialMouseClickY = -1.0F;
		}

		this.applyScrollLimits();
		Tessellator tesselator = Tessellator.instance;

		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_FOG);
		this.client.renderEngine.bindTexture(background);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		tesselator.startDrawingQuads();
		tesselator.setColorOpaque_I(0x888888);
		tesselator.addVertexWithUV(this.left, this.bottom, 0.0D, this.left / var17, (this.bottom + (int)this.scrollDistance) / var17);
		tesselator.addVertexWithUV(this.right, this.bottom, 0.0D, this.right / var17, (this.bottom + (int)this.scrollDistance) / var17);
		tesselator.addVertexWithUV(this.right, this.top, 0.0D, this.right / var17, (this.top + (int)this.scrollDistance) / var17);
		tesselator.addVertexWithUV(this.left, this.top, 0.0D, this.left / var17, (this.top + (int)this.scrollDistance) / var17);
		tesselator.draw();

		// boxRight = this.listWidth / 2 - 92 - 16;
		var10 = this.top + 4 - (int)this.scrollDistance;

		if (this.field_27262_q)
			this.func_27260_a(boxRight, var10, tesselator);

		int var14;

		for (var11 = 0; var11 < listLength; ++var11)
		{
			var19 = var10 + var11 * this.slotHeight + this.field_27261_r;
			var13 = this.slotHeight - 4;

			if (var19 <= this.bottom && var19 + var13 >= this.top)
			{
				if (this.field_25123_p && this.isSelected(var11))
				{
					var14 = boxLeft;
					int var15 = boxRight;
					GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					GL11.glDisable(GL11.GL_TEXTURE_2D);
					tesselator.startDrawingQuads();
					tesselator.setColorOpaque_I(0xFFFFFF);
					tesselator.addVertexWithUV(var14, var19 + var13 + 2, 0.0D, 0.0D, 1.0D);
					tesselator.addVertexWithUV(var15, var19 + var13 + 2, 0.0D, 1.0D, 1.0D);
					tesselator.addVertexWithUV(var15, var19 - 2, 0.0D, 1.0D, 0.0D);
					tesselator.addVertexWithUV(var14, var19 - 2, 0.0D, 0.0D, 0.0D);
					tesselator.setColorOpaque_I(0);
					tesselator.addVertexWithUV(var14 + 1, var19 + var13 + 1, 0.0D, 0.0D, 1.0D);
					tesselator.addVertexWithUV(var15 - 1, var19 + var13 + 1, 0.0D, 1.0D, 1.0D);
					tesselator.addVertexWithUV(var15 - 1, var19 - 1, 0.0D, 1.0D, 0.0D);
					tesselator.addVertexWithUV(var14 + 1, var19 - 1, 0.0D, 0.0D, 0.0D);
					tesselator.draw();
					GL11.glEnable(GL11.GL_TEXTURE_2D);
				}

				this.drawSlot(var11, boxRight, var19, var13, tesselator);
			}
		}

		GL11.glDisable(GL11.GL_DEPTH_TEST);
		this.overlayBackground(0, this.top, 255, 255);
		this.overlayBackground(this.bottom, this.listHeight, 255, 255);
		var19 = this.getContentHeight() - (this.bottom - this.top - 4);

		if (var19 > 0)
		{
			var13 = (this.bottom - this.top) * (this.bottom - this.top) / this.getContentHeight();

			if (var13 < 32)
				var13 = 32;

			if (var13 > this.bottom - this.top - 8)
				var13 = this.bottom - this.top - 8;

			var14 = (int)this.scrollDistance * (this.bottom - this.top - var13) / var19 + this.top;

			if (var14 < this.top)
				var14 = this.top;

			this.client.renderEngine.bindTexture(background2);
			tesselator.startDrawingQuads();
			tesselator.setColorRGBA_I(0, 255);
			tesselator.addVertexWithUV(scrollBarXStart, this.bottom, 0.0D, 0.0D, 1.0D);
			tesselator.addVertexWithUV(scrollBarXEnd, this.bottom, 0.0D, 1.0D, 1.0D);
			tesselator.addVertexWithUV(scrollBarXEnd, this.top, 0.0D, 1.0D, 0.0D);
			tesselator.addVertexWithUV(scrollBarXStart, this.top, 0.0D, 0.0D, 0.0D);
			tesselator.draw();
			tesselator.startDrawingQuads();
			tesselator.setColorRGBA_I(0xFFFFFF, 255);
			tesselator.addVertexWithUV(scrollBarXStart, var14 + var13, 0.0D, 0.0D, 1.0D);
			tesselator.addVertexWithUV(scrollBarXEnd, var14 + var13, 0.0D, 1.0D, 1.0D);
			tesselator.addVertexWithUV(scrollBarXEnd, var14, 0.0D, 1.0D, 0.0D);
			tesselator.addVertexWithUV(scrollBarXStart, var14, 0.0D, 0.0D, 0.0D);
			tesselator.draw();
			tesselator.startDrawingQuads();
			tesselator.setColorRGBA_I(0xFFFFFF, 255);
			tesselator.addVertexWithUV(scrollBarXStart, var14 + var13 - 1, 0.0D, 0.0D, 1.0D);
			tesselator.addVertexWithUV(scrollBarXEnd - 1, var14 + var13 - 1, 0.0D, 1.0D, 1.0D);
			tesselator.addVertexWithUV(scrollBarXEnd - 1, var14, 0.0D, 1.0D, 0.0D);
			tesselator.addVertexWithUV(scrollBarXStart, var14, 0.0D, 0.0D, 0.0D);
			tesselator.draw();
		}

		this.func_27257_b(mouseX, mouseY);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glShadeModel(GL11.GL_FLAT);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glDisable(GL11.GL_BLEND);
	}

	@Override
	protected void drawSlot(int listIndex, int var2, int var3, int var4, Tessellator var5)
	{
		GuiPowerListItem power = this.powers.get(listIndex);
		boolean hasPower = (power.power == null ? 0 : power.power.currentLevel) > 0;
		boolean isJedi = Arrays.asList(ForceUtils.getJediPowers()).contains(power.power.name);
		int c = isJedi ? (hasPower ? GLPalette.ANALOG_BLUE : GLPalette.BLUE) : (hasPower ? GLPalette.BRIGHT_RED : GLPalette.DARK_RED);
		c = Arrays.asList(ForceUtils.getBasicPowers()).contains(power.power.name) ? (hasPower ? GLPalette.BRIGHT_GREEN : GLPalette.MEDIUM_GREEN) : c;
		this.parent.getFontRenderer().drawString(this.parent.getFontRenderer().trimStringToWidth(power.localizedName, this.listWidth - 10), this.left + 3, var3 + 2, c);
		this.parent.getFontRenderer().drawString(this.parent.getFontRenderer().trimStringToWidth("Level " + (power.power == null ? 0 : power.power.currentLevel), this.listWidth - 10), this.left + 3, var3 + 12, 0xCCCCCC);
	}

	@Override
	protected void elementClicked(int var1, boolean var2)
	{
		this.parent.selectIndex(var1);
	}

	@Override
	protected int getContentHeight()
	{
		return this.getSize() * 35 + 1;
	}

	@Override
	protected int getSize()
	{
		return this.powers.size();
	}

	@Override
	protected boolean isSelected(int var1)
	{
		return this.parent.indexSelected(var1);
	}

	private void overlayBackground(int p_22239_1_, int p_22239_2_, int color1, int color2)
	{
		Tessellator var5 = Tessellator.instance;
		this.client.renderEngine.bindTexture(background);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		float var6 = 32.0F;
		var5.startDrawingQuads();
		var5.setColorRGBA_I(0xFFFFFF, color2);
		var5.addVertexWithUV(0.0D, p_22239_2_, 0.0D, 0.0D, p_22239_2_ / var6);
		var5.addVertexWithUV((double)this.listWidth + 30, p_22239_2_, 0.0D, (this.listWidth + 30) / var6, p_22239_2_ / var6);
		var5.setColorRGBA_I(0xFFFFFF, color1);
		var5.addVertexWithUV((double)this.listWidth + 30, p_22239_1_, 0.0D, (this.listWidth + 30) / var6, p_22239_1_ / var6);
		var5.addVertexWithUV(0.0D, p_22239_1_, 0.0D, 0.0D, p_22239_1_ / var6);
		var5.draw();
	}
}