package com.parzivail.pswm.rendering.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerClient extends Container
{
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return player.isClientWorld();
	}
}