package com.parzivail.pswm.rendering;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.blocks.ModelAncientJediStatue;
import com.parzivail.pswm.tileentities.TileEntityAncientJediStatue;
import com.parzivail.util.ui.GLPZ;
import com.parzivail.util.ui.ShaderHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class RenderAncientJediStatue extends TileEntitySpecialRenderer
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID + ":" + "textures/blocks/ancientJediStatue.png");

	private final ModelAncientJediStatue model;

	public RenderAncientJediStatue()
	{
		this.model = new ModelAncientJediStatue();
	}

	private void adjustRotatePivotViaMeta(World world, int x, int y, int z)
	{
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float tickTime)
	{
		int cap = GL12.GL_RESCALE_NORMAL;
		GL11.glPushMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(cap);
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glTranslated(x + 0.5f, y + 19.2f, z + 0.5f);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(((TileEntityAncientJediStatue)te).getFacing() * 22.5f, 0, 1, 0);
		GLPZ.glScalef(16f);
		GL11.glColor4f(1, 1, 1, 1);
		this.model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.05F);
		GLPZ.glScalef(0.3f);
		GL11.glScalef(1, -1, 1);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glTranslatef(0, -1.6f, -1.2f);
		IHandlesRender r = RenderLightsaber.models.get("revan");
		Minecraft.getMinecraft().renderEngine.bindTexture(r.getResourceLocation(false));
		ShaderHelper.setLightsaberColor(0x363636);
		ShaderHelper.useShader(ShaderHelper.glowSolid);
		r.renderItem(ItemRenderType.ENTITY, null);

		r = RenderLightsaber.blades.get("revan")[2];
		Minecraft.getMinecraft().renderEngine.bindTexture(r.getResourceLocation(false));
		r.renderItem(ItemRenderType.ENTITY, null);
		ShaderHelper.releaseShader();
		GL11.glEnable(cap);
		GL11.glPopMatrix();
	}
}
