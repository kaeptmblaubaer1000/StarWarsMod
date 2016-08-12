package com.parzivail.pswm.quest.rebel;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.armor.ArmorEndor;
import com.parzivail.pswm.network.MessageSetPlayerHolding;
import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import com.parzivail.pswm.quest.QuestUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import static com.parzivail.pswm.items.ItemQuestLog.isQuestDone;
import static com.parzivail.pswm.items.ItemQuestLog.setQuestDone;
import static com.parzivail.pswm.quest.QuestBank.rebel0;

/**
 * Created by Colby on 5/8/2016.
 */
public class Rebel1 extends Quest
{
	public Rebel1()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Well look at this, a new recruit, nice and Shiny in his brand new armor.";
		this.tree.response1 = "Hi nice to meet you!";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "It's not so nice to meet you, Shiny. I've already got enough new recruits to train...";
		this.tree.response1DT.response1 = "Look, man I'm here to join the Rebel Alliance, if you don't want me just say so.";
		this.tree.response1DT.response1DT = new DialogTree();
		this.tree.response1DT.response1DT.npcHeader = "Oh come on, I'm just playin with ya kid. We have to test the resolve of our new recruits to see if they really are Rebel material. You seem like you'll fit the bill perfectly. First things first though, we need to get you onto the range for some target practice and that means you'll need a blaster. Head back to the Quartermaster and pick up an A-280 Blaster Rifle. Then meet me back here and you'll head to the range to see if you really do have what it takes to blast some Imperial scum.";
		this.tree.response2 = "What's with the tough guy act, old man?";
		this.tree.response2DT = new DialogTree();
		this.tree.response2DT.npcHeader = "It's no act, I'm the toughest Rebel in this entire galaxy son, and I'm not here to babysit you.";
		this.tree.response2DT.response1 = "Look, man I'm here to join the Rebel Alliance, if you don't want me just say so.";
		this.tree.response2DT.response1DT = new DialogTree();
		this.tree.response2DT.response1DT.npcHeader = "Oh come on, I'm just playin with ya kid. We have to test the resolve of our new recruits to see if they really are Rebel material. You seem like you'll fit the bill perfectly. First things first though, we need to get you onto the range for some target practice and that means you'll need a blaster. Head back to the Quartermaster and pick up an A-280 Blaster Rifle. Then meet me back here and you'll head to the range to see if you really do have what it takes to blast some Imperial scum.";
		this.tree.response3 = "Hey man, I'm just here to blast some Stormtroopers.";
		this.tree.response3DT = new DialogTree();
		this.tree.response3DT.npcHeader = "Well isn't that nice, too bad you probably hold a blaster like a real sleemo.";
		this.tree.response3DT.response1 = "Look, man I'm here to join the Rebel Alliance, if you don't want me just say so.";
		this.tree.response3DT.response1DT = new DialogTree();
		this.tree.response3DT.response1DT.npcHeader = "Oh come on, I'm just playin with ya kid. We have to test the resolve of our new recruits to see if they really are Rebel material. You seem like you'll fit the bill perfectly. First things first though, we need to get you onto the range for some target practice and that means you'll need a blaster. Head back to the Quartermaster and pick up an A-280 Blaster Rifle. Then meet me back here and you'll head to the range to see if you really do have what it takes to blast some Imperial scum.";
	}

	@Override
	public String getQuestgiverName()
	{
		return "Rex";
	}

	@Override
	public boolean canBeGivenQuest(EntityPlayer player)
	{
		return !isQuestDone(player, this) && QuestUtils.hasOnArmor(player, ArmorEndor.class) && rebel0.isQuestComplete(player);
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
		StarWarsMod.network.sendToServer(new MessageSetPlayerHolding(player, new ItemStack(StarWarsItems.silverImperialCredit, 1), true));
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
		return "Enlisting";
	}
}
