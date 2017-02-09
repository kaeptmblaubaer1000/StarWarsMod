package com.parzivail.util.schematic;

import com.parzivail.pswm.Resources;
import com.parzivail.util.common.Lumberjack;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * Created by Colby on 2/8/2017.
 */
public class NbtBlockMap
{
	public HashMap<Integer, Block> blockMap = new HashMap<>();
	public HashMap<Integer, Item> itemMap = new HashMap<>();

	public NbtBlockMap(String nbtpack)
	{
		try
		{
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("assets/" + Resources.MODID + "/nbtpack/" + nbtpack + ".nbt");
			NBTTagCompound tag = CompressedStreamTools.readCompressed(is);
			NBTTagList map = (NBTTagList)tag.getTag("map");

			int failed = 0;
			for (int i = 0; i < map.tagCount(); i++)
			{
				NBTTagCompound compound = map.getCompoundTagAt(i);
				String name = compound.getString("k");
				int id = compound.getInteger("v");
				Block b = Block.getBlockFromName(name);
				Item item = getItemFromName(name);
				if (b != null && (b != Blocks.AIR || id == 0))
					blockMap.put(id, b);
				else if (item != null)
					itemMap.put(id, item);
				else
				{
					failed++;
					Lumberjack.err("Skipped unknown block/item: " + name);
				}
			}

			is.close();
			Lumberjack.log("Init nbtpack " + nbtpack + ", " + (map.tagCount() - failed) + " loaded, " + failed + "failed");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public int translateItemId(int id)
	{
		return Item.getIdFromItem(itemMap.get(id));
	}

	public static Item getItemFromName(String p_149684_0_)
	{
		ResourceLocation resourceLocation = new ResourceLocation(p_149684_0_);
		if (Item.REGISTRY.containsKey(resourceLocation))
			return Item.REGISTRY.getObject(resourceLocation);
		else
			try
			{
				return Item.REGISTRY.getObjectById(Integer.parseInt(p_149684_0_));
			}
			catch (NumberFormatException numberformatexception)
			{
				return null;
			}
	}
}
