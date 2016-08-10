package com.parzivail.pswm.tileentities;

import com.parzivail.pswm.mobs.trooper.MobYodaBiped;

public class TileEntityStaticNpcYoda extends TileEntityStaticNpc
{
	MobYodaBiped yoda;

	public MobYodaBiped getInternalYoda()
	{
		if (yoda == null)
			yoda = new MobYodaBiped(this.worldObj);
		return yoda;
	}

	@Override
	public void updateEntity()
	{
		if (this.yoda != null)
		{
			if (this.yoda.worldObj == null)
				this.yoda.worldObj = this.worldObj;
			this.yoda.ticksExisted++;
		}
		super.updateEntity();
	}
}