package com.parzivail.pswm.rendering.item;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.vehicles.ModelSkyhopper;
import com.parzivail.pswm.models.vehicles.ModelTIEAdvanced;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderSpawnSkyhopper implements IItemRenderer
{
	private static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/skyhopper.png");

	private ModelSkyhopper model;

	public RenderSpawnSkyhopper()
	{
		this.model = new ModelSkyhopper();
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
				GL11.glScalef(0.025F, -0.025F, 0.025F);
				GL11.glTranslatef(-14.25f, 22.0f, 1f);
				GL11.glRotatef(0, 0, 0, 1);
				GL11.glRotatef(260, 0, 1, 0);
				GL11.glTranslatef(-10, 0, 0);
				GL11.glScalef(1, 1, -1);
				this.model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
				GL11.glEnable(GL11.GL_CULL_FACE);
				GL11.glPopMatrix();
				break;
			case EQUIPPED:
				if (data[1] instanceof EntityPlayer)
				{
					GL11.glPushMatrix();
					GL11.glDisable(GL11.GL_CULL_FACE);
					GL11.glScalef(0.12F, -0.12F, 0.12F);
					GL11.glRotatef(-40, 0, 1, 0);
					GL11.glRotatef(22, 0, 0, 1);
					GL11.glTranslatef(19, 7, 0);
					GL11.glRotatef(90, 0, 0, -1);
					GL11.glTranslatef(15, -11, 0);
					GL11.glScalef(-1, -1, 1);
					GL11.glRotatef(90, 0, 0, 1);
					this.model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
					GL11.glEnable(GL11.GL_CULL_FACE);
					GL11.glPopMatrix();
				}
				else
				{
					GL11.glPushMatrix();
					GL11.glDisable(GL11.GL_CULL_FACE);
					GL11.glScalef(0.07F, 0.07F, 0.07F);
					GL11.glRotatef(-40, 0, 1, 0);
					GL11.glRotatef(11, 1, 0, 0);
					GL11.glTranslatef(20, 27f, 1);
					GL11.glRotatef(90, 0, 0, -1);
					GL11.glTranslatef(15, -11, 0);
					GL11.glScalef(-1, -1, 1);
					GL11.glRotatef(90, 1, 0, 0);
					this.model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
					GL11.glEnable(GL11.GL_CULL_FACE);
					GL11.glPopMatrix();
				}
				break;
			case EQUIPPED_FIRST_PERSON:
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glScalef(0.0155F, -0.0155F, 0.0155F);
				GL11.glTranslatef(8, -55, 48);
				GL11.glRotatef(180, 0, 0, 1);
				GL11.glRotatef(60, 0, 1, 0);
				GL11.glRotatef(25, 1, 0, 0);
				GL11.glRotatef(-8, 0, 1, 0);
				GL11.glTranslatef(8, 10, 6);
				GL11.glScalef(-1, -1, -1);
				GL11.glRotatef(-30, 1, 0.1f, 0);
				this.model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
				GL11.glEnable(GL11.GL_CULL_FACE);
				GL11.glPopMatrix();
				break;
			default:
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glScalef(0.07F, -0.07F, 0.07F);
				GL11.glRotatef(90, 0, 0, 1);
				GL11.glTranslatef(-25, -2, -2);
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