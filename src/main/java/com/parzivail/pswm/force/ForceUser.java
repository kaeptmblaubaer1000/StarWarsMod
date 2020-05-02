package com.parzivail.pswm.force;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.force.exceptions.NotAForceUserException;
import com.parzivail.pswm.network.MessageHolocronSyncClient;
import com.parzivail.util.common.NotNull;
import com.parzivail.util.common.Nullable;
import com.parzivail.util.common.PendingRename;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Supplier;

// TODO: replace this with Kotlin extension methods on EntityPlayer at some point, or at least create an extension that returns an instance of this
public final class ForceUser
{
	@NotNull
	private final EntityPlayer player;
	@NotNull
	private final ItemStack itemStack;

	public ForceUser(@NotNull EntityPlayer player, @NotNull ItemStack itemStack)
	{
		Objects.requireNonNull(player);
		Objects.requireNonNull(player, new Supplier<String>() // lambda would be slow
		{
			@Override
			public String get()
			{
				return player.getDisplayName() + " is not a force user";
			}
		});
		this.player = player;
		this.itemStack = itemStack;
	}

	public ForceUser(@NotNull EntityPlayer player) throws NotAForceUserException
	{
		this.player = player;
		if ((this.itemStack = Cron.getHolocron(player)) == null)
		{
			throw new NotAForceUserException(player.getDisplayName() + " is not a force user");
		}
	}

	public boolean canUse(@Nullable ForcePower.PowerData powerData)
	{
		return powerData != null && getXp() > powerData.getCost() && !powerData.isRecharging();
	}

	@PendingRename(PendingRename.Kind.FORCE_XP)
	public int getXp()
	{
		return Force.getXP(itemStack);
	}

	@PendingRename(PendingRename.Kind.FORCE_XP)
	public void setXp(int xp)
	{
		Force.setXP(itemStack, xp);
	}

	@PendingRename(PendingRename.Kind.FORCE_XP)
	public int getMaxXp() {
		return (getLevel() + 1) * 100;
	}

	@Nonnull
	public EntityPlayer getPlayer()
	{
		return player;
	}

	public NBTTagCompound getPowersNBT() {
		return itemStack.stackTagCompound.getCompoundTag(Resources.nbtPowers);
	}

	public void setPowersNBT(NBTTagCompound powersNBT) {
		itemStack.stackTagCompound.setTag(Resources.nbtPowers, powersNBT);
	}

	@Nullable
	public ForcePower getActivePower()
	{
		return null;
	}

	public int getUpgradePoints() {
		return itemStack.stackTagCompound.getInteger(Resources.nbtUpgradePoints);
	}

	public void setUpgradePoints(int upgradePoints) {
		itemStack.stackTagCompound.setInteger(Resources.nbtUpgradePoints, upgradePoints);
	}

	public int getLevel()
	{
		return itemStack.stackTagCompound.getInteger(Resources.nbtLevel) / 10;
	}

	public void setLevel(int level)
	{
		itemStack.stackTagCompound.setInteger(Resources.nbtLevel, level * 10);
	}

	public boolean addXpAndCheckLevelUp() {
		itemStack.stackTagCompound.setInteger(Resources.nbtLevel, itemStack.stackTagCompound.getInteger(Resources.nbtLevel) + 1);
		return (itemStack.stackTagCompound.getInteger(Resources.nbtLevel) % 10) == 0;
	}

	public void setSide(Force.ForceSide side) {
		itemStack.stackTagCompound.setInteger(Resources.nbtSide, Force.ForceSide.JEDI.ordinal());
	}

	@NotNull
	public ItemStack getItemStack()
	{
		return itemStack;
	}

	public boolean getAskedJediSith() {
		return itemStack.stackTagCompound.getBoolean(Resources.nbtAskedJediSith);
	}

	public void sync()
	{
		StarWarsMod.network.sendTo(new MessageHolocronSyncClient(player), (EntityPlayerMP) player);
	}
}
