package com.parzivail.pswm.rendering.gui;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.models.ModelPlanetCube;
import com.parzivail.util.ui.GLPalette;
import com.parzivail.util.ui.OutlineButton;
import com.parzivail.util.ui.OutlineButtonModel;
import com.parzivail.util.ui.Screen2D;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.function.Consumer;

@SideOnly(Side.CLIENT)
public class GuiScreenHyperdrive extends GuiScreen
{
	private EntityPlayer player;
	private static final ResourceLocation background = new ResourceLocation(Resources.MODID, "textures/gui/space.png");
	private static ScaledResolution r;

	public GuiScreenHyperdrive(EntityPlayer player)
	{
		this.mc = Minecraft.getMinecraft();
		this.player = player;
	}

	@Override
	public void initGui()
	{
		r = new ScaledResolution(StarWarsMod.mc, StarWarsMod.mc.displayWidth, StarWarsMod.mc.displayHeight);

		Consumer<OutlineButton> transform = outlineButton -> {
			GL11.glTranslatef(1.9f, -0.6f, 10);
			GL11.glScalef(0.3f, 0.3f, 0.3f);
			GL11.glRotatef(-30, 1, 0, 0);
			GL11.glRotatef((System.currentTimeMillis() / 50) % 360, 0, 1, 0);
		};

		int id = 0;
		Point p = galaxyCoordsToXy(7.1f, 5.1f);
		OutlineButtonModel alderaan = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		alderaan.setup(new ModelPlanetCube(), Resources.planetTextures.get(Resources.ConfigOptions.dimAlderaanId), transform);
		buttonList.add(alderaan);

		p = galaxyCoordsToXy(4.9f, 13.45f);
		OutlineButtonModel bespin = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		bespin.setup(new ModelPlanetCube(), Resources.planetTextures.get(Resources.ConfigOptions.dimBespinId), transform);
		buttonList.add(bespin);

		p = galaxyCoordsToXy(4.7f, 13.7f);
		OutlineButtonModel hoth = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		hoth.setup(new ModelPlanetCube(), Resources.planetTextures.get(Resources.ConfigOptions.dimHothId), transform);
		buttonList.add(hoth);

		p = galaxyCoordsToXy(7.4f, 6.8f);
		OutlineButtonModel earth = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		earth.setup(new ModelPlanetCube(), Resources.planetTextures.get(0), transform);
		buttonList.add(earth);

		p = galaxyCoordsToXy(6.1f, 4.9f);
		OutlineButtonModel coruscant = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		coruscant.setup(new ModelPlanetCube(), Resources.planetTextures.get(Resources.ConfigOptions.dimCoruscantId), transform);
		buttonList.add(coruscant);

		p = galaxyCoordsToXy(7.7f, 14.4f);
		OutlineButtonModel dagobah = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		dagobah.setup(new ModelPlanetCube(), Resources.planetTextures.get(Resources.ConfigOptions.dimDagobahId), transform);
		buttonList.add(dagobah);

		p = galaxyCoordsToXy(9.25f, 1.35f);
		OutlineButtonModel dathomir = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		dathomir.setup(new ModelPlanetCube(), Resources.planetTextures.get(Resources.ConfigOptions.dimDathomirId), transform);
		buttonList.add(dathomir);

		p = galaxyCoordsToXy(2.58f, 11.6f);
		OutlineButtonModel endor = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		endor.setup(new ModelPlanetCube(), Resources.planetTextures.get(Resources.ConfigOptions.dimEndorId), transform);
		buttonList.add(endor);

		p = galaxyCoordsToXy(12.6f, 11.5f);
		OutlineButtonModel geonosis = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		geonosis.setup(new ModelPlanetCube(), Resources.planetTextures.get(Resources.ConfigOptions.dimGeonosisId), transform);
		buttonList.add(geonosis);

		p = galaxyCoordsToXy(12.35f, 11.75f);
		OutlineButtonModel tatooine = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		tatooine.setup(new ModelPlanetCube(), Resources.planetTextures.get(Resources.ConfigOptions.dimTatooineId), transform);
		buttonList.add(tatooine);

		p = galaxyCoordsToXy(12.75f, 12.6f);
		OutlineButtonModel ryloth = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		ryloth.setup(new ModelPlanetCube(), Resources.planetTextures.get(Resources.ConfigOptions.dimRylothId), transform);
		buttonList.add(ryloth);

		p = galaxyCoordsToXy(1.9f, 2.4f);
		OutlineButtonModel ilum = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		ilum.setup(new ModelPlanetCube(), Resources.planetTextures.get(Resources.ConfigOptions.dimIlumId), transform);
		buttonList.add(ilum);

		p = galaxyCoordsToXy(13.75f, 10.3f);
		OutlineButtonModel kamino = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		kamino.setup(new ModelPlanetCube(), Resources.planetTextures.get(Resources.ConfigOptions.dimKaminoId), transform);
		buttonList.add(kamino);

		p = galaxyCoordsToXy(10.75f, 4.65f);
		OutlineButtonModel kashyyyk = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		kashyyyk.setup(new ModelPlanetCube(), Resources.planetTextures.get(Resources.ConfigOptions.dimKashyyykId), transform);
		buttonList.add(kashyyyk);

		p = galaxyCoordsToXy(14.3f, 5.0f);
		OutlineButtonModel kessel = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		kessel.setup(new ModelPlanetCube(), Resources.planetTextures.get(Resources.ConfigOptions.dimKesselId), transform);
		buttonList.add(kessel);

		p = galaxyCoordsToXy(9.7f, 1.3f);
		OutlineButtonModel mandalore = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		mandalore.setup(new ModelPlanetCube(), Resources.planetTextures.get(Resources.ConfigOptions.dimMandaloreId), transform);
		buttonList.add(mandalore);

		p = galaxyCoordsToXy(15.1f, 1.8f);
		OutlineButtonModel monCalamari = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		monCalamari.setup(new ModelPlanetCube(), Resources.planetTextures.get(Resources.ConfigOptions.dimMonCalamariId), transform);
		buttonList.add(monCalamari);

		p = galaxyCoordsToXy(6.3f, 19.8f);
		OutlineButtonModel mustafar = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		mustafar.setup(new ModelPlanetCube(), Resources.planetTextures.get(Resources.ConfigOptions.dimMustafarId), transform);
		buttonList.add(mustafar);

		p = galaxyCoordsToXy(9.4f, 12.1f);
		OutlineButtonModel naboo = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		naboo.setup(new ModelPlanetCube(), Resources.planetTextures.get(Resources.ConfigOptions.dimNabooId), transform);
		buttonList.add(naboo);

		p = galaxyCoordsToXy(7.75f, 12.5f);
		OutlineButtonModel sullust = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		sullust.setup(new ModelPlanetCube(), Resources.planetTextures.get(Resources.ConfigOptions.dimSullustId), transform);
		buttonList.add(sullust);

		p = galaxyCoordsToXy(8.2f, 14.75f);
		OutlineButtonModel utapau = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		utapau.setup(new ModelPlanetCube(), Resources.planetTextures.get(Resources.ConfigOptions.dimUtapauId), transform);
		buttonList.add(utapau);

		p = galaxyCoordsToXy(10.6f, 1.0f);
		OutlineButtonModel yavin4 = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		yavin4.setup(new ModelPlanetCube(), Resources.planetTextures.get(Resources.ConfigOptions.dimYavin4Id), transform);
		buttonList.add(yavin4);

		p = galaxyCoordsToXy(3.8f, 8.4f);
		OutlineButtonModel jakku = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		jakku.setup(new ModelPlanetCube(), Resources.planetTextures.get(Resources.ConfigOptions.dimJakkuId), transform);
		buttonList.add(jakku);

		p = galaxyCoordsToXy(4.8f, 10.7f);
		OutlineButtonModel takodana = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		takodana.setup(new ModelPlanetCube(), Resources.planetTextures.get(Resources.ConfigOptions.dimTakodanaId), transform);
		buttonList.add(takodana);

		p = galaxyCoordsToXy(9.3f, 13.1f);
		OutlineButtonModel dQar = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		dQar.setup(new ModelPlanetCube(), Resources.planetTextures.get(Resources.ConfigOptions.dimDQarId), transform);
		buttonList.add(dQar);

		p = galaxyCoordsToXy(16.8f, 8.6f);
		OutlineButtonModel ahchTo = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		ahchTo.setup(new ModelPlanetCube(), Resources.planetTextures.get(Resources.ConfigOptions.dimAhchToId), transform);
		buttonList.add(ahchTo);

		p = galaxyCoordsToXy(10.4f, 0.8f);
		OutlineButtonModel deathStar = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		deathStar.setup(new ModelPlanetCube(), Resources.planetTextures.get(Resources.ConfigOptions.dimDeathStarId), transform);
		buttonList.add(deathStar);
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

		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		RenderHelper.enableStandardItemLighting();

		super.drawScreen(mX, mY, p);
	}

	public Point galaxyCoordsToXy(float x, float y)
	{
		int pX = (int)(r.getScaledWidth() / 2f - 144);
		int pY = (int)(r.getScaledHeight() / 2f - 144) + 16;
		return new Point((int)(pX + 16 * x), (int)(pY + 16 * y));
	}
}