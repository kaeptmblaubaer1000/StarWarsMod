package com.parzivail.pswm.mobs.trooper;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MobDefaultBiped extends EntityLiving
{
	public MobDefaultBiped(World par1World)
	{
		super(par1World);
		setSize(0.5F, 1.5F);
		this.tasks.addTask(0, new EntityAIWatchClosest(this, EntityPlayer.class, 10, 0));
	}
}