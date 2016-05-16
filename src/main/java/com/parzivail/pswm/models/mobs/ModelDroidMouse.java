package com.parzivail.pswm.models.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDroidMouse extends ModelBase
{
	ModelRenderer Main_Section;
	ModelRenderer Bottom;
	ModelRenderer Wheel1;
	ModelRenderer BottomF;
	ModelRenderer BottomB;
	ModelRenderer BottomM;
	ModelRenderer Wheel2;
	ModelRenderer Wheel3;
	ModelRenderer Wheel4;
	ModelRenderer Front;
	ModelRenderer Back;
	ModelRenderer Body1;
	ModelRenderer Body2;
	ModelRenderer Body3;
	ModelRenderer Body4;
	ModelRenderer Body5;
	ModelRenderer Body6;
	ModelRenderer Body7;
	ModelRenderer LittleSpikeyThing1;
	ModelRenderer LittleSpikeyThing2;

	public ModelDroidMouse()
	{
		this.textureWidth = 256;
		this.textureHeight = 256;
		this.Main_Section = new ModelRenderer(this, 0, 0);
		this.Main_Section.addBox(0.0F, 0.0F, 0.0F, 12, 1, 16);
		this.Main_Section.setRotationPoint(-6.0F, 20.5F, -8.0F);
		this.Main_Section.setTextureSize(256, 256);
		this.Main_Section.mirror = true;
		this.setRotation(this.Main_Section, 0.0F, 0.0F, 0.0F);
		this.Bottom = new ModelRenderer(this, 0, 41);
		this.Bottom.addBox(0.0F, 0.0F, 0.0F, 8, 2, 14);
		this.Bottom.setRotationPoint(-4.0F, 21.5F, -7.0F);
		this.Bottom.setTextureSize(256, 256);
		this.Bottom.mirror = true;
		this.setRotation(this.Bottom, 0.0F, 0.0F, 0.0F);
		this.Wheel1 = new ModelRenderer(this, 35, 18);
		this.Wheel1.addBox(0.0F, -1.0F, -1.0F, 2, 2, 2);
		this.Wheel1.setRotationPoint(3.5F, 22.8F, -4.7F);
		this.Wheel1.setTextureSize(256, 256);
		this.Wheel1.mirror = true;
		this.setRotation(this.Wheel1, 0.0F, 0.0F, 0.0F);
		this.BottomF = new ModelRenderer(this, 0, 35);
		this.BottomF.addBox(0.0F, 0.0F, 0.0F, 10, 2, 1);
		this.BottomF.setRotationPoint(-5.0F, 21.5F, -7.0F);
		this.BottomF.setTextureSize(256, 256);
		this.BottomF.mirror = true;
		this.setRotation(this.BottomF, 0.0F, 0.0F, 0.0F);
		this.BottomB = new ModelRenderer(this, 0, 30);
		this.BottomB.addBox(0.0F, 0.0F, 0.0F, 10, 2, 1);
		this.BottomB.setRotationPoint(-5.0F, 21.5F, 6.0F);
		this.BottomB.setTextureSize(256, 256);
		this.BottomB.mirror = true;
		this.setRotation(this.BottomB, 0.0F, 0.0F, 0.0F);
		this.BottomM = new ModelRenderer(this, 0, 18);
		this.BottomM.addBox(0.0F, 0.0F, 0.0F, 10, 2, 7);
		this.BottomM.setRotationPoint(-5.0F, 21.5F, -3.5F);
		this.BottomM.setTextureSize(256, 256);
		this.BottomM.mirror = true;
		this.setRotation(this.BottomM, 0.0F, 0.0F, 0.0F);
		this.Wheel2 = new ModelRenderer(this, 45, 18);
		this.Wheel2.addBox(0.0F, -1.0F, -1.0F, 2, 2, 2);
		this.Wheel2.setRotationPoint(3.5F, 22.8F, 4.7F);
		this.Wheel2.setTextureSize(256, 256);
		this.Wheel2.mirror = true;
		this.setRotation(this.Wheel2, 0.0F, 0.0F, 0.0F);
		this.Wheel3 = new ModelRenderer(this, 24, 30);
		this.Wheel3.addBox(-2.0F, -1.0F, -1.0F, 2, 2, 2);
		this.Wheel3.setRotationPoint(-3.5F, 22.8F, 4.7F);
		this.Wheel3.setTextureSize(256, 256);
		this.Wheel3.mirror = true;
		this.setRotation(this.Wheel3, 0.0F, 0.0F, 0.0F);
		this.Wheel4 = new ModelRenderer(this, 34, 30);
		this.Wheel4.addBox(-2.0F, -1.0F, -1.0F, 2, 2, 2);
		this.Wheel4.setRotationPoint(-3.5F, 22.8F, -4.7F);
		this.Wheel4.setTextureSize(256, 256);
		this.Wheel4.mirror = true;
		this.setRotation(this.Wheel4, 0.0F, 0.0F, 0.0F);
		this.Front = new ModelRenderer(this, 0, 59);
		this.Front.addBox(0.0F, 0.0F, 0.0F, 10, 7, 1);
		this.Front.setRotationPoint(-5.0F, 14.0F, -5.0F);
		this.Front.setTextureSize(256, 256);
		this.Front.mirror = true;
		this.setRotation(this.Front, -0.3490659F, 0.0F, 0.0F);
		this.Back = new ModelRenderer(this, 0, 69);
		this.Back.addBox(0.0F, 0.0F, 0.0F, 10, 7, 1);
		this.Back.setRotationPoint(-5.0F, 14.3F, 4.0F);
		this.Back.setTextureSize(256, 256);
		this.Back.mirror = true;
		this.setRotation(this.Back, 0.3490659F, 0.0F, 0.0F);
		this.Body1 = new ModelRenderer(this, 0, 79);
		this.Body1.addBox(0.0F, 0.0F, 0.0F, 10, 1, 14);
		this.Body1.setRotationPoint(-5.0F, 20.0F, -7.0F);
		this.Body1.setTextureSize(256, 256);
		this.Body1.mirror = true;
		this.setRotation(this.Body1, 0.0F, 0.0F, 0.0F);
		this.Body2 = new ModelRenderer(this, 0, 97);
		this.Body2.addBox(0.0F, 0.0F, 0.0F, 10, 1, 13);
		this.Body2.setRotationPoint(-5.0F, 19.0F, -6.5F);
		this.Body2.setTextureSize(256, 256);
		this.Body2.mirror = true;
		this.setRotation(this.Body2, 0.0F, 0.0F, 0.0F);
		this.Body3 = new ModelRenderer(this, 0, 114);
		this.Body3.addBox(0.0F, 0.0F, 0.0F, 10, 1, 12);
		this.Body3.setRotationPoint(-5.0F, 18.0F, -6.0F);
		this.Body3.setTextureSize(256, 256);
		this.Body3.mirror = true;
		this.setRotation(this.Body3, 0.0F, 0.0F, 0.0F);
		this.Body4 = new ModelRenderer(this, 0, 129);
		this.Body4.addBox(0.0F, 0.0F, 0.0F, 10, 1, 11);
		this.Body4.setRotationPoint(-5.0F, 17.0F, -5.5F);
		this.Body4.setTextureSize(256, 256);
		this.Body4.mirror = true;
		this.setRotation(this.Body4, 0.0F, 0.0F, 0.0F);
		this.Body5 = new ModelRenderer(this, 0, 143);
		this.Body5.addBox(0.0F, 0.0F, 0.0F, 10, 1, 11);
		this.Body5.setRotationPoint(-5.0F, 16.0F, -5.5F);
		this.Body5.setTextureSize(256, 256);
		this.Body5.mirror = true;
		this.setRotation(this.Body5, 0.0F, 0.0F, 0.0F);
		this.Body6 = new ModelRenderer(this, 0, 157);
		this.Body6.addBox(0.0F, 0.0F, 0.0F, 10, 1, 10);
		this.Body6.setRotationPoint(-5.0F, 15.0F, -5.0F);
		this.Body6.setTextureSize(256, 256);
		this.Body6.mirror = true;
		this.setRotation(this.Body6, 0.0F, 0.0F, 0.0F);
		this.Body7 = new ModelRenderer(this, 0, 170);
		this.Body7.addBox(0.0F, 0.0F, 0.0F, 10, 1, 10);
		this.Body7.setRotationPoint(-5.0F, 14.0F, -5.0F);
		this.Body7.setTextureSize(256, 256);
		this.Body7.mirror = true;
		this.setRotation(this.Body7, 0.0F, 0.0F, 0.0F);
		this.LittleSpikeyThing1 = new ModelRenderer(this, 0, 184);
		this.LittleSpikeyThing1.addBox(0.0F, 0.0F, 0.0F, 8, 1, 1);
		this.LittleSpikeyThing1.setRotationPoint(-4.0F, 13.0F, -4.0F);
		this.LittleSpikeyThing1.setTextureSize(256, 256);
		this.LittleSpikeyThing1.mirror = true;
		this.setRotation(this.LittleSpikeyThing1, 0.0F, 0.0F, 0.0F);
		this.LittleSpikeyThing2 = new ModelRenderer(this, 0, 188);
		this.LittleSpikeyThing2.addBox(0.0F, 0.0F, 0.0F, 8, 1, 1);
		this.LittleSpikeyThing2.setRotationPoint(-4.0F, 13.0F, 3.0F);
		this.LittleSpikeyThing2.setTextureSize(256, 256);
		this.LittleSpikeyThing2.mirror = true;
		this.setRotation(this.LittleSpikeyThing2, 0.0F, 0.0F, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Main_Section.render(f5);
		this.Bottom.render(f5);
		this.Wheel1.render(f5);
		this.BottomF.render(f5);
		this.BottomB.render(f5);
		this.BottomM.render(f5);
		this.Wheel2.render(f5);
		this.Wheel3.render(f5);
		this.Wheel4.render(f5);
		this.Front.render(f5);
		this.Back.render(f5);
		this.Body1.render(f5);
		this.Body2.render(f5);
		this.Body3.render(f5);
		this.Body4.render(f5);
		this.Body5.render(f5);
		this.Body6.render(f5);
		this.Body7.render(f5);
		this.LittleSpikeyThing1.render(f5);
		this.LittleSpikeyThing2.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Wheel1.rotateAngleX = f;
		this.Wheel2.rotateAngleX = f;
		this.Wheel3.rotateAngleX = f;
		this.Wheel4.rotateAngleX = f;
	}
}
