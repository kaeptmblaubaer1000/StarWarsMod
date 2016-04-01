package com.parzivail.pswm.quest.rebel;

import com.parzivail.pswm.items.ItemQuestContainer;
import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.DialogTree.Response;
import com.parzivail.pswm.quest.IQuest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;

public class Quest2TargetPractice implements IQuest
{
	DialogTree tree1;
	DialogTree tree2;

	public Quest2TargetPractice()
	{
		this.tree1 = new DialogTree();

		this.tree1.npcHeader = "Now that you've got your A-280, head on over to the range and blast some targets. Make sure you bring me back one of your targets so I can see what kind of shot you are.";
		this.tree1.response1 = new Response();
		this.tree1.response1.text = "Aye Aye, sir!";
		this.tree1.response2 = new Response();
		this.tree1.response2.text = "You got it, gramps.";
		this.tree1.response3 = new Response();
		this.tree1.response3.text = "Be glad to, sir.";

		this.tree2 = new DialogTree();
		this.tree2.npcHeader = "Well you've sure got 2 eyes and you can see the target, but it looks like you might have learned how to shoot from a Stormtrooper son.";
		this.tree2.response1 = new Response();
		this.tree2.response1.text = "Is it really that bad?";
		this.tree2.response1.npcDialog = new DialogTree();
		this.tree2.response1.npcDialog.npcHeader = "It looks worse than a Tauntaun smells, that's for sure.";
		this.tree2.response1.npcDialog.response1 = new Response();
		this.tree2.response1.npcDialog.response1.text = "What's a Tauntaun?";
		this.tree2.response1.npcDialog.response1.npcDialog = new DialogTree();
		this.tree2.response1.npcDialog.response1.npcDialog.npcHeader = "Enough chatter Shiny, now that you've got your armor and proved you're capable of firing a blaster, it's my duty to welcome you fully into The Rebel Alliance.  Take a while and get acquainted with the base and the other Rebels.  When you're ready for your first assignment come find me.  I'll give you a hint where you'll be going, it's cold and there's Wampas.";
		this.tree2.response1.npcDialog.response2 = new Response();
		this.tree2.response1.npcDialog.response2.text = "I eat Tauntaun for breakfast old man.";
		this.tree2.response1.npcDialog.response2.npcDialog = new DialogTree();
		this.tree2.response1.npcDialog.response2.npcDialog.npcHeader = "Enough chatter Shiny, now that you've got your armor and proved you're capable of firing a blaster, it's my duty to welcome you fully into The Rebel Alliance.  Take a while and get acquainted with the base and the other Rebels.  When you're ready for your first assignment come find me.  I'll give you a hint where you'll be going, it's cold and there's Wampas.";
		this.tree2.response1.npcDialog.response3 = new Response();
		this.tree2.response1.npcDialog.response3.text = "Sorry sir but i don't understand the joke.";
		this.tree2.response1.npcDialog.response3.npcDialog = new DialogTree();
		this.tree2.response1.npcDialog.response3.npcDialog.npcHeader = "Enough chatter Shiny, now that you've got your armor and proved you're capable of firing a blaster, it's my duty to welcome you fully into The Rebel Alliance.  Take a while and get acquainted with the base and the other Rebels.  When you're ready for your first assignment come find me.  I'll give you a hint where you'll be going, it's cold and there's Wampas.";
		this.tree2.response2 = new Response();
		this.tree2.response2.text = "I bet it's better than you.";
		this.tree2.response2.npcDialog = new DialogTree();
		this.tree2.response2.npcDialog.npcHeader = "That's not a bet you want to take Shiny.";
		this.tree2.response2.npcDialog.response1 = new Response();
		this.tree2.response2.npcDialog.response1.text = "You're probably right sir.";
		this.tree2.response2.npcDialog.response1.npcDialog = new DialogTree();
		this.tree2.response2.npcDialog.response1.npcDialog.npcHeader = "Enough chatter Shiny, now that you've got your armor and proved you're capable of firing a blaster, it's my duty to welcome you fully into The Rebel Alliance.  Take a while and get acquainted with the base and the other Rebels.  When you're ready for your first assignment come find me.  I'll give you a hint where you'll be going, it's cold and there's Wampas.";
		this.tree2.response2.npcDialog.response2 = new Response();
		this.tree2.response2.npcDialog.response2.text = "I'll take you on any day gramps.";
		this.tree2.response2.npcDialog.response2.npcDialog = new DialogTree();
		this.tree2.response2.npcDialog.response2.npcDialog.npcHeader = "Enough chatter Shiny, now that you've got your armor and proved you're capable of firing a blaster, it's my duty to welcome you fully into The Rebel Alliance.  Take a while and get acquainted with the base and the other Rebels.  When you're ready for your first assignment come find me.  I'll give you a hint where you'll be going, it's cold and there's Wampas.";
		this.tree2.response2.npcDialog.response3 = new Response();
		this.tree2.response2.npcDialog.response3.text = "I'm sure I could hold my own sir.";
		this.tree2.response2.npcDialog.response3.npcDialog = new DialogTree();
		this.tree2.response2.npcDialog.response3.npcDialog.npcHeader = "Enough chatter Shiny, now that you've got your armor and proved you're capable of firing a blaster, it's my duty to welcome you fully into The Rebel Alliance.  Take a while and get acquainted with the base and the other Rebels.  When you're ready for your first assignment come find me.  I'll give you a hint where you'll be going, it's cold and there's Wampas.";
		this.tree2.response3 = new Response();
		this.tree2.response3.text = "Well there's always room for improvement right?";
		this.tree2.response3.npcDialog = new DialogTree();
		this.tree2.response3.npcDialog.npcHeader = "Not much, but Stormtroopers couldn't hit the broad side of a Sarlacc so you'll have time for a few extra shots in combat.";
		this.tree2.response3.npcDialog.response1 = new Response();
		this.tree2.response3.npcDialog.response1.text = "Combat sir? I don't think i'm ready to see combat yet.";
		this.tree2.response3.npcDialog.response1.npcDialog = new DialogTree();
		this.tree2.response3.npcDialog.response1.npcDialog.npcHeader = "Enough chatter Shiny, now that you've got your armor and proved you're capable of firing a blaster, it's my duty to welcome you fully into The Rebel Alliance.  Take a while and get acquainted with the base and the other Rebels.  When you're ready for your first assignment come find me.  I'll give you a hint where you'll be going, it's cold and there's Wampas.";
		this.tree2.response3.npcDialog.response2 = new Response();
		this.tree2.response3.npcDialog.response2.text = "I think it's them who'll be needing the extra time.  It'll take a while for them to regroup after I blast em all.";
		this.tree2.response3.npcDialog.response2.npcDialog = new DialogTree();
		this.tree2.response3.npcDialog.response2.npcDialog.npcHeader = "Enough chatter Shiny, now that you've got your armor and proved you're capable of firing a blaster, it's my duty to welcome you fully into The Rebel Alliance.  Take a while and get acquainted with the base and the other Rebels.  When you're ready for your first assignment come find me.  I'll give you a hint where you'll be going, it's cold and there's Wampas.";
		this.tree2.response3.npcDialog.response3 = new Response();
		this.tree2.response3.npcDialog.response3.text = "That's certainly reassuring sir, I'm sure my Rebel comrades will watch my back too.";
		this.tree2.response3.npcDialog.response3.npcDialog = new DialogTree();
		this.tree2.response3.npcDialog.response3.npcDialog.npcHeader = "Enough chatter Shiny, now that you've got your armor and proved you're capable of firing a blaster, it's my duty to welcome you fully into The Rebel Alliance.  Take a while and get acquainted with the base and the other Rebels.  When you're ready for your first assignment come find me.  I'll give you a hint where you'll be going, it's cold and there's Wampas.";

	}

	@Override
	public boolean canBeGivenQuest(EntityPlayer player)
	{
		return true;
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
		ItemQuestContainer.setQuestDone(player, this);
	}

	@Override
	public DialogTree getDialog(EntityPlayer player)
	{
		if (player.inventory.hasItem(Items.stick))
			return tree2;
		return tree1;
	}

	@Override
	public String getID()
	{
		return "r2-target";
	}
}
