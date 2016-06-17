package com.parzivail.pswm.rendering.gui;

import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.items.weapons.ItemLightsaber;
import com.parzivail.pswm.rendering.RenderLightsaber;
import com.parzivail.util.math.Animation;
import com.parzivail.util.ui.GFX;
import com.parzivail.util.ui.GLPalette;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;

public class AnimationSaberShowcase extends Animation
{
	private ScaledResolution r;

	private ItemStack stackShowing;
	private RenderLightsaber renderLightsaber;
	private int hiltIndex;
	private int lastTick = 0;

	public AnimationSaberShowcase(int hiltIndex, boolean on)
	{
		super(ItemLightsaber.hilts.length * 200, false, true);

		this.r = new ScaledResolution(StarWarsMod.mc, StarWarsMod.mc.displayWidth, StarWarsMod.mc.displayHeight);
		this.stackShowing = new ItemStack(StarWarsItems.lightsaberNew[0], 1);
		ItemLightsaber.setupNBT(0, stackShowing);
		stackShowing.stackTagCompound.setString(ItemLightsaber.nbtHilt, ItemLightsaber.hilts[hiltIndex]);
		stackShowing.stackTagCompound.setBoolean(ItemLightsaber.nbtBladeOn, on);
		renderLightsaber = new RenderLightsaber();
		this.hiltIndex = hiltIndex;
	}

	@Override
	public void render(RenderGameOverlayEvent event)
	{
		GL11.glPushMatrix();

		GLPalette.glColorI(GLPalette.WHITE);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GFX.drawRectangle(0, 0, r.getScaledWidth(), r.getScaledHeight(), true);

		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_LIGHTING);
		RenderHelper.enableStandardItemLighting();

		GL11.glTranslatef(245, 215, 130);
		GL11.glScalef(130, -130, 130);
		GL11.glRotatef((this.tick % 100) / 100f * 360 - 90, 0, 1, 0);

		if (this.tick >= lastTick + 100)
		{
			if (!stackShowing.stackTagCompound.getBoolean(ItemLightsaber.nbtBladeOn))
			{
				this.hiltIndex++;
				stackShowing.stackTagCompound.setString(ItemLightsaber.nbtHilt, ItemLightsaber.hilts[hiltIndex]);
				stackShowing.stackTagCompound.setBoolean(ItemLightsaber.nbtBladeOn, true);
			}
			else if (stackShowing.stackTagCompound.getInteger(ItemLightsaber.nbtBladeOn) == 0)
				stackShowing.stackTagCompound.setInteger(ItemLightsaber.nbtHiltSkin, 1);
			else
				stackShowing.stackTagCompound.setBoolean(ItemLightsaber.nbtBladeOn, false);
			lastTick = this.tick;
		}

		RenderLightsaber.applyTransformFix(this.stackShowing.stackTagCompound.getString(ItemLightsaber.nbtHilt));

		String s = stackShowing.stackTagCompound.getString(ItemLightsaber.nbtHilt);

		if (stackShowing.stackTagCompound.getBoolean(ItemLightsaber.nbtBladeOn))
		{
			switch (s)
			{
				case "dooku":
					GL11.glScalef(0.49f, 0.49f, 0.49f);
					GL11.glTranslatef(0, -0.595f, 0);
					break;
				case "ezra":
					GL11.glScalef(0.47f, 0.47f, 0.47f);
					GL11.glTranslatef(0, -0.76f, 0);
					break;
				case "kanan":
					GL11.glScalef(0.455f, 0.455f, 0.455f);
					GL11.glTranslatef(0, -0.78f, 0);
					break;
				case "maul":
					GL11.glScalef(0.43f, 0.43f, 0.43f);
					GL11.glTranslatef(0, 1.3f, 0);
					break;
				case "padawan":
					GL11.glScalef(0.42f, 0.42f, 0.42f);
					GL11.glTranslatef(0, -1.355f, 0);
					break;
				case "shoto":
					GL11.glScalef(0.46f, 0.46f, 0.46f);
					GL11.glTranslatef(0, -1.03f, 0);
					break;
				case "doubleSith":
					GL11.glScalef(0.315f, 0.315f, 0.315f);
					GL11.glTranslatef(0, 2.22f, 0);
					break;
				case "vader2":
					GL11.glScalef(0.36f, 0.36f, 0.36f);
					GL11.glTranslatef(0, -0.82f, 0);
					break;
				case "luke1":
					GL11.glScalef(0.33f, 0.33f, 0.33f);
					GL11.glTranslatef(0, -1.0f, 0);
					break;
				case "luke2":
					GL11.glScalef(0.45f, 0.45f, 0.45f);
					GL11.glTranslatef(0, -0.92f, 0);
					break;
				case "crossguard":
					GL11.glScalef(0.38f, 0.38f, 0.38f);
					GL11.glTranslatef(0, -0.95f, 0);
					break;
				case "malgus":
					GL11.glScalef(0.465f, 0.465f, 0.465f);
					GL11.glTranslatef(0, -1.04f, 0);
					break;
				case "obiwan":
					GL11.glScalef(0.4f, 0.4f, 0.4f);
					GL11.glTranslatef(0, -1.2f, 0);
					break;
				case "quigon":
					GL11.glScalef(0.4f, 0.4f, 0.4f);
					GL11.glTranslatef(0, -1.3f, 0);
					break;
				case "revan":
					GL11.glScalef(0.38f, 0.38f, 0.38f);
					GL11.glTranslatef(0, -1.33f, 0);
					break;
				case "starkiller":
					GL11.glScalef(0.385f, 0.385f, 0.385f);
					GL11.glTranslatef(0, -1.155f, 0);
					break;
				case "plokoon":
					GL11.glScalef(0.395f, 0.395f, 0.395f);
					GL11.glTranslatef(0, -0.92f, 0);
					break;
				case "inquisitor":
					GL11.glScalef(0.26f, 0.26f, 0.26f);
					GL11.glTranslatef(0, 3.08f, 0);
					break;
				case "mace":
					GL11.glScalef(0.34f, 0.34f, 0.34f);
					GL11.glTranslatef(0, -0.75f, 0);
					break;
				case "yoda":
					GL11.glScalef(0.26f, 0.26f, 0.26f);
					GL11.glTranslatef(0, 1.0f, 0);
					break;
			}
		}

		renderLightsaber.renderItem(IItemRenderer.ItemRenderType.ENTITY, stackShowing);

		GL11.glDisable(GL11.GL_LIGHTING);

		GL11.glPopMatrix();
	}
}
