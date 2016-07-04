package com.parzivail.pswm.gui;

import com.parzivail.util.ui.GFX;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import org.lwjgl.opengl.GL11;

public class GuiButtonJedi extends GuiButton
{
	public GuiButtonJedi(int id, int x, int y)
	{
		super(id, x, y, 16, 16, "");
	}

	/**
	 * Draws this button to the screen.
	 */
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY)
	{
		if (this.visible)
		{
			mc.getTextureManager().bindTexture(GFX.swIcons);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			boolean flag = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
			int k = 26;

			if (flag)
				k += 17f;

			this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, k, this.width, this.height);
		}
	}
}