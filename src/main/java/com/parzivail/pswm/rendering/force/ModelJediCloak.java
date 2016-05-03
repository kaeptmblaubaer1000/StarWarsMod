package com.parzivail.pswm.rendering.force;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.event.RenderPlayerEvent;
import org.lwjgl.opengl.GL11;

/**
 * Jedi Robes - Weaston
 * <p>
 * Created using Tabula 4.1.1
 */
public class ModelJediCloak extends ModelBiped
{
	public ModelRenderer BodyMain;
	public ModelRenderer FootL;
	public ModelRenderer FootR;
	public ModelRenderer ArmR;
	public ModelRenderer ArmL;
	public ModelRenderer Cape;
	public ModelRenderer HoodBack;
	public ModelRenderer HoodTop;
	public ModelRenderer HoodL;
	public ModelRenderer HoodR;

	public ModelJediCloak()
	{
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.bipedLeftArm = new ModelRenderer(this, 0, 83);
		this.bipedLeftArm.setRotationPoint(-4.5F, 2.0F, 0.0F);
		this.bipedLeftArm.addBox(-4.5F, -2.0F, -2.5F, 5, 10, 5, 0.0F);
		this.HoodL = new ModelRenderer(this, 30, 38);
		this.HoodL.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HoodL.addBox(-4.5F, -8.5F, -4.5F, 1, 9, 6, 0.0F);
		this.bipedRightArm = new ModelRenderer(this, 0, 62);
		this.bipedRightArm.setRotationPoint(4.5F, 2.0F, 0.0F);
		this.bipedRightArm.addBox(-0.5F, -2.0F, -2.5F, 5, 10, 5, 0.0F);
		this.HoodTop = new ModelRenderer(this, 30, 25);
		this.HoodTop.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HoodTop.addBox(-4.5F, -8.5F, -4.5F, 9, 1, 6, 0.0F);
		this.HoodR = new ModelRenderer(this, 30, 57);
		this.HoodR.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HoodR.addBox(3.5F, -8.5F, -4.5F, 1, 9, 6, 0.0F);
		this.bipedRightLeg = new ModelRenderer(this, 0, 44);
		this.bipedRightLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
		this.bipedRightLeg.addBox(-2.5F, 5.0F, -2.5F, 5, 7, 5, 0.0F);
		this.bipedCloak = new ModelRenderer(this, 35, 0);
		this.bipedCloak.setRotationPoint(0.0F, 1.0F, -2.5F);
		this.bipedCloak.addBox(-4.5F, 0.0F, 1.0F, 9, 20, 1, 0.0F);
		this.HoodBack = new ModelRenderer(this, 62, 0);
		this.HoodBack.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.HoodBack.addBox(-4.5F, -8.5F, 1.5F, 9, 11, 3, 0.0F);
		this.bipedBody = new ModelRenderer(this, 0, 0);
		this.bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedBody.addBox(-4.5F, 0.0F, -2.5F, 9, 17, 5, 0.0F);
		this.bipedLeftLeg = new ModelRenderer(this, 0, 26);
		this.bipedLeftLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
		this.bipedLeftLeg.addBox(-2.5F, 5.0F, -2.5F, 5, 7, 5, 0.0F);
		this.bipedBody.addChild(this.bipedLeftArm);
		this.bipedBody.addChild(this.HoodL);
		this.bipedBody.addChild(this.bipedRightArm);
		this.bipedBody.addChild(this.HoodTop);
		this.bipedBody.addChild(this.HoodR);
		this.bipedBody.addChild(this.bipedRightLeg);
		// this.BodyMain.addChild(this.Cape);
		this.bipedBody.addChild(this.HoodBack);
		this.bipedBody.addChild(this.bipedLeftLeg);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		this.bipedLeftArm.setRotationPoint(8F, 1.5F, 0.0F);
		this.bipedRightArm.setRotationPoint(-8F, 1.5F, 0.0F);
		this.bipedBody.render(f5);
	}

	public void renderCape(float f5)
	{
		this.bipedCloak.render(f5);
	}

	public void renderCloak(RenderPlayerEvent.Specials.Post event)
	{
		if (event.entityPlayer.inventory.armorItemInSlot(2) != null && event.entityPlayer.inventory.armorItemInSlot(2).getItem() == StarWarsMod.jediRobes)
		{
			GL11.glPushMatrix();
			// GL11.glTranslatef(0.0F, -0.25F, 0.125F);
			double d3 = event.entityPlayer.field_71091_bM + (event.entityPlayer.field_71094_bP - event.entityPlayer.field_71091_bM) * event.partialRenderTick - (event.entityPlayer.prevPosX + (event.entityPlayer.posX - event.entityPlayer.prevPosX) * event.partialRenderTick);
			double d4 = event.entityPlayer.field_71096_bN + (event.entityPlayer.field_71095_bQ - event.entityPlayer.field_71096_bN) * event.partialRenderTick - (event.entityPlayer.prevPosY + (event.entityPlayer.posY - event.entityPlayer.prevPosY) * event.partialRenderTick);
			double d0 = event.entityPlayer.field_71097_bO + (event.entityPlayer.field_71085_bR - event.entityPlayer.field_71097_bO) * event.partialRenderTick - (event.entityPlayer.prevPosZ + (event.entityPlayer.posZ - event.entityPlayer.prevPosZ) * event.partialRenderTick);
			float f4 = event.entityPlayer.prevRenderYawOffset + (event.entityPlayer.renderYawOffset - event.entityPlayer.prevRenderYawOffset) * event.partialRenderTick;
			double d1 = MathHelper.sin(f4 * (float)Math.PI / 180.0F);
			double d2 = -MathHelper.cos(f4 * (float)Math.PI / 180.0F);
			float f5 = (float)d4 * 10.0F;

			if (f5 < -6.0F)
				f5 = -6.0F;

			if (f5 > 32.0F)
				f5 = 32.0F;

			float f6 = (float)(d3 * d1 + d0 * d2) * 100.0F;
			float f7 = (float)(d3 * d2 - d0 * d1) * 100.0F;

			if (f6 < 0.0F)
				f6 = 0.0F;

			float f8 = event.entityPlayer.prevCameraYaw + (event.entityPlayer.cameraYaw - event.entityPlayer.prevCameraYaw) * event.partialRenderTick;
			f5 += MathHelper.sin((event.entityPlayer.prevDistanceWalkedModified + (event.entityPlayer.distanceWalkedModified - event.entityPlayer.prevDistanceWalkedModified) * event.partialRenderTick) * 6.0F) * 32.0F * f8;

			if (event.entityPlayer.isSneaking())
				f5 += 25.0F;

			f6 *= 1.8f;

			GL11.glRotatef(6.0F + f6 / 2.0F + f5, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(f7 / 2.0F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(-f7 / 2.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
			GL11.glScalef(1, 1, 1);
			StarWarsMod.mc.getTextureManager().bindTexture(Resources.capeTexture);
			// rp.modelBipedMain.renderCloak(0.0625F);
			this.renderCape(0.0625F);
			GL11.glPopMatrix();
		}
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		this.HoodBack.rotateAngleY = f3 / (180F / (float)Math.PI);
		this.HoodBack.rotateAngleX = f4 / (180F / (float)Math.PI);

		this.HoodL.rotateAngleY = f3 / (180F / (float)Math.PI);
		this.HoodL.rotateAngleX = f4 / (180F / (float)Math.PI);

		this.HoodR.rotateAngleY = f3 / (180F / (float)Math.PI);
		this.HoodR.rotateAngleX = f4 / (180F / (float)Math.PI);

		this.HoodTop.rotateAngleY = f3 / (180F / (float)Math.PI);
		this.HoodTop.rotateAngleX = f4 / (180F / (float)Math.PI);

		if (entity.isSneaking())
		{
			this.HoodBack.rotationPointY = 1.0F;
			this.HoodL.rotationPointY = 1.0F;
			this.HoodR.rotationPointY = 1.0F;
			this.HoodTop.rotationPointY = 1.0F;
		}
		else
		{
			this.HoodBack.rotationPointY = 0.0F;
			this.HoodL.rotationPointY = 0.0F;
			this.HoodR.rotationPointY = 0.0F;
			this.HoodTop.rotationPointY = 0.0F;
		}
	}
}
