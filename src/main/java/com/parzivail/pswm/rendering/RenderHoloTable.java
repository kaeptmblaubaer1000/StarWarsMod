package com.parzivail.pswm.rendering;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.tileentities.TileEntityHoloTableBase;
import com.parzivail.util.ui.RenderHelper;
import com.parzivail.util.ui.ShaderHelper;
import com.parzivail.util.world.WorldUtils;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

public class RenderHoloTable extends TileEntitySpecialRenderer
{
	public RenderHoloTable()
	{
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float p)
	{
		GL11.glPushMatrix();

		TileEntityHoloTableBase table = (TileEntityHoloTableBase)te;

		for (Entity e : WorldUtils.getEntitiesWithinAABB(te.getWorldObj(), Entity.class, te.getRenderBoundingBox().expand(table.getSideLength() / 2 - 6, table.getSideLength() / 2 - 2, table.getSideLength() / 2 - 6)))
		{
			if (e == StarWarsMod.mc.thePlayer)
				continue;
			GL11.glPushMatrix();
			Vec3 pos = StarWarsMod.mc.thePlayer.getPosition(p);
			GL11.glTranslated(-pos.xCoord, -pos.yCoord, -pos.zCoord);
			float dx = (float)(te.xCoord - e.posX) / -16f;
			float dy = (float)(te.yCoord - e.posY) / -16f;
			float dz = (float)(te.zCoord - e.posZ) / -16f;
			GL11.glTranslatef(te.xCoord + 0.5f + dx + table.getOffsetX() / 16f, te.yCoord + 1.04f + dy + table.getOffsetY() / 16f, te.zCoord + 0.5f + dz + table.getOffsetZ() / 16f);
			GL11.glScalef(1 / 16f, 1 / 16f, 1 / 16f);
			GL11.glTranslatef(-1, 0, -1);
			GL11.glColor4f(1, 1, 1, 1);
			RenderHelper.renderEntity(e);
			GL11.glPopMatrix();
		}

		if (table.isMapSetup() && table.getRGB() != null)
		{
			Vec3 pos = StarWarsMod.mc.thePlayer.getPosition(p);
			GL11.glTranslated(-pos.xCoord, -pos.yCoord, -pos.zCoord);
			GL11.glTranslatef(table.xCoord + 0.5f + table.getOffsetX() / 16f, table.yCoord + 1 + 0.001f + table.getOffsetY() / 16f, table.zCoord + 0.5f + table.getOffsetZ() / 16f);
			GL11.glScalef(1 / 16f, 1 / 16f, 1 / 16f);

			GL11.glPushMatrix();

			GL11.glDisable(GL11.GL_LIGHTING); // fix for dimming bug!
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glEnable(GL11.GL_LINE_SMOOTH);
			GL11.glDisable(GL11.GL_CULL_FACE);

			GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_ONE_MINUS_DST_COLOR);

			ShaderHelper.setColor(table.getRGB().getRed() / 255f, table.getRGB().getGreen() / 255f, table.getRGB().getBlue() / 255f, 0.2f);
			ShaderHelper.useShader(ShaderHelper.glowSolid);
			GL11.glCallList(table.getDisplayList());
			ShaderHelper.releaseShader();

			GL11.glDisable(GL11.GL_LINE_SMOOTH);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glEnable(GL11.GL_LIGHTING); // end of fix
			GL11.glPopMatrix();
		}
		else
			table.setupMap();

		GL11.glPopMatrix();
	}
}
