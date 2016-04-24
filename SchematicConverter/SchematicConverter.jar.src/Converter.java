import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Converter

{
	List<BlockBase> deferred = new ArrayList();

	public boolean Convert(String outputFilePath, String outputClassName, SchematicManager manager)

	{
		Logging.instance.info("Beginning conversion of " + manager.getFileName() + " (output class: " + outputClassName + ")");

		if (!outputFilePath.endsWith("\\"))
		{
			outputFilePath = outputFilePath + "\\";
		}
		String outputFileName = outputFilePath + outputClassName + ".java";

		File output = new File(outputFileName);
		if (!output.exists())
		{
			try
			{
				Logging.instance.fine("Output file did not exist:  Creating...");
				output.createNewFile();
			}
			catch (IOException e)
			{
				Logging.instance.exception(e);
				return false;
			}
		}
		FileOutputStream fos = null;
		try
		{
			Logging.instance.fine("Opening file output stream");
			fos = new FileOutputStream(output);
		}
		catch (FileNotFoundException e)
		{
			Logging.instance.exception(e);
			return false;
		}

		Logging.instance.info("Writing file header");
		WriteStringToFile(fos, FileHeader(manager, outputClassName));

		if (manager.GetConditionalSpawning())
		{
			Logging.instance.info("Conditional Spawning is TRUE - writing conditional spawn code.");
			WriteStringToFile(fos, ConditionalSpawn(manager));
		}
		else
		{
			Logging.instance.info("Conditional Spawning is FALSE");
		}

		int count = 0;
		int methodCount = 1;

		Logging.instance.info("Writing Blocks to file");
		BlockBase[] arrayOfBlockBase;
		int j = (arrayOfBlockBase = manager.getAllBlocks()).length;
		for (int i = 0; i < j; i++)
		{
			BlockBase bb = arrayOfBlockBase[i];

			if (!bb.isIgnored())

			{

				if (bb.GetMeta() != 0)
				{
					this.deferred.add(bb);
				}
				else
				{
					WriteStringToFile(fos, bb.getCreateFunctionCall(false));

					count++;

					if ((count != 0) && (count % 1500 == 0))
					{
						methodCount++;
						Logging.instance.info("Method length approaching size limit - splitting to next method.");
						WriteStringToFile(fos, MethodSplit(methodCount));
					}
				}
			}
		}
		Logging.instance.info("Writing deferred blocks");

		for (BlockBase bb : this.deferred)

		{
			WriteStringToFile(fos, bb.getCreateFunctionCall(false));
			WriteStringToFile(fos, bb.getCreateFunctionCall(true));

			count += 2;

			if ((count != 0) && (count % 1500 == 0))
			{
				methodCount++;
				Logging.instance.info("Method length approaching size limit - splitting to next method.");
				WriteStringToFile(fos, MethodSplit(methodCount));
			}
		}

		Logging.instance.info("Writing file footer");
		WriteStringToFile(fos, FileFooter());
		try
		{
			Logging.instance.fine("Closing file output stream");
			fos.close();
		}
		catch (IOException e)
		{
			Logging.instance.exception(e);
			return false;
		}

		Logging.instance.info("Conversion of " + manager.getFileName() + " completed successfully.");
		return true;
	}

	private boolean deferBlock(int BlockID)
	{
		int[] blockIDsToDefer = { 6, 8, 9, 10, 11, 12, 13, 27, 28, 31, 32, 37, 38, 39, 40, 50, 55, 59, 63, 64, 65, 66, 68, 69, 70, 71, 72, 75, 76, 77, 78, 81, 83, 93, 94, 95, 96, 97, 104, 105, 106, 125, 126, 159, 160, 171 };
		int[] arrayOfInt1;
		int j = (arrayOfInt1 = blockIDsToDefer).length;
		for (int i = 0; i < j; i++)
		{
			int cur = arrayOfInt1[i];
			if (BlockID == cur) { return true; }
		}
		return false;
	}

	private boolean WriteStringToFile(FileOutputStream fos, String output)
	{
		byte[] buffer = output.getBytes();
		try
		{
			fos.write(buffer);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private String MethodSplit(int index)
	{
		StringBuilder splitter = new StringBuilder();
		splitter.append("\r\n");
		splitter.append("\t\tgenerate" + index + "(world, rand, i, j, k);");
		splitter.append("\r\n");
		splitter.append("\t\treturn true;");
		splitter.append("\r\n");
		splitter.append("\t}");
		splitter.append("\r\n");
		splitter.append("\r\n");
		splitter.append("\tpublic boolean generate" + index + "(World world, Random rand, int i, int j, int k) {");
		splitter.append("\r\n");
		return splitter.toString();
	}

	private String AllowedSpawnBlocks(SchematicManager manager)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("\r\n");
		sb.append("\tprotected Block[] getValidSpawnBlocks() {");
		sb.append("\r\n");
		sb.append("\t\treturn new Block[] {");
		sb.append("\r\n");
		int count = manager.getAllowedSpawnBlocks().length - 1;
		Integer[] arrayOfInteger;
		int j = (arrayOfInteger = manager.getAllowedSpawnBlocks()).length;
		for (int i = 0; i < j; i++)
		{
			Integer i1 = arrayOfInteger[i];
			TextureMappingData tmd = BlockResources.instance.getTextureMappingData(i1.intValue());
			if ((tmd == null) || (tmd.getSpawnCode() == null) || (tmd.getSpawnCode() == ""))
			{
				sb.append("\t\t\t" + i);
			}
			else
			{
				sb.append("\t\t\t" + tmd.getSpawnCode());
			}
			if (count-- != 0)
			{
				sb.append(",");
			}
			sb.append("\r\n");
		}
		sb.append("\t\t};");
		sb.append("\r\n");
		sb.append("\t}");
		sb.append("\r\n\r\n");
		sb.append(locationIsValidSpawn(manager));
		return sb.toString();
	}

	private String FileHeader(SchematicManager manager, String className)
	{
		StringBuilder header = new StringBuilder();
		header.append("package your.mod.package;");
		header.append("\r\n\r\n");
		header.append("import java.util.Random;\r\n");
		header.append("import net.minecraft.block.Block;\r\n");
		header.append("import net.minecraft.init.Blocks;\r\n");
		header.append("import net.minecraft.world.World;\r\n");
		header.append("import net.minecraft.world.chunk.IChunkProvider;\r\n");
		header.append("import net.minecraft.world.gen.feature.WorldGenerator;\r\n");
		header.append("import cpw.mods.fml.common.IWorldGenerator;\r\n\r\n");
		header.append("public class " + className + " extends WorldGenerator implements IWorldGenerator");
		header.append("\r\n");
		header.append("{");
		if (manager.GetConditionalSpawning())
		{
			header.append(AllowedSpawnBlocks(manager));
			header.append("\r\n");
		}
		header.append("\r\n");
		header.append("\tpublic " + className + "() { }");
		header.append("\r\n");
		header.append("\r\n");
		header.append("\t@Override");
		header.append("\r\n");
		header.append("\tpublic void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) { }");
		header.append("\r\n");
		header.append("\r\n");
		header.append("\tpublic void setBlock(World world, int x, int y, int z, Block block, int metadata)");
		header.append("\r\n");
		header.append("\t{");
		header.append("\r\n");
		header.append("\t\tBlock b1 = world.getBlock(x, y, z);");
		header.append("\r\n");
		header.append("\r\n");
		header.append("\t\tif(b1.isAir(world, x, y, z) || b1.isLeaves(world, x, y, z))");
		header.append("\r\n");
		header.append("\t\t{");
		header.append("\r\n");
		header.append("\t\t\tworld.setBlock(x, y, z, block, metadata, 2);");
		header.append("\r\n");
		header.append("\t\t}");
		header.append("\r\n");
		header.append("\t}");
		header.append("\r\n");
		header.append("\r\n");
		header.append("\tpublic boolean generate(World world, Random rand, int i, int j, int k) {");
		header.append("\r\n");
		return header.toString();
	}

	public String locationIsValidSpawn(SchematicManager manager)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("\tpublic boolean locationIsValidSpawn(World world, int i, int j, int k){");
		sb.append("\r\n\t\t");
		sb.append("int distanceToAir = 0;");
		sb.append("\r\n\t\t");
		sb.append("Block check = world.getBlock(i, j, k);");
		sb.append("\r\n");
		sb.append("\r\n\t\t");
		sb.append("while (check != Blocks.air){");
		sb.append("\r\n\t\t\t");
		sb.append("if (distanceToAir > " + manager.getSpawnVarianceTolerance() + "){");
		sb.append("\r\n\t\t\t");
		sb.append("\treturn false;");
		sb.append("\r\n\t\t");
		sb.append("\t}");
		sb.append("\r\n");
		sb.append("\r\n\t\t\t");
		sb.append("distanceToAir++;");
		sb.append("\r\n\t\t\t");
		sb.append("check = world.getBlock(i, j + distanceToAir, k);");
		sb.append("\r\n\t\t");
		sb.append("}");
		sb.append("\r\n\r\n\t\t");
		sb.append("j += distanceToAir - 1;");
		sb.append("\r\n\r\n\t\t");
		sb.append("Block block = world.getBlock(i, j, k);");
		sb.append("\r\n\t\t");
		sb.append("Block blockAbove = world.getBlock(i, j+1, k);");
		sb.append("\r\n\t\t");
		sb.append("Block blockBelow = world.getBlock(i, j-1, k);");
		sb.append("\r\n\t\t");
		sb.append("\r\n\t\t");
		sb.append("for (Block x : getValidSpawnBlocks()){");
		sb.append("\r\n\t\t\t");
		sb.append("if (blockAbove != Blocks.air){");
		sb.append("\r\n\t\t\t\t");
		sb.append("return false;");
		sb.append("\r\n\t\t\t");
		sb.append("}");
		sb.append("\r\n\t\t\t");
		sb.append("if (block == x){");
		sb.append("\r\n\t\t\t\t");
		sb.append("return true;");
		sb.append("\r\n\t\t\t");
		sb.append("}else if (block == Blocks.snow && blockBelow == x){");
		sb.append("\r\n\t\t\t\t");
		sb.append("return true;");
		sb.append("\r\n\t\t\t");
		sb.append("}");
		sb.append("\r\n\t\t");
		sb.append("}");
		sb.append("\r\n\t\t");
		sb.append("\r\n\t\t");
		sb.append("return false;");
		sb.append("\r\n\t");
		sb.append("}");

		return sb.toString();
	}

	private String ConditionalSpawn(SchematicManager manager)
	{
		StringBuilder condition = new StringBuilder();

		condition.append("\t\t");
		condition.append("//check that each corner is one of the valid spawn blocks");
		condition.append("\r\n\t\t");
		condition.append("if(!locationIsValidSpawn(world, i, j, k) || !locationIsValidSpawn(world, i + " + manager.getSchematicWidth() + ", j, k) || !locationIsValidSpawn(world, i + " + manager.getSchematicWidth() + ", j, k + " + manager.getSchematicHeight() + ") || !locationIsValidSpawn(world, i, j, k + " + manager.getSchematicHeight() + "))");
		condition.append("\r\n\t\t");
		condition.append("{");
		condition.append("\r\n\t\t\t");
		condition.append("return false;");
		condition.append("\r\n\t\t");
		condition.append("}");
		condition.append("\r\n\r\n");
		condition.append("\t\tk = k - 10;");
		condition.append("\r\n");
		condition.append("\t\ti = i - 10;");
		condition.append("\r\n\r\n");

		return condition.toString();
	}

	private String FileFooter()
	{
		StringBuilder footer = new StringBuilder();
		footer.append("\r\n");
		footer.append("\t\treturn true;\r\n");
		footer.append("\t}\r\n");
		footer.append("}");

		return footer.toString();
	}

}

/*
 * Location: F:\Forge\schematicconverter\SchematicConverter.jar!\Converter.class
 * Java compiler version: 5 (49.0) JD-Core Version: 0.7.1
 */