package com.parzivail.pswm.tileentities.sensor;

import com.parzivail.pswm.mobs.*;
import com.parzivail.pswm.mobs.trooper.*;
import net.minecraft.entity.EntityLiving;

public class TileEntitySensorStructureRebelMassassi extends TileEntitySensorPeoplePlace
{
	public TileEntitySensorStructureRebelMassassi()
	{
		this.rX = 30;
		this.rY = 3;
		this.rZ = 30;
		this.entityMax = 5;
		this.otherMax = 3;
	}

	public MobTrooper getNewEntity()
	{
		switch (this.worldObj.rand.nextInt(6))
		{
			case 0:
				return new MobRebelPilot(this.worldObj);
			case 1:
				return new MobRebelPilotA(this.worldObj);
			case 2:
				return new MobRebelPilotY(this.worldObj);
			case 3:
				return new MobRebelTechnician(this.worldObj);
			case 4:
				return new MobRebelWorker(this.worldObj);
			case 5:
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

	@Override
	public EntityLiving getNewEntityOther()
	{
		switch (this.worldObj.rand.nextInt(4))
		{
			case 0:
				return new MobDroidProtocol(this.worldObj);
			case 1:
				return new MobDroidAstromech(this.worldObj);
			case 2:
				return new MobDroidAstromech2(this.worldObj);
			case 3:
				return new MobDroidGNK(this.worldObj);
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
