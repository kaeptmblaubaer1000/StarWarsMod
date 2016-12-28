package com.parzivail.util.worldgen;

/**
 * Created by colby on 12/28/2016.
 */
public interface IHeightmap
{
	/**
	 * Gets the height of the top block (natural worldgen, not player creation) at (x, z)
	 *
	 * @param x The x position
	 * @param z The y position
	 * @return The height of the block at (x, z)
	 */
	double getHeightAt(int x, int z);
}
