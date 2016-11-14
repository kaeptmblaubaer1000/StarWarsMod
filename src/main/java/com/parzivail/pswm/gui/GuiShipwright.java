package com.parzivail.pswm.gui;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.customship.ComponentBank;
import com.parzivail.pswm.customship.IStarshipPart;
import com.parzivail.pswm.customship.ManufacturerBank;
import com.parzivail.util.lwjgl.Vector2f;
import com.parzivail.util.lwjgl.Vector3f;
import com.parzivail.util.math.Animation;
import com.parzivail.util.ui.*;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
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
	private OutlineButton bCustomLeft;
	private OutlineButton bCustomRight;
	private OutlineButton bPaintjobLeft;
	private OutlineButton bPaintjobRight;

	private int indexCustom = 0;
	private int maxCustom = 3;
	private int indexPaintjob = 0;
	private int maxPaintjob = 3;

	private static Rectangle partListRegion;
	private static Rectangle extrasRegion;
	private static Rectangle partInfoRegion;
	private static Rectangle shipInfoRegion;
	private static Rectangle shipNameRegion;
	private static FixedSize partListSize;
	private static FixedSize extrasSize;
	private static FixedSize partInfoSize;
	private static FixedSize shipInfoSize;
	private static FixedSize shipNameSize;
	private int partListScroll = 3;
	private int partListTotalContentHeight;

	private IStarshipPart currentPartInfo;

	public GuiShipwright(EntityPlayer player)
	{
		this.player = player;
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
			else if (button instanceof OutlineDropdownItem)
			{
				OutlineDropdownItem b = ((OutlineDropdownItem)button);
				if (!b.getTags().isEmpty() && b.getTags().get(0) instanceof IStarshipPart)
				{
					IStarshipPart part = (IStarshipPart)b.getTags().get(0);
					showInfoFor(part);
				}
			}
			else if (button.id == bCustomLeft.id && maxCustom > 0)
				indexCustom = wrap(-1, indexCustom, maxCustom);
			else if (button.id == bCustomRight.id && maxCustom > 0)
				indexCustom = wrap(1, indexCustom, maxCustom);
			else if (button.id == bPaintjobLeft.id && maxPaintjob > 0)
				indexPaintjob = wrap(-1, indexPaintjob, maxPaintjob);
			else if (button.id == bPaintjobRight.id && maxPaintjob > 0)
				indexPaintjob = wrap(1, indexPaintjob, maxPaintjob);
		}
	}

	private void showInfoFor(IStarshipPart part)
	{
		currentPartInfo = part;
	}

	private int wrap(int add, int current, int max)
	{
		int n = current + add;
		if (n < 0)
			n = max - 1;
		else if (n >= max)
			n = 0;
		return n;
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
		float w = r.getScaledWidth() - 2 * inwardness;
		float h = r.getScaledHeight() - 2 * inwardness;

		int headerHeight = 8;
		int subHeight = 8;
		int dropdownIndent = 0;
		String dropdownItemPrefix = "> ";
		int dropdownHoverIndent = 1;
		int id = 0;

		dropdownList.clear();

		OutlineDropdown<IStarshipPart> bEngines = new OutlineDropdown<>(id++, inwardness + 1, inwardness + 1, 100, headerHeight, dropdownIndent, "Engines", false);
		dropdownList.add(bEngines);

		for (IStarshipPart part : ComponentBank.energyWeapons)
		{
			ArrayList<IStarshipPart> tags = new ArrayList<>();
			tags.add(part);
			OutlineDropdownItem<IStarshipPart> partOutlineDropdownItem = new OutlineDropdownItem<>(id++, 0, 0, 100, subHeight, part.getPartDesignation(), false, tags, dropdownItemPrefix, dropdownHoverIndent);
			bEngines.addChild(partOutlineDropdownItem);
		}

		OutlineDropdown<IStarshipPart> bPowerPlants = new OutlineDropdown<>(id++, inwardness + 1, inwardness + 1, 100, headerHeight, dropdownIndent, "Power Plants", false);
		dropdownList.add(bPowerPlants);

		for (IStarshipPart part : ComponentBank.powerPlants)
		{
			ArrayList<IStarshipPart> tags = new ArrayList<>();
			tags.add(part);
			OutlineDropdownItem<IStarshipPart> partOutlineDropdownItem = new OutlineDropdownItem<>(id++, 0, 0, 100, subHeight, part.getPartDesignation(), false, tags, dropdownItemPrefix, dropdownHoverIndent);
			bPowerPlants.addChild(partOutlineDropdownItem);
		}

		OutlineDropdown<IStarshipPart> bShields = new OutlineDropdown<>(id++, inwardness + 1, inwardness + 1, 100, headerHeight, dropdownIndent, "Shields", false);
		dropdownList.add(bShields);

		for (IStarshipPart part : ComponentBank.shields)
		{
			ArrayList<IStarshipPart> tags = new ArrayList<>();
			tags.add(part);
			OutlineDropdownItem<IStarshipPart> partOutlineDropdownItem = new OutlineDropdownItem<>(id++, 0, 0, 100, subHeight, part.getPartDesignation(), false, tags, dropdownItemPrefix, dropdownHoverIndent);
			bShields.addChild(partOutlineDropdownItem);
		}

		OutlineDropdown<IStarshipPart> bTargetingComputers = new OutlineDropdown<>(id++, inwardness + 1, inwardness + 1, 100, headerHeight, dropdownIndent, "Targeting Computers", false);
		dropdownList.add(bTargetingComputers);

		for (IStarshipPart part : ComponentBank.targetingComputers)
		{
			ArrayList<IStarshipPart> tags = new ArrayList<>();
			tags.add(part);
			OutlineDropdownItem<IStarshipPart> partOutlineDropdownItem = new OutlineDropdownItem<>(id++, 0, 0, 100, subHeight, part.getPartDesignation(), false, tags, dropdownItemPrefix, dropdownHoverIndent);
			bTargetingComputers.addChild(partOutlineDropdownItem);
		}

		OutlineDropdown<IStarshipPart> bEnergyWeapons = new OutlineDropdown<>(id++, inwardness + 1, inwardness + 1, 100, headerHeight, dropdownIndent, "Energy Weapons", false);
		dropdownList.add(bEnergyWeapons);

		for (IStarshipPart part : ComponentBank.energyWeapons)
		{
			ArrayList<IStarshipPart> tags = new ArrayList<>();
			tags.add(part);
			OutlineDropdownItem<IStarshipPart> partOutlineDropdownItem = new OutlineDropdownItem<>(id++, 0, 0, 100, subHeight, part.getPartDesignation(), false, tags, dropdownItemPrefix, dropdownHoverIndent);
			bEnergyWeapons.addChild(partOutlineDropdownItem);
		}

		OutlineDropdown<IStarshipPart> bPhysicalWeapons = new OutlineDropdown<>(id++, inwardness + 1, inwardness + 1, 100, headerHeight, dropdownIndent, "Physical Weapons", false);
		dropdownList.add(bPhysicalWeapons);

		for (IStarshipPart part : ComponentBank.physicalWeapons)
		{
			ArrayList<IStarshipPart> tags = new ArrayList<>();
			tags.add(part);
			OutlineDropdownItem<IStarshipPart> partOutlineDropdownItem = new OutlineDropdownItem<>(id++, 0, 0, 100, subHeight, part.getPartDesignation(), false, tags, dropdownItemPrefix, dropdownHoverIndent);
			bPhysicalWeapons.addChild(partOutlineDropdownItem);
		}

		OutlineDropdown<IStarshipPart> bHyperdrive = new OutlineDropdown<>(id++, inwardness + 1, inwardness + 1, 100, headerHeight, dropdownIndent, "Hyperdrives", false);
		dropdownList.add(bHyperdrive);

		for (IStarshipPart part : ComponentBank.hyperdrives)
		{
			ArrayList<IStarshipPart> tags = new ArrayList<>();
			tags.add(part);
			OutlineDropdownItem<IStarshipPart> partOutlineDropdownItem = new OutlineDropdownItem<>(id++, 0, 0, 100, subHeight, part.getPartDesignation(), false, tags, dropdownItemPrefix, dropdownHoverIndent);
			bHyperdrive.addChild(partOutlineDropdownItem);
		}

		OutlineDropdown<IStarshipPart> bStealthTech = new OutlineDropdown<>(id++, inwardness + 1, inwardness + 1, 100, headerHeight, dropdownIndent, "Cloaking", false);
		dropdownList.add(bStealthTech);

		for (IStarshipPart part : ComponentBank.stealthTech)
		{
			ArrayList<IStarshipPart> tags = new ArrayList<>();
			tags.add(part);
			OutlineDropdownItem<IStarshipPart> partOutlineDropdownItem = new OutlineDropdownItem<>(id++, 0, 0, 100, subHeight, part.getPartDesignation(), false, tags, dropdownItemPrefix, dropdownHoverIndent);
			bStealthTech.addChild(partOutlineDropdownItem);
		}

		updateDropdowns();

		partListSize = new FixedSize(0.22f, 0.75f);
		extrasSize = new FixedSize(0.22f, 0.25f);
		partInfoSize = new FixedSize(0.58f, 0.25f);
		shipInfoSize = new FixedSize(0.2f, 0.25f);
		shipNameSize = new FixedSize(0.25f, 0.05f);

		partListRegion = new Rectangle(inwardness, inwardness, (int)(w * partInfoSize.getWPercent()), (int)(h * partInfoSize.getHPercent()));
		extrasRegion = new Rectangle(inwardness, inwardness + partListRegion.getHeight(), (int)(w * extrasSize.getWPercent()), (int)(h * extrasSize.getHPercent()));
		partInfoRegion = new Rectangle(inwardness, inwardness + partListRegion.getHeight(), (int)(w * partInfoSize.getWPercent()), (int)(h * partInfoSize.getHPercent()));

		bCustomLeft = new OutlineButton(id++, inwardness + 5, inwardness + partListRegion.getHeight() + 5, 8, 15, "<", false);
		bCustomRight = new OutlineButton(id++, inwardness + 89, inwardness + partListRegion.getHeight() + 5, 8, 15, ">", false);
		bPaintjobLeft = new OutlineButton(id++, inwardness + 5, inwardness + partListRegion.getHeight() + 25, 8, 15, "<", false);
		bPaintjobRight = new OutlineButton(id++, inwardness + 89, inwardness + partListRegion.getHeight() + 25, 8, 15, ">", false);
		buttonList.add(bCustomLeft);
		buttonList.add(bCustomRight);
		buttonList.add(bPaintjobLeft);
		buttonList.add(bPaintjobRight);
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

		GL11.glPushMatrix();

		GLPalette.glColorI(GLPalette.ALMOST_BLACK, 0x88);
		GFX.drawRectangle(inwardness, inwardness, r.getScaledWidth() - 2 * inwardness, r.getScaledHeight() - 2 * inwardness, true);

		GLPalette.glColorI(GLPalette.SW_YELLOW);
		GFX.drawRectangle(inwardness, inwardness, r.getScaledWidth() - 2 * inwardness, r.getScaledHeight() - 2 * inwardness, false);

		GL11.glLineWidth(2);

		handleScrolling(x, y);

		/*
			Draw Custom Part / Paintjob region
		 */
		GLPalette.glColorI(GLPalette.SW_YELLOW);
		GFX.rectangle(inwardness, inwardness + partListRegion.getHeight(), 102, 74, false);

		GFX.drawCenteredText(mc.fontRenderer, "Hull #" + String.valueOf(indexCustom + 1), (bCustomLeft.xPosition + bPaintjobLeft.width + bPaintjobRight.xPosition) / 2f, bCustomLeft.yPosition + 4, 1, GLPalette.WHITE);
		GFX.drawCenteredText(mc.fontRenderer, "Paint Job #" + String.valueOf(indexPaintjob + 1), (bCustomLeft.xPosition + bPaintjobLeft.width + bPaintjobRight.xPosition) / 2f, bPaintjobLeft.yPosition + 4, 1, GLPalette.WHITE);

		/*
			Draw Part Info region
		 */
		GLPalette.glColorI(GLPalette.SW_YELLOW);
		GFX.rectangle(inwardness + 102, inwardness + partListRegion.getHeight(), 372, 74, false);

		if (currentPartInfo != null)
		{
			ResourceLocation logoTexture = ManufacturerBank.LOGOS.get(currentPartInfo.getPartManufacturer());
			GFX.renderImage(logoTexture, inwardness + 104, inwardness + partListRegion.getHeight() + 19, 37.5f, 37.5f);
			GFX.rectangle(inwardness + 104, inwardness + partListRegion.getHeight() + 19, 37.5f, 37.5f, false);

			GFX.drawText(mc.fontRenderer, currentPartInfo.getPartDesignation(), inwardness + 144, inwardness + partListRegion.getHeight() + 2, 1, GLPalette.WHITE);

			GFX.drawText(mc.fontRenderer, "Manufacturer:", inwardness + 144, inwardness + partListRegion.getHeight() + 12, 0.5f, GLPalette.SW_YELLOW);
			GFX.drawText(mc.fontRenderer, currentPartInfo.getPartManufacturer(), inwardness + 184, inwardness + partListRegion.getHeight() + 12, 0.5f, GLPalette.WHITE);

			GFX.drawText(mc.fontRenderer, "Weight:", inwardness + 144, inwardness + partListRegion.getHeight() + 19, 0.5f, GLPalette.SW_YELLOW);
			GFX.drawText(mc.fontRenderer, String.format("%s kg", currentPartInfo.getWeight()), inwardness + 184, inwardness + partListRegion.getHeight() + 19, 0.5f, GLPalette.WHITE);
		}

		/*
			Draw part region
		 */
		GFX.rectangle(partListRegion.getX(), partListRegion.getY(), partListRegion.getWidth(), partListRegion.getHeight(), false);

		float contentSize = partListTotalContentHeight;
		float windowSize = partListRegion.getHeight();
		float trackSize = windowSize;
		float minimalGripSize = 20;
		float gripWidth = 2;

		GFX.startGlScissor(partListRegion.getX() + 1, partListRegion.getY() + 1, partListRegion.getWidth() - 1 + (int)gripWidth, partListRegion.getHeight() - 2);
		drawScrollbar(contentSize, windowSize, trackSize, minimalGripSize, gripWidth);
		for (OutlineDropdown d : dropdownList)
			d.drawButton(mc, x, y);
		GFX.endGlScissor();

		GL11.glPushMatrix();
		GL11.glTranslatef(0, 0, 5);

		for (Object aButtonList : this.buttonList)
			((GuiButton)aButtonList).drawButton(this.mc, x, y);
		GL11.glPopMatrix();

		GL11.glPopMatrix();

		GL11.glPopMatrix();

		GL11.glDisable(GL11.GL_LINE_SMOOTH);
		GL11.glEnable(GL11.GL_LIGHTING); // end of fix

		GL11.glPopMatrix();
	}

	private void drawScrollbar(float contentSize, float windowSize, float trackSize, float minimalGripSize, float gripWidth)
	{
		float windowContentRatio = windowSize / contentSize;
		float gripSize = trackSize * windowContentRatio;

		if (gripSize < minimalGripSize)
			gripSize = minimalGripSize;
		if (gripSize > trackSize)
			gripSize = trackSize;

		float windowScrollAreaSize = contentSize - windowSize;
		float windowPosition = -partListScroll + 2.5f;
		float windowPositionRatio = windowPosition / windowScrollAreaSize;
		float trackScrollAreaSize = trackSize - gripSize;
		float gripPositionOnTrack = trackScrollAreaSize * windowPositionRatio;

		GFX.rectangle(partListRegion.getX() + partListRegion.getWidth(), inwardness + gripPositionOnTrack, gripWidth, gripSize, true);
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