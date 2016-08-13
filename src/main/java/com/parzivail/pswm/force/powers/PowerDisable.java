package com.parzivail.pswm.force.powers;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.network.MessageAddEffectTo;
import com.parzivail.pswm.utils.EntityCooldownEntry;
import com.parzivail.util.entity.EntityUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class PowerDisable extends PowerBase
{
	public PowerDisable(int currentLevel)
	{
		super("disable");
		this.costBase = 960;
		this.costMult = 60;
		this.currentLevel = currentLevel;
		this.maxLevel = 41;
		this.rechargeTime = 10 * 20; // 40 ticks/second
		this.recharge = 0;
	}

	@Override
	public boolean run(EntityPlayer player)
	{
		if (this.recharge == 0)
		{
			Entity e = EntityUtils.rayTrace(this.currentLevel * 2, player, new Entity[0]);

			if (e != null)
				StarWarsMod.network.sendToServer(new MessageAddEffectTo(new EntityCooldownEntry(e, "disable", this.currentLevel * 40)));

			return true;
		}
		return false;
	}
}
