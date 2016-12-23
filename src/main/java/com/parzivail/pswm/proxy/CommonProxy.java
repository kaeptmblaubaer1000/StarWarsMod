package com.parzivail.pswm.proxy;

import com.parzivail.pswm.PSWM;
import com.parzivail.pswm.Resources;
import com.parzivail.pswm.dimension.DimensionInfo;
import com.parzivail.pswm.handler.EventHandler;
import com.parzivail.pswm.handler.NetworkHandler;
import com.parzivail.pswm.network.MessageTeleportPlayer;
import com.parzivail.pswm.registry.BlockRegister;
import com.parzivail.pswm.registry.CreativeTabRegister;
import com.parzivail.util.common.Lumberjack;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by colby on 12/18/2016.
 */
public class CommonProxy
{
	public void preinit()
	{
		DimensionInfo.register();
		CreativeTabRegister.register();
		BlockRegister.register();

		NetworkHandler.register(MessageTeleportPlayer.class, Side.SERVER);
	}

	public void init()
	{
		Lumberjack.log("This is Parzi's Star Wars Mod v" + Resources.VERSION);

		PSWM.eventHandler = new EventHandler();
		MinecraftForge.EVENT_BUS.register(PSWM.eventHandler);
	}

	public EntityPlayerMP getPlayer()
	{
		return null;
	}

	public void registerItemRenderer(Item item, int meta, String id)
	{
	}

	public void teleportPlayer(int id)
	{
		DimensionInfo.teleportPlayerTo(PSWM.proxy.getPlayer(), id);
	}

	public void teleport(EntityPlayerMP entity, int id)
	{
		DimensionInfo.teleportPlayerTo(entity, id);
	}
}
