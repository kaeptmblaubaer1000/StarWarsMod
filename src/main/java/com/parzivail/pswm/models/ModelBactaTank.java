package com.parzivail.pswm.models;

import com.parzivail.util.ui.ShaderHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * Bacta Tank - Weaston Created using Tabula 4.1.1
 */
public class ModelBactaTank extends ModelBase
{
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
	public ModelRenderer shape20;
	public ModelRenderer shape21;
	public ModelRenderer shape22;
	public ModelRenderer shape23;
	public ModelRenderer shape24;
	public ModelRenderer shape25;
	public ModelRenderer shape26;
	public ModelRenderer shape27;
	public ModelRenderer shape28;
	public ModelRenderer shape29;
	public ModelRenderer shape30;
	public ModelRenderer shape31;
	public ModelRenderer shape32;
	public ModelRenderer shape33;
	public ModelRenderer shape34;
	public ModelRenderer shape35;
	public ModelRenderer shape36;
	public ModelRenderer shape37;
	public ModelRenderer shape38;
	public ModelRenderer shape39;
	public ModelRenderer shape40;
	public ModelRenderer shape41;
	public ModelRenderer shape42;
	public ModelRenderer shape43;
	public ModelRenderer shape44;
	public ModelRenderer shape45;
	public ModelRenderer shape46;
	public ModelRenderer shape47;

	public ModelBactaTank()
	{
		this.textureWidth = 512;
		this.textureHeight = 512;
		this.shape35 = new ModelRenderer(this, 150, 198);
		this.shape35.setRotationPoint(10.0F, 14.0F, -5.5F);
		this.shape35.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.shape22 = new ModelRenderer(this, 0, 488);
		this.shape22.setRotationPoint(2.5F, -41.0F, -13.0F);
		this.shape22.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.shape31 = new ModelRenderer(this, 150, 148);
		this.shape31.setRotationPoint(-5.5F, 14.0F, 10.0F);
		this.shape31.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.shape10 = new ModelRenderer(this, 0, 288);
		this.shape10.setRotationPoint(-13.0F, -44.0F, 10.0F);
		this.shape10.addBox(0.0F, 0.0F, 0.0F, 26, 3, 3, 0.0F);
		this.shape27 = new ModelRenderer(this, 150, 54);
		this.shape27.setRotationPoint(10.0F, 18.0F, -13.0F);
		this.shape27.addBox(0.0F, 0.0F, 0.0F, 3, 3, 26, 0.0F);
		this.shape32 = new ModelRenderer(this, 150, 162);
		this.shape32.setRotationPoint(2.5F, 14.0F, 10.0F);
		this.shape32.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.shape33 = new ModelRenderer(this, 150, 174);
		this.shape33.setRotationPoint(10.0F, 14.0F, 10.0F);
		this.shape33.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.shape1 = new ModelRenderer(this, 0, 0);
		this.shape1.setRotationPoint(-10.0F, -33.5F, -10.0F);
		this.shape1.addBox(0.0F, 0.0F, 0.0F, 20, 44, 20, 0.0F);
		this.shape23 = new ModelRenderer(this, 150, 0);
		this.shape23.setRotationPoint(10.0F, -41.0F, -5.5F);
		this.shape23.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.shape8 = new ModelRenderer(this, 0, 238);
		this.shape8.setRotationPoint(-13.0F, -44.0F, -13.0F);
		this.shape8.addBox(0.0F, 0.0F, 0.0F, 26, 3, 3, 0.0F);
		this.shape45 = new ModelRenderer(this, 150, 370);
		this.shape45.setRotationPoint(-13.0F, 11.0F, -13.0F);
		this.shape45.addBox(0.0F, 0.0F, 0.0F, 26, 3, 3, 0.0F);
		this.shape47 = new ModelRenderer(this, 150, 420);
		this.shape47.setRotationPoint(-11.5F, 8.0F, -11.5F);
		this.shape47.addBox(0.0F, 0.0F, 0.0F, 23, 3, 23, 0.0F);
		this.shape34 = new ModelRenderer(this, 150, 186);
		this.shape34.setRotationPoint(10.0F, 14.0F, 2.5F);
		this.shape34.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.shape15 = new ModelRenderer(this, 0, 378);
		this.shape15.setRotationPoint(10.0F, -41.0F, 10.0F);
		this.shape15.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.shape21 = new ModelRenderer(this, 0, 476);
		this.shape21.setRotationPoint(-5.5F, -41.0F, -13.0F);
		this.shape21.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.shape18 = new ModelRenderer(this, 0, 414);
		this.shape18.setRotationPoint(-14.5F, -47.0F, -14.5F);
		this.shape18.addBox(0.0F, 0.0F, 0.0F, 29, 3, 29, 0.0F);
		this.shape28 = new ModelRenderer(this, 150, 90);
		this.shape28.setRotationPoint(-13.0F, 18.0F, -13.0F);
		this.shape28.addBox(0.0F, 0.0F, 0.0F, 26, 3, 3, 0.0F);
		this.shape5 = new ModelRenderer(this, 0, 130);
		this.shape5.setRotationPoint(-13.0F, -37.0F, -13.0F);
		this.shape5.addBox(0.0F, 0.0F, 0.0F, 3, 3, 26, 0.0F);
		this.shape36 = new ModelRenderer(this, 150, 210);
		this.shape36.setRotationPoint(10.0F, -41.0F, -13.0F);
		this.shape36.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.shape40 = new ModelRenderer(this, 150, 258);
		this.shape40.setRotationPoint(-13.0F, 14.0F, -5.5F);
		this.shape40.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.shape11 = new ModelRenderer(this, 0, 300);
		this.shape11.setRotationPoint(-13.0F, -44.0F, -13.0F);
		this.shape11.addBox(0.0F, 0.0F, 0.0F, 3, 3, 26, 0.0F);
		this.shape4 = new ModelRenderer(this, 0, 118);
		this.shape4.setRotationPoint(-13.0F, -37.0F, 10.0F);
		this.shape4.addBox(0.0F, 0.0F, 0.0F, 26, 3, 3, 0.0F);
		this.shape14 = new ModelRenderer(this, 0, 364);
		this.shape14.setRotationPoint(10.0F, 14.0F, -13.0F);
		this.shape14.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.shape24 = new ModelRenderer(this, 150, 12);
		this.shape24.setRotationPoint(10.0F, -41.0F, 2.5F);
		this.shape24.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.shape9 = new ModelRenderer(this, 0, 250);
		this.shape9.setRotationPoint(10.0F, -44.0F, -13.0F);
		this.shape9.addBox(0.0F, 0.0F, 0.0F, 3, 3, 26, 0.0F);
		this.shape2 = new ModelRenderer(this, 0, 68);
		this.shape2.setRotationPoint(-11.5F, -34.0F, -11.5F);
		this.shape2.addBox(0.0F, 0.0F, 0.0F, 23, 3, 23, 0.0F);
		this.shape6 = new ModelRenderer(this, 0, 164);
		this.shape6.setRotationPoint(10.0F, -37.0F, -13.0F);
		this.shape6.addBox(0.0F, 0.0F, 0.0F, 3, 3, 26, 0.0F);
		this.shape7 = new ModelRenderer(this, 0, 200);
		this.shape7.setRotationPoint(-11.0F, -42.0F, -11.0F);
		this.shape7.addBox(0.0F, 0.0F, 0.0F, 22, 6, 22, 0.0F);
		this.shape12 = new ModelRenderer(this, 0, 340);
		this.shape12.setRotationPoint(-13.0F, -41.0F, 10.0F);
		this.shape12.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.shape30 = new ModelRenderer(this, 150, 136);
		this.shape30.setRotationPoint(-13.0F, 14.0F, 10.0F);
		this.shape30.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.shape41 = new ModelRenderer(this, 150, 270);
		this.shape41.setRotationPoint(-13.0F, 14.0F, 2.5F);
		this.shape41.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.shape44 = new ModelRenderer(this, 150, 334);
		this.shape44.setRotationPoint(10.0F, 11.0F, -13.0F);
		this.shape44.addBox(0.0F, 0.0F, 0.0F, 3, 3, 26, 0.0F);
		this.shape16 = new ModelRenderer(this, 0, 390);
		this.shape16.setRotationPoint(2.5F, -41.0F, 10.0F);
		this.shape16.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.shape17 = new ModelRenderer(this, 0, 402);
		this.shape17.setRotationPoint(-5.5F, -41.0F, 10.0F);
		this.shape17.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.shape25 = new ModelRenderer(this, 150, 0);
		this.shape25.setRotationPoint(-14.5F, 21.0F, -14.5F);
		this.shape25.addBox(0.0F, 0.0F, 0.0F, 29, 3, 29, 0.0F);
		this.shape46 = new ModelRenderer(this, 150, 384);
		this.shape46.setRotationPoint(-11.0F, 13.0F, -11.0F);
		this.shape46.addBox(0.0F, 0.0F, 0.0F, 22, 6, 22, 0.0F);
		this.shape3 = new ModelRenderer(this, 0, 104);
		this.shape3.setRotationPoint(-13.0F, -37.0F, -13.0F);
		this.shape3.addBox(0.0F, 0.0F, 0.0F, 26, 3, 3, 0.0F);
		this.shape42 = new ModelRenderer(this, 150, 282);
		this.shape42.setRotationPoint(-13.0F, 11.0F, -13.0F);
		this.shape42.addBox(0.0F, 0.0F, 0.0F, 3, 3, 26, 0.0F);
		this.shape19 = new ModelRenderer(this, 0, 452);
		this.shape19.setRotationPoint(-13.0F, -41.0F, 2.5F);
		this.shape19.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.shape29 = new ModelRenderer(this, 150, 100);
		this.shape29.setRotationPoint(-13.0F, 18.0F, -13.0F);
		this.shape29.addBox(0.0F, 0.0F, 0.0F, 3, 3, 26, 0.0F);
		this.shape39 = new ModelRenderer(this, 150, 246);
		this.shape39.setRotationPoint(-13.0F, 14.0F, -13.0F);
		this.shape39.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.shape13 = new ModelRenderer(this, 0, 352);
		this.shape13.setRotationPoint(-13.0F, -41.0F, -13.0F);
		this.shape13.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.shape26 = new ModelRenderer(this, 150, 40);
		this.shape26.setRotationPoint(-13.0F, 18.0F, 10.0F);
		this.shape26.addBox(0.0F, 0.0F, 0.0F, 26, 3, 3, 0.0F);
		this.shape38 = new ModelRenderer(this, 150, 234);
		this.shape38.setRotationPoint(-5.5F, 14.0F, -13.0F);
		this.shape38.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.shape43 = new ModelRenderer(this, 150, 320);
		this.shape43.setRotationPoint(-13.0F, 11.0F, 10.0F);
		this.shape43.addBox(0.0F, 0.0F, 0.0F, 26, 3, 3, 0.0F);
		this.shape37 = new ModelRenderer(this, 150, 222);
		this.shape37.setRotationPoint(2.5F, 14.0F, -13.0F);
		this.shape37.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.shape20 = new ModelRenderer(this, 0, 464);
		this.shape20.setRotationPoint(-13.0F, -41.0F, -5.5F);
		this.shape20.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.shape35.render(f5);
		this.shape22.render(f5);
		this.shape31.render(f5);
		this.shape10.render(f5);
		this.shape27.render(f5);
		this.shape32.render(f5);
		this.shape33.render(f5);
		this.shape23.render(f5);
		this.shape8.render(f5);
		this.shape45.render(f5);
		this.shape47.render(f5);
		this.shape34.render(f5);
		this.shape15.render(f5);
		this.shape21.render(f5);
		this.shape18.render(f5);
		this.shape28.render(f5);
		this.shape5.render(f5);
		this.shape36.render(f5);
		this.shape40.render(f5);
		this.shape11.render(f5);
		this.shape4.render(f5);
		this.shape14.render(f5);
		this.shape24.render(f5);
		this.shape9.render(f5);
		this.shape2.render(f5);
		this.shape6.render(f5);
		this.shape7.render(f5);
		this.shape12.render(f5);
		this.shape30.render(f5);
		this.shape41.render(f5);
		this.shape44.render(f5);
		this.shape16.render(f5);
		this.shape17.render(f5);
		this.shape25.render(f5);
		this.shape46.render(f5);
		this.shape3.render(f5);
		this.shape42.render(f5);
		this.shape19.render(f5);
		this.shape29.render(f5);
		this.shape39.render(f5);
		this.shape13.render(f5);
		this.shape26.render(f5);
		this.shape38.render(f5);
		this.shape43.render(f5);
		this.shape37.render(f5);
		this.shape20.render(f5);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_SRC_ALPHA);
		ShaderHelper.setColor(0, 0, 1, 0.5f);
		ShaderHelper.useShader(ShaderHelper.glowSolid);
		this.shape1.render(f5);
		ShaderHelper.releaseShader();
		GL11.glDisable(GL11.GL_BLEND);
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
