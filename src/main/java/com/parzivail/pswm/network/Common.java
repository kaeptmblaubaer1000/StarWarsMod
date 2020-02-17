package com.parzivail.pswm.network;

import com.parzivail.util.block.INameProvider;
import com.parzivail.util.common.Lumberjack;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

/**
 * Created by colby on 9/10/2017.
 */
public class Common
{
	private MinecraftServer MCServer;

	public void init()
	{
		Lumberjack.log("Server proxy loaded!");
	}

	public void checkLeftClickPressed(boolean selfReported)
	{

	}

	public MinecraftServer getMCServer()
	{
		return FMLCommonHandler.instance().getMinecraftServerInstance();
	}

	public void postInit()
	{
	}

	public void spawnSmokeParticle(World world, double x, double y, double z, double velocityX, double velocityY, double velocityZ)
	{
	}

	public void handleWorldDataSync(NBTTagCompound worldData)
	{
	}

	public void handlePlayerDataSync(int entityId, NBTTagCompound ieep)
	{
	}

	public <T extends Block & INameProvider> void registerBlockModel(T block)
	{
	}

	public void tickSounds(EntityPlayer player, ItemStack heldItem)
	{
	}

	public void hudDebug(String category, Object data)
	{
	}

	public void handleVehicleKeybinds()
	{
	}

	public void displayGuiScreen(GuiScreen gui)
	{
	}
}
