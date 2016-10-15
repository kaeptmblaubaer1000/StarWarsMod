package com.parzivail.pswm;

import com.parzivail.pswm.Resources.ConfigOptions;
import com.parzivail.util.ui.Lumberjack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;

public class StarWarsCommonProxy
{
	public void doSidedThings()
	{
		Lumberjack.log("Server proxy loaded!");

		if (ConfigOptions.enableBetaFeatures)
		{
			Resources.IS_DEV_ENVIRONMENT = true;
			Lumberjack.info("Debug/Beta mechanics implemented!");
		}
	}

	public void registerRendering()
	{
	}

	public void showJediSithGui(PlayerPickupXpEvent event)
	{
	}

	public boolean isThePlayer(EntityPlayer entity)
	{
		return false;
	}
}
