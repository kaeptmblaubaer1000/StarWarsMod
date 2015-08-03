package com.parzi.starwarsmod.achievement;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.Lumberjack;

import cpw.mods.fml.common.FMLCommonHandler;

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

	public static void registerAll()
	{
		becomeJedi = new StarWarsAchievement("becomeJedi", -2, -1, StarWarsMod.lightJediRobes, null);

		fireBlaster = new StarWarsAchievement("fireBlaster", 2, -2, StarWarsMod.blasterRifle.getMeta("Stormtrooper"), null);

		craftLightsaber = new StarWarsAchievement("craftLightsaber", -1, 2, new ItemStack(StarWarsMod.lightsaber, 1, 2), null);
		craftHyperdrive = new StarWarsAchievement("craftHyperdrive", 1, 0, StarWarsMod.hyperdriveEngine, null);

		travelTatooine = new StarWarsAchievement("travelTatooine", 2, 1, StarWarsMod.hyperdriveTatooine, craftHyperdrive);
		travelHoth = new StarWarsAchievement("travelHoth", 2, 2, StarWarsMod.hyperdriveHoth, craftHyperdrive);
		travelYavin = new StarWarsAchievement("travelYavin", 2, 3, StarWarsMod.hyperdriveYavin4, craftHyperdrive);
		travelEndor = new StarWarsAchievement("travelEndor", 2, 4, StarWarsMod.hyperdriveEndor, craftHyperdrive);
		travelKashyyyk = new StarWarsAchievement("travelKashyyyk", 2, 5, StarWarsMod.hyperdriveKashyyyk, craftHyperdrive);

		page = new AchievementPage("Star Wars", StarWarsAchievement.achievements.toArray(new Achievement[StarWarsAchievement.achievements.size()]));
		AchievementPage.registerAchievementPage(page);

		FMLCommonHandler.instance().bus().register(new AchievementTrigger());

		Lumberjack.info("Achievements, reporting for duty!");
	}
}
