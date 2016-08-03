package com.parzivail.pswm.rendering;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.quest.QuestUtils;
import com.parzivail.pswm.tileentities.TileEntityStaticNpc;
import com.parzivail.util.ui.GFX;
import com.parzivail.util.ui.GLPalette;
import com.parzivail.util.ui.P3D;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import static com.parzivail.util.ui.GFX.swIcons;

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
				GL11.glRotatef(staticNpc.getFacing() * 90 + 180, 0, 1, 0);
			else
				GL11.glRotatef(-RenderManager.instance.playerViewY + 180, 0, 1, 0);

			GLPalette.glColorI(GLPalette.WHITE);

			QuestUtils.setRightTexture(staticNpc, biped);

			if (staticNpc.getInternalEntity().worldObj != null)
				biped.doRender(staticNpc.getInternalEntity(), 0, 0, 0, 0, 0.0625f);

			GL11.glTranslatef(-0.375f, 3f, -0.05f);
			GL11.glScalef(1, -1, 1);

			GL11.glDisable(GL11.GL_CULL_FACE);
			GL11.glDisable(GL11.GL_LIGHTING);

			GL11.glPushMatrix();

			P3D.glScalef(0.05f);

			GL11.glTranslatef(0, MathHelper.sin(staticNpc.getInternalEntity().ticksExisted / 5f), 0);

			StarWarsMod.mc.renderEngine.bindTexture(swIcons);

			switch (staticNpc.getAff())
			{
				case Resources.allegianceJediFmt:
					GFX.drawTexture(0, 0, 0, 26, 16, 16);
					break;
				case Resources.allegianceSithFmt:
					GFX.drawTexture(0, 0, 17, 26, 16, 16);
					break;
				case Resources.allegianceRebelFmt:
					GFX.drawTexture(0, 0, 33, 26, 16, 16);
					break;
				case Resources.allegianceImperialFmt:
					GFX.drawTexture(0, 0, 49, 26, 16, 16);
					break;
				case Resources.allegianceMerchantFmt:
					GFX.drawTexture(0, 0, 5 * 16 + 1, 26, 16, 16);
					break;
				case Resources.allegianceCorellianFmt:
					GFX.drawTexture(0, 0, 6 * 16 + 1, 26, 16, 16);
					break;
				case Resources.allegianceBartenderFmt:
					GFX.drawTexture(0, 0, 7 * 16 + 1, 26, 16, 16);
					break;
				case Resources.allegianceWeaponDealerFmt:
					GFX.drawTexture(0, 0, 8 * 16 + 1, 26, 16, 16);
					break;
			}

			GL11.glEnable(GL11.GL_LIGHTING);

			GL11.glPopMatrix();

			GL11.glPopMatrix();
		}
	}

}
