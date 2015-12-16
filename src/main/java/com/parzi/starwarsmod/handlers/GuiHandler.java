package com.parzi.starwarsmod.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.parzi.starwarsmod.rendering.gui.ContainerMV;
import com.parzi.starwarsmod.rendering.gui.GuiJediRobes;
import com.parzi.starwarsmod.rendering.gui.GuiLightJediRobes;
import com.parzi.starwarsmod.rendering.gui.GuiMV;
import com.parzi.starwarsmod.tileentities.TileEntityMV;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == 0)
			return new GuiMV(player.inventory, (TileEntityMV)world.getTileEntity(x, y, z));
		if (ID == 1)
			return new GuiJediRobes(player);
		if (ID == 2)
			return new GuiLightJediRobes(player);
		return null;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == 0)
			return new ContainerMV(player.inventory, (TileEntityMV)world.getTileEntity(x, y, z));
		if (ID == 1)
			return new GuiJediRobes(player);
		if (ID == 2)
			return new GuiLightJediRobes(player);
		return null;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\handlers\GuiHandler.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */