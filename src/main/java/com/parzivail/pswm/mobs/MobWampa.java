package com.parzivail.pswm.mobs;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.ai.AiFreqMove;
import com.parzivail.pswm.ai.AiMelee;
import com.parzivail.pswm.mobs.trooper.MobTrooper;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class MobWampa extends EntityCreature implements IMob
{
	public MobWampa(World par1World)
	{
		super(par1World);
		getNavigator().setCanSwim(true);
		tasks.addTask(0, new AiMelee(this, EntityPlayer.class, 1, false, 6));
		tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1, false));
		tasks.addTask(2, new AiFreqMove(this, 1, 0));
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, MobTrooper.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
		setSize(2.0F, 3.0F);
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(25.0D);
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(45.0D);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
	}

	@Override
	protected boolean isAIEnabled()
	{
		return true;
	}

	@Override
	public boolean getCanSpawnHere()
	{
		int i = MathHelper.floor_double(boundingBox.minY);
		if (i >= 40)
			return false;
		int j = MathHelper.floor_double(posX);
		int k = MathHelper.floor_double(posZ);
		int l = worldObj.getBlockLightValue(j, i, k);
		if (rand.nextInt(100) < 90)
			return false;
		return l <= rand.nextInt(7) && super.getCanSpawnHere();
	}

	@Override
	protected String getDeathSound()
	{
		return Resources.MODID + ":" + "mob.wampa.die";
	}

	@Override
	protected String getHurtSound()
	{
		return Resources.MODID + ":" + "mob.wampa.hit";
	}

	@Override
	protected String getLivingSound()
	{
		return Resources.MODID + ":" + "mob.wampa.say";
	}

	@Override
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
	{
		this.dropItem(StarWarsItems.wampaHorn, 1);
	}
}
