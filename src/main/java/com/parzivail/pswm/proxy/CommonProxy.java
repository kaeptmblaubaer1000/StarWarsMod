package com.parzivail.pswm.proxy;

import com.parzivail.pswm.PSWM;
import com.parzivail.pswm.Resources;
import com.parzivail.pswm.dimension.DimensionInfo;
import com.parzivail.pswm.handler.EventHandler;
import com.parzivail.pswm.handler.NetworkHandler;
import com.parzivail.pswm.network.MessageDrivableControl;
import com.parzivail.pswm.network.MessageTeleportPlayer;
import com.parzivail.pswm.registry.BlockRegister;
import com.parzivail.pswm.registry.CreativeTabRegister;
import com.parzivail.pswm.registry.ItemRegister;
import com.parzivail.pswm.vehicle.VehicTIE;
import com.parzivail.pswm.vehicle.VehicTIEStriker;
import com.parzivail.pswm.vehicle.VehicUWing;
import com.parzivail.pswm.vehicle.VehicXWing;
import com.parzivail.util.EntityUtils;
import com.parzivail.util.common.Lumberjack;
import com.parzivail.util.driven.EntityCamera;
import net.minecraft.entity.player.EntityPlayer;
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
		ItemRegister.register();

		NetworkHandler.register(MessageTeleportPlayer.class, Side.SERVER);
		NetworkHandler.register(MessageDrivableControl.class, Side.SERVER);
		NetworkHandler.register(MessageDrivableControl.class, Side.CLIENT);
		Lumberjack.log(PSWM.getNextRegisterMessage("NET"));
	}

	public void init()
	{
		Lumberjack.log("This is Parzi's Star Wars Mod v" + Resources.VERSION);

		PSWM.eventHandler = new EventHandler();
		MinecraftForge.EVENT_BUS.register(PSWM.eventHandler);
	}

	public void postinit()
	{
		EntityUtils.registerEntity(VehicXWing.class, "xwing");
		EntityUtils.registerEntity(VehicUWing.class, "uwing");
		EntityUtils.registerEntity(VehicTIEStriker.class, "tiestriker");
		EntityUtils.registerEntity(VehicTIE.class, "tie");
		EntityUtils.registerEntity(EntityCamera.class, "camera");
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
		Lumberjack.debug("Teleporting %s to %s", entity.getName(), id);
		DimensionInfo.teleportPlayerTo(entity, id);
	}

	public boolean isThePlayer(EntityPlayer entityPlayer)
	{
		return false;
	}
}
