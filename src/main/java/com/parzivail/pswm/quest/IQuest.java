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
	boolean canBeGivenQuest(EntityPlayer player);

	/**
	 * Sets starting paramaters for a quest
	 *
	 * @param player
	 */
	void begin(EntityPlayer player);

	/**
	 * Checks parameters for quest completion
	 *
	 * @param player
	 * @return
	 */
	boolean isQuestComplete(EntityPlayer player);

	/**
	 * Sets the ending parameters for a quest
	 *
	 * @param player
	 */
	void end(EntityPlayer player);

	/**
	 * Gets the dialogue
	 */
	DialogTree getDialog(EntityPlayer player);

	/**
	 * Gets the quest ID
	 *
	 * @return
	 */
	String getID();
}