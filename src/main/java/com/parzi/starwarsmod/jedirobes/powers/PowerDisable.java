package com.parzi.starwarsmod.jedirobes.powers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.network.MessageAddEffectTo;
import com.parzi.starwarsmod.utils.ForceUtils.EntityCooldownEntry;
import com.parzi.util.entity.EntityUtils;
import com.parzi.util.ui.GuiToast;

public class PowerDisable extends Power
{
	public PowerDisable(int currentLevel)
	{
		super("disable");
		this.costBase = 960;
		this.costMult = 60;
		this.currentLevel = currentLevel;
		this.maxLevel = 41;
		this.rechargeTime = 3;
		this.recharge = 0;
	}

	@Override
	public boolean run(EntityPlayer player)
	{
		if (this.recharge == 0)
		{
			Entity e = EntityUtils.rayTrace(this.currentLevel * 2, player, new Entity[0]);

			if (e != null)
			{
				StarWarsMod.network.sendToServer(new MessageAddEffectTo(new EntityCooldownEntry(e, "disable", this.currentLevel * 40)));
				GuiToast.makeText(e, 40).show();
			}

			return true;
		}
		return false;
	}
}
