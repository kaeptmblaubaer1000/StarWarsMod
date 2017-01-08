package com.parzivail.pswm.dimension.endor;

import com.parzivail.pswm.dimension.DimensionInfo;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.chunk.IChunkGenerator;

/**
 * Created by colby on 12/22/2016.
 */

public class WorldProviderEndor extends WorldProvider
{
	@Override
	protected void init()
	{
		this.hasSkyLight = true;
		this.biomeProvider = new BiomeProviderSingle(DimensionInfo.biomeEndor);
	}

	@Override
	public IChunkGenerator createChunkGenerator()
	{
		return new ChunkProviderEndor(world, world.getSeed());
	}

	@Override
	public String getWelcomeMessage()
	{
		return "Jumping out of Hyperspace near " + this.world.getWorldInfo().getWorldName();
	}

	@Override
	public String getDepartMessage()
	{
		return "Blasting out of " + this.world.getWorldInfo().getWorldName();
	}

	@Override
	public String getSaveFolder()
	{
		return "ENDOR";
	}

	@Override
	public DimensionType getDimensionType()
	{
		return DimensionInfo.endorDimension;
	}

}