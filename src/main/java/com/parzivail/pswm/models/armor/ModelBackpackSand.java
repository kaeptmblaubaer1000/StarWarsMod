package com.parzivail.pswm.models.armor;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.rendering.ArmorRenderHelper;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import static com.parzivail.pswm.StarWarsMod.mc;

/**
 * ModelBackpackSand - weaston
 * Created using Tabula 4.1.1
 */
public class ModelBackpackSand extends ModelBiped
{
	public ModelRenderer BackpackParent;
	public ModelRenderer ShoulderPadParent;
	public ModelRenderer shape1;
	public ModelRenderer shape2;
	public ModelRenderer shape3;
	public ModelRenderer shape4;
	public ModelRenderer shape5;
	public ModelRenderer shape6;
	public ModelRenderer shape7;
	public ModelRenderer shape8;
	public ModelRenderer shape9;
	public ModelRenderer shape10;
	public ModelRenderer shape11;
	public ModelRenderer shape12;
	public ModelRenderer shape13;
	public ModelRenderer shape14;
	public ModelRenderer shape15;
	public ModelRenderer shape16;
	public ModelRenderer shape17;
	public ModelRenderer shape18;
	public ModelRenderer shape19;

	public static ResourceLocation texture1 = new ResourceLocation(Resources.MODID, "textures/models/backpackSand.png");
	public static ResourceLocation texture2 = new ResourceLocation(Resources.MODID, "textures/models/sandtrooperArmorLayer1.png");
	private static ModelCompressionArmor armorModel;

	public ModelBackpackSand(ItemArmor armor)
	{
		armorModel = new ModelCompressionArmor(0.4f, armor);
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.shape13 = new ModelRenderer(this, 14, 20);
		this.shape13.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape13.addBox(2.5F, 1.5F, 4.0F, 1, 4, 2, 0.0F);
		this.shape5 = new ModelRenderer(this, 53, 0);
		this.shape5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape5.addBox(-5.5F, -5.0F, 3.5F, 2, 12, 2, 0.0F);
		this.shape4 = new ModelRenderer(this, 40, 0);
		this.shape4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape4.addBox(-0.5F, -1.0F, 3.7F, 4, 2, 2, 0.0F);
		this.shape3 = new ModelRenderer(this, 23, 0);
		this.shape3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape3.addBox(-2.5F, 1.5F, 4.0F, 6, 1, 2, 0.0F);
		this.shape14 = new ModelRenderer(this, 19, 26);
		this.shape14.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape14.addBox(-2.5F, 1.5F, 3.4F, 6, 4, 2, 0.0F);
		this.shape17 = new ModelRenderer(this, 23, 13);
		this.shape17.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape17.addBox(0.0F, -0.5F, 5.0F, 1, 1, 1, 0.0F);
		this.shape1 = new ModelRenderer(this, 0, 16);
		this.shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape1.addBox(-3.5F, -5.5F, 4.3F, 3, 4, 2, 0.0F);
		this.shape10 = new ModelRenderer(this, 46, 5);
		this.shape10.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape10.addBox(-2.5F, -7.0F, 5.2F, 1, 3, 1, 0.0F);
		this.shape8 = new ModelRenderer(this, 41, 5);
		this.shape8.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape8.addBox(2.0F, -7.0F, 5.2F, 1, 4, 1, 0.0F);
		this.shape7 = new ModelRenderer(this, 32, 4);
		this.shape7.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape7.addBox(-3.0F, -1.0F, 3.5F, 2, 2, 2, 0.0F);
		this.shape16 = new ModelRenderer(this, 36, 10);
		this.shape16.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape16.addBox(2.0F, -0.5F, 5.0F, 1, 1, 1, 0.0F);
		this.shape18 = new ModelRenderer(this, 40, 12);
		this.shape18.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape18.addBox(-3.5F, -2.3F, -2.8F, 5, 3, 1, 0.0F);
		this.shape2 = new ModelRenderer(this, 0, 23);
		this.shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape2.addBox(0.0F, -5.0F, 3.5F, 1, 3, 2, 0.0F);
		this.shape11 = new ModelRenderer(this, 11, 16);
		this.shape11.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape11.addBox(-2.5F, 4.5F, 4.0F, 6, 1, 2, 0.0F);
		this.shape19 = new ModelRenderer(this, 44, 17);
		this.shape19.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape19.addBox(-3.5F, -2.3F, 1.8F, 5, 3, 1, 0.0F);
		this.ShoulderPadParent = new ModelRenderer(this, 23, 16);
		this.ShoulderPadParent.setRotationPoint(-5.0F, 2.0F, 0.0F);
		this.ShoulderPadParent.addBox(-3.5F, -2.3F, -2.5F, 5, 1, 5, 0.0F);
		this.shape12 = new ModelRenderer(this, 7, 23);
		this.shape12.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape12.addBox(-2.5F, 1.5F, 4.0F, 1, 4, 2, 0.0F);
		this.shape9 = new ModelRenderer(this, 23, 10);
		this.shape9.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape9.addBox(-2.5F, -7.0F, 5.2F, 5, 1, 1, 0.0F);
		this.shape15 = new ModelRenderer(this, 36, 27);
		this.shape15.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape15.addBox(-3.0F, -5.0F, 4.7F, 2, 3, 2, 0.0F);
		this.BackpackParent = new ModelRenderer(this, 0, 0);
		this.BackpackParent.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.BackpackParent.addBox(-4.0F, -6.0F, 2.0F, 8, 12, 3, 0.0F);
		this.shape6 = new ModelRenderer(this, 23, 4);
		this.shape6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape6.addBox(1.5F, -5.0F, 3.5F, 2, 3, 2, 0.0F);
		this.BackpackParent.addChild(this.shape13);
		this.BackpackParent.addChild(this.shape5);
		this.BackpackParent.addChild(this.shape4);
		this.BackpackParent.addChild(this.shape3);
		this.BackpackParent.addChild(this.shape14);
		this.BackpackParent.addChild(this.shape17);
		this.BackpackParent.addChild(this.shape1);
		this.BackpackParent.addChild(this.shape10);
		this.BackpackParent.addChild(this.shape8);
		this.BackpackParent.addChild(this.shape7);
		this.BackpackParent.addChild(this.shape16);
		this.ShoulderPadParent.addChild(this.shape18);
		this.BackpackParent.addChild(this.shape2);
		this.BackpackParent.addChild(this.shape11);
		this.ShoulderPadParent.addChild(this.shape19);
		this.BackpackParent.addChild(this.shape12);
		this.BackpackParent.addChild(this.shape9);
		this.BackpackParent.addChild(this.shape15);
		this.BackpackParent.addChild(this.shape6);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		StarWarsMod.mc.renderEngine.bindTexture(texture1);
		this.ShoulderPadParent.render(f5);
		this.BackpackParent.rotationPointZ = entity.isSneaking() ? 2.8f : 0;
		this.BackpackParent.rotateAngleX = entity.isSneaking() ? 0.5f : 0;
		this.BackpackParent.render(f5);

		if (entity instanceof EntityLivingBase)
		{
			EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
			mc.renderEngine.bindTexture(texture2);
			this.doRotationStuff(entityLivingBase, entityLivingBase.getHeldItem());
			armorModel.onGround = entityLivingBase.getSwingProgress(f5);
			if (entity instanceof EntityPlayer)
				ArmorRenderHelper.renderModel(armorModel, (EntityPlayer)entity, f, f1, f2, f3, f4, f5);
			else
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
