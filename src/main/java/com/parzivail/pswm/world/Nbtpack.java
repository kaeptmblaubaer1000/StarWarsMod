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
import java.util.HashMap;

/**
 * @author Colby
 */
public class NbtPack
{
	private HashMap<Integer, Block> blockMap;

	public void load(String nbtpack)
	{
		Lumberjack.log("Loading nbtpack " + nbtpack);
		try
		{
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("assets/" + Resources.MODID + "/nbtpacks/" + nbtpack + ".nbt");
			NBTTagCompound tag = CompressedStreamTools.readCompressed(is);
			NBTTagList map = (NBTTagList)tag.getTag("map");

			blockMap = new HashMap<>();

			for (int i = 0; i < map.tagCount(); i++)
			{
				NBTTagCompound compound = map.getCompoundTagAt(i);
				String blockname = compound.getString("k");
				int id = compound.getInteger("v");
				Block b = Block.getBlockFromName(blockname);
				if (b != Blocks.air || id == 0)
					blockMap.put(id, b);
			}

			is.close();
			Lumberjack.log("Loaded " + map.tagCount() + " key/value pairs");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}
}
