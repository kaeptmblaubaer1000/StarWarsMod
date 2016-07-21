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
 * Ventress - Wolfie
 * Created using P-Tabula 4.1.1
 */
public class ModelVentressHilt extends ModelBase implements IHandlesRender
{

	ResourceLocation tA = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/revan2_A.png");
	ResourceLocation tB = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/revan2_B.png");

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

    public ModelVentressHilt() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.Shape4 = new ModelRenderer(this, 82, 4);
        this.Shape4.setRotationPoint(3.0F, 0.0F, 0.0F);
        this.Shape4.addBox(0.0F, 0.0F, 0.0F, 11, 3, 6, 0.0F);
        this.Shape3 = new ModelRenderer(this, 118, 4);
        this.Shape3.setRotationPoint(3.0F, 2.5F, 0.5F);
        this.Shape3.addBox(0.0F, 0.0F, 0.0F, 11, 3, 5, 0.0F);
        this.Shape12 = new ModelRenderer(this, 208, 4);
        this.Shape12.setRotationPoint(13.0F, 1.5F, -0.5F);
        this.Shape12.addBox(0.0F, 0.0F, 0.0F, 1, 3, 7, 0.0F);
        this.setRotateAngle(Shape12, 0.0F, -0.0F, -0.34906584024429316F);
        this.Shape30 = new ModelRenderer(this, 190, 13);
        this.Shape30.setRotationPoint(47.20000076293945F, 12.699999809265137F, -2.5F);
        this.Shape30.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
        this.setRotateAngle(Shape30, 0.0F, -0.0F, 0.5410520434379578F);
        this.Shape14 = new ModelRenderer(this, 52, 0);
        this.Shape14.setRotationPoint(2.0F, -1.0F, 2.0F);
        this.Shape14.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
        this.Shape17 = new ModelRenderer(this, 72, 0);
        this.Shape17.setRotationPoint(10.0F, -1.0F, 2.0F);
        this.Shape17.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
        this.setRotateAngle(Shape17, 0.0F, -0.0F, 0.24434609711170194F);
        this.Shape8 = new ModelRenderer(this, 204, 18);
        this.Shape8.setRotationPoint(10.0F, 4.0F, 0.0F);
        this.Shape8.addBox(0.0F, 0.0F, 0.0F, 1, 2, 6, 0.0F);
        this.Shape31 = new ModelRenderer(this, 0, 0);
        this.Shape31.setRotationPoint(18.0F, 2.0F, -1.5F);
        this.Shape31.addBox(0.0F, 0.0F, 0.0F, 24, 1, 1, 0.0F);
        this.setRotateAngle(Shape31, 0.0F, -0.0F, 0.22689279913902285F);
        this.Shape21 = new ModelRenderer(this, 44, 4);
        this.Shape21.setRotationPoint(17.0F, 0.0F, 0.0F);
        this.Shape21.addBox(0.0F, 0.0F, 0.0F, 12, 6, 6, 0.0F);
        this.setRotateAngle(Shape21, 0.0F, -0.0F, 0.08726646006107329F);
        this.Shape24 = new ModelRenderer(this, 86, 18);
        this.Shape24.setRotationPoint(27.0F, 0.30000001192092896F, -0.5F);
        this.Shape24.addBox(0.0F, 0.0F, 0.0F, 4, 7, 7, 0.0F);
        this.setRotateAngle(Shape24, 0.0F, -0.0F, 0.22689279913902285F);
        this.Shape2 = new ModelRenderer(this, 154, 18);
        this.Shape2.setRotationPoint(0.0F, -1.0F, -0.5F);
        this.Shape2.addBox(0.0F, 0.0F, 0.0F, 1, 8, 7, 0.0F);
        this.Shape15 = new ModelRenderer(this, 248, 10);
        this.Shape15.setRotationPoint(2.0F, -3.0F, 2.0F);
        this.Shape15.addBox(-1.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(Shape15, 0.0F, -0.0F, -0.5410520434379578F);
        this.Shape26 = new ModelRenderer(this, 36, 18);
        this.Shape26.setRotationPoint(40.0F, 5.5F, -0.5F);
        this.Shape26.addBox(0.0F, 0.0F, 0.0F, 5, 7, 7, 0.0F);
        this.setRotateAngle(Shape26, 0.0F, -0.0F, 0.471238911151886F);
        this.Shape11 = new ModelRenderer(this, 190, 4);
        this.Shape11.setRotationPoint(13.0F, 3.0F, 0.0F);
        this.Shape11.addBox(0.0F, -1.0F, 0.0F, 2, 1, 6, 0.0F);
        this.setRotateAngle(Shape11, 0.0F, -0.0F, 0.7155849933624268F);
        this.Shape29 = new ModelRenderer(this, 242, 4);
        this.Shape29.setRotationPoint(47.0F, 12.0F, -2.0F);
        this.Shape29.addBox(0.0F, 0.0F, 0.0F, 3, 3, 1, 0.0F);
        this.setRotateAngle(Shape29, 0.0F, -0.0F, 0.5410520434379578F);
        this.Shape9 = new ModelRenderer(this, 134, 18);
        this.Shape9.setRotationPoint(14.0F, -0.5F, -0.5F);
        this.Shape9.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
        this.Shape5 = new ModelRenderer(this, 226, 4);
        this.Shape5.setRotationPoint(4.0F, 4.0F, 0.0F);
        this.Shape5.addBox(0.0F, 0.0F, 0.0F, 1, 2, 6, 0.0F);
        this.Shape19 = new ModelRenderer(this, 220, 18);
        this.Shape19.setRotationPoint(12.0F, 4.0F, 0.0F);
        this.Shape19.addBox(0.0F, 0.0F, 0.0F, 1, 2, 6, 0.0F);
        this.Shape25 = new ModelRenderer(this, 110, 18);
        this.Shape25.setRotationPoint(34.0F, 2.700000047683716F, -0.5F);
        this.Shape25.addBox(0.0F, 0.0F, 0.0F, 4, 7, 7, 0.0F);
        this.setRotateAngle(Shape25, 0.0F, -0.0F, 0.4188790321350098F);
        this.Shape10 = new ModelRenderer(this, 172, 4);
        this.Shape10.setRotationPoint(13.0F, -0.5F, -0.5F);
        this.Shape10.addBox(0.0F, 0.0F, 0.0F, 1, 2, 7, 0.0F);
        this.Shape16 = new ModelRenderer(this, 64, 0);
        this.Shape16.setRotationPoint(6.0F, -1.0F, 2.0F);
        this.Shape16.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
        this.setRotateAngle(Shape16, 0.0F, -0.0F, 0.6632251143455505F);
        this.Shape1 = new ModelRenderer(this, 152, 4);
        this.Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape1.addBox(0.0F, 0.0F, 0.0F, 3, 6, 6, 0.0F);
        this.Shape20 = new ModelRenderer(this, 236, 18);
        this.Shape20.setRotationPoint(16.0F, 0.0F, 0.0F);
        this.Shape20.addBox(0.0F, 0.0F, 0.0F, 1, 6, 6, 0.0F);
        this.Shape27 = new ModelRenderer(this, 0, 18);
        this.Shape27.setRotationPoint(44.0F, 7.0F, -1.0F);
        this.Shape27.addBox(0.0F, 0.0F, 0.0F, 9, 8, 8, 0.0F);
        this.setRotateAngle(Shape27, 0.0F, -0.0F, 0.5410520434379578F);
        this.Shape23 = new ModelRenderer(this, 62, 18);
        this.Shape23.setRotationPoint(19.0F, -0.30000001192092896F, -0.5F);
        this.Shape23.addBox(0.0F, 0.0F, 0.0F, 4, 7, 7, 0.0F);
        this.setRotateAngle(Shape23, 0.0F, -0.0F, 0.06981316953897475F);
        this.Shape28 = new ModelRenderer(this, 0, 36);
        this.Shape28.setRotationPoint(45.5F, 7.300000190734863F, -1.5F);
        this.Shape28.addBox(0.0F, 0.0F, 0.0F, 6, 9, 9, 0.0F);
        this.setRotateAngle(Shape28, 0.0F, -0.0F, 0.5410520434379578F);
        this.Shape7 = new ModelRenderer(this, 188, 18);
        this.Shape7.setRotationPoint(8.0F, 4.0F, 0.0F);
        this.Shape7.addBox(0.0F, 0.0F, 0.0F, 1, 2, 6, 0.0F);
        this.Shape6 = new ModelRenderer(this, 172, 18);
        this.Shape6.setRotationPoint(6.0F, 4.0F, 0.0F);
        this.Shape6.addBox(0.0F, 0.0F, 0.0F, 1, 2, 6, 0.0F);
        this.Shape22 = new ModelRenderer(this, 0, 4);
        this.Shape22.setRotationPoint(29.0F, 1.0F, 0.0F);
        this.Shape22.addBox(0.0F, 0.0F, 0.0F, 15, 6, 6, 0.0F);
        this.setRotateAngle(Shape22, 0.0F, -0.0F, 0.43633231520652765F);
        this.Shape32 = new ModelRenderer(this, 88, 0);
        this.Shape32.setRotationPoint(17.0F, 2.0F, -1.5F);
        this.Shape32.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.Shape18 = new ModelRenderer(this, 80, 0);
        this.Shape18.setRotationPoint(10.0F, -1.0F, 2.0F);
        this.Shape18.addBox(-2.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
        this.setRotateAngle(Shape18, 0.0F, -0.0F, -0.6806784272193909F);
        this.Shape13 = new ModelRenderer(this, 242, 10);
        this.Shape13.setRotationPoint(1.0F, -3.0F, 2.0F);
        this.Shape13.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Shape4.render(f5);
        this.Shape3.render(f5);
        this.Shape12.render(f5);
        this.Shape30.render(f5);
        this.Shape14.render(f5);
        this.Shape17.render(f5);
        this.Shape8.render(f5);
        this.Shape31.render(f5);
        this.Shape21.render(f5);
        this.Shape24.render(f5);
        this.Shape2.render(f5);
        this.Shape15.render(f5);
        this.Shape26.render(f5);
        this.Shape11.render(f5);
        this.Shape29.render(f5);
        this.Shape9.render(f5);
        this.Shape5.render(f5);
        this.Shape19.render(f5);
        this.Shape25.render(f5);
        this.Shape10.render(f5);
        this.Shape16.render(f5);
        this.Shape1.render(f5);
        this.Shape20.render(f5);
        this.Shape27.render(f5);
        this.Shape23.render(f5);
        this.Shape28.render(f5);
        this.Shape7.render(f5);
        this.Shape6.render(f5);
        this.Shape22.render(f5);
        this.Shape32.render(f5);
        this.Shape18.render(f5);
        this.Shape13.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

	@Override
	public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
	{
		return true;
	}

	@Override
	public ResourceLocation getResourceLocation(boolean alt)
	{
		if (alt)
			return this.tB;
		return this.tA;
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
				GL11.glTranslatef(-30, -2, -2);
				this.render(null, 0, 0, 0, 0, 0, 0.625f);
				GL11.glPopMatrix();
				break;
			case EQUIPPED:
				GL11.glPushMatrix();
				GL11.glScalef(0.05f, 0.05f, 0.05f);
				GL11.glRotatef(180, 1, 0, 0);
				GL11.glRotatef(45, 0, 1, 0);
				GL11.glRotatef(-10, 0, 0, 1);
				GL11.glTranslatef(15, -10, -2);
				if (data[1] instanceof EntityPlayer)
				{
					EntityPlayer player = (EntityPlayer)data[1];
					if (player.isBlocking())
					{
						GL11.glRotatef(40, 0, 0, 1);
						GL11.glRotatef(-20, 0, 1, 0);
						GL11.glTranslatef(0, -8, -3);
					}
				}
				this.render(null, 0, 0, 0, 0, 0, 0.625f);
				GL11.glPopMatrix();
				break;
			case EQUIPPED_FIRST_PERSON:
				GL11.glPushMatrix();
				GL11.glScalef(0.05f, 0.05f, 0.05f);
				GL11.glTranslatef(0, 25, 0);
				GL11.glRotatef(-130, 0, 1, 0);
				GL11.glRotatef(180, 1, 0, 0);
				GL11.glRotatef(50, 0, 0, 1);
				GL11.glTranslatef(0, 0, 18);
				if (data[1] instanceof EntityPlayer)
				{
					EntityPlayer player = (EntityPlayer)data[1];
					if (player.isBlocking())
					{
						GL11.glRotatef(70, 0, 0, 1);
						GL11.glRotatef(70, 1, 0, 0);
						GL11.glTranslatef(0, -5, 18);
					}
				}
				this.render(null, 0, 0, 0, 0, 0, 0.625f);
				GL11.glPopMatrix();
				break;
			case INVENTORY:
				GL11.glScalef(0.045f, 0.045f, 0.045f);
				GL11.glTranslatef(-7, 8, 0);
				GL11.glRotatef(160, 0, 0, 1);
				GL11.glRotatef(180, 0, 1, 0);
				GL11.glRotatef(0, 1, 0, 0);
				this.render(null, 0, 0, 0, 0, 0, 0.625f);
				break;
			default:
				break;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
	{
		return true;
	}
}
