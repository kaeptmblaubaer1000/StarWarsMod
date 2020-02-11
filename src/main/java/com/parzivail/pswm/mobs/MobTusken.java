package com.parzivail.pswm.mobs;

import com.parzivail.pswm.StarWarsItems;
import com.parzivail.util.ai.AiFreqMove;
import com.parzivail.util.ai.AiMelee;
import com.parzivail.util.ai.AiShoot;
import com.parzivail.pswm.entities.EntityBlasterProbeBolt;
import com.parzivail.pswm.mobs.trooper.MobTrooper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

import static com.parzivail.pswm.Resources.MODID;

public class MobTusken extends EntityCreature implements IMob, IShootThings
{
	private AiShoot aiShoot;
	private int angerLevel;
	private Entity angryAt = null;
	private EntityAIArrowAttack aiArrow;

	public MobTusken(World par1World)
	{
		super(par1World);
		getNavigator().setCanSwim(true);
		getNavigator().setEnterDoors(true);
		getNavigator().setAvoidsWater(true);
		switch (rand.nextInt(3))
		{
			case 0:
				setCurrentItemOrArmor(0, new ItemStack(StarWarsItems.gaffiStick, 1));
				break;
			case 1:
				setCurrentItemOrArmor(0, StarWarsItems.blasterRifle.getMeta("Cycler"));
				this.tasks.addTask(0, aiShoot = new AiShoot(this, 1.0D, 20, 60, 15.0F));
				break;
		}
		this.tasks.addTask(1, new EntityAISwimming(this));
		tasks.addTask(1, new AiMelee(this, EntityPlayer.class, 1, false, 3));
		tasks.addTask(2, new AiFreqMove(this, 1, 20));
		targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
		targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, MobTrooper.class, 0, false));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(10.0D);
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.4D);
	}

	public void rangeAttack(EntityLivingBase p_82196_1_, float p_82196_2_)
	{
		playSound(MODID + ":" + "fx.shoot.cycler", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(rand, -0.2D, 0.2D));
		worldObj.spawnEntityInWorld(new EntityBlasterProbeBolt(worldObj, this, p_82196_1_));
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		Entity entity = source.getEntity();
		if (entity instanceof EntityPlayer)
		{
			@SuppressWarnings("unchecked")
			List<Entity> list = (List<Entity>) worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.expand(32.0D, 32.0D, 32.0D));
			for (Entity entity1 : list)
			{
				if (entity1 instanceof MobTusken)
				{
					MobTusken tusken = (MobTusken)entity1;
					tusken.becomeAngryAt(entity);
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
		return MODID + ":" + "mob.tusken.die";
	}

	@Override
	protected String getHurtSound()
	{
		return MODID + ":" + "mob.tusken.hit";
	}

	@Override
	protected String getLivingSound()
	{
		return MODID + ":" + "mob.tusken.say";
	}

	@Override
	protected boolean isAIEnabled()
	{
		return true;
	}

	@Override
	public void onUpdate()
	{
		angryAt = entityToAttack;
		super.onUpdate();
	}
}
