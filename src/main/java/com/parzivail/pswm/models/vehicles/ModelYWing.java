package com.parzivail.pswm.models.vehicles;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.handlers.ClientEventHandler;
import com.parzivail.pswm.mobs.MobDroidAstromech;
import com.parzivail.pswm.mobs.MobDroidAstromech2;
import com.parzivail.pswm.vehicles.VehicYWing;
import com.parzivail.util.ui.P3D;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * Y-Wing with landing gear.tbl - TechneToTabulaImporter
 * Created using Tabula 4.1.1
 */
public class ModelYWing extends ModelBase
{
	public ModelRenderer MainBody;
	public ModelRenderer Neck;
	public ModelRenderer Wings;
	public ModelRenderer PodThingR;
	public ModelRenderer ConeR;
	public ModelRenderer ConnectorR1;
	public ModelRenderer ConnectorR2;
	public ModelRenderer ConnectorR3;
	public ModelRenderer ConnectorR4;
	public ModelRenderer BackPlateR1;
	public ModelRenderer BackPlateR2;
	public ModelRenderer BackPlateR3;
	public ModelRenderer BackPlateR4;
	public ModelRenderer EngineR;
	public ModelRenderer ConnectorExtraR1;
	public ModelRenderer ConnectorExtraR2;
	public ModelRenderer ConnectorExtraR3;
	public ModelRenderer ConnectorExtraR4;
	public ModelRenderer BodyExtraThing;
	public ModelRenderer TurbineR1;
	public ModelRenderer TurbineR2;
	public ModelRenderer PodThingL;
	public ModelRenderer ConeL;
	public ModelRenderer ConnectorL1;
	public ModelRenderer ConnectorL2;
	public ModelRenderer ConnectorL3;
	public ModelRenderer ConnectorL4;
	public ModelRenderer EngineL;
	public ModelRenderer ConnectorExtraL1;
	public ModelRenderer ConnectorExtraL2;
	public ModelRenderer ConnectorExtraL3;
	public ModelRenderer ConnectorExtraL4;
	public ModelRenderer BackPlateL1;
	public ModelRenderer BackPlateL2;
	public ModelRenderer BackPlateL3;
	public ModelRenderer BackPlateL4;
	public ModelRenderer TurbineL1;
	public ModelRenderer TurbineL2;
	public ModelRenderer BodyExtraThing2;
	public ModelRenderer BodyExtraThing3;
	public ModelRenderer MoreEngines;
	public ModelRenderer AstromechSpot;
	public ModelRenderer LandingGear1;
	public ModelRenderer LandingGear2;
	public ModelRenderer LandingGear3;
	public ModelRenderer LandingGear4;
	public ModelRenderer LandingGear5;
	public ModelRenderer LandingGear6;
	public ModelRenderer Neck_1;
	public ModelRenderer Neck_2;
	public ModelRenderer Neck_3;
	public ModelRenderer Neck_4;
	public ModelRenderer Neck_5;
	public ModelRenderer Neck_6;
	public ModelRenderer Neck_7;
	public ModelRenderer Neck_8;
	public ModelRenderer Neck_9;
	public ModelRenderer Neck_10;
	public ModelRenderer Neck_11;
	public ModelRenderer Neck_12;
	public ModelRenderer Neck_13;
	public ModelRenderer Neck_14;
	public ModelRenderer Neck_15;
	public ModelRenderer Neck_16;
	public ModelRenderer Neck_17;
	public ModelRenderer Neck_18;

	public ModelYWing()
	{
		this.textureWidth = 512;
		this.textureHeight = 512;
		this.ConnectorR1 = new ModelRenderer(this, 0, 198);
		this.ConnectorR1.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.ConnectorR1.addBox(-26.5F, -13.0F, 26.0F, 1, 1, 55, 0.0F);
		this.LandingGear3 = new ModelRenderer(this, 147, 70);
		this.LandingGear3.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.LandingGear3.addBox(6.0F, -7.0F, 36.0F, 2, 11, 2, 0.0F);
		this.setRotateAngle(LandingGear3, 0.0F, -0.0F, -0.3141592741012573F);
		this.Neck_15 = new ModelRenderer(this, 425, 79);
		this.Neck_15.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.Neck_15.addBox(-3.5F, -8.5F, -32.0F, 2, 2, 10, 0.0F);
		this.LandingGear1 = new ModelRenderer(this, 101, 64);
		this.LandingGear1.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.LandingGear1.addBox(0.0F, -10.5F, 3.0F, 2, 11, 2, 0.0F);
		this.setRotateAngle(LandingGear1, -0.3141592741012573F, -0.0F, 0.0F);
		this.Neck_6 = new ModelRenderer(this, 320, 91);
		this.Neck_6.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.Neck_6.addBox(-11.35F, -12.55F, -23.11F, 7, 3, 32, 0.0F);
		this.setRotateAngle(Neck_6, 0.14573499254152653F, -0.2617993877991494F, 0.0F);
		this.BackPlateL4 = new ModelRenderer(this, 0, 264);
		this.BackPlateL4.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.BackPlateL4.addBox(17.0F, -13.5F, 80.0F, 2, 10, 2, 0.0F);
		this.PodThingR = new ModelRenderer(this, 0, 105);
		this.PodThingR.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.PodThingR.addBox(-26.0F, -12.5F, 25.0F, 8, 8, 29, 0.0F);
		this.BackPlateR1 = new ModelRenderer(this, 100, 117);
		this.BackPlateR1.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.BackPlateR1.addBox(-26.5F, -13.5F, 80.0F, 9, 2, 2, 0.0F);
		this.Neck_5 = new ModelRenderer(this, 225, 82);
		this.Neck_5.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.Neck_5.addBox(-11.35F, -9.0F, -24.92F, 9, 3, 32, 0.0F);
		this.setRotateAngle(Neck_5, 0.0F, -0.2617993877991494F, 0.0F);
		this.Neck_9 = new ModelRenderer(this, 255, 136);
		this.Neck_9.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.Neck_9.addBox(2.55F, -13.85F, 6.88F, 9, 8, 2, 0.0F);
		this.setRotateAngle(Neck_9, 0.0F, 0.2617993877991494F, 0.0F);
		this.ConnectorExtraL1 = new ModelRenderer(this, 50, 264);
		this.ConnectorExtraL1.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.ConnectorExtraL1.addBox(17.0F, -13.5F, 28.0F, 2, 2, 8, 0.0F);
		this.Neck_12 = new ModelRenderer(this, 379, 139);
		this.Neck_12.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.Neck_12.addBox(-4.95F, -13.85F, 5.94F, 10, 8, 2, 0.0F);
		this.BackPlateR4 = new ModelRenderer(this, 35, 266);
		this.BackPlateR4.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.BackPlateR4.addBox(-19.0F, -13.5F, 80.0F, 2, 10, 2, 0.0F);
		this.BackPlateR3 = new ModelRenderer(this, 19, 267);
		this.BackPlateR3.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.BackPlateR3.addBox(-27.0F, -13.5F, 80.0F, 2, 10, 2, 0.0F);
		this.PodThingL = new ModelRenderer(this, 0, 357);
		this.PodThingL.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.PodThingL.addBox(18.0F, -12.5F, 25.0F, 8, 8, 29, 0.0F);
		this.Neck_16 = new ModelRenderer(this, 425, 102);
		this.Neck_16.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.Neck_16.addBox(1.5F, -8.5F, -32.0F, 2, 2, 10, 0.0F);
		this.ConnectorL2 = new ModelRenderer(this, 233, 257);
		this.ConnectorL2.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.ConnectorL2.addBox(25.5F, -13.0F, 26.0F, 1, 1, 55, 0.0F);
		this.LandingGear6 = new ModelRenderer(this, 204, 80);
		this.LandingGear6.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.LandingGear6.addBox(-9.600000381469727F, 1.0F, 35.0F, 6, 1, 4, 0.0F);
		this.ConnectorExtraL4 = new ModelRenderer(this, 78, 278);
		this.ConnectorExtraL4.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.ConnectorExtraL4.addBox(17.0F, -5.5F, 28.0F, 2, 2, 8, 0.0F);
		this.Neck_14 = new ModelRenderer(this, 426, 62);
		this.Neck_14.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.Neck_14.addBox(-3.5F, -16.17F, -2.52F, 7, 3, 5, 0.0F);
		this.setRotateAngle(Neck_14, 0.6981317007977318F, 0.0F, 0.0F);
		this.ConeL = new ModelRenderer(this, 0, 397);
		this.ConeL.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.ConeL.addBox(19.0F, -11.5F, 20.0F, 6, 6, 37, 0.0F);
		this.Neck_8 = new ModelRenderer(this, 204, 131);
		this.Neck_8.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.Neck_8.addBox(-11.35F, -11.0F, -4.92F, 9, 3, 12, 0.0F);
		this.setRotateAngle(Neck_8, 0.0F, -0.2617993877991494F, 0.0F);
		this.Neck = new ModelRenderer(this, 0, 62);
		this.Neck.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.Neck.addBox(-4.5F, -12.7F, -25.5F, 9, 3, 32, 0.0F);
		this.setRotateAngle(Neck, 0.13962634015954636F, 0.0F, 0.0F);
		this.Neck_13 = new ModelRenderer(this, 414, 132);
		this.Neck_13.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.Neck_13.addBox(-3.5F, -15.0F, -6.5F, 7, 3, 14, 0.0F);
		this.setRotateAngle(Neck_13, 0.13962634015954636F, 0.0F, 0.0F);
		this.Neck_17 = new ModelRenderer(this, 458, 62);
		this.Neck_17.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.Neck_17.addBox(-3.0F, -8.0F, -36.0F, 1, 1, 5, 0.0F);
		this.ConnectorExtraL2 = new ModelRenderer(this, 50, 278);
		this.ConnectorExtraL2.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.ConnectorExtraL2.addBox(25.0F, -13.5F, 28.0F, 2, 2, 8, 0.0F);
		this.LandingGear5 = new ModelRenderer(this, 180, 80);
		this.LandingGear5.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.LandingGear5.addBox(-7.0F, -7.5F, 36.0F, 2, 11, 2, 0.0F);
		this.setRotateAngle(LandingGear5, 0.0F, -0.0F, 0.3141592741012573F);
		this.Neck_10 = new ModelRenderer(this, 288, 136);
		this.Neck_10.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.Neck_10.addBox(-11.45F, -13.85F, 6.88F, 9, 8, 2, 0.0F);
		this.setRotateAngle(Neck_10, 0.0F, -0.2617993877991494F, 0.0F);
		this.Neck_4 = new ModelRenderer(this, 331, 48);
		this.Neck_4.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.Neck_4.addBox(4.35F, -12.55F, -23.11F, 7, 3, 32, 0.0F);
		this.setRotateAngle(Neck_4, 0.14573499254152653F, 0.2617993877991494F, 0.0F);
		this.Neck_11 = new ModelRenderer(this, 323, 137);
		this.Neck_11.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.Neck_11.addBox(-6.5F, -12.7F, -0.9F, 13, 3, 9, 0.0F);
		this.setRotateAngle(Neck_11, 0.15707963267948966F, 0.0F, 0.0F);
		this.BodyExtraThing2 = new ModelRenderer(this, 0, 458);
		this.BodyExtraThing2.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.BodyExtraThing2.addBox(16.5F, -11.0F, 29.0F, 3, 5, 20, 0.0F);
		this.BodyExtraThing3 = new ModelRenderer(this, 0, 486);
		this.BodyExtraThing3.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.BodyExtraThing3.addBox(-19.5F, -11.0F, 29.0F, 3, 5, 20, 0.0F);
		this.BackPlateL3 = new ModelRenderer(this, 0, 225);
		this.BackPlateL3.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.BackPlateL3.addBox(25.0F, -13.5F, 80.0F, 2, 10, 2, 0.0F);
		this.ConnectorL3 = new ModelRenderer(this, 352, 257);
		this.ConnectorL3.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.ConnectorL3.addBox(25.5F, -5.0F, 26.0F, 1, 1, 55, 0.0F);
		this.ConnectorExtraL3 = new ModelRenderer(this, 78, 264);
		this.ConnectorExtraL3.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.ConnectorExtraL3.addBox(25.0F, -5.5F, 28.0F, 2, 2, 8, 0.0F);
		this.BackPlateL2 = new ModelRenderer(this, 0, 214);
		this.BackPlateL2.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.BackPlateL2.addBox(17.5F, -5.5F, 80.0F, 9, 2, 2, 0.0F);
		this.MoreEngines = new ModelRenderer(this, 453, 0);
		this.MoreEngines.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.MoreEngines.addBox(-9.0F, -13.0F, 51.0F, 18, 9, 9, 0.0F);
		this.ConnectorR4 = new ModelRenderer(this, 353, 198);
		this.ConnectorR4.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.ConnectorR4.addBox(-18.5F, -5.0F, 26.0F, 1, 1, 55, 0.0F);
		this.LandingGear2 = new ModelRenderer(this, 116, 66);
		this.LandingGear2.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.LandingGear2.addBox(-1.0F, 1.0F, 0.800000011920929F, 4, 1, 6, 0.0F);
		this.ConnectorL1 = new ModelRenderer(this, 115, 257);
		this.ConnectorL1.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.ConnectorL1.addBox(17.5F, -13.0F, 26.0F, 1, 1, 55, 0.0F);
		this.TurbineR1 = new ModelRenderer(this, 0, 341);
		this.TurbineR1.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.TurbineR1.addBox(-22.5F, -12.5F, 80.5F, 1, 8, 1, 0.0F);
		this.BackPlateL1 = new ModelRenderer(this, 0, 200);
		this.BackPlateL1.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.BackPlateL1.addBox(17.5F, -13.5F, 80.0F, 9, 2, 2, 0.0F);
		this.EngineL = new ModelRenderer(this, 0, 443);
		this.EngineL.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.EngineL.addBox(20.0F, -10.5F, 52.0F, 4, 4, 8, 0.0F);
		this.ConeR = new ModelRenderer(this, 0, 149);
		this.ConeR.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.ConeR.addBox(-25.0F, -11.5F, 20.0F, 6, 6, 37, 0.0F);
		this.ConnectorL4 = new ModelRenderer(this, 115, 317);
		this.ConnectorL4.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.ConnectorL4.addBox(17.5F, -5.0F, 26.0F, 1, 1, 55, 0.0F);
		this.ConnectorExtraR2 = new ModelRenderer(this, 26, 301);
		this.ConnectorExtraR2.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.ConnectorExtraR2.addBox(-19.0F, -13.5F, 28.0F, 2, 2, 8, 0.0F);
		this.BodyExtraThing = new ModelRenderer(this, 0, 314);
		this.BodyExtraThing.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.BodyExtraThing.addBox(-9.5F, -11.0F, 29.0F, 19, 5, 20, 0.0F);
		this.Neck_18 = new ModelRenderer(this, 458, 81);
		this.Neck_18.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.Neck_18.addBox(2.0F, -8.0F, -36.0F, 1, 1, 5, 0.0F);
		this.ConnectorExtraR3 = new ModelRenderer(this, 55, 301);
		this.ConnectorExtraR3.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.ConnectorExtraR3.addBox(-27.0F, -5.5F, 28.0F, 2, 2, 8, 0.0F);
		this.TurbineR2 = new ModelRenderer(this, 0, 353);
		this.TurbineR2.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.TurbineR2.addBox(-26.0F, -9.0F, 80.5F, 8, 1, 1, 0.0F);
		this.MainBody = new ModelRenderer(this, 0, 0);
		this.MainBody.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.MainBody.addBox(-8.0F, -12.0F, 22.0F, 16, 7, 34, 0.0F);
		this.BackPlateR2 = new ModelRenderer(this, 100, 137);
		this.BackPlateR2.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.BackPlateR2.addBox(-26.5F, -5.5F, 80.0F, 9, 2, 2, 0.0F);
		this.ConnectorR2 = new ModelRenderer(this, 115, 198);
		this.ConnectorR2.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.ConnectorR2.addBox(-18.5F, -13.0F, 26.0F, 1, 1, 55, 0.0F);
		this.ConnectorExtraR1 = new ModelRenderer(this, 0, 301);
		this.ConnectorExtraR1.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.ConnectorExtraR1.addBox(-27.0F, -13.5F, 28.0F, 2, 2, 8, 0.0F);
		this.TurbineL1 = new ModelRenderer(this, 14, 341);
		this.TurbineL1.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.TurbineL1.addBox(21.5F, -12.5F, 80.5F, 1, 8, 1, 0.0F);
		this.Neck_7 = new ModelRenderer(this, 142, 127);
		this.Neck_7.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.Neck_7.addBox(2.35F, -11.0F, -8.92F, 9, 3, 16, 0.0F);
		this.setRotateAngle(Neck_7, 0.0F, 0.2617993877991494F, 0.0F);
		this.ConnectorExtraR4 = new ModelRenderer(this, 82, 301);
		this.ConnectorExtraR4.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.ConnectorExtraR4.addBox(-19.0F, -5.5F, 28.0F, 2, 2, 8, 0.0F);
		this.ConnectorR3 = new ModelRenderer(this, 233, 198);
		this.ConnectorR3.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.ConnectorR3.addBox(-26.5F, -5.0F, 26.0F, 1, 1, 55, 0.0F);
		this.EngineR = new ModelRenderer(this, 0, 286);
		this.EngineR.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.EngineR.addBox(-24.0F, -10.5F, 52.0F, 4, 4, 8, 0.0F);
		this.TurbineL2 = new ModelRenderer(this, 0, 362);
		this.TurbineL2.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.TurbineL2.addBox(18.0F, -9.0F, 80.5F, 8, 1, 1, 0.0F);
		this.AstromechSpot = new ModelRenderer(this, 476, 39);
		this.AstromechSpot.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.AstromechSpot.addBox(-4.0F, -12.0F, 10.300000190734863F, 8, 2, 8, 0.0F);
		this.Neck_2 = new ModelRenderer(this, 229, 7);
		this.Neck_2.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.Neck_2.addBox(-4.5F, -9.0F, -27.0F, 9, 3, 32, 0.0F);
		this.LandingGear4 = new ModelRenderer(this, 164, 64);
		this.LandingGear4.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.LandingGear4.addBox(4.800000190734863F, 1.0F, 35.0F, 6, 1, 4, 0.0F);
		this.Wings = new ModelRenderer(this, 110, 4);
		this.Wings.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.Wings.addBox(-20.0F, -10.0F, 30.0F, 40, 3, 18, 0.0F);
		this.Neck_3 = new ModelRenderer(this, 327, 8);
		this.Neck_3.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.Neck_3.addBox(2.35F, -9.0F, -24.92F, 9, 3, 32, 0.0F);
		this.setRotateAngle(Neck_3, 0.0F, 0.2617993877991494F, 0.0F);
		this.Neck_1 = new ModelRenderer(this, 232, 51);
		this.Neck_1.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.Neck_1.addBox(-7.0F, -11.0F, 5.0F, 14, 5, 20, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		if (entity != null && entity.riddenByEntity != StarWarsMod.mc.thePlayer)
			GL11.glRotatef(entity.prevRotationPitch, 1, 0, 0);
		boolean flag;
		if (entity instanceof VehicYWing)
		{
			flag = entity.worldObj.isAirBlock((int)entity.posX, (int)entity.posY - 1, (int)entity.posZ);

			this.LandingGear1.isHidden = flag;
			this.LandingGear2.isHidden = flag;
			this.LandingGear3.isHidden = flag;
			this.LandingGear4.isHidden = flag;
			this.LandingGear5.isHidden = flag;
			this.LandingGear6.isHidden = flag;

			flag = ClientEventHandler.renderHelper.isFirstPerson() && entity.riddenByEntity == StarWarsMod.mc.thePlayer;
			this.Neck.isHidden = flag;

			if (flag)
			{
				GL11.glTranslatef(0, 0.4f, -0.3f);
			}
		}

		this.ConnectorR1.render(f5);
		this.LandingGear3.render(f5);
		this.Neck_15.render(f5);
		this.LandingGear1.render(f5);
		this.Neck_6.render(f5);
		this.BackPlateL4.render(f5);
		this.PodThingR.render(f5);
		this.BackPlateR1.render(f5);
		this.Neck_5.render(f5);
		this.Neck_9.render(f5);
		this.ConnectorExtraL1.render(f5);
		this.Neck_12.render(f5);
		this.BackPlateR4.render(f5);
		this.BackPlateR3.render(f5);
		this.PodThingL.render(f5);
		this.Neck_16.render(f5);
		this.ConnectorL2.render(f5);
		this.LandingGear6.render(f5);
		this.ConnectorExtraL4.render(f5);
		this.Neck_14.render(f5);
		this.ConeL.render(f5);
		this.Neck_8.render(f5);
		this.Neck.render(f5);
		this.Neck_13.render(f5);
		this.Neck_17.render(f5);
		this.ConnectorExtraL2.render(f5);
		this.LandingGear5.render(f5);
		this.Neck_10.render(f5);
		this.Neck_4.render(f5);
		this.Neck_11.render(f5);
		this.BodyExtraThing2.render(f5);
		this.BodyExtraThing3.render(f5);
		this.BackPlateL3.render(f5);
		this.ConnectorL3.render(f5);
		this.ConnectorExtraL3.render(f5);
		this.BackPlateL2.render(f5);
		this.MoreEngines.render(f5);
		this.ConnectorR4.render(f5);
		this.LandingGear2.render(f5);
		this.ConnectorL1.render(f5);
		this.TurbineR1.render(f5);
		this.BackPlateL1.render(f5);
		this.EngineL.render(f5);
		this.ConeR.render(f5);
		this.ConnectorL4.render(f5);
		this.ConnectorExtraR2.render(f5);
		this.BodyExtraThing.render(f5);
		this.Neck_18.render(f5);
		this.ConnectorExtraR3.render(f5);
		this.TurbineR2.render(f5);
		this.MainBody.render(f5);
		this.BackPlateR2.render(f5);
		this.ConnectorR2.render(f5);
		this.ConnectorExtraR1.render(f5);
		this.TurbineL1.render(f5);
		this.Neck_7.render(f5);
		this.ConnectorExtraR4.render(f5);
		this.ConnectorR3.render(f5);
		this.EngineR.render(f5);
		this.TurbineL2.render(f5);
		this.AstromechSpot.render(f5);
		this.Neck_2.render(f5);
		this.LandingGear4.render(f5);
		this.Wings.render(f5);
		this.Neck_3.render(f5);
		this.Neck_1.render(f5);

		if (entity instanceof VehicYWing)
		{
			VehicYWing ywing = (VehicYWing)entity;
			if (ywing.getHasAstro())
			{
				Entity astro = ywing.getAstroType() == 0 ? new MobDroidAstromech(ywing.worldObj) : new MobDroidAstromech2(ywing.worldObj);
				GL11.glPushMatrix();
				GL11.glRotatef(180, 0, 1, 0);
				GL11.glRotatef(-9, 1, 0, 0);
				GL11.glScalef(1, -1, 1);
				P3D.glScalef(0.6f);
				GL11.glTranslatef(0, -2.43f, -1.22f);
				Render render = RenderManager.instance.getEntityRenderObject(astro);
				astro.setEntityId(1337);
				render.doRender(astro, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
				GL11.glPopMatrix();
			}
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
