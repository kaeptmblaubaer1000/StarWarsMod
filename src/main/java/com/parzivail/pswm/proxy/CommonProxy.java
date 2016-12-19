package com.parzivail.pswm.proxy;

import com.parzivail.pswm.registry.PRegister;
import com.parzivail.pswm.registry.RegistryBlock;
import com.parzivail.pswm.registry.RegistryModel;
import com.parzivail.util.common.Filter;
import com.parzivail.util.common.InitPhase;
import com.parzivail.util.common.Lumberjack;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by colby on 12/18/2016.
 */
public class CommonProxy
{
	protected final PRegister[] registers = new PRegister[] { new RegistryBlock(), new RegistryModel() };
	protected final Filter<PRegister> regfilter = new Filter<>(registers);

	public void preinit(Side side)
	{
		for (PRegister register : regfilter.filter(o -> o.getPhase() == InitPhase.PRE && o.getSide() == Side.SERVER))
		{
			Lumberjack.log("REGISTER: %s@%s", register.getName(), side);
			register.registerAll();
		}
	}
}
