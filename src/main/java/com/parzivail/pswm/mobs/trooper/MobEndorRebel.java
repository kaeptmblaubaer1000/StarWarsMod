package com.parzivail.pswm.mobs.trooper;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.ai.AiFreqMove;
import com.parzivail.pswm.mobs.MobDroidAstromech;
import com.parzivail.pswm.mobs.MobDroidProtocol;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;
import java.util.UUID;

public class MobEndorRebel extends EntityMob implements IMob, IRangedAttackMob
{
	private static final UUID field_110189_bq = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
	private static final AttributeModifier field_110190_br = new AttributeModifier(field_110189_bq, "Attacking speed boost", 1, 0).setSaved(false);
	private int angerLevel;
	private Entity angryAt = null;
	private EntityAIArrowAttack aiArrow;

	public MobEndorRebel(World par1World)
	{
		super(par1World);
		setSize(0.5F, 1.5F);
		getNavigator().setEnterDoors(true);
		tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.25D, false));
		tasks.addTask(1, new AiFreqMove(this, 1, 0));
		setCurrentItemOrArmor(4, new ItemStack(StarWarsMod.endorHelmet, 1));
		setCurrentItemOrArmor(3, new ItemStack(StarWarsMod.endorChest, 1));
		setCurrentItemOrArmor(2, new ItemStack(StarWarsMod.endorLegs, 1));
		setCurrentItemOrArmor(1, new ItemStack(StarWarsMod.endorBoots, 1));
		switch (rand.nextInt(2))
		{
			case 0:
				setCurrentItemOrArmor(0, StarWarsMod.blasterRifle.getMeta("A280"));
				break;
			case 1:
				setCurrentItemOrArmor(0, StarWarsMod.blasterPistol.getMeta("Dh17"));
				break;
		}
		tasks.addTask(1, aiArrow = new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
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
				if (entity1 instanceof MobEndorRebel)
				{
					MobEndorRebel s = (MobEndorRebel)entity1;
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
	protected Entity findPlayerToAttack()
	{
		return angerLevel == 0 ? null : super.findPlayerToAttack();
	}

	@Override
	public boolean getCanSpawnHere()
	{
		return worldObj.difficultySetting != net.minecraft.world.EnumDifficulty.PEACEFUL && isValidLightLevel() && rand.nextInt(20) == 0;
	}

	@Override
	protected String getDeathSound()
	{
		return Resources.MODID + ":" + "mob.sandtrooper.die";
	}

	@Override
	protected String getHurtSound()
	{
		return Resources.MODID + ":" + "mob.sandtrooper.hit";
	}

	@Override
	protected String getLivingSound()
	{
		EntityTameable e = (EntityTameable)worldObj.findNearestEntityWithinAABB(EntityTameable.class, boundingBox.expand(10.0D, 10.0D, 10.0D), this);
		if (e instanceof MobDroidAstromech || e instanceof MobDroidProtocol)
			return Resources.MODID + ":" + "mob.sandtrooper.droid";
		return Resources.MODID + ":" + "mob.sandtrooper.say";
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
