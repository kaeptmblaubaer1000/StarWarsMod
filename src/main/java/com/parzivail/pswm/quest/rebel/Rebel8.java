package com.parzivail.pswm.quest.rebel;

import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

import static com.parzivail.pswm.items.ItemQuestLog.isQuestDone;
import static com.parzivail.pswm.items.ItemQuestLog.setQuestDone;

/**
 * Created by Colby on 5/8/2016.
 */
public class Rebel8 extends Quest
{
	public Rebel8()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Well look what we have here, it appears you weren't cooked and eaten by the Ewoks.";
		this.tree.response1 = "Good joke sir, they were as docile as can be.";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "That's good to hear, and I assume the droid is still in working order?";
		this.tree.response1DT.response1 = "Of course sir!";
		this.tree.response1DT.response1DT = new DialogTree();
		this.tree.response1DT.response1DT.npcHeader = "Good work then soldier. I've got some good news too because it's time you transferred over to Red Squadron. Head back to Yavin 4 for your training. Good luck.";
		this.tree.response1DT.response2 = "Why else would I be back here talking to you?";
		this.tree.response1DT.response2DT = new DialogTree();
		this.tree.response1DT.response2DT.npcHeader = "I'm asking myself the same question. It looks like that you're due for a transfer though. They want you in Red Squadron, so head back to Yavin 4 to begin your pilot training.";
		this.tree.response1DT.response3 = "I believe so sir.";
		this.tree.response1DT.response3DT = new DialogTree();
		this.tree.response1DT.response3DT.npcHeader = "That's not the most comforting thing I've heard today, but i'm sure it's fine. I've got some good news for you though. Red Squadron wants you, so head back to Yavin 4 for your pilot training. Don't crash Shiny.";
		this.tree.response2 = "They would have regretted trying.";
		this.tree.response2DT = new DialogTree();
		this.tree.response2DT.npcHeader = "Is that so? I'd have liked to see that. I'm just hoping you didn't destroy the droid somehow.";
		this.tree.response2DT.response1 = "Of course not sir!";
		this.tree.response2DT.response1DT = new DialogTree();
		this.tree.response2DT.response1DT.npcHeader = "Good work then soldier. I've got some good news too because it's time you transferred over to Red Squadron. Head back to Yavin 4 for your training. Good luck.";
		this.tree.response2DT.response2 = "Come on give me some credit.";
		this.tree.response2DT.response2DT = new DialogTree();
		this.tree.response2DT.response2DT.npcHeader = "I guess you do deserve at least a little for bringing that droid back in one piece. It looks like that you're due for a transfer though. They want you in Red Squadron, so head back to Yavin 4 to begin your pilot training.";
		this.tree.response2DT.response3 = "Absolutely not sir, it's in working order.";
		this.tree.response2DT.response3DT = new DialogTree();
		this.tree.response2DT.response3DT.npcHeader = "Perfect. I've got some good news for you too. Red Squadron wants you, so head back to Yavin 4 for your pilot training. Don't crash Shiny.";
		this.tree.response3 = "Come on sir, I wasn't that scared.";
		this.tree.response3DT = new DialogTree();
		this.tree.response3DT.npcHeader = "You looked like you were shaking in your armor Shiny. I assume you got the droid back though?";
		this.tree.response3DT.response1 = "Luckily they were docile, and yes sir the droid is okay.";
		this.tree.response3DT.response1DT = new DialogTree();
		this.tree.response3DT.response1DT.npcHeader = "Good work then soldier. I've got some good news too because it's time you transferred over to Red Squadron. Head back to Yavin 4 for your training. Good luck.";
		this.tree.response3DT.response2 = "Say that again and we'll see who's shaking in their armor.";
		this.tree.response3DT.response2DT = new DialogTree();
		this.tree.response3DT.response2DT.npcHeader = "Kid, I eat Gorrnar for breakfast, I don't need to prove myself to you. It looks like that you're due for a transfer though. They want you in Red Squadron, so head back to Yavin 4 to begin your pilot training.";
		this.tree.response3DT.response3 = "I didn't exactly know what I was up against sir..";
		this.tree.response3DT.response3DT = new DialogTree();
		this.tree.response3DT.response3DT.npcHeader = "I don't exactly know what you expected, but i'm glad you came back in one piece. I've got some good news for you too. Red Squadron wants you, so head back to Yavin 4 for your pilot training. Don't crash Shiny.";
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
	public String getQuestgiverName()
	{
		return "Tantor";
	}

	@Override
	public String getID()
	{
		return "Red Squadron";
	}
}
