package com.parzi.starwarsmod.achievement;

import com.parzi.starwarsmod.StarWarsMod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;

public class AchievementTrigger
{
	@SubscribeEvent
	public void onDimChanged(PlayerChangedDimensionEvent event)
	{
		if (event.toDim == StarWarsMod.dimTatooineId)
		{
			event.player.addStat(StarWarsAchievements.travelTatooine, 1);
		}
		else if (event.toDim == StarWarsMod.dimEndorId)
		{
			event.player.addStat(StarWarsAchievements.travelEndor, 1);
		}
		else if (event.toDim == StarWarsMod.dimHothId)
		{
			event.player.addStat(StarWarsAchievements.travelHoth, 1);
		}
		else if (event.toDim == StarWarsMod.dimKashyyykId)
		{
			event.player.addStat(StarWarsAchievements.travelKashyyyk, 1);
		}
		else if (event.toDim == StarWarsMod.dimYavin4Id)
		{
			event.player.addStat(StarWarsAchievements.travelYavin, 1);
		}
	}

	@SubscribeEvent
	public void onItemCrafted(ItemCraftedEvent event)
	{
		if (event.crafting != null)
		{
			if (event.crafting.getItem() == StarWarsMod.jediRobes || event.crafting.getItem() == StarWarsMod.lightJediRobes)
			{
				event.player.addStat(StarWarsAchievements.becomeJedi, 1);
			}
			else if (event.crafting.getItem() == StarWarsMod.hyperdriveEngine)
			{
				event.player.addStat(StarWarsAchievements.craftHyperdrive, 1);
			}
			else if (event.crafting.getItem() == StarWarsMod.lightsaber)
			{
				event.player.addStat(StarWarsAchievements.craftLightsaber, 1);
			}
		}
	}
}
