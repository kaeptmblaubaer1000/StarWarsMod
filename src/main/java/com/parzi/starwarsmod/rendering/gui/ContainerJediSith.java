package com.parzi.starwarsmod.rendering.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerJediSith extends Container
{
	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_)
	{
		return p_75145_1_.isClientWorld();
	}
}