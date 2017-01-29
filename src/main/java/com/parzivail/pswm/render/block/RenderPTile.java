package com.parzivail.pswm.render.block;

import com.parzivail.util.basic.TileEntityRotate;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderPTile extends TileEntitySpecialRenderer<TileEntityRotate>
{
	private ResourceLocation texture;
	private ModelBase modelBase;
	private EntityTEPassthrough passthrough;

	public RenderPTile(ResourceLocation texture, ModelBase modelBase)
	{
		this.texture = texture;
		this.modelBase = modelBase;
		this.passthrough = new EntityTEPassthrough();
	}

	@Override
	public void renderTileEntityAt(TileEntityRotate te, double x, double y, double z, float partialTick, int destroyStage)
	{
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5, y, z + 0.5);
		GL11.glScalef(1, -1, 1);

		this.bindTexture(texture);
		modelBase.render(passthrough.set(te), (float)x, (float)y, (float)z, partialTick, destroyStage, 0.0625f);

		GL11.glPopMatrix();
	}

	private class EntityTEPassthrough extends Entity
	{
		private TileEntityRotate tileEntityRotate;

		public EntityTEPassthrough()
		{
			super(null);
		}

		public EntityTEPassthrough set(TileEntityRotate tileEntityRotate)
		{
			this.tileEntityRotate = tileEntityRotate;
			return this;
		}

		@Override
		protected void entityInit()
		{

		}

		@Override
		protected void readEntityFromNBT(NBTTagCompound compound)
		{

		}

		@Override
		protected void writeEntityToNBT(NBTTagCompound compound)
		{

		}
	}
}
