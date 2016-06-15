package com.parzivail.pswm.force.powers;

import com.parzivail.util.ui.LangUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class PowerBase
{

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
	public boolean isRunning = false;
	public int health = 0;

	public boolean isDurationBased = false;

	public PowerBase(String name)
	{
		this.unlocalizedName = "force.power." + name;
		this.unlocalizedDescription = this.unlocalizedName + ".desc";
		this.name = name;
	}

	/**
	 * Serializes the power for saving to NBT
	 *
	 * @return a NBTTagCompound of the power
	 */
	public NBTTagCompound serialize()
	{
		NBTTagCompound compound = new NBTTagCompound();
		compound.setInteger("currentLevel", currentLevel);
		compound.setInteger("maxLevel", maxLevel);
		compound.setString("name", name);
		compound.setString("unlocalizedName", unlocalizedName);
		compound.setString("unlocalizedDescription", unlocalizedDescription);
		compound.setFloat("rechargeTime", rechargeTime);
		compound.setFloat("recharge", recharge);
		compound.setInteger("costMult", costMult);
		compound.setInteger("costBase", costBase);
		compound.setInteger("duration", duration);
		compound.setInteger("durationBase", durationBase);
		compound.setInteger("durationMult", durationMult);
		compound.setInteger("healthBase", healthBase);
		compound.setInteger("healthMult", healthMult);
		compound.setInteger("rangeBase", rangeBase);
		compound.setInteger("rangeMult", rangeMult);
		compound.setInteger("health", health);
		compound.setBoolean("isRunning", isRunning);
		return compound;
	}

	/**
	 * Sets up the power with the specified NBT
	 *
	 * @param compound The compound to read
	 */
	public PowerBase deserialize(NBTTagCompound compound)
	{
		this.currentLevel = compound.getInteger("currentLevel");
		this.maxLevel = compound.getInteger("maxLevel");
		this.name = compound.getString("name");
		this.unlocalizedName = compound.getString("unlocalizedName");
		this.unlocalizedDescription = compound.getString("unlocalizedDescription");
		this.rechargeTime = compound.getFloat("rechargeTime");
		this.recharge = compound.getFloat("recharge");
		this.costMult = compound.getInteger("costMult");
		this.costBase = compound.getInteger("costBase");
		this.duration = compound.getInteger("duration");
		this.durationBase = compound.getInteger("durationBase");
		this.durationMult = compound.getInteger("durationMult");
		this.healthBase = compound.getInteger("healthBase");
		this.healthMult = compound.getInteger("healthMult");
		this.rangeBase = compound.getInteger("rangeBase");
		this.rangeMult = compound.getInteger("rangeMult");
		this.health = compound.getInteger("health");
		this.isRunning = compound.getBoolean("isRunning");
		return this;
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
	 * @param level The level to test
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
	 * @param level The level to test
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
	 * @param level The level to test
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
	 * Gets the max range of a the power at a specific level
	 *
	 * @return The max range
	 */
	public int getRange()
	{
		return this.rangeBase + this.rangeMult * (this.currentLevel - 1);
	}

	/**
	 * Gets the max damage / second of using the power at a specific level
	 *
	 * @param level The level to test
	 * @return The max damage / second
	 */
	public int getRangeForLevel(int level)
	{
		return this.rangeBase + this.rangeMult * (level - 1);
	}

	/**
	 * Applies the power to the player, called every tick the armor is worn.
	 *
	 * @param player The player to apply the power to
	 * @return Returns true if a power was applied, false otherwise
	 */
	public boolean run(EntityPlayer player)
	{
		return false;
	}
}
