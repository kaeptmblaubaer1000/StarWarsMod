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
 * ModelBiped - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ModelBackpackScout extends ModelBiped
{
	public ModelRenderer MainParent;
	public ModelRenderer shape9;
	public ModelRenderer shape9_1;

	public static ResourceLocation texture1 = new ResourceLocation(Resources.MODID, "textures/models/backpackScout.png");
	public static ResourceLocation texture2 = new ResourceLocation(Resources.MODID, "textures/models/scoutTrooperArmorLayer1.png");
	private static ModelCompressionArmor armorModel;

	public ModelBackpackScout(ItemArmor armor)
	{
		armorModel = new ModelCompressionArmor(0.4f, armor);
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.MainParent = new ModelRenderer(this, 0, 0);
		this.MainParent.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.MainParent.addBox(-1.0F, -4.5F, 1.7F, 2, 6, 2, 0.0F);
		this.shape9 = new ModelRenderer(this, 0, 0);
		this.shape9.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape9.addBox(-2.5F, -4.5F, 1.0F, 5, 5, 2, 0.0F);
		this.shape9_1 = new ModelRenderer(this, 0, 0);
		this.shape9_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape9_1.addBox(-2.5F, 2.5F, 1.5F, 5, 2, 2, 0.0F);
		this.MainParent.addChild(this.shape9);
		this.MainParent.addChild(this.shape9_1);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		StarWarsMod.mc.renderEngine.bindTexture(texture1);
		this.MainParent.rotationPointZ = entity.isSneaking() ? 3.4f : 0;
		this.MainParent.rotateAngleX = entity.isSneaking() ? 0.5f : 0;
		this.MainParent.render(f5);

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
