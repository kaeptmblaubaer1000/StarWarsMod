package com.parzivail.pswm.quest.sith;

import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

import static com.parzivail.pswm.items.ItemQuestLog.isQuestDone;
import static com.parzivail.pswm.items.ItemQuestLog.setQuestDone;
import static com.parzivail.util.ui.TextUtils.makeObfuscated;

/**
 * Created by Colby on 5/8/2016.
 */
public class Sith3 extends Quest
{
	public Sith3()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "It is time for you to construct the Lightsaber of a Sith. The Jedi use Kyber Crystals in their Lightsabers, but a Sith crystal is synthetic. You must first find three of the six shards still left intact from the ancient times, then use your hatred and power to compress the shards into your Synthetic Crystal. If you wish to construct a double-bladed Lightsaber, know that three shards make one whole Synthetic Crystal, so you must recover all six of the shards. The Shards can be found here:";
		this.tree.response3 = "Next";
		this.tree.response3DT = new DialogTree();
		this.tree.response3DT.npcHeader = "Hidden somewhere in the Ilum Temple, in fact, you may already be in possession of it.";
		this.tree.response3DT.response1 = "Next";
		this.tree.response3DT.response1DT = new DialogTree();
		this.tree.response3DT.response1DT.npcHeader = "Hidden in the tree in which your old Jedi Master lives in refuge.";
		this.tree.response3DT.response1DT.response1 = "Next";
		this.tree.response3DT.response1DT.response1DT = new DialogTree();
		this.tree.response3DT.response1DT.response1DT.npcHeader = "Hidden in Ancient Temple Ruins on the planet where the Rebels have their Main Base.";
		this.tree.response3DT.response1DT.response1DT.response1 = "Next";
		this.tree.response3DT.response1DT.response1DT.response1DT = new DialogTree();
		this.tree.response3DT.response1DT.response1DT.response1DT.npcHeader = "Hidden with a Black Market Dealer somewhere in Mos Eisley. You will have to buy the shard from him, as he knows not of it's power.";
		this.tree.response3DT.response1DT.response1DT.response1DT.response1 = "Next";
		this.tree.response3DT.response1DT.response1DT.response1DT.response1DT = new DialogTree();
		this.tree.response3DT.response1DT.response1DT.response1DT.response1DT.npcHeader = "Hidden deep within the Imperial Base on Endor, in a secret chamber for their leader.";
		this.tree.response3DT.response1DT.response1DT.response1DT.response1DT.response1 = "Next";
		this.tree.response3DT.response1DT.response1DT.response1DT.response1DT.response1DT = new DialogTree();
		this.tree.response3DT.response1DT.response1DT.response1DT.response1DT.response1DT.npcHeader = "As a reward for becoming my Apprentice, I will give you one of the shards, as I have kept it in my possession for safekeeping";
		this.tree.response3DT.response1DT.response1DT.response1DT.response1DT.response1DT.response1 = "Thank you Master, what do I do once I have the remaining shards?";
		this.tree.response3DT.response1DT.response1DT.response1DT.response1DT.response1DT.response1DT = new DialogTree();
		this.tree.response3DT.response1DT.response1DT.response1DT.response1DT.response1DT.response1DT.npcHeader = "Return to the chamber in the temple on Ilum where you found the Sith Holocron. There you will find a Crystal Compressor. Use it to make the shards whole again. Once you have your Synthetic Crystal, use the Lightsaber Forge you used previously to construct your saber. Once the construction is complete, return to me, Apprentice, and I will show you the true power of The Dark Side.";
	}

	@Override
	public String getQuestgiverName()
	{
		return makeObfuscated("Zannah");
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
		return "The Weapon of a Sith";
	}
}
