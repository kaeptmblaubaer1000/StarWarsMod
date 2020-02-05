// Date: 2/7/2016 6:29:01 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package net.minecraft.src;

public class ModelLuke LS1 extends ModelBase
{
  //fields
    ModelRenderer blade;
  
  public ModelLuke LS1()
  {
    textureWidth = 256;
    textureHeight = 128;
    
      blade = new ModelRenderer(this, 0, 0);
      blade.addBox(0F, 0F, 0F, 124, 4, 4);
      blade.setRotationPoint(-109F, 1F, 1F);
      blade.setTextureSize(64, 32);
      blade.mirror = true;
      setRotation(blade, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    blade.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5);
  }

}