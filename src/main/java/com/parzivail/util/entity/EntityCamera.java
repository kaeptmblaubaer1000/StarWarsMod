package com.parzivail.util.entity;

import com.parzivail.util.driven.Pilotable;
import com.parzivail.util.lwjgl.Vector3f;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityCamera extends EntityLivingBase
{
	public Pilotable pilotable;

	public EntityCamera(World world)
	{
		super(world);
		setSize(0F, 0F);
	}

	public EntityCamera(World world, Pilotable d)
	{
		this(world);
		pilotable = d;
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
		//cameraPosition.scale(drivable.getDriveableType().cameraDistance);
		cameraPosition = pilotable.axes.findLocalVectorGlobally(cameraPosition);

		//Lerp it
		double dX = pilotable.posX + cameraPosition.x - posX;
		double dY = pilotable.posY + cameraPosition.y - posY;
		double dZ = pilotable.posZ + cameraPosition.z - posZ;

		float lerpAmount = 0.1F;

		setPosition(posX + dX * lerpAmount, posY + dY * lerpAmount, posZ + dZ * lerpAmount);

		rotationYaw = MathHelper.wrapAngleTo180_float(pilotable.axes.getYaw() - 90F);
		rotationPitch = MathHelper.wrapAngleTo180_float(pilotable.axes.getPitch());
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
