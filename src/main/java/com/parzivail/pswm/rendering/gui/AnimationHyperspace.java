package com.parzivail.pswm.rendering.gui;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.Animation;
import com.parzivail.util.ui.GLPZ;
import com.parzivail.util.ui.Screen2D;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayList;

public class AnimationHyperspace extends Animation
{
	private class Star
	{
		Point pos;
		int color;

		public Star(Point pos, int color)
		{
			this.color = color;
			this.pos = pos;
		}
	}

	private static final ResourceLocation background = new ResourceLocation(Resources.MODID, "textures/gui/space.png");

	private ArrayList<Star> stars;
	private boolean reverse;
	private ScaledResolution r;

	public AnimationHyperspace(int amtStars, boolean reverse)
	{
		super(100, false, true);

		this.r = new ScaledResolution(StarWarsMod.mc, StarWarsMod.mc.displayWidth, StarWarsMod.mc.displayHeight);
		this.stars = new ArrayList<>();
		this.reverse = reverse;

		//if (reverse)
		//	player.playSound(Resources.MODID + ":" + "lightspeed.exit", 1, 1);
		//else
		//	player.playSound(Resources.MODID + ":" + "lightspeed.enter", 1, 1);

		for (int i = 0; i < amtStars; i++)
			stars.add(new Star(new Point(StarWarsMod.rngGeneral.nextInt(r.getScaledWidth()), StarWarsMod.rngGeneral.nextInt(r.getScaledHeight())), StarWarsMod.rngGeneral.nextInt(255)));
	}

	@Override
	public void render(RenderGameOverlayEvent event)
	{
		super.render(event);
		GL11.glDisable(GL11.GL_TEXTURE_2D);

		GL11.glColor3f(0, 0, 0);
		Screen2D.drawRectangle(0, 0, r.getScaledWidth(), r.getScaledHeight(), true);

		int mX = r.getScaledWidth() / 2;
		int mY = r.getScaledHeight() / 2;

		for (Star star : stars)
		{
			GLPZ.glColorGrayscale(star.color);

			GL11.glLineWidth(star.color / 255f * 2 + 0.1f);

			float angle = (float)Math.atan2(star.pos.x - mX, star.pos.y - mY);

			double t = 0;
			if (reverse)
				t = Math.pow((100 - this.tick) / 15f, 4);
			else
				t = Math.pow(this.tick / 15f, 4);

			t += 1;

			Screen2D.drawLine(star.pos.x, star.pos.y, star.pos.x + MathHelper.sin(angle) * t, star.pos.y + MathHelper.cos(angle) * t);
		}
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}

	@Override
	public void tick()
	{
		super.tick();
		//if (isDone())
		//	GuiToast.makeText("Done!", GuiToast.TIME_SHORT).show();
	}

	public void drawBackground(int width, int height)
	{
		Tessellator tessellator = Tessellator.instance;
		StarWarsMod.mc.getTextureManager().bindTexture(background);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		float f = 200.0F;
		tessellator.startDrawingQuads();
		tessellator.setColorOpaque_I(0xFFFFFFFF);
		tessellator.addVertexWithUV(0.0D, height, 0.0D, 0.0D, height / f + 1);
		tessellator.addVertexWithUV(width, height, 0.0D, width / f, height / f + 1);
		tessellator.addVertexWithUV(width, 0.0D, 0.0D, width / f, 1);
		tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 1);
		tessellator.draw();
	}
}
