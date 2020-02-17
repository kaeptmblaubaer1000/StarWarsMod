package com.parzivail.pswm.turrets;

import com.parzivail.pswm.ai.AiTurretAttack;
import com.parzivail.pswm.entities.EntityLaserTurret;
import com.parzivail.pswm.mobs.IShootThings;
import com.parzivail.pswm.vehicles.VehicAWing;
import com.parzivail.pswm.vehicles.VehicXWing;
import com.parzivail.pswm.vehicles.VehicYWing;
import com.parzivail.util.world.WorldUtils;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.IMob;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

import static com.parzivail.pswm.Resources.MODID;

public abstract class TurretBaseImperial extends EntityCreature implements IMob, IShootThings
{

	private AiTurretAttack aiTurretAttack = new AiTurretAttack(this, 0.0D, 5, 10, 120.0F);

	public TurretBaseImperial(World world)
	{
		super(world);
		this.tasks.addTask(0, this.aiTurretAttack);
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, VehicXWing.class, 0, true));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, VehicYWing.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, VehicAWing.class, 0, true));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0D);
	}

	public void rangeAttack(EntityLivingBase p_82196_1_, float p_82196_2_)
	{
		playSound(MODID + ":" + "item.blasterRifle.use", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(rand, -0.5D, 0.5D));
		worldObj.spawnEntityInWorld(new EntityLaserTurret(worldObj, this, p_82196_1_));
	}

	@Override
	public void onUpdate()
	{
		List<Entity> list = WorldUtils.getEntitiesWithinAABBExcludingEntity(worldObj, this, boundingBox.expand(32.0D, 32.0D, 32.0D));
		for (Entity entity1 : list)
		{
			List<Entity> list2 = WorldUtils.getEntitiesWithinAABBExcludingEntity(worldObj, this, boundingBox.expand(100.0D, 100.0D, 100.0D));
			for(Entity entity : list2)
			{
				if (entity1 instanceof GroundTurretImperial)
				{
					TurretBaseImperial turrets = (TurretBaseImperial)entity1;
					if (entity instanceof VehicXWing || entity instanceof VehicAWing || entity instanceof VehicYWing)
					{
						turrets.setAttackTarget((EntityLivingBase) entity);
					}
				}
			}
		}
		super.onUpdate();
	}

	@Override
	public String getCommandSenderName()
	{
		return "Turret";
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	protected boolean canDespawn()
	{
		return false;
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		getDataWatcher().addObject(25, rand.nextInt(2));
	}

	@Override
	protected String getDeathSound()
	{
		return null;
	}

	@Override
	protected String getHurtSound()
	{
		// TODO add sound effect
		return null;
	}
}
