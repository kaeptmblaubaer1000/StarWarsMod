package com.parzivail.pswm.registry;

import net.minecraft.util.DamageSource;

import com.parzivail.pswm.StarWarsMod;

public class DamageSourceRegister
{
	public static void registerAll()
	{
		StarWarsMod.blasterDamageSource = new DamageSource("blaster").setDamageBypassesArmor().setProjectile();
	}
}
