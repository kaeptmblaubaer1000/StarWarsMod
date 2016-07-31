package com.parzivail.pswm.tileentities;

import com.parzivail.pswm.mobs.MobJawa;

public class TileEntityStaticNpcJawa extends TileEntityStaticNpc
{
	MobJawa jawa;

	public MobJawa getInternalJawa()
	{
		if (jawa == null)
			jawa = new MobJawa(this.worldObj);
		return jawa;
	}

	@Override
	public void updateEntity()
	{
		if (this.jawa != null)
		{
			if (this.jawa.worldObj == null)
				this.jawa.worldObj = this.worldObj;
			this.jawa.ticksExisted++;
		}
		super.updateEntity();
	}
}