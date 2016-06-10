package com.parzivail.pswm.quest.rebel;

import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Colby on 5/8/2016.
 */
public class Rebel8_PostArmor extends Quest
{
	public Rebel8_PostArmor()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Well now that you look the part, you need to know how to really handle yourself in a ship.";
		this.tree.response1 = "Next";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "There are 4 ships available for you to use in The Rebel Alliance: The T65 X-Wing (which is what we use here in Red Squadron), the BTL Y-Wing (those are for Gold Squadron), the RZ-1 A-Wing (Green Squadron), and the T47 Snowspeeder (Rogue Squadron on Hoth uses those). All ships have the same controls, but different cockpits so every ship feels a little bit different.";
		this.tree.response1DT.response1 = "Next";
		this.tree.response1DT.response1DT = new DialogTree();
		this.tree.response1DT.response1DT.npcHeader = "All have the same max speed and maneuverability except for the RZ-1 A-Wing which is slightly faster than the rest. All are equipped with lasers, but the X-Wing is also equipped with Proton Torpedoes, and the Y-Wing is also equipped with bombs.";
		this.tree.response1DT.response1DT.response1 = "Next";
		this.tree.response1DT.response1DT.response1DT = new DialogTree();
		this.tree.response1DT.response1DT.response1DT.npcHeader = "They are easy to fly, but landing is a bit different than you'd expect. You must come in almost parallel to the ground, much like the large civilian transports, and not brake until you are basically on the ground.";
		this.tree.response1DT.response1DT.response1DT.response1 = "Next";
		this.tree.response1DT.response1DT.response1DT.response1DT = new DialogTree();
		this.tree.response1DT.response1DT.response1DT.response1DT.npcHeader = "If you'd like to hone your skills outside of combat, the Quartermaster has a Hyperdrive which will take you to neutral empty space.";
		this.tree.response1DT.response1DT.response1DT.response1DT.response1 = "Next";
		this.tree.response1DT.response1DT.response1DT.response1DT.response1DT = new DialogTree();
		this.tree.response1DT.response1DT.response1DT.response1DT.response1DT.npcHeader = "The X-Wing and the Y-Wing also require an Astromech Droid in order to fully function and you can find Astromechs almost anywhere.";
		this.tree.response1DT.response1DT.response1DT.response1DT.response1DT.response1 = "Next";
		this.tree.response1DT.response1DT.response1DT.response1DT.response1DT.response1DT = new DialogTree();
		this.tree.response1DT.response1DT.response1DT.response1DT.response1DT.response1DT.npcHeader = "That concludes the briefing and I'd like to welcome you into Red Squadron kid, I'm sure you'll do fine. Come find me when you're ready for your first mission.";
		this.tree.response1DT.response1DT.response1DT.response1DT.response1DT.response1DT.response1 = "Thank you sir!";
		this.tree.response1DT.response1DT.response1DT.response1DT.response1DT.response1DT.response1DT = new DialogTree();
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
