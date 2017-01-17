package com.parzivail.util.driven;

import com.parzivail.pswm.PSWM;
import com.parzivail.util.lwjgl.Vector3f;
import com.parzivail.util.math.RotatedAxes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import net.minecraft.world.World;

import java.util.ArrayList;

public class EntityCamera extends EntityLivingBase
{
	public Pilotable pilotable;

	public EntityCamera(World world)
	{
		super(world);
		setSize(0F, 0F);
	}

	@Override
	public Iterable<ItemStack> getArmorInventoryList()
	{
		return new ArrayList<>();
	}

	@Override
	public ItemStack getItemStackFromSlot(EntityEquipmentSlot slotIn)
	{
		return new ItemStack(Blocks.AIR);
	}

	@Override
	public void setItemStackToSlot(EntityEquipmentSlot slotIn, ItemStack stack)
	{

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
			return;

		Vector3f cameraPosition = new Vector3f(pilotable.getCameraZ(), pilotable.getCameraY(), 0);
		cameraPosition.scale(pilotable.data.cameraDistance);
		cameraPosition = pilotable.axes.findLocalVectorGlobally(cameraPosition);

		//Lerp it
		double dX = pilotable.posX + cameraPosition.x - posX;
		double dY = pilotable.posY + cameraPosition.y - posY;
		double dZ = pilotable.posZ + cameraPosition.z - posZ;

		setPosition(posX + dX * pilotable.data.cameraFloatDampening, posY + dY * pilotable.data.cameraFloatDampening, posZ + dZ * pilotable.data.cameraFloatDampening);

		rotationYaw = pilotable.axes.getYaw() - 90F;
		rotationPitch = pilotable.axes.getPitch();

		updatePrevAngles(pilotable.axes);
	}

	public void updatePrevAngles(RotatedAxes axes)
	{
		//Correct angles that crossed the +/- 180 line, so that rendering doesnt make them swing 360 degrees in one tick.
		double dYaw = axes.getYaw() - prevRotationYaw;
		if (dYaw > 180)
			prevRotationYaw += 360F;
		if (dYaw < -180)
			prevRotationYaw -= 360F;

		double dPitch = axes.getPitch() - prevRotationPitch;
		if (dPitch > 180)
			prevRotationPitch += 360F;
		if (dPitch < -180)
			prevRotationPitch -= 360F;
	}

	@Override
	public EnumHandSide getPrimaryHand()
	{
		return EnumHandSide.RIGHT;
	}

	public static void loadAnglesFromStored()
	{
		PSWM.camera.setPositionAndRotation(PSWM.cameraPosition.x, PSWM.cameraPosition.y, PSWM.cameraPosition.z, PSWM.cameraRotation.y, PSWM.cameraRotation.x);
	}
}
