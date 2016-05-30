package com.parzivail.pswm.achievement;

import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.items.weapons.ItemLightsaber;
import com.parzivail.util.ui.Lumberjack;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

import java.util.Arrays;

public class StarWarsAchievements
{
	public static AchievementPage page;
	public static Achievement becomeJedi;
	public static Achievement fireBlaster;
	public static Achievement craftLightsaber;
	public static Achievement craftHyperdrive;
	public static Achievement travelTatooine;
	public static Achievement travelHoth;
	public static Achievement travelYavin;
	public static Achievement travelEndor;
	public static Achievement travelKashyyyk;
	public static Achievement ezraBlaster;

	public static void registerAll()
	{
		becomeJedi = new StarWarsAchievement("becomeJedi", -2, -1, StarWarsItems.jediRobes, null);
		fireBlaster = new StarWarsAchievement("fireBlaster", 2, -2, StarWarsItems.blasterRifle.getMeta("Stormtrooper"), null);
		craftLightsaber = new StarWarsAchievement("craftLightsaber", -1, 2, new ItemStack(StarWarsItems.lightsaberNew[9], 1, 2), null);
		craftHyperdrive = new StarWarsAchievement("craftHyperdrive", 1, 0, StarWarsItems.hyperdriveEngine, null);
		travelTatooine = new StarWarsAchievement("travelTatooine", 2, 1, StarWarsItems.hyperdriveTatooine, craftHyperdrive);
		travelHoth = new StarWarsAchievement("travelHoth", 2, 2, StarWarsItems.hyperdriveHoth, craftHyperdrive);
		travelYavin = new StarWarsAchievement("travelYavin", 2, 3, StarWarsItems.hyperdriveYavin4, craftHyperdrive);
		travelEndor = new StarWarsAchievement("travelEndor", 2, 4, StarWarsItems.hyperdriveEndor, craftHyperdrive);
		travelKashyyyk = new StarWarsAchievement("travelKashyyyk", 2, 5, StarWarsItems.hyperdriveKashyyyk, craftHyperdrive);
		ezraBlaster = new StarWarsAchievement("ezraBlaster", -4, 5, StarWarsItems.lightsaberNew[Arrays.asList(ItemLightsaber.hilts).indexOf("ezra")], null);
		page = new AchievementPage("Star Wars", StarWarsAchievement.achievements.toArray(new Achievement[StarWarsAchievement.achievements.size()]));
		AchievementPage.registerAchievementPage(page);
		FMLCommonHandler.instance().bus().register(new AchievementTrigger());
		Lumberjack.info("Achievements, reporting for duty!");

		// java ur dumb
	}
}
