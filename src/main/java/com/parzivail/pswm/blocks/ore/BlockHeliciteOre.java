package com.parzivail.pswm.blocks.ore;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.block.PBlock;
import com.parzivail.util.world.HarvestLevel;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockHeliciteOre extends PBlock
{
	public BlockHeliciteOre()
	{
		super("heliciteOre", Material.rock);
		setBlockTextureName(Resources.MODID + ":" + name);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		setHardness(4.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		setStepSound(soundTypeStone);
	}

	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return StarWarsItems.ingotHelicite; // TODO: convert to smelting recipe
	}
}
