package com.parzivail.util.schematic;

import com.parzivail.util.common.Lumberjack;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import java.util.HashMap;

/**
 * Created by colby on 2/12/2017.
 */
public class EmbeddedNbtBlockMap
{
	public HashMap<Integer, Block> blockMap = new HashMap<>();
	public HashMap<Integer, Item> itemMap = new HashMap<>();

	public EmbeddedNbtBlockMap(NBTTagCompound schematic)
	{
		NBTTagList map = (NBTTagList)schematic.getTag("EmbeddedTypes");

		int failed = 0;
		for (int i = 0; i < map.tagCount(); i++)
		{
			NBTTagCompound compound = map.getCompoundTagAt(i);
			String name = compound.getString("registryName");
			int id = compound.getInteger("embeddedId");
			boolean isBlock = compound.getInteger("isBlock") == 1;

			if (isBlock)
			{
				Block b = Block.getBlockFromName(name);
				if (b != null && (b != Blocks.AIR || id == 0))
					blockMap.put(id, b);
				else
				{
					failed++;
					Lumberjack.err("Skipped unknown block: " + name);
				}

			}
			else
			{
				Item item = Item.getByNameOrId(name);
				if (item != null)
					itemMap.put(id, item);
				else
				{
					failed++;
					Lumberjack.err("Skipped unknown item: " + name);
				}
			}
		}

		Lumberjack.log("Init EmbeddedNbtBlockMap, " + (map.tagCount() - failed) + " conversions loaded, " + failed + " failed");
	}

	public int translateItemId(int id)
	{
		return Item.getIdFromItem(itemMap.get(id));
	}
}
