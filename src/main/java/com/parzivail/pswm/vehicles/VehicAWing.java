package com.parzivail.pswm.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.quest.QuestUtils;
import com.parzivail.util.vehicle.VehicleAirBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class VehicAWing extends VehicleAirBase
{
	public VehicAWing(World par1World)
	{
		super(par1World);
		this.setSize(3.0F, 5.0F);
		this.vehicYOffset = -3F;
		this.moveModifier = 2F;
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
		this.setHealth((float)this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue());
	}

	@Override
	public String getCommandSenderName()
	{
		if (this.hasCustomNameTag())
			return this.getCustomNameTag();
		return "RZ-1 A-Wing Interceptor";
	}

	@Override
	public String getDeathSound()
	{
		return Resources.MODID + ":" + "vehicle.xwing.die";
	}

	@Override
	public String getMovingSound()
	{
		return "vehicle.awing.move";
	}

	@Override
	public boolean interact(EntityPlayer player)
	{
		if (!QuestUtils.canRideInShip(player, this.getClass()))
			return false;
		if (player.isSneaking())
		{
			if (!worldObj.isRemote)
				player.openGui(StarWarsMod.instance, Resources.GUI_HYPERDRIVE, this.worldObj, 0, 0, 0);
			return true;
		}

		return super.interact(player);
	}
}
