package com.parzivail.pswm.world;

import com.parzivail.pswm.Resources;
import com.parzivail.util.ui.Lumberjack;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Colby
 */
public class NbtBlockMap
{
	public HashMap<Integer, Block> blockMap = new HashMap<>();

	public NbtBlockMap(String nbtpack)
	{
		try
		{
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("assets/" + Resources.MODID + "/nbtpacks/" + nbtpack + ".nbt");
			NBTTagCompound tag = CompressedStreamTools.readCompressed(is);
			NBTTagList map = (NBTTagList)tag.getTag("map");

			List<String> skipped = new ArrayList<>();
			for (int i = 0; i < map.tagCount(); i++)
			{
				NBTTagCompound compound = map.getCompoundTagAt(i);
				String blockname = compound.getString("k");
				int id = compound.getInteger("v");
				Block b = Block.getBlockFromName(blockname);
				if (b != Blocks.air || id == 0)
					blockMap.put(id, b);
				else
					skipped.add(blockname);
			}
			if (!skipped.isEmpty())
				Lumberjack.err("Skipped unknown blocks: " + String.join(", ", skipped));

			is.close();
			Lumberjack.log("Loaded nbtpack " + nbtpack + ", " + map.tagCount() + " key/value pairs");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public int translateId(int id)
	{
		return Block.getIdFromBlock(blockMap.get(id));
	}
}
