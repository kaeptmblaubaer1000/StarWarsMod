package com.parzivail.pswm.quest.imperial;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.network.MessageSetPlayerHolding;
import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import com.parzivail.util.world.ItemUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import static com.parzivail.pswm.items.ItemQuestLog.isQuestDone;
import static com.parzivail.pswm.items.ItemQuestLog.setQuestDone;
import static com.parzivail.pswm.quest.QuestBank.imperial4_3;

/**
 * Created by Colby on 5/8/2016.
 */
public class Imperial5 extends Quest
{
	public Imperial5()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Good job finding those droids Trooper, the Empire was in dire need of this information. Now, I have another mission for you.";
		this.tree.response1 = "Yes Sir! What's the mission Sir!";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "We've received intel about some Rebel smugglers in Mos Eisley. Take this ID Scanner and scan people to see their identification. If something about the identification seems off, arrest them and bring them back here. We've only received intel regarding 2 of them, but feel free to bring back as many as you find.";
		this.tree.response1DT.response1 = "Sir Yes Sir!";
		this.tree.response1DT.response1DT = new DialogTree();
		this.tree.response2 = "My blaster is itching for action Sir.";
		this.tree.response2DT = new DialogTree();
		this.tree.response2DT.npcHeader = "Too bad Trooper, this isn't the time for blasting. We've received intel about some Rebel smugglers operating out of Mos Eisley. Take this ID Scanner and scan people to see their identification. If something about the identification seems off, arrest them and bring them back here. We've only received intel regarding 2 of them, but feel free to bring back as many as you find.";
		this.tree.response2DT.response1 = "Sir Yes Sir!";
		this.tree.response2DT.response1DT = new DialogTree();
		this.tree.response3 = "I'm always ready for another mission Sir!";
		this.tree.response3DT = new DialogTree();
		this.tree.response3DT.npcHeader = "I like your attitude Trooper. We've received intel about some Rebel smugglers doing operating out of Mos Eisley. Take this ID Scanner and scan people to see their identification. If something about the identification seems off, arrest them and bring them back here. We've only received intel regarding 2 of them, but feel free to bring back as many as you find.";
		this.tree.response3DT.response1 = "Sir Yes Sir!";
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
		return !isQuestDone(player, this) && imperial4_3.isQuestComplete(player) && ItemUtils.hasItems(player, new ItemStack(StarWarsItems.spawnAstromech, 1)) && ItemUtils.hasItems(player, new ItemStack(StarWarsItems.spawnProtocol, 1));
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
		StarWarsMod.network.sendToServer(new MessageSetPlayerHolding(player, new ItemStack(StarWarsItems.silverImperialCredit, 5), true));
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
		return "A Wretched Hive of Scum and Villainy";
	}
}
