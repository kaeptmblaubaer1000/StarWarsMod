package com.parzivail.pswm.force.powers;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.network.MessageDrainKnowledge;
import com.parzivail.util.entity.EntityUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class PowerDrainKnowledge extends PowerBase
{
	public PowerDrainKnowledge(int currentLevel)
	{
		super("drainKnowledge");
		this.costBase = 0;
		this.costMult = 0;
		this.currentLevel = currentLevel;
		this.maxLevel = -1;
		this.rechargeTime = 60 * 40; // 40 ticks/second
		this.recharge = 0;
	}

	@Override
	public boolean run(EntityPlayer player)
	{
		if (this.recharge == 0)
		{
			Entity e = EntityUtils.rayTrace(this.currentLevel * 2, player, new Entity[0]);

			if (e != null)
				StarWarsMod.network.sendToServer(new MessageDrainKnowledge(e, 400 + (this.currentLevel * 400)));

			return true;
		}
		return false;
	}
}
