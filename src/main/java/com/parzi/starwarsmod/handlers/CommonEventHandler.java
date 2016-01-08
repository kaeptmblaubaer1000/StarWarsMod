package com.parzi.starwarsmod.handlers;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsEnum;
import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.entities.EntityBlasterHeavyBolt;
import com.parzi.starwarsmod.entities.EntityBlasterPistolBolt;
import com.parzi.starwarsmod.entities.EntityBlasterProbeBolt;
import com.parzi.starwarsmod.entities.EntityBlasterRifleBolt;
import com.parzi.starwarsmod.entities.EntitySpeederBlasterRifleBolt;
import com.parzi.starwarsmod.jedirobes.ArmorJediRobes;
import com.parzi.starwarsmod.jedirobes.powers.Power;
import com.parzi.starwarsmod.jedirobes.powers.PowerDefend;
import com.parzi.starwarsmod.jedirobes.powers.PowerLightning;
import com.parzi.starwarsmod.network.PacketCreateBlasterBolt;
import com.parzi.starwarsmod.network.PacketEntityHurt;
import com.parzi.starwarsmod.network.PacketPlayerLightning;
import com.parzi.starwarsmod.network.PacketReverseEntity;
import com.parzi.starwarsmod.network.PacketRobesNBT;
import com.parzi.starwarsmod.registry.KeybindRegistry;
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
		if (KeybindRegistry.keyShootVehicle.isPressed() && StarWarsMod.mc.thePlayer.ridingEntity != null)
			if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicSpeederBike || StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicHothSpeederBike)
			{
				StarWarsMod.network.sendToServer(new PacketCreateBlasterBolt(StarWarsMod.mc.thePlayer.getCommandSenderName(), StarWarsMod.mc.thePlayer.worldObj.provider.dimensionId, BlasterBoltType.SPEEDER));
				StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "item.blasterRifle.use", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(StarWarsMod.mc.thePlayer.worldObj.rand, -0.2D, 0.2D));
			}
			else if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicXWing || StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicAWing)
			{
				StarWarsMod.network.sendToServer(new PacketCreateBlasterBolt(StarWarsMod.mc.thePlayer.getCommandSenderName(), StarWarsMod.mc.thePlayer.worldObj.provider.dimensionId, BlasterBoltType.XWING));
				StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "vehicle.xwing.fire", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(StarWarsMod.mc.thePlayer.worldObj.rand, -0.2D, 0.2D));
				ClientEventHandler.isFiring = true;
				ClientEventHandler.blipFrame = ClientEventHandler.blipMax;
			}
			else if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicTIE || StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicTIEInterceptor)
			{
				StarWarsMod.network.sendToServer(new PacketCreateBlasterBolt(StarWarsMod.mc.thePlayer.getCommandSenderName(), StarWarsMod.mc.thePlayer.worldObj.provider.dimensionId, BlasterBoltType.TIE));
				StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "vehicle.tie.fire", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(StarWarsMod.mc.thePlayer.worldObj.rand, -0.2D, 0.2D));
			}

		if (KeybindRegistry.keySFoil.isPressed())
			if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicXWing)
			{
				VehicXWing xwing = (VehicXWing)StarWarsMod.mc.thePlayer.ridingEntity;
				if (xwing.getSFoil() <= 0)
				{
					xwing.isOpening = true;
					Minecraft.getMinecraft().getSoundHandler().playSound(new SoundSFoil(StarWarsMod.mc.thePlayer, true));
				}
				if (xwing.getSFoil() >= 0.8f)
				{
					xwing.isClosing = true;
					Minecraft.getMinecraft().getSoundHandler().playSound(new SoundSFoil(StarWarsMod.mc.thePlayer, false));
				}
			}

		if (KeybindRegistry.keyRobeGui.isPressed())
			StarWarsMod.mc.thePlayer.openGui(StarWarsMod.instance, StarWarsEnum.GUI_ROBES, null, 0, 0, 0);

		if (KeybindRegistry.keyRobePower.isPressed())
			if (StarWarsMod.mc.thePlayer.inventory.armorItemInSlot(2) != null && StarWarsMod.mc.thePlayer.inventory.armorItemInSlot(2).getItem() == StarWarsMod.jediRobes)
			{
				ItemStack stack = StarWarsMod.mc.thePlayer.inventory.armorItemInSlot(2);
				Power active = ForceUtils.activePower;

				if (active != null && ArmorJediRobes.getLevelOf(stack, active.name) > 0)
				{
					active.currentLevel = ArmorJediRobes.getLevelOf(stack, active.name);
					if (ArmorJediRobes.getXP(stack) - active.getCost() >= 0 && !ForceUtils.coolingPowers.contains(active))
					{
						StarWarsMod.network.sendToServer(new PacketRobesNBT("xp", ArmorJediRobes.getXP(stack) - active.getCost(), StarWarsMod.mc.thePlayer.dimension, StarWarsMod.mc.thePlayer.getCommandSenderName()));

						if (!active.isDurationBased)
						{
							if (active.name.equals("defend"))
							{
								if (!((PowerDefend)ForceUtils.activePower).isRunning)
									active.run(StarWarsMod.mc.thePlayer);
								else
								{
									PowerDefend power = (PowerDefend)ForceUtils.activePower;
									power.health = 0;
									power.isRunning = false;
									power.recharge = power.rechargeTime;
									ForceUtils.coolingPowers.add(power);
								}
							}
							else
							{
								active.run(StarWarsMod.mc.thePlayer);
								active.recharge = active.rechargeTime;
								ForceUtils.coolingPowers.add(active);
							}
						}
						else
							ForceUtils.isUsingDuration = true;
					}
				}
			}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onTick(TickEvent.ClientTickEvent event)
	{
		if (StarWarsMod.mc.theWorld == null || StarWarsMod.mc.thePlayer == null)
			return;

		Item i = StarWarsMod.mc.thePlayer.inventory.getCurrentItem() == null ? null : StarWarsMod.mc.thePlayer.inventory.getCurrentItem().getItem();
		if (i != ClientEventHandler.lastItem && (i == StarWarsMod.lightsaber || i == StarWarsMod.sequelLightsaber))
			Minecraft.getMinecraft().getSoundHandler().playSound(new SoundLightsaberHum(StarWarsMod.mc.thePlayer));
		ClientEventHandler.lastItem = i;

		if (ForceUtils.activePower != null && ForceUtils.activePower.name.equals("deflect") && ForceUtils.isUsingDuration)
			for (Object entityObj : StarWarsMod.mc.theWorld.getEntitiesWithinAABB(Entity.class, StarWarsMod.mc.thePlayer.boundingBox.expand(3, 3, 3)))
				if (entityObj instanceof EntityArrow || entityObj instanceof EntityBlasterRifleBolt || entityObj instanceof EntityBlasterHeavyBolt || entityObj instanceof EntityBlasterPistolBolt || entityObj instanceof EntityBlasterProbeBolt || entityObj instanceof EntitySpeederBlasterRifleBolt)
				{
					Entity entity = (Entity)entityObj;
					StarWarsMod.network.sendToServer(new PacketReverseEntity(entity.getEntityId(), entity.dimension));
				}

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

			if (StarWarsMod.mc.thePlayer.inventory.armorItemInSlot(2) != null && StarWarsMod.mc.thePlayer.inventory.armorItemInSlot(2).getItem() == StarWarsMod.jediRobes)
			{
				ItemStack robes = StarWarsMod.mc.thePlayer.inventory.armorItemInSlot(2);
				int level = ArmorJediRobes.getLevel(robes);
				int xp = ArmorJediRobes.getXP(robes);
				int maxxp = ArmorJediRobes.getMaxXP(robes);

				double percent = 1 + 0.1f * Math.floor(level / 10);

				if (percent > 6)
					percent = 6;

				int addition = (int)(maxxp / 100 * percent);

				int total = 0;

				if (xp + addition < maxxp)
					total = xp + addition;
				else
					total = maxxp;

				StarWarsMod.network.sendToServer(new PacketRobesNBT("xp", total, StarWarsMod.mc.thePlayer.dimension, StarWarsMod.mc.thePlayer.getCommandSenderName()));

				if (ForceUtils.isUsingDuration && ForceUtils.activePower != null)
				{
					ForceUtils.activePower.duration++;

					ForceUtils.isUsingDuration = ForceUtils.isUsingDuration && KeybindRegistry.keyRobePower.getIsKeyPressed();

					if (ForceUtils.activePower.duration > ForceUtils.activePower.getDuration() || !ForceUtils.isUsingDuration)
					{
						if (ForceUtils.activePower.name.equals("lightning"))
							if (ClientEventHandler.lastLightning instanceof EntityPlayer)
								try
						{
									StarWarsMod.network.sendToServer(new PacketPlayerLightning(StarWarsMod.mc.thePlayer.getCommandSenderName(), "", StarWarsMod.mc.thePlayer.dimension));
									ClientEventHandler.lastLightning = null;
						}
						catch (Exception e)
						{
						}
						ForceUtils.activePower.duration = 0;
						ForceUtils.isUsingDuration = false;
						ForceUtils.activePower.recharge = ForceUtils.activePower.rechargeTime;
						ForceUtils.coolingPowers.add(ForceUtils.activePower);
					}
					else if (ForceUtils.activePower.name.equals("lightning"))
					{
						PowerLightning power = (PowerLightning)ForceUtils.activePower;
						if (power.getTarget() != null)
						{
							StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "force.lightning", 1.0F, 1.0F);
							StarWarsMod.network.sendToServer(new PacketEntityHurt(power.getTarget().getEntityId(), power.getTarget().dimension, power.getDamage()));
							if (power.getTarget() instanceof EntityPlayer)
								try
							{
									ClientEventHandler.lastLightning = (EntityPlayer)power.getTarget();
									StarWarsMod.network.sendToServer(new PacketPlayerLightning(StarWarsMod.mc.thePlayer.getCommandSenderName(), power.getTarget().getCommandSenderName(), StarWarsMod.mc.thePlayer.dimension));
							}
							catch (Exception e)
							{
							}
						}
						else if (ClientEventHandler.lastLightning instanceof EntityPlayer)
							try
						{
								StarWarsMod.network.sendToServer(new PacketPlayerLightning(StarWarsMod.mc.thePlayer.getCommandSenderName(), "", StarWarsMod.mc.thePlayer.dimension));
								ClientEventHandler.lastLightning = null;
						}
						catch (Exception e)
						{
						}
					}
				}
			}
			else
			{
				ForceUtils.activePower = null;
				ForceUtils.isUsingDuration = false;
			}
		}
	}
}
