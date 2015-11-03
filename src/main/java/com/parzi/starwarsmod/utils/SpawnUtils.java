package com.parzi.starwarsmod.utils;

import net.minecraft.world.World;

import com.parzi.starwarsmod.mobs.MobSandtrooper;
import com.parzi.starwarsmod.mobs.MobTatooineCommoner;
import com.parzi.starwarsmod.mobs.MobWookiee;

public class SpawnUtils
{
	public static void spawnNPC(NPCType type, World world, int x, int y, int z)
	{
		switch (type)
		{
			case MOSEISLEY:
				if (world.rand.nextInt(1) == 0)
				{
					MobTatooineCommoner c = new MobTatooineCommoner(world);
					c.setPosition(x, y, z);
					world.spawnEntityInWorld(c);
				}
				else
				{
					MobSandtrooper c = new MobSandtrooper(world);
					c.setPosition(x, y, z);
					world.spawnEntityInWorld(c);
				}
				break;
			case WOOKIETREE:
				MobWookiee w = new MobWookiee(world);
				w.setPosition(x, y, z);
				world.spawnEntityInWorld(w);
				break;
		}
	}
}