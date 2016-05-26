package com.parzivail.pswm.mobs.trooper;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.mobs.MobDroidAstromech;
import com.parzivail.pswm.mobs.MobDroidProtocol;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;
import java.util.UUID;

public class MobSnowtrooper extends EntityTameable implements IMob, IRangedAttackMob
{
	private static final UUID field_110189_bq = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
	private static final AttributeModifier field_110190_br = new AttributeModifier(field_110189_bq, "Attacking speed boost", 1, 0).setSaved(false);
	private int angerLevel;
	private Entity angryAt = null;
	private EntityAIArrowAttack aiArrow;

	public MobSnowtrooper(World par1World)
	{
		super(par1World);
		setSize(0.5F, 1.5F);
		getNavigator().setEnterDoors(true);
		setCurrentItemOrArmor(4, new ItemStack(StarWarsItems.snowtrooperHelmet, 1));
		setCurrentItemOrArmor(3, new ItemStack(StarWarsItems.snowtrooperChest, 1));
		setCurrentItemOrArmor(2, new ItemStack(StarWarsItems.snowtrooperLegs, 1));
		setCurrentItemOrArmor(1, new ItemStack(StarWarsItems.snowtrooperBoots, 1));
		switch (rand.nextInt(3))
		{
			case 0:
				setCurrentItemOrArmor(0, StarWarsItems.blasterRifle.getMeta("Stormtrooper"));
				break;
			case 1:
				setCurrentItemOrArmor(0, StarWarsItems.blasterHeavy.getMeta("Dlt19"));
				break;
			case 2:
				setCurrentItemOrArmor(0, StarWarsItems.blasterHeavy.getMeta("T21"));
				break;
		}
		tasks.addTask(1, aiArrow = new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F));

		tasks.addTask(0, new EntityAIFollowOwner(this, 1.0D, 4.0F, 2.0F));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(9, new EntityAILookIdle(this));
		tasks.addTask(10, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.25D, false));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.setTamed(false);
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

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15.0D);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.28D);
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
				if (entity1 instanceof MobSnowtrooper)
				{
					MobSnowtrooper s = (MobSnowtrooper)entity1;
					s.becomeAngryAt(entity);
				}
			}
			becomeAngryAt(entity);
		}
		return super.attackEntityFrom(source, amount);
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_)
	{
		if (angryAt != null)
		{
			playSound(Resources.MODID + ":" + "item.blasterRifle.use", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(rand, -0.2D, 0.2D));
			worldObj.spawnEntityInWorld(new com.parzivail.pswm.entities.EntityBlasterRifleBolt(worldObj, this, getAttackTarget()));
		}
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
	protected String getDeathSound()
	{
		return Resources.MODID + ":" + "mob.stormtrooper.die";
	}

	@Override
	protected String getHurtSound()
	{
		return Resources.MODID + ":" + "mob.stormtrooper.hit";
	}

	@Override
	protected String getLivingSound()
	{
		EntityTameable e = (EntityTameable)worldObj.findNearestEntityWithinAABB(EntityTameable.class, boundingBox.expand(10.0D, 10.0D, 10.0D), this);
		if (e instanceof MobDroidAstromech || e instanceof MobDroidProtocol)
			return Resources.MODID + ":" + "mob.sandtrooper.droid";
		return Resources.MODID + ":" + "mob.stormtrooper.say";
	}

	@Override
	public void onUpdate()
	{
		if (angryAt != entityToAttack && !worldObj.isRemote)
		{
			IAttributeInstance iattributeinstance = getEntityAttribute(SharedMonsterAttributes.movementSpeed);
			iattributeinstance.removeModifier(field_110190_br);

			if (entityToAttack != null)
				iattributeinstance.applyModifier(field_110190_br);
		}

		angryAt = entityToAttack;
		super.onUpdate();
	}
}
