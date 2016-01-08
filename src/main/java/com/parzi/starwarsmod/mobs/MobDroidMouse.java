package com.parzi.starwarsmod.mobs;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.ai.AiFreqMove;
import com.parzi.util.entity.EntityUtils;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class MobDroidMouse extends EntityTameable
{
	private EntityAITempt aiTempt;

	public MobDroidMouse(World par1World)
	{
		super(par1World);
		this.setSize(0.5F, 0.5F);
		this.tasks.addTask(2, this.aiSit);
		this.tasks.addTask(3, this.aiTempt = new EntityAITempt(this, 0.6D, StarWarsMod.droidCaller, true));
		this.tasks.addTask(4, new com.parzi.starwarsmod.ai.AiMouseScare(this, MobWookiee.class, 16.0F, 0.8D, 1.33D));
		this.tasks.addTask(5, new net.minecraft.entity.ai.EntityAIFollowOwner(this, 1.0D, 10.0F, 5.0F));
		this.tasks.addTask(6, new EntityAIMate(this, 0.8D));
		this.tasks.addTask(7, new AiFreqMove(this, 1.5D, 12));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(0.5D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.255D);
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
	public void dropFewItems(boolean par1, int par2)
	{
		this.dropItem(StarWarsMod.spawnMouse, 1);
	}

	@Override
	protected void dropRareDrop(int par1)
	{
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(18, Byte.valueOf((byte)0));
	}

	@Override
	protected void fall(float par1)
	{
	}

	@Override
	public boolean getCanSpawnHere()
	{
		return true;
	}

	@Override
	protected String getDeathSound()
	{
		return Resources.MODID + ":" + "mob.mouse.die";
	}

	@Override
	protected String getHurtSound()
	{
		return Resources.MODID + ":" + "mob.mouse.hit";
	}

	@Override
	protected String getLivingSound()
	{
		return Resources.MODID + ":" + "mob.mouse.say";
	}

	@Override
	public boolean interact(EntityPlayer par1EntityPlayer)
	{
		ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
		if (itemstack == null)
			itemstack = new ItemStack(net.minecraft.init.Blocks.air);
		if (this.isTamed())
		{
			if (par1EntityPlayer.getUniqueID().equals(this.getOwner().getUniqueID()) && !this.worldObj.isRemote && !this.isBreedingItem(itemstack) && itemstack.getItem() == StarWarsMod.droidCaller)
			{
				this.aiSit.setSitting(!this.isSitting());
				par1EntityPlayer.addChatMessage(new ChatComponentText(EntityUtils.getDroidSittingMessage(!this.isSitting())));
				this.isJumping = false;
			}
		}
		else if (itemstack != null && itemstack.getItem() == StarWarsMod.droidCaller && par1EntityPlayer.getDistanceSqToEntity(this) < 9.0D)
		{
			if (!this.worldObj.isRemote)
				if (this.rand.nextInt(3) == 0)
				{
					this.setTamed(true);
					this.func_152115_b(par1EntityPlayer.getUniqueID().toString());
					this.playTameEffect(true);
					this.aiSit.setSitting(true);
					this.worldObj.setEntityState(this, (byte)7);
					par1EntityPlayer.addChatMessage(new ChatComponentText(EntityUtils.getDroidSittingMessage(!this.isSitting())));
				}
				else
				{
					this.playTameEffect(false);
					this.worldObj.setEntityState(this, (byte)6);
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
	public void updateAITick()
	{
		if (this.getMoveHelper().isUpdating())
		{
			double d0 = this.getMoveHelper().getSpeed();
			if (d0 == 0.6D)
			{
				this.setSneaking(true);
				this.setSprinting(false);
			}
			else if (d0 == 1.33D)
			{
				this.setSneaking(false);
				this.setSprinting(true);
			}
			else
			{
				this.setSneaking(false);
				this.setSprinting(false);
			}
		}
		else
		{
			this.setSneaking(false);
			this.setSprinting(false);
		}
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\mobs\MobDroidMouse.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */