package com.parzivail.pswm;

import com.parzivail.pswm.Resources.ConfigOptions;
import com.parzivail.pswm.entities.EntityBlasterEzraBolt;
import com.parzivail.pswm.entities.EntityBlasterHeavyBolt;
import com.parzivail.pswm.entities.EntityBlasterPistolBolt;
import com.parzivail.pswm.entities.EntityBlasterProbeBolt;
import com.parzivail.pswm.entities.EntityBlasterRifleBolt;
import com.parzivail.pswm.entities.EntityDestruction;
import com.parzivail.pswm.entities.EntitySpeederBlasterRifleBolt;
import com.parzivail.pswm.entities.EntityTIEBolt;
import com.parzivail.pswm.entities.EntityXWingBolt;
import com.parzivail.pswm.font.FontManager;
import com.parzivail.pswm.items.weapons.ItemLightsaber;
import com.parzivail.pswm.mobs.MobBantha;
import com.parzivail.pswm.mobs.MobBith;
import com.parzivail.pswm.mobs.MobDewback;
import com.parzivail.pswm.mobs.MobDroidAstromech;
import com.parzivail.pswm.mobs.MobDroidAstromech2;
import com.parzivail.pswm.mobs.MobDroidAstromechBb8;
import com.parzivail.pswm.mobs.MobDroidAstromechImperial;
import com.parzivail.pswm.mobs.MobDroidAstromechImperial2;
import com.parzivail.pswm.mobs.MobDroidGNK;
import com.parzivail.pswm.mobs.MobDroidMouse;
import com.parzivail.pswm.mobs.MobDroidProbe;
import com.parzivail.pswm.mobs.MobDroidProtocol;
import com.parzivail.pswm.mobs.MobDroidProtocol2;
import com.parzivail.pswm.mobs.MobDroidSurgical;
import com.parzivail.pswm.mobs.MobDroidTreadwell;
import com.parzivail.pswm.mobs.MobEwok;
import com.parzivail.pswm.mobs.MobGamorrean;
import com.parzivail.pswm.mobs.MobJawa;
import com.parzivail.pswm.mobs.MobSandtrooper;
import com.parzivail.pswm.mobs.MobTatooineCommoner;
import com.parzivail.pswm.mobs.MobTauntaun;
import com.parzivail.pswm.mobs.MobTusken;
import com.parzivail.pswm.mobs.MobWampa;
import com.parzivail.pswm.mobs.MobWookiee;
import com.parzivail.pswm.models.ModelDSTurret;
import com.parzivail.pswm.models.mobs.ModelBantha;
import com.parzivail.pswm.models.mobs.ModelBith;
import com.parzivail.pswm.models.mobs.ModelDewback;
import com.parzivail.pswm.models.mobs.ModelDroidAstromech;
import com.parzivail.pswm.models.mobs.ModelDroidAstromech2;
import com.parzivail.pswm.models.mobs.ModelDroidBb8;
import com.parzivail.pswm.models.mobs.ModelDroidMouse;
import com.parzivail.pswm.models.mobs.ModelDroidProbe;
import com.parzivail.pswm.models.mobs.ModelDroidProtocol;
import com.parzivail.pswm.models.mobs.ModelDroidSurgical;
import com.parzivail.pswm.models.mobs.ModelDroidTreadwell;
import com.parzivail.pswm.models.mobs.ModelGNK;
import com.parzivail.pswm.models.mobs.ModelGamorrean;
import com.parzivail.pswm.models.mobs.ModelSmallBiped;
import com.parzivail.pswm.models.mobs.ModelTaunNew;
import com.parzivail.pswm.models.mobs.ModelWampa;
import com.parzivail.pswm.models.mobs.ModelWookiee;
import com.parzivail.pswm.models.vehicles.ModelATST;
import com.parzivail.pswm.models.vehicles.ModelAWing;
import com.parzivail.pswm.models.vehicles.ModelJakkuSpeeder;
import com.parzivail.pswm.models.vehicles.ModelLandspeeder;
import com.parzivail.pswm.models.vehicles.ModelSkyhopper;
import com.parzivail.pswm.models.vehicles.ModelSnowspeeder;
import com.parzivail.pswm.models.vehicles.ModelSpeederBike;
import com.parzivail.pswm.models.vehicles.ModelTIE;
import com.parzivail.pswm.models.vehicles.ModelTIEInterceptor;
import com.parzivail.pswm.models.vehicles.ModelXWing;
import com.parzivail.pswm.registry.KeybindRegistry;
import com.parzivail.pswm.registry.RegisterGuiOverlays;
import com.parzivail.pswm.rendering.RenderBactaTank;
import com.parzivail.pswm.rendering.RenderBantha;
import com.parzivail.pswm.rendering.RenderBasket;
import com.parzivail.pswm.rendering.RenderBith;
import com.parzivail.pswm.rendering.RenderBlasterBolt;
import com.parzivail.pswm.rendering.RenderBlockFieldEmitter;
import com.parzivail.pswm.rendering.RenderBlockMudTable;
import com.parzivail.pswm.rendering.RenderBlockTatooineTable;
import com.parzivail.pswm.rendering.RenderCommoner;
import com.parzivail.pswm.rendering.RenderDSTurret;
import com.parzivail.pswm.rendering.RenderDeathStarDoor;
import com.parzivail.pswm.rendering.RenderDewback;
import com.parzivail.pswm.rendering.RenderDroidAstromech;
import com.parzivail.pswm.rendering.RenderDroidAstromech2;
import com.parzivail.pswm.rendering.RenderDroidBb8;
import com.parzivail.pswm.rendering.RenderDroidMouse;
import com.parzivail.pswm.rendering.RenderDroidProbe;
import com.parzivail.pswm.rendering.RenderDroidProtocol;
import com.parzivail.pswm.rendering.RenderDroidSurgical;
import com.parzivail.pswm.rendering.RenderDroidTreadwell;
import com.parzivail.pswm.rendering.RenderEwok;
import com.parzivail.pswm.rendering.RenderGNK;
import com.parzivail.pswm.rendering.RenderGamorrean;
import com.parzivail.pswm.rendering.RenderHangingBucket;
import com.parzivail.pswm.rendering.RenderHangingCauldron;
import com.parzivail.pswm.rendering.RenderHoloTable;
import com.parzivail.pswm.rendering.RenderHuman;
import com.parzivail.pswm.rendering.RenderJawa;
import com.parzivail.pswm.rendering.RenderLightsaber;
import com.parzivail.pswm.rendering.RenderMV;
import com.parzivail.pswm.rendering.RenderTauntaun;
import com.parzivail.pswm.rendering.RenderTusken;
import com.parzivail.pswm.rendering.RenderWampa;
import com.parzivail.pswm.rendering.RenderWookiee;
import com.parzivail.pswm.rendering.helper.PSWMEntityRenderer;
import com.parzivail.pswm.rendering.item.RenderBlasterHeavy;
import com.parzivail.pswm.rendering.item.RenderBlasterPistol;
import com.parzivail.pswm.rendering.item.RenderBlasterRifle;
import com.parzivail.pswm.rendering.item.RenderBowcaster;
import com.parzivail.pswm.rendering.item.RenderGaffi;
import com.parzivail.pswm.rendering.item.RenderGamL;
import com.parzivail.pswm.rendering.item.RenderGamM;
import com.parzivail.pswm.rendering.item.RenderGamS;
import com.parzivail.pswm.rendering.item.RenderSpear;
import com.parzivail.pswm.rendering.item.RenderVibro;
import com.parzivail.pswm.rendering.vehicles.RenderATST;
import com.parzivail.pswm.rendering.vehicles.RenderAWing;
import com.parzivail.pswm.rendering.vehicles.RenderJakkuSpeeder;
import com.parzivail.pswm.rendering.vehicles.RenderLandspeeder;
import com.parzivail.pswm.rendering.vehicles.RenderSkyhopper;
import com.parzivail.pswm.rendering.vehicles.RenderSnowspeeder;
import com.parzivail.pswm.rendering.vehicles.RenderSpeederBike;
import com.parzivail.pswm.rendering.vehicles.RenderTIE;
import com.parzivail.pswm.rendering.vehicles.RenderTIEInterceptor;
import com.parzivail.pswm.rendering.vehicles.RenderXWing;
import com.parzivail.pswm.tileentities.TileEntityBactaTank;
import com.parzivail.pswm.tileentities.TileEntityBasket;
import com.parzivail.pswm.tileentities.TileEntityDeathStarDoor;
import com.parzivail.pswm.tileentities.TileEntityFieldEmitter;
import com.parzivail.pswm.tileentities.TileEntityHangingBucket;
import com.parzivail.pswm.tileentities.TileEntityHangingCauldron;
import com.parzivail.pswm.tileentities.TileEntityHoloTableBase;
import com.parzivail.pswm.tileentities.TileEntityMV;
import com.parzivail.pswm.tileentities.TileEntityMudTable;
import com.parzivail.pswm.tileentities.TileEntityTatooineTable;
import com.parzivail.pswm.vehicles.VehicATST;
import com.parzivail.pswm.vehicles.VehicAWing;
import com.parzivail.pswm.vehicles.VehicHothSpeederBike;
import com.parzivail.pswm.vehicles.VehicJakkuSpeeder;
import com.parzivail.pswm.vehicles.VehicLandspeeder;
import com.parzivail.pswm.vehicles.VehicSkyhopper;
import com.parzivail.pswm.vehicles.VehicSnowspeeder;
import com.parzivail.pswm.vehicles.VehicSpeederBike;
import com.parzivail.pswm.vehicles.VehicTIE;
import com.parzivail.pswm.vehicles.VehicTIEInterceptor;
import com.parzivail.pswm.vehicles.VehicXWing;
import com.parzivail.pswm.weaponry.WeaponDSTurret;
import com.parzivail.util.ui.GLPalette;
import com.parzivail.util.ui.Lumberjack;
import com.parzivail.util.ui.ShaderHelper;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.client.MinecraftForgeClient;

public class StarWarsClientProxy extends StarWarsCommonProxy
{
	@Override
	public void doSidedThings()
	{
		Minecraft.getMinecraft().entityRenderer = new PSWMEntityRenderer(Minecraft.getMinecraft(), Minecraft.getMinecraft().getResourceManager());

		StarWarsMod.mc = Minecraft.getMinecraft();

		StarWarsMod.clientHandler.init();

		if (Minecraft.getMinecraft().getSession().getUsername().equalsIgnoreCase("StarWarsMod") || Minecraft.getMinecraft().getSession().getUsername().equalsIgnoreCase("weaston") || ConfigOptions.enableBetaFeatures)
		{
			Resources.IS_DEV_ENVIRONVENT = true;
			Lumberjack.info("Debug/Beta mechanics implemented!");
			Lumberjack.info("Please be warned, beta features may not be fully implemented, or may crash!");
		}

		KeybindRegistry.registerAll();

		FontManager.registerAll();

		ShaderHelper.initShaders();

		if (ConfigOptions.beshOverride)
			Minecraft.getMinecraft().fontRenderer = FontManager.aurebesh;

		Lumberjack.log("Client proxy loaded!");
	}

	@Override
	public void registerRendering()
	{
		RenderingRegistry.registerEntityRenderingHandler(MobWookiee.class, new RenderWookiee(new ModelWookiee(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobJawa.class, new RenderJawa(new ModelSmallBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobEwok.class, new RenderEwok(new ModelSmallBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobTauntaun.class, new RenderTauntaun(new ModelTaunNew(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobBantha.class, new RenderBantha(new ModelBantha(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobWampa.class, new RenderWampa(new ModelWampa(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobTusken.class, new RenderTusken(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobDroidGNK.class, new RenderGNK(new ModelGNK(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobGamorrean.class, new RenderGamorrean(new ModelGamorrean(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobDewback.class, new RenderDewback(new ModelDewback(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobTatooineCommoner.class, new RenderCommoner(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobBith.class, new RenderBith(new ModelBith(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobSandtrooper.class, new RenderHuman(new ModelBiped(), 0.5F));

		RenderingRegistry.registerEntityRenderingHandler(MobDroidAstromech.class, new RenderDroidAstromech(new ModelDroidAstromech(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobDroidAstromech2.class, new RenderDroidAstromech2(new ModelDroidAstromech2(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobDroidAstromechImperial.class, new RenderDroidAstromech(new ModelDroidAstromech(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobDroidAstromechImperial2.class, new RenderDroidAstromech2(new ModelDroidAstromech2(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobDroidAstromechBb8.class, new RenderDroidBb8(new ModelDroidBb8(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobDroidProbe.class, new RenderDroidProbe(new ModelDroidProbe(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobDroidProtocol.class, new RenderDroidProtocol(new ModelDroidProtocol(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobDroidProtocol2.class, new RenderDroidProtocol(new ModelDroidProtocol(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobDroidSurgical.class, new RenderDroidSurgical(new ModelDroidSurgical(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobDroidTreadwell.class, new RenderDroidTreadwell(new ModelDroidTreadwell(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobDroidMouse.class, new RenderDroidMouse(new ModelDroidMouse(), 0.5F));

		RenderingRegistry.registerEntityRenderingHandler(VehicHothSpeederBike.class, new RenderSpeederBike(new ModelSpeederBike(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(VehicSpeederBike.class, new RenderSpeederBike(new ModelSpeederBike(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(VehicLandspeeder.class, new RenderLandspeeder(new ModelLandspeeder(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(VehicJakkuSpeeder.class, new RenderJakkuSpeeder(new ModelJakkuSpeeder(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(VehicATST.class, new RenderATST(new ModelATST(), 0.5F));

		RenderingRegistry.registerEntityRenderingHandler(VehicTIE.class, new RenderTIE(new ModelTIE(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(VehicTIEInterceptor.class, new RenderTIEInterceptor(new ModelTIEInterceptor(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(VehicXWing.class, new RenderXWing(new ModelXWing(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(VehicAWing.class, new RenderAWing(new ModelAWing(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(VehicSkyhopper.class, new RenderSkyhopper(new ModelSkyhopper(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(VehicSnowspeeder.class, new RenderSnowspeeder(new ModelSnowspeeder(), 0.5F));

		RenderingRegistry.registerEntityRenderingHandler(WeaponDSTurret.class, new RenderDSTurret(new ModelDSTurret(), 0.5F));

		RenderingRegistry.registerEntityRenderingHandler(EntityBlasterPistolBolt.class, new RenderBlasterBolt(GLPalette.BRIGHT_RED));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlasterRifleBolt.class, new RenderBlasterBolt(GLPalette.BRIGHT_RED));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlasterHeavyBolt.class, new RenderBlasterBolt(GLPalette.BRIGHT_RED));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlasterProbeBolt.class, new RenderBlasterBolt(GLPalette.BRIGHT_RED));
		RenderingRegistry.registerEntityRenderingHandler(EntitySpeederBlasterRifleBolt.class, new RenderBlasterBolt(GLPalette.BRIGHT_RED));
		RenderingRegistry.registerEntityRenderingHandler(EntityXWingBolt.class, new RenderBlasterBolt(GLPalette.BRIGHT_ORANGE, 2.0f));
		RenderingRegistry.registerEntityRenderingHandler(EntityTIEBolt.class, new RenderBlasterBolt(GLPalette.NEON_GREEN, 2.0f));
		RenderingRegistry.registerEntityRenderingHandler(EntityDestruction.class, new RenderBlasterBolt(GLPalette.ELECTRIC_BLUE));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlasterEzraBolt.class, new RenderBlasterBolt(GLPalette.ELECTRIC_BLUE));

		for (ItemLightsaber i : StarWarsMod.lightsaberNew)
			MinecraftForgeClient.registerItemRenderer(i, new RenderLightsaber());
		MinecraftForgeClient.registerItemRenderer(StarWarsMod.lightsaberOff, new RenderLightsaber());

		MinecraftForgeClient.registerItemRenderer(StarWarsMod.blasterPistol, new RenderBlasterPistol());
		MinecraftForgeClient.registerItemRenderer(StarWarsMod.blasterRifle, new RenderBlasterRifle());
		MinecraftForgeClient.registerItemRenderer(StarWarsMod.blasterHeavy, new RenderBlasterHeavy());
		MinecraftForgeClient.registerItemRenderer(StarWarsMod.bowcaster, new RenderBowcaster());
		MinecraftForgeClient.registerItemRenderer(StarWarsMod.gamorreanAx1, new RenderGamS());
		MinecraftForgeClient.registerItemRenderer(StarWarsMod.gamorreanAx2, new RenderGamM());
		MinecraftForgeClient.registerItemRenderer(StarWarsMod.gamorreanAx3, new RenderGamL());
		MinecraftForgeClient.registerItemRenderer(StarWarsMod.vibroLance, new RenderVibro());
		MinecraftForgeClient.registerItemRenderer(StarWarsMod.ewokSpear, new RenderSpear());
		MinecraftForgeClient.registerItemRenderer(StarWarsMod.gaffiStick, new RenderGaffi());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMV.class, new RenderMV());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDeathStarDoor.class, new RenderDeathStarDoor());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHoloTableBase.class, new RenderHoloTable());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTatooineTable.class, new RenderBlockTatooineTable());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMudTable.class, new RenderBlockMudTable());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHangingCauldron.class, new RenderHangingCauldron());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHangingBucket.class, new RenderHangingBucket());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBasket.class, new RenderBasket());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFieldEmitter.class, new RenderBlockFieldEmitter());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBactaTank.class, new RenderBactaTank());

		RegisterGuiOverlays.registerAll();

		Lumberjack.log("Rendering registered!");
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\StarWarsClientProxy.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */