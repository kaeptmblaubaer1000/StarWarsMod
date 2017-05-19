package com.parzivail.pswm.capability;

import com.parzivail.pswm.PSWM;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by colby on 5/18/2017.
 */
public class ForcePowerProvider implements ICapabilityProvider, IForceCapability, ICapabilitySerializable<NBTTagCompound>
{
	private EntityPlayer player;

	public ForcePowerProvider(EntityPlayer player)
	{
		this.player = player;
	}

	@Override
	public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing)
	{
		//noinspection ConstantConditions
		return capability == PSWM.FORCE_CAP;
	}

	@Nullable
	@Override
	public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing)
	{
		if (PSWM.FORCE_CAP != null && capability == PSWM.FORCE_CAP)
			return PSWM.FORCE_CAP.cast(this);
		return null;
	}

	@Override
	public NBTTagCompound serializeNBT()
	{
		return new NBTTagCompound();
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt)
	{

	}

	@Override
	public String getPowerName()
	{
		return "Test power yo";
	}
}
