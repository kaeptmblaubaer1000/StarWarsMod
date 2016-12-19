package com.parzivail.pswm;

import com.parzivail.pswm.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by colby on 12/18/2016.
 */
@Mod(modid = Resources.MODID, version = Resources.VERSION, name = "Parzi's Star Wars Mod", acceptedMinecraftVersions = "[1.11]")
public class PSWM
{
	@SidedProxy(clientSide = "com.parzivail.pswm.proxy.ClientProxy", serverSide = "com.parzivail.pswm.proxy.ServerProxy")
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preinit(FMLPreInitializationEvent event)
	{
		proxy.preinit(event.getSide());
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
	}
}