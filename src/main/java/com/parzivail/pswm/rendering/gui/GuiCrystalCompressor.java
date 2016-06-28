package com.parzivail.pswm.rendering.gui;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.handlers.ClientEventHandler;
import com.parzivail.pswm.tileentities.TileEntityCrystalCompressor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiCrystalCompressor extends GuiContainer
{
	private static final ResourceLocation crystalCompressorGuiTextures = new ResourceLocation(Resources.MODID, "textures/gui/crystalCompressor.png");
	private TileEntityCrystalCompressor compressor;

	public GuiCrystalCompressor(InventoryPlayer p_i1081_1_, TileEntityCrystalCompressor p_i1081_2_)
	{
		super(new ContainerCrystalCompressor(p_i1081_1_, p_i1081_2_));
		this.compressor = p_i1081_2_;
	}

	/**
	 * Draw the foreground layer for the GuiContainer (everything in front of the items)
	 */
	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
	{
	}

	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(crystalCompressorGuiTextures);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

		if (this.compressor.getCompressTime() == 0)
			return;

		float i1 = 1 - this.compressor.getCompressTime() / (float)this.compressor.getCompressTimeMax();

		ClientEventHandler.pgui.drawTexturedModalRectFloat(k + 28.5f, l + 27f, 0, 166, 119 * i1, 32);
	}
}