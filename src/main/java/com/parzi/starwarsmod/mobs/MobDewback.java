package com.parzi.starwarsmod.mobs;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;

public class MobDewback extends EntityHorse
{
	private int field_110285_bP = 0;

	public MobDewback(World par1World)
	{
		super(par1World);
		setSize(2, 2);
		tasks.addTask(3, new EntityAIWander(this, 0.1D));
		tasks.addTask(4, new EntityAILookIdle(this));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.1D);
	}

	@Override
	public boolean canMateWith(EntityAnimal p_70878_1_)
	{
		return false;
	}

	@Override
	protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
	{
		Block.SoundType soundtype = p_145780_4_.stepSound;

		if (worldObj.getBlock(p_145780_1_, p_145780_2_ + 1, p_145780_3_) == Blocks.snow_layer)
		{
			soundtype = Blocks.snow_layer.stepSound;
		}

		if (!p_145780_4_.getMaterial().isLiquid())
		{
			int l = getHorseType();

			if (riddenByEntity != null && l != 1 && l != 2)
			{
				++field_110285_bP;

				if (field_110285_bP > 5 && field_110285_bP % 3 == 0)
				{
					playSound("mob.horse.gallop", soundtype.getVolume() * 0.15F, soundtype.getPitch());
				}
				else if (field_110285_bP <= 5)
				{
					playSound("mob.horse.wood", soundtype.getVolume() * 0.15F, soundtype.getPitch());
				}
			}
			else if (soundtype == Block.soundTypeWood)
			{
				playSound("mob.horse.wood", soundtype.getVolume() * 0.15F, soundtype.getPitch());
			}
			else
			{
				playSound("mob.horse.soft", soundtype.getVolume() * 0.15F, soundtype.getPitch());
			}
		}
	}

	@Override
	public boolean getCanSpawnHere()
	{
		return true;
	}

	@Override
	public String getCommandSenderName()
	{
		if (hasCustomNameTag())
		{
			return getCustomNameTag();
		}
		else
		{
			if (isChested())
			{
				return "Pack-Dewback";
			}
			else
			{
				return "Dewback";
			}
		}
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound()
	{
		return StarWarsMod.MODID + ":" + "mob.dewback.die";
	}

	@Override
	protected Item getDropItem()
	{
		return null;
	}

	@Override
	public int getHorseType()
	{
		return 2;
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected String getHurtSound()
	{
		return StarWarsMod.MODID + ":" + "mob.dewback.hit";
	}

	@Override
	protected String getLivingSound()
	{
		return StarWarsMod.MODID + ":" + "mob.dewback.say";
	}

    protected String getAngrySoundName()
    {
        return StarWarsMod.MODID + ":" + "mob.dewback.say";
    }

	@Override
	public int getMaxSpawnedInChunk()
	{
		return 1;
	}

	@Override
	public boolean interact(EntityPlayer p_70085_1_)
	{
		ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();

		if (itemstack != null && itemstack.getItem() == Items.spawn_egg) { return false; }

		return super.interact(p_70085_1_);
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_)
	{
		Object p_110161_1_1 = super.onSpawnWithEgg(p_110161_1_);
		return (IEntityLivingData)p_110161_1_1;
	}

	@Override
	public void updateRiderPosition()
	{
		super.updateRiderPosition();

		float f = MathHelper.sin(renderYawOffset * (float)Math.PI / 180.0F);
		float f1 = MathHelper.cos(renderYawOffset * (float)Math.PI / 180.0F);
		float f2 = 0.5F;
		float f3 = 1F;
		riddenByEntity.setPosition(posX + f2 * f, posY + getMountedYOffset() + riddenByEntity.getYOffset() + f3 - 0.35F, posZ - f2 * f1);

		if (riddenByEntity instanceof EntityLivingBase)
		{
			((EntityLivingBase)riddenByEntity).renderYawOffset = renderYawOffset;
		}
	}
}