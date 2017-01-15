package com.parzivail.pswm.vehicle;

import com.parzivail.util.basic.BasicItem;
import com.parzivail.util.driven.Pilotable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemSpawnVehicle extends BasicItem
{
	public ItemSpawnVehicle(String name)
	{
		super(name);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entityplayer, EnumHand hand)
	{
		ItemStack itemstack = entityplayer.getHeldItem(hand);
		float i = (float)entityplayer.posX;
		float j = (float)entityplayer.posY;
		float k = (float)entityplayer.posZ;
		if (!world.isRemote)
		{
			world.spawnEntity(getVehicle(world, entityplayer, i, j, k));
		}
		if (!entityplayer.isCreative())
			itemstack.shrink(1);
		return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);
	}

	protected Pilotable getVehicle(World world, EntityPlayer entityplayer, double i, double j, double k)
	{
		return null;
	}
}
