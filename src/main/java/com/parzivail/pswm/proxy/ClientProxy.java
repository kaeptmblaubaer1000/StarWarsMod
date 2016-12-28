package com.parzivail.pswm.proxy;

import com.parzivail.pswm.PSWM;
import com.parzivail.pswm.models.guns.ItemModelTESR;
import com.parzivail.pswm.models.guns.ModelA280;
import com.parzivail.pswm.models.guns.TModelA280;
import com.parzivail.pswm.registry.KeybindRegistry;
import com.parzivail.util.Util;
import com.parzivail.util.block.Variants;
import com.parzivail.util.common.Lumberjack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.server.management.PlayerList;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
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

		ClientRegistry.bindTileEntitySpecialRenderer(TModelA280.class, new ItemModelTESR(new ModelA280()));
		ForgeHooksClient.registerTESRItemStack(Items.APPLE, 0, TModelA280.class);
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
	public void teleportPlayer(int id)
	{

	}
}
