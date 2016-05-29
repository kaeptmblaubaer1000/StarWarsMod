package com.parzivail.pswm.vehicles.npc;

import com.parzivail.util.math.FPoint;
import com.parzivail.util.math.Spline3D;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class VehicNpcLandspeeder extends EntityLiving
{
	Spline3D path;

	public VehicNpcLandspeeder(World par1World)
	{
		super(par1World);
		this.setSize(2.0F, 2.0F);

		path = new Spline3D(new FPoint[] { new FPoint(3, 69, 1), new FPoint(27, 69, 31), new FPoint(38, 69, 49), new FPoint(65, 69, 74), new FPoint(82, 69, 98), new FPoint(92, 69, 115), new FPoint(94, 69, 146), new FPoint(99, 69, 155), new FPoint(83, 69, 161), new FPoint(45, 69, 177), new FPoint(37, 69, 208), new FPoint(55, 69, 242), new FPoint(73, 69, 240), new FPoint(92, 69, 242), new FPoint(113, 69, 230), new FPoint(127, 69, 250), new FPoint(137, 69, 267) });
		FPoint p = path.getPoint(0);
		this.setPositionAndUpdate(p.x, p.y, p.z);
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.255D);
	}

	@Override
	public void dropFewItems(boolean par1, int par2)
	{
		// nothing
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
		return new ItemStack[0];
	}

	@Override
	public String getCommandSenderName()
	{
		return "Piloted X-34 Landspeeder";
	}

	@Override
	public void onUpdate()
	{
		if (!this.worldObj.isRemote)
		{
			FPoint pt = path.getPoint((this.ticksExisted % 600) / 600f);
			FPoint npt = path.getPoint(((this.ticksExisted % 600) + 1) / 600f);

			// calculate position and angles
			float d0 = npt.x - pt.x;
			float d1 = npt.y - pt.y;
			float d2 = npt.z - pt.z;
			float d3 = MathHelper.sqrt_float(d0 * d0 + d2 * d2);

			this.rotationYaw = (float)Math.toDegrees(Math.atan2(d2, d0)) - 90;
			this.rotationPitch = -(float)Math.toDegrees(Math.atan2(d1, d3));
			this.setPositionAndUpdate(pt.x, pt.y, pt.z);
		}

		this.motionX = this.motionY = this.motionZ = 0;

		super.onUpdate();
	}

	@Override
	public void updateRiderPosition()
	{
		if (this.riddenByEntity != null)
		{
			this.riddenByEntity.setPosition(this.posX, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset() - 0.75f, this.posZ);
		}
	}
}
