package com.parzivail.pswm.proxy;

import com.parzivail.pswm.registry.PRegister;
import com.parzivail.util.common.InitPhase;
import com.parzivail.util.common.Lumberjack;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by colby on 12/18/2016.
 */
public class ClientProxy extends CommonProxy
{
	public void preinit(Side side)
	{
		super.preinit(Side.SERVER);
		for (PRegister register : regfilter.filter(o -> o.getPhase() == InitPhase.PRE && o.getSide() == Side.CLIENT))
		{
			Lumberjack.log("REGISTER: %s@%s", register.getName(), side);
			register.registerAll();
		}
	}
}
