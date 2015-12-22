package com.parzi.starwarsmod.rendering.models.vehicles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelJakkuSpeeder extends ModelBase
{
	// fields
	ModelRenderer Main_Body;
	ModelRenderer Panel_1;
	ModelRenderer Panel_2;
	ModelRenderer Panel_31;
	ModelRenderer Panel_5;
	ModelRenderer Turbine_Base_1;
	ModelRenderer Turbine_Base_2;
	ModelRenderer Turbine_1;
	ModelRenderer Turbine_2;
	ModelRenderer Panel_6;
	ModelRenderer Skid_Plate1;
	ModelRenderer Turbine_Connector;
	ModelRenderer Turbine_Connector_2;
	ModelRenderer Windshield;
	ModelRenderer Turbine_Panel_1;
	ModelRenderer Turbine_Panel_2;
	ModelRenderer Turbine_Connector_3;
	ModelRenderer Seat;
	ModelRenderer Foot_Hold;
	ModelRenderer Panel_Filler;
	ModelRenderer Panel_32;
	ModelRenderer Skid_Plate2;
	ModelRenderer Skid_Plate3;

	public ModelJakkuSpeeder()
	{
		this.textureWidth = 256;
		this.textureHeight = 256;

		this.Main_Body = new ModelRenderer(this, 0, 0);
		this.Main_Body.addBox(-2F, -10F, -21.5F, 4, 10, 17);
		this.Main_Body.setRotationPoint(0F, 20F, 0F);
		this.Main_Body.setTextureSize(64, 32);
		this.Main_Body.mirror = true;
		this.setRotation(this.Main_Body, 0F, 0F, 0F);
		this.Panel_1 = new ModelRenderer(this, 0, 31);
		this.Panel_1.addBox(-3F, -11F, -22F, 6, 3, 18);
		this.Panel_1.setRotationPoint(0F, 20F, 0F);
		this.Panel_1.setTextureSize(64, 32);
		this.Panel_1.mirror = true;
		this.setRotation(this.Panel_1, 0F, 0F, 0F);
		this.Panel_2 = new ModelRenderer(this, 0, 56);
		this.Panel_2.addBox(-3F, -2F, -22F, 6, 3, 18);
		this.Panel_2.setRotationPoint(0F, 20F, 0F);
		this.Panel_2.setTextureSize(64, 32);
		this.Panel_2.mirror = true;
		this.setRotation(this.Panel_2, 0F, 0F, 0F);
		this.Panel_31 = new ModelRenderer(this, 0, 80);
		this.Panel_31.addBox(1F, -11F, -22F, 2, 12, 2);
		this.Panel_31.setRotationPoint(0F, 20F, 0F);
		this.Panel_31.setTextureSize(64, 32);
		this.Panel_31.mirror = true;
		this.setRotation(this.Panel_31, 0F, 0F, 0F);
		this.Panel_5 = new ModelRenderer(this, 0, 98);
		this.Panel_5.addBox(-2.5F, -11.5F, -21.5F, 5, 3, 17);
		this.Panel_5.setRotationPoint(0F, 20F, 0F);
		this.Panel_5.setTextureSize(64, 32);
		this.Panel_5.mirror = true;
		this.setRotation(this.Panel_5, 0F, 0F, 0F);
		this.Turbine_Base_1 = new ModelRenderer(this, 0, 122);
		this.Turbine_Base_1.addBox(-1F, -7F, -5F, 2, 2, 14);
		this.Turbine_Base_1.setRotationPoint(0F, 20F, 0F);
		this.Turbine_Base_1.setTextureSize(64, 32);
		this.Turbine_Base_1.mirror = true;
		this.setRotation(this.Turbine_Base_1, 0F, 0F, 0F);
		this.Turbine_Base_2 = new ModelRenderer(this, 0, 142);
		this.Turbine_Base_2.addBox(-1F, -3F, -5F, 2, 2, 14);
		this.Turbine_Base_2.setRotationPoint(0F, 20F, 0F);
		this.Turbine_Base_2.setTextureSize(64, 32);
		this.Turbine_Base_2.mirror = true;
		this.setRotation(this.Turbine_Base_2, 0F, 0F, 0F);
		this.Turbine_1 = new ModelRenderer(this, 0, 161);
		this.Turbine_1.addBox(-1.5F, -7.5F, 2F, 3, 3, 6);
		this.Turbine_1.setRotationPoint(0F, 20F, 0F);
		this.Turbine_1.setTextureSize(64, 32);
		this.Turbine_1.mirror = true;
		this.setRotation(this.Turbine_1, 0F, 0F, 0F);
		this.Turbine_2 = new ModelRenderer(this, 21, 161);
		this.Turbine_2.addBox(-1.5F, -3.5F, 2F, 3, 3, 6);
		this.Turbine_2.setRotationPoint(0F, 20F, 0F);
		this.Turbine_2.setTextureSize(64, 32);
		this.Turbine_2.mirror = true;
		this.setRotation(this.Turbine_2, 0F, 0F, 0F);
		this.Panel_6 = new ModelRenderer(this, 0, 174);
		this.Panel_6.addBox(-1.5F, -7.5F, -5F, 3, 7, 2);
		this.Panel_6.setRotationPoint(0F, 20F, 0F);
		this.Panel_6.setTextureSize(64, 32);
		this.Panel_6.mirror = true;
		this.setRotation(this.Panel_6, 0F, 0F, 0F);
		this.Skid_Plate1 = new ModelRenderer(this, 14, 174);
		this.Skid_Plate1.addBox(-1.7F, 2.3F, -20F, 3, 1, 6);
		this.Skid_Plate1.setRotationPoint(0F, 20F, 0F);
		this.Skid_Plate1.setTextureSize(64, 32);
		this.Skid_Plate1.mirror = true;
		this.setRotation(this.Skid_Plate1, 0F, 0F, 1.308997F);
		this.Turbine_Connector = new ModelRenderer(this, 0, 187);
		this.Turbine_Connector.addBox(-1F, -5F, 3F, 2, 2, 4);
		this.Turbine_Connector.setRotationPoint(0F, 20F, 0F);
		this.Turbine_Connector.setTextureSize(64, 32);
		this.Turbine_Connector.mirror = true;
		this.setRotation(this.Turbine_Connector, 0F, 0F, 0F);
		this.Turbine_Connector_2 = new ModelRenderer(this, 16, 187);
		this.Turbine_Connector_2.addBox(-3.5F, -7F, 4F, 7, 2, 2);
		this.Turbine_Connector_2.setRotationPoint(0F, 20F, 0F);
		this.Turbine_Connector_2.setTextureSize(64, 32);
		this.Turbine_Connector_2.mirror = true;
		this.setRotation(this.Turbine_Connector_2, 0F, 0F, 0F);
		this.Windshield = new ModelRenderer(this, 0, 196);
		this.Windshield.addBox(-2F, -12F, -6F, 4, 3, 3);
		this.Windshield.setRotationPoint(0F, 20F, 0F);
		this.Windshield.setTextureSize(64, 32);
		this.Windshield.mirror = true;
		this.setRotation(this.Windshield, 0F, 0F, 0F);
		this.Turbine_Panel_1 = new ModelRenderer(this, 0, 206);
		this.Turbine_Panel_1.addBox(3F, -8.5F, 3F, 1, 9, 4);
		this.Turbine_Panel_1.setRotationPoint(0F, 20F, 0F);
		this.Turbine_Panel_1.setTextureSize(64, 32);
		this.Turbine_Panel_1.mirror = true;
		this.setRotation(this.Turbine_Panel_1, 0F, 0F, 0F);
		this.Turbine_Panel_2 = new ModelRenderer(this, 13, 206);
		this.Turbine_Panel_2.addBox(-4F, -8.5F, 3F, 1, 9, 4);
		this.Turbine_Panel_2.setRotationPoint(0F, 20F, 0F);
		this.Turbine_Panel_2.setTextureSize(64, 32);
		this.Turbine_Panel_2.mirror = true;
		this.setRotation(this.Turbine_Panel_2, 0F, 0F, 0F);
		this.Turbine_Connector_3 = new ModelRenderer(this, 38, 187);
		this.Turbine_Connector_3.addBox(-3.5F, -3F, 4F, 7, 2, 2);
		this.Turbine_Connector_3.setRotationPoint(0F, 20F, 0F);
		this.Turbine_Connector_3.setTextureSize(64, 32);
		this.Turbine_Connector_3.mirror = true;
		this.setRotation(this.Turbine_Connector_3, 0F, 0F, 0F);
		this.Seat = new ModelRenderer(this, 0, 223);
		this.Seat.addBox(-1.5F, -8F, -1F, 3, 2, 5);
		this.Seat.setRotationPoint(0F, 20F, 0F);
		this.Seat.setTextureSize(64, 32);
		this.Seat.mirror = true;
		this.setRotation(this.Seat, 0F, 0F, 0F);
		this.Foot_Hold = new ModelRenderer(this, 0, 234);
		this.Foot_Hold.addBox(-2.5F, -2.5F, -0.5F, 5, 1, 1);
		this.Foot_Hold.setRotationPoint(0F, 20F, 0F);
		this.Foot_Hold.setTextureSize(64, 32);
		this.Foot_Hold.mirror = true;
		this.setRotation(this.Foot_Hold, 0F, 0F, 0F);
		this.Panel_Filler = new ModelRenderer(this, 0, 239);
		this.Panel_Filler.addBox(-3F, -11F, -6F, 6, 12, 2);
		this.Panel_Filler.setRotationPoint(0F, 20F, 0F);
		this.Panel_Filler.setTextureSize(64, 32);
		this.Panel_Filler.mirror = true;
		this.setRotation(this.Panel_Filler, 0F, 0F, 0F);
		this.Panel_32 = new ModelRenderer(this, 14, 80);
		this.Panel_32.addBox(-3F, -11F, -22F, 2, 12, 2);
		this.Panel_32.setRotationPoint(0F, 20F, 0F);
		this.Panel_32.setTextureSize(64, 32);
		this.Panel_32.mirror = true;
		this.setRotation(this.Panel_32, 0F, 0F, 0F);
		this.Skid_Plate2 = new ModelRenderer(this, 39, 174);
		this.Skid_Plate2.addBox(-1.5F, 0F, -8F, 3, 2, 4);
		this.Skid_Plate2.setRotationPoint(0F, 20F, 0F);
		this.Skid_Plate2.setTextureSize(64, 32);
		this.Skid_Plate2.mirror = true;
		this.setRotation(this.Skid_Plate2, 0F, 0F, 0F);
		this.Skid_Plate3 = new ModelRenderer(this, 61, 174);
		this.Skid_Plate3.addBox(-1.3F, 2.3F, -20F, 3, 1, 6);
		this.Skid_Plate3.setRotationPoint(0F, 20F, 0F);
		this.Skid_Plate3.setTextureSize(64, 32);
		this.Skid_Plate3.mirror = true;
		this.setRotation(this.Skid_Plate3, 0F, 0F, -1.308997F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Main_Body.render(f5);
		this.Panel_1.render(f5);
		this.Panel_2.render(f5);
		this.Panel_31.render(f5);
		this.Panel_5.render(f5);
		this.Turbine_Base_1.render(f5);
		this.Turbine_Base_2.render(f5);
		this.Turbine_1.render(f5);
		this.Turbine_2.render(f5);
		this.Panel_6.render(f5);
		this.Skid_Plate1.render(f5);
		this.Turbine_Connector.render(f5);
		this.Turbine_Connector_2.render(f5);
		this.Windshield.render(f5);
		this.Turbine_Panel_1.render(f5);
		this.Turbine_Panel_2.render(f5);
		this.Turbine_Connector_3.render(f5);
		this.Seat.render(f5);
		this.Foot_Hold.render(f5);
		this.Panel_Filler.render(f5);
		this.Panel_32.render(f5);
		this.Skid_Plate2.render(f5);
		this.Skid_Plate3.render(f5);
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
	}

}