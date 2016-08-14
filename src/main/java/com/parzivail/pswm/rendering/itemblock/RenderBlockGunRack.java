package com.parzivail.pswm.rendering.itemblock;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.rendering.RenderGunRack;
import com.parzivail.pswm.tileentities.TileEntityGunRack;
import com.parzivail.util.ui.P3D;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderBlockGunRack implements IItemRenderer
{
	private TileEntitySpecialRenderer render;
	private TileEntity tile;

	public RenderBlockGunRack()
	{
		render = new RenderGunRack();
		tile = new TileEntityGunRack();
		tile.setWorldObj(StarWarsMod.mc.theWorld);
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		GL11.glPushMatrix();
		this.tile.setWorldObj(StarWarsMod.mc.theWorld);
		this.tile.updateEntity();
		switch (type)
		{
			case INVENTORY:
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glTranslatef(0, -0.3f, 0);
				GL11.glRotatef(90, 0, 1, 0);
				P3D.glScalef(0.75f);
				GL11.glScalef(1, 1, -1);
				GL11.glTranslatef(-.03f, -.6f, 0);
				this.render.renderTileEntityAt(tile, 0, 0, 0, 0);
				GL11.glEnable(GL11.GL_CULL_FACE);
				GL11.glPopMatrix();
				break;
			case EQUIPPED:
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glRotatef(45, 0, 1, 0);
				GL11.glScalef(0.45f, 0.45f, -0.45f);
				GL11.glTranslatef(-0.5f, 1.2f, -3);
				GL11.glRotatef(45, 1, 0, 0);
				this.render.renderTileEntityAt(tile, 0, 0, 0, 0);
				GL11.glEnable(GL11.GL_CULL_FACE);
				GL11.glPopMatrix();
				break;
			case EQUIPPED_FIRST_PERSON:
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glScalef(1.5f, 1.5f, -1.5f);
				GL11.glTranslatef(3, -1, 0.5f);
				GL11.glRotatef(135, 0, 1, 0);
				this.render.renderTileEntityAt(tile, 0, 0, 0, 0);
				GL11.glEnable(GL11.GL_CULL_FACE);
				GL11.glPopMatrix();
				break;
			default:
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glRotatef(90, 0, 1, 0);
				GL11.glScalef(0.85f, 0.85f, -0.85f);
				GL11.glTranslatef(-0.5f, 0.4f, -0.5f);
				this.render.renderTileEntityAt(tile, 0, 0, 0, 0);
				GL11.glEnable(GL11.GL_CULL_FACE);
				GL11.glPopMatrix();
		}
		GL11.glPopMatrix();
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}
}