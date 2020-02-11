package com.parzivail.pswm.mobs;

import com.parzivail.pswm.ai.AiFreqMove;
import com.parzivail.pswm.ai.AiMelee;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.List;
import java.util.UUID;

import static com.parzivail.pswm.Resources.MODID;
import static com.parzivail.pswm.StarWarsItems.*;
import static com.parzivail.pswm.StarWarsMod.rngGeneral;
import static java.util.UUID.fromString;
import static net.minecraft.entity.SharedMonsterAttributes.maxHealth;
import static net.minecraft.entity.SharedMonsterAttributes.movementSpeed;

public class MobGamorrean extends EntityCreature implements IMob
{
	private static final UUID field_110189_bq = fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
	private static final AttributeModifier field_110190_br = new AttributeModifier(field_110189_bq, "Attacking speed boost", 1, 0).setSaved(false);
	private int angerLevel;
	private Entity angryAt;

	public MobGamorrean(World par1World)
	{
		super(par1World);
		getNavigator().setCanSwim(true);
		tasks.addTask(0, new AiMelee(this, EntityPlayer.class, 1, false, 4));
		tasks.addTask(1, new AiFreqMove(this, 1, 0));
		targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
		switch (rngGeneral.nextInt(3))
		{
			case 0:
				setCurrentItemOrArmor(0, new ItemStack(gamorreanAx1, 1));
				break;
			case 1:
				setCurrentItemOrArmor(0, new ItemStack(gamorreanAx2, 1));
				break;
			case 2:
				setCurrentItemOrArmor(0, new ItemStack(gamorreanAx3, 1));
				break;
		}
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(maxHealth).setBaseValue(45.0D);
		getEntityAttribute(movementSpeed).setBaseValue(0.24D);
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
				if (entity1 instanceof MobGamorrean)
				{
					MobGamorrean jawa = (MobGamorrean)entity1;
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
	public void dropFewItems(boolean par1, int par2)
	{
		switch (rand.nextInt(10))
		{
			case 0:
				dropItem(gamorreanAx1, 1);
		}
	}

	@Override
	protected Entity findPlayerToAttack()
	{
		return angerLevel == 0 ? null : super.findPlayerToAttack();
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

	@Override
	protected String getDeathSound()
	{
		return MODID + ":" + "mob.gamor.die";
	}

	@Override
	protected String getHurtSound()
	{
		return MODID + ":" + "mob.gamor.hit";
	}

	@Override
	protected String getLivingSound()
	{
		return MODID + ":" + "mob.gamor.say";
	}
}
