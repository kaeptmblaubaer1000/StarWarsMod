package com.parzivail.pswm.quest.imperial;

import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

import static com.parzivail.pswm.items.ItemQuestContainer.isQuestDone;
import static com.parzivail.pswm.items.ItemQuestContainer.setQuestDone;

/**
 * Created by Colby on 5/8/2016.
 */
public class Imperial6_1 extends Quest
{
	public Imperial6_1()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Good work Trooper, we'll have a real edge over the Rebels with the information these smugglers hold. It's also time for you to transfer to the Snowtrooper Division.";
		this.tree.response1 = "Snowtrooper Division?";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "Yes the Snowtrooper Division, your transfer unit is currently stationed on Hoth. You'll be taking the fight to the Rebels in extreme conditions. Stop by the Quartermaster for your Hyperdrive and be on your way Trooper.";
		this.tree.response1DT.response1 = "Sir Yes Sir!";
		this.tree.response1DT.response1DT = new DialogTree();
		this.tree.response2 = "I've heard that Division is very elite.";
		this.tree.response2DT = new DialogTree();
		this.tree.response2DT.npcHeader = "They are indeed, and they need Troopers like you. The unit you are transferring to is currently stationed on Hoth. Be sure to stop by the Quartermaster, then be on your way.";
		this.tree.response2DT.response1 = "Thank you sir, I'll be leaving immediately.";
		this.tree.response2DT.response1DT = new DialogTree();
		this.tree.response3 = "Where would that be sir?";
		this.tree.response3DT = new DialogTree();
		this.tree.response3DT.npcHeader = "Hoth, a desolate ice planet. You're to ship out right away, so go to the Quartermaster for your Hyperdrive and make haste. Make the Empire proud Trooper.";
		this.tree.response3DT.response1 = "I will sir! Thank you sir!";
		this.tree.response3DT.response1DT = new DialogTree();
	}

	@Override
	public String getQuestgiverName()
	{
		return "Furgan";
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
		return "The Rebels Will Tremble in Fear";
	}
}
