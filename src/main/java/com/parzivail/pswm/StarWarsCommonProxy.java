package com.parzivail.pswm;

import com.parzivail.pswm.Resources.ConfigOptions;
import com.parzivail.util.ui.Lumberjack;

public class StarWarsCommonProxy
{
	public void doSidedThings()
	{
		Lumberjack.log("Server proxy loaded!");

		if (ConfigOptions.enableBetaFeatures)
		{
			Resources.IS_DEV_ENVIRONVENT = true;
			Lumberjack.info("Debug/Beta mechanics implemented!");
		}
	}

	public void registerRendering()
	{
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\StarWarsCommonProxy.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */