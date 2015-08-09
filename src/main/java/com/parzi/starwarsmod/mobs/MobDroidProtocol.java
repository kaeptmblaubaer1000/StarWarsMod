package com.parzi.starwarsmod.mobs;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.EntityUtils;

public class MobDroidProtocol extends EntityTameable
{
	private EntityAITempt aiTempt;

	public MobDroidProtocol(World par1World)
	{
		super(par1World);
		setSize(1, 2);
		tasks.addTask(2, aiSit);
		tasks.addTask(3, aiTempt = new EntityAITempt(this, 0.6D, StarWarsMod.droidCaller, true));
		tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D, 10.0F, 5.0F));
		tasks.addTask(6, new EntityAIMate(this, 0.8D));
		tasks.addTask(7, new EntityAIWander(this, 0.8D));
		tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(5.0D);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
	}

	@Override
	protected boolean canDespawn()
	{
		return false;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dropFewItems(boolean par1, int par2)
	{
		dropItem(StarWarsMod.spawnProtocol, 1);
	}

	@Override
	protected void dropRareDrop(int par1)
	{
		/*
		 * switch (this.rand.nextInt(1)) { case 0:
		 * this.dropItem(StarWarsMod.gaffiStick, 1); break; }
		 */
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		dataWatcher.addObject(18, Byte.valueOf((byte)0));
	}

	@Override
	public boolean getCanSpawnHere()
	{
		return true;
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound()
	{
		return StarWarsMod.MODID + ":" + "mob.protocol.die";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected String getHurtSound()
	{
		return StarWarsMod.MODID + ":" + "mob.protocol.hit";
	}

	@Override
	protected String getLivingSound()
	{
		return StarWarsMod.MODID + ":" + "mob.protocol.say";
	}

	@Override
	protected float getSoundPitch()
	{
		return 1.0F;
	}

	@Override
	public boolean interact(EntityPlayer par1EntityPlayer)
	{
		ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();

		if (itemstack == null)
		{
			itemstack = new ItemStack(Blocks.air);
		}

		if (isTamed())
		{
			if (par1EntityPlayer.getUniqueID().equals(getOwner().getUniqueID()) && !worldObj.isRemote && !isBreedingItem(itemstack))
			{
				aiSit.setSitting(!isSitting());
				par1EntityPlayer.addChatMessage(new ChatComponentText(EntityUtils.getDroidSittingMessage(!isSitting())));
				isJumping = false;
			}
		}
		else if (/* this.aiTempt.isRunning() && */itemstack != null && itemstack.getItem() == StarWarsMod.droidCaller && par1EntityPlayer.getDistanceSqToEntity(this) < 9.0D)
		{
			if (!worldObj.isRemote)
			{
				if (rand.nextInt(3) == 0)
				{
					setTamed(true);
					func_152115_b(par1EntityPlayer.getUniqueID().toString());
					playTameEffect(true);
					aiSit.setSitting(true);
					worldObj.setEntityState(this, (byte)7);
					par1EntityPlayer.addChatMessage(new ChatComponentText(EntityUtils.getDroidSittingMessage(!isSitting())));
				}
				else
				{
					playTameEffect(false);
					worldObj.setEntityState(this, (byte)6);
				}
			}

			return true;
		}

		return super.interact(par1EntityPlayer);
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		if (rand.nextInt(1000) == 0 && worldObj.findNearestEntityWithinAABB(MobDroidAstromech.class, boundingBox.expand(5, 5, 5), this) instanceof MobDroidAstromech)
		{
			playSound(StarWarsMod.MODID + ":" + "mob.protocol.r2d2rare", 1F, 1F);
		}
	}

	@Override
	public void updateAITick()
	{
		if (getMoveHelper().isUpdating())
		{
			double d0 = getMoveHelper().getSpeed();

			if (d0 == 0.6D)
			{
				setSneaking(true);
				setSprinting(false);
			}
			else if (d0 == 1.33D)
			{
				setSneaking(false);
				setSprinting(true);
			}
			else
			{
				setSneaking(false);
				setSprinting(false);
			}
		}
		else
		{
			setSneaking(false);
			setSprinting(false);
		}
	}
}