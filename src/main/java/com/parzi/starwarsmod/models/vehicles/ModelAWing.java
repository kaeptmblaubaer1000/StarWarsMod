package com.parzi.starwarsmod.models.vehicles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAWing extends ModelBase
{
	// fields
	ModelRenderer Main_Body;
	ModelRenderer Fin_R_Top;
	ModelRenderer Fin_R_Top_Small;
	ModelRenderer Body_1;
	ModelRenderer Body_2;
	ModelRenderer Body_3;
	ModelRenderer Body_4;
	ModelRenderer Body_5;
	ModelRenderer Body_6;
	ModelRenderer Body_Filler;
	ModelRenderer Body_7;
	ModelRenderer Body_8;
	ModelRenderer Body_9;
	ModelRenderer Body_10;
	ModelRenderer Body_11;
	ModelRenderer Body_12;
	ModelRenderer Fin_R_Bottom;
	ModelRenderer Fin_R_Bottom_Small;
	ModelRenderer Fin_L_Top;
	ModelRenderer Fin_L_Bottom;
	ModelRenderer Fine_L_Top_Small;
	ModelRenderer Fin_L_Bottom_Small;
	ModelRenderer Body_Extra;
	ModelRenderer Body_Butt;
	ModelRenderer Cockpit_1;
	ModelRenderer Cockpit_2;
	ModelRenderer Cockpit_3;
	ModelRenderer Laser_Base_L;
	ModelRenderer Laser_L;
	ModelRenderer Laser_Barrel_L;
	ModelRenderer Laser_Base_L_2;
	ModelRenderer Laser_L_2;
	ModelRenderer Laser_Barrel_L_2;
	ModelRenderer Engine_L_1;
	ModelRenderer Engine_L_2;
	ModelRenderer Engine_L_3;
	ModelRenderer Engine_L_4;
	ModelRenderer Engine_R_1;
	ModelRenderer Engine_R_2;
	ModelRenderer Engine_R_3;
	ModelRenderer Engine_R_4;
	ModelRenderer Laser_Base_R;
	ModelRenderer Laser_R;
	ModelRenderer Laser_Barrel_R;
	ModelRenderer Laser_Base_R_2;
	ModelRenderer Laser_R_2;
	ModelRenderer Laser_Barrel_R_2;
	ModelRenderer Landing_Gear_1;
	ModelRenderer Landing_Gear_2;
	ModelRenderer Landing_Gear_3;
	ModelRenderer Landing_Gear_4;
	ModelRenderer Landing_Gear_5;
	ModelRenderer Landing_Gear_6;
	ModelRenderer Body_Filler_More;

	public ModelAWing()
	{
		this.textureWidth = 512;
		this.textureHeight = 512;

		this.Main_Body = new ModelRenderer(this, 0, 0);
		this.Main_Body.addBox(-12F, -8F, 0F, 24, 6, 20);
		this.Main_Body.setRotationPoint(0F, 20F, 0F);
		this.Main_Body.setTextureSize(64, 32);
		this.Main_Body.mirror = true;
		this.setRotation(this.Main_Body, 0F, 0F, 0F);
		this.Fin_R_Top = new ModelRenderer(this, 0, 31);
		this.Fin_R_Top.addBox(-8F, -13F, 11F, 1, 6, 14);
		this.Fin_R_Top.setRotationPoint(0F, 20F, 0F);
		this.Fin_R_Top.setTextureSize(64, 32);
		this.Fin_R_Top.mirror = true;
		this.setRotation(this.Fin_R_Top, 0F, 0F, 0F);
		this.Fin_R_Top_Small = new ModelRenderer(this, 0, 57);
		this.Fin_R_Top_Small.addBox(-8F, -10F, 6F, 1, 4, 5);
		this.Fin_R_Top_Small.setRotationPoint(0F, 20F, 0F);
		this.Fin_R_Top_Small.setTextureSize(64, 32);
		this.Fin_R_Top_Small.mirror = true;
		this.setRotation(this.Fin_R_Top_Small, 0F, 0F, 0F);
		this.Body_1 = new ModelRenderer(this, 0, 70);
		this.Body_1.addBox(-12F, -7.9F, -18.9F, 11, 1, 20);
		this.Body_1.setRotationPoint(0F, 20F, 0F);
		this.Body_1.setTextureSize(64, 32);
		this.Body_1.mirror = true;
		this.setRotation(this.Body_1, 0.1047198F, 0F, 0F);
		this.Body_2 = new ModelRenderer(this, 0, 97);
		this.Body_2.addBox(1F, -7.9F, -18.9F, 11, 1, 20);
		this.Body_2.setRotationPoint(0F, 20F, 0F);
		this.Body_2.setTextureSize(64, 32);
		this.Body_2.mirror = true;
		this.setRotation(this.Body_2, 0.1047198F, 0F, 0F);
		this.Body_3 = new ModelRenderer(this, 0, 123);
		this.Body_3.addBox(1F, -2.95F, -20.3F, 11, 1, 20);
		this.Body_3.setRotationPoint(0F, 20F, 0F);
		this.Body_3.setTextureSize(64, 32);
		this.Body_3.mirror = true;
		this.setRotation(this.Body_3, -0.1047198F, 0F, 0F);
		this.Body_4 = new ModelRenderer(this, 0, 150);
		this.Body_4.addBox(-12F, -2.95F, -20.3F, 11, 1, 20);
		this.Body_4.setRotationPoint(0F, 20F, 0F);
		this.Body_4.setTextureSize(64, 32);
		this.Body_4.mirror = true;
		this.setRotation(this.Body_4, -0.1047198F, 0F, 0F);
		this.Body_5 = new ModelRenderer(this, 0, 176);
		this.Body_5.addBox(1F, -6F, -20F, 11, 2, 21);
		this.Body_5.setRotationPoint(0F, 20F, 0F);
		this.Body_5.setTextureSize(64, 32);
		this.Body_5.mirror = true;
		this.setRotation(this.Body_5, 0F, 0F, 0F);
		this.Body_6 = new ModelRenderer(this, 0, 204);
		this.Body_6.addBox(-12F, -6F, -20F, 11, 2, 21);
		this.Body_6.setRotationPoint(0F, 20F, 0F);
		this.Body_6.setTextureSize(64, 32);
		this.Body_6.mirror = true;
		this.setRotation(this.Body_6, 0F, 0F, 0F);
		this.Body_Filler = new ModelRenderer(this, 0, 232);
		this.Body_Filler.addBox(-2F, -6F, -16F, 4, 2, 19);
		this.Body_Filler.setRotationPoint(0F, 20F, 0F);
		this.Body_Filler.setTextureSize(64, 32);
		this.Body_Filler.mirror = true;
		this.setRotation(this.Body_Filler, 0F, 0F, 0F);
		this.Body_7 = new ModelRenderer(this, 0, 258);
		this.Body_7.addBox(-2F, -7.9F, -13.9F, 4, 1, 15);
		this.Body_7.setRotationPoint(0F, 20F, 0F);
		this.Body_7.setTextureSize(64, 32);
		this.Body_7.mirror = true;
		this.setRotation(this.Body_7, 0.1047198F, 0F, 0F);
		this.Body_8 = new ModelRenderer(this, 0, 280);
		this.Body_8.addBox(-2F, -2.95F, -15.3F, 4, 1, 15);
		this.Body_8.setRotationPoint(0F, 20F, 0F);
		this.Body_8.setTextureSize(64, 32);
		this.Body_8.mirror = true;
		this.setRotation(this.Body_8, -0.1047198F, 0F, 0F);
		this.Body_9 = new ModelRenderer(this, 0, 301);
		this.Body_9.addBox(10F, -6.5F, -10F, 2, 3, 12);
		this.Body_9.setRotationPoint(0F, 20F, 0F);
		this.Body_9.setTextureSize(64, 32);
		this.Body_9.mirror = true;
		this.setRotation(this.Body_9, 0F, 0F, 0F);
		this.Body_10 = new ModelRenderer(this, 0, 320);
		this.Body_10.addBox(10F, -7F, -5F, 2, 4, 7);
		this.Body_10.setRotationPoint(0F, 20F, 0F);
		this.Body_10.setTextureSize(64, 32);
		this.Body_10.mirror = true;
		this.setRotation(this.Body_10, 0F, 0F, 0F);
		this.Body_11 = new ModelRenderer(this, 0, 336);
		this.Body_11.addBox(-12F, -6.5F, -10F, 2, 3, 12);
		this.Body_11.setRotationPoint(0F, 20F, 0F);
		this.Body_11.setTextureSize(64, 32);
		this.Body_11.mirror = true;
		this.setRotation(this.Body_11, 0F, 0F, 0F);
		this.Body_12 = new ModelRenderer(this, 0, 355);
		this.Body_12.addBox(-12F, -7F, -5F, 2, 4, 7);
		this.Body_12.setRotationPoint(0F, 20F, 0F);
		this.Body_12.setTextureSize(64, 32);
		this.Body_12.mirror = true;
		this.setRotation(this.Body_12, 0F, 0F, 0F);
		this.Fin_R_Bottom = new ModelRenderer(this, 0, 371);
		this.Fin_R_Bottom.addBox(-8F, -3F, 11F, 1, 6, 14);
		this.Fin_R_Bottom.setRotationPoint(0F, 20F, 0F);
		this.Fin_R_Bottom.setTextureSize(64, 32);
		this.Fin_R_Bottom.mirror = true;
		this.setRotation(this.Fin_R_Bottom, 0F, 0F, 0F);
		this.Fin_R_Bottom_Small = new ModelRenderer(this, 0, 397);
		this.Fin_R_Bottom_Small.addBox(-8F, -4F, 6F, 1, 4, 5);
		this.Fin_R_Bottom_Small.setRotationPoint(0F, 20F, 0F);
		this.Fin_R_Bottom_Small.setTextureSize(64, 32);
		this.Fin_R_Bottom_Small.mirror = true;
		this.setRotation(this.Fin_R_Bottom_Small, 0F, 0F, 0F);
		this.Fin_L_Top = new ModelRenderer(this, 0, 411);
		this.Fin_L_Top.addBox(7F, -13F, 11F, 1, 6, 14);
		this.Fin_L_Top.setRotationPoint(0F, 20F, 0F);
		this.Fin_L_Top.setTextureSize(64, 32);
		this.Fin_L_Top.mirror = true;
		this.setRotation(this.Fin_L_Top, 0F, 0F, 0F);
		this.Fin_L_Bottom = new ModelRenderer(this, 0, 436);
		this.Fin_L_Bottom.addBox(7F, -3F, 11F, 1, 6, 14);
		this.Fin_L_Bottom.setRotationPoint(0F, 20F, 0F);
		this.Fin_L_Bottom.setTextureSize(64, 32);
		this.Fin_L_Bottom.mirror = true;
		this.setRotation(this.Fin_L_Bottom, 0F, 0F, 0F);
		this.Fine_L_Top_Small = new ModelRenderer(this, 0, 462);
		this.Fine_L_Top_Small.addBox(7F, -10F, 6F, 1, 4, 5);
		this.Fine_L_Top_Small.setRotationPoint(0F, 20F, 0F);
		this.Fine_L_Top_Small.setTextureSize(64, 32);
		this.Fine_L_Top_Small.mirror = true;
		this.setRotation(this.Fine_L_Top_Small, 0F, 0F, 0F);
		this.Fin_L_Bottom_Small = new ModelRenderer(this, 0, 476);
		this.Fin_L_Bottom_Small.addBox(7F, -4F, 6F, 1, 4, 5);
		this.Fin_L_Bottom_Small.setRotationPoint(0F, 20F, 0F);
		this.Fin_L_Bottom_Small.setTextureSize(64, 32);
		this.Fin_L_Bottom_Small.mirror = true;
		this.setRotation(this.Fin_L_Bottom_Small, 0F, 0F, 0F);
		this.Body_Extra = new ModelRenderer(this, 0, 488);
		this.Body_Extra.addBox(-14.5F, -7.5F, 1F, 29, 5, 18);
		this.Body_Extra.setRotationPoint(0F, 20F, 0F);
		this.Body_Extra.setTextureSize(64, 32);
		this.Body_Extra.mirror = true;
		this.setRotation(this.Body_Extra, 0F, 0F, 0F);
		this.Body_Butt = new ModelRenderer(this, 100, 0);
		this.Body_Butt.addBox(-11F, -7F, 20F, 22, 4, 1);
		this.Body_Butt.setRotationPoint(0F, 20F, 0F);
		this.Body_Butt.setTextureSize(64, 32);
		this.Body_Butt.mirror = true;
		this.setRotation(this.Body_Butt, 0F, 0F, 0F);
		this.Cockpit_1 = new ModelRenderer(this, 100, 10);
		this.Cockpit_1.addBox(-2.5F, -10F, -0.3F, 5, 3, 8);
		this.Cockpit_1.setRotationPoint(0F, 20F, 0F);
		this.Cockpit_1.setTextureSize(64, 32);
		this.Cockpit_1.mirror = true;
		this.setRotation(this.Cockpit_1, 0.1396263F, 0F, 0F);
		this.Cockpit_2 = new ModelRenderer(this, 100, 27);
		this.Cockpit_2.addBox(-2.5F, -10.95F, 6F, 5, 3, 14);
		this.Cockpit_2.setRotationPoint(0F, 20F, 0F);
		this.Cockpit_2.setTextureSize(64, 32);
		this.Cockpit_2.mirror = true;
		this.setRotation(this.Cockpit_2, 0F, 0F, 0F);
		this.Cockpit_3 = new ModelRenderer(this, 100, 50);
		this.Cockpit_3.addBox(-2.5F, -9.3F, -3.3F, 5, 3, 7);
		this.Cockpit_3.setRotationPoint(0F, 20F, 0F);
		this.Cockpit_3.setTextureSize(64, 32);
		this.Cockpit_3.mirror = true;
		this.setRotation(this.Cockpit_3, 0.5585054F, 0F, 0F);
		this.Laser_Base_L = new ModelRenderer(this, 100, 66);
		this.Laser_Base_L.addBox(12.75F, -8.5F, 6F, 1, 2, 8);
		this.Laser_Base_L.setRotationPoint(0F, 20F, 0F);
		this.Laser_Base_L.setTextureSize(64, 32);
		this.Laser_Base_L.mirror = true;
		this.setRotation(this.Laser_Base_L, 0F, 0F, 0F);
		this.Laser_L = new ModelRenderer(this, 100, 82);
		this.Laser_L.addBox(12.2F, -10F, 4F, 2, 2, 12);
		this.Laser_L.setRotationPoint(0F, 20F, 0F);
		this.Laser_L.setTextureSize(64, 32);
		this.Laser_L.mirror = true;
		this.setRotation(this.Laser_L, 0F, 0F, 0F);
		this.Laser_Barrel_L = new ModelRenderer(this, 100, 101);
		this.Laser_Barrel_L.addBox(12.75F, -9.5F, 2F, 1, 1, 4);
		this.Laser_Barrel_L.setRotationPoint(0F, 20F, 0F);
		this.Laser_Barrel_L.setTextureSize(64, 32);
		this.Laser_Barrel_L.mirror = true;
		this.setRotation(this.Laser_Barrel_L, 0F, 0F, 0F);
		this.Laser_Base_L_2 = new ModelRenderer(this, 100, 111);
		this.Laser_Base_L_2.addBox(13.5F, -5.5F, 6F, 2, 1, 8);
		this.Laser_Base_L_2.setRotationPoint(0F, 20F, 0F);
		this.Laser_Base_L_2.setTextureSize(64, 32);
		this.Laser_Base_L_2.mirror = true;
		this.setRotation(this.Laser_Base_L_2, 0F, 0F, 0F);
		this.Laser_L_2 = new ModelRenderer(this, 100, 126);
		this.Laser_L_2.addBox(15F, -6F, 3F, 2, 2, 14);
		this.Laser_L_2.setRotationPoint(0F, 20F, 0F);
		this.Laser_L_2.setTextureSize(64, 32);
		this.Laser_L_2.mirror = true;
		this.setRotation(this.Laser_L_2, 0F, 0F, 0F);
		this.Laser_Barrel_L_2 = new ModelRenderer(this, 100, 148);
		this.Laser_Barrel_L_2.addBox(15.5F, -5.5F, 0F, 1, 1, 4);
		this.Laser_Barrel_L_2.setRotationPoint(0F, 20F, 0F);
		this.Laser_Barrel_L_2.setTextureSize(64, 32);
		this.Laser_Barrel_L_2.mirror = true;
		this.setRotation(this.Laser_Barrel_L_2, 0F, 0F, 0F);
		this.Engine_L_1 = new ModelRenderer(this, 100, 158);
		this.Engine_L_1.addBox(5F, -8F, 24F, 5, 1, 1);
		this.Engine_L_1.setRotationPoint(0F, 20F, 0F);
		this.Engine_L_1.setTextureSize(64, 32);
		this.Engine_L_1.mirror = true;
		this.setRotation(this.Engine_L_1, 0F, 0F, 0F);
		this.Engine_L_2 = new ModelRenderer(this, 100, 164);
		this.Engine_L_2.addBox(5F, -3F, 24F, 5, 1, 1);
		this.Engine_L_2.setRotationPoint(0F, 20F, 0F);
		this.Engine_L_2.setTextureSize(64, 32);
		this.Engine_L_2.mirror = true;
		this.setRotation(this.Engine_L_2, 0F, 0F, 0F);
		this.Engine_L_3 = new ModelRenderer(this, 100, 170);
		this.Engine_L_3.addBox(9F, -7.5F, 24F, 1, 5, 1);
		this.Engine_L_3.setRotationPoint(0F, 20F, 0F);
		this.Engine_L_3.setTextureSize(64, 32);
		this.Engine_L_3.mirror = true;
		this.setRotation(this.Engine_L_3, 0F, 0F, 0F);
		this.Engine_L_4 = new ModelRenderer(this, 100, 180);
		this.Engine_L_4.addBox(5F, -7.5F, 24F, 1, 5, 1);
		this.Engine_L_4.setRotationPoint(0F, 20F, 0F);
		this.Engine_L_4.setTextureSize(64, 32);
		this.Engine_L_4.mirror = true;
		this.setRotation(this.Engine_L_4, 0F, 0F, 0F);
		this.Engine_R_1 = new ModelRenderer(this, 100, 190);
		this.Engine_R_1.addBox(-10F, -3F, 24F, 5, 1, 1);
		this.Engine_R_1.setRotationPoint(0F, 20F, 0F);
		this.Engine_R_1.setTextureSize(64, 32);
		this.Engine_R_1.mirror = true;
		this.setRotation(this.Engine_R_1, 0F, 0F, 0F);
		this.Engine_R_2 = new ModelRenderer(this, 100, 196);
		this.Engine_R_2.addBox(-10F, -8F, 24F, 5, 1, 1);
		this.Engine_R_2.setRotationPoint(0F, 20F, 0F);
		this.Engine_R_2.setTextureSize(64, 32);
		this.Engine_R_2.mirror = true;
		this.setRotation(this.Engine_R_2, 0F, 0F, 0F);
		this.Engine_R_3 = new ModelRenderer(this, 100, 201);
		this.Engine_R_3.addBox(-10F, -7.5F, 24F, 1, 5, 1);
		this.Engine_R_3.setRotationPoint(0F, 20F, 0F);
		this.Engine_R_3.setTextureSize(64, 32);
		this.Engine_R_3.mirror = true;
		this.setRotation(this.Engine_R_3, 0F, 0F, 0F);
		this.Engine_R_4 = new ModelRenderer(this, 100, 212);
		this.Engine_R_4.addBox(-6F, -7.5F, 24F, 1, 5, 1);
		this.Engine_R_4.setRotationPoint(0F, 20F, 0F);
		this.Engine_R_4.setTextureSize(64, 32);
		this.Engine_R_4.mirror = true;
		this.setRotation(this.Engine_R_4, 0F, 0F, 0F);
		this.Laser_Base_R = new ModelRenderer(this, 100, 222);
		this.Laser_Base_R.addBox(-13.75F, -8.5F, 6F, 1, 2, 8);
		this.Laser_Base_R.setRotationPoint(0F, 20F, 0F);
		this.Laser_Base_R.setTextureSize(64, 32);
		this.Laser_Base_R.mirror = true;
		this.setRotation(this.Laser_Base_R, 0F, 0F, 0F);
		this.Laser_R = new ModelRenderer(this, 100, 236);
		this.Laser_R.addBox(-14.25F, -10F, 4F, 2, 2, 12);
		this.Laser_R.setRotationPoint(0F, 20F, 0F);
		this.Laser_R.setTextureSize(64, 32);
		this.Laser_R.mirror = true;
		this.setRotation(this.Laser_R, 0F, 0F, 0F);
		this.Laser_Barrel_R = new ModelRenderer(this, 100, 254);
		this.Laser_Barrel_R.addBox(-13.75F, -9.5F, 2F, 1, 1, 4);
		this.Laser_Barrel_R.setRotationPoint(0F, 20F, 0F);
		this.Laser_Barrel_R.setTextureSize(64, 32);
		this.Laser_Barrel_R.mirror = true;
		this.setRotation(this.Laser_Barrel_R, 0F, 0F, 0F);
		this.Laser_Base_R_2 = new ModelRenderer(this, 100, 263);
		this.Laser_Base_R_2.addBox(-15.5F, -5.5F, 6F, 2, 1, 8);
		this.Laser_Base_R_2.setRotationPoint(0F, 20F, 0F);
		this.Laser_Base_R_2.setTextureSize(64, 32);
		this.Laser_Base_R_2.mirror = true;
		this.setRotation(this.Laser_Base_R_2, 0F, 0F, 0F);
		this.Laser_R_2 = new ModelRenderer(this, 100, 278);
		this.Laser_R_2.addBox(-17F, -6F, 3F, 2, 2, 14);
		this.Laser_R_2.setRotationPoint(0F, 20F, 0F);
		this.Laser_R_2.setTextureSize(64, 32);
		this.Laser_R_2.mirror = true;
		this.setRotation(this.Laser_R_2, 0F, 0F, 0F);
		this.Laser_Barrel_R_2 = new ModelRenderer(this, 100, 299);
		this.Laser_Barrel_R_2.addBox(-16.5F, -5.5F, 0F, 1, 1, 4);
		this.Laser_Barrel_R_2.setRotationPoint(0F, 20F, 0F);
		this.Laser_Barrel_R_2.setTextureSize(64, 32);
		this.Laser_Barrel_R_2.mirror = true;
		this.setRotation(this.Laser_Barrel_R_2, 0F, 0F, 0F);
		this.Landing_Gear_1 = new ModelRenderer(this, 180, 0);
		this.Landing_Gear_1.addBox(-0.5F, -2.8F, -9F, 1, 9, 2);
		this.Landing_Gear_1.setRotationPoint(0F, 20F, 0F);
		this.Landing_Gear_1.setTextureSize(64, 32);
		this.Landing_Gear_1.mirror = true;
		this.setRotation(this.Landing_Gear_1, -0.3141593F, 0F, 0F);
		this.Landing_Gear_2 = new ModelRenderer(this, 192, 0);
		this.Landing_Gear_2.addBox(-2F, 3F, -12F, 4, 1, 5);
		this.Landing_Gear_2.setRotationPoint(0F, 20F, 0F);
		this.Landing_Gear_2.setTextureSize(64, 32);
		this.Landing_Gear_2.mirror = true;
		this.setRotation(this.Landing_Gear_2, 0F, 0F, 0F);
		this.Landing_Gear_3 = new ModelRenderer(this, 216, 0);
		this.Landing_Gear_3.addBox(9F, -2F, 13F, 2, 9, 1);
		this.Landing_Gear_3.setRotationPoint(0F, 20F, 0F);
		this.Landing_Gear_3.setTextureSize(64, 32);
		this.Landing_Gear_3.mirror = true;
		this.setRotation(this.Landing_Gear_3, 0F, 0F, -0.3141593F);
		this.Landing_Gear_4 = new ModelRenderer(this, 229, 0);
		this.Landing_Gear_4.addBox(8.7F, 3F, 11.5F, 5, 1, 4);
		this.Landing_Gear_4.setRotationPoint(0F, 20F, 0F);
		this.Landing_Gear_4.setTextureSize(64, 32);
		this.Landing_Gear_4.mirror = true;
		this.setRotation(this.Landing_Gear_4, 0F, 0F, 0F);
		this.Landing_Gear_5 = new ModelRenderer(this, 252, 0);
		this.Landing_Gear_5.addBox(-11F, -2F, 13F, 2, 9, 1);
		this.Landing_Gear_5.setRotationPoint(0F, 20F, 0F);
		this.Landing_Gear_5.setTextureSize(64, 32);
		this.Landing_Gear_5.mirror = true;
		this.setRotation(this.Landing_Gear_5, 0F, 0F, 0.3141593F);
		this.Landing_Gear_6 = new ModelRenderer(this, 265, 0);
		this.Landing_Gear_6.addBox(-14F, 3F, 11.5F, 5, 1, 4);
		this.Landing_Gear_6.setRotationPoint(0F, 20F, 0F);
		this.Landing_Gear_6.setTextureSize(64, 32);
		this.Landing_Gear_6.mirror = true;
		this.setRotation(this.Landing_Gear_6, 0F, 0F, 0F);
		this.Body_Filler_More = new ModelRenderer(this, 162, 22);
		this.Body_Filler_More.addBox(-12F, -6F, -0.3F, 24, 4, 2);
		this.Body_Filler_More.setRotationPoint(0F, 20F, 0F);
		this.Body_Filler_More.setTextureSize(64, 32);
		this.Body_Filler_More.mirror = true;
		this.setRotation(this.Body_Filler_More, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Main_Body.render(f5);
		this.Fin_R_Top.render(f5);
		this.Fin_R_Top_Small.render(f5);
		this.Body_1.render(f5);
		this.Body_2.render(f5);
		this.Body_3.render(f5);
		this.Body_4.render(f5);
		this.Body_5.render(f5);
		this.Body_6.render(f5);
		this.Body_Filler.render(f5);
		this.Body_7.render(f5);
		this.Body_8.render(f5);
		this.Body_9.render(f5);
		this.Body_10.render(f5);
		this.Body_11.render(f5);
		this.Body_12.render(f5);
		this.Fin_R_Bottom.render(f5);
		this.Fin_R_Bottom_Small.render(f5);
		this.Fin_L_Top.render(f5);
		this.Fin_L_Bottom.render(f5);
		this.Fine_L_Top_Small.render(f5);
		this.Fin_L_Bottom_Small.render(f5);
		this.Body_Extra.render(f5);
		this.Body_Butt.render(f5);
		this.Cockpit_1.render(f5);
		this.Cockpit_2.render(f5);
		this.Cockpit_3.render(f5);
		this.Laser_Base_L.render(f5);
		this.Laser_L.render(f5);
		this.Laser_Barrel_L.render(f5);
		this.Laser_Base_L_2.render(f5);
		this.Laser_L_2.render(f5);
		this.Laser_Barrel_L_2.render(f5);
		this.Engine_L_1.render(f5);
		this.Engine_L_2.render(f5);
		this.Engine_L_3.render(f5);
		this.Engine_L_4.render(f5);
		this.Engine_R_1.render(f5);
		this.Engine_R_2.render(f5);
		this.Engine_R_3.render(f5);
		this.Engine_R_4.render(f5);
		this.Laser_Base_R.render(f5);
		this.Laser_R.render(f5);
		this.Laser_Barrel_R.render(f5);
		this.Laser_Base_R_2.render(f5);
		this.Laser_R_2.render(f5);
		this.Laser_Barrel_R_2.render(f5);
		this.Body_Filler_More.render(f5);
		if (!entity.worldObj.isAirBlock((int)entity.posX, (int)entity.posY - 1, (int)entity.posZ))
		{
			this.Landing_Gear_1.render(f5);
			this.Landing_Gear_2.render(f5);
			this.Landing_Gear_3.render(f5);
			this.Landing_Gear_4.render(f5);
			this.Landing_Gear_5.render(f5);
			this.Landing_Gear_6.render(f5);
		}
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