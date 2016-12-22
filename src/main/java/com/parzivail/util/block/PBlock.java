package com.parzivail.util.block;

import com.parzivail.pswm.PSWM;
import com.parzivail.pswm.tile.PTileEntity;
import com.parzivail.util.register.RegisterUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

/**
 * Created by colby on 12/18/2016.
 */
public class PBlock extends Block
{
	private String name;

	public PBlock(String name, Material material)
	{
		super(material);
		this.name = name;
		this.setCreativeTab(PSWM.tabBlocks);
		RegisterUtils.registerBlock(this, name);
		PSWM.proxy.registerItemRenderer(new ItemBlock(this), 0, name);
	}

	public PTileEntity getAssociatedTileEntity()
	{
		return null;
	}

	public String getName()
	{
		return name;
	}
}