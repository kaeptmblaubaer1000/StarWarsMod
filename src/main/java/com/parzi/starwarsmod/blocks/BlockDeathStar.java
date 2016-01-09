package com.parzi.starwarsmod.blocks;

import java.util.List;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.util.block.BlockMultiTexture;
import com.parzi.util.world.HarvestLevel;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockDeathStar extends BlockMultiTexture
{
	public BlockDeathStar()
	{
		super("deathStarBlock", new String[] { "HangarFloor", "LightHangarFloor", "HangarCrate", "CorridorFloor", "CautionFloor", "HangarWallPanel", "CorridorWallPanel", "ShieldGeneratorConsole", "Extra1", "Extra2", "Extra3" }, Material.rock);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.setHardness(4.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		this.setStepSound(soundTypeMetal);
	}
}