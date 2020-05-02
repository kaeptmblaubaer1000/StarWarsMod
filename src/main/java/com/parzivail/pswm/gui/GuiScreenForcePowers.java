package com.parzivail.pswm.gui;

import com.parzivail.pswm.force.Cron;
import com.parzivail.pswm.force.Force;
import com.parzivail.pswm.force.ForcePower;
import com.parzivail.pswm.force.ForceUser;
import com.parzivail.pswm.force.events.PowerSelectedEvent;
import com.parzivail.util.ui.GuiScreen;
import com.parzivail.util.ui.LangUtils;
import com.parzivail.util.ui.TextEffects;
import com.parzivail.util.ui.TextUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL11;

import javax.annotation.CheckForNull;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

@SideOnly(Side.CLIENT)
public class GuiScreenForcePowers extends GuiScreen
{
	private final ItemStack holocron;
	private final EntityPlayer player;
	private final ArrayList<ForcePower> powers;
	private final ForceUser forceUser;
	private GuiPowerList powerList;
	private GuiButton learnButton;
	private GuiButton selectButton;
	private int listWidth;
	@CheckForNull
	private GuiPowerList.GuiPowerListItem selectedPower;
	private int selectedIndex;

	public GuiScreenForcePowers(EntityPlayer player)
	{
		this.holocron = Objects.requireNonNull(Cron.getHolocron(player));
		this.player = player;
		this.powers = Force.getPowersAvailable(holocron);
		this.forceUser = new ForceUser(player, holocron);
	}

	@Override
	public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_)
	{
		this.powerList.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
		int offset = (this.listWidth + this.width) / 2;
		int y = 5;
		this.drawCenteredString(this.fontRendererObj, LangUtils.translate("level.s.s", forceUser.getLevel(), Cron.getTitle(Cron.getSide(this.holocron), (int)Math.floor(forceUser.getLevel()))) + TextUtils.addEffect(" " + this.player.getCommandSenderName(), Force.getSide(this.holocron) == Force.ForceSide.JEDI ? TextEffects.COLOR_BLUE : TextEffects.COLOR_DARK_RED), offset, y += 10, 0xFFFFFF);
		this.drawCenteredString(this.fontRendererObj, LangUtils.translate("s.available.upgrade.points", forceUser.getUpgradePoints()), offset, y += 10, 0xFFFFFF);
		y += 10;
		if (this.selectedPower != null)
		{
			final ForcePower.PowerData power = selectedPower.power.new PowerData(holocron.stackTagCompound.getCompoundTag("powers").getCompoundTag(selectedPower.power.name));
			GL11.glEnable(GL11.GL_BLEND);
			this.drawCenteredString(this.fontRendererObj, TextUtils.makeUnderline(this.selectedPower.power.translatedName), offset, y += 10, 0xFFFFFF);
			this.drawCenteredString(this.fontRendererObj, LangUtils.translate("current.level.s", power.getLevel()), offset, y += 10, 0xFFFFFF);
			this.drawCenteredString(this.fontRendererObj, LangUtils.translate("xp.use.s", power.getCost()), offset, y += 10, 0xFFFFFF);
			this.drawCenteredString(this.fontRendererObj, LangUtils.translate("recharge.time.s.seconds", this.selectedPower.power.rechargeTime / 40f), offset, y += 10, 0xFFFFFF);
			this.drawCenteredString(this.fontRendererObj, LangUtils.translate("description.and.use"), offset, y += 10, 0xDDDDDD);
			this.fontRendererObj.drawSplitString(TextUtils.makeItalic(this.selectedPower.power.translatedDescription), offset - 125, y + 20, 250, 0xDDDDDD);
			GL11.glDisable(GL11.GL_BLEND);

			boolean is_power_active;
			is_power_active = Force.selectedPower == selectedPower.power;
			this.selectButton.enabled = power.getLevel() > 0 && !is_power_active;
			this.learnButton.enabled = this.canLearn(power);
		}
		else
		{
			this.learnButton.enabled = false;
			this.selectButton.enabled = false;
		}
		super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
	}

	private boolean canLearn(ForcePower.PowerData power)
	{
		final ForceUser forceUser = new ForceUser(player, holocron);
		return (power.getLevel() < power.getMaxLevel() || power.getMaxLevel() == -1) && forceUser.getUpgradePoints() > 0;
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if (button.enabled) {
			if (button == selectButton) {
				final ForcePower power = this.selectedPower == null ? null : this.selectedPower.power;
				final PowerSelectedEvent event = new PowerSelectedEvent(power);
				MinecraftForge.EVENT_BUS.post(event);
			}
		}
	}

	@Override
	public void initGui()
	{
		this.listWidth = 100;

		ArrayList<GuiPowerList.GuiPowerListItem> items = this.powers.stream().map(power -> new GuiPowerList.GuiPowerListItem(power, Force.getPowerLevel(holocron, power))).collect(Collectors.toCollection(ArrayList::new));

		this.powerList = new GuiPowerList(this, items, listWidth);
		this.powerList.registerScrollButtons(this.buttonList, 7, 8);

		this.learnButton = new GuiButton(20, 10, this.height - 60, listWidth, 20, "Study");
		this.selectButton = new GuiButton(21, 10, this.height - 38, listWidth, 20, "Wield");
		this.buttonList.add(this.learnButton);
		this.buttonList.add(this.selectButton);
	}

	public void selectIndex(int index)
	{
		this.selectedIndex = index;
		if (index >= 0 && index <= this.powerList.getSize())
			this.selectedPower = this.powerList.powers.get(this.selectedIndex);
		else
			this.selectedPower = null;
	}

	boolean indexSelected(int index)
	{
		return index == this.selectedIndex;
	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}
}
