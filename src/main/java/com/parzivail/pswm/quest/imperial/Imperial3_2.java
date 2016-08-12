package com.parzivail.pswm.quest.imperial;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.armor.ArmorScoutTrooper;
import com.parzivail.pswm.network.MessageSetPlayerHolding;
import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import com.parzivail.pswm.quest.QuestUtils;
import com.parzivail.util.world.ItemUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import static com.parzivail.pswm.items.ItemQuestLog.isQuestDone;
import static com.parzivail.pswm.items.ItemQuestLog.setQuestDone;
import static com.parzivail.pswm.quest.QuestBank.imperial3_1;

/**
 * Created by Colby on 5/8/2016.
 */
public class Imperial3_2 extends Quest
{
	public Imperial3_2()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Now that you've got your gear we need to send you out to do some recon.";
		this.tree.response1 = "Sir Yes Sir!";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "Take a 74-Z Speeder Bike and scout the area surrounding the base for any Rebel encampments. We need at least three Rebel Data Drives in order to coordinate future attacks. The Rebels hide these drives in their encampments and it's your mission to bring them back to us. Feel free to use your blaster.";
		this.tree.response2 = "Hopefully I'll get to use this new pistol.";
		this.tree.response2DT = new DialogTree();
		this.tree.response2DT.npcHeader = "That's up to you Trooper. Take a 74-Z Speeder Bike and scout the surrounding areas for Rebel encampments. They have hidden Rebel Data Drives and we need at least three of them to conduct future operations.";
		this.tree.response3 = "What am I doing recon on Sir?";
		this.tree.response3DT = new DialogTree();
		this.tree.response3DT.npcHeader = "There are hidden Rebel encampments not far from here that have Rebel Data Drives. We need those drives and it's your mission to retrieve them. Take a 74-Z Speeder Bike and use your blaster if you need to. We need at least three of those drives Trooper.";
	}

	@Override
	public String getQuestgiverName()
	{
		return "Cody";
	}

	@Override
	public boolean canBeGivenQuest(EntityPlayer player)
	{
		return !isQuestDone(player, this) && imperial3_1.isQuestComplete(player) && QuestUtils.hasOnArmor(player, ArmorScoutTrooper.class) && ItemUtils.hasItems(player, new ItemStack(StarWarsItems.blasterPistol, 1, 5));
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
		player.playSound(Resources.MODID + ":" + "quest.complete", 1, 1);
		StarWarsMod.network.sendToServer(new MessageSetPlayerHolding(player, new ItemStack(StarWarsItems.silverImperialCredit, 3), true));
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
		return " Recon Mission ";
	}
}
