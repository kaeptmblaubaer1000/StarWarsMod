package com.parzivail.pswm.quest;

import net.minecraft.entity.player.EntityPlayer;

import java.util.function.Consumer;

public class DialogTree
{
	public String npcHeader;
	public String response1;
	public String response2;
	public String response3;

	public DialogTree response1DT;
	public DialogTree response2DT;
	public DialogTree response3DT;

	/**
	 * Consumer that should be run when the dialog tree is selected.
	 * Adds the ability to make actions
	 * happen when trees are followed
	 * i.e. get weapons or set variables
	 */
	public Consumer<EntityPlayer> action;

	public DialogTree()
	{
		npcHeader = "";
		response1 = "";
		response2 = "";
		response3 = "";
	}

	public boolean hasAction()
	{
		return action != null;
	}

	public void doAction(EntityPlayer player)
	{
		if (hasAction())
			action.accept(player);
	}
}
