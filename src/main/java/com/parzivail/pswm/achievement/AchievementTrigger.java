package com.parzivail.pswm.achievement;

import com.parzivail.pswm.Resources.ConfigOptions;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.items.ItemQuestLog;
import com.parzivail.pswm.items.weapons.ItemLightsaber;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class AchievementTrigger
{
	@SubscribeEvent
	public void onDimChanged(PlayerEvent.PlayerChangedDimensionEvent event)
	{
		if (event.toDim == ConfigOptions.dimTatooineId)
			event.player.addStat(StarWarsAchievements.travelTatooine, 1);
		else if (event.toDim == ConfigOptions.dimEndorId)
			event.player.addStat(StarWarsAchievements.travelEndor, 1);
		else if (event.toDim == ConfigOptions.dimHothId)
			event.player.addStat(StarWarsAchievements.travelHoth, 1);
		else if (event.toDim == ConfigOptions.dimKashyyykId)
			event.player.addStat(StarWarsAchievements.travelKashyyyk, 1);
		else if (event.toDim == ConfigOptions.dimYavin4Id)
			event.player.addStat(StarWarsAchievements.travelYavin, 1);
		else if (event.toDim == ConfigOptions.dimSpaceId)
			event.player.addStat(StarWarsAchievements.travelSpace, 1);
		else if (event.toDim == ConfigOptions.dimIlumId)
			event.player.addStat(StarWarsAchievements.travelIlum, 1);
		else if (event.toDim == ConfigOptions.dimDagobahId)
			event.player.addStat(StarWarsAchievements.travelDagobah, 1);

		if (ItemQuestLog.getQuestContainer(event.player) != null && !event.player.worldObj.isRemote)
		{
			ItemQuestLog.addDimTravel(ItemQuestLog.getQuestContainer(event.player), event.toDim);
		}
	}

	@SubscribeEvent
	public void onItemCrafted(PlayerEvent.ItemCraftedEvent event)
	{
		if (event.crafting != null)
			if (event.crafting.getItem() == StarWarsItems.jediRobes)
				event.player.addStat(StarWarsAchievements.becomeJedi, 1);
			else if (event.crafting.getItem() == StarWarsItems.hyperdriveEngine)
				event.player.addStat(StarWarsAchievements.craftHyperdrive, 1);
			else if (event.crafting.getItem() instanceof ItemLightsaber)
				event.player.addStat(StarWarsAchievements.craftLightsaber, 1);
	}
}
