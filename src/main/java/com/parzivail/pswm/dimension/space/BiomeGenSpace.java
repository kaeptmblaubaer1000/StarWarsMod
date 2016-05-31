package com.parzivail.pswm.dimension.space;

import com.parzivail.pswm.dimension.BiomeGenPSWM;
import com.parzivail.pswm.world.gen.asteroid.*;
import com.parzivail.util.math.MathUtils;
import net.minecraft.world.World;

import java.util.Random;

public class BiomeGenSpace extends BiomeGenPSWM
{
	int locY;

	public BiomeGenSpace(int biomeId)
	{
		super(biomeId);

		this.setBiomeName("Space");

		this.enableRain = false;
		this.enableSnow = false;

		this.rootHeight = 0.1f;
		this.heightVariation = 0.0f;

		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();

		this.topBlock = null;
		this.fillerBlock = null;

		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.deadBushPerChunk = -999;
		this.theBiomeDecorator.reedsPerChunk = -999;
		this.theBiomeDecorator.cactiPerChunk = -999;

		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
	}

	@Override
	public void decorate(World world, Random par2Random, int chunkX, int chunkZ)
	{
		if (MathUtils.oneIn(8))
		{
			locY = MathUtils.randomRange(10, 200);
			switch (MathUtils.randomRange(0, 10))
			{
				case 0:
					WorldGenAsteroid2_x0_z0.generate(world, chunkX, this.locY, chunkZ);
					WorldGenAsteroid2_x0_z16.generate(world, chunkX, this.locY, chunkZ + 16);
					break;
				case 1:
					WorldGenAsteroid1_x0_z0.generate(world, chunkX, this.locY, chunkZ);
					WorldGenAsteroid1_x0_z16.generate(world, chunkX, this.locY, chunkZ + 16);
					break;
				case 2:
					WorldGenAsteroid3_x0_z0.generate(world, chunkX, this.locY, chunkZ);
					break;
				case 3:
					WorldGenAsteroid4_x0_z0.generate(world, chunkX, this.locY, chunkZ);
					WorldGenAsteroid4_x0_z16.generate(world, chunkX, this.locY, chunkZ + 16);
					break;
				case 4:
					WorldGenAsteroid6_x0_z0.generate(world, chunkX, this.locY, chunkZ);
					break;
				case 5:
					WorldGenAsteroid8_x0_z0.generate(world, chunkX, this.locY, chunkZ);
					WorldGenAsteroid8_x16_z0.generate(world, chunkX + 16, this.locY, chunkZ);
					break;
				case 6:
					WorldGenAsteroid7_x0_z0.generate(world, chunkX, this.locY, chunkZ);
					break;
				case 7:
					WorldGenAsteroid5_x0_z0.generate(world, chunkX, this.locY, chunkZ);
					break;
				case 8:
					WorldGenAsteroid9_x0_z0.generate(world, chunkX, this.locY, chunkZ);
					WorldGenAsteroid9_x0_z16.generate(world, chunkX, this.locY, chunkZ + 16);
					break;
				case 9:
					WorldGenAsteroid10_x0_z0.generate(world, chunkX, this.locY, chunkZ);
					WorldGenAsteroid10_x0_z16.generate(world, chunkX, this.locY, chunkZ + 16);
					WorldGenAsteroid10_x16_z0.generate(world, chunkX + 16, this.locY, chunkZ);
					WorldGenAsteroid10_x16_z16.generate(world, chunkX + 16, this.locY, chunkZ + 16);
					break;
			}
		}
	}
}