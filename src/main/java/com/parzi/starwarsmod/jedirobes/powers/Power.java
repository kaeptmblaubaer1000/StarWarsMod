package com.parzi.starwarsmod.jedirobes.powers;

import net.minecraft.entity.player.EntityPlayer;

import com.parzi.starwarsmod.utils.ForceUtils;
import com.parzi.starwarsmod.utils.LangUtils;

public class Power
{
	public static Power getPowerFromName(String name)
	{
		if (name.equalsIgnoreCase("jump"))
			return ForceUtils.powerJump;
		else if (name.equalsIgnoreCase("push"))
			return ForceUtils.powerPush;
		else if (name.equalsIgnoreCase("pull"))
			return ForceUtils.powerPull;
		else if (name.equalsIgnoreCase("lightning"))
			return ForceUtils.powerLightning;
		else if (name.equalsIgnoreCase("destruction"))
			return ForceUtils.powerDestruction;
		return null;
	}

	public int currentLevel = 0;
	public int maxLevel = 5;
	public String name = "";
	public String unlocalizedName = "";
	public String unlocalizedDescription = "";
	public float rechargeTime = 0;
	public float recharge = 0;
	public int costMult = 0;
	public int costBase = 0;
	public int duration = 0;
	public int durationBase = 0;
	public int durationMult = 0;
	public int healthBase = 0;
	public int healthMult = 0;
	public int rangeBase = 0;
	public int rangeMult = 0;

	public boolean isDurationBased = false;

	public Power(String name)
	{
		this.unlocalizedName = "force.power." + name;
		this.unlocalizedDescription = this.unlocalizedName + ".desc";
		this.name = name;
	}

	/**
	 * Gets the XP cost of using the power at a specific level
	 *
	 * @return The cost in XP
	 */
	public int getCost()
	{
		return this.costBase + this.costMult * (this.currentLevel - 1);
	}

	/**
	 * Gets the XP cost of using the power at a specific level
	 *
	 * @param level
	 *            The level to test
	 * @return The cost in XP
	 */
	public int getCostForLevel(int level)
	{
		return this.costBase + this.costMult * (level - 1);
	}

	/**
	 * Gets the max damage / second of using the power at a specific level
	 *
	 * @return The max damage / second
	 */
	public int getDamage()
	{
		return this.healthBase + this.healthMult * (this.currentLevel - 1);
	}

	/**
	 * Gets the max damage / second of using the power at a specific level
	 *
	 * @param level
	 *            The level to test
	 * @return The max damage / second
	 */
	public int getDamageForLevel(int level)
	{
		return this.healthBase + this.healthMult * (level - 1);
	}

	/**
	 * Gets the max duration of using the power at a specific level
	 *
	 * @return The max duration in seconds
	 */
	public int getDuration()
	{
		return this.durationBase + this.durationMult * (this.currentLevel - 1);
	}

	/**
	 * Gets the max duration of using the power at a specific level
	 *
	 * @param level
	 *            The level to test
	 * @return The max duration in seconds
	 */
	public int getDurationForLevel(int level)
	{
		return this.durationBase + this.durationMult * (level - 1);
	}

	/**
	 * Returns the description, translated into the player's native lang
	 *
	 * @return
	 */
	public String getLocalizedDesc()
	{
		return LangUtils.translate(this.unlocalizedDescription);
	}

	/**
	 * Returns the name, translated into the player's native lang
	 *
	 * @return
	 */
	public String getLocalizedName()
	{
		return LangUtils.translate(this.unlocalizedName);
	}

	/**
	 * Gets the max damage / second of using the power at a specific level
	 *
	 * @return The max damage / second
	 */
	public int getRange()
	{
		return this.rangeBase + this.rangeMult * (this.currentLevel - 1);
	}

	/**
	 * Gets the max damage / second of using the power at a specific level
	 *
	 * @param level
	 *            The level to test
	 * @return The max damage / second
	 */
	public int getRangeForLevel(int level)
	{
		return this.rangeBase + this.rangeMult * (level - 1);
	}

	/**
	 * Applies the power to the player, called every tick the armor is worn.
	 *
	 * @param player
	 *            The player to apply the power to
	 * @return Returns true if a power was applied, false otherwise
	 */
	public boolean run(EntityPlayer player)
	{
		return false;
	}
}
