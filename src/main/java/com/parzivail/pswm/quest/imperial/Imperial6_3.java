package com.parzivail.pswm.quest.imperial;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.armor.ArmorSnowtrooper;
import com.parzivail.pswm.network.MessageSetPlayerHolding;
import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import com.parzivail.pswm.quest.QuestUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import static com.parzivail.pswm.items.ItemQuestLog.isQuestDone;
import static com.parzivail.pswm.items.ItemQuestLog.setQuestDone;
import static com.parzivail.pswm.quest.QuestBank.imperial6_2;

/**
 * Created by Colby on 5/8/2016.
 */
public class Imperial6_3 extends Quest
{
	public Imperial6_3()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Now that you look like a Snowtrooper I can give you a mission befitting a Snowtrooper. You need to take an AT-ST and assault any nearby Rebel Shield Generator Bases. We need you to take their reactor cores offline and bring them back here. We need at least four of those cores in order to effectively weaken the Rebels. Bring them back to me, and take whatever troops you need with you.";
		this.tree.response1 = "Sir Yes Sir!";
		this.tree.response1DT = new DialogTree();
		this.tree.response2 = "Finally I'll get to blast some Rebel scum.";
		this.tree.response2DT = new DialogTree();
		this.tree.response3 = "You can count on me sir!";
		this.tree.response3DT = new DialogTree();
	}

	@Override
	public String getQuestgiverName()
	{
		return "Veers";
	}

	@Override
	public boolean canBeGivenQuest(EntityPlayer player)
	{
		return !isQuestDone(player, this) && imperial6_2.isQuestComplete(player) && QuestUtils.hasOnArmor(player, ArmorSnowtrooper.class);
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
		StarWarsMod.network.sendToServer(new MessageSetPlayerHolding(player, new ItemStack(StarWarsItems.silverImperialCredit, 6), true));
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
		return "  The Rebels Will Tremble in Fear  ";
	}
}
