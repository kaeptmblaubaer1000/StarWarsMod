package com.parzivail.util;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public interface IDebugProvider
{
	public abstract List<String> getDebugText(EntityPlayer player, World world, int x, int y, int z);
}
