package com.parzivail.pswm.force.powers_old;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.network.MessageAddEffectTo;
import com.parzivail.pswm.utils.EntityCooldownEntry;
import com.parzivail.util.entity.EntityUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class PowerSlow extends PowerBase
{
	public PowerSlow(int currentLevel)
	{
		super("slow");
		this.costBase = 2700;
		this.costMult = 75;
		this.currentLevel = currentLevel;
		this.maxLevel = 5;
		this.rechargeTime = 15 * 20; // 40 ticks/second
		this.recharge = 0;
	}

	@Override
	public boolean run(EntityPlayer player, Entity target)
	{
		if (this.recharge == 0)
		{
			Entity e = EntityUtils.rayTrace(this.currentLevel * 2, player, new Entity[0]);

			if (e != null)
				StarWarsMod.network.sendToServer(new MessageAddEffectTo(new EntityCooldownEntry(e, "slow", this.currentLevel * 40)));

			return true;
		}
		return false;
	}
}
