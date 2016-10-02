package com.parzivail.pswm.handlers;

/**
 * Created by colby on 10/2/2016.
 */

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.vehicle.StarshipBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.MouseHelper;
import org.lwjgl.input.Mouse;

@SideOnly(Side.CLIENT)
public class PMouseHandler extends MouseHelper
{
	@Override
	public void mouseXYChange()
	{
		if (StarWarsMod.mc.thePlayer != null && StarWarsMod.mc.thePlayer.ridingEntity instanceof StarshipBase) return;

		this.deltaX = Mouse.getDX();
		this.deltaY = Mouse.getDY();
	}
}