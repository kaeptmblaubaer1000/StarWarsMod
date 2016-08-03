package com.parzivail.pswm.items;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.mobs.MobDroidProbe;
import com.parzivail.pswm.network.MessageSetQuestLogNbt;
import com.parzivail.pswm.quest.QuestStats;
import com.parzivail.util.ui.GuiToast;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import static net.minecraft.util.MovingObjectPosition.MovingObjectType;

public class ItemDataPad extends Item
{
	public String name = "dataPad";

	public ItemDataPad()
	{
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (StarWarsMod.mc.objectMouseOver.typeOfHit == MovingObjectType.ENTITY)
		{
			Entity e = StarWarsMod.mc.objectMouseOver.entityHit;

			if (stack.stackTagCompound == null)
				stack.stackTagCompound = new NBTTagCompound();

			if (e instanceof MobDroidProbe && !stack.stackTagCompound.hasKey(String.valueOf(e.getEntityId())))
			{
				if (world.isRemote)
				{
					GuiToast.makeText("Data Transmitted!", GuiToast.TIME_SHORT).show();
					ItemQuestLog.addStat(player, QuestStats.PROBE_DATA);
					StarWarsMod.network.sendToServer(new MessageSetQuestLogNbt(player, ItemQuestLog.getQuestContainer(player).stackTagCompound));
				}
				stack.stackTagCompound.setBoolean(String.valueOf(e.getEntityId()), true);
			}
			else
			{
				if (world.isRemote)
					GuiToast.makeText("You can't scan that!", GuiToast.TIME_SHORT).show();
			}
		}

		return super.onItemRightClick(stack, world, player);
	}
}
