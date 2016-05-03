package com.parzivail.pswm.handlers;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.quest.GuiQuest;
import com.parzivail.pswm.rendering.gui.*;
import com.parzivail.pswm.tileentities.TileEntityHoloTableBase;
import com.parzivail.pswm.tileentities.TileEntityMV;
import com.parzivail.pswm.tileentities.TileEntityStaticNpc;
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
		else if (id == Resources.GUI_ROBES)
			return new GuiScreenJediRobes(player);
		else if (id == Resources.GUI_JEDI_SITH)
			return new GuiJediSith(player);
		else if (id == Resources.GUI_HOLOTABLE)
			return new GuiHoloTable(player, (TileEntityHoloTableBase)world.getTileEntity(x, y, z));
		else if (id == Resources.GUI_QUESTLOG)
			return new GuiQuest(player, ((TileEntityStaticNpc)world.getTileEntity(x, y, z)).getId());
		else if (id == Resources.GUI_LSFORGE)
			return new GuiScreenLightsaberForge(player);
		else if (id == Resources.GUI_SCANNER)
			return new GuiIDScanner(player);
		return null;
	}

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		if (id == Resources.GUI_MV)
			return new ContainerMV(player.inventory, (TileEntityMV)world.getTileEntity(x, y, z));
		else if (id == Resources.GUI_ROBES)
			return new ContainerClient();
		else if (id == Resources.GUI_JEDI_SITH)
			return new ContainerClient();
		else if (id == Resources.GUI_HOLOTABLE)
			return new ContainerHoloTable((TileEntityHoloTableBase)world.getTileEntity(x, y, z));
		else if (id == Resources.GUI_QUESTLOG || id == Resources.GUI_LSFORGE || id == Resources.GUI_SCANNER)
			return new ContainerClient();
		return null;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\handlers\GuiHandler.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */