package com.parzivail.pswm.gui;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.customship.*;
import com.parzivail.util.driven.Pilotable;
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
	private int partListScroll = 0;
	private int partListTotalContentHeight;

	private Pilotable ship;

	private IStarshipPart currentPartInfo;
	ArrayList<Tuple<String, String>> infos = new ArrayList<>();

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

		infos.clear();

		infos.add(new Tuple<>("Manufacturer", currentPartInfo.getPartManufacturer()));
		infos.add(new Tuple<>("Weight", currentPartInfo.getWeight() + "kg"));

		if (currentPartInfo instanceof DSublightEngine)
		{
			infos.add(new Tuple<>("EU/t Idle", ((DSublightEngine)currentPartInfo).getEnergyIdle() + "eu"));
			infos.add(new Tuple<>("EU/t Full Thrust", ((DSublightEngine)currentPartInfo).getEnergyFull() + "eu"));
			infos.add(new Tuple<>("Max Speed", ((DSublightEngine)currentPartInfo).getSpeed() + "kph"));
		}
		else if (currentPartInfo instanceof DPowerPlant)
		{
			infos.add(new Tuple<>("EU/t Produce", ((DPowerPlant)currentPartInfo).getAmbientPowerGeneration() + "eu"));
		}
		else if (currentPartInfo instanceof DShield)
		{
			infos.add(new Tuple<>("EU/t Consume", ((DShield)currentPartInfo).getEnergyPerTick() + "eu"));
			infos.add(new Tuple<>("Durability", ((DShield)currentPartInfo).getShieldDurability() + "sbd"));
		}
		else if (currentPartInfo instanceof DTargetingComputer)
		{
			infos.add(new Tuple<>("EU/t Consume", ((DTargetingComputer)currentPartInfo).getEnergyPerTick() + "eu"));
			infos.add(new Tuple<>("Range", ((DTargetingComputer)currentPartInfo).getRange() + "m"));
		}
		else if (currentPartInfo instanceof DEnergyWeapon)
		{
			infos.add(new Tuple<>("EU/shot", ((DEnergyWeapon)currentPartInfo).getPowerDrainPerUse(ship) + "eu"));
		}
		else if (currentPartInfo instanceof DHyperdrive)
		{
			infos.add(new Tuple<>("Class", String.valueOf(((DHyperdrive)currentPartInfo).getHyperdriveClass())));
		}
		else if (currentPartInfo instanceof DStealthTech)
		{
			infos.add(new Tuple<>("EU/t Active", ((DStealthTech)currentPartInfo).getEnergyPerTick() + "eu"));
			infos.add(new Tuple<>("Cloaking Time", ((DStealthTech)currentPartInfo).getCloakingTime() + "s"));
			infos.add(new Tuple<>("Visible (Players)", ((DStealthTech)currentPartInfo).isVisibleToPlayers() ? "Yes" : "No"));
			infos.add(new Tuple<>("Visible (Radar)", ((DStealthTech)currentPartInfo).isVisibleToRadar() ? "Yes" : "No"));
		}
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
		partListTotalContentHeight = 2;
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
		float w = r.getScaledWidth();
		float h = r.getScaledHeight();

		partListSize = new FixedSize(0.22f, 0.75f);
		extrasSize = new FixedSize(0.22f, 0.25f);
		partInfoSize = new FixedSize(0.58f, 0.25f);
		shipInfoSize = new FixedSize(0.2f, 0.25f);
		shipNameSize = new FixedSize(0.25f, 0.05f);

		partListRegion = new Rectangle(0, 0, (int)(w * partListSize.getWPercent()), (int)(h * partListSize.getHPercent()));
		extrasRegion = new Rectangle(0, partListRegion.getHeight(), (int)(w * extrasSize.getWPercent()), (int)(h * extrasSize.getHPercent()));
		partInfoRegion = new Rectangle(extrasRegion.getWidth(), partListRegion.getHeight(), (int)(w * partInfoSize.getWPercent()), (int)(h * partInfoSize.getHPercent()));
		shipInfoRegion = new Rectangle(extrasRegion.getWidth() + partInfoRegion.getWidth(), partListRegion.getHeight(), (int)(w * shipInfoSize.getWPercent()), (int)(h * shipInfoSize.getHPercent()));
		shipNameRegion = new Rectangle(partListRegion.getWidth(), partListRegion.getHeight(), (int)(w * shipNameSize.getWPercent()), (int)(h * shipNameSize.getHPercent()));

		int headerHeight = 8;
		int subHeight = 8;
		int dropdownIndent = 0;
		String dropdownItemPrefix = "> ";
		int dropdownHoverIndent = 1;
		int id = 0;
		int dropdownWidth = partListRegion.getWidth() - 2;

		dropdownList.clear();

		OutlineDropdown<IStarshipPart> bEngines = new OutlineDropdown<>(id++, 1, 1, dropdownWidth, headerHeight, dropdownIndent, "Engines", false);
		dropdownList.add(bEngines);

		for (IStarshipPart part : ComponentBank.sublightEngines)
		{
			ArrayList<IStarshipPart> tags = new ArrayList<>();
			tags.add(part);
			OutlineDropdownItem<IStarshipPart> partOutlineDropdownItem = new OutlineDropdownItem<>(id++, 0, 0, dropdownWidth, subHeight, part.getPartDesignation(), false, tags, dropdownItemPrefix, dropdownHoverIndent);
			bEngines.addChild(partOutlineDropdownItem);
		}

		OutlineDropdown<IStarshipPart> bPowerPlants = new OutlineDropdown<>(id++, 1, 1, dropdownWidth, headerHeight, dropdownIndent, "Power Plants", false);
		dropdownList.add(bPowerPlants);

		for (IStarshipPart part : ComponentBank.powerPlants)
		{
			ArrayList<IStarshipPart> tags = new ArrayList<>();
			tags.add(part);
			OutlineDropdownItem<IStarshipPart> partOutlineDropdownItem = new OutlineDropdownItem<>(id++, 0, 0, dropdownWidth, subHeight, part.getPartDesignation(), false, tags, dropdownItemPrefix, dropdownHoverIndent);
			bPowerPlants.addChild(partOutlineDropdownItem);
		}

		OutlineDropdown<IStarshipPart> bShields = new OutlineDropdown<>(id++, 1, 1, dropdownWidth, headerHeight, dropdownIndent, "Shields", false);
		dropdownList.add(bShields);

		for (IStarshipPart part : ComponentBank.shields)
		{
			ArrayList<IStarshipPart> tags = new ArrayList<>();
			tags.add(part);
			OutlineDropdownItem<IStarshipPart> partOutlineDropdownItem = new OutlineDropdownItem<>(id++, 0, 0, dropdownWidth, subHeight, part.getPartDesignation(), false, tags, dropdownItemPrefix, dropdownHoverIndent);
			bShields.addChild(partOutlineDropdownItem);
		}

		OutlineDropdown<IStarshipPart> bTargetingComputers = new OutlineDropdown<>(id++, 1, 1, dropdownWidth, headerHeight, dropdownIndent, "Targeting Computers", false);
		dropdownList.add(bTargetingComputers);

		for (IStarshipPart part : ComponentBank.targetingComputers)
		{
			ArrayList<IStarshipPart> tags = new ArrayList<>();
			tags.add(part);
			OutlineDropdownItem<IStarshipPart> partOutlineDropdownItem = new OutlineDropdownItem<>(id++, 0, 0, dropdownWidth, subHeight, part.getPartDesignation(), false, tags, dropdownItemPrefix, dropdownHoverIndent);
			bTargetingComputers.addChild(partOutlineDropdownItem);
		}

		OutlineDropdown<IStarshipPart> bEnergyWeapons = new OutlineDropdown<>(id++, 1, 1, dropdownWidth, headerHeight, dropdownIndent, "Energy Weapons", false);
		dropdownList.add(bEnergyWeapons);

		for (IStarshipPart part : ComponentBank.energyWeapons)
		{
			ArrayList<IStarshipPart> tags = new ArrayList<>();
			tags.add(part);
			OutlineDropdownItem<IStarshipPart> partOutlineDropdownItem = new OutlineDropdownItem<>(id++, 0, 0, dropdownWidth, subHeight, part.getPartDesignation(), false, tags, dropdownItemPrefix, dropdownHoverIndent);
			bEnergyWeapons.addChild(partOutlineDropdownItem);
		}

		OutlineDropdown<IStarshipPart> bPhysicalWeapons = new OutlineDropdown<>(id++, 1, 1, dropdownWidth, headerHeight, dropdownIndent, "Physical Weapons", false);
		dropdownList.add(bPhysicalWeapons);

		for (IStarshipPart part : ComponentBank.physicalWeapons)
		{
			ArrayList<IStarshipPart> tags = new ArrayList<>();
			tags.add(part);
			OutlineDropdownItem<IStarshipPart> partOutlineDropdownItem = new OutlineDropdownItem<>(id++, 0, 0, dropdownWidth, subHeight, part.getPartDesignation(), false, tags, dropdownItemPrefix, dropdownHoverIndent);
			bPhysicalWeapons.addChild(partOutlineDropdownItem);
		}

		OutlineDropdown<IStarshipPart> bHyperdrive = new OutlineDropdown<>(id++, 1, 1, dropdownWidth, headerHeight, dropdownIndent, "Hyperdrives", false);
		dropdownList.add(bHyperdrive);

		for (IStarshipPart part : ComponentBank.hyperdrives)
		{
			ArrayList<IStarshipPart> tags = new ArrayList<>();
			tags.add(part);
			OutlineDropdownItem<IStarshipPart> partOutlineDropdownItem = new OutlineDropdownItem<>(id++, 0, 0, dropdownWidth, subHeight, part.getPartDesignation(), false, tags, dropdownItemPrefix, dropdownHoverIndent);
			bHyperdrive.addChild(partOutlineDropdownItem);
		}

		OutlineDropdown<IStarshipPart> bStealthTech = new OutlineDropdown<>(id++, 1, 1, dropdownWidth, headerHeight, dropdownIndent, "Cloaking", false);
		dropdownList.add(bStealthTech);

		for (IStarshipPart part : ComponentBank.stealthTech)
		{
			ArrayList<IStarshipPart> tags = new ArrayList<>();
			tags.add(part);
			OutlineDropdownItem<IStarshipPart> partOutlineDropdownItem = new OutlineDropdownItem<>(id++, 0, 0, dropdownWidth, subHeight, part.getPartDesignation(), false, tags, dropdownItemPrefix, dropdownHoverIndent);
			bStealthTech.addChild(partOutlineDropdownItem);
		}

		updateDropdowns();

		bCustomLeft = new OutlineButton(id++, 5, partListRegion.getHeight() + 5, 8, 15, "<", false);
		bCustomRight = new OutlineButton(id++, 89, partListRegion.getHeight() + 5, 8, 15, ">", false);
		bPaintjobLeft = new OutlineButton(id++, 5, partListRegion.getHeight() + 25, 8, 15, "<", false);
		bPaintjobRight = new OutlineButton(id++, 89, partListRegion.getHeight() + 25, 8, 15, ">", false);
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

		//GLPalette.glColorI(GLPalette.ALMOST_BLACK, 0x88);
		//GFX.drawRectangle(inwardness, inwardness, r.getScaledWidth() - 2 * inwardness, r.getScaledHeight() - 2 * inwardness, true);

		//GLPalette.glColorI(GLPalette.SW_YELLOW);
		//GFX.drawRectangle(inwardness, inwardness, r.getScaledWidth() - 2 * inwardness, r.getScaledHeight() - 2 * inwardness, false);

		int GUI_BG = GLPalette.ALMOST_BLACK;
		int GUI_FG = GLPalette.SW_YELLOW;

		GL11.glLineWidth(2);

		handleScrolling(x, y);

		/*
			Draw Custom Part / Paintjob region
		 */
		GLPalette.glColorI(GUI_BG, 0x88);
		GFX.rectangle(extrasRegion, true);
		GLPalette.glColorI(GUI_FG);
		GFX.rectangle(extrasRegion, false);

		GFX.scissor(extrasRegion);

		GFX.drawCenteredText(mc.fontRenderer, "Hull #" + String.valueOf(indexCustom + 1), (bCustomLeft.xPosition + bPaintjobLeft.width + bPaintjobRight.xPosition) / 2f, bCustomLeft.yPosition + 4, 1, GLPalette.WHITE);
		GFX.drawCenteredText(mc.fontRenderer, "Paint Job #" + String.valueOf(indexPaintjob + 1), (bCustomLeft.xPosition + bPaintjobLeft.width + bPaintjobRight.xPosition) / 2f, bPaintjobLeft.yPosition + 4, 1, GLPalette.WHITE);

		GFX.endScissor();

		/*
			Draw Part Info region
		 */
		GLPalette.glColorI(GUI_BG, 0x88);
		GFX.rectangle(partInfoRegion, true);
		GLPalette.glColorI(GUI_FG);
		GFX.rectangle(partInfoRegion, false);

		GFX.scissor(partInfoRegion);

		if (currentPartInfo != null)
		{
			float tS = partInfoRegion.getHeight() - 4;
			float tX = extrasRegion.getWidth() + 2;
			float tY = partListRegion.getHeight() + 2;
			ResourceLocation logoTexture = ManufacturerBank.LOGOS.get(currentPartInfo.getPartManufacturer());
			GFX.renderImage(logoTexture, tX, tY, tS, tS);
			GFX.rectangle(tX, tY, tS, tS, false);

			GFX.drawText(mc.fontRenderer, currentPartInfo.getPartDesignation(), tX + tS + 2, partListRegion.getHeight() + 2, 1, GLPalette.WHITE);

			int cY = partListRegion.getHeight() + 2 + mc.fontRenderer.FONT_HEIGHT + 4;
			//int cX =
			for (Tuple<String, String> info : infos)
			{
				GFX.drawText(mc.fontRenderer, info.getA(), tX + tS + 2, cY, 0.5f, GLPalette.SW_YELLOW);
				GFX.drawText(mc.fontRenderer, info.getB(), partInfoRegion.getX() + partInfoRegion.getWidth() - mc.fontRenderer.getStringWidth(info.getB()) / 2f - 2, cY, 0.5f, GLPalette.WHITE);

				GLPalette.glColorI(GLPalette.SW_YELLOW);
				GL11.glLineWidth(1);
				GFX.drawLine(tX + tS + 2 + mc.fontRenderer.getStringWidth(info.getA()) / 2f + 2, cY + mc.fontRenderer.FONT_HEIGHT / 3f, partInfoRegion.getX() + partInfoRegion.getWidth() - mc.fontRenderer.getStringWidth(info.getB()) / 2f - 4, cY + mc.fontRenderer.FONT_HEIGHT / 3f);
				GL11.glLineWidth(2);
				cY += mc.fontRenderer.FONT_HEIGHT / 2f + 4;
			}
		}

		GFX.endScissor();

		/*
			Draw part list region
		 */
		GLPalette.glColorI(GUI_BG, 0x88);
		GFX.rectangle(partListRegion, true);
		GLPalette.glColorI(GUI_FG);
		GFX.rectangle(partListRegion, false);

		float contentSize = partListTotalContentHeight;
		float windowSize = partListRegion.getHeight();
		float trackSize = windowSize;
		float minimalGripSize = 20;
		float gripWidth = 2;

		GFX.scissor(partListRegion.getX() + 1, partListRegion.getY() + 1, partListRegion.getWidth() - 1 + (int)gripWidth, partListRegion.getHeight() - 2);
		drawScrollbar(contentSize, windowSize, trackSize, minimalGripSize, gripWidth);
		for (OutlineDropdown d : dropdownList)
			d.drawButton(mc, x, y);
		GFX.endScissor();

		/*
			Draw Ship Info
		 */
		GLPalette.glColorI(GUI_BG, 0x88);
		GFX.rectangle(shipInfoRegion, true);
		GLPalette.glColorI(GUI_FG);
		GFX.rectangle(shipInfoRegion, false);

		GFX.scissor(shipInfoRegion);

		GFX.endScissor();

		/*
			Draw MC buttons, etc.
		 */
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
		float windowPosition = -partListScroll;
		float windowPositionRatio = windowPosition / windowScrollAreaSize;
		float trackScrollAreaSize = trackSize - gripSize;
		float gripPositionOnTrack = trackScrollAreaSize * windowPositionRatio;

		GFX.rectangle(partListRegion.getX() + partListRegion.getWidth(), gripPositionOnTrack - 2, gripWidth, gripSize + 2, true);
	}

	private void handleScrolling(int x, int y)
	{
		int dw = (int)Math.signum(Mouse.getDWheel()) * 5;

		if (partListRegion.contains(x, y))
		{
			if (partListTotalContentHeight > partListRegion.getHeight())
				partListScroll += dw;
			else if (partListScroll < 0)
				partListScroll = 0;

			if (partListScroll > 0)
				partListScroll = 0;

			int bottom = partListScroll + partListTotalContentHeight - 1;

			if (partListTotalContentHeight > partListRegion.getHeight() && bottom < partListRegion.getX() + partListRegion.getHeight())
				partListScroll = -partListTotalContentHeight + partListRegion.getHeight() + 1;

			updateDropdowns();
		}
	}
}