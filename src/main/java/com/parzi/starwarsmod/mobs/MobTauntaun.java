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
		this.setSize(1F, 3F);
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(4, new EntityAILookIdle(this));
	}

	@Override
	public int getMaxSpawnedInChunk()
	{
		return 1;
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.1D);
	}

	@Override
	public void updateRiderPosition()
	{
		if (this.riddenByEntity != null)
		{
			this.riddenByEntity.setPosition(this.posX, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset() - 0.1F, this.posZ);
		}
	}

	@Override
	public boolean interact(EntityPlayer p_70085_1_)
	{
		ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();

		if (itemstack != null && itemstack.getItem() == Items.spawn_egg) { return false; }

		return super.interact(p_70085_1_);
	}

	@Override
	protected String getLivingSound()
	{
		return StarWarsMod.MODID + ":" + "mob.tauntaun.say";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected String getHurtSound()
	{
		return StarWarsMod.MODID + ":" + "mob.tauntaun.hit";
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
	public boolean getCanSpawnHere()
	{
		return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.isValidLightLevel() && this.rand.nextInt(20) == 0;
	}

	protected boolean isValidLightLevel()
	{
		int i = MathHelper.floor_double(this.posX);
		int j = MathHelper.floor_double(this.boundingBox.minY);
		int k = MathHelper.floor_double(this.posZ);

		return (this.worldObj.getSavedLightValue(EnumSkyBlock.Sky, i, j, k) > 11);
	}

	@Override
	public boolean canMateWith(EntityAnimal p_70878_1_)
	{
		return false;
	}

	@Override
	protected String getAngrySoundName()
	{
		return StarWarsMod.MODID + ":" + "mob.tauntaun.hit";
	}

	@Override
	public int getHorseType()
	{
		return 2;
	}

	@Override
	public String getCommandSenderName()
	{
		if (this.hasCustomNameTag())
		{
			return this.getCustomNameTag();
		}
		else
		{
			if (this.isChested())
			{
				return "Pack-Tauntaun";
			}
			else
			{
				return "Tauntaun";
			}
		}
	}

	@Override
	protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
	{
		Block.SoundType soundtype = p_145780_4_.stepSound;

		if (this.worldObj.getBlock(p_145780_1_, p_145780_2_ + 1, p_145780_3_) == Blocks.snow_layer)
		{
			soundtype = Blocks.snow_layer.stepSound;
		}

		if (!p_145780_4_.getMaterial().isLiquid())
		{
			int l = this.getHorseType();

			if (this.riddenByEntity != null && l != 1 && l != 2)
			{
				++this.field_110285_bP;

				if (this.field_110285_bP > 5 && this.field_110285_bP % 3 == 0)
				{
					this.playSound("mob.horse.gallop", soundtype.getVolume() * 0.15F, soundtype.getPitch());
				}
				else if (this.field_110285_bP <= 5)
				{
					this.playSound("mob.horse.wood", soundtype.getVolume() * 0.15F, soundtype.getPitch());
				}
			}
			else if (soundtype == Block.soundTypeWood)
			{
				this.playSound("mob.horse.wood", soundtype.getVolume() * 0.15F, soundtype.getPitch());
			}
			else
			{
				this.playSound("mob.horse.soft", soundtype.getVolume() * 0.15F, soundtype.getPitch());
			}
		}
	}
}