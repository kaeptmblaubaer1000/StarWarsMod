package com.parzivail.pswm.rendering.gui;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.dimension.PlanetInformation;
import com.parzivail.pswm.models.ModelPlanetCube;
import com.parzivail.util.ui.OutlineButton;
import com.parzivail.util.ui.OutlineButtonModel;
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
		PlanetInformation info = PlanetInformation.getPlanet("alderaan");
		Point p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel alderaan = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		alderaan.displayString = info.getName();
		alderaan.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(alderaan);

		info = PlanetInformation.getPlanet("bespin");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel bespin = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		bespin.displayString = info.getName();
		bespin.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(bespin);

		info = PlanetInformation.getPlanet("hoth");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel hoth = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		hoth.displayString = info.getName();
		hoth.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(hoth);

		info = PlanetInformation.getPlanet("earth");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel earth = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		earth.displayString = info.getName();
		earth.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(earth);

		info = PlanetInformation.getPlanet("coruscant");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel coruscant = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		coruscant.displayString = info.getName();
		coruscant.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(coruscant);

		info = PlanetInformation.getPlanet("dagobah");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel dagobah = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		dagobah.displayString = info.getName();
		dagobah.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(dagobah);

		info = PlanetInformation.getPlanet("dathomir");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel dathomir = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		dathomir.displayString = info.getName();
		dathomir.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(dathomir);

		info = PlanetInformation.getPlanet("endor");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel endor = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		endor.displayString = info.getName();
		endor.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(endor);

		info = PlanetInformation.getPlanet("geonosis");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel geonosis = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		geonosis.displayString = info.getName();
		geonosis.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(geonosis);

		info = PlanetInformation.getPlanet("tatooine");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel tatooine = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		tatooine.displayString = info.getName();
		tatooine.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(tatooine);

		info = PlanetInformation.getPlanet("ryloth");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel ryloth = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		ryloth.displayString = info.getName();
		ryloth.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(ryloth);

		info = PlanetInformation.getPlanet("ilum");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel ilum = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		ilum.displayString = info.getName();
		ilum.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(ilum);

		info = PlanetInformation.getPlanet("kamino");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel kamino = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		kamino.displayString = info.getName();
		kamino.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(kamino);

		info = PlanetInformation.getPlanet("kashyyyk");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel kashyyyk = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		kashyyyk.displayString = info.getName();
		kashyyyk.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(kashyyyk);

		info = PlanetInformation.getPlanet("kessel");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel kessel = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		kessel.displayString = info.getName();
		kessel.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(kessel);

		info = PlanetInformation.getPlanet("mandalore");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel mandalore = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		mandalore.displayString = info.getName();
		mandalore.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(mandalore);

		info = PlanetInformation.getPlanet("monCalamari");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel monCalamari = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		monCalamari.displayString = info.getName();
		monCalamari.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(monCalamari);

		info = PlanetInformation.getPlanet("mustafar");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel mustafar = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		mustafar.displayString = info.getName();
		mustafar.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(mustafar);

		info = PlanetInformation.getPlanet("naboo");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel naboo = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		naboo.displayString = info.getName();
		naboo.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(naboo);

		info = PlanetInformation.getPlanet("sullust");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel sullust = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		sullust.displayString = info.getName();
		sullust.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(sullust);

		info = PlanetInformation.getPlanet("utapau");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel utapau = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		utapau.displayString = info.getName();
		utapau.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(utapau);

		info = PlanetInformation.getPlanet("yavin4");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel yavin4 = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		yavin4.displayString = info.getName();
		yavin4.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(yavin4);

		info = PlanetInformation.getPlanet("jakku");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel jakku = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		jakku.displayString = info.getName();
		jakku.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(jakku);

		info = PlanetInformation.getPlanet("takodana");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel takodana = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		takodana.displayString = info.getName();
		takodana.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(takodana);

		info = PlanetInformation.getPlanet("dQar");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel dQar = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		dQar.displayString = info.getName();
		dQar.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(dQar);

		info = PlanetInformation.getPlanet("ahchTo");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel ahchTo = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		ahchTo.displayString = info.getName();
		ahchTo.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
		buttonList.add(ahchTo);

		info = PlanetInformation.getPlanet("deathStar");
		p = galaxyCoordsToXy(info.getPosition().x, info.getPosition().y);
		OutlineButtonModel deathStar = new OutlineButtonModel(id++, p.x, p.y, 4, 4);
		deathStar.displayString = info.getName();
		deathStar.setup(new ModelPlanetCube(), info.getCubeTexture(), transform);
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