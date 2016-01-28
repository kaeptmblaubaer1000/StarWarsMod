package com.parzivail.pswm.rendering.gui;

import com.parzivail.pswm.tileentities.TileEntityHoloTableBase;
import com.parzivail.pswm.tileentities.TileEntityHoloTableWar;
import com.parzivail.pswm.tileentities.TileEntityMV;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

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