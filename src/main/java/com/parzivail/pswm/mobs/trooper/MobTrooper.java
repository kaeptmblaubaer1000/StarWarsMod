package com.parzivail.pswm.mobs.trooper;

import com.parzivail.pswm.ai.AiFreqMove;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by Colby on 7/6/2016.
 */
public abstract class MobTrooper extends EntityTameable implements IMob, IRangedAttackMob
{
	private EntityAIArrowAttack aiArrow;

	public MobTrooper(World world)
	{
		super(world);
		setSize(0.5F, 1.5F);
		getNavigator().setEnterDoors(true);
		this.tasks.addTask(0, new EntityAIFollowOwner(this, 1.0D, 4.0F, 2.0F));
		this.tasks.addTask(1, aiArrow = new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F));
		this.tasks.addTask(2, new AiFreqMove(this, 1, 20));
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.25D, false));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.setTamed(false);
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(50.0D);
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
	}
}
