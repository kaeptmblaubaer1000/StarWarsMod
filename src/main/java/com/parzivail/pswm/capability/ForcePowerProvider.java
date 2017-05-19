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
public class ForcePowerProvider implements ICapabilitySerializable<NBTTagCompound>
{
	@CapabilityInject(IForceCapability.class)
	public static final Capability<IForceCapability> FORCE_CAP = null;

	private IForceCapability instance = FORCE_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing)
	{
		return capability == FORCE_CAP;
	}

	@Nullable
	@Override
	public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing)
	{
		return capability == FORCE_CAP ? FORCE_CAP.cast((IForceCapability)capability) : null;
	}

	@Override
	public NBTTagCompound serializeNBT()
	{
		return (NBTTagCompound)FORCE_CAP.getStorage().writeNBT(FORCE_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt)
	{
		FORCE_CAP.getStorage().readNBT(FORCE_CAP, this.instance, null, nbt);
	}
}
