package com.parzivail.pswm.utils;

import com.parzivail.pswm.mobs.MobBith;
import com.parzivail.pswm.mobs.MobSandtrooper;
import com.parzivail.pswm.mobs.MobTatooineCommoner;
import com.parzivail.pswm.mobs.MobWookiee;

import net.minecraft.world.World;

public class SpawnUtils
{
	public static void spawnNPC(NPCType type, World world, int x, int y, int z)
	{
		switch (type)
		{
			case MOSEISLEY:
				switch (world.rand.nextInt(5))
				{
					case 0:
					case 1:
						MobTatooineCommoner c = new MobTatooineCommoner(world);
						c.setPosition(x, y, z);
						world.spawnEntityInWorld(c);
						break;
					case 2:
					case 3:
						MobSandtrooper cc = new MobSandtrooper(world);
						cc.setPosition(x, y, z);
						world.spawnEntityInWorld(cc);
						break;
					case 4:
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