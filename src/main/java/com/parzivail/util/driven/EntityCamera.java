package com.parzivail.util.driven;

import com.parzivail.pswm.PSWM;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import net.minecraft.world.World;

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
		return null;
	}

	@Override
	public ItemStack getItemStackFromSlot(EntityEquipmentSlot slotIn)
	{
		return null;
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
	}

	@Override
	public EnumHandSide getPrimaryHand()
	{
		return null;
	}

	public static void loadAnglesFromStored()
	{
		PSWM.camera.setPositionAndRotation(PSWM.cameraPosition.x, PSWM.cameraPosition.y, PSWM.cameraPosition.z, PSWM.cameraRotation.y, PSWM.cameraRotation.x);
	}
}
