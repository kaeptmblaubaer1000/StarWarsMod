package com.parzivail.pswm.force;

import net.minecraft.entity.player.EntityPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by colby on 5/19/2017.
 */
public class ForcePowerEmpty implements IForcePower
{
	public static final ArrayList<ForcePowerAttribute> ATTRIBUTES = new ArrayList<>();

	static
	{
		ATTRIBUTES.add(ForcePowerAttribute.Unusable);
		ATTRIBUTES.add(ForcePowerAttribute.Jedi);
		ATTRIBUTES.add(ForcePowerAttribute.Sith);
	}

	@Override
	public List<ForcePowerAttribute> getAttributes()
	{
		return ATTRIBUTES;
	}

	@Override
	public void use(EntityPlayer player)
	{

	}
}
