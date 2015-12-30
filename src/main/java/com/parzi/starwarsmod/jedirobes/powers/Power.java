package com.parzi.starwarsmod.jedirobes.powers;

import net.minecraft.entity.player.EntityPlayer;

import com.parzi.starwarsmod.utils.LangUtils;

public class Power
{
	public int currentLevel = 0;
	public int maxLevel = 5;
	public String unlocalizedName = "";
	public String unlocalizedDescription = "";
	public int rechargeTime = 0;

	public Power(String name, int maxLevel, int rechargeTime)
	{
		this.unlocalizedName = "force.power." + name;
		this.unlocalizedDescription = this.unlocalizedName + ".desc";
		this.maxLevel = maxLevel;
		this.rechargeTime = rechargeTime;
	}

	/**
	 * Returns the name, translated into the player's native lang
	 * @return
	 */
	public String getLocalizedName()
	{
		return LangUtils.translate(this.unlocalizedName);
	}

	/**
	 * Returns the description, translated into the player's native lang
	 * @return
	 */
	public String getLocalizedDesc()
	{
		return LangUtils.translate(this.unlocalizedDescription);
	}

	/**
	 * Applies the power to the player, called every tick the armor is worn.
	 * @param player The player to apply the power to
	 * @return Returns true if a power was applied, false otherwise
	 */
	public boolean run(EntityPlayer player)
	{
		return false;
	}
}
