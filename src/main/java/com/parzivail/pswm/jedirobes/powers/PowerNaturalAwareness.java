package com.parzivail.pswm.jedirobes.powers;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.network.MessageTransmute;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;

public class PowerNaturalAwareness extends Power
{
	public PowerNaturalAwareness(int currentLevel)
	{
		super("naturalAwareness");
		this.costBase = 640;
		this.costMult = 0;
		this.currentLevel = currentLevel;
		this.maxLevel = 1;
		this.rechargeTime = 1; // 40 ticks/second
		this.recharge = 0;
	}

	@Override
	public boolean run(EntityPlayer player)
	{
		if (this.recharge == 0)
		{
			MovingObjectPosition pos = Minecraft.getMinecraft().objectMouseOver;

			if (pos != null && pos.typeOfHit == MovingObjectType.BLOCK)
				StarWarsMod.network.sendToServer(new MessageTransmute(player.dimension, this.currentLevel, pos.blockX, pos.blockY, pos.blockZ));

			return true;
		}
		return false;
	}
}
