package com.parzivail.pswm.force.powers_old;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.items.weapons.ItemLightsaber;
import com.parzivail.pswm.network.MessageThrowSaber;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class PowerSaberThrow extends PowerBase
{
	public PowerSaberThrow(int currentLevel)
	{
		super("saberThrow");
		this.costBase = 1550;
		this.costMult = 50;
		this.currentLevel = currentLevel;
		this.maxLevel = 5;
		this.rechargeTime = 20; // 15 s
		this.recharge = 0;
	}

	@Override
	public boolean run(EntityPlayer player, Entity target)
	{
		if (this.recharge == 0 && player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemLightsaber && player.getHeldItem().stackTagCompound != null && player.getHeldItem().stackTagCompound.getBoolean(ItemLightsaber.nbtBladeOn))
		{
			StarWarsMod.network.sendToServer(new MessageThrowSaber(player, player.getHeldItem().copy()));

			return true;
		}
		return false;
	}
}
