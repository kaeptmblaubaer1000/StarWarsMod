package com.parzivail.pswm.mobs.trooper;

import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.UUID;

import static com.parzivail.pswm.Resources.MODID;
import static com.parzivail.pswm.StarWarsItems.*;
import static java.util.UUID.fromString;

public class MobBountyhunter extends MobTrooper
{
	private static final UUID field_110189_bq = fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
	private EntityAIArrowAttack aiArrow;

	public MobBountyhunter(World par1World)
	{
		super(par1World);
		setCurrentItemOrArmor(4, new ItemStack(bobaHelmet, 1));
		setCurrentItemOrArmor(2, new ItemStack(bobaLegs, 1));
		setCurrentItemOrArmor(1, new ItemStack(bobaBoots, 1));
		switch (rand.nextInt(2))
		{
			case 0:
				setCurrentItemOrArmor(3, new ItemStack(bobaChest, 1));
				break;
			case 1:
				setCurrentItemOrArmor(3, new ItemStack(bobaJetpackChest, 1));
				break;
		}
	}

	@Override
	public boolean getCanSpawnHere()
	{
		return rand.nextInt(20) == 0;
	}

	@Override
	protected String getDeathSound()
	{
		return MODID + ":" + "mob.bountyhunter.die";
	}

	@Override
	protected String getHurtSound()
	{
		return MODID + ":" + "mob.bountyhunter.hit";
	}

	@Override
	protected String getLivingSound()
	{
		return MODID + ":" + "mob.bountyhunter.say";
	}
}
