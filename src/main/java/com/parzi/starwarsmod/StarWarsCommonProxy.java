package com.parzi.starwarsmod;

import com.parzi.starwarsmod.rendering.gui.JediGUI;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class StarWarsCommonProxy implements IGuiHandler
{
	public void registerRendering()
	{
		/* GUIs */
		NetworkRegistry.INSTANCE.registerGuiHandler(StarWarsMod.getInstance(), StarWarsMod.proxy);
	}

	public void registerKeybindings()
	{
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}
}
