package com.parzivail.pswm.rendering.gui;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.ModelPlanetCube;
import com.parzivail.util.ui.GLPZ;
import com.parzivail.util.ui.GLPalette;
import com.parzivail.util.ui.OutlineButton;
import com.parzivail.util.ui.OutlineModelButtonFancy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.Map;
import java.util.function.Consumer;

@SideOnly(Side.CLIENT)
public class GuiScreenHyperdrive extends GuiScreen
{
	private EntityPlayer player;
	private static final ResourceLocation background = new ResourceLocation(Resources.MODID, "textures/gui/space.png");

	Map<String, GuiButton> listBHilts;

	public GuiScreenHyperdrive(EntityPlayer player)
	{
		this.mc = Minecraft.getMinecraft();
		this.player = player;
	}

	@Override
	public void initGui()
	{
		int id = -1;
		int x = 10;
		int y = 40;

		ModelPlanetCube modelPlanetCube = new ModelPlanetCube();

		Consumer<OutlineButton> preTransform = outlineButton -> {
			GL11.glTranslatef(0, -15, 10);
			GLPZ.glScalef(1.7f);
			GL11.glRotatef(25, 1, 0, 0);
			GL11.glRotatef((System.currentTimeMillis() / 15) % 360, 0, 1, 0);
		};

		OutlineModelButtonFancy earth = new OutlineModelButtonFancy(id++, "earth", x, y + id * 32, modelPlanetCube, Resources.planetTextures.get(0), preTransform);
		this.buttonList.add(earth);
		OutlineModelButtonFancy tatooine = new OutlineModelButtonFancy(id++, "tatooine", x, y + id * 32, modelPlanetCube, Resources.planetTextures.get(Resources.ConfigOptions.dimTatooineId), preTransform);
		this.buttonList.add(tatooine);
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if (button.enabled && button.visible)
		{
		}
	}

	public void drawBg2()
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

	@Override
	public void drawScreen(int mX, int mY, float p)
	{
		this.drawBg2();

		GL11.glPushMatrix();

		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_LIGHTING);
		RenderHelper.enableStandardItemLighting();

		GLPalette.glColorI(GLPalette.WHITE);

		// stuff

		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_TEXTURE_2D);

		GL11.glPopMatrix();

		super.drawScreen(mX, mY, p);
	}
}