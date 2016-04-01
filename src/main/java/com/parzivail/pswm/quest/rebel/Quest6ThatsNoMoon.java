package com.parzivail.pswm.quest.rebel;

import com.parzivail.pswm.items.ItemQuestContainer;
import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.IQuest;

import net.minecraft.entity.player.EntityPlayer;

public class Quest6ThatsNoMoon implements IQuest
{
	DialogTree tree;

	public Quest6ThatsNoMoon()
	{
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
		return tree;
	}

	@Override
	public String getID()
	{
		return "r6-nomoon";
	}
}
