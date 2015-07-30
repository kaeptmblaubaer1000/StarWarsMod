package com.parzi.starwarsmod.rendering.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.tileentities.TileEntityMV;
import com.parzi.starwarsmod.utils.Lumberjack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MVGUI extends GuiContainer
{
    private static final ResourceLocation guiTexture = new ResourceLocation(StarWarsMod.MODID, "textures/gui/mv.png");

    TileEntityMV vaporator;

    public MVGUI(InventoryPlayer player, TileEntityMV vap)
    {
        super(new ContainerMV(player, vap));
        this.vaporator = vap;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
    {
        String s = "Moisture Vaporator";
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(guiTexture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int percent = (int)((float)vaporator.progressTicks / (float)vaporator.totalTicks * 30F);
        this.drawTexturedModalRect(k + 62, l + 28 + (30 - percent), this.xSize, 30 - percent, 9, percent);
    }
}
