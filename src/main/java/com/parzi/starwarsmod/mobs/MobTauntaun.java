package com.parzi.starwarsmod.mobs;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;

public class MobTauntaun extends EntityHorse
{
	private int field_110285_bP = 0;

	public MobTauntaun(World par1World)
	{
		super(par1World);
		setSize(1F, 3F);
		tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		tasks.addTask(3, new EntityAIWander(this, 1.0D));
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
					playSound("mob.tauntaun.move", soundtype.getVolume() * 0.15F, soundtype.getPitch());
				}
				else if (field_110285_bP <= 5)
				{
					playSound("mob.tauntaun.move", soundtype.getVolume() * 0.15F, soundtype.getPitch());
				}
			}
			else if (soundtype == Block.soundTypeWood)
			{
				playSound("mob.tauntaun.move", soundtype.getVolume() * 0.15F, soundtype.getPitch());
			}
			else
			{
				playSound("mob.tauntaun.move", soundtype.getVolume() * 0.15F, soundtype.getPitch());
			}
		}
	}

	@Override
	protected String getAngrySoundName()
	{
		return StarWarsMod.MODID + ":" + "mob.tauntaun.hit";
	}

	@Override
	public boolean getCanSpawnHere()
	{
		return worldObj.difficultySetting != EnumDifficulty.PEACEFUL && isValidLightLevel() && rand.nextInt(20) == 0;
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
				return "Pack-Tauntaun";
			}
			else
			{
				return "Tauntaun";
			}
		}
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound()
	{
		return StarWarsMod.MODID + ":" + "mob.tauntaun.die";
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
		return StarWarsMod.MODID + ":" + "mob.tauntaun.hit";
	}

	@Override
	protected String getLivingSound()
	{
		return StarWarsMod.MODID + ":" + "mob.tauntaun.say";
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

	protected boolean isValidLightLevel()
	{
		int i = MathHelper.floor_double(posX);
		int j = MathHelper.floor_double(boundingBox.minY);
		int k = MathHelper.floor_double(posZ);

		return worldObj.getSavedLightValue(EnumSkyBlock.Sky, i, j, k) > 11;
	}

	@Override
	public void updateRiderPosition()
	{
		if (riddenByEntity != null)
		{
			riddenByEntity.setPosition(posX, posY + getMountedYOffset() + riddenByEntity.getYOffset() - 0.1F, posZ);
		}
	}
}