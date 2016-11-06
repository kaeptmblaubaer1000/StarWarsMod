package com.parzivail.util.driven;

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
		prevPosX = posX;
		prevPosY = posY;
		prevPosZ = posZ;

		if (pilotable == null)
		{
			return;
		}

		Vector3f cameraPosition = new Vector3f(-1, 0, 0);
		cameraPosition.scale(pilotable.data.cameraDistance);
		cameraPosition = pilotable.axes.findLocalVectorGlobally(cameraPosition);

		//Lerp it
		double dX = pilotable.posX + cameraPosition.x - posX;
		double dY = pilotable.posY + cameraPosition.y - posY;
		double dZ = pilotable.posZ + cameraPosition.z - posZ;

		setPosition(posX + dX * pilotable.data.cameraFloatDampening, posY + dY * pilotable.data.cameraFloatDampening, posZ + dZ * pilotable.data.cameraFloatDampening);

		rotationYaw = MathHelper.wrapAngleTo180_float(pilotable.axes.getYaw() - 90F);
		rotationPitch = MathHelper.wrapAngleTo180_float(pilotable.axes.getPitch());
	}

	@Override
	public String getCommandSenderName()
	{
		return "Camera";
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
