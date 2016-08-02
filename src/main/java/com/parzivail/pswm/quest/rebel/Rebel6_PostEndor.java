package com.parzivail.pswm.quest.rebel;

import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

import static com.parzivail.pswm.items.ItemQuestLog.isQuestDone;
import static com.parzivail.pswm.items.ItemQuestLog.setQuestDone;

/**
 * Created by Colby on 5/8/2016.
 */
public class Rebel6_PostEndor extends Quest
{
	public Rebel6_PostEndor()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Welcome to Endor Recon soldier, you look like you've seen a little action.";
		this.tree.response1 = "Well I did kill a Wampa back on Hoth if you count that as action...";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "Carlist is still making the rookies do that huh? Well maybe that'll help you out, because I've got a mission for you.";
		this.tree.response1DT.response1 = "It was the scariest thing I've ever done sir... But what's the mission?";
		this.tree.response1DT.response1DT = new DialogTree();
		this.tree.response1DT.response1DT.npcHeader = "I need you to steal an Imperial AT-ST and bring it back here. There should be a base a few miles from here. Just bring it back to base and park it near the rest of the speeders we've stolen. Good luck.";
		this.tree.response1DT.response2 = "I'm no rookie, I'm a soldier just like you. Now gimme my mission.";
		this.tree.response1DT.response2DT = new DialogTree();
		this.tree.response1DT.response2DT.npcHeader = "Well then, I need you to steal an Imperial AT-ST and bring it back here. There should be a base a few miles from here. Just park it near the 74-Z's we've stolen. Good luck Mr. Hotshot Commando.";
		this.tree.response1DT.response3 = "Apparently so sir, and what's the mission?";
		this.tree.response1DT.response3DT = new DialogTree();
		this.tree.response1DT.response3DT.npcHeader = "To infiltrate the Imperial base a few miles from here and steal and AT-ST. Bring it back and park it by all the speeder bikes that we've stolen. Make us proud soldier.";
		this.tree.response2 = "I was born in the action";
		this.tree.response2DT = new DialogTree();
		this.tree.response2DT.npcHeader = "I'm sorry, I didn't know I was in the presence of a Commando. Lighten up Shiny, I've got a mission for you, and it involves Stormtroopers.";
		this.tree.response2DT.response1 = "But I've never been in combat sir!";
		this.tree.response2DT.response1DT = new DialogTree();
		this.tree.response2DT.response1DT.npcHeader = "Well you will be today! I need you to steal an AT-ST from the Imperial Base a few miles from here. Bring it back and park it by the 74-Z speeder bikes we've stolen. Good luck soldier.";
		this.tree.response2DT.response2 = "Finally, I'll get to put this blaster to good use";
		this.tree.response2DT.response2DT = new DialogTree();
		this.tree.response2DT.response2DT.npcHeader = "You're gonna have to because I need you to steal an AT-ST from the Imperial Base not too far from here. Bring it back and park it by all the speeder bike's we've stolen.";
		this.tree.response2DT.response3 = "Sorry sir, I got a bit carried away, what's the mission?";
		this.tree.response2DT.response3DT = new DialogTree();
		this.tree.response2DT.response3DT.npcHeader = "It's alright soldier, we all do sometimes. But, I need you to steal an AT-ST from the Imperial Base not too far from here. Park it by all the speeder bikes we've stolen when you bring it back. Good luck.";
		this.tree.response3 = "Somewhat sir, my training on Hoth was eye-opening to say the least.";
		this.tree.response3DT = new DialogTree();
		this.tree.response3DT.npcHeader = "That's good to hear soldier. Hopefully it will have prepared you for your first mission in Endor Recon.";
		this.tree.response3DT.response1 = "I sure hope so sir! What's the mission?";
		this.tree.response3DT.response1DT = new DialogTree();
		this.tree.response3DT.response1DT.npcHeader = "I need you to steal an AT-ST from the Imperial Base not too far from here. Once you have it, bring it back here and park it by all the speeder bikes we've stolen. Good luck soldier.";
		this.tree.response3DT.response2 = "I didn't need preparation, now give me the mission details.";
		this.tree.response3DT.response2DT = new DialogTree();
		this.tree.response3DT.response2DT.npcHeader = "Easy soldier, I need you to steal an AT-ST from the Imperial Base a few clicks away. Park it by the stolen speeder bikes when you bring it back.";
		this.tree.response3DT.response3 = "I'm sure it will have sir, how can I help out Endor Recon?";
		this.tree.response3DT.response3DT = new DialogTree();
		this.tree.response3DT.response3DT.npcHeader = "We need an AT-ST, and we need you to steal it from the Imperial Base not too far from here. Just park it by all the speeder bikes we've stolen when you bring it back. Go get em soldier.";
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
		return isQuestDone(player, this);
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
	public String getQuestgiverName()
	{
		return "Tantor";
	}

	@Override
	public String getID()
	{
		return "That’s no moon!";
	}
}
