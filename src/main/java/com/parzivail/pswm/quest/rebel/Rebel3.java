package com.parzivail.pswm.quest.rebel;

import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Colby on 5/8/2016.
 */
public class Rebel3 extends Quest
{
	public Rebel3()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Good to see you again Shiny, are you ready for your first assignment?";
		this.tree.response1 = "Of course sir, where are we headed?";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "*We* aren't going anywhere. You, however, are shipping off to Hoth.";
		this.tree.response1DT.response1 = "But isn't it cold there sir? I don't want to get frostbite!";
		this.tree.response1DT.response1DT = new DialogTree();
		this.tree.response1DT.response1DT.npcHeader = "You'll be fine Shiny, stop by the Quartermaster for a Hoth Hyperdrive for your ship. Make sure to fill up on supplies too.";
		this.tree.response1DT.response2 = "It's gotta be better than this moon that's for sure.";
		this.tree.response1DT.response2DT = new DialogTree();
		this.tree.response1DT.response2DT.npcHeader = "I don't know how you could justify that, but whatever makes you feel tough Shiny. Make sure to stop by the Quartermaster for your Hoth Hyperdrive.";
		this.tree.response1DT.response3 = "Anywhere the Rebels need support, you can count on me sir.";
		this.tree.response1DT.response3DT = new DialogTree();
		this.tree.response1DT.response3DT.npcHeader = "Glad to hear it soldier, Make sure to stop by the Quartermaster for your Hoth Hyperdrive, and good luck.";
		this.tree.response2 = "I'm ready to be anywhere besides in front of you gramps.";
		this.tree.response2DT = new DialogTree();
		this.tree.response2DT.npcHeader = "I couldn't agree more Shiny.";
		this.tree.response2DT.response1 = "Sir this armor doesn't even have any Shiny plating on it...";
		this.tree.response2DT.response1DT = new DialogTree();
		this.tree.response2DT.response1DT.npcHeader = "It's a nickname kid, because you haven't seen any action yet. In any case, make sure to stop by the Quartermaster for your Hoth Hyperdrive. Good luck kid.";
		this.tree.response2DT.response2 = "You're going to want to stop calling me Shiny.";
		this.tree.response2DT.response2DT = new DialogTree();
		this.tree.response2DT.response2DT.npcHeader = "And you'll want to stop calling me gramps. Make sure to stop by the Quartermaster for a Hoth Hyperdrive, and try to stay warm, we don't want you freezing to death out there.";
		this.tree.response2DT.response3 = "Good because I'm ready to support the Rebels and gain some experience sir!";
		this.tree.response2DT.response3DT = new DialogTree();
		this.tree.response2DT.response3DT.npcHeader = "Always a great thing to hear soldier. Make sure to stop by the Quartermaster and get a Hoth Hyperdrive on your way out.";
		this.tree.response3 = "I'm ready to blast some Imperial scum if that's what you mean.";
		this.tree.response3DT = new DialogTree();
		this.tree.response3DT.npcHeader = "Whoa Shiny, easy with the blaster. You're not blasting any Troopers yet.";
		this.tree.response3DT.response1 = "I don't like the sound of blasting OR getting blasted at sir...";
		this.tree.response3DT.response1DT = new DialogTree();
		this.tree.response3DT.response1DT.npcHeader = "Then maybe you should consider flying Skyhoppers on Tatooine for a living. In any case, stop by the Quartermaster and get a Hoth Hyperdrive and report to your new post soldier. And make sure you're ready to use that blaster of yours.";
		this.tree.response3DT.response2 = "Probably because you're still here talking my ear off sir.";
		this.tree.response3DT.response2DT = new DialogTree();
		this.tree.response3DT.response2DT.npcHeader = "Maybe that's because I'm trying to train you Shiny. Just hurry up and go to the Quartermaster to get your Hoth Hyperdrive. Try not to land in any asteroid fields for a pit stop, you never know, you might end up in a giant space worm.";
		this.tree.response3DT.response3 = "Bantha poodoo! Well then what's the assignment sir?";
		this.tree.response3DT.response3DT = new DialogTree();
		this.tree.response3DT.response3DT.npcHeader = "Couldn't tell you Shiny, it's just part of your next phase of training. Make sure you stop by the Quartermaster for a Hoth Hyperdrive. Enjoy your time on Hoth.";
	}

	@Override
	public boolean canBeGivenQuest(EntityPlayer player)
	{
		return false;
	}

	@Override
	public void begin(EntityPlayer player)
	{

	}

	@Override
	public boolean isQuestComplete(EntityPlayer player)
	{
		return false;
	}

	@Override
	public void end(EntityPlayer player)
	{

	}

	@Override
	public DialogTree getDialog(EntityPlayer player)
	{
		return tree;
	}

	@Override
	public String getQuestgiverName()
	{
		return "Rex";
	}

	@Override
	public String getID()
	{
		return "Your ticket to the galaxy";
	}
}
