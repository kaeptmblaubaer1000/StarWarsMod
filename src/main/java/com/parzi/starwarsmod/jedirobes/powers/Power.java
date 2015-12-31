package com.parzi.starwarsmod.jedirobes.powers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

import com.parzi.starwarsmod.utils.ForceUtils;
import com.parzi.starwarsmod.utils.LangUtils;

public class Power
{
	public int currentLevel = 0;
	public int maxLevel = 5;
	public String name = "";
	public String unlocalizedName = "";
	public String unlocalizedDescription = "";
	public float rechargeTime = 0;
	public float recharge = 0;
	public int costMult = 0;
	public int baseCost = 0;

	public Power(String name)
	{
		this.unlocalizedName = "force.power." + name;
		this.unlocalizedDescription = this.unlocalizedName + ".desc";
		this.name = name;
	}

	public static Power getPowerFromName(String name)
	{
		if (name.equalsIgnoreCase("jump"))
			return ForceUtils.powerJump;
		return null;
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
		return baseCost + (costMult * (level - 1));
	}

	/**
	 * Gets the XP cost of using the power at a specific level
	 *
	 * @return The cost in XP
	 */
	public int getCost()
	{
		return baseCost + (costMult * (this.currentLevel - 1));
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
	 * Returns the description, translated into the player's native lang
	 *
	 * @return
	 */
	public String getLocalizedDesc()
	{
		return LangUtils.translate(this.unlocalizedDescription);
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
