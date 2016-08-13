package com.parzivail.pswm.models.armor;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/**
 * ModelBiped - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ModelBackpackStorm extends ModelBiped
{
	public ModelRenderer MainParent;
	public ModelRenderer shape9;
	public ModelRenderer shape9_1;
	public ModelRenderer shape9_2;
	public ModelRenderer shape9_3;
	public ModelRenderer shape9_4;
	public ModelRenderer shape9_5;
	public ModelRenderer shape9_6;

	public static ResourceLocation texture1 = new ResourceLocation(Resources.MODID, "textures/models/backpackStorm.png");
	public static ResourceLocation texture2 = new ResourceLocation(Resources.MODID, "textures/models/stormtrooperArmorLayer1.png");
	private static ModelBiped armorModel = new ModelBiped(0.4f);

	public ModelBackpackStorm()
	{
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.shape9_3 = new ModelRenderer(this, 0, 0);
		this.shape9_3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape9_3.addBox(-3.0F, -4.0F, 0.9F, 6, 4, 2, 0.0F);
		this.shape9_2 = new ModelRenderer(this, 0, 0);
		this.shape9_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape9_2.addBox(-3.0F, -0.5F, 1.3F, 6, 1, 2, 0.0F);
		this.shape9_4 = new ModelRenderer(this, 0, 0);
		this.shape9_4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape9_4.addBox(-1.8F, -3.0F, 1.3F, 1, 2, 2, 0.0F);
		this.shape9_1 = new ModelRenderer(this, 0, 0);
		this.shape9_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape9_1.addBox(-3.0F, -4.5F, 1.3F, 6, 1, 2, 0.0F);
		this.MainParent = new ModelRenderer(this, 0, 0);
		this.MainParent.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.MainParent.addBox(-3.0F, -4.5F, 1.3F, 1, 5, 2, 0.0F);
		this.shape9_5 = new ModelRenderer(this, 0, 0);
		this.shape9_5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape9_5.addBox(-0.3F, -3.0F, 1.3F, 2, 2, 2, 0.0F);
		this.shape9 = new ModelRenderer(this, 0, 0);
		this.shape9.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape9.addBox(2.0F, -4.5F, 1.3F, 1, 5, 2, 0.0F);
		this.shape9_6 = new ModelRenderer(this, 0, 0);
		this.shape9_6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape9_6.addBox(-2.5F, 2.5F, 1.3F, 5, 2, 2, 0.0F);
		this.MainParent.addChild(this.shape9_3);
		this.MainParent.addChild(this.shape9_2);
		this.MainParent.addChild(this.shape9_4);
		this.MainParent.addChild(this.shape9_1);
		this.MainParent.addChild(this.shape9_5);
		this.MainParent.addChild(this.shape9);
		this.MainParent.addChild(this.shape9_6);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		StarWarsMod.mc.renderEngine.bindTexture(texture1);
		this.MainParent.rotationPointZ = entity.isSneaking() ? 3.4f : 0;
		this.MainParent.rotateAngleX = entity.isSneaking() ? 0.5f : 0;
		this.shape9_6.rotationPointZ = 0.5f;
		this.MainParent.render(f5);

		if (entity instanceof EntityLivingBase)
		{
			EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
			StarWarsMod.mc.renderEngine.bindTexture(texture2);
			this.doRotationStuff(entityLivingBase, entityLivingBase.getHeldItem());
			armorModel.onGround = entityLivingBase.getSwingProgress(f5);
			armorModel.render(entity, f, f1, f2, f3, f4, f5);
		}
	}

	protected void doRotationStuff(EntityLivingBase entity, ItemStack stack)
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
