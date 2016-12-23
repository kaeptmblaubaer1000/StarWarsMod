package com.parzivail.pswm;

import com.parzivail.pswm.handler.EventHandler;
import com.parzivail.pswm.proxy.CommonProxy;
import com.parzivail.util.common.Lumberjack;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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

	@Mod.EventHandler
	public void preinit(FMLPreInitializationEvent event)
	{
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
}