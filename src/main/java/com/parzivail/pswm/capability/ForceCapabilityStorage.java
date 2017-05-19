package com.parzivail.pswm.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

/**
 * Created by colby on 5/18/2017.
 */
public class ForceCapabilityStorage implements Capability.IStorage<IForceCapability>
{
	@Override
	public NBTBase writeNBT(Capability<IForceCapability> capability, IForceCapability instance, EnumFacing side)
	{
		return null;
	}

	@Override
	public void readNBT(Capability<IForceCapability> capability, IForceCapability instance, EnumFacing side, NBTBase nbt)
	{
	}
}
