package com.parzi.starwarsmod;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

import com.parzi.starwarsmod.entities.EntityBlasterBolt;
import com.parzi.starwarsmod.mobs.MobBantha;
import com.parzi.starwarsmod.mobs.MobDroidAstromech;
import com.parzi.starwarsmod.mobs.MobGNK;
import com.parzi.starwarsmod.mobs.MobJawa;
import com.parzi.starwarsmod.mobs.MobTauntaun;
import com.parzi.starwarsmod.mobs.MobTusken;
import com.parzi.starwarsmod.mobs.MobWookiee;
import com.parzi.starwarsmod.rendering.RenderBantha;
import com.parzi.starwarsmod.rendering.RenderBlasterBolt;
import com.parzi.starwarsmod.rendering.RenderDroidAstromech;
import com.parzi.starwarsmod.rendering.RenderGNK;
import com.parzi.starwarsmod.rendering.RenderJawa;
import com.parzi.starwarsmod.rendering.RenderMV;
import com.parzi.starwarsmod.rendering.RenderSpeederBike;
import com.parzi.starwarsmod.rendering.RenderTauntaun;
import com.parzi.starwarsmod.rendering.RenderTusken;
import com.parzi.starwarsmod.rendering.RenderWookiee;
import com.parzi.starwarsmod.rendering.models.ModelBantha;
import com.parzi.starwarsmod.rendering.models.ModelDroidAstromech;
import com.parzi.starwarsmod.rendering.models.ModelGNK;
import com.parzi.starwarsmod.rendering.models.ModelJawa;
import com.parzi.starwarsmod.rendering.models.ModelSpeederBike;
import com.parzi.starwarsmod.rendering.models.ModelTauntaun;
import com.parzi.starwarsmod.rendering.models.ModelWookiee;
import com.parzi.starwarsmod.tileentities.TileEntityMV;
import com.parzi.starwarsmod.vehicles.VehicSpeederBike;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.IGuiHandler;

public class StarWarsClientProxy extends StarWarsCommonProxy implements IGuiHandler
{
	@Override
	public void registerRendering()
	{
		/* Mobs */
		RenderingRegistry.registerEntityRenderingHandler(MobWookiee.class, new RenderWookiee(new ModelWookiee(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobJawa.class, new RenderJawa(new ModelJawa(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobTauntaun.class, new RenderTauntaun(new ModelTauntaun(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobBantha.class, new RenderBantha(new ModelBantha(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobTusken.class, new RenderTusken(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobGNK.class, new RenderGNK(new ModelGNK(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobDroidAstromech.class, new RenderDroidAstromech(new ModelDroidAstromech(), 0.5F));

		RenderingRegistry.registerEntityRenderingHandler(VehicSpeederBike.class, new RenderSpeederBike(new ModelSpeederBike(), 0.5F));

		/* Entities */
		RenderingRegistry.registerEntityRenderingHandler(EntityBlasterBolt.class, new RenderBlasterBolt(StarWarsMod.blasterBolt));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMV.class, new RenderMV());

		/* Events */
		MinecraftForge.EVENT_BUS.register(new StarWarsEventHandler());
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}
}
