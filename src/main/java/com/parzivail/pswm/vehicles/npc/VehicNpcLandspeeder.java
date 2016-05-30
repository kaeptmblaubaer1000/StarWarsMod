package com.parzivail.pswm.vehicles.npc;

import com.parzivail.util.math.FPoint;
import com.parzivail.util.math.MathUtils;
import com.parzivail.util.math.Spline3D;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class VehicNpcLandspeeder extends EntityLiving
{
	Spline3D path;

	FPoint[][] paths = { { new FPoint(3, 69, 1), new FPoint(11, 69, 11), new FPoint(18, 69, 19), new FPoint(26, 69, 32), new FPoint(36, 69, 43), new FPoint(45, 69, 57), new FPoint(58, 69, 66), new FPoint(69, 69, 85), new FPoint(84, 69, 100), new FPoint(91, 69, 107), new FPoint(92, 69, 124), new FPoint(93, 69, 146), new FPoint(98, 69, 154), new FPoint(108, 69, 172), new FPoint(121, 69, 190), new FPoint(122, 69, 215), new FPoint(126, 69, 232), new FPoint(127, 69, 250), new FPoint(134, 69, 264), new FPoint(141, 69, 281), new FPoint(140, 70, 349) },

			{ new FPoint(3, 69, 1), new FPoint(22, 69, 20), new FPoint(25, 69, 36), new FPoint(39, 69, 48), new FPoint(44, 69, 59), new FPoint(21, 69, 79), new FPoint(4, 69, 94), new FPoint(-13, 71, 114), new FPoint(-62, 69, 133) },

			{ new FPoint(4, 69, 3), new FPoint(45, 69, 57), new FPoint(66, 69, 74), new FPoint(92, 69, 105), new FPoint(92, 69, 142), new FPoint(98, 69, 155), new FPoint(68, 69, 166), new FPoint(0, 69, 169) },

			{ new FPoint(3, 69, 1), new FPoint(31, 69, 38), new FPoint(49, 69, 61), new FPoint(71, 69, 84), new FPoint(92, 69, 106), new FPoint(94, 69, 146), new FPoint(97, 69, 156), new FPoint(58, 69, 170), new FPoint(46, 69, 176), new FPoint(32, 69, 191), new FPoint(40, 69, 216), new FPoint(42, 69, 225), new FPoint(29, 69, 239), new FPoint(30, 69, 260), new FPoint(29, 69, 264), new FPoint(29, 69, 273) },

			{ new FPoint(3, 69, 1), new FPoint(27, 69, 31), new FPoint(38, 69, 49), new FPoint(65, 69, 74), new FPoint(82, 69, 98), new FPoint(92, 69, 115), new FPoint(94, 69, 146), new FPoint(99, 69, 155), new FPoint(83, 69, 161), new FPoint(45, 69, 177), new FPoint(37, 69, 208), new FPoint(55, 69, 242), new FPoint(73, 69, 240), new FPoint(92, 69, 242), new FPoint(113, 69, 230), new FPoint(127, 69, 250), new FPoint(137, 69, 267) },

			{ new FPoint(4, 69, 1), new FPoint(32, 69, 37), new FPoint(53, 69, 62), new FPoint(71, 69, 83), new FPoint(83, 69, 100), new FPoint(93, 69, 111), new FPoint(93, 69, 137), new FPoint(94, 69, 147), new FPoint(100, 69, 155), new FPoint(116, 69, 148), new FPoint(130, 69, 133), new FPoint(166, 69, 126), new FPoint(193, 69, 118) }, { new FPoint(3, 69, 1), new FPoint(27, 69, 31), new FPoint(38, 69, 49), new FPoint(65, 69, 74), new FPoint(82, 69, 98), new FPoint(92, 69, 115), new FPoint(94, 69, 146), new FPoint(99, 69, 155), new FPoint(83, 69, 161), new FPoint(45, 69, 177), new FPoint(37, 69, 208), new FPoint(55, 69, 242), new FPoint(73, 69, 240), new FPoint(92, 69, 242), new FPoint(113, 69, 230), new FPoint(127, 69, 250), new FPoint(137, 69, 267) },

			{ new FPoint(3, 69, 2), new FPoint(25, 69, 28), new FPoint(41, 69, 52), new FPoint(66, 69, 75), new FPoint(82, 69, 101), new FPoint(92, 69, 105), new FPoint(115, 69, 87), new FPoint(144, 69, 58), new FPoint(152, 69, 30), new FPoint(149, 69, 0) } };

	public VehicNpcLandspeeder(World par1World)
	{
		super(par1World);
		this.setSize(2.0F, 2.0F);

		path = new Spline3D(MathUtils.getRandomElement(paths));
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
