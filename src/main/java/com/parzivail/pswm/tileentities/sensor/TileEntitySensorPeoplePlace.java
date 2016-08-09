package com.parzivail.pswm.tileentities.sensor;

import com.parzivail.pswm.mobs.trooper.MobTrooper;
import com.parzivail.pswm.tileentities.TileEntitySensor;
import com.parzivail.util.math.MathUtils;
import com.parzivail.util.ui.Lumberjack;
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

	public TileEntitySensorPeoplePlace()
	{
		this.rX = 20;
		this.rY = 20;
		this.rZ = 20;
		this.entityMax = 30;
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
			int troopers = MathUtils.howManyOfType(entitiesInAabb, MobTrooper.class);

			if (MathUtils.howManyOfType(entitiesInAabb, EntityPlayer.class) > 0) // Uh oh, slaughterer alert!
			{
				long currentTime = System.currentTimeMillis();
				if (currentTime >= nextTime && troopers < entityMax) // The time has come
				{
					spawnANewOne(); // hit em wit it
					Lumberjack.log("Spawned one because i think one was killed. Troopers: " + troopers);
					int n = getRandomTimeNext();
					nextTime = currentTime + n; // (but not too much)
					Lumberjack.log("Waiting " + n + "ms...");
				}
			}
			else
			{
				// Nobody here, populate!
				if (troopers < entityMax)
				{
					spawnANewOne();
					Lumberjack.log("Spawned one because player outside range. Troopers: " + troopers);
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

		MobTrooper entity = getNewTrooper();
		entity.setLocationAndAngles(x, y, z, this.worldObj.rand.nextFloat() * 360.0F, 0.0F);
		worldObj.spawnEntityInWorld(entity);
	}

	public int getRandomTimeNext()
	{
		return MathUtils.randomRange(60000, 300000); // between 1 and 5 minutes
	}

	public abstract MobTrooper getNewTrooper();
}
