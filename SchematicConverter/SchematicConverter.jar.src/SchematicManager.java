import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class SchematicManager extends JPanel
{
	private static final long serialVersionUID = 5147547435624305692L;
	private String fileName;
	private boolean loaded;
	private boolean doConditionalSpawn;
	private boolean isIgnoringAir;
	private BlockBase[] allBlocks;
	private int sliceIndex;
	private int schematicNumSlices;
	private int schematicWidth;
	private int schematicHeight;
	private BlockBase[] curSlice;
	private ArrayList<Integer> AllowedSpawnBlocks;
	private int heightVarianceTolerance;

	public SchematicManager()
	{
		this.loaded = false;
		this.AllowedSpawnBlocks = new ArrayList();
		this.doConditionalSpawn = true;
		this.isIgnoringAir = true;
		this.heightVarianceTolerance = 3;
	}

	public void SetIgnoreAir(boolean ignore)
	{
		this.isIgnoringAir = ignore;
	}

	public boolean GetIgnoreAir()
	{
		return this.isIgnoringAir;
	}

	public void SetConditionalSpawning(boolean enable)
	{
		this.doConditionalSpawn = enable;
	}

	public boolean GetConditionalSpawning()
	{
		return this.doConditionalSpawn;
	}

	public BlockBase[] getAllBlocks()
	{
		return this.allBlocks;
	}

	public void AddAllowedSpawnBlock(int blockID)
	{
		if (!this.AllowedSpawnBlocks.contains(Integer.valueOf(blockID)))
		{
			this.AllowedSpawnBlocks.add(Integer.valueOf(blockID));
		}
	}

	public void RemoveAllowedSpawnBlock(int blockID)
	{
		if (this.AllowedSpawnBlocks.contains(Integer.valueOf(blockID)))
		{
			this.AllowedSpawnBlocks.remove(Integer.valueOf(blockID));
		}
	}

	public Integer[] getAllowedSpawnBlocks()
	{
		Integer[] spawnBlocks = new Integer[this.AllowedSpawnBlocks.size()];
		return (Integer[])this.AllowedSpawnBlocks.toArray(spawnBlocks);
	}

	public void setSpawnVarianceTolerance(int tolerance)
	{
		this.heightVarianceTolerance = tolerance;
	}

	public int getSpawnVarianceTolerance()
	{
		return this.heightVarianceTolerance;
	}

	private void setSlice(int index)
	{
		this.sliceIndex = index;
		this.curSlice = getSlice(index);
	}

	public void incrementSlice()
	{
		if (this.sliceIndex + 1 > this.schematicNumSlices) { return; }
		setSlice(++this.sliceIndex);
	}

	public void decrementSlice()
	{
		if (this.sliceIndex - 1 < 0) { return; }
		setSlice(--this.sliceIndex);
	}

	public boolean setFileName(String FileName, boolean ignoreAirBlocks)
	{
		this.schematicNumSlices = 0;
		this.schematicWidth = 0;
		this.schematicHeight = 0;
		this.fileName = FileName;

		if (!FileName.endsWith(".schematic"))
		{
			Logging.instance.severe("File specified is not a valid schematic file.");
			this.loaded = false;
			return false;
		}
		NBTRead reader = new NBTRead();
		try
		{
			this.allBlocks = reader.ReadSchematic(FileName);
		}
		catch (IOException e)
		{
			Logging.instance.exception(e);
			Logging.instance.severe("Failed to read from the NBT compound.");
			this.loaded = false;
			return false;
		}
		BlockBase[] arrayOfBlockBase;
		int j = (arrayOfBlockBase = this.allBlocks).length;
		int y;
		for (int i = 0; i < j; i++)
		{
			BlockBase bb = arrayOfBlockBase[i];

			int x = bb.GetX();
			y = bb.GetY();
			int z = bb.GetZ();

			if (x > this.schematicWidth)
			{
				this.schematicWidth = x;
			}
			if (y > this.schematicNumSlices)
			{
				this.schematicNumSlices = y;
			}
			if (z > this.schematicHeight)
			{
				this.schematicHeight = z;
			}
		}

		if (ignoreAirBlocks)
		{
			Logging.instance.fine("Ignore Air Blocks is TRUE - removing air blocks found in the schematic from the export list.");

			List<?> nonAirBlocks = new ArrayList();
			int k = (y = this.allBlocks.length);
			for (j = 0; j < k; j++)
			{
				BlockBase bb = this.allBlocks[j];
				if (bb.GetTypeID() == 0)
				{
					bb.setIgnored(true);
				}
			}
		}
		else
		{
			Logging.instance.fine("Ignore Air Blocks is FALSE.");
		}

		this.curSlice = getSlice(0);

		this.loaded = true;
		return true;
	}

	public int getCanvasWidth()
	{
		if (!this.loaded) { return 0; }
		return this.schematicWidth * 16;
	}

	public int getCanvasHeight()
	{
		if (!this.loaded) { return 0; }
		return this.schematicHeight * 16;
	}

	public int getSchematicWidth()
	{
		if (this.loaded) { return this.schematicWidth; }
		return 0;
	}

	public int getSchematicHeight()
	{
		if (this.loaded) { return this.schematicHeight; }
		return 0;
	}

	public int getSliceCount()
	{
		return this.schematicNumSlices;
	}

	public int getCurrentSlice()
	{
		return this.sliceIndex;
	}

	public void draw(Graphics g)
	{
		BlockBase[] arrayOfBlockBase;
		int j = (arrayOfBlockBase = this.curSlice).length;
		for (int i = 0; i < j; i++)
		{
			BlockBase bb = arrayOfBlockBase[i];
			int dx1 = bb.GetX() * 16;
			int dz1 = bb.GetZ() * 16;
			int dx2 = dx1 + 16;
			int dz2 = dz1 + 16;

			if (bb.GetTypeID() != 0)
			{
				TextureIndexData tid = BlockResources.instance.getTextureAndIndex(bb.GetTypeID(), bb.GetMeta());

				int sx1 = tid.index % 16 * 16;
				int sz1 = tid.index / 16 * 16;
				int sx2 = sx1 + 16;
				int sz2 = sz1 + 16;

				g.drawImage(tid.texture, dx1, dz1, dx2, dz2, sx1, sz1, sx2, sz2, null);
			}
			if (bb.isIgnored()) g.drawImage(BlockResources.instance.ignoredBlock, dx1, dz1, null);
		}
	}

	public void toggleIgnoreAir(boolean ignore)
	{
		BlockBase[] arrayOfBlockBase;
		int j = (arrayOfBlockBase = this.allBlocks).length;
		for (int i = 0; i < j; i++)
		{
			BlockBase bb = arrayOfBlockBase[i];
			if (bb.GetTypeID() == 0)
			{
				bb.setIgnored(ignore);
			}
		}
		this.isIgnoringAir = ignore;
	}

	public void toggleBlockIgnored(int x, int z)
	{
		BlockBase[] arrayOfBlockBase;
		int j = (arrayOfBlockBase = this.curSlice).length;
		for (int i = 0; i < j; i++)
		{
			BlockBase bb = arrayOfBlockBase[i];
			if ((bb.GetZ() == z) && (bb.GetX() == x)) bb.setIgnored(!bb.isIgnored());
		}
	}

	public String getBlockNameAt(int x, int z)
	{
		BlockBase[] arrayOfBlockBase;
		int j = (arrayOfBlockBase = this.curSlice).length;
		for (int i = 0; i < j; i++)
		{
			BlockBase bb = arrayOfBlockBase[i];
			if ((bb.GetZ() == z) && (bb.GetX() == x)) { return BlockResources.instance.getTextureAndIndex(bb.GetTypeID(), bb.GetMeta()).name; }
		}
		return "Unknown";
	}

	public String getFileName()
	{
		return this.fileName;
	}

	private BlockBase[] getSlice(int index)
	{
		if (index > this.schematicNumSlices) { return new BlockBase[0]; }
		List<BlockBase> blocksInSlice = new ArrayList();
		BlockBase[] arrayOfBlockBase1;
		int j = (arrayOfBlockBase1 = this.allBlocks).length;
		for (int i = 0; i < j; i++)
		{
			BlockBase bb = arrayOfBlockBase1[i];
			if (bb.GetY() == index)
			{
				blocksInSlice.add(bb);
			}
		}
		BlockBase[] returnArray = new BlockBase[blocksInSlice.size()];
		return (BlockBase[])blocksInSlice.toArray(returnArray);
	}
}

/*
 * Location:
 * F:\Forge\schematicconverter\SchematicConverter.jar!\SchematicManager.class
 * Java compiler version: 5 (49.0) JD-Core Version: 0.7.1
 */