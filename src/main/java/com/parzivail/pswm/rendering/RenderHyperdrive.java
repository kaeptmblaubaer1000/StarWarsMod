package com.parzivail.pswm.rendering;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.ModelPlanetCube;
import com.parzivail.pswm.models.blocks.ModelHyperdriveBlock;
import com.parzivail.pswm.tileentities.TileEntityHyperdrive;
import com.parzivail.util.ui.P3D;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class RenderHyperdrive extends TileEntitySpecialRenderer
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID + ":" + "textures/models/hyperdriveBlock.png");

	private final ModelHyperdriveBlock model;
	private final ModelPlanetCube modelCube;

	public RenderHyperdrive()
	{
		this.model = new ModelHyperdriveBlock();
		this.modelCube = new ModelPlanetCube();

		Resources.planetTextures.put(0, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetEarth.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimTatooineId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetTatooine.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimHothId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetHoth.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimEndorId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetEndor.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimYavin4Id, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetYavin4.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimDagobahId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetDagobah.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimIlumId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetIlum.png"));
		Resources.planetTextures.put(48, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetKessel.png")); //This is Kessel, use 48 as the dim

	}

	private void adjustRotatePivotViaMeta(World world, int x, int y, int z)
	{
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float tickTime)
	{
		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glTranslated(x + 0.5f, y + 1.5f, z + 0.5f);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		P3D.glScalef(1.25f);
		this.model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.05F);
		int dim = te.getWorldObj().provider.dimensionId;
		if (Resources.planetTextures.containsKey(dim))
		{
			GL11.glTranslated(0, -0.5, 0);
			P3D.glScalef(0.4f);
			GL11.glTranslatef(0, MathHelper.sin((float)Math.toRadians(((TileEntityHyperdrive)te).getTicks())) / 10f, 0);
			GL11.glRotatef(((TileEntityHyperdrive)te).getTicks(), 0, 1, 0);
			Minecraft.getMinecraft().renderEngine.bindTexture(Resources.planetTextures.get(dim));
			this.modelCube.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.05F);
		}
		GL11.glPopMatrix();
	}
}
