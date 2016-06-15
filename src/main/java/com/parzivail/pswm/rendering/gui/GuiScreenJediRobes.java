package com.parzivail.pswm.rendering.gui;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.force.CronUtils;
import com.parzivail.pswm.force.powers.PowerBase;
import com.parzivail.pswm.jedi.JediUtils;
import com.parzivail.pswm.network.MessageHolocronRefreshPowers;
import com.parzivail.pswm.network.MessageHolocronSetActive;
import com.parzivail.pswm.network.MessageRobesIntNBT;
import com.parzivail.pswm.utils.ForceUtils;
import com.parzivail.util.ui.LangUtils;
import com.parzivail.util.ui.TextEffects;
import com.parzivail.util.ui.TextUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

@SideOnly(Side.CLIENT)
public class GuiScreenJediRobes extends GuiScreen
{
	private GuiSlotPowerList powerList;
	private int selected = -1;
	private GuiPowerListItem selectedPower;
	private int listWidth = 0;
	private ArrayList<String> powers;

	private GuiButton learnButton;
	private GuiButton enableButton;

	private ItemStack stack;
	private EntityPlayer player;

	private int points = 0;

	public GuiScreenJediRobes(EntityPlayer player)
	{
		this.mc = Minecraft.getMinecraft();
		this.stack = CronUtils.getHolocron(player);
		this.player = player;

		this.powers = ForceUtils.getPowersAvailableAtLevel(CronUtils.getSide(this.stack), (int)Math.floor(CronUtils.getLevel(this.stack) / JediUtils.POINTS_PER_LEVEL));

		this.points = CronUtils.getPoints(this.stack);
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if (button.enabled)
		{
			if (button.id == this.enableButton.id)
			{
				ForceUtils.activePower = this.selectedPower.power;
				CronUtils.setActive(this.mc.thePlayer, this.selectedPower.power);
				NBTTagCompound powers = CronUtils.compilePowers();
				powers.setTag(this.selectedPower.power.name, this.selectedPower.power.serialize());
				StarWarsMod.network.sendToServer(new MessageHolocronRefreshPowers(StarWarsMod.mc.thePlayer, powers));
				StarWarsMod.network.sendToServer(new MessageHolocronSetActive(StarWarsMod.mc.thePlayer, this.selectedPower.power.serialize()));
			}
			if (button.id == this.learnButton.id && this.selectedPower.power != null)
			{
				ForceUtils.getPowerFromName(this.selectedPower.power.name).currentLevel++;
				NBTTagCompound powers = CronUtils.compilePowers();
				powers.setTag(this.selectedPower.power.name, this.selectedPower.power.serialize());
				StarWarsMod.network.sendToServer(new MessageHolocronRefreshPowers(StarWarsMod.mc.thePlayer, powers));

				PowerBase active = CronUtils.getActive(StarWarsMod.mc.thePlayer);
				if (active != null && active.name.equals(this.selectedPower.power.name))
					StarWarsMod.network.sendToServer(new MessageHolocronSetActive(StarWarsMod.mc.thePlayer, this.selectedPower.power.serialize()));
				StarWarsMod.network.sendToServer(new MessageRobesIntNBT(StarWarsMod.mc.thePlayer, Resources.nbtRemainingPts, --this.points));
			}
		}
	}

	private boolean canLearn(PowerBase power)
	{
		return power != null && (power.currentLevel < power.maxLevel || power.maxLevel == -1) && this.points > 0;
	}

	public int drawLine(String line, int offset, int shifty)
	{
		this.fontRendererObj.drawString(line, offset, shifty, 0xd7edea);
		return shifty + 10;
	}

	/**
	 * Draws the screen and all the components in it.
	 */
	@Override
	public void drawScreen(int p_571_1_, int p_571_2_, float p_571_3_)
	{
		this.powerList.drawScreen(p_571_1_, p_571_2_, p_571_3_);
		int offset = (this.listWidth + this.width) / 2;
		int y = 5;
		this.drawCenteredString(this.fontRendererObj, String.format("Level %s %s ", (int)Math.floor(CronUtils.getLevel(this.stack) / JediUtils.POINTS_PER_LEVEL), ForceUtils.getTitle(JediUtils.getSide(this.stack), (int)Math.floor(JediUtils.getLevel(this.stack) / JediUtils.POINTS_PER_LEVEL))) + TextUtils.addEffect(this.player.getCommandSenderName(), JediUtils.getSide(this.stack).equals(JediUtils.SIDE_JEDI) ? TextEffects.COLOR_BLUE : TextEffects.COLOR_DARK_RED), offset, y += 10, 0xFFFFFF);
		this.drawCenteredString(this.fontRendererObj, String.format("%s available upgrade points", this.points), offset, y += 10, 0xFFFFFF);
		y += 10;
		if (this.selectedPower != null)
		{
			GL11.glEnable(GL11.GL_BLEND);
			this.drawCenteredString(this.fontRendererObj, TextUtils.makeUnderline(this.selectedPower.localizedName), offset, y += 10, 0xFFFFFF);
			this.drawCenteredString(this.fontRendererObj, String.format("Current Level: %s", this.selectedPower.power == null ? 0 : this.selectedPower.power.currentLevel), offset, y += 10, 0xFFFFFF);
			this.drawCenteredString(this.fontRendererObj, String.format("XP/use: %s", this.selectedPower.power == null ? 0 : this.selectedPower.power.getCost()), offset, y += 10, 0xFFFFFF);
			this.drawCenteredString(this.fontRendererObj, String.format("Recharge Time: %s seconds", this.selectedPower.power == null ? 0 : this.selectedPower.power.rechargeTime / 40f), offset, y += 10, 0xFFFFFF);
			this.drawCenteredString(this.fontRendererObj, "Description and Use:", offset, y += 10, 0xDDDDDD);
			this.fontRendererObj.drawSplitString(TextUtils.makeItalic(this.selectedPower.localizedDesc), offset - 125, y + 20, 250, 0xDDDDDD);
			GL11.glDisable(GL11.GL_BLEND);

			if (this.selectedPower.power != null)
			{
				boolean is_power_active = false;
				PowerBase power;
				if ((power = CronUtils.getActive(StarWarsMod.mc.thePlayer)) != null)
					is_power_active = power.name.equals(this.selectedPower.power.name);
				this.enableButton.enabled = this.selectedPower.power.currentLevel > 0 && !is_power_active;
				this.learnButton.enabled = this.canLearn(this.selectedPower.power);
			}
		}
		else
		{
			this.learnButton.enabled = false;
			this.enableButton.enabled = false;
		}
		super.drawScreen(p_571_1_, p_571_2_, p_571_3_);
	}

	FontRenderer getFontRenderer()
	{
		/** The FontRenderer used by GuiScreen */
		return this.fontRendererObj;
	}

	Minecraft getMinecraftInstance()
	{
		/** Reference to the Minecraft object. */
		return this.mc;
	}

	boolean indexSelected(int var1)
	{
		return var1 == this.selected;
	}

	/**
	 * Adds the buttons (and other controls) to the screen in question.
	 */
	@Override
	public void initGui()
	{
		ArrayList<GuiPowerListItem> items = new ArrayList<>();

		this.listWidth = 100;

		for (String power : this.powers)
		{
			GuiPowerListItem item = new GuiPowerListItem();
			item.localizedName = LangUtils.translate("force.power." + power);
			item.localizedDesc = LangUtils.translate("force.power." + power + ".desc");

			if (this.stack != null)
			{
				item.power = ForceUtils.getPowerFromName(power);
				if (item.power != null)
					item.power.currentLevel = CronUtils.getLevelOf(this.stack, item.power.name);
			}

			items.add(item);
		}

		this.powerList = new GuiSlotPowerList(this, items, this.listWidth);
		this.powerList.registerScrollButtons(this.buttonList, 7, 8);

		this.learnButton = new GuiButton(20, 10, this.height - 60, this.listWidth, 20, "Study");
		this.enableButton = new GuiButton(21, 10, this.height - 38, this.listWidth, 20, "Wield");
		this.buttonList.add(this.learnButton);
		this.buttonList.add(this.enableButton);
	}

	/**
	 * @param var1 The index to select
	 */
	void selectIndex(int var1)
	{
		this.selected = var1;
		if (var1 >= 0 && var1 <= this.powerList.getSize())
			this.selectedPower = this.powerList.powers.get(this.selected);
		else
			this.selectedPower = null;
	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}
}