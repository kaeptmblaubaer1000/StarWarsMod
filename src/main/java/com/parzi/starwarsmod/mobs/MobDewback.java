package com.parzi.starwarsmod.mobs;

import com.parzi.starwarsmod.Resources;

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
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class MobDewback extends EntityHorse
{
	private int field_110285_bP = 0;

	public MobDewback(World par1World)
	{
		super(par1World);
		this.setSize(2.0F, 2.0F);
		this.tasks.addTask(3, new EntityAIWander(this, 0.1D));
		this.tasks.addTask(4, new EntityAILookIdle(this));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.1D);
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
		if (this.worldObj.getBlock(p_145780_1_, p_145780_2_ + 1, p_145780_3_) == Blocks.snow_layer)
			soundtype = Blocks.snow_layer.stepSound;
		if (!p_145780_4_.getMaterial().isLiquid())
		{
			int l = this.getHorseType();
			if (this.riddenByEntity != null && l != 1 && l != 2)
			{
				this.field_110285_bP += 1;
				if (this.field_110285_bP > 5 && this.field_110285_bP % 3 == 0)
					this.playSound("mob.horse.gallop", soundtype.getVolume() * 0.15F, soundtype.getPitch());
				else if (this.field_110285_bP <= 5)
					this.playSound("mob.horse.wood", soundtype.getVolume() * 0.15F, soundtype.getPitch());
			}
			else if (soundtype == Block.soundTypeWood)
				this.playSound("mob.horse.wood", soundtype.getVolume() * 0.15F, soundtype.getPitch());
			else
				this.playSound("mob.horse.soft", soundtype.getVolume() * 0.15F, soundtype.getPitch());
		}
	}

	protected net.minecraft.item.Item func_146068_u()
	{
		return null;
	}

	@Override
	protected String getAngrySoundName()
	{
		return Resources.MODID + ":" + "mob.dewback.say";
	}

	@Override
	public boolean getCanSpawnHere()
	{
		return true;
	}

	@Override
	public String getCommandSenderName()
	{
		if (this.hasCustomNameTag())
			return this.getCustomNameTag();
		if (this.isChested())
			return "Pack-Dewback";
		return "Dewback";
	}

	@Override
	protected String getDeathSound()
	{
		return Resources.MODID + ":" + "mob.dewback.die";
	}

	@Override
	public int getHorseType()
	{
		return 2;
	}

	@Override
	protected String getHurtSound()
	{
		return Resources.MODID + ":" + "mob.dewback.hit";
	}

	@Override
	protected String getLivingSound()
	{
		return Resources.MODID + ":" + "mob.dewback.say";
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
		if (itemstack != null && itemstack.getItem() == net.minecraft.init.Items.spawn_egg)
			return false;
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
		float f = MathHelper.sin(this.renderYawOffset * 3.1415927F / 180.0F);
		float f1 = MathHelper.cos(this.renderYawOffset * 3.1415927F / 180.0F);
		float f2 = 0.5F;
		float f3 = 1.0F;
		this.riddenByEntity.setPosition(this.posX + f2 * f, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset() + f3 - 0.3499999940395355D, this.posZ - f2 * f1);
		if (this.riddenByEntity instanceof EntityLivingBase)
			((EntityLivingBase)this.riddenByEntity).renderYawOffset = this.renderYawOffset;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\mobs\MobDewback.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */