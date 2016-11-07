package com.parzivail.pswm.gui;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.customship.ComponentBank;
import com.parzivail.pswm.customship.IStarshipPart;
import com.parzivail.util.lwjgl.Vector2f;
import com.parzivail.util.lwjgl.Vector3f;
import com.parzivail.util.math.Animation;
import com.parzivail.util.ui.GFX;
import com.parzivail.util.ui.GLPalette;
import com.parzivail.util.ui.OutlineDropdown;
import com.parzivail.util.ui.OutlineDropdownItem;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class GuiShipwright extends GuiScreen
{
	EntityPlayer player;
	ScaledResolution r;
	public static float lerp = 0;
	private final int inwardness = 3;

	private List<OutlineDropdown<IStarshipPart>> dropdownList = new ArrayList<>();

	private static Rectangle partListRegion;
	private int partListScroll = 3;
	private int partListTotalContentHeight;

	public GuiShipwright(EntityPlayer player)
	{
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if (button.visible && button.enabled)
		{
			if (button instanceof OutlineDropdown)
			{
				if (((OutlineDropdown)button).expanded)
					((OutlineDropdown)button).close();
				else
					((OutlineDropdown)button).expand();
				updateDropdowns();
			}
		}
	}

	private void updateDropdowns()
	{
		partListTotalContentHeight = 0;
		int yOffset = 1 + partListScroll;
		for (OutlineDropdown<IStarshipPart> d : dropdownList)
		{
			d.yPosition = yOffset;
			yOffset += d.getHeight();
			partListTotalContentHeight += d.getHeight();
		}

		dropdownList.forEach(OutlineDropdown::updateChildren);
	}

	@Override
	public void handleMouseInput()
	{
		super.handleMouseInput();
	}

	@Override
	public void initGui()
	{
		r = new ScaledResolution(StarWarsMod.mc, StarWarsMod.mc.displayWidth, StarWarsMod.mc.displayHeight);

		int headerHeight = 10;
		int subHeight = 8;

		OutlineDropdown<IStarshipPart> bEngines = new OutlineDropdown<>(0, inwardness + 1, inwardness + 1, 100, headerHeight, 2, "Engines", false);
		dropdownList.add(bEngines);

		for (IStarshipPart part : ComponentBank.energyWeapons)
		{
			ArrayList<IStarshipPart> tags = new ArrayList<>();
			tags.add(part);
			OutlineDropdownItem<IStarshipPart> partOutlineDropdownItem = new OutlineDropdownItem<>(1, 0, 0, 100, subHeight, part.getPartDesignation(), false, tags);
			bEngines.addChild(partOutlineDropdownItem);
		}

		OutlineDropdown<IStarshipPart> bPowerPlants = new OutlineDropdown<>(0, inwardness + 1, inwardness + 1, 100, headerHeight, 2, "Power Plants", false);
		dropdownList.add(bPowerPlants);

		for (IStarshipPart part : ComponentBank.powerPlants)
		{
			ArrayList<IStarshipPart> tags = new ArrayList<>();
			tags.add(part);
			OutlineDropdownItem<IStarshipPart> partOutlineDropdownItem = new OutlineDropdownItem<>(1, 0, 0, 100, subHeight, part.getPartDesignation(), false, tags);
			bPowerPlants.addChild(partOutlineDropdownItem);
		}

		OutlineDropdown<IStarshipPart> bShields = new OutlineDropdown<>(0, inwardness + 1, inwardness + 1, 100, headerHeight, 2, "Shields", false);
		dropdownList.add(bShields);

		for (IStarshipPart part : ComponentBank.shields)
		{
			ArrayList<IStarshipPart> tags = new ArrayList<>();
			tags.add(part);
			OutlineDropdownItem<IStarshipPart> partOutlineDropdownItem = new OutlineDropdownItem<>(1, 0, 0, 100, subHeight, part.getPartDesignation(), false, tags);
			bShields.addChild(partOutlineDropdownItem);
		}

		OutlineDropdown<IStarshipPart> bTargetingComputers = new OutlineDropdown<>(0, inwardness + 1, inwardness + 1, 100, headerHeight, 2, "Targeting Computers", false);
		dropdownList.add(bTargetingComputers);

		for (IStarshipPart part : ComponentBank.targetingComputers)
		{
			ArrayList<IStarshipPart> tags = new ArrayList<>();
			tags.add(part);
			OutlineDropdownItem<IStarshipPart> partOutlineDropdownItem = new OutlineDropdownItem<>(1, 0, 0, 100, subHeight, part.getPartDesignation(), false, tags);
			bTargetingComputers.addChild(partOutlineDropdownItem);
		}

		OutlineDropdown<IStarshipPart> bEnergyWeapons = new OutlineDropdown<>(0, inwardness + 1, inwardness + 1, 100, headerHeight, 2, "Energy Weapons", false);
		dropdownList.add(bEnergyWeapons);

		for (IStarshipPart part : ComponentBank.energyWeapons)
		{
			ArrayList<IStarshipPart> tags = new ArrayList<>();
			tags.add(part);
			OutlineDropdownItem<IStarshipPart> partOutlineDropdownItem = new OutlineDropdownItem<>(1, 0, 0, 100, subHeight, part.getPartDesignation(), false, tags);
			bEnergyWeapons.addChild(partOutlineDropdownItem);
		}

		OutlineDropdown<IStarshipPart> bPhysicalWeapons = new OutlineDropdown<>(0, inwardness + 1, inwardness + 1, 100, headerHeight, 2, "Physical Weapons", false);
		dropdownList.add(bPhysicalWeapons);

		for (IStarshipPart part : ComponentBank.physicalWeapons)
		{
			ArrayList<IStarshipPart> tags = new ArrayList<>();
			tags.add(part);
			OutlineDropdownItem<IStarshipPart> partOutlineDropdownItem = new OutlineDropdownItem<>(1, 0, 0, 100, subHeight, part.getPartDesignation(), false, tags);
			bPhysicalWeapons.addChild(partOutlineDropdownItem);
		}

		OutlineDropdown<IStarshipPart> bHyperdrive = new OutlineDropdown<>(0, inwardness + 1, inwardness + 1, 100, headerHeight, 2, "Hyperdrives", false);
		dropdownList.add(bHyperdrive);

		for (IStarshipPart part : ComponentBank.hyperdrives)
		{
			ArrayList<IStarshipPart> tags = new ArrayList<>();
			tags.add(part);
			OutlineDropdownItem<IStarshipPart> partOutlineDropdownItem = new OutlineDropdownItem<>(1, 0, 0, 100, subHeight, part.getPartDesignation(), false, tags);
			bHyperdrive.addChild(partOutlineDropdownItem);
		}

		OutlineDropdown<IStarshipPart> bStealthTech = new OutlineDropdown<>(0, inwardness + 1, inwardness + 1, 100, headerHeight, 2, "Cloaking", false);
		dropdownList.add(bStealthTech);

		for (IStarshipPart part : ComponentBank.stealthTech)
		{
			ArrayList<IStarshipPart> tags = new ArrayList<>();
			tags.add(part);
			OutlineDropdownItem<IStarshipPart> partOutlineDropdownItem = new OutlineDropdownItem<>(1, 0, 0, 100, subHeight, part.getPartDesignation(), false, tags);
			bStealthTech.addChild(partOutlineDropdownItem);
		}

		updateDropdowns();

		partListRegion = new Rectangle(inwardness, inwardness, 102, 175);
	}

	@Override
	protected void mouseClicked(int mX, int mY, int button)
	{
		if (button == 0)
		{
			for (Object aButtonList : this.buttonList)
			{
				GuiButton guibutton = (GuiButton)aButtonList;

				if (guibutton.mousePressed(this.mc, mX, mY))
				{
					guibutton.func_146113_a(this.mc.getSoundHandler());
					this.actionPerformed(guibutton);
				}
			}

			for (OutlineDropdown<IStarshipPart> d : dropdownList)
			{
				if (d.mousePressed(this.mc, mX, mY) && partListRegion.contains(mX, mY))
				{
					d.func_146113_a(this.mc.getSoundHandler());
					this.actionPerformed(d);
				}

				d.getChildren().stream().filter(p -> p.mousePressed(this.mc, mX, mY) && partListRegion.contains(mX, mY)).forEach(p ->
				{
					p.func_146113_a(this.mc.getSoundHandler());
					this.actionPerformed(p);
				});
			}
		}
	}

	@Override
	protected void keyTyped(char p_73869_1_, int p_73869_2_)
	{
		if (p_73869_2_ == 1)
		{
			Vector3f originalPos = new Vector3f(StarWarsMod.cameraPosition);
			Vector2f originalRot = new Vector2f(StarWarsMod.cameraRotation);
			Animation cameraSwing = new Animation(20, false, true)
			{
				@Override
				public void render(RenderGameOverlayEvent event)
				{
					lerp = 1 - (getTick() + event.partialTicks) / (float)getLength();
					StarWarsMod.cameraPosition = originalPos.lerp(new Vector3f(StarWarsMod.mc.thePlayer.posX, StarWarsMod.mc.thePlayer.posY - 1.5f, StarWarsMod.mc.thePlayer.posZ), 1 - (lerp + 0.1f));
					StarWarsMod.cameraRotation = originalRot.lerp(new Vector2f(StarWarsMod.mc.thePlayer.rotationPitch, MathHelper.wrapAngleTo180_float(StarWarsMod.mc.thePlayer.rotationYaw)), 1 - (lerp + 0.1f));
				}
			};
			cameraSwing.setOnAnimationEnd(animation ->
			{
				this.mc.displayGuiScreen(null);
				this.mc.setIngameFocus();
				StarWarsMod.mc.renderViewEntity = StarWarsMod.mc.thePlayer;
				StarWarsMod.camera.setDead();
			});
			cameraSwing.start();
		}
	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}

	@Override
	public void drawScreen(int x, int y, float n)
	{
		GL11.glPushMatrix();

		GL11.glDisable(GL11.GL_LIGHTING); // fix for dimming bug!
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);

		GL11.glPushMatrix();
		GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);

		GL11.glTranslatef(r.getScaledWidth() / 2f * (1 - lerp), r.getScaledHeight() / 2f * (1 - lerp), 0);
		GL11.glScalef(lerp, lerp, 1);

		GLPalette.glColorI(GLPalette.ALMOST_BLACK, 0x55);
		GFX.drawRectangle(inwardness, inwardness, r.getScaledWidth() - 2 * inwardness, r.getScaledHeight() - 2 * inwardness, true);

		GLPalette.glColorI(GLPalette.SW_YELLOW);
		GFX.drawRectangle(inwardness, inwardness, r.getScaledWidth() - 2 * inwardness, r.getScaledHeight() - 2 * inwardness, false);

		handleScrolling(x, y);

		GL11.glTranslatef(0, 0, 5);

		for (Object aButtonList : this.buttonList)
			((GuiButton)aButtonList).drawButton(this.mc, x, y);

		GFX.rectangle(partListRegion.getX(), partListRegion.getY(), partListRegion.getWidth(), partListRegion.getHeight(), false);

		float contentSize = partListTotalContentHeight;
		float windowSize = partListRegion.getHeight();
		float trackSize = windowSize;

		float windowContentRatio = windowSize / contentSize;
		float gripSize = trackSize * windowContentRatio;

		float minimalGripSize = 20;
		float gripWidth = 3;

		if (gripSize < minimalGripSize)
			gripSize = minimalGripSize;
		if (gripSize > trackSize)
			gripSize = trackSize;

		float windowScrollAreaSize = contentSize - windowSize;
		float windowPosition = -partListScroll + 2.5f;
		float windowPositionRatio = windowPosition / windowScrollAreaSize;
		float trackScrollAreaSize = trackSize - gripSize;
		float gripPositionOnTrack = trackScrollAreaSize * windowPositionRatio;

		GFX.startGlScissor(partListRegion.getX() + 1, partListRegion.getY() + 1, partListRegion.getWidth() - 1 + (int)gripWidth, partListRegion.getHeight() - 2);
		GFX.rectangle(partListRegion.getX() + partListRegion.getWidth(), inwardness + gripPositionOnTrack, gripWidth, gripSize, true);
		for (OutlineDropdown d : dropdownList)
			d.drawButton(mc, x, y);
		GFX.endGlScissor();

		GL11.glPopMatrix();

		GL11.glDisable(GL11.GL_LINE_SMOOTH);
		GL11.glEnable(GL11.GL_LIGHTING); // end of fix

		GL11.glPopMatrix();
	}

	private void handleScrolling(int x, int y)
	{
		int dw = (int)Math.signum(Mouse.getDWheel()) * 5;

		if (partListRegion.contains(x, y))
		{
			if (partListTotalContentHeight > partListRegion.getHeight())
				partListScroll += dw;
			else if (partListScroll < 3)
				partListScroll = 3;

			if (partListScroll > 3)
				partListScroll = 3;

			int bottom = inwardness + partListScroll + partListTotalContentHeight - 1;

			if (partListTotalContentHeight > partListRegion.getHeight() && bottom < partListRegion.getX() + partListRegion.getHeight())
				partListScroll = -partListTotalContentHeight + partListRegion.getHeight() + 1;

			updateDropdowns();
		}
	}
}