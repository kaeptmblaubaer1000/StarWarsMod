package com.parzivail.util.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.registry.RegistryModel;
import com.parzivail.pswm.tile.PTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

/**
 * Created by colby on 12/18/2016.
 */
public class PBlock extends Block
{
	private String name;
	private ItemBlock ib;

	public PBlock(String name, Material material)
	{
		super(material);
		this.name = name;
		this.setRegistryName(Resources.MODID, this.name);
		this.setUnlocalizedName(this.name);
	}

	public PTileEntity getAssociatedTileEntity()
	{
		return null;
	}

	public String getName()
	{
		return name;
	}

	public ItemBlock createItemBlock()
	{
		ItemBlock ib = new ItemBlock(this);
		ib.setRegistryName(Resources.MODID, this.name);
		return ib;
	}

	public ItemBlock getAssociatedItemBlock()
	{
		if (this.ib == null)
			this.ib = createItemBlock();
		return this.ib;
	}

	public void registerAllTypes()
	{
		RegistryModel.register(this, Variants.INVENTORY);
	}
}