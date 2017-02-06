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
	ArrayList<Command> commands = new ArrayList<>();

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
		for (Command s : commands)
		{
			GFX.drawText(PSWM.mc.fontRendererObj, "$ " + s.command, 1, y, 0.5f, GLPalette.WHITE);
			y += PSWM.mc.fontRendererObj.FONT_HEIGHT / 2f + 2;

			for (String c : s.output)
			{
				GFX.drawText(PSWM.mc.fontRendererObj, c, 1, y, 0.5f, GLPalette.WHITE);
				y += PSWM.mc.fontRendererObj.FONT_HEIGHT / 2f + 2;
			}
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
		switch (s)
		{
			case "whoami":
				this.commands.add(new Command(s, "flynn"));
				break;
			case "bin/history":
				this.commands.add(new Command(s, " 488 cd /opt/LLL/controller/laser/", " 489 vi LLLSDLaserControl.c", " 490 make", " 491 make install", " 492 ./sanity_check", " 493 ./configure -o test.cfg", " 494 vi test.cfg", " 495 vi ~/last_will_and_testament.txt", " 496 cat /proc/meminfo", " 497 ps -a -x -u", " 498 kill -9 2207", " 499 kill 2208", " 500 ps -a -x -u", " 501 touch /opt/LLL/run/ok", " 502 LLLSDLaserControl -ok 1"));
				break;
			case "bin/LLLSDLaserControl -ok 1":
				this.commands.add(new Command(s, " * Starting up...", " * PSU Online", " * HV Online", " * Analog core memory... OK", " * Booting pattern recognition systems"));
				this.parent.addWindow(new WindowLaserControl(this.parent, new Rectangle(100, 100, 100, 40)));
				break;
			default:
				this.commands.add(new Command(s, "Unknown command \"" + s + "\""));
				break;
		}
	}

	public class Command
	{
		public String command;
		public String[] output;

		public Command(String command, String... output)
		{
			this.command = command;
			this.output = output;
		}
	}
}
