package com.parzivail.pswm.vehicles;

import com.parzivail.util.driven.Pilotable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemSpawnVehicle extends net.minecraft.item.Item
{
	private boolean placeableOnWater;
	private boolean placeableOnLand = true;

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		//Raytracing
		float cosYaw = MathHelper.cos(-entityplayer.rotationYaw * 0.01745329F - 3.141593F);
		float sinYaw = MathHelper.sin(-entityplayer.rotationYaw * 0.01745329F - 3.141593F);
		float cosPitch = -MathHelper.cos(-entityplayer.rotationPitch * 0.01745329F);
		float sinPitch = MathHelper.sin(-entityplayer.rotationPitch * 0.01745329F);
		double length = 5D;
		Vec3 posVec = Vec3.createVectorHelper(entityplayer.posX, entityplayer.posY + 1.62D - entityplayer.yOffset, entityplayer.posZ);
		Vec3 lookVec = posVec.addVector(sinYaw * cosPitch * length, sinPitch * length, cosYaw * cosPitch * length);
		MovingObjectPosition movingobjectposition = world.rayTraceBlocks(posVec, lookVec, this.placeableOnWater);

		//Result check
		if (movingobjectposition == null)
		{
			return itemstack;
		}
		if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
		{
			int i = movingobjectposition.blockX;
			int j = movingobjectposition.blockY;
			int k = movingobjectposition.blockZ;
			Block block = world.getBlock(i, j, k);
			if (this.placeableOnLand || block instanceof BlockLiquid)
			{
				if (!world.isRemote)
				{
					world.spawnEntityInWorld(getVehicle(itemstack, world, entityplayer, i, j, k));
				}
				if (!entityplayer.capabilities.isCreativeMode)
				{
					itemstack.stackSize--;
				}
			}
		}
		return itemstack;
	}

	protected Pilotable getVehicle(ItemStack itemstack, World world, EntityPlayer entityplayer, double i, double j, double k)
	{
		return null;
	}
}
