package com.parzivail.pswm.rendering;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.entities.EntityTilePassthrough;
import com.parzivail.pswm.models.blocks.hoth.ModelConsoleHothCurved1;
import com.parzivail.pswm.tileentities.TileEntityRenderGirderDouble;
import com.parzivail.util.block.TileEntityRotate;
import com.parzivail.util.ui.GLPZ;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class RenderRenderGirderDouble extends TileEntitySpecialRenderer
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID + ":" + "textures/models/renderGirderDouble.png");

	private final ModelBase model;

	public RenderRenderGirderDouble()
	{
		this.model = new RenderGirderDouble();
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
		GLPZ.glScalef(1.25f);
		if (te instanceof TileEntityRotate)
			GL11.glRotatef(90 * ((TileEntityRenderGirderDouble)te).getFacing(), 0, 1, 0);
		this.model.render(new EntityTilePassthrough(te), 0, 0, 0, 0.0F, 0.0F, 0.05F);
		GL11.glPopMatrix();
	}
}

