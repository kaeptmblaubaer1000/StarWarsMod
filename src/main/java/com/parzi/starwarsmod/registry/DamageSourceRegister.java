package com.parzi.starwarsmod.registry;

import com.parzi.starwarsmod.StarWarsMod;

import net.minecraft.util.DamageSource;

public class DamageSourceRegister
{
	public static void registerAll()
	{
		StarWarsMod.blasterDamageSource = (new DamageSource("blaster")).setDamageBypassesArmor().setProjectile();
	}
}
