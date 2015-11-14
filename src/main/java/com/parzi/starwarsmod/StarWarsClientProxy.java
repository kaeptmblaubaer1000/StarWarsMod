package com.parzi.starwarsmod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

import com.parzi.starwarsmod.entities.EntityBlasterHeavyBolt;
import com.parzi.starwarsmod.entities.EntityBlasterPistolBolt;
import com.parzi.starwarsmod.entities.EntityBlasterProbeBolt;
import com.parzi.starwarsmod.entities.EntityBlasterRifleBolt;
import com.parzi.starwarsmod.entities.EntitySpeederBlasterRifleBolt;
import com.parzi.starwarsmod.handlers.StarWarsEventHandler;
import com.parzi.starwarsmod.mobs.MobBantha;
import com.parzi.starwarsmod.mobs.MobBith;
import com.parzi.starwarsmod.mobs.MobDewback;
import com.parzi.starwarsmod.mobs.MobDroidAstromech;
import com.parzi.starwarsmod.mobs.MobDroidAstromech2;
import com.parzi.starwarsmod.mobs.MobDroidGNK;
import com.parzi.starwarsmod.mobs.MobDroidMouse;
import com.parzi.starwarsmod.mobs.MobDroidProbe;
import com.parzi.starwarsmod.mobs.MobDroidProtocol;
import com.parzi.starwarsmod.mobs.MobDroidProtocol2;
import com.parzi.starwarsmod.mobs.MobDroidSurgical;
import com.parzi.starwarsmod.mobs.MobDroidTreadwell;
import com.parzi.starwarsmod.mobs.MobEwok;
import com.parzi.starwarsmod.mobs.MobGamorrean;
import com.parzi.starwarsmod.mobs.MobJawa;
import com.parzi.starwarsmod.mobs.MobSandtrooper;
import com.parzi.starwarsmod.mobs.MobTatooineCommoner;
import com.parzi.starwarsmod.mobs.MobTauntaun;
import com.parzi.starwarsmod.mobs.MobTusken;
import com.parzi.starwarsmod.mobs.MobWampa;
import com.parzi.starwarsmod.mobs.MobWookiee;
import com.parzi.starwarsmod.registry.RegisterGuiOverlays;
import com.parzi.starwarsmod.rendering.RenderBantha;
import com.parzi.starwarsmod.rendering.RenderBith;
import com.parzi.starwarsmod.rendering.RenderBlasterBolt;
import com.parzi.starwarsmod.rendering.RenderBlockTable;
import com.parzi.starwarsmod.rendering.RenderCommoner;
import com.parzi.starwarsmod.rendering.RenderDSTurret;
import com.parzi.starwarsmod.rendering.RenderDewback;
import com.parzi.starwarsmod.rendering.RenderDroidAstromech;
import com.parzi.starwarsmod.rendering.RenderDroidAstromech2;
import com.parzi.starwarsmod.rendering.RenderDroidMouse;
import com.parzi.starwarsmod.rendering.RenderDroidProbe;
import com.parzi.starwarsmod.rendering.RenderDroidProtocol;
import com.parzi.starwarsmod.rendering.RenderDroidProtocol2;
import com.parzi.starwarsmod.rendering.RenderDroidSurgical;
import com.parzi.starwarsmod.rendering.RenderDroidTreadwell;
import com.parzi.starwarsmod.rendering.RenderEwok;
import com.parzi.starwarsmod.rendering.RenderGNK;
import com.parzi.starwarsmod.rendering.RenderGamorrean;
import com.parzi.starwarsmod.rendering.RenderHuman;
import com.parzi.starwarsmod.rendering.RenderJawa;
import com.parzi.starwarsmod.rendering.RenderLightsaber;
import com.parzi.starwarsmod.rendering.RenderLightsaberOff;
import com.parzi.starwarsmod.rendering.RenderMV;
import com.parzi.starwarsmod.rendering.RenderTauntaun;
import com.parzi.starwarsmod.rendering.RenderTusken;
import com.parzi.starwarsmod.rendering.RenderWampa;
import com.parzi.starwarsmod.rendering.RenderWookiee;
import com.parzi.starwarsmod.rendering.helper.FancyHaloRenderer;
import com.parzi.starwarsmod.rendering.models.ModelDSTurret;
import com.parzi.starwarsmod.rendering.models.mobs.ModelBantha;
import com.parzi.starwarsmod.rendering.models.mobs.ModelBith;
import com.parzi.starwarsmod.rendering.models.mobs.ModelDewback;
import com.parzi.starwarsmod.rendering.models.mobs.ModelDroidAstromech;
import com.parzi.starwarsmod.rendering.models.mobs.ModelDroidAstromech2;
import com.parzi.starwarsmod.rendering.models.mobs.ModelDroidMouse;
import com.parzi.starwarsmod.rendering.models.mobs.ModelDroidProbe;
import com.parzi.starwarsmod.rendering.models.mobs.ModelDroidProtocol;
import com.parzi.starwarsmod.rendering.models.mobs.ModelDroidSurgical;
import com.parzi.starwarsmod.rendering.models.mobs.ModelDroidTreadwell;
import com.parzi.starwarsmod.rendering.models.mobs.ModelGNK;
import com.parzi.starwarsmod.rendering.models.mobs.ModelGamorrean;
import com.parzi.starwarsmod.rendering.models.mobs.ModelSmallBiped;
import com.parzi.starwarsmod.rendering.models.mobs.ModelTauntaun;
import com.parzi.starwarsmod.rendering.models.mobs.ModelWampa;
import com.parzi.starwarsmod.rendering.models.mobs.ModelWookiee;
import com.parzi.starwarsmod.rendering.models.vehicles.ModelLandspeeder;
import com.parzi.starwarsmod.rendering.models.vehicles.ModelSpeederBike;
import com.parzi.starwarsmod.rendering.vehicles.RenderHothSpeederBike;
import com.parzi.starwarsmod.rendering.vehicles.RenderLandspeeder;
import com.parzi.starwarsmod.rendering.vehicles.RenderSpeederBike;
import com.parzi.starwarsmod.tileentities.TileEntityMV;
import com.parzi.starwarsmod.tileentities.TileEntityTable;
import com.parzi.starwarsmod.utils.PGui;
import com.parzi.starwarsmod.utils.PlayerHelper;
import com.parzi.starwarsmod.utils.RenderHelper;
import com.parzi.starwarsmod.vehicles.VehicHothSpeederBike;
import com.parzi.starwarsmod.vehicles.VehicLandspeeder;
import com.parzi.starwarsmod.vehicles.VehicSentientLandspeeder;
import com.parzi.starwarsmod.vehicles.VehicSpeederBike;
import com.parzi.starwarsmod.weaponry.WeaponDSTurret;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.IGuiHandler;

public class StarWarsClientProxy extends StarWarsCommonProxy
{
	@Override
	public void doSidedThings()
	{
		StarWarsMod.renderHelper = new RenderHelper(Minecraft.getMinecraft());
		StarWarsMod.playerHelper = new PlayerHelper(Minecraft.getMinecraft());
		StarWarsMod.pgui = new PGui(Minecraft.getMinecraft());

		RenderingRegistry.registerEntityRenderingHandler(MobWookiee.class, new RenderWookiee(new ModelWookiee(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobJawa.class, new RenderJawa(new ModelSmallBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobEwok.class, new RenderEwok(new ModelSmallBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobTauntaun.class, new RenderTauntaun(new ModelTauntaun(), 0.5F));
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
		RenderingRegistry.registerEntityRenderingHandler(MobDroidProbe.class, new RenderDroidProbe(new ModelDroidProbe(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobDroidProtocol.class, new RenderDroidProtocol(new ModelDroidProtocol(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobDroidProtocol2.class, new RenderDroidProtocol2(new ModelDroidProtocol(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobDroidSurgical.class, new RenderDroidSurgical(new ModelDroidSurgical(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobDroidTreadwell.class, new RenderDroidTreadwell(new ModelDroidTreadwell(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobDroidMouse.class, new RenderDroidMouse(new ModelDroidMouse(), 0.5F));

		RenderingRegistry.registerEntityRenderingHandler(VehicHothSpeederBike.class, new RenderHothSpeederBike(new ModelSpeederBike(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(VehicSpeederBike.class, new RenderSpeederBike(new ModelSpeederBike(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(VehicLandspeeder.class, new RenderLandspeeder(new ModelLandspeeder(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(VehicSentientLandspeeder.class, new RenderLandspeeder(new ModelLandspeeder(), 0.5F));

		RenderingRegistry.registerEntityRenderingHandler(WeaponDSTurret.class, new RenderDSTurret(new ModelDSTurret(), 0.5F));

		RenderingRegistry.registerEntityRenderingHandler(EntityBlasterPistolBolt.class, new RenderBlasterBolt(StarWarsMod.blasterBolt));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlasterRifleBolt.class, new RenderBlasterBolt(StarWarsMod.blasterRifleBolt));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlasterHeavyBolt.class, new RenderBlasterBolt(StarWarsMod.blasterRifleBolt));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlasterProbeBolt.class, new RenderBlasterBolt(StarWarsMod.blasterRifleBolt));
		RenderingRegistry.registerEntityRenderingHandler(EntitySpeederBlasterRifleBolt.class, new RenderBlasterBolt(StarWarsMod.blasterRifleBolt));

		MinecraftForgeClient.registerItemRenderer(StarWarsMod.lightsaber, new RenderLightsaber());
		MinecraftForgeClient.registerItemRenderer(StarWarsMod.lightsaberOff, new RenderLightsaberOff());
		MinecraftForgeClient.registerItemRenderer(StarWarsMod.jediRobes, new FancyHaloRenderer());
		MinecraftForgeClient.registerItemRenderer(StarWarsMod.lightJediRobes, new FancyHaloRenderer());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMV.class, new RenderMV());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTable.class, new RenderBlockTable());

		MinecraftForge.EVENT_BUS.register(new StarWarsEventHandler());

		RegisterGuiOverlays.registerAll();
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\StarWarsClientProxy.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */