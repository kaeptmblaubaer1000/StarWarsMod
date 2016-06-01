package com.parzivail.pswm.rendering;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.rendering.helper.PSWMEntityRenderer;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.IRenderHandler;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Sphere;

import java.util.Random;

public class DrawSpaceSky extends IRenderHandler
{
	private static ResourceLocation sunTexture = new ResourceLocation(Resources.MODID, "textures/environment/hoth_sun.png");
	private static ResourceLocation moon1Texture = new ResourceLocation(Resources.MODID, "textures/environment/hoth_moon.png");
	private static Vec3 moon1Offset = Vec3.createVectorHelper(-20, 0, 10);
	private static float moon1SizeMod = 1.0F;
	private static Vec3 moon2Offset = Vec3.createVectorHelper(-44, 0, 0);
	private static float moon2SizeMod = 1.25F;
	private static Vec3 moon3Offset = Vec3.createVectorHelper(4, 0, -10);
	private static float moon3SizeMod = 3.0F;
	public static int starList = GLAllocation.generateDisplayLists(3);
	public static int glSkyList = starList + 1;
	public static int glSkyList2 = starList + 2;
	private static float sunSize = 32.0F;
	private static float moonSize = 32.0F;

	public DrawSpaceSky()
	{
		GL11.glPushMatrix();
		GL11.glNewList(starList, 4864);
		this.renderStars();
		GL11.glEndList();
		GL11.glPopMatrix();
		Tessellator tessellator = Tessellator.instance;
		GL11.glNewList(glSkyList, 4864);
		byte byte2 = 64;
		int i = 256 / byte2 + 2;
		float f = 16.0F;
		for (int j = -byte2 * i; j <= byte2 * i; j += byte2)
			for (int l = -byte2 * i; l <= byte2 * i; l += byte2)
			{
				tessellator.startDrawingQuads();
				tessellator.addVertex(j + 0, f, l + 0);
				tessellator.addVertex(j + byte2, f, l + 0);
				tessellator.addVertex(j + byte2, f, l + byte2);
				tessellator.addVertex(j + 0, f, l + byte2);
				tessellator.draw();
			}
		GL11.glEndList();
	}

	public float getSkyBrightness(float par1)
	{
		float var2 = FMLClientHandler.instance().getClient().theWorld.getCelestialAngle(par1);
		float var3 = 1.0F - (MathHelper.sin(var2 * 3.1415927F * 2.0F) * 2.0F + 0.25F);
		if (var3 < 0.0F)
			var3 = 0.0F;
		if (var3 > 1.0F)
			var3 = 1.0F;
		return var3 * var3 * 1.0F;
	}

	@Override
	public void render(float partialTicks, WorldClient world, Minecraft mc)
	{
		GL11.glDisable(3553);
		GL11.glDepthMask(false);
		GL11.glEnable(2912);
		GL11.glColor3f(0, 0, 0);
		GL11.glDisable(GL11.GL_FOG);
		if (StarWarsMod.mc.entityRenderer instanceof PSWMEntityRenderer)
			new Sphere().draw(((PSWMEntityRenderer)StarWarsMod.mc.entityRenderer).getThirdPersonDistance() * 0.9f, 10, 10);
		GL11.glEnable(GL11.GL_FOG);
		GL11.glDisable(2912);
		GL11.glDisable(3008);
		GL11.glEnable(3042);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		RenderHelper.disableStandardItemLighting();

		GL11.glColor4f(1, 1, 1, 1);
		this.renderStars();

		GL11.glEnable(3553);
		GL11.glDepthMask(true);
	}

	private void renderStars()
	{
		Random rand = new Random(0);
		Tessellator var2 = Tessellator.instance;
		var2.startDrawingQuads();
		for (int starIndex = 0; starIndex < 20000; starIndex++)
		{
			double var4 = rand.nextFloat() * 2.0F - 1.0F;
			double var6 = rand.nextFloat() * 2.0F - 1.0F;
			double var8 = rand.nextFloat() * 2.0F - 1.0F;
			double var10 = 0.15F + rand.nextFloat() * 0.1F;
			double var12 = var4 * var4 + var6 * var6 + var8 * var8;
			if (var12 < 1.0D && var12 > 0.01D)
			{
				var12 = 1.0D / Math.sqrt(var12);
				var4 *= var12;
				var6 *= var12;
				var8 *= var12;
				double var14 = var4 * 100.0D;
				double var16 = var6 * 100.0D;
				double var18 = var8 * 100.0D;
				double var20 = Math.atan2(var4, var8);
				double var22 = Math.sin(var20);
				double var24 = Math.cos(var20);
				double var26 = Math.atan2(Math.sqrt(var4 * var4 + var8 * var8), var6);
				double var28 = Math.sin(var26);
				double var30 = Math.cos(var26);
				double var32 = rand.nextDouble() * 3.141592653589793D * 2.0D;
				double var34 = Math.sin(var32);
				double var36 = Math.cos(var32);
				for (int var38 = 0; var38 < 4; var38++)
				{
					double var39 = 0.0D;
					double var41 = ((var38 & 0x2) - 1) * var10;
					double var43 = ((var38 + 1 & 0x2) - 1) * var10;
					double var47 = var41 * var36 - var43 * var34;
					double var49 = var43 * var36 + var41 * var34;
					double var53 = var47 * var28 + var39 * var30;
					double var55 = var39 * var28 - var47 * var30;
					double var57 = var55 * var22 - var49 * var24;
					double var61 = var49 * var22 + var55 * var24;
					var2.addVertex(var14 + var57, var16 + var53, var18 + var61);
				}
			}
		}
		var2.draw();
	}
}
