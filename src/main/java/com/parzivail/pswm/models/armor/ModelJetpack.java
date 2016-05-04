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
 * Z-6 Jetpack - Undefined Created using Tabula 4.1.1
 */
public class ModelJetpack extends ModelBiped
{
	public ModelRenderer JetpackMain;
	public ModelRenderer Jetpack1;
	public ModelRenderer Jetpack3;
	public ModelRenderer Jetpack4;
	public ModelRenderer Jetpack5;
	public ModelRenderer Jetpack7;
	public ModelRenderer Jetpack8;
	public ModelRenderer Jetpack9;
	public ModelRenderer Jetpack10;
	public ModelRenderer Jetpack11;
	public ModelRenderer Jetpack2;
	public ModelRenderer Jetpack6;

	public static ResourceLocation texture2 = new ResourceLocation(Resources.MODID, "textures/models/bobaArmorLayer1.png");
	private static ModelBiped armorModel = new ModelBiped(0.5f);

	public ModelJetpack()
	{
		this.textureWidth = 256;
		this.textureHeight = 256;
		this.Jetpack11 = new ModelRenderer(this, 0, 118);
		this.Jetpack11.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Jetpack11.addBox(-1.0F, -12.8F, 4.0F, 2, 7, 2, 0.0F);
		this.Jetpack2 = new ModelRenderer(this, 0, 136);
		this.Jetpack2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Jetpack2.addBox(-4.5F, -5.0F, 2.0F, 3, 10, 3, 0.0F);
		this.Jetpack8 = new ModelRenderer(this, 0, 75);
		this.Jetpack8.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Jetpack8.addBox(-1.0F, -4.0F, 4.0F, 2, 8, 3, 0.0F);
		this.Jetpack4 = new ModelRenderer(this, 0, 37);
		this.Jetpack4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Jetpack4.addBox(5.0F, 1.5F, 2.5F, 2, 4, 2, 0.0F);
		this.JetpackMain = new ModelRenderer(this, 0, 0);
		this.JetpackMain.setRotationPoint(0.0F, 5.0F, 0.0F);
		this.JetpackMain.addBox(-4.0F, -5.0F, 2.0F, 8, 10, 2, 0.0F);
		this.Jetpack5 = new ModelRenderer(this, 0, 48);
		this.Jetpack5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Jetpack5.addBox(-4.0F, 3.0F, 1.5F, 8, 3, 3, 0.0F);
		this.Jetpack6 = new ModelRenderer(this, 0, 158);
		this.Jetpack6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Jetpack6.addBox(-2.0F, -5.0F, 3.2F, 4, 10, 3, 0.0F);
		this.Jetpack9 = new ModelRenderer(this, 0, 90);
		this.Jetpack9.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Jetpack9.addBox(-7.0F, 1.5F, 2.5F, 2, 4, 2, 0.0F);
		this.Jetpack10 = new ModelRenderer(this, 0, 100);
		this.Jetpack10.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Jetpack10.addBox(-0.5F, -14.0F, 4.5F, 1, 10, 1, 0.0F);
		this.Jetpack3 = new ModelRenderer(this, 0, 20);
		this.Jetpack3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Jetpack3.addBox(1.5F, -5.0F, 2.0F, 3, 10, 3, 0.0F);
		this.Jetpack7 = new ModelRenderer(this, 0, 60);
		this.Jetpack7.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Jetpack7.addBox(-3.0F, -4.0F, 2.8F, 6, 8, 3, 0.0F);
		this.Jetpack1 = new ModelRenderer(this, 0, 16);
		this.Jetpack1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Jetpack1.addBox(-7.5F, 2.0F, 3.0F, 15, 1, 1, 0.0F);
		this.JetpackMain.addChild(this.Jetpack11);
		this.JetpackMain.addChild(this.Jetpack2);
		this.JetpackMain.addChild(this.Jetpack8);
		this.JetpackMain.addChild(this.Jetpack4);
		this.JetpackMain.addChild(this.Jetpack5);
		this.JetpackMain.addChild(this.Jetpack6);
		this.JetpackMain.addChild(this.Jetpack9);
		this.JetpackMain.addChild(this.Jetpack10);
		this.JetpackMain.addChild(this.Jetpack3);
		this.JetpackMain.addChild(this.Jetpack7);
		this.JetpackMain.addChild(this.Jetpack1);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.JetpackMain.render(f5);

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
}
