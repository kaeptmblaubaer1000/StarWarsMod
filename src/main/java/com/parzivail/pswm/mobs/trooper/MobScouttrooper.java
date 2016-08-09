package com.parzivail.pswm.mobs.trooper;

import com.parzivail.pswm.entities.EntityBlasterRifleBolt;
import com.parzivail.pswm.mobs.MobDroidAstromech;
import com.parzivail.pswm.mobs.MobDroidProtocol;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.List;
import java.util.UUID;

import static com.parzivail.pswm.Resources.MODID;
import static com.parzivail.pswm.StarWarsItems.*;
import static java.lang.Integer.valueOf;
import static java.util.UUID.fromString;
import static net.minecraft.util.MathHelper.getRandomDoubleInRange;

public class MobScouttrooper extends MobTrooper
{
	private static final UUID field_110189_bq = fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
	private static final AttributeModifier field_110190_br = new AttributeModifier(field_110189_bq, "Attacking speed boost", 1, 0).setSaved(false);
	private int angerLevel;
	private Entity angryAt = null;

	public MobScouttrooper(World par1World)
	{
		super(par1World);
		setCurrentItemOrArmor(4, new ItemStack(scoutTrooperHelmet, 1));
		setCurrentItemOrArmor(3, new ItemStack(scoutTrooperChest, 1));
		setCurrentItemOrArmor(2, new ItemStack(scoutTrooperLegs, 1));
		setCurrentItemOrArmor(1, new ItemStack(scoutTrooperBoots, 1));
		switch (rand.nextInt(2))
		{
			case 0:
				setCurrentItemOrArmor(0, blasterRifle.getMeta("Stormtrooper"));
				break;
			case 1:
				setCurrentItemOrArmor(0, blasterPistol.getMeta("Scout"));
				break;
		}
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
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		Entity entity = source.getEntity();
		if (entity instanceof EntityPlayer)
		{
			List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.expand(32.0D, 32.0D, 32.0D));
			for (int i = 0; i < list.size(); i++)
			{
				Entity entity1 = (Entity)list.get(i);
				if (entity1 instanceof MobScouttrooper)
				{
					MobScouttrooper s = (MobScouttrooper)entity1;
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
			playSound(MODID + ":" + "item.blasterRifle.use", 1.0F, 1.0F + (float)getRandomDoubleInRange(rand, -0.2D, 0.2D));
			worldObj.spawnEntityInWorld(new EntityBlasterRifleBolt(worldObj, this, getAttackTarget()));
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
		getDataWatcher().addObject(25, valueOf(rand.nextInt(2)));
	}

	@Override
	protected Entity findPlayerToAttack()
	{
		return angerLevel == 0 ? null : super.findPlayerToAttack();
	}

	@Override
	protected String getDeathSound()
	{
		return MODID + ":" + "mob.sandtrooper.die";
	}

	@Override
	protected String getHurtSound()
	{
		return MODID + ":" + "mob.sandtrooper.hit";
	}

	@Override
	protected String getLivingSound()
	{
		EntityTameable e = (EntityTameable)worldObj.findNearestEntityWithinAABB(EntityTameable.class, boundingBox.expand(10.0D, 10.0D, 10.0D), this);
		if (e instanceof MobDroidAstromech || e instanceof MobDroidProtocol)
			return MODID + ":" + "mob.sandtrooper.droid";
		return MODID + ":" + "mob.sandtrooper.say";
	}
}
