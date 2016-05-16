package com.parzivail.pswm.rendering;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.tileentities.TileEntityStaticNpc;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class RenderStaticNpc extends TileEntitySpecialRenderer
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID + ":" + "textures/models/npc/parzi.png");
	private final RenderHuman biped;

	public RenderStaticNpc()
	{
		this.biped = new RenderHuman(new ModelBiped(), 0.5f, texture);
		biped.setRenderManager(RenderManager.instance);
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
			GL11.glTranslated(x + 0.5f, y, z + 0.5f);
			if (staticNpc.getLocked())
				GL11.glRotatef(staticNpc.getFacing() * 90, 0, 1, 0);
			else
				GL11.glRotatef(staticNpc.getAngleToClosestPlayer(), 0, 1, 0);
			biped.doRender(staticNpc.getInternalEntity(), 0, 0, 0, 0, 0.0625f);
			GL11.glPopMatrix();
		}
	}
}
