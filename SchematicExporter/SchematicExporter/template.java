package {{PACKAGE}};

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;
import com.parzivail.pswm.utils.LootGenUtils;
import com.parzivail.pswm.StarWarsMod;

public class {{CLASS}} extends WorldGenerator implements IWorldGenerator
{
	public {{CLASS}}() { }

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) { }

	public void setBlock(World world, int x, int y, int z, Block block, int metadata)
	{
		world.setBlock(x, y, z, block, metadata, 2);
	}

{{GEN_METHODS}}
}