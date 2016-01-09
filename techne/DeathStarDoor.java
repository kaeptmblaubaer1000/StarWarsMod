package Daeth Star Door hopefully;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Death Star Door - Weaston
 * Created using Tabula 4.1.1
 */
public class DeathStarDoor extends ModelBase {
    public ModelRenderer Base;
    public ModelRenderer SplitBackTopParent;
    public ModelRenderer SplitBackBottomParent;
    public ModelRenderer SplitMiddleTopParent;
    public ModelRenderer SplitMiddleBottomParent;
    public ModelRenderer SplitFrontTopParent;
    public ModelRenderer SplitFrontBottomParent;
    public ModelRenderer FrameTop;
    public ModelRenderer FrameR;
    public ModelRenderer FrameL;
    public ModelRenderer SplitBackTopPart1;
    public ModelRenderer SplitBackTopPart2;
    public ModelRenderer SplitBackTopPart3;
    public ModelRenderer SplitBackTopPart4;
    public ModelRenderer SplitBackTopFiller1;
    public ModelRenderer SplitBackTopFiller2;
    public ModelRenderer SplitBackTopFiller3;
    public ModelRenderer SplitBackTopPart5;
    public ModelRenderer SplitBackTopPart6;
    public ModelRenderer SplitBackBottomPart1;
    public ModelRenderer SplitBackBottomPart2;
    public ModelRenderer SplitBackBottomFiller1;
    public ModelRenderer SplitBackBottomFiller2;
    public ModelRenderer SplitBackBottomFiller3;
    public ModelRenderer SplitBackBottomPart3;
    public ModelRenderer SplitBackBottomPart4;
    public ModelRenderer SplitBackBottomPart5;
    public ModelRenderer SplitBackBottomPart6;
    public ModelRenderer SplitMiddleTopPart1;
    public ModelRenderer SplitMiddleTopPart2;
    public ModelRenderer SplitMiddleTopPart3;
    public ModelRenderer SplitMiddleTopPart4;
    public ModelRenderer SplitMiddleTopPart5;
    public ModelRenderer SplitMiddleTopFiller1;
    public ModelRenderer SplitMiddleTopFiller2;
    public ModelRenderer SplitMiddleTopFiller3;
    public ModelRenderer SplitMiddleTopPart6;
    public ModelRenderer SplitMiddleBottomFiller1;
    public ModelRenderer SplitMiddleBottomFiller2;
    public ModelRenderer SplitMiddleBottomFiller3;
    public ModelRenderer SplitMiddleBottomPart1;
    public ModelRenderer SplitMiddleBottomPart2;
    public ModelRenderer SplitMiddleBottomPart3;
    public ModelRenderer SplitMiddleBottomPart4;
    public ModelRenderer SplitMiddleBottomPart5;
    public ModelRenderer SplitMiddleBottomPart5_1;
    public ModelRenderer SplitFrontTopFiller1;
    public ModelRenderer SplitFrontTopFiller2;
    public ModelRenderer SplitFrontTopFiller3;
    public ModelRenderer SplitFrontTopPart1;
    public ModelRenderer SplitFrontTopPart2;
    public ModelRenderer SplitFrontTopPart3;
    public ModelRenderer SplitFrontTopPart4;
    public ModelRenderer SplitFrontTopPart5;
    public ModelRenderer SplitFrontTopPart6;
    public ModelRenderer SplitFrontBottomPart1;
    public ModelRenderer SplitFrontBottomPart2;
    public ModelRenderer SplitFrontBottomFiller1;
    public ModelRenderer SplitFrontBottomFiller2;
    public ModelRenderer SplitFrontBottomFiller3;
    public ModelRenderer SplitFrontBottomPart3;
    public ModelRenderer SplitFrontBottomPart4;
    public ModelRenderer SplitFrontBottomPart5;
    public ModelRenderer SplitFrontBottomPart6;
    public ModelRenderer SplitFrontBottomPart7;

    public DeathStarDoor() {
        this.textureWidth = 512;
        this.textureHeight = 512;
        this.SplitBackBottomPart6 = new ModelRenderer(this, 0, 416);
        this.SplitBackBottomPart6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitBackBottomPart6.addBox(-4.0F, -4.0F, 2.5F, 92, 3, 4, 0.0F);
        this.SplitFrontTopPart6 = new ModelRenderer(this, 310, 230);
        this.SplitFrontTopPart6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitFrontTopPart6.addBox(-43.0F, -43.0F, -7.0F, 92, 3, 4, 0.0F);
        this.SplitMiddleBottomParent = new ModelRenderer(this, 0, 245);
        this.SplitMiddleBottomParent.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitMiddleBottomParent.addBox(-28.0F, 21.0F, -2.25F, 96, 3, 4, 0.0F);
        this.setRotateAngle(SplitMiddleBottomParent, 0.0F, 0.0F, 79.32521450314228F);
        this.SplitFrontBottomPart5 = new ModelRenderer(this, 310, 260);
        this.SplitFrontBottomPart5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitFrontBottomPart5.addBox(-8.0F, -7.0F, -7.0F, 92, 3, 4, 0.0F);
        this.SplitMiddleTopFiller3 = new ModelRenderer(this, 396, 0);
        this.SplitMiddleTopFiller3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitMiddleTopFiller3.addBox(16.0F, -62.0F, -2.25F, 45, 24, 4, 0.0F);
        this.setRotateAngle(SplitMiddleTopFiller3, 0.0F, 0.0F, 0.7853981633974483F);
        this.SplitMiddleTopFiller2 = new ModelRenderer(this, 348, 0);
        this.SplitMiddleTopFiller2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitMiddleTopFiller2.addBox(24.0F, -43.0F, -2.25F, 19, 24, 4, 0.0F);
        this.setRotateAngle(SplitMiddleTopFiller2, 0.0F, 0.0F, 0.7853981633974483F);
        this.SplitMiddleTopPart6 = new ModelRenderer(this, 290, 70);
        this.SplitMiddleTopPart6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitMiddleTopPart6.addBox(-45.0F, 42.0F, -2.25F, 92, 3, 4, 0.0F);
        this.SplitBackTopParent = new ModelRenderer(this, 0, 214);
        this.SplitBackTopParent.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitBackTopParent.addBox(-25.0F, -25.0F, 2.5F, 92, 3, 4, 0.0F);
        this.setRotateAngle(SplitBackTopParent, 0.0F, 0.0F, -0.7853981633974483F);
        this.SplitBackBottomPart3 = new ModelRenderer(this, 0, 386);
        this.SplitBackBottomPart3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitBackBottomPart3.addBox(-15.0F, -13.0F, 2.5F, 92, 3, 4, 0.0F);
        this.SplitFrontBottomPart6 = new ModelRenderer(this, 310, 270);
        this.SplitFrontBottomPart6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitFrontBottomPart6.addBox(-5.0F, -4.0F, -7.0F, 92, 3, 4, 0.0F);
        this.SplitMiddleTopParent = new ModelRenderer(this, 0, 235);
        this.SplitMiddleTopParent.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitMiddleTopParent.addBox(-28.0F, 24.0F, -2.25F, 92, 3, 4, 0.0F);
        this.setRotateAngle(SplitMiddleTopParent, 0.0F, 0.0F, 79.32521450314228F);
        this.SplitMiddleTopPart4 = new ModelRenderer(this, 44, 166);
        this.SplitMiddleTopPart4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitMiddleTopPart4.addBox(-40.0F, 36.0F, -2.25F, 92, 3, 4, 0.0F);
        this.SplitMiddleBottomFiller3 = new ModelRenderer(this, 360, 80);
        this.SplitMiddleBottomFiller3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitMiddleBottomFiller3.addBox(-37.0F, -46.0F, -2.25F, 19, 24, 4, 0.0F);
        this.setRotateAngle(SplitMiddleBottomFiller3, 0.0F, 0.0F, 79.32521450314228F);
        this.SplitBackTopFiller2 = new ModelRenderer(this, 102, 46);
        this.SplitBackTopFiller2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitBackTopFiller2.addBox(-45.0F, -62.0F, 2.5F, 45, 24, 4, 0.0F);
        this.setRotateAngle(SplitBackTopFiller2, 0.0F, 0.0F, 0.7853981633974483F);
        this.SplitFrontTopPart5 = new ModelRenderer(this, 310, 220);
        this.SplitFrontTopPart5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitFrontTopPart5.addBox(-40.0F, -40.0F, -7.0F, 92, 3, 4, 0.0F);
        this.SplitMiddleBottomFiller2 = new ModelRenderer(this, 260, 80);
        this.SplitMiddleBottomFiller2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitMiddleBottomFiller2.addBox(-40.0F, -60.0F, -2.25F, 45, 24, 4, 0.0F);
        this.setRotateAngle(SplitMiddleBottomFiller2, 0.0F, 0.0F, 79.32521450314228F);
        this.SplitBackBottomFiller2 = new ModelRenderer(this, 58, 316);
        this.SplitBackBottomFiller2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitBackBottomFiller2.addBox(-3.0F, -23.0F, 2.5F, 45, 24, 4, 0.0F);
        this.setRotateAngle(SplitBackBottomFiller2, 0.0F, 0.0F, 0.7853981633974483F);
        this.SplitFrontBottomPart3 = new ModelRenderer(this, 310, 240);
        this.SplitFrontBottomPart3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitFrontBottomPart3.addBox(-14.0F, -13.0F, -7.0F, 92, 3, 4, 0.0F);
        this.SplitFrontBottomParent = new ModelRenderer(this, 0, 266);
        this.SplitFrontBottomParent.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitFrontBottomParent.addBox(-22.0F, -22.0F, -7.0F, 92, 3, 4, 0.0F);
        this.setRotateAngle(SplitFrontBottomParent, 0.0F, 0.0F, -0.7853981633974483F);
        this.SplitBackTopFiller3 = new ModelRenderer(this, 102, 76);
        this.SplitBackTopFiller3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitBackTopFiller3.addBox(-36.0F, -44.0F, 2.5F, 19, 24, 4, 0.0F);
        this.setRotateAngle(SplitBackTopFiller3, 0.0F, 0.0F, 0.7853981633974483F);
        this.SplitBackBottomPart2 = new ModelRenderer(this, 0, 306);
        this.SplitBackBottomPart2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitBackBottomPart2.addBox(-17.0F, -16.0F, 2.5F, 92, 3, 4, 0.0F);
        this.SplitMiddleTopPart3 = new ModelRenderer(this, 44, 156);
        this.SplitMiddleTopPart3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitMiddleTopPart3.addBox(-37.0F, 33.0F, -2.25F, 92, 3, 4, 0.0F);
        this.FrameTop = new ModelRenderer(this, 0, 23);
        this.FrameTop.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.FrameTop.addBox(-64.0F, -66.0F, -8.0F, 128, 5, 16, 0.0F);
        this.SplitMiddleTopPart5 = new ModelRenderer(this, 44, 176);
        this.SplitMiddleTopPart5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitMiddleTopPart5.addBox(-43.0F, 39.0F, -2.25F, 92, 3, 4, 0.0F);
        this.SplitBackBottomFiller3 = new ModelRenderer(this, 58, 346);
        this.SplitBackBottomFiller3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitBackBottomFiller3.addBox(18.0F, -43.0F, 2.5F, 19, 24, 4, 0.0F);
        this.setRotateAngle(SplitBackBottomFiller3, 0.0F, 0.0F, 0.7853981633974483F);
        this.SplitBackTopPart1 = new ModelRenderer(this, 0, 426);
        this.SplitBackTopPart1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitBackTopPart1.addBox(-29.0F, -28.0F, 2.5F, 92, 3, 4, 0.0F);
        this.SplitBackBottomFiller1 = new ModelRenderer(this, 0, 316);
        this.SplitBackBottomFiller1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitBackBottomFiller1.addBox(36.0F, -62.0F, 2.5F, 24, 63, 4, 0.0F);
        this.setRotateAngle(SplitBackBottomFiller1, 0.0F, 0.0F, 0.7853981633974483F);
        this.SplitMiddleBottomFiller1 = new ModelRenderer(this, 202, 46);
        this.SplitMiddleBottomFiller1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitMiddleBottomFiller1.addBox(-61.0F, -62.0F, -2.25F, 24, 63, 4, 0.0F);
        this.setRotateAngle(SplitMiddleBottomFiller1, 0.0F, 0.0F, 79.32521450314228F);
        this.SplitMiddleBottomPart5_1 = new ModelRenderer(this, 297, 339);
        this.SplitMiddleBottomPart5_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitMiddleBottomPart5_1.addBox(-13.0F, 3.0F, -2.25F, 96, 3, 4, 0.0F);
        this.SplitFrontTopPart1 = new ModelRenderer(this, 310, 180);
        this.SplitFrontTopPart1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitFrontTopPart1.addBox(-28.0F, -28.0F, -7.0F, 92, 3, 4, 0.0F);
        this.SplitFrontBottomFiller1 = new ModelRenderer(this, 200, 318);
        this.SplitFrontBottomFiller1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitFrontBottomFiller1.addBox(36.0F, -62.0F, -7.0F, 24, 63, 4, 0.0F);
        this.setRotateAngle(SplitFrontBottomFiller1, 0.0F, 0.0F, 0.7853981633974483F);
        this.SplitFrontTopPart2 = new ModelRenderer(this, 310, 190);
        this.SplitFrontTopPart2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitFrontTopPart2.addBox(-31.0F, -31.0F, -7.0F, 92, 3, 4, 0.0F);
        this.SplitBackTopPart5 = new ModelRenderer(this, 44, 116);
        this.SplitBackTopPart5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitBackTopPart5.addBox(-41.0F, -40.0F, 2.5F, 92, 3, 4, 0.0F);
        this.SplitFrontBottomFiller3 = new ModelRenderer(this, 200, 420);
        this.SplitFrontBottomFiller3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitFrontBottomFiller3.addBox(23.0F, -44.0F, -7.0F, 19, 24, 4, 0.0F);
        this.setRotateAngle(SplitFrontBottomFiller3, 0.0F, 0.0F, 0.7853981633974483F);
        this.SplitBackTopPart4 = new ModelRenderer(this, 0, 456);
        this.SplitBackTopPart4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitBackTopPart4.addBox(-38.0F, -37.0F, 2.5F, 92, 3, 4, 0.0F);
        this.SplitFrontTopFiller2 = new ModelRenderer(this, 196, 256);
        this.SplitFrontTopFiller2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitFrontTopFiller2.addBox(-37.0F, -46.0F, -7.0F, 19, 24, 4, 0.0F);
        this.setRotateAngle(SplitFrontTopFiller2, 0.0F, 0.0F, 0.7853981633974483F);
        this.FrameR = new ModelRenderer(this, 0, 48);
        this.FrameR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.FrameR.addBox(-64.0F, -62.0F, -8.0F, 5, 64, 16, 0.0F);
        this.SplitMiddleBottomPart5 = new ModelRenderer(this, 260, 150);
        this.SplitMiddleBottomPart5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitMiddleBottomPart5.addBox(-13.0F, 6.0F, -2.25F, 96, 3, 4, 0.0F);
        this.SplitFrontBottomPart2 = new ModelRenderer(this, 0, 286);
        this.SplitFrontBottomPart2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitFrontBottomPart2.addBox(-17.0F, -16.0F, -7.0F, 92, 3, 4, 0.0F);
        this.SplitBackBottomPart4 = new ModelRenderer(this, 0, 396);
        this.SplitBackBottomPart4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitBackBottomPart4.addBox(-13.0F, -10.0F, 2.5F, 92, 3, 4, 0.0F);
        this.SplitBackTopPart2 = new ModelRenderer(this, 0, 436);
        this.SplitBackTopPart2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitBackTopPart2.addBox(-32.0F, -31.0F, 2.5F, 92, 3, 4, 0.0F);
        this.SplitBackTopPart6 = new ModelRenderer(this, 44, 126);
        this.SplitBackTopPart6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitBackTopPart6.addBox(-44.0F, -43.0F, 2.5F, 92, 3, 4, 0.0F);
        this.SplitBackBottomPart5 = new ModelRenderer(this, 0, 406);
        this.SplitBackBottomPart5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitBackBottomPart5.addBox(-9.0F, -7.0F, 2.5F, 92, 3, 4, 0.0F);
        this.SplitMiddleBottomPart4 = new ModelRenderer(this, 260, 140);
        this.SplitMiddleBottomPart4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitMiddleBottomPart4.addBox(-16.0F, 9.0F, -2.25F, 96, 3, 4, 0.0F);
        this.SplitFrontBottomFiller2 = new ModelRenderer(this, 200, 388);
        this.SplitFrontBottomFiller2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitFrontBottomFiller2.addBox(2.0F, -23.0F, -7.0F, 45, 24, 4, 0.0F);
        this.setRotateAngle(SplitFrontBottomFiller2, 0.0F, 0.0F, 0.7853981633974483F);
        this.SplitFrontBottomPart4 = new ModelRenderer(this, 310, 250);
        this.SplitFrontBottomPart4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitFrontBottomPart4.addBox(-11.0F, -10.0F, -7.0F, 92, 3, 4, 0.0F);
        this.SplitFrontBottomPart7 = new ModelRenderer(this, 310, 280);
        this.SplitFrontBottomPart7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitFrontBottomPart7.addBox(-2.0F, -1.0F, -7.0F, 90, 3, 4, 0.0F);
        this.SplitFrontTopParent = new ModelRenderer(this, 0, 256);
        this.SplitFrontTopParent.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitFrontTopParent.addBox(-25.0F, -25.0F, -7.0F, 92, 3, 4, 0.0F);
        this.setRotateAngle(SplitFrontTopParent, 0.0F, 0.0F, -0.7853981633974483F);
        this.SplitMiddleTopFiller1 = new ModelRenderer(this, 290, 0);
        this.SplitMiddleTopFiller1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitMiddleTopFiller1.addBox(0.0F, -59.0F, -2.25F, 24, 63, 4, 0.0F);
        this.setRotateAngle(SplitMiddleTopFiller1, 0.0F, 0.0F, 0.7853981633974483F);
        this.SplitMiddleBottomPart1 = new ModelRenderer(this, 260, 110);
        this.SplitMiddleBottomPart1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitMiddleBottomPart1.addBox(-25.0F, 18.0F, -2.25F, 96, 3, 4, 0.0F);
        this.SplitFrontTopFiller3 = new ModelRenderer(this, 196, 288);
        this.SplitFrontTopFiller3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitFrontTopFiller3.addBox(-40.0F, -64.0F, -7.0F, 45, 24, 4, 0.0F);
        this.setRotateAngle(SplitFrontTopFiller3, 0.0F, 0.0F, 0.7853981633974483F);
        this.SplitBackBottomParent = new ModelRenderer(this, 0, 225);
        this.SplitBackBottomParent.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitBackBottomParent.addBox(-22.0F, -22.0F, 2.5F, 92, 3, 4, 0.0F);
        this.setRotateAngle(SplitBackBottomParent, 0.0F, 0.0F, -0.7853981633974483F);
        this.SplitFrontBottomPart1 = new ModelRenderer(this, 0, 276);
        this.SplitFrontBottomPart1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitFrontBottomPart1.addBox(-20.0F, -19.0F, -7.0F, 92, 3, 4, 0.0F);
        this.SplitFrontTopPart4 = new ModelRenderer(this, 310, 210);
        this.SplitFrontTopPart4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitFrontTopPart4.addBox(-37.0F, -37.0F, -7.0F, 92, 3, 4, 0.0F);
        this.SplitMiddleBottomPart2 = new ModelRenderer(this, 260, 120);
        this.SplitMiddleBottomPart2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitMiddleBottomPart2.addBox(-22.0F, 15.0F, -2.25F, 96, 3, 4, 0.0F);
        this.SplitMiddleTopPart1 = new ModelRenderer(this, 44, 136);
        this.SplitMiddleTopPart1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitMiddleTopPart1.addBox(-31.0F, 27.0F, -2.25F, 92, 3, 4, 0.0F);
        this.SplitBackTopFiller1 = new ModelRenderer(this, 44, 46);
        this.SplitBackTopFiller1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitBackTopFiller1.addBox(-60.0F, -62.0F, 2.5F, 24, 63, 4, 0.0F);
        this.setRotateAngle(SplitBackTopFiller1, 0.0F, 0.0F, 0.7853981633974483F);
        this.SplitBackBottomPart1 = new ModelRenderer(this, 0, 296);
        this.SplitBackBottomPart1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitBackBottomPart1.addBox(-20.0F, -19.0F, 2.5F, 92, 3, 4, 0.0F);
        this.SplitBackTopPart3 = new ModelRenderer(this, 0, 446);
        this.SplitBackTopPart3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitBackTopPart3.addBox(-35.0F, -34.0F, 2.5F, 92, 3, 4, 0.0F);
        this.SplitFrontTopFiller1 = new ModelRenderer(this, 202, 186);
        this.SplitFrontTopFiller1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitFrontTopFiller1.addBox(-60.0F, -62.0F, -7.0F, 24, 63, 4, 0.0F);
        this.setRotateAngle(SplitFrontTopFiller1, 0.0F, 0.0F, 0.7853981633974483F);
        this.SplitFrontTopPart3 = new ModelRenderer(this, 310, 200);
        this.SplitFrontTopPart3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitFrontTopPart3.addBox(-34.0F, -34.0F, -7.0F, 92, 3, 4, 0.0F);
        this.SplitMiddleTopPart2 = new ModelRenderer(this, 44, 146);
        this.SplitMiddleTopPart2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitMiddleTopPart2.addBox(-34.0F, 30.0F, -2.25F, 92, 3, 4, 0.0F);
        this.SplitMiddleBottomPart3 = new ModelRenderer(this, 260, 130);
        this.SplitMiddleBottomPart3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SplitMiddleBottomPart3.addBox(-19.0F, 12.0F, -2.25F, 96, 3, 4, 0.0F);
        this.FrameL = new ModelRenderer(this, 0, 130);
        this.FrameL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.FrameL.addBox(59.0F, -62.0F, -8.0F, 5, 64, 16, 0.0F);
        this.Base = new ModelRenderer(this, 0, 0);
        this.Base.setRotationPoint(-8.0F, 23.0F, 0.0F);
        this.Base.addBox(-64.0F, 0.0F, -8.0F, 128, 5, 16, 0.0F);
        this.SplitBackBottomParent.addChild(this.SplitBackBottomPart6);
        this.SplitFrontTopParent.addChild(this.SplitFrontTopPart6);
        this.Base.addChild(this.SplitMiddleBottomParent);
        this.SplitFrontBottomParent.addChild(this.SplitFrontBottomPart5);
        this.SplitMiddleTopParent.addChild(this.SplitMiddleTopFiller3);
        this.SplitMiddleTopParent.addChild(this.SplitMiddleTopFiller2);
        this.SplitMiddleTopParent.addChild(this.SplitMiddleTopPart6);
        this.Base.addChild(this.SplitBackTopParent);
        this.SplitBackBottomParent.addChild(this.SplitBackBottomPart3);
        this.SplitFrontBottomParent.addChild(this.SplitFrontBottomPart6);
        this.Base.addChild(this.SplitMiddleTopParent);
        this.SplitMiddleTopParent.addChild(this.SplitMiddleTopPart4);
        this.SplitMiddleBottomParent.addChild(this.SplitMiddleBottomFiller3);
        this.SplitBackTopParent.addChild(this.SplitBackTopFiller2);
        this.SplitFrontTopParent.addChild(this.SplitFrontTopPart5);
        this.SplitMiddleBottomParent.addChild(this.SplitMiddleBottomFiller2);
        this.SplitBackBottomParent.addChild(this.SplitBackBottomFiller2);
        this.SplitFrontBottomParent.addChild(this.SplitFrontBottomPart3);
        this.Base.addChild(this.SplitFrontBottomParent);
        this.SplitBackTopParent.addChild(this.SplitBackTopFiller3);
        this.SplitBackBottomParent.addChild(this.SplitBackBottomPart2);
        this.SplitMiddleTopParent.addChild(this.SplitMiddleTopPart3);
        this.Base.addChild(this.FrameTop);
        this.SplitMiddleTopParent.addChild(this.SplitMiddleTopPart5);
        this.SplitBackBottomParent.addChild(this.SplitBackBottomFiller3);
        this.SplitBackTopParent.addChild(this.SplitBackTopPart1);
        this.SplitBackBottomParent.addChild(this.SplitBackBottomFiller1);
        this.SplitMiddleBottomParent.addChild(this.SplitMiddleBottomFiller1);
        this.SplitMiddleBottomParent.addChild(this.SplitMiddleBottomPart5_1);
        this.SplitFrontTopParent.addChild(this.SplitFrontTopPart1);
        this.SplitFrontBottomParent.addChild(this.SplitFrontBottomFiller1);
        this.SplitFrontTopParent.addChild(this.SplitFrontTopPart2);
        this.SplitBackTopParent.addChild(this.SplitBackTopPart5);
        this.SplitFrontBottomParent.addChild(this.SplitFrontBottomFiller3);
        this.SplitBackTopParent.addChild(this.SplitBackTopPart4);
        this.SplitFrontTopParent.addChild(this.SplitFrontTopFiller2);
        this.Base.addChild(this.FrameR);
        this.SplitMiddleBottomParent.addChild(this.SplitMiddleBottomPart5);
        this.SplitFrontBottomParent.addChild(this.SplitFrontBottomPart2);
        this.SplitBackBottomParent.addChild(this.SplitBackBottomPart4);
        this.SplitBackTopParent.addChild(this.SplitBackTopPart2);
        this.SplitBackTopParent.addChild(this.SplitBackTopPart6);
        this.SplitBackBottomParent.addChild(this.SplitBackBottomPart5);
        this.SplitMiddleBottomParent.addChild(this.SplitMiddleBottomPart4);
        this.SplitFrontBottomParent.addChild(this.SplitFrontBottomFiller2);
        this.SplitFrontBottomParent.addChild(this.SplitFrontBottomPart4);
        this.SplitFrontBottomParent.addChild(this.SplitFrontBottomPart7);
        this.Base.addChild(this.SplitFrontTopParent);
        this.SplitMiddleTopParent.addChild(this.SplitMiddleTopFiller1);
        this.SplitMiddleBottomParent.addChild(this.SplitMiddleBottomPart1);
        this.SplitFrontTopParent.addChild(this.SplitFrontTopFiller3);
        this.Base.addChild(this.SplitBackBottomParent);
        this.SplitFrontBottomParent.addChild(this.SplitFrontBottomPart1);
        this.SplitFrontTopParent.addChild(this.SplitFrontTopPart4);
        this.SplitMiddleBottomParent.addChild(this.SplitMiddleBottomPart2);
        this.SplitMiddleTopParent.addChild(this.SplitMiddleTopPart1);
        this.SplitBackTopParent.addChild(this.SplitBackTopFiller1);
        this.SplitBackBottomParent.addChild(this.SplitBackBottomPart1);
        this.SplitBackTopParent.addChild(this.SplitBackTopPart3);
        this.SplitFrontTopParent.addChild(this.SplitFrontTopFiller1);
        this.SplitFrontTopParent.addChild(this.SplitFrontTopPart3);
        this.SplitMiddleTopParent.addChild(this.SplitMiddleTopPart2);
        this.SplitMiddleBottomParent.addChild(this.SplitMiddleBottomPart3);
        this.Base.addChild(this.FrameL);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Base.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
