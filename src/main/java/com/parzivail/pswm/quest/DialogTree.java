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

	public Consumer<EntityPlayer> action; // adds the ability to make actions
	// happen when trees are followed
	// i.e. get weapons or set variables
	// Usage: action = Class::method;

	public DialogTree()
	{
		npcHeader = "";
		response1 = "";
		response2 = "";
		response3 = "";
	}
}
