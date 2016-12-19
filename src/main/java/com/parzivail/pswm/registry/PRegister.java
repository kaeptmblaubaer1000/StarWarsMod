package com.parzivail.pswm.registry;

import com.parzivail.util.common.InitPhase;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by colby on 12/18/2016.
 */
public interface PRegister
{
	String getName();

	void registerAll();

	InitPhase getPhase();

	Side getSide();
}
