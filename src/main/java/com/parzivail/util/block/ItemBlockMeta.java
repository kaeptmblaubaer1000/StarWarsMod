package com.parzivail.util.block;

import com.parzivail.pswm.Resources;
import net.minecraft.item.ItemBlock;

/**
 * Created by colby on 12/19/2016.
 */
public class ItemBlockMeta extends ItemBlock
{
	public ItemBlockMeta(PBlock block)
	{
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setRegistryName(Resources.MODID, block.getName());
	}

	public int getMetadata(int damage)
	{
		return damage;
	}
}