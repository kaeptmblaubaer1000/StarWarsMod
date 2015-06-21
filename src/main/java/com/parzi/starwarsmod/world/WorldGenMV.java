package com.parzi.starwarsmod.world;

import java.util.Random;

import com.parzi.starwarsmod.StarWarsMod;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenMV extends WorldGenerator
{

	public boolean generate(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
	{

		while (p_76484_1_.isAirBlock(p_76484_3_, p_76484_4_, p_76484_5_) && p_76484_4_ > 2)
		{
			p_76484_4_--;
		}

		if (p_76484_1_.getBlock(p_76484_3_, p_76484_4_, p_76484_5_) != Blocks.sand)
		{
			return false;
		}
		else
		{
			p_76484_1_.setBlock(p_76484_3_, p_76484_4_ + 1, p_76484_5_, StarWarsMod.blockMV, 0, 2);
			return true;
		}
	}

}
