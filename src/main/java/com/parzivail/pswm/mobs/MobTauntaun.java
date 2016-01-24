package com.parzivail.pswm.mobs;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.parzivail.pswm.Resources;

public class MobTauntaun extends EntityHorse
{
	private int field_110285_bP = 0;

	public MobTauntaun(World par1World)
	{
		super(par1World);
		this.setSize(1.0F, 3.0F);
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(4, new net.minecraft.entity.ai.EntityAILookIdle(this));
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
					this.playSound("mob.tauntaun.move", soundtype.getVolume() * 0.15F, soundtype.getPitch());
				else if (this.field_110285_bP <= 5)
					this.playSound("mob.tauntaun.move", soundtype.getVolume() * 0.15F, soundtype.getPitch());
			}
			else if (soundtype == Block.soundTypeWood)
				this.playSound("mob.tauntaun.move", soundtype.getVolume() * 0.15F, soundtype.getPitch());
			else
				this.playSound("mob.tauntaun.move", soundtype.getVolume() * 0.15F, soundtype.getPitch());
		}
	}

	@Override
	protected String getAngrySoundName()
	{
		return Resources.MODID + ":" + "mob.tauntaun.hit";
	}

	@Override
	public boolean getCanSpawnHere()
	{
		return this.worldObj.difficultySetting != net.minecraft.world.EnumDifficulty.PEACEFUL && this.isValidLightLevel() && this.rand.nextInt(20) == 0;
	}

	@Override
	public String getCommandSenderName()
	{
		if (this.hasCustomNameTag())
			return this.getCustomNameTag();
		if (this.isChested())
			return "Pack-Tauntaun";
		return "Tauntaun";
	}

	@Override
	protected String getDeathSound()
	{
		return Resources.MODID + ":" + "mob.tauntaun.die";
	}

	@Override
	public int getHorseType()
	{
		return 2;
	}

	@Override
	protected String getHurtSound()
	{
		return Resources.MODID + ":" + "mob.tauntaun.hit";
	}

	@Override
	protected String getLivingSound()
	{
		return Resources.MODID + ":" + "mob.tauntaun.say";
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

	protected boolean isValidLightLevel()
	{
		int i = MathHelper.floor_double(this.posX);
		int j = MathHelper.floor_double(this.boundingBox.minY);
		int k = MathHelper.floor_double(this.posZ);
		return this.worldObj.getSavedLightValue(net.minecraft.world.EnumSkyBlock.Sky, i, j, k) > 11;
	}

	@Override
	public void updateRiderPosition()
	{
		if (this.riddenByEntity != null)
			this.riddenByEntity.setPosition(this.posX, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset() - 0.10000000149011612D, this.posZ);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\mobs\MobTauntaun.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */