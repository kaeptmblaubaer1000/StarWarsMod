package com.parzivail.pswm.rendering;

import org.lwjgl.opengl.GL11;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.tileentities.TileEntityStaticNpc;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RenderStaticNpc extends TileEntitySpecialRenderer
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID + ":" + "textures/models/npc/parzi.png");
	private final RenderHuman biped;

	public RenderStaticNpc()
	{
		this.biped = new RenderHuman(new ModelBiped(), 0.5f, texture);
	}

	private void adjustRotatePivotViaMeta(World world, int x, int y, int z)
	{
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float tickTime)
	{
		if (te instanceof TileEntityStaticNpc)
		{
			TileEntityStaticNpc staticNpc = (TileEntityStaticNpc)te;
			GL11.glPushMatrix();
			GL11.glTranslatef((float)x + 0.5F, (float)y + 3.5F, (float)z + 0.5F);
			biped.setRenderManager(RenderManager.instance); // fix concmodexc
			biped.doRender(staticNpc.getInternalEntity(), 0, 0, 0, 0, 0.0625f);
			GL11.glPopMatrix();
		}
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\RenderBlockTable.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */