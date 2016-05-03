package com.parzivail.pswm.rendering.gui;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.font.FontManager;
import com.parzivail.pswm.mobs.MobTatooineCommoner;
import com.parzivail.util.IParziNPC;
import com.parzivail.util.MathUtils;
import com.parzivail.util.ui.GLPZ;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiIDScanner extends GuiScreen
{
	private static final ResourceLocation guiTexture = new ResourceLocation(Resources.MODID, "textures/gui/scanner.png");
	EntityPlayer player;
	Entity scanned;
	boolean fraud = false;
	long timeInit;

	public GuiIDScanner(EntityPlayer player)
	{
		this.mc = Minecraft.getMinecraft();
		this.player = player;
	}

	@Override
	public void initGui()
	{
		this.scanned = mc.objectMouseOver.entityHit;
		if (scanned instanceof MobTatooineCommoner && MathUtils.oneIn(10))
		{
			scanned = new MobTatooineCommoner(scanned.worldObj);
			int n = 0;
			do
				n = StarWarsMod.rngGeneral.nextInt(5);
			while (n == mc.objectMouseOver.entityHit.getDataWatcher().getWatchableObjectInt(25));

			scanned.getDataWatcher().updateObject(25, Integer.valueOf(n));

			fraud = true;
		}
		timeInit = System.currentTimeMillis();
	}

	@Override
	public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_)
	{
		if (scanned instanceof IParziNPC)
		{
			IParziNPC parziNPC = (IParziNPC)scanned;

			ScaledResolution r = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);

			this.drawGradientRect(0, 0, this.width, this.height, 0x88000000, 0xAA000000);

			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.mc.renderEngine.bindTexture(guiTexture);
			this.drawTexturedModalRect((r.getScaledWidth() - 151) / 2, (r.getScaledHeight() - 210) / 2, 0, 0, 151, 196);

			long timeOpen = System.currentTimeMillis() - timeInit;
			int strPos = 0;
			if (timeOpen / 10 < 100)
				strPos = (int)(timeOpen / 10);
			else
				strPos = 100;

			int textColor = 0x00538E;

			if (fraud)
				textColor = (System.currentTimeMillis() / 250) % 2 == 0 ? 0xFF0000 : 0xFF7777;

			GL11.glPushMatrix();
			int width = FontManager.aurebesh.getStringWidth(parziNPC.getName());
			FontManager.aurebesh.drawString(parziNPC.getName().substring(0, (int)(parziNPC.getName().length() * (strPos / 100f))), (r.getScaledWidth() - width) / 2, (r.getScaledHeight() - 130) / 2, textColor);
			GLPZ.glScalef(0.5f);
			FontManager.aurebesh.drawString(parziNPC.getSpecies().substring(0, (int)(parziNPC.getSpecies().length() * (strPos / 100f))), r.getScaledWidth() + 2, r.getScaledHeight() - 85, textColor);
			FontManager.aurebesh.drawString(parziNPC.getAllegiance().substring(0, (int)(parziNPC.getAllegiance().length() * (strPos / 100f))), r.getScaledWidth() + 2, r.getScaledHeight() - 65, textColor);
			FontManager.aurebesh.drawString(parziNPC.getJob().substring(0, (int)(parziNPC.getJob().length() * (strPos / 100f))), r.getScaledWidth() + 2, r.getScaledHeight() - 45, textColor);
			GL11.glPopMatrix();

			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glTranslatef(r.getScaledWidth() / 2 - 20, r.getScaledHeight() / 2 - 3, 10);
			GLPZ.glScalef(25f);
			GL11.glRotatef(scanned.getRotationYawHead(), 0, 1, 0);
			GL11.glScalef(1, -1, 1);
			float old = RendererLivingEntity.NAME_TAG_RANGE;
			RendererLivingEntity.NAME_TAG_RANGE = 0.0F;
			Render render = RenderManager.instance.getEntityRenderObject(scanned);
			render.doRender(scanned, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
			RendererLivingEntity.NAME_TAG_RANGE = old;
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
		}
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\gui\GuiMV.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */