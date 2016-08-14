package com.parzivail.pswm.rendering;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.entities.EntityTilePassthrough;
import com.parzivail.pswm.models.blocks.ModelHothCeilingLight2;
import com.parzivail.pswm.tileentities.TileEntityHothCeilingLight2;
import com.parzivail.util.block.TileEntityRotate;
import com.parzivail.util.ui.P3D;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class RenderHothCeilingLight2 extends TileEntitySpecialRenderer
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID + ":" + "textures/models/hothCeilingLight2.png");

	private final ModelBase model;

	public RenderHothCeilingLight2()
	{
		this.model = new ModelHothCeilingLight2();
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

		if (te instanceof TileEntityRotate)
			GL11.glRotatef(90 * ((TileEntityHothCeilingLight2)te).getFacing(), 0, 1, 0);

		GL11.glPushMatrix();
		P3D.glScalef(1.25f);

		this.model.render(te == null ? null : new EntityTilePassthrough(te), 0, 0, 0, 0.0F, 0.0F, 0.05F);
		GL11.glPopMatrix();

		GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
		GL11.glDisable(GL11.GL_TEXTURE_2D);

		if (te != null)
		{

			int i = 1;
			boolean flag = false;
			while (i <= 50)
			{
				if (!te.getWorldObj().isAirBlock(te.xCoord, te.yCoord + i, te.zCoord))
				{
					flag = true;
					break;
				}
				i++;
			}

			if (flag)
			{
				GL11.glColor4f(0, 0, 0, 1);
				GL11.glLineWidth((float)(30 / Math.sqrt(x * x + y * y + z * z)));
				P3D.drawLine(0, 0.5f, 0.4f, 0, -i + 1, 0.4f);
				P3D.drawLine(0, 0.5f, -0.4f, 0, -i + 1, -0.4f);
			}
		}
		GL11.glPopAttrib();

		GL11.glPopMatrix();
	}
}

