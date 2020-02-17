package com.parzivail.pswm.mobs.trooper;

import com.parzivail.pswm.ai.AiFreqMove;
import com.parzivail.pswm.ai.AiMelee;
import com.parzivail.pswm.ai.AiTrooperAttack;
import com.parzivail.pswm.entities.EntityBlasterProbeBolt;
import com.parzivail.pswm.mobs.*;
import com.parzivail.util.world.WorldUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

import static com.parzivail.pswm.Resources.MODID;

/**
 * Created by Colby on 7/6/2016.
 */
public abstract class MobTrooper extends EntityTameable implements IMob, IShootThings
{
	private AiTrooperAttack trooperAttack;
	private int angerLevel;

	private Entity angryAt = null;

	public MobTrooper(World world)
	{
		super(world);
		setSize(0.5F, 1.5F);
		getNavigator().setEnterDoors(true);
		getNavigator().setCanSwim(true);
		getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(0, trooperAttack = new AiTrooperAttack(this, 1.0D, 10, 30, 50.0F));
		this.tasks.addTask(1, new EntityAIFollowOwner(this, 1.0D, 4.0F, 2.0F));
		tasks.addTask(2, new AiMelee(this, MobWampa.class, 1, false, 4));
		this.tasks.addTask(3, new AiFreqMove(this, 1, 20));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.25D, false));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, MobWampa.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, MobTusken.class, 0, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, MobDroidProbe.class, 0, true));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, MobTrooper.class, 0, true));
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

	public void rangeAttack(EntityLivingBase p_82196_1_, float p_82196_2_)
	{
		playSound(MODID + ":" + "item.blasterRifle.use", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(rand, -0.2D, 0.2D));
		worldObj.spawnEntityInWorld(new EntityBlasterProbeBolt(worldObj, this, p_82196_1_));
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		Entity entity = source.getEntity();
		if (entity instanceof EntityLivingBase)
		{
			final List<Entity> list = WorldUtils.getEntitiesWithinAABBExcludingEntity(worldObj, this, boundingBox.expand(32.0D, 32.0D, 32.0D));
			for (Entity entity1 : list)
			{
				if (entity1 instanceof MobTrooper)
				{
					MobTrooper trooper = (MobTrooper)entity1;
					trooper.setAngry(true);
					trooper.setLastAttacker(entity);
					trooper.setRevengeTarget((EntityLivingBase) entity);
				}
			}
		}
		return super.attackEntityFrom(source, amount);
	}

	@Override
	public void onUpdate()
	{
		angryAt = entityToAttack;
		super.onUpdate();
	}

	public boolean interact(EntityPlayer p_70085_1_)
	{
		ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();
		if (itemstack == null && !this.isTamed())
		{
			if (!this.worldObj.isRemote)
			{
				if (this.rand.nextInt(3) == 0)
				{
					this.setTamed(true);
					this.setAttackTarget(null);
					this.setHealth(20.0F);
					this.func_152115_b(p_70085_1_.getUniqueID().toString());
					this.playTameEffect(true);
					this.worldObj.setEntityState(this, (byte)7);
					this.setSitting(false);
				}
				else
				{
					this.playTameEffect(false);
					this.worldObj.setEntityState(this, (byte)6);
				}
			}

			return true;
		}

		return super.interact(p_70085_1_);
	}

	public void setAttackTarget(EntityLivingBase p_70624_1_)
	{
		super.setAttackTarget(p_70624_1_);

		if (p_70624_1_ == null)
		{
			this.setAngry(false);
		}
		else if (!this.isTamed())
		{
			this.setAngry(true);
		}
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound p_70014_1_)
	{
		super.writeEntityToNBT(p_70014_1_);
		p_70014_1_.setBoolean("Angry", this.isAngry());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound p_70037_1_)
	{
		super.readEntityFromNBT(p_70037_1_);
		this.setAngry(p_70037_1_.getBoolean("Angry"));
	}

	/**
	 * Determines whether this wolf is angry or not.
	 */
	public boolean isAngry()
	{
		return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
	}

	/**
	 * Sets whether this wolf is angry or not.
	 */
	public void setAngry(boolean p_70916_1_)
	{
		byte b0 = this.dataWatcher.getWatchableObjectByte(16);

		if (p_70916_1_)
		{
			this.dataWatcher.updateObject(16, (byte)(b0 | 2));
		}
		else
		{
			this.dataWatcher.updateObject(16, (byte)(b0 & -3));
		}
	}

	@Override
	public String getCommandSenderName()
	{
		return "Trooper";
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
	public EntityAgeable createChild(EntityAgeable p_90011_1_)
	{
		return null;
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		getDataWatcher().addObject(25, rand.nextInt(2));
	}

	@Override
	protected Entity findPlayerToAttack()
	{
		return angerLevel == 0 ? null : super.findPlayerToAttack();
	}

	@Override
	protected String getDeathSound()
	{
		return MODID + ":" + "mob.rebel.die";
	}

	@Override
	protected String getHurtSound()
	{
		return MODID + ":" + "mob.rebel.hit";
	}

	protected String getRebelSound()
	{
		return MODID + ":" + "mob.rebel.say";
	}

	protected String getImperialSound()
	{
		EntityTameable e = (EntityTameable)worldObj.findNearestEntityWithinAABB(EntityTameable.class, boundingBox.expand(10.0D, 10.0D, 10.0D), this);
		if (e instanceof MobDroidAstromech || e instanceof MobDroidProtocol)
			return MODID + ":" + "mob.sandtrooper.droid";
		return MODID + ":" + "mob.stormtrooper.say";
	}
}
