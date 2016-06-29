package com.parzivail.pswm.gui;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.tileentities.TileEntityMV;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiMV extends GuiContainer
{
	private static final ResourceLocation guiTexture = new ResourceLocation(Resources.MODID, "textures/gui/mv.png");
	TileEntityMV vaporator;

	public GuiMV(InventoryPlayer player, TileEntityMV vap)
	{
		super(new ContainerMV(player, vap));
		this.vaporator = vap;
	}

	// drawGuiContainerBackgroundLayer
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(guiTexture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, 175, 165);
		int percent = (int)((this.vaporator.progressTicks + 1F) / this.vaporator.totalTicks * 30.0F);
		this.drawTexturedModalRect(k + 62, l + 58 - percent, 176, 30 - percent, 9, percent);

		String s = "Moisture Vaporator";
		this.fontRendererObj.drawString(s, k + this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, l + 6, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), k + 8, l + 71, 4210752);
	}
}
