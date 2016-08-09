package com.parzivail.pswm.mobs.trooper;

import com.parzivail.pswm.mobs.MobDroidAstromech;
import com.parzivail.pswm.mobs.MobDroidProtocol;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.passive.EntityTameable;
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
