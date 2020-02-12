package com.parzivail.pswm.entities;

import com.parzivail.pswm.StarWarsMod;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityProtonTorpedo extends EntityBlasterBoltBase
{
	public EntityProtonTorpedo(World par1World)
	{
		super(par1World, 5.0f);
	}

//	public EntityProtonTorpedo(World par1World, double par2, double par4, double par6)
//	{
//		super(par1World, par2, par4, par6, 100.0f);
//	}

	public EntityProtonTorpedo(World par1World, EntityLivingBase par2EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase, 100.0f);
	}

	public EntityProtonTorpedo(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase, par3EntityLivingBase, 100.0f);
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
		if ((pos.typeOfHit == MovingObjectPosition.MovingObjectType.ENTITY && pos.entityHit == getSender()) || this.ticksExisted < 10)
			return;

		super.onImpact(pos);
		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 5, true);
	}

	@Override
	public void recreate(EntityPlayer hit)
	{
		this.setDead();
	}
}
