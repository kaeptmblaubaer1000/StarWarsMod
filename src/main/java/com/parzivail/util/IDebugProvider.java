package com.parzivail.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import java.util.List;

public interface IDebugProvider
{
	List<String> getDebugText(List<String> list, EntityPlayer player, World world, int x, int y, int z);
}
