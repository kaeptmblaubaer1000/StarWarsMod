package com.parzivail.util.nbt;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.Constants;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class NBTUtil
{
	private NBTUtil() {}

	@SuppressWarnings("unchecked")
	public static void updateNBT(final NBTTagCompound baseCompoundTag, final NBTTagCompound newCompoundTag)
	{
		((Set<String>)baseCompoundTag.func_150296_c()).removeIf(key -> !newCompoundTag.hasKey(key));

		for (final Map.Entry<String, NBTBase> entry: ((Map<String, NBTBase>)newCompoundTag.tagMap).entrySet()) {
			final String key = entry.getKey();
			final NBTBase value = entry.getValue();
			final NBTBase oldValue = baseCompoundTag.getTag(key);
			if (value == oldValue) {
				continue;
			}
			if (value.getId() == oldValue.getId()) {
				if (value.getId() == Constants.NBT.TAG_COMPOUND)
				{
					updateNBT((NBTTagCompound)oldValue, (NBTTagCompound)value);
					continue;
				}
			}
			baseCompoundTag.setTag(key, value);
		}
	}
}
