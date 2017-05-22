package com.parzivail.pswm.force;

import net.minecraft.entity.player.EntityPlayer;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Created by colby on 5/19/2017.
 */
public interface IForcePower
{
	@Nonnull
	List<ForcePowerAttribute> getAttributes();

	void use(EntityPlayer player);
}
