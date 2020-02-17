package com.parzivail.pswm.rendering;

import com.parzivail.pswm.Resources;
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

import java.util.Random;

public class DrawYavinFourSky extends IRenderHandler
{
	private static ResourceLocation yavinPrimeTexture = new ResourceLocation(Resources.MODID, "textures/environment/yavin_prime.png");
	private static float yavinPrimeSizeMod = 150.0F;
	private static ResourceLocation deathStarTexture = new ResourceLocation(Resources.MODID, "textures/environment/death_star.png");
	public static int starList = GLAllocation.generateDisplayLists(3);
	public static int glSkyList = starList + 1;
	public static int glSkyList2 = starList + 2;
	private static float deathStarSize = 4.0F;
	private static Vec3 deathStarOffset = Vec3.createVectorHelper(-75, 0, 0);

	public DrawYavinFourSky()
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
				tessellator.addVertex(j, f, l);
				tessellator.addVertex(j + byte2, f, l);
				tessellator.addVertex(j + byte2, f, l + byte2);
				tessellator.addVertex(j, f, l + byte2);
				tessellator.draw();
			}
		GL11.glEndList();
		GL11.glNewList(glSkyList2, 4864);
		f = -16.0F;
		tessellator.startDrawingQuads();
		for (int k = -byte2 * i; k <= byte2 * i; k += byte2)
			for (int i1 = -byte2 * i; i1 <= byte2 * i; i1 += byte2)
			{
				tessellator.addVertex(k + byte2, f, i1);
				tessellator.addVertex(k, f, i1);
				tessellator.addVertex(k, f, i1 + byte2);
				tessellator.addVertex(k + byte2, f, i1 + byte2);
			}
		tessellator.draw();
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
		Vec3 vec3 = world.getSkyColor(mc.renderViewEntity, partialTicks);
		float f1 = (float)vec3.xCoord;
		float f2 = (float)vec3.yCoord;
		float f3 = (float)vec3.zCoord;
		if (mc.gameSettings.anaglyph)
		{
			float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
			float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
			float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
			f1 = f4;
			f2 = f5;
			f3 = f6;
		}
		GL11.glColor3f(f1, f2, f3);
		Tessellator tessellator1 = Tessellator.instance;
		GL11.glDepthMask(false);
		GL11.glEnable(2912);
		GL11.glColor3f(f1, f2, f3);
		GL11.glCallList(glSkyList);
		GL11.glDisable(2912);
		GL11.glDisable(3008);
		GL11.glEnable(3042);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		RenderHelper.disableStandardItemLighting();
		float f18 = world.getStarBrightness(partialTicks);
		if (f18 > 0.0F)
		{
			GL11.glColor4f(f18, f18, f18, f18);
			GL11.glCallList(starList);
		}
		float[] afloat = new float[4];
		GL11.glDisable(3553);
		GL11.glShadeModel(7425);
		GL11.glPushMatrix();
		GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
		afloat[0] = 1.0F;
		afloat[1] = 0.7607843F;
		afloat[2] = 0.7058824F;
		afloat[3] = 0.3F;
		float f6 = afloat[0];
		float f7 = afloat[1];
		float f8 = afloat[2];
		if (mc.gameSettings.anaglyph)
		{
			float f9 = (f6 * 30.0F + f7 * 59.0F + f8 * 11.0F) / 100.0F;
			float f10 = (f6 * 30.0F + f7 * 70.0F) / 100.0F;
			float f11 = (f6 * 30.0F + f8 * 70.0F) / 100.0F;
			f6 = f9;
			f7 = f10;
			f8 = f11;
		}
		f18 = 1.0F - f18;
		tessellator1.startDrawing(6);
		tessellator1.setColorRGBA_F(f6 * f18, f7 * f18, f8 * f18, afloat[3] * 2.0F / f18);
		tessellator1.addVertex(0.0D, 100.0D, 0.0D);
		tessellator1.setColorRGBA_F(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F);
		float f10 = 20.0F;
		tessellator1.addVertex(-f10, 100.0D, -f10);
		tessellator1.addVertex(0.0D, 100.0D, -f10 * 1.5D);
		tessellator1.addVertex(f10, 100.0D, -f10);
		tessellator1.addVertex(f10 * 1.5D, 100.0D, 0.0D);
		tessellator1.addVertex(f10, 100.0D, f10);
		tessellator1.addVertex(0.0D, 100.0D, f10 * 1.5D);
		tessellator1.addVertex(-f10, 100.0D, f10);
		tessellator1.addVertex(-f10 * 1.5D, 100.0D, 0.0D);
		tessellator1.addVertex(-f10, 100.0D, -f10);
		tessellator1.draw();
		tessellator1.startDrawing(6);
		tessellator1.setColorRGBA_F(f6 * f18, f7 * f18, f8 * f18, afloat[3] * f18);
		tessellator1.addVertex(0.0D, 100.0D, 0.0D);
		tessellator1.setColorRGBA_F(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F);
		f10 = 40.0F;
		tessellator1.addVertex(-f10, 100.0D, -f10);
		tessellator1.addVertex(0.0D, 100.0D, -f10 * 1.5D);
		tessellator1.addVertex(f10, 100.0D, -f10);
		tessellator1.addVertex(f10 * 1.5D, 100.0D, 0.0D);
		tessellator1.addVertex(f10, 100.0D, f10);
		tessellator1.addVertex(0.0D, 100.0D, f10 * 1.5D);
		tessellator1.addVertex(-f10, 100.0D, f10);
		tessellator1.addVertex(-f10 * 1.5D, 100.0D, 0.0D);
		tessellator1.addVertex(-f10, 100.0D, -f10);
		tessellator1.draw();
		GL11.glPopMatrix();
		GL11.glShadeModel(7424);
		GL11.glEnable(3553);
		GL11.glPushMatrix();
		f7 = 0.0F;
		f8 = 0.0F;
		float f9 = 0.0F;
		GL11.glTranslatef(f7, f8, f9);
		GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
		GL11.glDisable(3553);
		GL11.glColor4f(0.0F, 0.0F, 0.0F, 1.0F);
		f10 = yavinPrimeSizeMod / 4.0F;
		tessellator1.startDrawingQuads();
		tessellator1.addVertex(-f10, 100.0D, -f10);
		tessellator1.addVertex(f10, 100.0D, -f10);
		tessellator1.addVertex(f10, 100.0D, f10);
		tessellator1.addVertex(-f10, 100.0D, f10);
		tessellator1.draw();
		GL11.glEnable(3553);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		f10 = yavinPrimeSizeMod;
		mc.renderEngine.bindTexture(yavinPrimeTexture);
		tessellator1.startDrawingQuads();
		tessellator1.addVertexWithUV(-f10, 100.0D, -f10, 0.0D, 0.0D);
		tessellator1.addVertexWithUV(f10, 100.0D, -f10, 1.0D, 0.0D);
		tessellator1.addVertexWithUV(f10, 100.0D, f10, 1.0D, 1.0D);
		tessellator1.addVertexWithUV(-f10, 100.0D, f10, 0.0D, 1.0D);
		tessellator1.draw();
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glDisable(3553);
		GL11.glColor4f(0.0F, 0.0F, 0.0F, 1.0F);
		f10 = deathStarSize / 3.5F;
		tessellator1.startDrawingQuads();
		tessellator1.addVertex(-f10 + deathStarOffset.xCoord, 99.9D + deathStarOffset.yCoord, -f10 + deathStarOffset.zCoord);
		tessellator1.addVertex(f10 + deathStarOffset.xCoord, 99.9D + deathStarOffset.yCoord, -f10 + deathStarOffset.zCoord);
		tessellator1.addVertex(f10 + deathStarOffset.xCoord, 99.9D + deathStarOffset.yCoord, f10 + deathStarOffset.zCoord);
		tessellator1.addVertex(-f10 + deathStarOffset.xCoord, 99.9D + deathStarOffset.yCoord, f10 + deathStarOffset.zCoord);
		tessellator1.draw();
		GL11.glEnable(3553);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		f10 = deathStarSize;
		mc.renderEngine.bindTexture(deathStarTexture);
		tessellator1.startDrawingQuads();
		tessellator1.addVertexWithUV(-f10 + deathStarOffset.xCoord, 100.0D + deathStarOffset.yCoord, -f10 + deathStarOffset.zCoord, 0.0D, 0.0D);
		tessellator1.addVertexWithUV(f10 + deathStarOffset.xCoord, 100.0D + deathStarOffset.yCoord, -f10 + deathStarOffset.zCoord, 1.0D, 0.0D);
		tessellator1.addVertexWithUV(f10 + deathStarOffset.xCoord, 100.0D + deathStarOffset.yCoord, f10 + deathStarOffset.zCoord, 1.0D, 1.0D);
		tessellator1.addVertexWithUV(-f10 + deathStarOffset.xCoord, 100.0D + deathStarOffset.yCoord, f10 + deathStarOffset.zCoord, 0.0D, 1.0D);
		tessellator1.draw();
		GL11.glDisable(3553);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(3042);
		GL11.glEnable(3008);
		GL11.glEnable(2912);
		GL11.glPopMatrix();
		GL11.glDisable(3553);
		GL11.glColor3f(0.0F, 0.0F, 0.0F);
		double d0 = mc.thePlayer.getPosition(partialTicks).yCoord - world.getHorizon();
		if (d0 < 0.0D)
		{
			GL11.glPushMatrix();
			GL11.glTranslatef(0.0F, 12.0F, 0.0F);
			GL11.glCallList(glSkyList2);
			GL11.glPopMatrix();
			f8 = 1.0F;
			f9 = -(float)(d0 + 65.0D);
			f10 = -f8;
			tessellator1.startDrawingQuads();
			tessellator1.setColorRGBA_I(0, 255);
			tessellator1.addVertex(-f8, f9, f8);
			tessellator1.addVertex(f8, f9, f8);
			tessellator1.addVertex(f8, f10, f8);
			tessellator1.addVertex(-f8, f10, f8);
			tessellator1.addVertex(-f8, f10, -f8);
			tessellator1.addVertex(f8, f10, -f8);
			tessellator1.addVertex(f8, f9, -f8);
			tessellator1.addVertex(-f8, f9, -f8);
			tessellator1.addVertex(f8, f10, -f8);
			tessellator1.addVertex(f8, f10, f8);
			tessellator1.addVertex(f8, f9, f8);
			tessellator1.addVertex(f8, f9, -f8);
			tessellator1.addVertex(-f8, f9, -f8);
			tessellator1.addVertex(-f8, f9, f8);
			tessellator1.addVertex(-f8, f10, f8);
			tessellator1.addVertex(-f8, f10, -f8);
			tessellator1.addVertex(-f8, f10, -f8);
			tessellator1.addVertex(-f8, f10, f8);
			tessellator1.addVertex(f8, f10, f8);
			tessellator1.addVertex(f8, f10, -f8);
			tessellator1.draw();
		}
		if (world.provider.isSkyColored())
			GL11.glColor3f(f1 * 0.2F + 0.04F, f2 * 0.2F + 0.04F, f3 * 0.6F + 0.1F);
		else
			GL11.glColor3f(f1, f2, f3);
		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, -(float)(d0 - 16.0D), 0.0F);
		GL11.glCallList(glSkyList2);
		GL11.glPopMatrix();
		GL11.glEnable(3553);
		GL11.glDepthMask(true);
	}

	private void renderStars()
	{
		Random rand = new Random(10842L);
		Tessellator var2 = Tessellator.instance;
		var2.startDrawingQuads();
		for (int starIndex = 0; starIndex < 6000; starIndex++)
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
