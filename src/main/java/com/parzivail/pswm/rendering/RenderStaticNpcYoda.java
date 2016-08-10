package com.parzivail.pswm.rendering;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.tileentities.TileEntityStaticNpcYoda;
import com.parzivail.util.ui.GFX;
import com.parzivail.util.ui.GLPalette;
import com.parzivail.util.ui.P3D;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import static com.parzivail.util.ui.GFX.swIcons;

public class RenderStaticNpcYoda extends TileEntitySpecialRenderer
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID + ":" + "textures/models/npc/parzi.png");
	private final RenderNpcYoda biped;

	public RenderStaticNpcYoda()
	{
		this.biped = new RenderNpcYoda();
		biped.setRenderManager(RenderManager.instance);
	}

	private void adjustRotatePivotViaMeta(World world, int x, int y, int z)
	{
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float tickTime)
	{
		if (te instanceof TileEntityStaticNpcYoda)
		{
			TileEntityStaticNpcYoda staticNpc = (TileEntityStaticNpcYoda)te;
			GL11.glPushMatrix();

			GL11.glTranslated(x + 0.5f, y, z + 0.5f);

			P3D.glScalef(0.85f);

			if (staticNpc.getLocked())
				GL11.glRotatef(staticNpc.getFacing() * 90 + 180, 0, 1, 0);
			else
				GL11.glRotatef(-RenderManager.instance.playerViewY + 180, 0, 1, 0);

			GLPalette.glColorI(GLPalette.WHITE);

			if (staticNpc.getInternalEntity().worldObj != null)
				biped.doRender(staticNpc.getInternalEntity(), 0, 0, 0, 0, 0.0625f);

			GL11.glTranslatef(-0.375f, 2.6f, -0.05f);
			GL11.glScalef(1, -1, 1);

			GL11.glDisable(GL11.GL_CULL_FACE);
			GL11.glDisable(GL11.GL_LIGHTING);

			GL11.glPushMatrix();

			P3D.glScalef(0.05f);

			GL11.glTranslatef(0, MathHelper.sin(staticNpc.getInternalYoda().ticksExisted / 5f), 0);

			StarWarsMod.mc.renderEngine.bindTexture(swIcons);

			GFX.drawTexture(0, 0, 0, 26, 16, 16);

			GL11.glEnable(GL11.GL_LIGHTING);

			GL11.glPopMatrix();

			GL11.glPopMatrix();
		}
	}
}
