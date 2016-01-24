package com.parzivail.pswm.minimap;

import java.awt.Point;
import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

import com.parzivail.util.ui.GlPalette;

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
			return GlPalette.ANALOG_BLUE;
		else if (block == Blocks.leaves)
			return GlPalette.DARK_GREEN;
		Material m = block.getMaterial();
		if (m == Material.air)
			return GlPalette.STEEL_GREY;
		else if (m == Material.anvil)
			return GlPalette.STEEL_GREY;
		else if (m == Material.cactus)
			return GlPalette.GREEN;
		else if (m == Material.cake)
			return GlPalette.LIGHT_PINK;
		else if (m == Material.carpet)
			return GlPalette.YELLOW;
		else if (m == Material.circuits)
			return GlPalette.ROSE_RED;
		else if (m == Material.clay)
			return GlPalette.CLAY;
		else if (m == Material.cloth)
			return GlPalette.OFF_WHITE;
		else if (m == Material.coral)
			return GlPalette.CORAL;
		else if (m == Material.craftedSnow)
			return GlPalette.WHITE;
		else if (m == Material.dragonEgg)
			return GlPalette.DEEP_PURPLE;
		else if (m == Material.fire)
			return GlPalette.RED_ORANGE;
		else if (m == Material.glass)
			return GlPalette.LIGHT_GREY;
		else if (m == Material.ground)
			return GlPalette.GRASS_GREEN;
		else if (m == Material.ice)
			return GlPalette.ICE;
		else if (m == Material.iron)
			return GlPalette.STEEL;
		else if (m == Material.lava)
			return GlPalette.RED_ORANGE;
		else if (m == Material.leaves)
			return GlPalette.GREEN_APPLE;
		else if (m == Material.packedIce)
			return GlPalette.ICE_BLUE;
		else if (m == Material.piston)
			return GlPalette.TAN_BROWN;
		else if (m == Material.plants)
			return GlPalette.LEAF_GREEN;
		else if (m == Material.portal)
			return GlPalette.PURPLE_PINK;
		else if (m == Material.redstoneLight)
			return GlPalette.ROSE_RED;
		else if (m == Material.rock)
			return GlPalette.STONE;
		else if (m == Material.sand)
			return GlPalette.LIGHT_TAN;
		else if (m == Material.snow)
			return GlPalette.WHITE;
		else if (m == Material.sponge)
			return GlPalette.YELLOW_TAN;
		else if (m == Material.tnt)
			return GlPalette.RED_ORANGE;
		else if (m == Material.vine)
			return GlPalette.LEAF_GREEN;
		else if (m == Material.water)
			return GlPalette.WATER_BLUE;
		else if (m == Material.web)
			return GlPalette.WHITE;
		else if (m == Material.wood)
			return GlPalette.TAN;
		return GlPalette.GREEN;
	}
}
