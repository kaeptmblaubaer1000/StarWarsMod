package com.parzivail.pswm.force;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.force.events.PowerSelectedEvent;
import com.parzivail.pswm.force.powers.PowerPull;
import com.parzivail.pswm.force.powers.PowerPush;
import com.parzivail.util.common.NotNull;
import com.parzivail.util.common.PendingRename;
import com.parzivail.util.ui.LangUtils;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;

public final class Force
{
	public static final ArrayList<ForcePower> powers = new ArrayList<>();
	public static final HashMap<String, ForcePower> powersByName = new HashMap<>();
	@Nullable
	@SideOnly(Side.CLIENT)
	public static ForcePower selectedPower = null;

	public static ForcePower getPower(final String powerName)
	{
		return powersByName.get(powerName);
	}

	public enum ForceSide
	{
		JEDI, SITH
	}

	private Force()
	{
	}

	@PendingRename(PendingRename.Kind.FORCE_XP)
	public static int getXP(final ItemStack itemStack)
	{
		return itemStack.stackTagCompound.getInteger(Resources.nbtXp);
	}

	@PendingRename(PendingRename.Kind.FORCE_XP)
	public static void setXP(final ItemStack itemStack, int xp) {
		itemStack.stackTagCompound.setInteger(Resources.nbtXp, xp);
	}

	public static ForceSide getSide(final ItemStack itemStack) {
		return ForceSide.values()[itemStack.stackTagCompound.getInteger("side")];
	}

	public static int getUpgradePoints(@NotNull final ItemStack itemStack)
	{
		return itemStack.stackTagCompound.getInteger(Resources.nbtUpgradePoints);
	}

	public static int getLevel(final ItemStack itemStack)
	{
		return itemStack.stackTagCompound.getInteger("level");
	}

	public static int getPowerLevel(final ItemStack itemStack, final ForcePower power)
	{
		return itemStack.stackTagCompound.getCompoundTag("powers").getCompoundTag(power.name).getInteger("level");
	}

	public static boolean getAskedJediSith(final ItemStack itemStack)
	{
		return itemStack.stackTagCompound.getBoolean(Resources.nbtAskedJediSith);
	}

	public static ArrayList<ForcePower> getPowersAvailable(final ItemStack itemStack)
	{
		ArrayList<ForcePower> powers = new ArrayList<>();
		powers.add(PowerPush.INSTANCE);
		int level = getLevel(itemStack);
		if (5 < level)
		{
			powers.add(PowerPull.INSTANCE);
		}
		return powers;
	}

	@SideOnly(Side.CLIENT)
	public static void translate(final IResourceManager resourceManager)
	{
		for (ForcePower power : powers)
		{
			power.translatedName = LangUtils.translate(power.untranslatedName);
			power.translatedDescription = LangUtils.translate(power.untranslatedDescription);
		}
	}

	public static void registerPower(final ForcePower power)
	{
		power.untranslatedName = "force.power." + power.name;
		power.untranslatedDescription = "force.power." + power.name + ".desc";
		powers.add(power);
		powersByName.put(power.name, power);
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void onPowerSelected(PowerSelectedEvent event)
	{
		selectedPower = event.power;
	}

	static
	{
		registerPower(PowerPush.INSTANCE);
		registerPower(PowerPull.INSTANCE);
	}
}
