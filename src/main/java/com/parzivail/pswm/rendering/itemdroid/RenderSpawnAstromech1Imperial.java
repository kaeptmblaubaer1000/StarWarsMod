package com.parzivail.pswm.rendering.itemdroid;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.mobs.ModelDroidAstromech;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderSpawnAstromech1Imperial implements IItemRenderer
{
	private static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/astromechImperial.png");

	private ModelDroidAstromech model;

	public RenderSpawnAstromech1Imperial()
	{
		this.model = new ModelDroidAstromech();
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
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		switch (type)
		{
			case INVENTORY:
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glScalef(0.0775F, -0.0775F, 0.0775F);
				GL11.glRotatef(180, 0, 1, 0);
				GL11.glRotatef(260, 0, 1, 0);
				GL11.glScalef(1, 1, -1);
				GL11.glTranslatef(0, -7f, 0);
				this.model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
				GL11.glEnable(GL11.GL_CULL_FACE);
				GL11.glPopMatrix();
				break;
			case EQUIPPED:
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glScalef(0.03F, -0.03F, 0.03F);
				GL11.glRotatef(-40, 0, 1, 0);
				GL11.glRotatef(24, 0, 0, 1);
				GL11.glTranslatef(19, 7, 0);
				GL11.glRotatef(90, 1, 0, 0);
				GL11.glRotatef(90, 0, 0, -1);
				GL11.glRotatef(90, 1, 0, 0);
				GL11.glRotatef(88, -1, 0, 0);
				GL11.glTranslatef(-2.75f, 25, 38);
				GL11.glScalef(-1, -1, 1);
				GL11.glRotatef(90, 0, 0, 1);
				GL11.glRotatef(90, 0, 0, 1);
				GL11.glRotatef(4, 0, 0, 1);
				GL11.glRotatef(-45, 1, 0, 0);
				GL11.glTranslatef(-1, -20, -14);
				this.model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
				GL11.glEnable(GL11.GL_CULL_FACE);
				GL11.glPopMatrix();
				break;
			case EQUIPPED_FIRST_PERSON:
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glScalef(0.04F, -0.04F, 0.04F);
				GL11.glTranslatef(48, -40, 38);
				GL11.glRotatef(180, 0, 0, 1);
				GL11.glRotatef(60, 0, 1, 0);
				GL11.glRotatef(25, 1, 0, 0);
				GL11.glRotatef(-8, 0, 1, 0);
				GL11.glTranslatef(48, 10, 25);
				GL11.glScalef(-1, -1, -1);
				GL11.glRotatef(-30, 1, 0.1f, 0);
				this.model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
				GL11.glEnable(GL11.GL_CULL_FACE);
				GL11.glPopMatrix();
				break;
			default:
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glScalef(0.04F, -0.04F, 0.04F);
				GL11.glTranslatef(0, 5, 0);
				GL11.glTranslatef(0, -20, 0);
				this.model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
				GL11.glEnable(GL11.GL_CULL_FACE);
				GL11.glPopMatrix();
				break;
		}
		GL11.glPopMatrix();
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}
}