package com.parzivail.pswm.tileentities.sensor;

import com.parzivail.pswm.tileentities.TileEntitySensor;
import com.parzivail.util.math.MathUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;

import java.util.List;

public abstract class TileEntitySensorPeoplePlace extends TileEntitySensor
{
	public Class<? extends Entity> needle;
	protected int rX;
	protected int rY;
	protected int rZ;
	private long nextTime = 0;
	protected int entityMax;
	protected int otherMax;

	public TileEntitySensorPeoplePlace()
	{
		this.rX = 30;
		this.rY = 30;
		this.rZ = 30;
		this.entityMax = 15;
		this.entityMax = 0;
	}

	@Override
	public boolean checkCondition()
	{
		return this.worldObj != null;
	}

	@Override
	public void runConditional()
	{
		if (!worldObj.isRemote)
		{
			List<EntityLiving> entitiesInAabb = this.worldObj.getEntitiesWithinAABB(Entity.class, this.bb.expand(rX, rY, rZ));

			int entities = MathUtils.howManyOfType(entitiesInAabb, getEntityNeedleClass());
			int entitiesOther = MathUtils.howManyOfType(entitiesInAabb, getEntityNeedleClassOther());

			if (MathUtils.howManyOfType(entitiesInAabb, EntityPlayer.class) > 0) // Uh oh, slaughterer alert!
			{
				long currentTime = System.currentTimeMillis();
				if (currentTime >= nextTime) // The time has come
				{
					if (entities < entityMax)
						spawnANewOne(); // hit em wit it
					if (entitiesOther < otherMax)
						spawnANewOther(); // hit em wit it
					//Lumberjack.log("Spawned one because i think one was killed. entities: " + entities);
					int n = getRandomTimeNext();
					nextTime = currentTime + n; // (but not too much)
					//Lumberjack.log("Waiting " + n + "ms...");
				}
			}
			else
			{
				// Nobody here, populate!
				if (entities < entityMax)
				{
					spawnANewOne();
					//Lumberjack.log("Spawned one because player outside range. entities: " + (entities + 1));
				}
				// Nobody here, populate!
				if (entitiesOther < otherMax)
				{
					spawnANewOther();
					//Lumberjack.log("Spawned one because player outside range. entities: " + (entities + 1));
				}
			}
		}
	}

	private void spawnANewOne()
	{
		int x, y, z;
		do
		{
			x = (int)((double)this.xCoord + (this.worldObj.rand.nextDouble() - this.worldObj.rand.nextDouble()) * (double)this.rX);
			y = this.yCoord + 1;
			z = (int)((double)this.zCoord + (this.worldObj.rand.nextDouble() - this.worldObj.rand.nextDouble()) * (double)this.rZ);
		}
		while (worldObj.getBlock(x, y - 1, z) == Blocks.air && worldObj.getBlock(x, y + 1, z) != Blocks.air);

		EntityLiving entity = getNewEntity();
		entity.setLocationAndAngles(x, y, z, this.worldObj.rand.nextFloat() * 360.0F, 0.0F);
		worldObj.spawnEntityInWorld(entity);
	}

	private void spawnANewOther()
	{
		int x, y, z;
		do
		{
			x = (int)((double)this.xCoord + (this.worldObj.rand.nextDouble() - this.worldObj.rand.nextDouble()) * (double)this.rX);
			y = this.yCoord + 1;
			z = (int)((double)this.zCoord + (this.worldObj.rand.nextDouble() - this.worldObj.rand.nextDouble()) * (double)this.rZ);
		}
		while (worldObj.getBlock(x, y - 1, z) == Blocks.air && worldObj.getBlock(x, y + 1, z) != Blocks.air);

		EntityLiving entity = getNewEntityOther();
		entity.setLocationAndAngles(x, y, z, this.worldObj.rand.nextFloat() * 360.0F, 0.0F);
		worldObj.spawnEntityInWorld(entity);
	}

	public int getRandomTimeNext()
	{
		return MathUtils.randomRange(60000, 300000); // between 1 and 5 minutes
	}

	public abstract EntityLiving getNewEntity();

	public abstract Class<? extends EntityLiving> getEntityNeedleClass();

	public EntityLiving getNewEntityOther()
	{
		return null;
	}

	public Class<? extends EntityLiving> getEntityNeedleClassOther()
	{
		return null;
	}
}
