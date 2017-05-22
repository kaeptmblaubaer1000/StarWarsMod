package com.parzivail.util.basic;

import com.parzivail.pswm.PSWM;
import com.parzivail.util.register.RegisterUtils;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.Tuple;

/**
 * Created by colby on 5/21/2017.
 */
public class BasicStairs extends BlockStairs
{
	private String name;

	public BasicStairs(IBlockState modelState, String name)
	{
		super(modelState);
		this.name = name;
		this.setCreativeTab(PSWM.tabBlocks);
		Tuple<BasicStairs, ItemBlock> re = RegisterUtils.registerBlock(this, name);
		PSWM.proxy.registerItemRenderer(re.getSecond(), 0, name);
	}

	public String getName()
	{
		return name;
	}
}
