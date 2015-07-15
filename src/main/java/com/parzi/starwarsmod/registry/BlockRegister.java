package com.parzi.starwarsmod.registry;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.blocks.BlockChromiumOre;
import com.parzi.starwarsmod.blocks.BlockEndorBaseWall;
import com.parzi.starwarsmod.blocks.BlockEndorBaseWallStairs;
import com.parzi.starwarsmod.blocks.BlockMV;
import com.parzi.starwarsmod.blocks.BlockTatooineSand;
import com.parzi.starwarsmod.blocks.BlockTitaniumChromium;
import com.parzi.starwarsmod.blocks.BlockTitaniumOre;
import com.parzi.starwarsmod.items.ItemEndorBaseWall;
import com.parzi.starwarsmod.tileentities.TileEntityMV;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegister
{
	public static void registerAll()
	{
		StarWarsMod.blockMV = new BlockMV();
		GameRegistry.registerBlock(StarWarsMod.blockMV, "moistureVaporator");
		GameRegistry.registerTileEntity(TileEntityMV.class, "teMoistureVaporator");

		StarWarsMod.chromiumOre = new BlockChromiumOre();
		GameRegistry.registerBlock(StarWarsMod.chromiumOre, "chromiumOre");

		StarWarsMod.titaniumOre = new BlockTitaniumOre();
		GameRegistry.registerBlock(StarWarsMod.titaniumOre, "titaniumOre");

		StarWarsMod.titaniumChromiumBlock = new BlockTitaniumChromium();
		GameRegistry.registerBlock(StarWarsMod.titaniumChromiumBlock, "titaniumChromiumBlock");

		StarWarsMod.blockEndorBaseWall = new BlockEndorBaseWall();
		GameRegistry.registerBlock(StarWarsMod.blockEndorBaseWall, ItemEndorBaseWall.class, "endorBaseWall");

		StarWarsMod.blockEndorBaseWallStairs = new BlockEndorBaseWallStairs();
		GameRegistry.registerBlock(StarWarsMod.blockEndorBaseWallStairs, "endorBaseWallStairs");
		
		StarWarsMod.tatooineSand = new BlockTatooineSand();
		GameRegistry.registerBlock(StarWarsMod.tatooineSand, "tatooineSand");
	}
}
