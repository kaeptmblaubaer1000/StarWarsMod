package com.parzivail.pswm.models.armor;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import static com.parzivail.pswm.rendering.ArmorRenderHelper.renderModel;

/**
 * ModelBiped - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ModelBackpackHoth extends ModelBiped
{
	public ModelRenderer parent;
	public ModelRenderer shape9;
	public ModelRenderer shape9_1;
	public ModelRenderer shape9_2;
	public ModelRenderer shape9_3;
	public ModelRenderer shape9_4;
	public ModelRenderer shape9_5;
	public ModelRenderer shape9_6;
	public ModelRenderer shape9_7;
	public ModelRenderer shape9_8;

	public static ResourceLocation texture1 = new ResourceLocation(Resources.MODID, "textures/models/backpackHoth.png");
	public static ResourceLocation texture2 = new ResourceLocation(Resources.MODID, "textures/models/hothArmorLayer1.png");
	private static ModelCompressionArmor armorModel;

	public ModelBackpackHoth(ItemArmor armor)
	{
		armorModel = new ModelCompressionArmor(0.4f, armor);
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.parent = new ModelRenderer(this, 0, 0);
		this.parent.setRotationPoint(0.0F, 5.7F, 0.0F);
		this.parent.addBox(-4.0F, 1.0F, 1.7F, 8, 5, 3, 0.0F);
		this.shape9_1 = new ModelRenderer(this, 0, 19);
		this.shape9_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape9_1.addBox(-4.5F, 0.3F, 1.1F, 9, 1, 4, 0.0F);
		this.shape9_3 = new ModelRenderer(this, 23, 0);
		this.shape9_3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape9_3.addBox(4.1F, -3.7F, 2.7F, 1, 2, 1, 0.0F);
		this.shape9_4 = new ModelRenderer(this, 28, 0);
		this.shape9_4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape9_4.addBox(4.5F, -8.7F, 2.7F, 1, 6, 1, 0.0F);
		this.shape9_7 = new ModelRenderer(this, 23, 14);
		this.shape9_7.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape9_7.addBox(0.4F, -2.1F, 1.7F, 1, 1, 4, 0.0F);
		this.setRotateAngle(shape9_7, 0.06981317007977318F, 0.0F, 0.0F);
		this.shape9_8 = new ModelRenderer(this, 34, 8);
		this.shape9_8.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape9_8.addBox(-2.5F, 2.0F, 1.1F, 5, 2, 4, 0.0F);
		this.shape9 = new ModelRenderer(this, 0, 9);
		this.shape9.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape9.addBox(-4.0F, -5.0F, 1.7F, 8, 6, 3, 0.0F);
		this.setRotateAngle(shape9, 0.06981317007977318F, 0.0F, 0.0F);
		this.shape9_6 = new ModelRenderer(this, 23, 8);
		this.shape9_6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape9_6.addBox(-1.3F, -2.1F, 1.7F, 1, 1, 4, 0.0F);
		this.setRotateAngle(shape9_6, 0.06981317007977318F, 0.0F, 0.0F);
		this.shape9_5 = new ModelRenderer(this, 33, 0);
		this.shape9_5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape9_5.addBox(-2.0F, -3.1F, 1.1F, 4, 3, 4, 0.0F);
		this.setRotateAngle(shape9_5, 0.06981317007977318F, 0.0F, 0.0F);
		this.shape9_2 = new ModelRenderer(this, 0, 25);
		this.shape9_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape9_2.addBox(3.5F, -4.2F, 2.2F, 1, 3, 2, 0.0F);
		this.parent.addChild(this.shape9_1);
		this.parent.addChild(this.shape9_3);
		this.parent.addChild(this.shape9_4);
		this.parent.addChild(this.shape9_7);
		this.parent.addChild(this.shape9_8);
		this.parent.addChild(this.shape9);
		this.parent.addChild(this.shape9_6);
		this.parent.addChild(this.shape9_5);
		this.parent.addChild(this.shape9_2);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		StarWarsMod.mc.renderEngine.bindTexture(texture1);
		this.parent.rotationPointZ = entity.isSneaking() ? 3.4f : 0;
		this.parent.rotateAngleX = entity.isSneaking() ? 0.5f : 0;
		this.parent.render(f5);

		if (entity instanceof EntityLivingBase)
		{
			EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
			StarWarsMod.mc.renderEngine.bindTexture(texture2);
			this.doRotationStuff(entityLivingBase, entityLivingBase.getHeldItem());
			armorModel.onGround = entityLivingBase.getSwingProgress(f5);
			if (entity instanceof EntityPlayer)
				renderModel(armorModel, (EntityPlayer)entity, f, f1, f2, f3, f4, f5);
			else if (entity instanceof EntityPlayer)
				renderModel(armorModel, (EntityPlayer)entity, f, f1, f2, f3, f4, f5);
			else
				armorModel.render(entity, f, f1, f2, f3, f4, f5);
		}
	}

	private void doRotationStuff(EntityLivingBase entity, ItemStack stack)
	{
		armorModel.heldItemRight = stack != null ? 1 : 0;
		armorModel.isSneak = entity.isSneaking();
		armorModel.bipedHead.showModel = false;
		armorModel.bipedHeadwear.showModel = false;
		armorModel.bipedBody.showModel = true;
		armorModel.bipedRightArm.showModel = true;
		armorModel.bipedLeftArm.showModel = true;
		armorModel.bipedRightLeg.showModel = false;
		armorModel.bipedLeftLeg.showModel = false;
		armorModel.isRiding = entity.isRiding();
		armorModel.isChild = entity.isChild();
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
}
