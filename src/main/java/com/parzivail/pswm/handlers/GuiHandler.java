package com.parzivail.pswm.handlers;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.quest.GuiQuest;
import com.parzivail.pswm.quest.GuiQuestNpc;
import com.parzivail.pswm.rendering.gui.*;
import com.parzivail.pswm.tileentities.*;
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
			return new GuiHoloTable((TileEntityHoloTableBase)world.getTileEntity(x, y, z));
		else if (id == Resources.GUI_QUESTNPC)
			return new GuiQuestNpc(player, ((TileEntityStaticNpc)world.getTileEntity(x, y, z)).getId());
		else if (id == Resources.GUI_QUEST)
			return new GuiQuest(player);
		else if (id == Resources.GUI_LSFORGE)
			return new GuiScreenLightsaberForge(player);
		else if (id == Resources.GUI_SCANNER)
			return new GuiIDScanner(player);
		else if (id == Resources.GUI_HYPERDRIVE)
			return new GuiScreenHyperdrive(player);
		else if (id == Resources.GUI_ANTENNA)
			return new GuiAntenna(player, (TileEntityAntenna)world.getTileEntity(x, y, z));
		else if (id == Resources.GUI_CRYSTALCOMPRESSOR)
			return new GuiCrystalCompressor(player.inventory, (TileEntityCrystalCompressor)world.getTileEntity(x, y, z));
		return null;
	}

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		if (id == Resources.GUI_MV)
			return new ContainerMV(player.inventory, (TileEntityMV)world.getTileEntity(x, y, z));
		else if (id == Resources.GUI_HOLOTABLE)
			return new ContainerHoloTable((TileEntityHoloTableBase)world.getTileEntity(x, y, z));
		else if (id == Resources.GUI_QUESTNPC || id == Resources.GUI_ANTENNA || id == Resources.GUI_QUEST || id == Resources.GUI_LSFORGE || id == Resources.GUI_SCANNER || id == Resources.GUI_HYPERDRIVE || id == Resources.GUI_ROBES || id == Resources.GUI_JEDI_SITH)
			return new ContainerClient();
		return null;
	}
}
