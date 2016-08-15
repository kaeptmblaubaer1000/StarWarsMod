package com.parzivail.pswm.quest.sith;

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
import static com.parzivail.pswm.quest.QuestBank.sith1;
import static com.parzivail.util.ui.TextUtils.makeObfuscated;

/**
 * Created by Colby on 5/8/2016.
 */
public class Sith2 extends Quest
{
	public Sith2()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "So you have returned, with the Sith Artifact no less. Do you sense it's power?";
		this.tree.response1 = "Yes, I can feel a heat flowing through me, an ancient power awakening inside of my mind.";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "Good, good. Let it flow through you, invite The Dark Side into your heart and let it feed your mind. That is the first step towards becoming an Apprentice.";
		this.tree.response1DT.response1 = "An Apprentice? What do you mean?";
		this.tree.response1DT.response1DT = new DialogTree();
		this.tree.response1DT.response1DT.npcHeader = "Long ago, a man named Darth Bane came to found The Sith Order. He was gifted in The Dark Side and was the first in a long line of Sith Lords. He instituted what is known as the Rule of Two. There may only be two Sith at a time, a Master, and an Apprentice. If you are willing, I will take you as my Apprentice and I will become your Master. The Dark Side flows strongly within you. With my teaching you can become more powerful than you've ever imagined.";
		this.tree.response1DT.response1DT.response2 = "More powerful than I've ever imagined, I like the sound of that.";
		this.tree.response1DT.response1DT.response2DT = new DialogTree();
		this.tree.response1DT.response1DT.response2DT.npcHeader = "Then it is set, I am your Master and you, are my Apprentice. Take these robes as a symbol of your Apprenticeship and return to me when you are ready to construct a Lightsaber more befitting of a Sith.";
	}

	@Override
	public String getQuestgiverName()
	{
		return makeObfuscated("Zannah");
	}

	@Override
	public boolean canBeGivenQuest(EntityPlayer player)
	{
		return !isQuestDone(player, this) && sith1.isQuestComplete(player) && ItemUtils.hasItems(player, new ItemStack(StarWarsItems.sithArtifact, 1));
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
		StarWarsMod.network.sendToServer(new MessageSetPlayerHolding(player, new ItemStack(StarWarsItems.jediRobes, 1, 1), true));
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
		return "A Master and an Apprentice";
	}
}
