package com.parzivail.pswm.mobs;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.ai.AiFreqMove;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class MobEwok extends EntityAnimal implements IAnimals
{
	private DataWatcher dw;

	public MobEwok(World par1World)
	{
		super(par1World);
		setSize(0.5F, 1.5F);
		dw = super.getDataWatcher();
		tasks.addTask(0, new AiFreqMove(this, 1, 0));
		setCurrentItemOrArmor(0, new net.minecraft.item.ItemStack(StarWarsMod.ewokSpear, 1));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(5.0D);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.55D);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_)
	{
		return null;
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		getDataWatcher().addObject(25, Integer.valueOf(rand.nextInt(3)));
	}

	protected Item func_146068_u()
	{
		switch (rand.nextInt(60))
		{
			case 36:
				dropItem(StarWarsMod.ewokSpear, 1);
		}
		return Item.getItemFromBlock(net.minecraft.init.Blocks.leaves);
	}

	@Override
	protected String getDeathSound()
	{
		return Resources.MODID + ":" + "mob.ewok.die";
	}

	@Override
	protected String getHurtSound()
	{
		return Resources.MODID + ":" + "mob.ewok.hit";
	}

	@Override
	protected String getLivingSound()
	{
		return Resources.MODID + ":" + "mob.ewok.say";
	}

	private int getType()
	{
		return getDataWatcher().getWatchableObjectInt(25);
	}
}
