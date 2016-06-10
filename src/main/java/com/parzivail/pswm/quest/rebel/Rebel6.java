package com.parzivail.pswm.quest.rebel;

import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Colby on 5/8/2016.
 */
public class Rebel6 extends Quest
{
	public Rebel6()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Nice job recruit, you're really shaping up into a fine Rebel soldier. We really needed someone to take out those droids.";
		this.tree.response1 = "Thank you sir!";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "Well are you ready to ship out to your next post?";
		this.tree.response1DT.response1 = "Where am I headed?";
		this.tree.response1DT.response1DT = new DialogTree();
		this.tree.response1DT.response1DT.npcHeader = "You're going to the Forest Moon of Endor, unsurprisingly also called Endor. You'll be helping out another unit there. Make sure you stop by the Quartermaster for your Hyperdrive. Good luck kid.";
		this.tree.response1DT.response2 = "What rock am I being sent to this time?";
		this.tree.response1DT.response2DT = new DialogTree();
		this.tree.response1DT.response2DT.npcHeader = "You're going on a vacation Mr. Rebel Commando. To the great Forest Moon of Endor, unsurprisingly also called Endor. Stop by the Quartermaster for your Hyperdrive, and don't get eaten by the Ewoks, Shiny.";
		this.tree.response1DT.response3 = "Where to sir?";
		this.tree.response1DT.response3DT = new DialogTree();
		this.tree.response1DT.response3DT.npcHeader = "You're headed to the Forest Moon of Endor, unsurprisingly also called Endor, to help out another unit. Stop by the Quartermaster for your Hyperdrive, make us proud soldier.";
		this.tree.response2 = "It wasn't very hard, I usually bullseye Womp Rats back home.";
		this.tree.response2DT = new DialogTree();
		this.tree.response2DT.npcHeader = "Don't be ungrateful Shiny, and by the way, it's time for you to ship out.";
		this.tree.response2DT.response1 = "Where to this time?";
		this.tree.response2DT.response1DT = new DialogTree();
		this.tree.response2DT.response1DT.npcHeader = "You're going to the Forest Moon of Endor, unsurprisingly also called Endor. You'll be helping out Endor Recon. Make sure you stop by the Quartermaster for your Hyperdrive.";
		this.tree.response2DT.response2 = "What rock am I being sent to now?";
		this.tree.response2DT.response2DT = new DialogTree();
		this.tree.response2DT.response2DT.npcHeader = "You're going on a vacation Mr. Ace Pilot. To the great Forest Moon of Endor, unsurprisingly also called Endor. Stop by the Quartermaster for your Hyperdrive, and try not to get eaten by the Ewoks.";
		this.tree.response2DT.response3 = "Where to sir?";
		this.tree.response2DT.response3DT = new DialogTree();
		this.tree.response2DT.response3DT.npcHeader = "You're headed to the Forest Moon of Endor, unsurprisingly also called Endor, to help out another unit. Stop by the Quartermaster for your Hyperdrive, and make us proud out there soldier.";
		this.tree.response3 = "I appreciate that sir, I'm happy to be a part of The Rebel Alliance.";
		this.tree.response3DT = new DialogTree();
		this.tree.response3DT.npcHeader = "You're in luck then soldier because it's time for you to ship out.";
		this.tree.response3DT.response1 = "I don't know if I'd call me lucky... But, where to?";
		this.tree.response3DT.response1DT = new DialogTree();
		this.tree.response3DT.response1DT.npcHeader = "You're going to the Forest Moon of Endor, unsurprisingly also called Endor. You'll be helping out another unit there. Make sure you stop by the Quartermaster for your Hyperdrive, and try to hold that blaster straight...";
		this.tree.response3DT.response2 = "I'm always in luck old man, what rock this time?";
		this.tree.response3DT.response2DT = new DialogTree();
		this.tree.response3DT.response2DT.npcHeader = "You're going on a vacation Mr. Rebel Commando. To the great Forest Moon of Endor, unsurprisingly also called Endor. Stop by the Quartermaster for your Hyperdrive.";
		this.tree.response3DT.response3 = "Where to sir?";
		this.tree.response3DT.response3DT = new DialogTree();
		this.tree.response3DT.response3DT.npcHeader = "You're headed to the Forest Moon of Endor, unsurprisingly also called Endor, to help out Endor Recon. Stop by the Quartermaster for your Hyperdrive, and good luck out there soldier.";
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
		return null;
	}

	@Override
	public String getID()
	{
		return null;
	}
}
