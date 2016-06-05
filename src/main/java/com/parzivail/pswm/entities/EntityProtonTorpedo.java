package com.parzivail.pswm.entities;

import com.parzivail.pswm.StarWarsMod;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityProtonTorpedo extends EntityBlasterBoltBase
{
	public EntityProtonTorpedo(World par1World)
	{
		super(par1World, 5.0f);
	}

	public EntityProtonTorpedo(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6, 5.0f);
	}

	public EntityProtonTorpedo(World par1World, EntityLivingBase par2EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase, 5.0f);
	}

	public EntityProtonTorpedo(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase, par3EntityLivingBase, 5.0f);
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if (worldObj.isRemote)
			for (int i = 0; i < 10; i++)
				this.worldObj.spawnParticle("flame", this.posX + (StarWarsMod.rngGeneral.nextFloat() - 0.5f) / 3f, this.posY + (StarWarsMod.rngGeneral.nextFloat() - 0.5f) / 3f, this.posZ + (StarWarsMod.rngGeneral.nextFloat() - 0.5f) / 3f, 0, 0, 0);
	}

	@Override
	protected void onImpact(MovingObjectPosition pos)
	{
		super.onImpact(pos);
		if (pos.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
			this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 5, true);
	}
}
