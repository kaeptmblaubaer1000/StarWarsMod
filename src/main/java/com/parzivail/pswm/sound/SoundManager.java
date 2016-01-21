package com.parzivail.pswm.sound;

import net.minecraft.client.audio.MovingSound;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.vehicles.VehicAWing;
import com.parzivail.pswm.vehicles.VehicHothSpeederBike;
import com.parzivail.pswm.vehicles.VehicJakkuSpeeder;
import com.parzivail.pswm.vehicles.VehicLandspeeder;
import com.parzivail.pswm.vehicles.VehicSpeederBike;
import com.parzivail.pswm.vehicles.VehicTIE;
import com.parzivail.pswm.vehicles.VehicTIEInterceptor;
import com.parzivail.pswm.vehicles.VehicXWing;
import com.parzivail.util.sound.PSoundBank;
import com.parzivail.util.ui.GuiToast;
import com.parzivail.util.vehicle.VehicleBase;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SoundManager
{
	@SideOnly(Side.CLIENT)
	public static PSoundBank soundBank;

	public static MovingSound lightsaberHum;
	public static MovingSound shipMove;

	private static boolean wasInShip = false;
	private static boolean isInShip = false;

	public void init()
	{
		soundBank = new PSoundBank();
	}

	public void tick()
	{
		if (StarWarsMod.mc.theWorld == null || StarWarsMod.mc.thePlayer == null)
			return;

		isInShip = StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicleBase;

		if (isInShip && !wasInShip)
		{
			GuiToast.makeText("Sound Started", 60).show();
			String ship = "unknown";
			if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicAWing)
				ship = "awing";
			else if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicXWing)
				ship = "xwing";
			else if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicLandspeeder)
				ship = "landspeeder";
			else if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicSpeederBike || StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicHothSpeederBike || StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicJakkuSpeeder)
				ship = "speeder";
			else if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicTIE || StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicTIEInterceptor)
				ship = "tie";
			SoundManager.shipMove = new SoundShipMove(ship);
			soundBank.play(SoundManager.shipMove);
		}

		if (!isInShip && wasInShip)
		{
			GuiToast.makeText("Sound Stopped", 60).show();
			soundBank.stop(SoundManager.shipMove);
		}

		wasInShip = isInShip;
	}
}
