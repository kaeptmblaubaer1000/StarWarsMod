package com.parzivail.pswm.tileentities.sensor;

import com.parzivail.pswm.mobs.trooper.MobEndorRebel;
import com.parzivail.pswm.mobs.trooper.MobRebelTechnician;
import com.parzivail.pswm.mobs.trooper.MobRebelWorker;
import com.parzivail.pswm.mobs.trooper.MobTrooper;
import net.minecraft.entity.EntityLiving;

public class TileEntitySensorStructureRebelEndor extends TileEntitySensorPeoplePlace
{
	public TileEntitySensorStructureRebelEndor()
	{
		this.rX = 40;
		this.rY = 40;
		this.rZ = 40;
		this.entityMax = 5;
	}

	public MobTrooper getNewEntity()
	{
		switch (this.worldObj.rand.nextInt(3))
		{
			case 0:
				return new MobRebelWorker(this.worldObj);
			case 1:
				return new MobRebelTechnician(this.worldObj);
			case 2:
				return new MobEndorRebel(this.worldObj);
			default:
				return null;
		}
	}

	@Override
	public Class<? extends EntityLiving> getEntityNeedleClass()
	{
		return MobTrooper.class;
	}
}
