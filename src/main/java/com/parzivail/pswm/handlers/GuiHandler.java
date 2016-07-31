package com.parzivail.pswm.handlers;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.blocks.npc.BlockNpcBase;
import com.parzivail.pswm.gui.*;
import com.parzivail.pswm.quest.GuiQuestLog;
import com.parzivail.pswm.quest.GuiQuestNpc;
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
			return new GuiQuestNpc(((BlockNpcBase)world.getBlock(x, y, z)).getQuestForPlayer(player), player, ((TileEntityStaticNpc)world.getTileEntity(x, y, z)));
		else if (id == Resources.GUI_QUEST)
			return new GuiQuestLog(player);
		else if (id == Resources.GUI_LSFORGE)
			return new GuiScreenLightsaberForge(player);
		else if (id == Resources.GUI_SCANNER)
			return new GuiIDScanner(player);
		else if (id == Resources.GUI_HYPERDRIVE)
		{
			GuiScreenHyperdrive guiScreenHyperdrive = new GuiScreenHyperdrive(player);
			guiScreenHyperdrive.didComeFromBlock = world != null && world.getTileEntity(x, y, z) instanceof TileEntityHyperdrive;
			return guiScreenHyperdrive;
		}
		else if (id == Resources.GUI_ANTENNA)
			return new GuiAntenna(player, (TileEntityAntenna)world.getTileEntity(x, y, z));
		else if (id == Resources.GUI_CRYSTALCOMPRESSOR)
			return new GuiCrystalCompressor(player.inventory, (TileEntityCrystalCompressor)world.getTileEntity(x, y, z));
		else if (id == Resources.GUI_QUARTERMASTER)
			return new GuiScreenQuartermaster(player, (TileEntityStaticNpc)world.getTileEntity(x, y, z));
		else if (id == Resources.GUI_QUARTERMASTER_EMPIRE)
			return new GuiScreenQuartermasterEmpire(player, (TileEntityStaticNpc)world.getTileEntity(x, y, z));
		else if (id == Resources.GUI_JAWA)
			return new GuiScreenJawa(player);
		return null;
	}

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		if (id == Resources.GUI_MV)
			return new ContainerMV(player.inventory, (TileEntityMV)world.getTileEntity(x, y, z));
		else if (id == Resources.GUI_HOLOTABLE)
			return new ContainerHoloTable((TileEntityHoloTableBase)world.getTileEntity(x, y, z));
		else if (id == Resources.GUI_QUARTERMASTER || id == Resources.GUI_QUARTERMASTER_EMPIRE || id == Resources.GUI_QUESTNPC || id == Resources.GUI_ANTENNA || id == Resources.GUI_QUEST || id == Resources.GUI_LSFORGE || id == Resources.GUI_SCANNER || id == Resources.GUI_HYPERDRIVE || id == Resources.GUI_ROBES || id == Resources.GUI_JEDI_SITH)
			return new ContainerClient();
		else if (id == Resources.GUI_CRYSTALCOMPRESSOR)
			return new ContainerCrystalCompressor(player.inventory, (TileEntityCrystalCompressor)world.getTileEntity(x, y, z));
		return null;
	}
}
