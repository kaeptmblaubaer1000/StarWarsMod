package com.parzi.starwarsmod.registry;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.blocks.BlockChromiumOre;
import com.parzi.starwarsmod.blocks.BlockDagobahMud;
import com.parzi.starwarsmod.blocks.BlockEndorBaseWall;
import com.parzi.starwarsmod.blocks.BlockEndorBaseWallStairs;
import com.parzi.starwarsmod.blocks.BlockHangingCauldron;
import com.parzi.starwarsmod.blocks.BlockMV;
import com.parzi.starwarsmod.blocks.BlockMudStairs;
import com.parzi.starwarsmod.blocks.BlockMudTable;
import com.parzi.starwarsmod.blocks.BlockSpaceLamp;
import com.parzi.starwarsmod.blocks.BlockTatooineSand;
import com.parzi.starwarsmod.blocks.BlockTatooineSandstone;
import com.parzi.starwarsmod.blocks.BlockTatooineTable;
import com.parzi.starwarsmod.blocks.BlockTitaniumChromium;
import com.parzi.starwarsmod.blocks.BlockTitaniumOre;
import com.parzi.starwarsmod.items.ItemEndorBaseWall;
import com.parzi.starwarsmod.items.ItemTatooineSand;
import com.parzi.starwarsmod.items.ItemTatooineSandstone;
import com.parzi.starwarsmod.tileentities.TileEntityHangingCauldron;
import com.parzi.starwarsmod.tileentities.TileEntityMV;
import com.parzi.starwarsmod.tileentities.TileEntityMudTable;
import com.parzi.starwarsmod.utils.Lumberjack;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegister
{
	public static void registerAll()
	{
		StarWarsMod.blockMV = new BlockMV();
		GameRegistry.registerBlock(StarWarsMod.blockMV, "moistureVaporator");
		GameRegistry.registerTileEntity(TileEntityMV.class, "teMoistureVaporator");

		StarWarsMod.blockHangingCauldron = new BlockHangingCauldron();
		GameRegistry.registerBlock(StarWarsMod.blockHangingCauldron, "hangingCauldron");
		GameRegistry.registerTileEntity(TileEntityHangingCauldron.class, "teHangingCauldron");

		StarWarsMod.blockChromiumOre = new BlockChromiumOre();
		GameRegistry.registerBlock(StarWarsMod.blockChromiumOre, "chromiumOre");

		StarWarsMod.blockTitaniumOre = new BlockTitaniumOre();
		GameRegistry.registerBlock(StarWarsMod.blockTitaniumOre, "titaniumOre");

		StarWarsMod.blockTitaniumChromiumBlock = new BlockTitaniumChromium();
		GameRegistry.registerBlock(StarWarsMod.blockTitaniumChromiumBlock, "titaniumChromiumBlock");

		StarWarsMod.blockDagobahMud = new BlockDagobahMud();
		GameRegistry.registerBlock(StarWarsMod.blockDagobahMud, "dagobahMud");

		StarWarsMod.blockEndorBaseWall = new BlockEndorBaseWall();
		GameRegistry.registerBlock(StarWarsMod.blockEndorBaseWall, ItemEndorBaseWall.class, "endorBaseWall");

		StarWarsMod.blockEndorBaseWallStairs = new BlockEndorBaseWallStairs();
		GameRegistry.registerBlock(StarWarsMod.blockEndorBaseWallStairs, "endorBaseWallStairs");

		StarWarsMod.blockMudStairs = new BlockMudStairs();
		GameRegistry.registerBlock(StarWarsMod.blockMudStairs, "mudStairs");

		StarWarsMod.blockTatooineSand = new BlockTatooineSand();
		GameRegistry.registerBlock(StarWarsMod.blockTatooineSand, ItemTatooineSand.class, "tatooineSand");

		StarWarsMod.blockTatooineSandstone = new BlockTatooineSandstone();
		GameRegistry.registerBlock(StarWarsMod.blockTatooineSandstone, ItemTatooineSandstone.class, "tatooineSandstone");

		StarWarsMod.blockSpaceLamp = new BlockSpaceLamp();
		GameRegistry.registerBlock(StarWarsMod.blockSpaceLamp, "spaceLamp");

		StarWarsMod.blockTable = new BlockTatooineTable();
		GameRegistry.registerBlock(StarWarsMod.blockTable, "table");

		StarWarsMod.blockTable2 = new BlockMudTable();
		GameRegistry.registerBlock(StarWarsMod.blockTable2, "mudTable");
		GameRegistry.registerTileEntity(TileEntityMudTable.class, "teMudTable");
		Lumberjack.info("Blocks, reporting for duty!");
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\registry\BlockRegister.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */