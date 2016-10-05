package com.parzivail.util.entity;

import com.parzivail.util.lwjgl.Vector3f;
import com.parzivail.util.vehicle.StarshipBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityFollowCamera extends EntityLivingBase
{
	public StarshipBase ship;

	public EntityFollowCamera(World world)
	{
		super(world);
		setSize(0F, 0F);
	}

	public EntityFollowCamera(World world, StarshipBase d)
	{
		this(world);
		ship = d;
		setPosition(d.posX, d.posY, d.posZ);
	}

	@Override
	public void onUpdate()
	{
		//super.onUpdate();

		prevPosX = posX;
		prevPosY = posY;
		prevPosZ = posZ;

		Vector3f cameraPosition = new Vector3f();//-1F, 0.5F, 0F);
		//cameraPosition.scale(ship.getDriveableType().cameraDistance);
		cameraPosition = ship.axes.findLocalVectorGlobally(cameraPosition);

		//Lerp it
		double dX = ship.posX + cameraPosition.x - posX;
		double dY = ship.posY + cameraPosition.y - posY;
		double dZ = ship.posZ + cameraPosition.z - posZ;

		float lerpAmount = 0.1F;

		setPosition(posX + dX * lerpAmount, posY + dY * lerpAmount, posZ + dZ * lerpAmount);

		rotationYaw = ship.axes.getYaw() - 90F;
		rotationPitch = ship.axes.getPitch();
	}

	@Override
	public ItemStack getHeldItem()
	{
		return null;
	}

	@Override
	public ItemStack getEquipmentInSlot(int p_71124_1_)
	{
		return null;
	}

	@Override
	public void setCurrentItemOrArmor(int p_70062_1_, ItemStack p_70062_2_)
	{

	}

	@Override
	public ItemStack[] getLastActiveItems()
	{
		return null;
	}

}
