package com.parzivail.pswm.rendering;

import com.parzivail.pswm.items.weapons.ItemBlasterHeavy;
import com.parzivail.pswm.items.weapons.ItemBlasterPistol;
import com.parzivail.pswm.items.weapons.ItemBlasterRifle;
import com.parzivail.pswm.items.weapons.ItemWookieeBowcaster;
import com.parzivail.pswm.models.armor.ModelCompressionArmor;
import com.parzivail.pswm.vehicles.VehicScootemaround;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

/**
 * @author Colby
 */
public class ArmorRenderHelper
{
	public static void renderModel(ModelCompressionArmor modelCompressionArmor, EntityPlayer p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
	{
		modelCompressionArmor.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);

		adjustEP(modelCompressionArmor, p_78088_1_, p_78088_1_.getEquipmentInSlot(0), p_78088_7_);

		if (modelCompressionArmor.isChild)
		{
			float f6 = 2.0F;
			GL11.glPushMatrix();
			GL11.glScalef(1.5F / f6, 1.5F / f6, 1.5F / f6);
			GL11.glTranslatef(0.0F, 16.0F * p_78088_7_, 0.0F);
			modelCompressionArmor._model.bipedHead.render(p_78088_7_);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
			GL11.glTranslatef(0.0F, 24.0F * p_78088_7_, 0.0F);
			modelCompressionArmor._model.bipedBody.render(p_78088_7_);
			modelCompressionArmor._model.bipedRightArm.render(p_78088_7_);
			modelCompressionArmor._model.bipedLeftArm.render(p_78088_7_);
			modelCompressionArmor._model.bipedRightLeg.render(p_78088_7_);
			modelCompressionArmor._model.bipedLeftLeg.render(p_78088_7_);
			modelCompressionArmor._model.bipedHeadwear.render(p_78088_7_);
			GL11.glPopMatrix();
		}
		else
		{
			modelCompressionArmor._model.bipedHead.render(p_78088_7_);
			modelCompressionArmor._model.bipedBody.render(p_78088_7_);
			modelCompressionArmor._model.bipedRightArm.render(p_78088_7_);
			modelCompressionArmor._model.bipedLeftArm.render(p_78088_7_);
			modelCompressionArmor._model.bipedRightLeg.render(p_78088_7_);
			modelCompressionArmor._model.bipedLeftLeg.render(p_78088_7_);
			modelCompressionArmor._model.bipedHeadwear.render(p_78088_7_);
		}
	}

	public static void adjustEP(ModelCompressionArmor modelCompressionArmor, EntityPlayer entity, ItemStack stack, float p)
	{
		modelCompressionArmor._model.heldItemRight = stack != null ? 1 : 0;
		modelCompressionArmor._model.isSneak = entity.isSneaking();
		modelCompressionArmor._model.bipedHead.showModel = entity.inventory.armorInventory[3] != null && entity.inventory.armorInventory[3].getItem() == modelCompressionArmor.armor;
		modelCompressionArmor._model.bipedHeadwear.showModel = entity.inventory.armorInventory[3] != null && entity.inventory.armorInventory[3].getItem() == modelCompressionArmor.armor;
		modelCompressionArmor._model.bipedBody.showModel = entity.inventory.armorInventory[2] != null && entity.inventory.armorInventory[2].getItem() == modelCompressionArmor.armor;
		modelCompressionArmor._model.bipedRightArm.showModel = entity.inventory.armorInventory[2] != null && entity.inventory.armorInventory[2].getItem() == modelCompressionArmor.armor;
		modelCompressionArmor._model.bipedLeftArm.showModel = entity.inventory.armorInventory[2] != null && entity.inventory.armorInventory[2].getItem() == modelCompressionArmor.armor;
		modelCompressionArmor._model.bipedRightLeg.showModel = (entity.inventory.armorInventory[1] != null && entity.inventory.armorInventory[1].getItem() == modelCompressionArmor.armor) || (entity.inventory.armorInventory[0] != null && entity.inventory.armorInventory[0].getItem() == modelCompressionArmor.armor);
		modelCompressionArmor._model.bipedLeftLeg.showModel = (entity.inventory.armorInventory[1] != null && entity.inventory.armorInventory[1].getItem() == modelCompressionArmor.armor) || (entity.inventory.armorInventory[0] != null && entity.inventory.armorInventory[0].getItem() == modelCompressionArmor.armor);
		modelCompressionArmor._model.isRiding = entity.isRiding();
		modelCompressionArmor._model.isChild = entity.isChild();
		modelCompressionArmor._model.onGround = entity.getSwingProgress(p);

		if (stack != null && entity.getItemInUseCount() > 0)
		{
			EnumAction enumaction = stack.getItemUseAction();

			if (enumaction == EnumAction.block)
				modelCompressionArmor._model.heldItemRight = 3;
			else if (enumaction == EnumAction.bow)
				modelCompressionArmor._model.aimedBow = true;
		}

		if (entity.getHeldItem() != null)
		{
			Item i = entity.getHeldItem().getItem();

			if (i instanceof ItemBlasterRifle || i instanceof ItemBlasterHeavy || i instanceof ItemWookieeBowcaster)
			{
				modelCompressionArmor._model.bipedRightArm.rotateAngleX = -1.5F;
				modelCompressionArmor._model.bipedRightArm.rotateAngleY = -0.1F;

				modelCompressionArmor._model.bipedLeftArm.rotateAngleX = -1.5F;
				modelCompressionArmor._model.bipedLeftArm.rotateAngleY = 1F;
			}
			else if (i instanceof ItemBlasterPistol)
			{
				modelCompressionArmor._model.bipedRightArm.rotateAngleX = -1.5F;
				modelCompressionArmor._model.bipedRightArm.rotateAngleY = -0.1F;
			}
		}

		if (modelCompressionArmor.isRiding && !(entity.ridingEntity instanceof VehicScootemaround))
		{
			modelCompressionArmor._model.bipedRightArm.rotateAngleX += -((float)Math.PI / 5F);
			modelCompressionArmor._model.bipedLeftArm.rotateAngleX += -((float)Math.PI / 5F);
			modelCompressionArmor._model.bipedRightLeg.rotateAngleX = -((float)Math.PI * 2F / 5F);
			modelCompressionArmor._model.bipedLeftLeg.rotateAngleX = -((float)Math.PI * 2F / 5F);
			modelCompressionArmor._model.bipedRightLeg.rotateAngleY = ((float)Math.PI / 10F);
			modelCompressionArmor._model.bipedLeftLeg.rotateAngleY = -((float)Math.PI / 10F);
		}

	}
}
