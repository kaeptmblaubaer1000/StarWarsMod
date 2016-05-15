package com.parzivail.pswm.rendering.gui;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.dimension.PlanetInformation;
import com.parzivail.pswm.models.ModelPlanetCube;
import com.parzivail.util.MathUtils;
import com.parzivail.util.PathfindingGrid;
import com.parzivail.util.ui.*;
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
	private static final ResourceLocation galaxy = new ResourceLocation(Resources.MODID, "textures/gui/galaxy.png");
	private static ScaledResolution r;

	private boolean isZoom = false;
	private PlanetInformation zoomPlanet;
	private PlanetInformation oldZoomPlanet;

	private AnimationZoom animationZoom;
	private OutlineButton buttonClose;

	private PathfindingGrid pathfindingGrid = new PathfindingGrid(180, 180, 10);

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
			GL11.glTranslatef(1.9f, -1f, 110);
			GL11.glScalef(0.3f, 0.3f, 0.3f);
			if ((zoomPlanet != null && PlanetInformation.getPlanet(outlineButton.displayString).getName().equalsIgnoreCase(zoomPlanet.getName())) || (oldZoomPlanet != null && PlanetInformation.getPlanet(outlineButton.displayString).getName().equalsIgnoreCase(oldZoomPlanet.getName())))
				GLPZ.glScalef((animationZoom.getTick() + 2) / 2f);
			GL11.glRotatef(-30, 1, 0, 0);
			GL11.glRotatef((System.currentTimeMillis() / 50) % 360, 0, 1, 0);
		};

		animationZoom = new AnimationZoom();

		int id = 0;
		PlanetInformation info = PlanetInformation.getPlanet("alderaan");
		Point p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel alderaan = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		alderaan.displayString = info.getInternalName();
		alderaan.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(alderaan);

		info = PlanetInformation.getPlanet("bespin");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel bespin = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		bespin.displayString = info.getInternalName();
		bespin.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(bespin);

		info = PlanetInformation.getPlanet("hoth");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel hoth = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		hoth.displayString = info.getInternalName();
		hoth.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(hoth);

		info = PlanetInformation.getPlanet("earth");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel earth = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		earth.displayString = info.getInternalName();
		earth.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(earth);

		info = PlanetInformation.getPlanet("coruscant");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel coruscant = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		coruscant.displayString = info.getInternalName();
		coruscant.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(coruscant);

		info = PlanetInformation.getPlanet("dagobah");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel dagobah = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		dagobah.displayString = info.getInternalName();
		dagobah.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(dagobah);

		info = PlanetInformation.getPlanet("dathomir");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel dathomir = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		dathomir.displayString = info.getInternalName();
		dathomir.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(dathomir);

		info = PlanetInformation.getPlanet("endor");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel endor = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		endor.displayString = info.getInternalName();
		endor.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(endor);

		info = PlanetInformation.getPlanet("geonosis");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel geonosis = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		geonosis.displayString = info.getInternalName();
		geonosis.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(geonosis);

		info = PlanetInformation.getPlanet("tatooine");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel tatooine = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		tatooine.displayString = info.getInternalName();
		tatooine.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(tatooine);

		info = PlanetInformation.getPlanet("ryloth");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel ryloth = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		ryloth.displayString = info.getInternalName();
		ryloth.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(ryloth);

		info = PlanetInformation.getPlanet("ilum");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel ilum = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		ilum.displayString = info.getInternalName();
		ilum.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(ilum);

		info = PlanetInformation.getPlanet("kamino");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel kamino = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		kamino.displayString = info.getInternalName();
		kamino.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(kamino);

		info = PlanetInformation.getPlanet("kashyyyk");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel kashyyyk = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		kashyyyk.displayString = info.getInternalName();
		kashyyyk.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(kashyyyk);

		info = PlanetInformation.getPlanet("kessel");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel kessel = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		kessel.displayString = info.getInternalName();
		kessel.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(kessel);

		info = PlanetInformation.getPlanet("mandalore");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel mandalore = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		mandalore.displayString = info.getInternalName();
		mandalore.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(mandalore);

		info = PlanetInformation.getPlanet("monCalamari");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel monCalamari = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		monCalamari.displayString = info.getInternalName();
		monCalamari.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(monCalamari);

		info = PlanetInformation.getPlanet("mustafar");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel mustafar = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		mustafar.displayString = info.getInternalName();
		mustafar.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(mustafar);

		info = PlanetInformation.getPlanet("naboo");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel naboo = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		naboo.displayString = info.getInternalName();
		naboo.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(naboo);

		info = PlanetInformation.getPlanet("sullust");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel sullust = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		sullust.displayString = info.getInternalName();
		sullust.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(sullust);

		info = PlanetInformation.getPlanet("utapau");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel utapau = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		utapau.displayString = info.getInternalName();
		utapau.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(utapau);

		info = PlanetInformation.getPlanet("yavin4");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel yavin4 = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		yavin4.displayString = info.getInternalName();
		yavin4.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(yavin4);

		info = PlanetInformation.getPlanet("jakku");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel jakku = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		jakku.displayString = info.getInternalName();
		jakku.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(jakku);

		info = PlanetInformation.getPlanet("takodana");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel takodana = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		takodana.displayString = info.getInternalName();
		takodana.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(takodana);

		info = PlanetInformation.getPlanet("dQar");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel dQar = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		dQar.displayString = info.getInternalName();
		dQar.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(dQar);

		info = PlanetInformation.getPlanet("ahchTo");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel ahchTo = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		ahchTo.displayString = info.getInternalName();
		ahchTo.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(ahchTo);

		info = PlanetInformation.getPlanet("deathStar");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel deathStar = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		deathStar.displayString = info.getInternalName();
		deathStar.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(deathStar);

		buttonClose = new OutlineButton(id++, 5, 5, 10, 10, "X", false);
		buttonList.add(buttonClose);
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if (button.enabled && button.visible)
		{
			if (!isZoom && PlanetInformation.getPlanet(button.displayString) != null)
			{
				this.oldZoomPlanet = null;
				this.zoomPlanet = PlanetInformation.getPlanet(button.displayString);
				this.animationZoom = new AnimationZoom();
				this.animationZoom.start();
				this.isZoom = true;
			}
			else if (button.id == buttonClose.id)
			{
				this.oldZoomPlanet = PlanetInformation.getPlanet(zoomPlanet.getInternalName());
				this.zoomPlanet = null;
				this.animationZoom = new AnimationZoom();
				this.animationZoom.setReverse(true);
				this.animationZoom.start();
				this.isZoom = false;
			}
		}
	}

	public void drawStars()
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

	public void drawGalaxy()
	{
		Tessellator tessellator = Tessellator.instance;
		this.mc.getTextureManager().bindTexture(galaxy);
		tessellator.startDrawingQuads();
		tessellator.setColorOpaque_I(0xFFFFFFFF);
		tessellator.addVertexWithUV(0.0D, 256, 0.0D, 0.0D, 2);
		tessellator.addVertexWithUV(256, 256, 0.0D, 1, 2);
		tessellator.addVertexWithUV(256, 0.0D, 0.0D, 1, 1);
		tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 1);
		tessellator.draw();
	}

	@Override
	public void drawScreen(int mX, int mY, float p)
	{
		this.drawStars();

		if (zoomPlanet == null && animationZoom.getTick() == 0)
		{
			GL11.glPushMatrix();
			GL11.glTranslatef(75, -35, 0);
			GLPZ.glScalef(1.3f);
			this.drawGalaxy();
			GL11.glPopMatrix();
		}

		this.buttonList.stream().filter(b -> PlanetInformation.getPlanet(((GuiButton)b).displayString) != null).forEach(b -> {
			OutlineButtonModel buttonModel = (OutlineButtonModel)b;
			PlanetInformation info = PlanetInformation.getPlanet(buttonModel.displayString);
			Point pt = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);

			if (info == zoomPlanet || info == oldZoomPlanet)
			{
				buttonModel.xPosition = (int)MathUtils.lerp(pt.x, (float)(r.getScaledWidth_double() / 2f) - 120, (float)animationZoom.getTick() / animationZoom.getMax());
				buttonModel.yPosition = (int)MathUtils.lerp(pt.y, (float)(r.getScaledHeight_double() / 2f) - 70, (float)animationZoom.getTick() / animationZoom.getMax());
			}

			buttonModel.visible = info == zoomPlanet || info == oldZoomPlanet || (zoomPlanet == null && animationZoom.getTick() == 0);
		});

		buttonClose.visible = zoomPlanet != null;

		PlanetInformation planet = zoomPlanet;
		if (planet == null)
			planet = oldZoomPlanet;

		if (planet != null)
		{
			GL11.glPushMatrix();
			GL11.glScalef(2, 2, 1);
			StarWarsMod.mc.fontRenderer.drawString(planet.getName().substring(0, (int)MathUtils.lerp(0, planet.getName().length(), (float)animationZoom.getTick() / animationZoom.getMax())), 160, 6, GLPalette.BRIGHT_YELLOW);
			GL11.glPopMatrix();
			int y = 32;
			String[] d = TextUtils.splitIntoLine(planet.getDescription(), 40);
			for (String d1 : d)
				StarWarsMod.mc.fontRenderer.drawString(d1.substring(0, (int)MathUtils.lerp(0, d1.length(), (float)animationZoom.getTick() / animationZoom.getMax())), 250, y += StarWarsMod.mc.fontRenderer.FONT_HEIGHT, GLPalette.BRIGHT_YELLOW);

			y += StarWarsMod.mc.fontRenderer.FONT_HEIGHT;

			int color = GLPalette.BRIGHT_YELLOW;
			if (planet.getAffiliation().equals(Resources.allegianceImperial) || planet.getAffiliation().equals(Resources.allegianceSith))
				color = GLPalette.BRIGHT_RED;
			else if (planet.getAffiliation().equals(Resources.allegianceRebel) || planet.getAffiliation().equals(Resources.allegianceJedi))
				color = GLPalette.BRIGHT_BLUE;
			String aff = ("Affiliation: " + planet.getAffiliation());
			StarWarsMod.mc.fontRenderer.drawString(aff.substring(0, (int)MathUtils.lerp(0, aff.length(), (float)animationZoom.getTick() / animationZoom.getMax())), 250, y += StarWarsMod.mc.fontRenderer.FONT_HEIGHT, color);

			y += StarWarsMod.mc.fontRenderer.FONT_HEIGHT;

			int ny = y;
			String headerTerrain = "Primary Terrain:";
			StarWarsMod.mc.fontRenderer.drawString(headerTerrain.substring(0, (int)MathUtils.lerp(0, headerTerrain.length(), (float)animationZoom.getTick() / animationZoom.getMax())), 250, y += StarWarsMod.mc.fontRenderer.FONT_HEIGHT, GLPalette.BRIGHT_YELLOW);
			for (String t : planet.getTerrain())
				StarWarsMod.mc.fontRenderer.drawString(t.substring(0, (int)MathUtils.lerp(0, t.length(), (float)animationZoom.getTick() / animationZoom.getMax())), 260, y += StarWarsMod.mc.fontRenderer.FONT_HEIGHT, GLPalette.BRIGHT_YELLOW);
			y += StarWarsMod.mc.fontRenderer.FONT_HEIGHT;

			String suns = "Suns: " + planet.getSuns();
			StarWarsMod.mc.fontRenderer.drawString(suns.substring(0, (int)MathUtils.lerp(0, suns.length(), (float)animationZoom.getTick() / animationZoom.getMax())), 380, ny += StarWarsMod.mc.fontRenderer.FONT_HEIGHT, GLPalette.BRIGHT_YELLOW);

			ny += StarWarsMod.mc.fontRenderer.FONT_HEIGHT;

			String moons = "Moons: " + planet.getMoons();
			StarWarsMod.mc.fontRenderer.drawString(moons.substring(0, (int)MathUtils.lerp(0, moons.length(), (float)animationZoom.getTick() / animationZoom.getMax())), 380, ny += StarWarsMod.mc.fontRenderer.FONT_HEIGHT, GLPalette.BRIGHT_YELLOW);

			ny = y;

			String mineralHeader = "Minerals: ";
			StarWarsMod.mc.fontRenderer.drawString(mineralHeader.substring(0, (int)MathUtils.lerp(0, mineralHeader.length(), (float)animationZoom.getTick() / animationZoom.getMax())), 380, ny += StarWarsMod.mc.fontRenderer.FONT_HEIGHT, GLPalette.BRIGHT_YELLOW);
			for (String t : planet.getResources())
				StarWarsMod.mc.fontRenderer.drawString(t.substring(0, (int)MathUtils.lerp(0, t.length(), (float)animationZoom.getTick() / animationZoom.getMax())), 390, ny += StarWarsMod.mc.fontRenderer.FONT_HEIGHT, GLPalette.BRIGHT_YELLOW);

			String nativeSpecies = "Inhabiting Species:";
			StarWarsMod.mc.fontRenderer.drawString(nativeSpecies.substring(0, (int)MathUtils.lerp(0, nativeSpecies.length(), (float)animationZoom.getTick() / animationZoom.getMax())), 250, y += StarWarsMod.mc.fontRenderer.FONT_HEIGHT, GLPalette.BRIGHT_YELLOW);
			for (String t : planet.getNativeSpecies())
				StarWarsMod.mc.fontRenderer.drawString(t.substring(0, (int)MathUtils.lerp(0, t.length(), (float)animationZoom.getTick() / animationZoom.getMax())), 260, y += StarWarsMod.mc.fontRenderer.FONT_HEIGHT, GLPalette.BRIGHT_YELLOW);
		}

		if (1 != 1)
		{
			PlanetInformation info = PlanetInformation.getPlanet("bespin");
			Point start = new Point((int)(info.getPosition().x * 10), (int)(info.getPosition().y * 10));

			info = PlanetInformation.getPlanet("tatooine");
			Point end = new Point((int)(info.getPosition().x * 10), (int)(info.getPosition().y * 10));

			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_TEXTURE_2D);

			GL11.glLineWidth(5);
			GLPalette.glColorI(GLPalette.WHITE);

			Point last = null;
			for (Point pt : pathfindingGrid.getPathFrom(start.x, start.y, end.x, end.y))
			{
				Point onscreen = galaxyCoordsToXy(pt.x + 0.9f, pt.y, 1.62f);
				if (last != null)
				{
					Screen2D.drawLine(last.x, last.y, onscreen.x, onscreen.y);
				}
				last = (Point)onscreen.clone();
			}
		}

		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		RenderHelper.enableStandardItemLighting();

		super.drawScreen(mX, mY, p);
	}

	public Point galaxyCoordsToXy(float x, float y, float scale)
	{
		float pX = r.getScaledWidth() / 2f - 144;
		float pY = r.getScaledHeight() / 2f - 144 + 16;
		return new Point((int)(pX + scale * x), (int)(pY + scale * y));
	}

	public Point galaxyCoordsToXy(float x, float y)
	{
		return galaxyCoordsToXy(x, y, 16);
	}
}