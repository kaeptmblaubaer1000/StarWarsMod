package com.parzivail.pswm.force;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.force.powers.PowerBase;
import com.parzivail.pswm.jedi.JediUtils;
import com.parzivail.pswm.utils.ForceUtils;
import com.parzivail.util.world.ItemUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StringUtils;
import net.minecraft.world.World;

import java.util.List;

public class ItemHolocron extends Item
{
	public String name = "holocron";

	public ItemHolocron()
	{
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	public String getItemStackDisplayName(ItemStack stack)
	{
		if (stack.hasTagCompound())
		{
			String s = stack.stackTagCompound.getString(Resources.nbtMaster);

			if (!StringUtils.isNullOrEmpty(s))
			{
				return s + "'s Holocron";
			}
		}

		return super.getItemStackDisplayName(stack);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
	{
		list.add("Level " + String.valueOf((int)Math.floor(JediUtils.getLevel(stack) / 10f)));
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int a, boolean b)
	{
		if (ItemUtils.initNBT(stack) && entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)entity;

			stack.stackTagCompound.setString(Resources.nbtMaster, player.getCommandSenderName());
			stack.stackTagCompound.setString(Resources.nbtSide, JediUtils.SIDE_JEDI);

			stack.stackTagCompound.setInteger(Resources.nbtXp, 0);
			stack.stackTagCompound.setInteger(Resources.nbtMaxXp, 100);

			stack.stackTagCompound.setTag(Resources.nbtWield, new NBTTagCompound());
			stack.stackTagCompound.setTag(Resources.nbtPowers, new NBTTagCompound());
			for (PowerBase p : ForceUtils.powers.values())
				((NBTTagCompound)stack.stackTagCompound.getTag(Resources.nbtPowers)).setTag(p.name, p.serialize());
		}
	}
}