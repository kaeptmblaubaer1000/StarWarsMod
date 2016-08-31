package com.parzivail.pswm.registry;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.ui.Lumberjack;
import net.minecraft.util.DamageSource;

public class DamageSourceRegister
{
	public static void registerAll()
	{
		StarWarsMod.blasterDamageSource = new DamageSource("blaster").setDamageBypassesArmor().setProjectile();
		StarWarsMod.saberDamageSource = new DamageSource("saber").setDamageBypassesArmor();
		StarWarsMod.roadkillDamageSource = new DamageSource("runOver");
		StarWarsMod.meleeDamageSource = new DamageSource("melee");
		Lumberjack.info("Damage Sources, reporting for duty!");
	}
}
