package com.parzivail.pswm.minimap;

import java.awt.Point;
import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

import com.parzivail.util.ui.GLPalette;

public class MinimapWorld
{
	private HashMap<Point, Integer> map = new HashMap<Point, Integer>();
	private int dimension;
	private WorldServer world;

	public MinimapWorld(int dim)
	{
		this.dimension = dim;
		this.world = MinecraftServer.getServer().worldServerForDimension(this.dimension);
	}

	public int getAt(int x, int z)
	{
		Point p = new Point(x, z);
		if (!this.map.containsKey(p))
		{
			Block block = this.world.getTopBlock(x, z);
			this.map.put(p, this.getColorForMaterial(block));
		}
		return this.map.get(p).intValue();
	}

	private int getColorForMaterial(Block block)
	{
		if (block == Blocks.water || block == Blocks.flowing_water)
			return GLPalette.ANALOG_BLUE;
		else if (block == Blocks.leaves)
			return GLPalette.DARK_GREEN;
		Material m = block.getMaterial();
		if (m == Material.air)
			return GLPalette.STEEL_GREY;
		else if (m == Material.anvil)
			return GLPalette.STEEL_GREY;
		else if (m == Material.cactus)
			return GLPalette.GREEN;
		else if (m == Material.cake)
			return GLPalette.LIGHT_PINK;
		else if (m == Material.carpet)
			return GLPalette.YELLOW;
		else if (m == Material.circuits)
			return GLPalette.ROSE_RED;
		else if (m == Material.clay)
			return GLPalette.CLAY;
		else if (m == Material.cloth)
			return GLPalette.OFF_WHITE;
		else if (m == Material.coral)
			return GLPalette.CORAL;
		else if (m == Material.craftedSnow)
			return GLPalette.WHITE;
		else if (m == Material.dragonEgg)
			return GLPalette.DEEP_PURPLE;
		else if (m == Material.fire)
			return GLPalette.RED_ORANGE;
		else if (m == Material.glass)
			return GLPalette.LIGHT_GREY;
		else if (m == Material.ground)
			return GLPalette.GRASS_GREEN;
		else if (m == Material.ice)
			return GLPalette.ICE;
		else if (m == Material.iron)
			return GLPalette.STEEL;
		else if (m == Material.lava)
			return GLPalette.RED_ORANGE;
		else if (m == Material.leaves)
			return GLPalette.GREEN_APPLE;
		else if (m == Material.packedIce)
			return GLPalette.ICE_BLUE;
		else if (m == Material.piston)
			return GLPalette.TAN_BROWN;
		else if (m == Material.plants)
			return GLPalette.LEAF_GREEN;
		else if (m == Material.portal)
			return GLPalette.PURPLE_PINK;
		else if (m == Material.redstoneLight)
			return GLPalette.ROSE_RED;
		else if (m == Material.rock)
			return GLPalette.STONE;
		else if (m == Material.sand)
			return GLPalette.LIGHT_TAN;
		else if (m == Material.snow)
			return GLPalette.WHITE;
		else if (m == Material.sponge)
			return GLPalette.YELLOW_TAN;
		else if (m == Material.tnt)
			return GLPalette.RED_ORANGE;
		else if (m == Material.vine)
			return GLPalette.LEAF_GREEN;
		else if (m == Material.water)
			return GLPalette.WATER_BLUE;
		else if (m == Material.web)
			return GLPalette.WHITE;
		else if (m == Material.wood)
			return GLPalette.TAN;
		return GLPalette.GREEN;
	}
}
