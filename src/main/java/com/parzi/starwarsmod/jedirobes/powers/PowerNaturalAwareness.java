package com.parzi.starwarsmod.jedirobes.powers;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.network.PacketHealBlock;

public class PowerNaturalAwareness extends Power
{
	public PowerNaturalAwareness(int currentLevel)
	{
		super("naturalAwareness");
		this.costBase = 640;
		this.costMult = 0;
		this.currentLevel = currentLevel;
		this.maxLevel = 1;
		this.rechargeTime = 1;
		this.recharge = 0;
	}

	@Override
	public boolean run(EntityPlayer player)
	{
		if (this.recharge == 0)
		{
			MovingObjectPosition pos = Minecraft.getMinecraft().objectMouseOver;

			if (pos != null && pos.typeOfHit == MovingObjectType.BLOCK)
				StarWarsMod.network.sendToServer(new PacketHealBlock(player.dimension, pos.blockX, pos.blockY, pos.blockZ));

			return true;
		}
		return false;
	}
}
