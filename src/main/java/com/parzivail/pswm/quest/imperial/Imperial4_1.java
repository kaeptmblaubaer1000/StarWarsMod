package com.parzivail.pswm.quest.imperial;

import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

import static com.parzivail.pswm.items.ItemQuestContainer.isQuestDone;
import static com.parzivail.pswm.items.ItemQuestContainer.setQuestDone;

/**
 * Created by Colby on 5/8/2016.
 */
public class Imperial4_1 extends Quest
{
	public Imperial4_1()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Fine work Trooper, with this intelligence we'll be able to better plan the destruction of The Rebel Alliance. Also I have a new assignment for you.";
		this.tree.response1 = "Thank you Sir! Where to now?";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "You're shipping out to Tatooine, the Troopers there need help finding some escaped droids, among other things. Go to the Quartermaster for your Hyperdrive and be on your way. Use the Imperial Shuttle and its Hyperdrive Block in order to travel to other planets.";
		this.tree.response1DT.response1 = "Sir Yes Sir!";
		this.tree.response1DT.response1DT = new DialogTree();
		this.tree.response2 = "Any place where I can fight the Rebels is fine with me.";
		this.tree.response2DT = new DialogTree();
		this.tree.response2DT.npcHeader = "That's what I like to hear Trooper. You're being transferred to a Tatooine detachment. I hear they need assistance finding escaped droids. Go to the Quartermaster for your Hyperdrive and be on your way. Use the Imperial Shuttle and its Hyperdrive Block in order to travel to other planets.";
		this.tree.response2DT.response1 = "Sir Yes Sir!";
		this.tree.response2DT.response1DT = new DialogTree();
		this.tree.response3 = "I'm glad to serve the Empire, Sergeant. Where's my next post?";
		this.tree.response3DT = new DialogTree();
		this.tree.response3DT.npcHeader = "Your loyalty will not go unnoticed Trooper. You're being sent to Tatooine to assist a detachment of Sandtroopers that I hear are searching for escaped droids. Go to the Quartermaster for your Hyperdrive and be on your way. Use the Imperial Shuttle and its Hyperdrive Block in order to travel to other planets.";
		this.tree.response3DT.response1 = "Sir Yes Sir!";
		this.tree.response3DT.response1DT = new DialogTree();
	}

	@Override
	public String getQuestgiverName()
	{
		return "Cody";
	}

	@Override
	public boolean canBeGivenQuest(EntityPlayer player)
	{
		return !isQuestDone(player, this);
	}

	@Override
	public void begin(EntityPlayer player)
	{

	}

	@Override
	public boolean isQuestComplete(EntityPlayer player)
	{
		return true;
	}

	@Override
	public void end(EntityPlayer player)
	{
		setQuestDone(player, this);
	}

	@Override
	public DialogTree getDialog(EntityPlayer player)
	{
		return tree;
	}

	@Override
	public String getID()
	{
		return "Sandy Troopers";
	}
}
