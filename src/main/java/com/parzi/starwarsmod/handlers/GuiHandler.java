package com.parzi.starwarsmod.handlers;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.rendering.gui.ContainerJediRobes;
import com.parzi.starwarsmod.rendering.gui.ContainerMV;
import com.parzi.starwarsmod.rendering.gui.GuiMV;
import com.parzi.starwarsmod.rendering.gui.GuiScreenJediRobes;
import com.parzi.starwarsmod.tileentities.TileEntityMV;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		if (id == Resources.GUI_MV)
			return new GuiMV(player.inventory, (TileEntityMV)world.getTileEntity(x, y, z));
		if (id == Resources.GUI_ROBES)
			return new GuiScreenJediRobes(player);
		return null;
	}

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		if (id == Resources.GUI_MV)
			return new ContainerMV(player.inventory, (TileEntityMV)world.getTileEntity(x, y, z));
		if (id == Resources.GUI_ROBES)
			return new ContainerJediRobes();
		return null;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\handlers\GuiHandler.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */