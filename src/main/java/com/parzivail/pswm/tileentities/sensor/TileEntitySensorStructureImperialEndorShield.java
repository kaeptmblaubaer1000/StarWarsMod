package com.parzivail.pswm.tileentities.sensor;

import com.parzivail.pswm.mobs.EntityDroidBase;
import com.parzivail.pswm.mobs.MobDroidAstromechImperial;
import com.parzivail.pswm.mobs.MobDroidAstromechImperial2;
import com.parzivail.pswm.mobs.MobDroidMouse;
import com.parzivail.pswm.mobs.trooper.MobImperialOfficer;
import com.parzivail.pswm.mobs.trooper.MobScouttrooper;
import com.parzivail.pswm.mobs.trooper.MobTrooper;
import net.minecraft.entity.EntityLiving;

public class TileEntitySensorStructureImperialEndorShield extends TileEntitySensorPeoplePlace
{
	public TileEntitySensorStructureImperialEndorShield()
	{
		this.rX = 20;
		this.rY = 3;
		this.rZ = 20;
		this.entityMax = 5;
		this.otherMax = 2;
	}

	public MobTrooper getNewEntity()
	{
		switch (this.worldObj.rand.nextInt(2))
		{
			case 0:
				return new MobScouttrooper(this.worldObj);
			case 1:
				return new MobImperialOfficer(this.worldObj);
			default:
				return null;
		}
	}

	@Override
	public Class<? extends EntityLiving> getEntityNeedleClass()
	{
		return MobTrooper.class;
	}

	@Override
	public EntityLiving getNewEntityOther()
	{
		switch (this.worldObj.rand.nextInt(4))
		{
			case 1:
				return new MobDroidAstromechImperial(this.worldObj);
			case 2:
				return new MobDroidAstromechImperial2(this.worldObj);
			case 3:
				return new MobDroidMouse(this.worldObj);
			default:
				return null;
		}
	}

	@Override
	public Class<? extends EntityLiving> getEntityNeedleClassOther()
	{
		return EntityDroidBase.class;
	}
}
