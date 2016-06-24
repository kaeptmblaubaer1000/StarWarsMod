package com.parzivail.pswm.rendering;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.blocks.ModelHangingBucket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class RenderHangingBucket extends TileEntitySpecialRenderer
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID + ":" + "textures/blocks/hangingBucket.png");

	private final ModelHangingBucket model;

	public RenderHangingBucket()
	{
		this.model = new ModelHangingBucket();
	}

	private void adjustRotatePivotViaMeta(World world, int x, int y, int z)
	{
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float tickTime)
	{
		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glTranslated(x + 0.5f, y + 2.4f, z + 0.5f);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		GL11.glScalef(2, 2, 2);
		this.model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.05F);
		GL11.glPopMatrix();
	}
}
