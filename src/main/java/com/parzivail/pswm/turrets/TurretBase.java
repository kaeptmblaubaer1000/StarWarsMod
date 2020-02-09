package com.parzivail.pswm.turrets;

import com.parzivail.pswm.ai.AiTrooperAttack;
import com.parzivail.pswm.ai.AiTurretAttack;
import com.parzivail.pswm.entities.EntityBlasterProbeBolt;
import com.parzivail.pswm.mobs.IShootThings;
import com.parzivail.pswm.mobs.MobWookiee;
import com.parzivail.pswm.vehicles.VehicXWing;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.IMob;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import scala.collection.Iterator;

import java.util.List;

import static com.parzivail.pswm.Resources.MODID;

public abstract class TurretBase extends EntityCreature implements IMob, IShootThings
{

	private AiTurretAttack aiTurretAttack = new AiTurretAttack(this, 0.0D, 5, 10, 500.0F);

	public TurretBase(World world)
	{
		super(world);
		setSize(2.0f, 2.0f);
		this.tasks.addTask(0, this.aiTurretAttack);
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, VehicXWing.class, 0, true));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(80.0D);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0D);
	}

	public void rangeAttack(EntityLivingBase p_82196_1_, float p_82196_2_)
	{
		playSound(MODID + ":" + "item.blasterRifle.use", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(rand, -0.5D, 0.5D));
		worldObj.spawnEntityInWorld(new EntityBlasterProbeBolt(worldObj, this, p_82196_1_));
	}

	@Override
	public void onUpdate()
	{
		List<Entity> list = (List<Entity>) worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.expand(32.0D, 32.0D, 32.0D));
		for (Entity entity1 : list)
		{
			List<Entity> list2 = (List<Entity>) worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.expand(100.0D, 100.0D, 100.0D));
			for(Entity entity : list2)
			{
				if (entity1 instanceof GroundTurretImperial)
				{
					TurretBase turrets = (TurretBase)entity1;
					if (entity instanceof VehicXWing)
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
