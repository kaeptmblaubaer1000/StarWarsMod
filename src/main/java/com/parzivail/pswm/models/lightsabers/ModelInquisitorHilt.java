package com.parzivail.pswm.models.lightsabers;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.rendering.IHandlesRender;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * NewProject - Undefined
 * Created using Tabula 4.1.1
 */
public class ModelInquisitorHilt extends ModelBase implements IHandlesRender
{

    ResourceLocation tA = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/inquisitor_A.png");
    ResourceLocation tB = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/inquisitor_B.png");

    public ModelRenderer Shape1;
    public ModelRenderer Shape2;
    public ModelRenderer Shape3;
    public ModelRenderer Shape4;
    public ModelRenderer Shape5;
    public ModelRenderer Shape6;
    public ModelRenderer Shape7;
    public ModelRenderer Shape8;
    public ModelRenderer Shape9;
    public ModelRenderer Shape10;
    public ModelRenderer Shape11;
    public ModelRenderer Shape12;
    public ModelRenderer Shape13;
    public ModelRenderer Shape14;
    public ModelRenderer Shape15;
    public ModelRenderer Shape16;
    public ModelRenderer Shape17;
    public ModelRenderer Shape18;
    public ModelRenderer Shape19;
    public ModelRenderer Shape20;
    public ModelRenderer Shape21;
    public ModelRenderer Shape22;
    public ModelRenderer Shape23;
    public ModelRenderer Shape24;
    public ModelRenderer Shape25;
    public ModelRenderer Shape26;
    public ModelRenderer Shape27;
    public ModelRenderer Shape28;
    public ModelRenderer Shape29;
    public ModelRenderer Shape30;
    public ModelRenderer Shape31;
    public ModelRenderer Shape32;
    public ModelRenderer Shape33;
    public ModelRenderer Shape34;
    public ModelRenderer Shape35;
    public ModelRenderer Shape36;
    public ModelRenderer Shape37;
    public ModelRenderer Shape38;
    public ModelRenderer Shape39;
    public ModelRenderer Shape41;
    public ModelRenderer Shape43;
    public ModelRenderer Shape40;
    public ModelRenderer Shape42;
    public ModelRenderer Shape46;
    public ModelRenderer Shape47;
    public ModelRenderer Shape48;
    public ModelRenderer Shape49;
    public ModelRenderer Shape50;
    public ModelRenderer Shape51;
    public ModelRenderer Shape52;
    public ModelRenderer Shape54;
    public ModelRenderer Shape53;
    public ModelRenderer Shape55;
    public ModelRenderer Shape56;
    public ModelRenderer Shape57;
    public ModelRenderer Shape58;
    public ModelRenderer Shape59;
    public ModelRenderer Shape60;
    public ModelRenderer Shape61;
    public ModelRenderer Shape62;
    public ModelRenderer Shape63;
    public ModelRenderer Shape64;
    public ModelRenderer Shape65;
    public ModelRenderer Shape66;
    public ModelRenderer Shape67;
    public ModelRenderer Shape68;
    public ModelRenderer Shape69;

    public ModelInquisitorHilt()
    {
        this.textureWidth = 512;
        this.textureHeight = 512;
        this.Shape16 = new ModelRenderer(this, 13, 134);
        this.Shape16.setRotationPoint(28.799999237060547F, 3.5F, -0.5F);
        this.Shape16.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
        this.Shape63 = new ModelRenderer(this, 73, 179);
        this.Shape63.setRotationPoint(14.0F, -13.0F, 1.5F);
        this.Shape63.addBox(0.0F, 0.0F, 0.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(Shape63, 0.0F, -0.0F, 0.7853981852531433F);
        this.Shape17 = new ModelRenderer(this, 77, 21);
        this.Shape17.setRotationPoint(-21.5F, -1.0F, -1.0F);
        this.Shape17.addBox(0.0F, 0.0F, 0.0F, 3, 7, 7, 0.0F);
        this.Shape8 = new ModelRenderer(this, 71, 105);
        this.Shape8.setRotationPoint(29.0F, -0.5F, -0.5F);
        this.Shape8.addBox(0.0F, 0.0F, 0.0F, 4, 1, 6, 0.0F);
        this.setRotateAngle(Shape8, 0.0F, -0.0F, 0.15707963705062866F);
        this.Shape13 = new ModelRenderer(this, 0, 0);
        this.Shape13.setRotationPoint(-30.5F, 0.0F, -0.5F);
        this.Shape13.addBox(0.0F, 0.0F, 0.0F, 4, 1, 6, 0.0F);
        this.Shape53 = new ModelRenderer(this, 0, 17);
        this.Shape53.setRotationPoint(-23.0F, -7.0F, 2.0F);
        this.Shape53.addBox(0.0F, 0.0F, 0.0F, 2, 3, 1, 0.0F);
        this.setRotateAngle(Shape53, 0.0F, -0.0F, 0.8726646304130553F);
        this.Shape23 = new ModelRenderer(this, 26, 134);
        this.Shape23.setRotationPoint(-31.799999237060547F, 3.5F, -0.5F);
        this.Shape23.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
        this.Shape35 = new ModelRenderer(this, 40, 74);
        this.Shape35.setRotationPoint(-3.0F, 0.0F, 0.0F);
        this.Shape35.addBox(0.0F, 0.0F, 0.0F, 1, 5, 5, 0.0F);
        this.Shape40 = new ModelRenderer(this, 0, 141);
        this.Shape40.setRotationPoint(-21.0F, -9.0F, 1.0F);
        this.Shape40.addBox(0.0F, 0.0F, 0.0F, 3, 23, 3, 0.0F);
        this.Shape36 = new ModelRenderer(this, 54, 50);
        this.Shape36.setRotationPoint(-5.0F, -0.5F, -0.5F);
        this.Shape36.addBox(-1.0F, 0.0F, 0.0F, 1, 2, 6, 0.0F);
        this.setRotateAngle(Shape36, 0.0F, -0.0F, -0.45378559827804565F);
        this.Shape55 = new ModelRenderer(this, 0, 23);
        this.Shape55.setRotationPoint(-23.0F, 12.0F, 2.0F);
        this.Shape55.addBox(0.0F, -3.0F, 0.0F, 2, 3, 1, 0.0F);
        this.setRotateAngle(Shape55, 0.0F, -0.0F, -0.8726646304130553F);
        this.Shape28 = new ModelRenderer(this, 35, 28);
        this.Shape28.setRotationPoint(-10.0F, 0.0F, 0.0F);
        this.Shape28.addBox(0.0F, 0.0F, 0.0F, 2, 5, 5, 0.0F);
        this.Shape19 = new ModelRenderer(this, 0, 129);
        this.Shape19.setRotationPoint(28.799999237060547F, 0.5F, 4.5F);
        this.Shape19.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
        this.Shape64 = new ModelRenderer(this, 73, 130);
        this.Shape64.setRotationPoint(-14.0F, 21.0F, 1.0F);
        this.Shape64.addBox(-9.0F, -3.0F, 0.0F, 9, 3, 3, 0.0F);
        this.setRotateAngle(Shape64, 0.0F, -0.0F, 0.7853981852531433F);
        this.Shape29 = new ModelRenderer(this, 36, 88);
        this.Shape29.setRotationPoint(-11.0F, 0.5F, 0.5F);
        this.Shape29.addBox(0.0F, 0.0F, 0.0F, 1, 4, 4, 0.0F);
        this.Shape54 = new ModelRenderer(this, 99, 83);
        this.Shape54.setRotationPoint(22.0F, -7.0F, 2.0F);
        this.Shape54.addBox(0.0F, 0.0F, 0.0F, 2, 19, 1, 0.0F);
        this.Shape58 = new ModelRenderer(this, 73, 160);
        this.Shape58.setRotationPoint(-14.0F, -16.0F, 1.0F);
        this.Shape58.addBox(-9.0F, 0.0F, 0.0F, 9, 3, 3, 0.0F);
        this.setRotateAngle(Shape58, 0.0F, -0.0F, -0.7853981852531433F);
        this.Shape7 = new ModelRenderer(this, 46, 114);
        this.Shape7.setRotationPoint(-28.0F, -0.5F, -0.5F);
        this.Shape7.addBox(-4.0F, 0.0F, 0.0F, 4, 1, 6, 0.0F);
        this.setRotateAngle(Shape7, 0.0F, -0.0F, -0.15707963705062866F);
        this.Shape6 = new ModelRenderer(this, 0, 114);
        this.Shape6.setRotationPoint(26.0F, -0.5F, -0.5F);
        this.Shape6.addBox(0.0F, 0.0F, 0.0F, 3, 6, 6, 0.0F);
        this.Shape51 = new ModelRenderer(this, 0, 173);
        this.Shape51.setRotationPoint(-13.0F, 16.0F, 1.5F);
        this.Shape51.addBox(0.0F, 0.0F, 0.0F, 27, 2, 2, 0.0F);
        this.Shape62 = new ModelRenderer(this, 65, 8);
        this.Shape62.setRotationPoint(22.0F, -9.0F, 1.0F);
        this.Shape62.addBox(-1.0F, -1.0F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(Shape62, 0.0F, -0.0F, -0.7504915595054628F);
        this.Shape61 = new ModelRenderer(this, 73, 150);
        this.Shape61.setRotationPoint(15.0F, -16.0F, 1.0F);
        this.Shape61.addBox(0.0F, 0.0F, 0.0F, 9, 3, 3, 0.0F);
        this.setRotateAngle(Shape61, 0.0F, -0.0F, 0.7853981852531433F);
        this.Shape27 = new ModelRenderer(this, 0, 57);
        this.Shape27.setRotationPoint(12.0F, 0.0F, 0.0F);
        this.Shape27.addBox(0.0F, 0.0F, 0.0F, 19, 5, 5, 0.0F);
        this.Shape31 = new ModelRenderer(this, 16, 28);
        this.Shape31.setRotationPoint(9.0F, 0.0F, 0.0F);
        this.Shape31.addBox(0.0F, 0.0F, 0.0F, 2, 5, 5, 0.0F);
        this.Shape15 = new ModelRenderer(this, 0, 134);
        this.Shape15.setRotationPoint(28.799999237060547F, 0.5F, -0.5F);
        this.Shape15.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
        this.Shape12 = new ModelRenderer(this, 71, 116);
        this.Shape12.setRotationPoint(29.0F, 5.5F, -0.5F);
        this.Shape12.addBox(0.0F, -1.0F, 0.0F, 4, 1, 6, 0.0F);
        this.setRotateAngle(Shape12, 0.0F, -0.0F, -0.15707963705062866F);
        this.Shape42 = new ModelRenderer(this, 16, 141);
        this.Shape42.setRotationPoint(19.0F, -9.0F, 1.0F);
        this.Shape42.addBox(0.0F, 0.0F, 0.0F, 3, 23, 3, 0.0F);
        this.Shape14 = new ModelRenderer(this, 0, 0);
        this.Shape14.setRotationPoint(-30.5F, 4.0F, -0.5F);
        this.Shape14.addBox(0.0F, 0.0F, 0.0F, 3, 1, 6, 0.0F);
        this.Shape20 = new ModelRenderer(this, 13, 129);
        this.Shape20.setRotationPoint(28.799999237060547F, 3.5F, 4.5F);
        this.Shape20.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
        this.Shape56 = new ModelRenderer(this, 0, 11);
        this.Shape56.setRotationPoint(24.0F, -7.0F, 2.0F);
        this.Shape56.addBox(0.0F, 0.0F, 0.0F, 3, 2, 1, 0.0F);
        this.setRotateAngle(Shape56, 0.0F, -0.0F, 0.6981316804885863F);
        this.Shape32 = new ModelRenderer(this, 0, 88);
        this.Shape32.setRotationPoint(-5.0F, 0.5F, 0.5F);
        this.Shape32.addBox(0.0F, 0.0F, 0.0F, 11, 4, 4, 0.0F);
        this.Shape43 = new ModelRenderer(this, 16, 13);
        this.Shape43.setRotationPoint(4.5F, 0.0F, 0.0F);
        this.Shape43.addBox(0.0F, 0.0F, 0.0F, 2, 5, 5, 0.0F);
        this.Shape5 = new ModelRenderer(this, 22, 114);
        this.Shape5.setRotationPoint(-28.0F, -0.5F, -0.5F);
        this.Shape5.addBox(0.0F, 0.0F, 0.0F, 3, 6, 6, 0.0F);
        this.Shape39 = new ModelRenderer(this, 57, 75);
        this.Shape39.setRotationPoint(6.0F, 5.5F, -0.5F);
        this.Shape39.addBox(0.0F, -2.0F, 0.0F, 1, 2, 6, 0.0F);
        this.setRotateAngle(Shape39, 0.0F, -0.0F, -0.45378559827804565F);
        this.Shape69 = new ModelRenderer(this, 73, 193);
        this.Shape69.setRotationPoint(14.0F, 18.0F, 1.5F);
        this.Shape69.addBox(0.0F, -2.0F, 0.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(Shape69, 0.0F, -0.0F, -0.7853981852531433F);
        this.Shape21 = new ModelRenderer(this, 39, 129);
        this.Shape21.setRotationPoint(-31.799999237060547F, 0.5F, -0.5F);
        this.Shape21.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
        this.Shape25 = new ModelRenderer(this, 26, 129);
        this.Shape25.setRotationPoint(-31.799999237060547F, 3.5F, 4.5F);
        this.Shape25.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
        this.Shape65 = new ModelRenderer(this, 53, 8);
        this.Shape65.setRotationPoint(-21.0F, 14.0F, 1.0F);
        this.Shape65.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(Shape65, 0.0F, -0.0F, -0.7504915595054628F);
        this.Shape22 = new ModelRenderer(this, 77, 40);
        this.Shape22.setRotationPoint(-22.5F, -0.5F, -0.5F);
        this.Shape22.addBox(0.0F, 0.0F, 0.0F, 6, 6, 6, 0.0F);
        this.Shape47 = new ModelRenderer(this, 45, 141);
        this.Shape47.setRotationPoint(-18.0F, -10.0F, 1.5F);
        this.Shape47.addBox(0.0F, 0.0F, 0.0F, 2, 24, 2, 0.0F);
        this.Shape33 = new ModelRenderer(this, 35, 13);
        this.Shape33.setRotationPoint(-5.5F, 0.0F, 0.0F);
        this.Shape33.addBox(0.0F, 0.0F, 0.0F, 2, 5, 5, 0.0F);
        this.Shape3 = new ModelRenderer(this, 54, 17);
        this.Shape3.setRotationPoint(6.0F, -0.5F, -0.5F);
        this.Shape3.addBox(0.0F, 0.0F, 0.0F, 3, 6, 6, 0.0F);
        this.Shape68 = new ModelRenderer(this, 65, 1);
        this.Shape68.setRotationPoint(22.0F, 14.0F, 1.0F);
        this.Shape68.addBox(-1.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(Shape68, 0.0F, -0.0F, 0.7504915595054628F);
        this.Shape4 = new ModelRenderer(this, 0, 101);
        this.Shape4.setRotationPoint(-5.0F, 1.0F, -0.5F);
        this.Shape4.addBox(0.0F, 0.0F, 0.0F, 11, 3, 6, 0.0F);
        this.Shape9 = new ModelRenderer(this, 0, 30);
        this.Shape9.setRotationPoint(-31.5F, 0.5F, 0.5F);
        this.Shape9.addBox(0.0F, 0.0F, 0.0F, 2, 4, 4, 0.0F);
        this.Shape59 = new ModelRenderer(this, 53, 1);
        this.Shape59.setRotationPoint(-21.0F, -9.0F, 1.0F);
        this.Shape59.addBox(0.0F, -1.0F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(Shape59, 0.0F, -0.0F, 0.7504915595054628F);
        this.Shape1 = new ModelRenderer(this, 0, 42);
        this.Shape1.setRotationPoint(-30.0F, 0.0F, 0.0F);
        this.Shape1.addBox(0.0F, 0.0F, 0.0F, 19, 5, 5, 0.0F);
        this.Shape2 = new ModelRenderer(this, 54, 34);
        this.Shape2.setRotationPoint(-8.0F, -0.5F, -0.5F);
        this.Shape2.addBox(0.0F, 0.0F, 0.0F, 3, 6, 6, 0.0F);
        this.Shape38 = new ModelRenderer(this, 76, 75);
        this.Shape38.setRotationPoint(-5.0F, 5.5F, -0.5F);
        this.Shape38.addBox(-1.0F, -2.0F, 0.0F, 1, 2, 6, 0.0F);
        this.setRotateAngle(Shape38, 0.0F, -0.0F, 0.45378559827804565F);
        this.Shape66 = new ModelRenderer(this, 73, 186);
        this.Shape66.setRotationPoint(-13.0F, 18.0F, 1.5F);
        this.Shape66.addBox(-7.0F, -2.0F, 0.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(Shape66, 0.0F, -0.0F, 0.7853981852531433F);
        this.Shape46 = new ModelRenderer(this, 0, 189);
        this.Shape46.setRotationPoint(-14.0F, -16.0F, 1.0F);
        this.Shape46.addBox(0.0F, 0.0F, 0.0F, 29, 3, 3, 0.0F);
        this.Shape49 = new ModelRenderer(this, 32, 141);
        this.Shape49.setRotationPoint(17.0F, -10.0F, 1.5F);
        this.Shape49.addBox(0.0F, 0.0F, 0.0F, 2, 24, 2, 0.0F);
        this.Shape52 = new ModelRenderer(this, 108, 83);
        this.Shape52.setRotationPoint(-23.0F, -7.0F, 2.0F);
        this.Shape52.addBox(0.0F, 0.0F, 0.0F, 2, 19, 1, 0.0F);
        this.Shape60 = new ModelRenderer(this, 73, 172);
        this.Shape60.setRotationPoint(-13.0F, -13.0F, 1.5F);
        this.Shape60.addBox(-7.0F, 0.0F, 0.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(Shape60, 0.0F, -0.0F, -0.7853981852531433F);
        this.Shape67 = new ModelRenderer(this, 73, 140);
        this.Shape67.setRotationPoint(15.0F, 21.0F, 1.0F);
        this.Shape67.addBox(0.0F, -3.0F, 0.0F, 9, 3, 3, 0.0F);
        this.setRotateAngle(Shape67, 0.0F, -0.0F, -0.7853981852531433F);
        this.Shape24 = new ModelRenderer(this, 39, 134);
        this.Shape24.setRotationPoint(-31.799999237060547F, 0.5F, 4.5F);
        this.Shape24.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
        this.Shape57 = new ModelRenderer(this, 0, 6);
        this.Shape57.setRotationPoint(24.0F, 12.0F, 2.0F);
        this.Shape57.addBox(0.0F, -2.0F, 0.0F, 3, 2, 1, 0.0F);
        this.setRotateAngle(Shape57, 0.0F, -0.0F, -0.6981316804885863F);
        this.Shape48 = new ModelRenderer(this, 0, 200);
        this.Shape48.setRotationPoint(-14.0F, 18.0F, 1.0F);
        this.Shape48.addBox(0.0F, 0.0F, 0.0F, 29, 3, 3, 0.0F);
        this.Shape18 = new ModelRenderer(this, 78, 57);
        this.Shape18.setRotationPoint(19.5F, -1.0F, -1.0F);
        this.Shape18.addBox(0.0F, 0.0F, 0.0F, 3, 7, 7, 0.0F);
        this.Shape34 = new ModelRenderer(this, 23, 74);
        this.Shape34.setRotationPoint(3.0F, 0.0F, 0.0F);
        this.Shape34.addBox(0.0F, 0.0F, 0.0F, 1, 5, 5, 0.0F);
        this.Shape30 = new ModelRenderer(this, 53, 88);
        this.Shape30.setRotationPoint(11.0F, 0.5F, 0.5F);
        this.Shape30.addBox(0.0F, 0.0F, 0.0F, 1, 4, 4, 0.0F);
        this.Shape11 = new ModelRenderer(this, 46, 102);
        this.Shape11.setRotationPoint(-28.0F, 5.5F, -0.5F);
        this.Shape11.addBox(-4.0F, -1.0F, 0.0F, 4, 1, 6, 0.0F);
        this.setRotateAngle(Shape11, 0.0F, -0.0F, 0.15707963705062866F);
        this.Shape26 = new ModelRenderer(this, 70, 89);
        this.Shape26.setRotationPoint(17.5F, -0.5F, -0.5F);
        this.Shape26.addBox(0.0F, 0.0F, 0.0F, 6, 6, 6, 0.0F);
        this.Shape50 = new ModelRenderer(this, 0, 180);
        this.Shape50.setRotationPoint(-13.0F, -13.0F, 1.5F);
        this.Shape50.addBox(0.0F, 0.0F, 0.0F, 27, 2, 2, 0.0F);
        this.Shape41 = new ModelRenderer(this, 0, 74);
        this.Shape41.setRotationPoint(-1.5F, 0.0F, 0.0F);
        this.Shape41.addBox(0.0F, 0.0F, 0.0F, 4, 5, 5, 0.0F);
        this.Shape10 = new ModelRenderer(this, 26, 1);
        this.Shape10.setRotationPoint(30.5F, 0.5F, 0.5F);
        this.Shape10.addBox(0.0F, 0.0F, 0.0F, 2, 4, 4, 0.0F);
        this.Shape37 = new ModelRenderer(this, 54, 62);
        this.Shape37.setRotationPoint(6.0F, -0.5F, -0.5F);
        this.Shape37.addBox(0.0F, 0.0F, 0.0F, 1, 2, 6, 0.0F);
        this.setRotateAngle(Shape37, 0.0F, -0.0F, 0.45378559827804565F);
    }

	@Override
	public ResourceLocation getResourceLocation(boolean alt)
	{
		if (alt)
			return this.tB;
		return this.tA;
	}

	@Override
	public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
	{
		return true;
	}

	@Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Shape16.render(f5);
        this.Shape63.render(f5);
        this.Shape17.render(f5);
        this.Shape8.render(f5);
        this.Shape13.render(f5);
        this.Shape53.render(f5);
        this.Shape23.render(f5);
        this.Shape35.render(f5);
        this.Shape40.render(f5);
        this.Shape36.render(f5);
        this.Shape55.render(f5);
        this.Shape28.render(f5);
        this.Shape19.render(f5);
        this.Shape64.render(f5);
        this.Shape29.render(f5);
        this.Shape54.render(f5);
        this.Shape58.render(f5);
        this.Shape7.render(f5);
        this.Shape6.render(f5);
        this.Shape51.render(f5);
        this.Shape62.render(f5);
        this.Shape61.render(f5);
        this.Shape27.render(f5);
        this.Shape31.render(f5);
        this.Shape15.render(f5);
        this.Shape12.render(f5);
        this.Shape42.render(f5);
        this.Shape14.render(f5);
        this.Shape20.render(f5);
        this.Shape56.render(f5);
        this.Shape32.render(f5);
        this.Shape43.render(f5);
        this.Shape5.render(f5);
        this.Shape39.render(f5);
        this.Shape69.render(f5);
        this.Shape21.render(f5);
        this.Shape25.render(f5);
        this.Shape65.render(f5);
        this.Shape22.render(f5);
        this.Shape47.render(f5);
        this.Shape33.render(f5);
        this.Shape3.render(f5);
        this.Shape68.render(f5);
        this.Shape4.render(f5);
        this.Shape9.render(f5);
        this.Shape59.render(f5);
        this.Shape1.render(f5);
        this.Shape2.render(f5);
        this.Shape38.render(f5);
        this.Shape66.render(f5);
        this.Shape46.render(f5);
        this.Shape49.render(f5);
        this.Shape52.render(f5);
        this.Shape60.render(f5);
        this.Shape67.render(f5);
        this.Shape24.render(f5);
        this.Shape57.render(f5);
        this.Shape48.render(f5);
        this.Shape18.render(f5);
        this.Shape34.render(f5);
        this.Shape30.render(f5);
        this.Shape11.render(f5);
        this.Shape26.render(f5);
        this.Shape50.render(f5);
        this.Shape41.render(f5);
        this.Shape10.render(f5);
        this.Shape37.render(f5);
    }

	@Override
	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data)
	{
		switch (type)
		{
			case ENTITY:
				GL11.glPushMatrix();
				GL11.glScalef(0.03f, 0.03f, 0.03f);
				GL11.glRotatef(-90, 0, 0, 1);
				GL11.glTranslatef(-40, -2, -2);
				this.render(null, 0, 0, 0, 0, 0, 0.625f);
				GL11.glPopMatrix();
				break;
			case EQUIPPED:
				GL11.glPushMatrix();
				GL11.glScalef(0.05f, 0.05f, 0.05f);
				GL11.glRotatef(180, 1, 0, 0);
				GL11.glRotatef(45, 0, 1, 0);
				GL11.glRotatef(20, 0, 0, 1);
				GL11.glRotatef(90, 1, 0, 0);
				GL11.glTranslatef(22, -1.5f, 20);
				if (data[1] instanceof EntityPlayer)
				{
					EntityPlayer player = (EntityPlayer)data[1];
					if (player.isBlocking())
					{
						GL11.glRotatef(80, 0, 0, 1);
						GL11.glTranslatef(0, -2, 0);
					}
				}
				GL11.glRotatef(-90, 1, 0, 0);
				this.render(null, 0, 0, 0, 0, 0, 0.625f);
				GL11.glPopMatrix();
				break;
			case EQUIPPED_FIRST_PERSON:
				GL11.glPushMatrix();
				GL11.glScalef(0.05f, 0.05f, 0.05f);
				GL11.glTranslatef(0, 25, 0);
				GL11.glRotatef(-130, 0, 1, 0);
				GL11.glRotatef(180, 1, 0, 0);
				GL11.glRotatef(75, 0, 0, 1);
				GL11.glRotatef(85, 1, 0, 0);
				GL11.glTranslatef(25, 18, 0);
				if (data[1] instanceof EntityPlayer)
				{
					EntityPlayer player = (EntityPlayer)data[1];
					if (player.isBlocking())
					{
						GL11.glRotatef(-20, 0, 0, 1);
						GL11.glRotatef(70, 0, 1, 0);
						GL11.glRotatef(30, 1, 0, 0);
						GL11.glTranslatef(10, -4, -5);
					}
				}
				GL11.glRotatef(-90, 1, 0, 0);
				this.render(null, 0, 0, 0, 0, 0, 0.625f);
				GL11.glPopMatrix();
				break;
			case INVENTORY:
				GL11.glScalef(0.035f, 0.035f, 0.035f);
				GL11.glTranslatef(-2, -3, -1);
				GL11.glRotatef(160, 0, 0, 1);
				GL11.glRotatef(180, 0, 1, 0);
				GL11.glRotatef(90, 1, 0, 0);
				this.render(null, 0, 0, 0, 0, 0, 0.625f);
				break;
			default:
				break;
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

	@Override
	public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
	{
		return true;
	}
}
