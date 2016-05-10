package com.parzivail.pswm.rendering;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.ModelHyperdriveBlock;
import com.parzivail.pswm.models.ModelPlanetCube;
import com.parzivail.util.ui.GLPZ;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;

public class RenderHyperdrive extends TileEntitySpecialRenderer
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID + ":" + "textures/models/hyperdriveBlock.png");
	public static HashMap<Integer, ResourceLocation> planetTextures = new HashMap<>();

	private final ModelHyperdriveBlock model;
	private final ModelPlanetCube modelCube;

	public RenderHyperdrive()
	{
		this.model = new ModelHyperdriveBlock();
		this.modelCube = new ModelPlanetCube();

		planetTextures.put(0, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetEarth.png"));
		planetTextures.put(Resources.ConfigOptions.dimTatooineId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetTatooine.png"));
	}

	private void adjustRotatePivotViaMeta(World world, int x, int y, int z)
	{
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float tickTime)
	{
		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glTranslated(x + 0.5f, y + 1.2f, z + 0.5f);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		this.model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.05F);
		int dim = 0;
		if (planetTextures.containsKey(dim))
		{
			GL11.glTranslated(0, -0.5, 0);
			GLPZ.glScalef(0.4f);
			GL11.glRotatef((System.currentTimeMillis() % 36000) / 100f, 0, 1, 0);
			Minecraft.getMinecraft().renderEngine.bindTexture(planetTextures.get(dim));
			this.modelCube.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.05F);
		}
		GL11.glPopMatrix();
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\RenderMV.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */