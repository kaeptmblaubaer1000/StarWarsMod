package com.parzivail.pswm.quest;

import net.minecraft.entity.player.EntityPlayer;

public interface IQuest
{
	/**
	 * Checks if a player can be given a quest
	 * 
	 * @param player
	 * @return
	 */
	public abstract boolean canBeGivenQuest(EntityPlayer player);

	/**
	 * Sets starting paramaters for a quest
	 * 
	 * @param player
	 */
	public abstract void begin(EntityPlayer player);

	/**
	 * Checks parameters for quest completion
	 * 
	 * @param player
	 * @return
	 */
	public abstract boolean isQuestComplete(EntityPlayer player);

	/**
	 * Sets the ending parameters for a quest
	 * 
	 * @param player
	 */
	public abstract void end(EntityPlayer player);

	/**
	 * Gets the dialogue
	 */
	public abstract DialogTree getDialog(EntityPlayer player);

	/**
	 * Gets the quest ID
	 * 
	 * @return
	 */
	public abstract String getID();
}