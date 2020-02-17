package com.parzivail.pswm.quest;

import net.minecraft.entity.player.EntityPlayer;

public interface IQuest
{
	/**
	 * Checks if a ship can be given a quest
	 */
	boolean canBeGivenQuest(EntityPlayer player);

	/**
	 * Sets starting paramaters for a quest
	 */
	void begin(EntityPlayer player);

	/**
	 * Checks parameters for quest completion
	 */
	boolean isQuestComplete(EntityPlayer player);

	/**
	 * Sets the ending parameters for a quest
	 */
	void end(EntityPlayer player);

	/**
	 * Gets the dialogue
	 */
	DialogTree getDialog(EntityPlayer player);

	/**
	 * Gets the quest ID
	 */
	String getID();

	/**
	 * Gets the questgiver's name
	 */
	String getQuestgiverName();
}