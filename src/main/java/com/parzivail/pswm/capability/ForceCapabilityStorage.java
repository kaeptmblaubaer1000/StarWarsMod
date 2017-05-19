package com.parzivail.pswm.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
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
		NBTTagCompound c = new NBTTagCompound();
		c.setInteger("xp", instance.getForceXp());
		c.setInteger("limit", instance.getForceXpLimit());
		return c;
	}

	@Override
	public void readNBT(Capability<IForceCapability> capability, IForceCapability instance, EnumFacing side, NBTBase nbt)
	{
		NBTTagCompound c = (NBTTagCompound)nbt;
		instance.set(c.getInteger("xp"));
		instance.setLimit(c.getInteger("limit"));
	}
}
