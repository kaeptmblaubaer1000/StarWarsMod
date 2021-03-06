package com.parzivail.pswm.rendering;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.entities.EntityTilePassthrough;
import com.parzivail.pswm.models.blocks.ModelTarget;
import com.parzivail.pswm.tileentities.TileEntityTarget;
import com.parzivail.util.block.TileEntityRotate;
import com.parzivail.util.ui.P3D;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class RenderTarget extends TileEntitySpecialRenderer
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID + ":" + "textures/models/target.png");
	public static ResourceLocation textureAlt = new ResourceLocation(Resources.MODID + ":" + "textures/models/targetEmpire.png");

	private final ModelBase model;

	public RenderTarget()
	{
		this.model = new ModelTarget();
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
		if (te instanceof TileEntityRotate)
			GL11.glRotatef(90 * ((TileEntityTarget)te).getFacing(), 0, 1, 0);
		float n = 0;
		if (te instanceof TileEntityTarget)
		{
			Minecraft.getMinecraft().renderEngine.bindTexture(((TileEntityTarget)te).isAltSkin() ? textureAlt : texture);
			n = ((TileEntityTarget)te).isHit ? (float)Math.toRadians(-80) : 0;
		}
		((ModelTarget)model).MainParent.rotateAngleX = n;
		GL11.glPushAttrib(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_BLEND);
		this.model.render(new EntityTilePassthrough(te), 0, 0, 0, 0.0F, 0.0F, 0.05F);
		GL11.glPopAttrib();
		GL11.glPopMatrix();
	}
}

