package com.parzivail.pswm.models.mobs;

import com.parzivail.pswm.mobs.MobTauntaun;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;

/**
 * Tauntaun Corrected - Weaston Created using Tabula 4.1.1
 */
public class ModelTaunNew extends ModelBase
{
	public ModelRenderer MainBodyParent;
	public ModelRenderer LegParentR;
	public ModelRenderer TailParent;
	public ModelRenderer Shape49;
	public ModelRenderer Shape52;
	public ModelRenderer Shape47;
	public ModelRenderer Shape52_1;
	public ModelRenderer Shape48;
	public ModelRenderer Shape18;
	public ModelRenderer Shape19;
	public ModelRenderer Shape20;
	public ModelRenderer ArmParentR;
	public ModelRenderer ArmParentL;
	public ModelRenderer Shape16;
	public ModelRenderer Shape1;
	public ModelRenderer Shape4;
	public ModelRenderer Shape3;
	public ModelRenderer Shape6;
	public ModelRenderer Shape2;
	public ModelRenderer shape42;
	public ModelRenderer shape42_1;
	public ModelRenderer shape42_2;
	public ModelRenderer shape42_3;
	public ModelRenderer shape42_4;
	public ModelRenderer shape42_5;
	public ModelRenderer shape48;
	public ModelRenderer shape48_1;
	public ModelRenderer LegParentL;
	public ModelRenderer Shape29;
	public ModelRenderer Shape32;
	public ModelRenderer Shape33;
	public ModelRenderer Shape26;
	public ModelRenderer Shape27;
	public ModelRenderer Shape45;
	public ModelRenderer Shape46;
	public ModelRenderer Shape31;
	public ModelRenderer Shape40;
	public ModelRenderer Shape41;
	public ModelRenderer Shape31_1;
	public ModelRenderer Shape40_1;
	public ModelRenderer Shape41_1;
	public ModelRenderer Shape29_1;
	public ModelRenderer Shape32_1;
	public ModelRenderer Shape33_1;

	public ModelTaunNew()
	{
		this.textureWidth = 512;
		this.textureHeight = 512;
		this.Shape47 = new ModelRenderer(this, 0, 218);
		this.Shape47.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Shape47.addBox(-7.0F, -6.0F, -6.0F, 12, 2, 12, 0.0F);
		this.Shape3 = new ModelRenderer(this, 96, 0);
		this.Shape3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Shape3.addBox(13.0F, -23.8F, -2.5F, 5, 3, 5, 0.0F);
		this.setRotateAngle(Shape3, 0.0F, -0.0F, 0.33161255787892263F);
		this.Shape20 = new ModelRenderer(this, 0, 332);
		this.Shape20.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Shape20.addBox(9.8F, -14.0F, -3.0F, 5, 4, 6, 0.0F);
		this.Shape52 = new ModelRenderer(this, 0, 196);
		this.Shape52.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Shape52.addBox(-7.0F, -6.5F, -6.5F, 1, 3, 13, 0.0F);
		this.Shape52_1 = new ModelRenderer(this, 0, 238);
		this.Shape52_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Shape52_1.addBox(4.0F, -6.5F, -6.5F, 1, 3, 13, 0.0F);
		this.shape42_3 = new ModelRenderer(this, 220, 0);
		this.shape42_3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape42_3.addBox(3.6F, -23.2F, 5.0F, 4, 4, 3, 0.0F);
		this.setRotateAngle(shape42_3, -0.12217304763960307F, 0.5235987755982988F, 0.20943951023931953F);
		this.Shape40 = new ModelRenderer(this, 0, 380);
		this.Shape40.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Shape40.addBox(0.16F, 7.09F, -1.5F, 2, 4, 2, 0.0F);
		this.setRotateAngle(Shape40, 0.0F, -0.0F, 0.22689280275926282F);
		this.Shape2 = new ModelRenderer(this, 134, 0);
		this.Shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Shape2.addBox(6.6F, -22.7F, -5.0F, 6, 5, 10, 0.0F);
		this.setRotateAngle(Shape2, 0.0F, -0.0F, 0.20943951023931953F);
		this.shape42_2 = new ModelRenderer(this, 202, 0);
		this.shape42_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape42_2.addBox(14.6F, -19.4F, -7.6F, 5, 2, 2, 0.0F);
		this.setRotateAngle(shape42_2, 0.08552113334772216F, 0.017453292519943295F, 0.10471975511965977F);
		this.Shape49 = new ModelRenderer(this, 0, 172);
		this.Shape49.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Shape49.addBox(-10.0F, -7.0F, -7.5F, 3, 3, 15, 0.0F);
		this.Shape4 = new ModelRenderer(this, 70, 0);
		this.Shape4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Shape4.addBox(11.4F, -25.0F, -3.5F, 3, 6, 7, 0.0F);
		this.setRotateAngle(Shape4, 0.0F, -0.0F, 0.3141592653589793F);
		this.shape48 = new ModelRenderer(this, 282, 0);
		this.shape48.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape48.addBox(12.0F, -25.5F, -3.0F, 1, 6, 2, 0.0F);
		this.Shape18 = new ModelRenderer(this, 0, 290);
		this.Shape18.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Shape18.addBox(4.5F, -11.5F, -4.5F, 8, 11, 9, 0.0F);
		this.setRotateAngle(Shape18, 0.0F, -0.0F, 0.3141592653589793F);
		this.Shape29 = new ModelRenderer(this, 0, 45);
		this.Shape29.setRotationPoint(0.0F, 4.5F, 0.0F);
		this.Shape29.addBox(-3.0F, -1.5F, -2.0F, 4, 7, 3, 0.0F);
		this.setRotateAngle(Shape29, 0.0F, -0.0F, 0.6981317007977318F);
		this.Shape46 = new ModelRenderer(this, 0, 160);
		this.Shape46.setRotationPoint(-4.0F, 0.0F, 0.0F);
		this.Shape46.addBox(-4.5F, -0.95F, -1.0F, 5, 2, 2, 0.0F);
		this.setRotateAngle(Shape46, 0.0F, -0.0F, 0.15707963267948966F);
		this.LegParentR = new ModelRenderer(this, 0, 26);
		this.LegParentR.setRotationPoint(-5.5F, 1.0F, -5.5F);
		this.LegParentR.addBox(-3.0F, -4.3F, -2.5F, 6, 9, 4, 0.0F);
		this.setRotateAngle(LegParentR, 0.0F, -0.0F, -0.17453292519943295F);
		this.shape42 = new ModelRenderer(this, 162, 0);
		this.shape42.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape42.addBox(3.6F, -23.2F, -8.1F, 4, 4, 3, 0.0F);
		this.setRotateAngle(shape42, 0.12217304763960307F, -0.5235987755982988F, 0.20943951023931953F);
		this.Shape31_1 = new ModelRenderer(this, 0, 0);
		this.Shape31_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Shape31_1.addBox(-1.5F, 2.4F, -1.5F, 2, 5, 2, 0.0F);
		this.setRotateAngle(Shape31_1, 0.0F, -0.0F, -0.593411945678072F);
		this.ArmParentR = new ModelRenderer(this, 0, 350);
		this.ArmParentR.setRotationPoint(10.5F, -4.0F, -5.0F);
		this.ArmParentR.addBox(-2.0F, -2.0F, -1.5F, 4, 6, 2, 0.0F);
		this.setRotateAngle(ArmParentR, 0.0F, -0.0F, 0.20943951023931953F);
		this.Shape6 = new ModelRenderer(this, 122, 0);
		this.Shape6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Shape6.addBox(13.5F, -21.9F, -2.0F, 3, 2, 4, 0.0F);
		this.setRotateAngle(Shape6, 0.0F, -0.0F, 0.3490658503988659F);
		this.Shape33 = new ModelRenderer(this, 0, 82);
		this.Shape33.setRotationPoint(-0.5F, 12.0F, 0.0F);
		this.Shape33.addBox(-2.3F, -1.0F, -2.5F, 5, 2, 4, 0.0F);
		this.setRotateAngle(Shape33, 0.0F, 0.0F, 0.3839724354387525F);
		this.Shape41_1 = new ModelRenderer(this, 0, 0);
		this.Shape41_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Shape41_1.addBox(9.34F, -6.32F, -1.5F, 3, 2, 2, 0.0F);
		this.setRotateAngle(Shape41_1, 0.0F, -0.0F, 1.9722220547535922F);
		this.Shape32_1 = new ModelRenderer(this, 0, 0);
		this.Shape32_1.setRotationPoint(-1.0F, 5.0F, 0.0F);
		this.Shape32_1.addBox(-2.7F, -0.9F, -2.0F, 4, 13, 3, 0.0F);
		this.setRotateAngle(Shape32_1, 0.0F, -0.0F, -0.6981317007977318F);
		this.Shape26 = new ModelRenderer(this, 0, 116);
		this.Shape26.setRotationPoint(-4.5F, 0.0F, 0.0F);
		this.Shape26.addBox(-9.0F, -3.05F, -3.0F, 11, 6, 6, 0.0F);
		this.setRotateAngle(Shape26, 0.0F, -0.0F, -0.4886921905584123F);
		this.Shape1 = new ModelRenderer(this, 0, 440);
		this.Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Shape1.addBox(6.1F, -25.0F, -4.0F, 8, 8, 8, 0.0F);
		this.setRotateAngle(Shape1, 0.0F, -0.0F, 0.20943951023931953F);
		this.Shape41 = new ModelRenderer(this, 0, 394);
		this.Shape41.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Shape41.addBox(9.34F, -6.32F, -1.5F, 3, 2, 2, 0.0F);
		this.setRotateAngle(Shape41, 0.0F, -0.0F, 1.9722220547535922F);
		this.Shape33_1 = new ModelRenderer(this, 0, 0);
		this.Shape33_1.setRotationPoint(-0.5F, 12.0F, 0.0F);
		this.Shape33_1.addBox(-2.3F, -1.0F, -2.5F, 5, 2, 4, 0.0F);
		this.setRotateAngle(Shape33_1, 0.0F, 0.0F, 0.3839724354387525F);
		this.shape42_1 = new ModelRenderer(this, 180, 0);
		this.shape42_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape42_1.addBox(0.0F, -23.2F, -12.2F, 3, 3, 5, 0.0F);
		this.setRotateAngle(shape42_1, 0.3131120678077827F, -1.006182313774731F, 0.05235987755982988F);
		this.Shape40_1 = new ModelRenderer(this, 0, 0);
		this.Shape40_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Shape40_1.addBox(0.16F, 7.09F, -1.5F, 2, 4, 2, 0.0F);
		this.setRotateAngle(Shape40_1, 0.0F, -0.0F, 0.22689280275926282F);
		this.Shape48 = new ModelRenderer(this, 0, 260);
		this.Shape48.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Shape48.addBox(0.0F, -4.0F, -6.0F, 1, 10, 12, 0.0F);
		this.shape48_1 = new ModelRenderer(this, 292, 0);
		this.shape48_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape48_1.addBox(12.0F, -25.5F, 1.0F, 1, 6, 2, 0.0F);
		this.shape42_4 = new ModelRenderer(this, 241, 0);
		this.shape42_4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape42_4.addBox(0.1F, -23.2F, 7.1F, 3, 3, 5, 0.0F);
		this.setRotateAngle(shape42_4, -0.3131120678077827F, 1.006182313774731F, 0.05235987755982988F);
		this.shape42_5 = new ModelRenderer(this, 262, 0);
		this.shape42_5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape42_5.addBox(14.6F, -19.4F, 5.5F, 5, 2, 2, 0.0F);
		this.setRotateAngle(shape42_5, -0.08552113334772216F, -0.017453292519943295F, 0.10471975511965977F);
		this.Shape16 = new ModelRenderer(this, 0, 422);
		this.Shape16.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Shape16.addBox(6.4F, -17.0F, -4.0F, 6, 2, 8, 0.0F);
		this.setRotateAngle(Shape16, 0.0F, -0.0F, 0.20943951023931953F);
		this.Shape31 = new ModelRenderer(this, 0, 366);
		this.Shape31.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Shape31.addBox(-1.5F, 2.4F, -1.5F, 2, 5, 2, 0.0F);
		this.setRotateAngle(Shape31, 0.0F, -0.0F, -0.593411945678072F);
		this.Shape32 = new ModelRenderer(this, 0, 60);
		this.Shape32.setRotationPoint(-1.0F, 5.0F, 0.0F);
		this.Shape32.addBox(-2.7F, -0.9F, -2.0F, 4, 13, 3, 0.0F);
		this.setRotateAngle(Shape32, 0.0F, -0.0F, -0.6981317007977318F);
		this.LegParentL = new ModelRenderer(this, 305, 0);
		this.LegParentL.setRotationPoint(-5.5F, 1.0F, 6.5F);
		this.LegParentL.addBox(-3.0F, -4.3F, -2.5F, 6, 9, 4, 0.0F);
		this.setRotateAngle(LegParentL, 0.0F, -0.0F, -0.17453292519943295F);
		this.TailParent = new ModelRenderer(this, 0, 94);
		this.TailParent.setRotationPoint(-11.0F, 0.0F, 0.0F);
		this.TailParent.addBox(-4.5F, -4.0F, -4.0F, 6, 8, 8, 0.0F);
		this.setRotateAngle(TailParent, 0.0F, -0.0F, -0.20943951023931953F);
		this.Shape29_1 = new ModelRenderer(this, 0, 0);
		this.Shape29_1.setRotationPoint(0.0F, 4.5F, 0.0F);
		this.Shape29_1.addBox(-3.0F, -1.5F, -2.0F, 4, 7, 3, 0.0F);
		this.setRotateAngle(Shape29_1, 0.0F, -0.0F, 0.6981317007977318F);
		this.ArmParentL = new ModelRenderer(this, 0, 406);
		this.ArmParentL.setRotationPoint(10.5F, -4.0F, 6.0F);
		this.ArmParentL.addBox(-2.0F, -2.0F, -1.5F, 4, 6, 2, 0.0F);
		this.setRotateAngle(ArmParentL, 0.0F, -0.0F, 0.20943951023931953F);
		this.Shape45 = new ModelRenderer(this, 0, 148);
		this.Shape45.setRotationPoint(-7.0F, 0.0F, 0.0F);
		this.Shape45.addBox(-4.2F, -1.5F, -1.5F, 5, 3, 3, 0.0F);
		this.setRotateAngle(Shape45, 0.0F, -0.0F, 0.2617993877991494F);
		this.MainBodyParent = new ModelRenderer(this, 0, 0);
		this.MainBodyParent.setRotationPoint(1.0F, 1.0F, 0.0F);
		this.MainBodyParent.addBox(-11.0F, -5.5F, -5.5F, 22, 11, 11, 0.0F);
		this.setRotateAngle(MainBodyParent, 0.0F, 0.0F, -0.20943951023931953F);
		this.Shape27 = new ModelRenderer(this, 0, 134);
		this.Shape27.setRotationPoint(-9.0F, 0.0F, 0.0F);
		this.Shape27.addBox(-6.8F, -2.0F, -2.5F, 8, 4, 5, 0.0F);
		this.setRotateAngle(Shape27, 0.0F, -0.0F, 0.40142572795869574F);
		this.Shape19 = new ModelRenderer(this, 0, 316);
		this.Shape19.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Shape19.addBox(6.0F, -14.0F, -3.5F, 7, 4, 7, 0.0F);
		this.setRotateAngle(Shape19, 0.0F, -0.0F, 0.20943951023931953F);
		this.MainBodyParent.addChild(this.Shape47);
		this.MainBodyParent.addChild(this.Shape3);
		this.MainBodyParent.addChild(this.Shape20);
		this.MainBodyParent.addChild(this.Shape52);
		this.MainBodyParent.addChild(this.Shape52_1);
		this.MainBodyParent.addChild(this.shape42_3);
		this.Shape31.addChild(this.Shape40);
		this.MainBodyParent.addChild(this.Shape2);
		this.MainBodyParent.addChild(this.shape42_2);
		this.MainBodyParent.addChild(this.Shape49);
		this.MainBodyParent.addChild(this.Shape4);
		this.MainBodyParent.addChild(this.shape48);
		this.MainBodyParent.addChild(this.Shape18);
		this.LegParentR.addChild(this.Shape29);
		this.Shape45.addChild(this.Shape46);
		this.MainBodyParent.addChild(this.LegParentR);
		this.MainBodyParent.addChild(this.shape42);
		this.ArmParentL.addChild(this.Shape31_1);
		this.MainBodyParent.addChild(this.ArmParentR);
		this.MainBodyParent.addChild(this.Shape6);
		this.Shape32.addChild(this.Shape33);
		this.Shape40_1.addChild(this.Shape41_1);
		this.Shape29_1.addChild(this.Shape32_1);
		this.TailParent.addChild(this.Shape26);
		this.MainBodyParent.addChild(this.Shape1);
		this.Shape40.addChild(this.Shape41);
		this.Shape32_1.addChild(this.Shape33_1);
		this.MainBodyParent.addChild(this.shape42_1);
		this.Shape31_1.addChild(this.Shape40_1);
		this.MainBodyParent.addChild(this.Shape48);
		this.MainBodyParent.addChild(this.shape48_1);
		this.MainBodyParent.addChild(this.shape42_4);
		this.MainBodyParent.addChild(this.shape42_5);
		this.MainBodyParent.addChild(this.Shape16);
		this.ArmParentR.addChild(this.Shape31);
		this.Shape29.addChild(this.Shape32);
		this.MainBodyParent.addChild(this.LegParentL);
		this.MainBodyParent.addChild(this.TailParent);
		this.LegParentL.addChild(this.Shape29_1);
		this.MainBodyParent.addChild(this.ArmParentL);
		this.Shape27.addChild(this.Shape45);
		this.Shape26.addChild(this.Shape27);
		this.MainBodyParent.addChild(this.Shape19);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		if (entity instanceof MobTauntaun)
		{
			MobTauntaun tauntaun = (MobTauntaun)entity;
			boolean hasSaddle = tauntaun.isHorseSaddled();
			this.Shape48.isHidden = !hasSaddle;
			this.Shape49.isHidden = !hasSaddle;
			this.Shape47.isHidden = !hasSaddle;
			this.Shape52.isHidden = !hasSaddle;
			this.Shape52_1.isHidden = !hasSaddle;

			float animMult = 3.8f;
			float m;

			if (tauntaun.getControllingPassenger() instanceof EntityLivingBase)
			{
				EntityLivingBase elb = (EntityLivingBase)tauntaun.getControllingPassenger();
				m = elb.moveForward;
				this.LegParentL.rotateAngleZ = -0.17453292519943295F + MathHelper.sin((float)((tauntaun.ticksExisted * m) / animMult + Math.PI)) / 5f;
				this.LegParentR.rotateAngleZ = -0.17453292519943295F + MathHelper.sin((tauntaun.ticksExisted * m) / animMult) / 5f;

				this.Shape29_1.rotateAngleZ = 0.6981317007977318F + MathHelper.sin((float)((tauntaun.ticksExisted * m) / animMult + Math.PI + 1)) / 5f;
				this.Shape29.rotateAngleZ = 0.6981317007977318F + MathHelper.sin((tauntaun.ticksExisted * m) / animMult + 1) / 5f;

				this.Shape32_1.rotateAngleZ = -0.6981317007977318F + MathHelper.sin((float)((tauntaun.ticksExisted * m) / animMult + Math.PI + 1)) / 5f;
				this.Shape32.rotateAngleZ = -0.6981317007977318F + MathHelper.sin((tauntaun.ticksExisted * m) / animMult) / 5f;

				this.Shape33_1.rotateAngleZ = 0.3839724354387525F + MathHelper.sin((tauntaun.ticksExisted * m) / animMult) / 5f;
				this.Shape33.rotateAngleZ = 0.3839724354387525F + MathHelper.sin((float)((tauntaun.ticksExisted * m) / animMult + Math.PI + 1)) / 5f;
			}
			else
			{
				m = tauntaun.getPosition().distanceSq(tauntaun.getPosition()) > 0 ? 1 : 0;
				this.LegParentL.rotateAngleZ = -0.17453292519943295F + MathHelper.sin((float)((tauntaun.ticksExisted * m) / animMult + Math.PI)) / 5f;
				this.LegParentR.rotateAngleZ = -0.17453292519943295F + MathHelper.sin((tauntaun.ticksExisted * m) / animMult) / 5f;

				this.Shape29_1.rotateAngleZ = 0.6981317007977318F + MathHelper.sin((float)((tauntaun.ticksExisted * m) / animMult + Math.PI + 1)) / 5f;
				this.Shape29.rotateAngleZ = 0.6981317007977318F + MathHelper.sin((tauntaun.ticksExisted * m) / animMult + 1) / 5f;

				this.Shape32_1.rotateAngleZ = -0.6981317007977318F + MathHelper.sin((float)((tauntaun.ticksExisted * m) / animMult + Math.PI + 1)) / 5f;
				this.Shape32.rotateAngleZ = -0.6981317007977318F + MathHelper.sin((tauntaun.ticksExisted * m) / animMult) / 5f;

				this.Shape33_1.rotateAngleZ = 0.3839724354387525F + MathHelper.sin((tauntaun.ticksExisted * m) / animMult) / 5f;
				this.Shape33.rotateAngleZ = 0.3839724354387525F + MathHelper.sin((float)((tauntaun.ticksExisted * m) / animMult + Math.PI + 1)) / 5f;
			}

			this.TailParent.rotateAngleY = MathHelper.sin(tauntaun.ticksExisted / 10f) * 0.05f;
			this.Shape26.rotateAngleY = MathHelper.sin(tauntaun.ticksExisted / 10f) * 0.05f;
			this.Shape27.rotateAngleY = MathHelper.sin(tauntaun.ticksExisted / 10f) * 0.05f;
			this.Shape45.rotateAngleY = MathHelper.sin(tauntaun.ticksExisted / 10f) * 0.05f;
			this.Shape46.rotateAngleY = MathHelper.sin(tauntaun.ticksExisted / 10f) * 0.05f;

			this.ArmParentL.rotateAngleY = MathHelper.sin(tauntaun.ticksExisted / 15f) * 0.06f;
			this.ArmParentL.rotateAngleX = MathHelper.sin(tauntaun.ticksExisted / 15f) * 0.04f;
			this.ArmParentR.rotateAngleY = -MathHelper.sin(tauntaun.ticksExisted / 15f) * 0.06f;
			this.ArmParentR.rotateAngleX = -MathHelper.sin(tauntaun.ticksExisted / 15f) * 0.04f;

			float yT = MathHelper.sin((tauntaun.ticksExisted * m) / (animMult / 2f)) * 0.02f;

			GL11.glTranslatef(0, yT, 0);

			this.MainBodyParent.render(f5);
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
}
