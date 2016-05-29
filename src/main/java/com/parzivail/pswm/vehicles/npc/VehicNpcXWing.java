package com.parzivail.pswm.vehicles.npc;

import com.parzivail.util.math.FPoint;
import com.parzivail.util.math.Spline3D;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class VehicNpcXWing extends EntityLiving
{
	Spline3D path;

	public VehicNpcXWing(World par1World)
	{
		super(par1World);
		this.setSize(2.0F, 2.0F);

		path = new Spline3D(new FPoint[] { new FPoint(-5, 6, 7), new FPoint(-7, 13, 24), new FPoint(-27, 8, 29), new FPoint(-46, 11, -1), new FPoint(-26, 9, -26), new FPoint(-5, 6, 7) });
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
		return "Piloted T-65B X-Wing Starfighter";
	}

	@Override
	public void onUpdate()
	{
		int spd = 30000;
		int time = (int)(System.currentTimeMillis() % spd);
		FPoint pt = path.getPoint(time / (float)spd);
		FPoint npt = path.getPoint((time + 1) / (float)spd);

		// calculate position and angles
		float d0 = npt.x - pt.x;
		float d1 = npt.y - pt.y;
		float d2 = npt.z - pt.z;
		float d3 = MathHelper.sqrt_float(d0 * d0 + d1 * d1 + d2 * d2);

		this.rotationYaw = (float)Math.toDegrees(Math.atan2(d2, d0)) - 90;
		this.rotationPitch = -(float)Math.toDegrees(Math.atan2(d1, d3));

		if (!this.worldObj.isRemote)
		{
			this.setPositionAndUpdate(pt.x, pt.y, pt.z);
		}

		this.motionX = this.motionY = this.motionZ = 0;

		super.onUpdate();
	}
}
