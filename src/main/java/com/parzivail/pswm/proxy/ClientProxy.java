package com.parzivail.pswm.proxy;

import com.parzivail.pswm.PSWM;
import com.parzivail.pswm.Resources;
import com.parzivail.pswm.registry.KeybindRegistry;
import com.parzivail.pswm.render.RenderUWing;
import com.parzivail.pswm.render.RenderXWing;
import com.parzivail.pswm.vehicle.VehicUWing;
import com.parzivail.pswm.vehicle.VehicXWing;
import com.parzivail.util.Util;
import com.parzivail.util.basic.Variants;
import com.parzivail.util.common.Lumberjack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.server.management.PlayerList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.UUID;

/**
 * Created by colby on 12/18/2016.
 */
public class ClientProxy extends CommonProxy
{
	@Override
	public void preinit()
	{
		super.preinit();
		PSWM.mc = Minecraft.getMinecraft();

		KeybindRegistry.register();

		ModelLoaderRegistry.registerLoader(com.parzivail.util.loader.OBJLoader.INSTANCE);

		com.parzivail.util.loader.OBJLoader.INSTANCE.addDomain(Resources.MODID);
		//		ModelLoader.setCustomModelResourceLocation(Items.APPLE, 0, new ModelResourceLocation(Util.modcolon("luke"), "inventory"));

		RenderingRegistry.registerEntityRenderingHandler(VehicXWing.class, RenderXWing::new);
		RenderingRegistry.registerEntityRenderingHandler(VehicUWing.class, RenderUWing::new);
	}

	@Override
	public EntityPlayerMP getPlayer()
	{
		PlayerList list = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList();
		UUID player = PSWM.mc.player.getPersistentID();
		return list.getPlayerByUUID(player);
	}

	@Override
	public void registerItemRenderer(Item item, int meta, String id)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Util.modcolon(id), Variants.INVENTORY));
		Lumberjack.debug("Registered renderer for item %s@%s", Util.modcolon(id), Variants.INVENTORY);
	}

	@Override
	public boolean isThePlayer(EntityPlayer entityPlayer)
	{
		if (entityPlayer == null || PSWM.mc == null || PSWM.mc.player == null)
			return false;
		return entityPlayer.getEntityId() == PSWM.mc.player.getEntityId();
	}
}
