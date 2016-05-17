package com.parzivail.pswm.rendering.item;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.vehicles.ModelXWingNew;
import com.parzivail.pswm.models.vehicles.ModelYWing;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderSpawnYWing implements IItemRenderer
{
	private static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/ywing.png");

	private ModelYWing model;

	public RenderSpawnYWing()
	{
		this.model = new ModelYWing();
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
				GL11.glTranslatef(-31, -2, 1f);
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
					GL11.glScalef(0.018F, -0.018F, 0.018F);
					GL11.glRotatef(-40, 0, 1, 0);
					GL11.glRotatef(24, 0, 0, 1);
					GL11.glTranslatef(33, -10, 3);
					GL11.glRotatef(90, 1, 0, 0);
					GL11.glRotatef(90, 0, 0, -1);
					GL11.glRotatef(90, 1, 0, 0);
					GL11.glRotatef(88, -1, 0, 0);
					GL11.glTranslatef(-2.75f, 0, 35);
					GL11.glScalef(-1, -1, 1);
					GL11.glRotatef(90, 0, 0, 1);
					GL11.glRotatef(90, 0, 0, 1);
					GL11.glRotatef(2, 0, 0, 1);
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
				GL11.glScalef(0.019F, -0.019F, 0.019F);
				GL11.glTranslatef(10, -56.5f, 45);
				GL11.glRotatef(180, 0, 0, 1);
				GL11.glRotatef(60, 0, 1, 0);
				GL11.glRotatef(25, 1, 0, 0);
				GL11.glRotatef(-10, 0, 1, 0);
				GL11.glTranslatef(8, 10, 6);
				GL11.glScalef(-1, -1, -1);
				GL11.glRotatef(-25, 1, -0.085f, 0);
				this.model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
				GL11.glEnable(GL11.GL_CULL_FACE);
				GL11.glPopMatrix();
				break;
			default:
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glScalef(0.036F, -0.036F, 0.036F);
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