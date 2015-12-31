package com.parzi.starwarsmod.jedirobes.powers;

import com.parzi.starwarsmod.utils.PotionList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;

public class PowerJump extends Power
{
	public PowerJump(int currentLevel)
	{
		super("jump");
		this.baseCost = 25;
		this.costMult = 25;
		this.currentLevel = currentLevel;
		this.maxLevel = 5;
		this.rechargeTime = 3;
	}

	@Override
	public boolean run(EntityPlayer player)
	{
		PotionEffect effect = new PotionEffect(PotionList.JUMP_BOOST, 20 * this.currentLevel, this.currentLevel, true);

		if (player.isPotionActive(effect.getPotionID()))
			return false;

		player.addPotionEffect(effect);
		return true;
	}
}
