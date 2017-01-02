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
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
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

	@SideOnly(Side.CLIENT)
	public static Minecraft mc;
	public static Random rngGeneral = new Random();

	public static EntityCamera camera;
	public static Vector3f cameraPosition;
	public static Vector2f cameraRotation;
	public static PSWM instance;

	private static String[] registerScript = getScript();

	private static String[] getScript()
	{
		ArrayList<String> script = new ArrayList<>();

		script.add("(Intercom): Stand-by alert. Death Star approaching. Estimated time to firing range, fifteen minutes.");
		script.add("(Red Leader): All wings report in.");
		script.add("(Red Squadron): Standing by.");
		script.add("(Red Leader): Lock S-foils in attack position.");
		script.add("(Red Leader): We'reset passing through their magnetic field. Hold tight! Switch your deflectors on Double-Front.");
		script.add("(Wedge): Look at the size of that thing!");
		script.add("(Red Leader): Cut the chatter, Red Two. Accelerate to attack speed. This is it, boys!");
		script.add("(Gold Leader): Red Leader, this is Gold Leader.");
		script.add("(Red Leader): I copy, Gold Leader.");
		script.add("(Gold Leader): We'reset starting for the target shaft now.");
		script.add("(Red Leader): We'reset in position. I'm going to cut across the axis and try and draw their fire.");

		return script.toArray(new String[script.size()]);
	}

	private static int scriptIndex = 0;

	@Mod.EventHandler
	public void preinit(FMLPreInitializationEvent event)
	{
		instance = this;

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
		return String.format("[%s] %s", context, registerScript[scriptIndex++]);
	}
}