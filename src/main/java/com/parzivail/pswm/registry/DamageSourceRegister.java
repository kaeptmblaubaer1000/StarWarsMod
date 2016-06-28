package com.parzivail.pswm.registry;

import com.parzivail.pswm.StarWarsMod;
import net.minecraft.util.DamageSource;

public class DamageSourceRegister
{
	public static void registerAll()
	{
		StarWarsMod.blasterDamageSource = new DamageSource("blaster").setDamageBypassesArmor().setProjectile();
		StarWarsMod.saberDamageSource = new DamageSource("saber").setDamageBypassesArmor();
		StarWarsMod.roadkillDamageSource = new DamageSource("runOver");
	}
}
