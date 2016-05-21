package com.parzivail.pswm.rendering.gui;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.math.Animation;
import com.parzivail.util.ui.GFX;
import com.parzivail.util.ui.GLPalette;
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
		int dist;
		float scale;
		float r;
		float g;
		float b;

		public Star(Point pos, int dist, float scale, int color)
		{
			this.dist = dist;
			this.pos = pos;
			this.scale = scale;
			Color c = GLPalette.intToColor(color);
			this.r = (c.getRed() / 255f) * (dist / 255f);
			this.g = (c.getGreen() / 255f) * (dist / 255f);
			this.b = (c.getBlue() / 255f) * (dist / 255f);
		}
	}

	private static final ResourceLocation background = new ResourceLocation(Resources.MODID, "textures/gui/space.png");

	private ArrayList<Star> stars;
	private boolean reverse;
	private ScaledResolution r;

	public AnimationHyperspace(int amtStars, boolean reverse)
	{
		super(150, false, true);

		this.r = new ScaledResolution(StarWarsMod.mc, StarWarsMod.mc.displayWidth, StarWarsMod.mc.displayHeight);
		this.stars = new ArrayList<>();
		this.reverse = reverse;

		//if (reverse)
		//	player.playSound(Resources.MODID + ":" + "lightspeed.exit", 1, 1);
		//else
		//	player.playSound(Resources.MODID + ":" + "lightspeed.enter", 1, 1);

		for (int i = 0; i < amtStars; i++)
			stars.add(new Star(new Point(StarWarsMod.rngGeneral.nextInt(r.getScaledWidth()), StarWarsMod.rngGeneral.nextInt(r.getScaledHeight())), StarWarsMod.rngGeneral.nextInt(255), StarWarsMod.rngGeneral.nextFloat(), 0xEEEEFF));
	}

	@Override
	public void render(RenderGameOverlayEvent event)
	{
		super.render(event);
		GL11.glDisable(GL11.GL_TEXTURE_2D);

		GL11.glColor3f(0, 0, 0);
		GFX.drawRectangle(0, 0, r.getScaledWidth(), r.getScaledHeight(), true);

		int mX = r.getScaledWidth() / 2;
		int mY = r.getScaledHeight() / 2;

		for (Star star : stars)
		{
			GL11.glColor3f(star.r, star.g, star.b);

			GL11.glLineWidth(2); //star.dist / 255f * 2 + 0.1f

			float angle = (float)Math.atan2(star.pos.x - mX, star.pos.y - mY);

			double t;
			int nTick = tick;
			if (reverse)
				nTick = 100 - tick;

			t = 1 / (Math.pow(2, nTick) * Math.pow(2, -1.2 * nTick + 5));

			t += 1;
			t *= star.scale;

			float mod = (float)(t / (float)(255 - star.dist));

			if (t < 5)
				mod = 1;

			GFX.drawLine(star.pos.x + MathHelper.sin(angle) * mod, star.pos.y + MathHelper.cos(angle) * mod, star.pos.x + MathHelper.sin(angle) * t, star.pos.y + MathHelper.cos(angle) * t);
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
