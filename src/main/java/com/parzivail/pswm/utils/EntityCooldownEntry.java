package com.parzivail.pswm.utils;

import net.minecraft.entity.Entity;

/**
 * Created by Colby on 6/18/2016.
 */
public class EntityCooldownEntry
{
	public int cooldownLeft;
	public int cooldown;
	public Entity entity;
	public String effect;

	public EntityCooldownEntry(Entity entity, String effect, int cooldown)
	{
		this.cooldownLeft = cooldown;
		this.cooldown = cooldown;
		this.entity = entity;
		this.effect = effect;
	}
}
