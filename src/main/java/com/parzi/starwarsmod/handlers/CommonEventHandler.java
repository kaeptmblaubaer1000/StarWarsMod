package com.parzi.starwarsmod.handlers;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;

import com.parzi.starwarsmod.StarWarsEnum;
import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.jedirobes.ArmorJediRobes;
import com.parzi.starwarsmod.jedirobes.powers.Power;
import com.parzi.starwarsmod.network.PacketCreateBlasterBolt;
import com.parzi.starwarsmod.network.PacketRobesNBT;
import com.parzi.starwarsmod.sound.SoundLightsaberHum;
import com.parzi.starwarsmod.sound.SoundSFoil;
import com.parzi.starwarsmod.utils.BlasterBoltType;
import com.parzi.starwarsmod.utils.ForceUtils;
import com.parzi.starwarsmod.vehicles.VehicAWing;
import com.parzi.starwarsmod.vehicles.VehicHothSpeederBike;
import com.parzi.starwarsmod.vehicles.VehicSpeederBike;
import com.parzi.starwarsmod.vehicles.VehicTIE;
import com.parzi.starwarsmod.vehicles.VehicTIEInterceptor;
import com.parzi.starwarsmod.vehicles.VehicXWing;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CommonEventHandler
{
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onKeyInput(InputEvent.KeyInputEvent event)
	{
		Minecraft mc = Minecraft.getMinecraft();
		if (StarWarsMod.keyShootVehicle.isPressed() && mc.thePlayer.ridingEntity != null)
			if (mc.thePlayer.ridingEntity instanceof VehicSpeederBike || mc.thePlayer.ridingEntity instanceof VehicHothSpeederBike)
			{
				StarWarsMod.network.sendToServer(new PacketCreateBlasterBolt(mc.thePlayer.getCommandSenderName(), mc.thePlayer.worldObj.provider.dimensionId, BlasterBoltType.SPEEDER));
				mc.thePlayer.playSound(StarWarsMod.MODID + ":" + "item.blasterRifle.use", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(mc.thePlayer.worldObj.rand, -0.2D, 0.2D));
			}
			else if (mc.thePlayer.ridingEntity instanceof VehicXWing || mc.thePlayer.ridingEntity instanceof VehicAWing)
			{
				StarWarsMod.network.sendToServer(new PacketCreateBlasterBolt(mc.thePlayer.getCommandSenderName(), mc.thePlayer.worldObj.provider.dimensionId, BlasterBoltType.XWING));
				mc.thePlayer.playSound(StarWarsMod.MODID + ":" + "vehicle.xwing.fire", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(mc.thePlayer.worldObj.rand, -0.2D, 0.2D));
				ClientEventHandler.isFiring = true;
				ClientEventHandler.blipFrame = ClientEventHandler.blipMax;
			}
			else if (mc.thePlayer.ridingEntity instanceof VehicTIE || mc.thePlayer.ridingEntity instanceof VehicTIEInterceptor)
			{
				StarWarsMod.network.sendToServer(new PacketCreateBlasterBolt(mc.thePlayer.getCommandSenderName(), mc.thePlayer.worldObj.provider.dimensionId, BlasterBoltType.TIE));
				mc.thePlayer.playSound(StarWarsMod.MODID + ":" + "vehicle.tie.fire", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(mc.thePlayer.worldObj.rand, -0.2D, 0.2D));
			}

		if (StarWarsMod.keySFoil.isPressed())
			if (mc.thePlayer.ridingEntity instanceof VehicXWing)
			{
				VehicXWing xwing = (VehicXWing)mc.thePlayer.ridingEntity;
				if (xwing.getSFoil() <= 0)
				{
					xwing.isOpening = true;
					Minecraft.getMinecraft().getSoundHandler().playSound(new SoundSFoil(mc.thePlayer, true));
				}
				if (xwing.getSFoil() >= 0.8f)
				{
					xwing.isClosing = true;
					Minecraft.getMinecraft().getSoundHandler().playSound(new SoundSFoil(mc.thePlayer, false));
				}
			}

		if (StarWarsMod.keyRobeGui.isPressed())
			mc.thePlayer.openGui(StarWarsMod.instance, StarWarsEnum.GUI_ROBES, null, 0, 0, 0);

		if (StarWarsMod.keyRobePower.isPressed())
		{
			if (mc.thePlayer.inventory.armorItemInSlot(2) != null && mc.thePlayer.inventory.armorItemInSlot(2).getItem() == StarWarsMod.jediRobes)
			{
				ItemStack stack = mc.thePlayer.inventory.armorItemInSlot(2);
				Power active = ForceUtils.activePower;

				if (active != null && ArmorJediRobes.getLevelOf(stack, active.name) > 0)
				{
					active.currentLevel = ArmorJediRobes.getLevelOf(stack, active.name);
					if (ArmorJediRobes.getXP(stack) - active.getCost() >= 0 && !ForceUtils.coolingPowers.contains(active))
					{
						StarWarsMod.network.sendToServer(new PacketRobesNBT("xp", ArmorJediRobes.getXP(stack) - active.getCost(), mc.thePlayer.dimension, mc.thePlayer.getCommandSenderName()));
						active.run(mc.thePlayer);
						active.recharge = active.rechargeTime;
						ForceUtils.coolingPowers.add(active);
					}
				}
			}
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onTick(TickEvent.ClientTickEvent event)
	{
		Minecraft mc = Minecraft.getMinecraft();

		if (mc.theWorld == null || mc.thePlayer == null)
			return;

		Item i = mc.thePlayer.inventory.getCurrentItem() == null ? null : mc.thePlayer.inventory.getCurrentItem().getItem();
		if (i != ClientEventHandler.lastItem && (i == StarWarsMod.lightsaber || i == StarWarsMod.sequelLightsaber))
		{
			Minecraft.getMinecraft().getSoundHandler().playSound(new SoundLightsaberHum(mc.thePlayer));
		}
		ClientEventHandler.lastItem = i;

		if (ClientEventHandler.lastTime <= System.currentTimeMillis())
		{
			ClientEventHandler.lastTime = System.currentTimeMillis() + 1000;

			ForceUtils.queueToRemove.clear();
			for (Power cooling : ForceUtils.coolingPowers)
			{
				cooling.recharge--;
				if (cooling.recharge <= 0)
					ForceUtils.queueToRemove.add(cooling);
			}

			for (Power remove : ForceUtils.queueToRemove)
				ForceUtils.coolingPowers.remove(remove);

			if (mc.thePlayer.inventory.armorItemInSlot(2) != null && mc.thePlayer.inventory.armorItemInSlot(2).getItem() == StarWarsMod.jediRobes)
			{

				ItemStack robes = mc.thePlayer.inventory.armorItemInSlot(2);
				NBTTagCompound tags = robes.stackTagCompound;

				int level = ArmorJediRobes.getLevel(robes);
				int xp = ArmorJediRobes.getXP(robes);
				int maxxp = ArmorJediRobes.getMaxXP(robes);

				double percent = 1 + (0.1f * Math.floor(level / 10));

				if (percent > 6)
					percent = 6;

				int addition = (int)((maxxp / 100) * percent);

				int total = 0;

				if (xp + addition < maxxp)
					total = xp + addition;
				else
					total = maxxp;

				StarWarsMod.network.sendToServer(new PacketRobesNBT("xp", total, mc.thePlayer.dimension, mc.thePlayer.getCommandSenderName()));
			}
		}
	}
}
