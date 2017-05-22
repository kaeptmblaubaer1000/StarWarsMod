package com.parzivail.util.register;

import com.parzivail.util.Util;
import com.parzivail.util.basic.ItemBlockMeta;
import com.parzivail.util.basic.PBlock;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Tuple;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.IForgeRegistryEntry;

import java.util.Locale;

/**
 * Created by colby on 12/20/2016.
 */
public class RegisterUtils
{
	public static <T extends Item> T registerItem(T item, String name)
	{
		if (!name.equals(name.toLowerCase(Locale.US)))
		{
			throw new IllegalArgumentException(String.format("Unlocalized names need to be all lowercase! Item: %s", name));
		}

		item.setUnlocalizedName(Util.moddot(name));
		item.setRegistryName(Util.getResource(name));
		GameRegistry.register(item);
		return item;
	}

	public static <T extends Block> Tuple<T, ItemBlock> registerBlock(T block, String name)
	{
		ItemBlock itemBlock = new ItemBlock(block);
		return registerBlock(block, itemBlock, name);
	}

	@SuppressWarnings("unchecked")
	public static <T extends Block> Tuple<T, ItemBlock> registerBlock(ItemBlock itemBlock, String name)
	{
		Block block = itemBlock.getBlock();
		return (Tuple<T, ItemBlock>)registerBlock(block, itemBlock, name);
	}

	public static <T extends Block> T registerBlock(T block, String name, IProperty<?> property)
	{
		ItemBlockMeta itemBlock = new ItemBlockMeta(block);
		registerBlock(block, itemBlock, name);
		ItemBlockMeta.setMappingProperty(block, property);
		return block;
	}

	public static <T extends Block> Tuple<T, ItemBlock> registerBlock(T block, ItemBlock itemBlock, String name)
	{
		if (!name.equals(name.toLowerCase(Locale.US)))
		{
			throw new IllegalArgumentException(String.format("Unlocalized names need to be all lowercase! Block: %s", name));
		}

		String prefixedName = Util.moddot(name);
		block.setUnlocalizedName(prefixedName);
		itemBlock.setUnlocalizedName(prefixedName);

		register(block, name);
		register(itemBlock, name);
		return new Tuple<T, ItemBlock>(block, itemBlock);
	}

	public static <T extends PBlock> T registerBlockNoItem(T block, String name)
	{
		if (!name.equals(name.toLowerCase(Locale.US)))
		{
			throw new IllegalArgumentException(String.format("Unlocalized names need to be all lowercase! Block: %s", name));
		}

		String prefixedName = Util.moddot(name);
		block.setUnlocalizedName(prefixedName);

		register(block, name);
		return block;
	}

	public static <T extends IForgeRegistryEntry<?>> T register(T thing, String name)
	{
		thing.setRegistryName(Util.getResource(name));
		GameRegistry.register(thing);
		return thing;
	}

	public static void registerTE(Class<? extends TileEntity> teClazz, String name)
	{
		if (!name.equals(name.toLowerCase(Locale.US)))
		{
			throw new IllegalArgumentException(String.format("Unlocalized names need to be all lowercase! TE: %s", name));
		}

		GameRegistry.registerTileEntity(teClazz, Util.moddot(name));
	}
}
