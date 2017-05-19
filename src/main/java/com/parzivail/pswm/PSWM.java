package com.parzivail.pswm;

import com.parzivail.pswm.commands.CommandChangeDim;
import com.parzivail.pswm.handler.EventHandler;
import com.parzivail.pswm.proxy.CommonProxy;
import com.parzivail.util.common.Lumberjack;
import com.parzivail.util.driven.EntityCamera;
import com.parzivail.util.lwjgl.Vector2f;
import com.parzivail.util.lwjgl.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.PersistentRegistryManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
 * Created by colby on 12/18/2016.
 */
@Mod(modid = Resources.MODID, version = Resources.VERSION, name = "Parzi's Star Wars Mod", acceptedMinecraftVersions = "[1.11]")
public class PSWM
{
	@SidedProxy(clientSide = "com.parzivail.pswm.proxy.ClientProxy", serverSide = "com.parzivail.pswm.proxy.ServerProxy")
	public static CommonProxy proxy;

	public static EventHandler eventHandler;

	public static CreativeTabs tabBlocks;
	public static CreativeTabs tabWeapons;

	@SideOnly(Side.CLIENT)
	public static Minecraft mc;
	public static Random rngGeneral = new Random();

	public static EntityCamera camera;
	public static Vector3f cameraPosition;
	public static Vector2f cameraRotation;
	public static PSWM instance;

	private static String[] registerScript = getScript();
	public static DamageSource blasterDamageSource;
	public File modConfigDir;

	private static String[] getScript()
	{
		ArrayList<String> script = new ArrayList<>();

		script.add("(Intercom): Stand-by alert. Death Star approaching. Estimated time to firing range, fifteen minutes.");
		script.add("(Red Leader): All wings report in.");
		script.add("(Red Squadron): Standing by.");
		script.add("(Red Leader): Lock S-foils in attack position.");
		script.add("(Red Leader): We're passing through their magnetic field. Hold tight! Switch your deflectors on Double-Front.");
		script.add("(Wedge): Look at the size of that thing!");
		script.add("(Red Leader): Cut the chatter, Red Two. Accelerate to attack speed. This is it, boys!");
		script.add("(Gold Leader): Red Leader, this is Gold Leader.");
		script.add("(Red Leader): I copy, Gold Leader.");
		script.add("(Gold Leader): We're starting for the target shaft now.");
		script.add("(Red Leader): We're in position. I'm going to cut across the axis and try and draw their fire.");

		return script.toArray(new String[script.size()]);
	}

	private static int scriptIndex = 0;

	@Mod.EventHandler
	public void preinit(FMLPreInitializationEvent event)
	{
		instance = this;
		this.modConfigDir = event.getModConfigurationDirectory();

		Lumberjack.debug("PREINIT=+=+=+PSWM=+=+=+=+START");

		proxy.preinit();

		Lumberjack.debug("PREINIT=+=+=+PSWM=+=+=+=+=+END");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		Lumberjack.debug("INIT+=+=+=+=+PSWM=+=+=+=+START");

		proxy.init();

		Lumberjack.debug("INIT+=+=+=+=+PSWM=+=+=+=+=+END");
	}

	@Mod.EventHandler
	public void postinit(FMLPostInitializationEvent event)
	{
		Lumberjack.debug("POSTINIT+=+=+PSWM=+=+=+=+START");

		proxy.postinit();

		Lumberjack.debug("POSTINIT+=+=+PSWM=+=+=+=+=+END");
	}

	@Mod.EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new CommandChangeDim());
	}

	public static String getNextRegisterMessage(String context)
	{
		if (scriptIndex >= registerScript.length)
			return context;
		return String.format("[%s] %s", context, registerScript[scriptIndex++]);
	}

	public static void saveNbtMappings(File file)
	{
		NBTTagCompound compound = new NBTTagCompound();
		NBTTagList blockMap = new NBTTagList();

		PersistentRegistryManager.GameDataSnapshot gameDataSnapshot = PersistentRegistryManager.takeSnapshot();

		for (Map.Entry<ResourceLocation, PersistentRegistryManager.GameDataSnapshot.Entry> entry : gameDataSnapshot.entries.entrySet())
		{
			int id = entry.getValue().ids.values().toArray(new Integer[0])[0]; // wtf

			NBTTagCompound c = new NBTTagCompound();
			c.setString("k", entry.toString());
			c.setInteger("v", id);
			blockMap.appendTag(c);
		}
		compound.setTag("map", blockMap);

		try
		{
			OutputStream outputStream = new FileOutputStream(file);
			CompressedStreamTools.writeCompressed(compound, outputStream);
			outputStream.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}