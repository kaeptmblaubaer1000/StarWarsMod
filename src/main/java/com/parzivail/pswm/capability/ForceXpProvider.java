package com.parzivail.pswm.capability;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by colby on 5/18/2017.
 */
public class ForceXpProvider implements ICapabilitySerializable<NBTTagCompound>
{
	@CapabilityInject(IForceCapability.class)
	public static Capability<IForceCapability> ForceXp;

	private IForceCapability instance = ForceXp.getDefaultInstance();

	@Override
	public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing)
	{
		return capability == ForceXp;
	}

	@Nullable
	@Override
	public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing)
	{
		return capability == ForceXp ? ForceXp.cast(this.instance) : null;
	}

	@Override
	public NBTTagCompound serializeNBT()
	{
		return (NBTTagCompound)ForceXp.getStorage().writeNBT(ForceXp, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt)
	{
		ForceXp.getStorage().readNBT(ForceXp, this.instance, null, nbt);
	}
}
