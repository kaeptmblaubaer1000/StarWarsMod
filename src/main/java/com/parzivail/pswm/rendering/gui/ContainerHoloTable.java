package com.parzivail.pswm.rendering.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

import com.parzivail.pswm.tileentities.TileEntityHoloTableBase;

public class ContainerHoloTable extends Container
{
	private TileEntityHoloTableBase table;

	public ContainerHoloTable(TileEntityHoloTableBase table)
	{
		this.table = table;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return this.table.isUseableByPlayer(player);
	}
}