package com.parzi.starwarsmod.utils;

import net.minecraft.world.World;

import com.parzi.starwarsmod.mobs.MobBantha;
import com.parzi.starwarsmod.mobs.MobBith;
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
				switch (world.rand.nextInt(2))
				{
					case 0:
						MobTatooineCommoner c = new MobTatooineCommoner(world);
						c.setPosition(x, y, z);
						world.spawnEntityInWorld(c);
						break;
					case 1:
						MobSandtrooper cc = new MobSandtrooper(world);
						cc.setPosition(x, y, z);
						world.spawnEntityInWorld(cc);
						break;
					case 2:
						MobBith ccc = new MobBith(world);
						ccc.setPosition(x, y, z);
						world.spawnEntityInWorld(ccc);
						break;
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