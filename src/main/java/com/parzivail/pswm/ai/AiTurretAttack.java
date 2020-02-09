package com.parzivail.pswm.ai;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.armor.*;
import com.parzivail.pswm.items.ItemQuestLog;
import com.parzivail.pswm.mobs.IShootThings;
import com.parzivail.pswm.mobs.MobDroidProbe;
import com.parzivail.pswm.mobs.MobTusken;
import com.parzivail.pswm.mobs.MobWampa;
import com.parzivail.pswm.mobs.trooper.*;
import com.parzivail.pswm.quest.QuestUtils;
import com.parzivail.pswm.turrets.GroundTurretImperial;
import com.parzivail.pswm.vehicles.VehicXWing;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;

/**
 * @author Colby
 */
public class AiTurretAttack extends EntityAIBase
{
	/**
	 * The entity the AI instance has been applied to
	 */
	private final EntityLiving entityHost;
	/**
	 * The entity (as a RangedAttackMob) the AI instance has been applied to.
	 */
	private final EntityLivingBase rangedAttackEntityHost;
	private EntityLivingBase attackTarget;
	/**
	 * A decrementing tick that spawns a ranged attack once this value reaches 0. It is then set back to the
	 * maxRangedAttackTime.
	 */
	private int rangedAttackTime;
	private double entityMoveSpeed;
	private int field_75318_f;
	private int minRangeAttackTime;
	/**
	 * The maximum time the AI has to wait before peforming another ranged attack.
	 */
	private int maxRangedAttackTime;
	private float field_96562_i;
	private float field_82642_h;

	public AiTurretAttack(EntityLiving entityHost, double entityMoveSpeed, int maxRangeAttackTime, float p_i1649_5_)
	{
		this(entityHost, entityMoveSpeed, maxRangeAttackTime, maxRangeAttackTime, p_i1649_5_);
	}

	public AiTurretAttack(EntityLiving entityHost, double entityMoveSpeed, int minRangeAttackTime, int maxRangeAttackTime, float p_i1650_6_)
	{
		this.rangedAttackTime = -1;

		if (!(entityHost instanceof EntityLivingBase))
		{
			throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
		}
		else
		{
			this.rangedAttackEntityHost = entityHost;
			this.entityHost = entityHost;
			this.entityMoveSpeed = entityMoveSpeed;
			this.minRangeAttackTime = minRangeAttackTime;
			this.maxRangedAttackTime = maxRangeAttackTime;
			this.field_96562_i = p_i1650_6_;
			this.field_82642_h = p_i1650_6_ * p_i1650_6_;
			this.setMutexBits(3);
		}
	}

	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	public boolean shouldExecute()
	{
		EntityLivingBase entity = this.entityHost.getAttackTarget();

		if (entity == null)
		{
			return false;
		}
		else if (shouldIAttack(entity))
		{
			this.attackTarget = entity;
			return true;
		}
		return false;
	}

	private boolean shouldIAttack(EntityLivingBase entity)
	{
		if (this.rangedAttackEntityHost.getEquipmentInSlot(0) == null && !(this.rangedAttackEntityHost instanceof GroundTurretImperial))
			return false;
		if(entity instanceof VehicXWing)
			return true;
		if(entityHost.getAttackTarget() != null)
			return true;
//		if (isARebel(rangedAttackEntityHost))
//			return true;
//		else if (isAnImperial(rangedAttackEntityHost))
//			return isARebel(entity);
		return false;
	}

	private boolean isARebel(EntityLivingBase entity)
	{
		if (entity instanceof VehicXWing)
		{
			return true;
		}
		return (entity instanceof GroundTurretImperial);
	}

	private boolean isAnImperial(EntityLivingBase entity)
	{
		if (entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)entity;
			return QuestUtils.hasOnArmor(player, ArmorAtatPilot.class) || QuestUtils.hasOnArmor(player, ArmorAtstPilot.class) || QuestUtils.hasOnArmor(player, ArmorSandtrooper.class) || QuestUtils.hasOnArmor(player, ArmorScoutTrooper.class) || QuestUtils.hasOnArmor(player, ArmorShadowtrooper.class) || QuestUtils.hasOnArmor(player, ArmorSnowtrooper.class) || QuestUtils.hasOnArmor(player, ArmorStormtrooper.class) || QuestUtils.hasOnArmor(player, ArmorTiePilot.class) || ItemQuestLog.getSide(player).equals(Resources.allegianceImperialFmt);
		}
		return (entity instanceof MobDroidProbe || entity instanceof MobAtatPilot || entity instanceof MobAtstPilot || entity instanceof MobImperialOfficer || entity instanceof MobSandtrooper || entity instanceof MobScouttrooper || entity instanceof MobSnowtrooper || entity instanceof MobStormtrooper || entity instanceof MobTiePilot);
	}
	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
	public boolean continueExecuting()
	{
		return this.shouldExecute() || !this.entityHost.getNavigator().noPath();
	}

	/**
	 * Resets the task
	 */
	public void resetTask()
	{
		this.attackTarget = null;
		this.field_75318_f = 0;
		this.rangedAttackTime = -1;
	}

	/**
	 * Updates the task
	 */
	public void updateTask()
	{
		double d0 = this.entityHost.getDistanceSq(this.attackTarget.posX, this.attackTarget.boundingBox.minY, this.attackTarget.posZ);
		boolean flag = this.entityHost.getEntitySenses().canSee(this.attackTarget);

		if (flag)
		{
			++this.field_75318_f;
		}
		else
		{
			this.field_75318_f = 0;
		}

		if (d0 <= (double)this.field_82642_h && this.field_75318_f >= 20)
		{
			this.entityHost.getNavigator().clearPathEntity();
		}
		else
		{
			this.entityHost.getNavigator().tryMoveToEntityLiving(this.attackTarget, this.entityMoveSpeed);
		}

		this.entityHost.getLookHelper().setLookPositionWithEntity(this.attackTarget, 5000.0F, 5000.0F);
		float f;

		if (--this.rangedAttackTime == 0)
		{
			if (d0 > (double)this.field_82642_h || !flag)
			{
				return;
			}

			f = MathHelper.sqrt_double(d0) / this.field_96562_i;
			float f1 = f;

			if (f < 2500.0F)
			{
				f1 = 2500.0F;
			}

			if (f1 > 5000.0F)
			{
				f1 = 5000.0F;
			}

			((IShootThings)this.rangedAttackEntityHost).rangeAttack(this.attackTarget, f1);
			this.rangedAttackTime = MathHelper.floor_float(f * (float)(this.maxRangedAttackTime - this.minRangeAttackTime) + (float)this.minRangeAttackTime);
		}
		else if (this.rangedAttackTime < 0)
		{
			f = MathHelper.sqrt_double(d0) / this.field_96562_i;
			this.rangedAttackTime = MathHelper.floor_float(f * (float)(this.maxRangedAttackTime - this.minRangeAttackTime) + (float)this.minRangeAttackTime);
		}
	}
}

