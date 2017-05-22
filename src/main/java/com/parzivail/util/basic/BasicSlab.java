package com.parzivail.util.basic;

import com.parzivail.pswm.PSWM;
import com.parzivail.util.register.RegisterUtils;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.Tuple;

/**
 * Created by colby on 5/21/2017.
 */
public class BasicSlab extends BlockStoneSlab
{
	private String name;

	public BasicSlab(String name)
	{
		this.name = name;
		this.setCreativeTab(PSWM.tabBlocks);
		Tuple<BasicSlab, ItemBlock> re = RegisterUtils.registerBlock(this, name);
		PSWM.proxy.registerItemRenderer(re.getSecond(), 0, name);
	}

	public String getName()
	{
		return name;
	}

	@Override
	public boolean isDouble()
	{
		return false;
	}
}
