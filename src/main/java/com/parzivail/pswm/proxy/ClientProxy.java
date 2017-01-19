package com.parzivail.pswm.proxy;

import com.parzivail.pswm.PSWM;
import com.parzivail.pswm.Resources;
import com.parzivail.pswm.entity.EntityBlasterBoltBase;
import com.parzivail.pswm.entity.EntityXWingBolt;
import com.parzivail.pswm.handler.EventHandler;
import com.parzivail.pswm.handler.KeyHandler;
import com.parzivail.pswm.registry.KeybindRegistry;
import com.parzivail.pswm.render.misc.RenderBlasterBolt;
import com.parzivail.pswm.render.ship.*;
import com.parzivail.pswm.vehicle.*;
import com.parzivail.util.Util;
import com.parzivail.util.basic.Variants;
import com.parzivail.util.common.Lumberjack;
import com.parzivail.util.ui.ShaderHelper;
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
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Controllers;

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

		EventHandler.keyHandler = new KeyHandler();

		KeybindRegistry.register();

		ModelLoaderRegistry.registerLoader(com.parzivail.util.loader.OBJLoader.INSTANCE);

		ShaderHelper.initShaders();

		com.parzivail.util.loader.OBJLoader.INSTANCE.addDomain(Resources.MODID);
		//		ModelLoader.setCustomModelResourceLocation(Items.APPLE, 0, new ModelResourceLocation(Util.modcolon("luke"), "inventory"));

		RenderingRegistry.registerEntityRenderingHandler(VehicXWing.class, RenderXWing::new);
		RenderingRegistry.registerEntityRenderingHandler(VehicUWing.class, RenderUWing::new);
		RenderingRegistry.registerEntityRenderingHandler(VehicTIEStriker.class, RenderTIEStriker::new);
		RenderingRegistry.registerEntityRenderingHandler(VehicTIE.class, RenderTIE::new);
		RenderingRegistry.registerEntityRenderingHandler(VehicAWing.class, RenderAWing::new);
		RenderingRegistry.registerEntityRenderingHandler(VehicHothScoot.class, RenderHothScoot::new);
		RenderingRegistry.registerEntityRenderingHandler(VehicJakkuSpeeder.class, RenderJakkuSpeeder::new);
		RenderingRegistry.registerEntityRenderingHandler(VehicLandspeeder.class, RenderLandspeeder::new);
		RenderingRegistry.registerEntityRenderingHandler(VehicScootEmAround.class, RenderScootEmAround::new);
		RenderingRegistry.registerEntityRenderingHandler(VehicSkyhopper.class, RenderSkyhopper::new);
		RenderingRegistry.registerEntityRenderingHandler(VehicSnowspeeder.class, RenderSnowspeeder::new);
		RenderingRegistry.registerEntityRenderingHandler(VehicSpeederBike.class, RenderSpeederBike::new);
		RenderingRegistry.registerEntityRenderingHandler(VehicT85.class, RenderT85::new);
		RenderingRegistry.registerEntityRenderingHandler(VehicTIEAdvanced.class, RenderTIEAdvanced::new);
		RenderingRegistry.registerEntityRenderingHandler(VehicTIEBomber.class, RenderTIEBomber::new);
		RenderingRegistry.registerEntityRenderingHandler(VehicTIEInterceptor.class, RenderTIEInterceptor::new);
		RenderingRegistry.registerEntityRenderingHandler(VehicYWing.class, RenderYWing::new);
		RenderingRegistry.registerEntityRenderingHandler(VehicJR4Swoop.class, RenderJR4Swoop::new);

		RenderingRegistry.registerEntityRenderingHandler(EntityBlasterBoltBase.class, manager -> new RenderBlasterBolt(manager, 0xc1461d));
		RenderingRegistry.registerEntityRenderingHandler(EntityXWingBolt.class, manager -> new RenderBlasterBolt(manager, 0xc1461d, 2));

		try
		{
			Controllers.create();
			Lumberjack.log("%s joysticks detected.", Controllers.getControllerCount());
			for (int i = 0; i < Controllers.getControllerCount(); i++)
			{
				Lumberjack.log("Controller %s:\t%s", i, Controllers.getController(i).getName());
			}
			if (Controllers.getControllerCount() > 0 && KeyHandler.currentJoystick != -1)
			{
				KeyHandler.joystick = Controllers.getController(KeyHandler.currentJoystick);
				Lumberjack.log("Joystick %s detected, usable for Flight.", KeyHandler.joystick.getName());
			}
		}
		catch (LWJGLException e)
		{
			Lumberjack.log("Unable to detect joysticks.");
			e.printStackTrace();
		}
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
		return !(entityPlayer == null || PSWM.mc == null || PSWM.mc.player == null) && entityPlayer.getEntityId() == PSWM.mc.player.getEntityId();
	}
}
