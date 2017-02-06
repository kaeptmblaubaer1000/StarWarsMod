package com.parzivail.pswm.gui;

import com.parzivail.pswm.PSWM;
import com.parzivail.util.ui.GFX;
import com.parzivail.util.ui.GLPalette;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Rectangle;

import java.util.ArrayList;

/**
 * Created by colby on 2/5/2017.
 */
public class WindowCommandPrompt extends GuiWindowLayer
{
	GuiInlineTextField textField;
	ArrayList<String> commands = new ArrayList<>();

	public WindowCommandPrompt(PGui parent, Rectangle bounds)
	{
		super(parent, bounds, "Command Prompt");

		this.textField = new GuiInlineTextField(0, PSWM.mc.fontRendererObj, 6, this.titleBarRectangle.getHeight() + 1, this.bounds.getWidth(), 12);
		this.textField.setEnableBackgroundDrawing(false);
		this.textField.setFocused(true);
		this.textField.setCanLoseFocus(false);
	}

	@Override
	public void drawInterior(int mouseX, int mouseY, float partialTicks)
	{
		int y = this.titleBarRectangle.getHeight() + 1;
		for (String s : commands)
		{
			GFX.drawText(PSWM.mc.fontRendererObj, "$ " + s, 1, y, 0.5f, GLPalette.WHITE);
			y += PSWM.mc.fontRendererObj.FONT_HEIGHT / 2f + 2;
		}
		textField.yPosition = y;
		GFX.drawText(PSWM.mc.fontRendererObj, "$", 1, y, 0.5f, GLPalette.WHITE);

		GL11.glEnable(GL11.GL_TEXTURE_2D);
		this.textField.drawTextBox();
	}

	@Override
	public void updateScreen()
	{
		this.textField.updateCursorCounter();
	}

	@Override
	public void keyTyped(char typedChar, int keyCode)
	{
		if (keyCode != Keyboard.KEY_RETURN)
		{
			this.textField.textboxKeyTyped(typedChar, keyCode);
		}
		else
		{
			String s = this.textField.getText().trim();

			if (!s.isEmpty())
				this.command(s);

			this.textField.setText("");
		}
	}

	private void command(String s)
	{
		this.commands.add(s);
	}
}
