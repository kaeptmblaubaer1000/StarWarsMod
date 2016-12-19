package com.parzivail.pswm.registry;

import com.parzivail.pswm.bank.PBlocks;
import com.parzivail.pswm.blocks.BlockInfrastructure;
import com.parzivail.pswm.tile.PTileEntity;
import com.parzivail.util.block.PBlock;
import com.parzivail.util.common.InitPhase;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by colby on 12/18/2016.
 */
public class RegistryBlock implements PRegister
{
	@Override
	public String getName()
	{
		return "Block";
	}

	@Override
	public void registerAll()
	{
		register(PBlocks.infrastructure = new BlockInfrastructure());
	}

	@Override
	public InitPhase getPhase()
	{
		return InitPhase.PRE;
	}

	@Override
	public Side getSide()
	{
		return Side.SERVER;
	}

	private void register(PBlock block)
	{
		PTileEntity tileEntity = block.getAssociatedTileEntity();
		if (tileEntity != null)
			GameRegistry.registerTileEntity(tileEntity.getClass(), tileEntity.getInternalId());
		GameRegistry.register(block);
		GameRegistry.register(block.getAssociatedItemBlock());
	}
}
