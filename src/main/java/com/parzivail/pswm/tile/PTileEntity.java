package com.parzivail.pswm.tile;

import com.parzivail.util.basic.PBlock;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by colby on 12/18/2016.
 */
public class PTileEntity extends TileEntity
{
	private String id;

	public PTileEntity(PBlock associatedBlock)
	{
		this.id = associatedBlock.getName() + "_tile";
	}

	public PTileEntity(PBlock associatedBlock, String suffix)
	{
		this.id = associatedBlock.getName() + "_" + suffix;
	}

	public String getInternalId()
	{
		return id;
	}
}
