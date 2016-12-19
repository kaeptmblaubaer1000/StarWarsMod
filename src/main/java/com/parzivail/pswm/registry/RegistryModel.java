package com.parzivail.pswm.registry;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.bank.PBlocks;
import com.parzivail.util.block.PBlock;
import com.parzivail.util.block.Variants;
import com.parzivail.util.common.InitPhase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by colby on 12/18/2016.
 */
public class RegistryModel implements PRegister
{
	@Override
	public String getName()
	{
		return "Model";
	}

	@Override
	public void registerAll()
	{
		register(PBlocks.infrastructure, Variants.INVENTORY);
	}

	private void register(PBlock block, int metadata, String variant)
	{
		ModelLoader.setCustomModelResourceLocation(block.getAssociatedItemBlock(), metadata, new ModelResourceLocation(Resources.MODID + ":" + block.getName(), variant));
	}

	private void register(PBlock block, String variant)
	{
		register(block, 0, variant);
	}

	@Override
	public InitPhase getPhase()
	{
		return InitPhase.PRE;
	}

	@Override
	public Side getSide()
	{
		return Side.CLIENT;
	}
}
