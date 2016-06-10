package com.parzivail.pswm.quest.rebel;

import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Colby on 5/8/2016.
 */
public class Rebel9 extends Quest
{
	public Rebel9()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Alright Ace, before you go around boasting about how you're the best shot in the Rebel Alliance you need to put in some time in a cockpit.";
		this.tree.response1 = "I'm excited to finally get into a real starfighter sir!";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "Good news then, because I want you to go to Wild Space and get familiar with a T65 X-Wing. It's our main starfighter and what you'll be flying most often. The Quartermaster will give you a Hyperdrive. Take your time out there and try not to crash or get eaten by a space slug.";
		this.tree.response1DT.response1 = "It'll be my pleasure sir!";
		this.tree.response1DT.response1DT = new DialogTree();
		this.tree.response1DT.response2 = "I'd like to see a space slug try.";
		this.tree.response1DT.response2DT = new DialogTree();
		this.tree.response1DT.response3 = "Space slugs sir?...";
		this.tree.response1DT.response3DT = new DialogTree();
		this.tree.response2 = "Well I am the best shot in the Rebel Alliance and I don't see anyone arguing.";
		this.tree.response2DT = new DialogTree();
		this.tree.response2DT.npcHeader = "No one's arguing because it's such a ridiculous thing for you to think, much less say. Now i want you to go to Wild Space and get familiar with the T65 X-Wing. It's the ship you'll be using most often and it's a real pleasure to fly. The Quartermaster will give you a Hyperdrive, but it's up to you not to crash into an asteroid.";
		this.tree.response2DT.response1 = "Don't worry sir, I'll come back in one piece!";
		this.tree.response2DT.response1DT = new DialogTree();
		this.tree.response2DT.response2 = "How could I crash into an asteroid if I'm such a gifted pilot?";
		this.tree.response2DT.response2DT = new DialogTree();
		this.tree.response2DT.response3 = "Umm I'll try not to sir...";
		this.tree.response2DT.response3DT = new DialogTree();
		this.tree.response3 = "Are you sure I'm ready sir? I've only ever been in a T47...";
		this.tree.response3DT = new DialogTree();
		this.tree.response3DT.npcHeader = "Don't worry soldier I'm sure you'll do fine. Now i want you to go to Wild Space and get familiar with the T65 X-Wing. It's the ship you'll be using most often and it's a real pleasure to fly. The Quartermaster will give you a Hyperdrive, and once you're out there just take it slow and trust your instincts.";
		this.tree.response3DT.response1 = "Thank you sir!";
		this.tree.response3DT.response1DT = new DialogTree();
		this.tree.response3DT.response2 = "I don't have to take it slow, I could fly a T65 in my sleep.";
		this.tree.response3DT.response2DT = new DialogTree();
		this.tree.response3DT.response3 = "I'll try to do my best sir...";
		this.tree.response3DT.response3DT = new DialogTree();
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
