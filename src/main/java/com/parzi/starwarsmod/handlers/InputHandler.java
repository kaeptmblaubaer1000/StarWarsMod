package com.parzi.starwarsmod.handlers;

import net.minecraft.client.Minecraft;
import net.minecraft.util.MathHelper;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.network.CreateBlasterBolt;
import com.parzi.starwarsmod.utils.BlasterBoltType;
import com.parzi.starwarsmod.vehicles.VehicAWing;
import com.parzi.starwarsmod.vehicles.VehicHothSpeederBike;
import com.parzi.starwarsmod.vehicles.VehicSpeederBike;
import com.parzi.starwarsmod.vehicles.VehicTIE;
import com.parzi.starwarsmod.vehicles.VehicTIEInterceptor;
import com.parzi.starwarsmod.vehicles.VehicXWing;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class InputHandler
{
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onKeyInput(InputEvent.KeyInputEvent event)
	{
		Minecraft mc = Minecraft.getMinecraft();
		if (StarWarsMod.keyShootVehicle.isPressed() && mc.thePlayer.ridingEntity != null) if (mc.thePlayer.ridingEntity instanceof VehicSpeederBike || mc.thePlayer.ridingEntity instanceof VehicHothSpeederBike)
		{
			StarWarsMod.network.sendToServer(new CreateBlasterBolt(mc.thePlayer.getCommandSenderName(), mc.thePlayer.worldObj.provider.dimensionId, BlasterBoltType.SPEEDER));
			mc.thePlayer.playSound(StarWarsMod.MODID + ":" + "item.blasterRifle.use", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(mc.thePlayer.worldObj.rand, -0.2D, 0.2D));
		}
		else if (mc.thePlayer.ridingEntity instanceof VehicXWing || mc.thePlayer.ridingEntity instanceof VehicAWing)
		{
			StarWarsMod.network.sendToServer(new CreateBlasterBolt(mc.thePlayer.getCommandSenderName(), mc.thePlayer.worldObj.provider.dimensionId, BlasterBoltType.XWING));
			mc.thePlayer.playSound(StarWarsMod.MODID + ":" + "vehicle.xwing.fire", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(mc.thePlayer.worldObj.rand, -0.2D, 0.2D));
		}
		else if (mc.thePlayer.ridingEntity instanceof VehicTIE || mc.thePlayer.ridingEntity instanceof VehicTIEInterceptor)
		{
			StarWarsMod.network.sendToServer(new CreateBlasterBolt(mc.thePlayer.getCommandSenderName(), mc.thePlayer.worldObj.provider.dimensionId, BlasterBoltType.TIE));
			mc.thePlayer.playSound(StarWarsMod.MODID + ":" + "vehicle.tie.fire", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(mc.thePlayer.worldObj.rand, -0.2D, 0.2D));
		}
	}
}
