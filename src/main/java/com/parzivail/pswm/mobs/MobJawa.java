package com.parzivail.pswm.mobs;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.ai.AiFreqMove;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.List;

public class MobJawa extends EntityCreature implements IMob
{
	private int angerLevel;
	private Entity angryAt;

	public MobJawa(World par1World)
	{
		super(par1World);
		setSize(0.5F, 1.5F);
		getNavigator().setCanSwim(true);
		tasks.addTask(0, new AiFreqMove(this, 1, 0));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(5.0D);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		Entity entity = source.getEntity();
		if (entity instanceof EntityPlayer)
		{
			List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.expand(32.0D, 32.0D, 32.0D));
			for (int i = 0; i < list.size(); i++)
			{
				Entity entity1 = (Entity)list.get(i);
				if (entity1 instanceof MobJawa)
				{
					MobJawa jawa = (MobJawa)entity1;
					jawa.becomeAngryAt(entity);
				}
			}
			becomeAngryAt(entity);
		}
		return super.attackEntityFrom(source, amount);
	}

	private void becomeAngryAt(Entity p_70835_1_)
	{
		entityToAttack = p_70835_1_;
		angerLevel = 400 + rand.nextInt(400);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		getDataWatcher().addObject(25, Integer.valueOf(rand.nextInt(2)));
	}

	@Override
	protected Entity findPlayerToAttack()
	{
		return angerLevel == 0 ? null : super.findPlayerToAttack();
	}

	@Override
	public boolean getCanSpawnHere()
	{
		return true;
	}

	@Override
	protected String getDeathSound()
	{
		return Resources.MODID + ":" + "mob.jawa.die";
	}

	@Override
	protected String getHurtSound()
	{
		return Resources.MODID + ":" + "mob.jawa.hit";
	}

	@Override
	protected String getLivingSound()
	{
		return Resources.MODID + ":" + "mob.jawa.say";
	}
}
