package com.parzivail.pswm.handlers;

import java.util.Iterator;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.entities.EntityBlasterHeavyBolt;
import com.parzivail.pswm.entities.EntityBlasterPistolBolt;
import com.parzivail.pswm.entities.EntityBlasterProbeBolt;
import com.parzivail.pswm.entities.EntityBlasterRifleBolt;
import com.parzivail.pswm.entities.EntitySpeederBlasterRifleBolt;
import com.parzivail.pswm.jedirobes.ArmorJediRobes;
import com.parzivail.pswm.jedirobes.powers.Power;
import com.parzivail.pswm.jedirobes.powers.PowerDefend;
import com.parzivail.pswm.network.MessageCreateBlasterBolt;
import com.parzivail.pswm.network.MessageEntityGrab;
import com.parzivail.pswm.network.MessageSetEntityTarget;
import com.parzivail.pswm.network.PacketEntityHurt;
import com.parzivail.pswm.network.PacketReverseEntity;
import com.parzivail.pswm.network.PacketRobesBooleanNBT;
import com.parzivail.pswm.network.PacketRobesIntNBT;
import com.parzivail.pswm.registry.KeybindRegistry;
import com.parzivail.pswm.sound.SoundLightsaberHum;
import com.parzivail.pswm.sound.SoundSFoil;
import com.parzivail.pswm.utils.BlasterBoltType;
import com.parzivail.pswm.utils.ForceUtils;
import com.parzivail.pswm.utils.ForceUtils.EntityCooldownEntry;
import com.parzivail.pswm.vehicles.VehicAWing;
import com.parzivail.pswm.vehicles.VehicHothSpeederBike;
import com.parzivail.pswm.vehicles.VehicSpeederBike;
import com.parzivail.pswm.vehicles.VehicTIE;
import com.parzivail.pswm.vehicles.VehicTIEInterceptor;
import com.parzivail.pswm.vehicles.VehicXWing;
import com.parzivail.util.AnimationManager;
import com.parzivail.util.entity.EntityUtils;
import com.parzivail.util.ui.GuiManager;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
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
				StarWarsMod.network.sendToServer(new MessageCreateBlasterBolt(StarWarsMod.mc.thePlayer, BlasterBoltType.SPEEDER));
				StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "item.blasterRifle.use", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(StarWarsMod.mc.thePlayer.worldObj.rand, -0.2D, 0.2D));
			}
			else if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicXWing || StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicAWing)
			{
				StarWarsMod.network.sendToServer(new MessageCreateBlasterBolt(StarWarsMod.mc.thePlayer, BlasterBoltType.XWING));
				StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "vehicle.xwing.fire", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(StarWarsMod.mc.thePlayer.worldObj.rand, -0.2D, 0.2D));
				ClientEventHandler.guiVehicle.isFiring = true;
				ClientEventHandler.guiVehicle.blipFrame = ClientEventHandler.guiVehicle.blipMax;
			}
			else if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicTIE || StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicTIEInterceptor)
			{
				StarWarsMod.network.sendToServer(new MessageCreateBlasterBolt(StarWarsMod.mc.thePlayer, BlasterBoltType.TIE));
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

		if (KeybindRegistry.keyDebug != null && KeybindRegistry.keyDebug.isPressed())
		{
			StarWarsMod.mc.thePlayer.openGui(StarWarsMod.instance, Resources.GUI_JEDI_SITH, null, 0, 0, 0);
		}

		if (KeybindRegistry.keyRobeGui.isPressed())
		{
			if (StarWarsMod.mc.thePlayer.inventory.armorItemInSlot(2) != null && StarWarsMod.mc.thePlayer.inventory.armorItemInSlot(2).getItem() == StarWarsMod.jediRobes)
			{
				StarWarsMod.mc.thePlayer.openGui(StarWarsMod.instance, Resources.GUI_ROBES, null, 0, 0, 0);
			}
		}

		// if (KeybindRegistry.keyDebug.isPressed())
		// GuiToast.makeText("X is 10\nY is 45", GuiToast.TIME_LONG).show();

		if (KeybindRegistry.keyRobePower.isPressed())
		{
			if (StarWarsMod.mc.thePlayer.inventory.armorItemInSlot(2) != null && StarWarsMod.mc.thePlayer.inventory.armorItemInSlot(2).getItem() == StarWarsMod.jediRobes)
			{
				Power active = Power.getPowerFromName(ArmorJediRobes.getActive(StarWarsMod.mc.thePlayer));

				if (active != null && ArmorJediRobes.getLevelOf(StarWarsMod.mc.thePlayer, active.name) > 0)
				{
					Entity e = EntityUtils.rayTrace(active.getRange(), StarWarsMod.mc.thePlayer, new Entity[0]);

					if (e != null)
					{
						ArmorJediRobes.setEntityTarget(StarWarsMod.mc.thePlayer, e.getEntityId());
					}

					active.currentLevel = ArmorJediRobes.getLevelOf(StarWarsMod.mc.thePlayer, active.name);
					if (ArmorJediRobes.getXP(StarWarsMod.mc.thePlayer) - active.getCost() >= 0 && !ForceUtils.isCooling(active.name))
					{
						StarWarsMod.network.sendToServer(new PacketRobesIntNBT(Resources.nbtXp, ArmorJediRobes.getXP(StarWarsMod.mc.thePlayer) - active.getCost(), StarWarsMod.mc.thePlayer.dimension, StarWarsMod.mc.thePlayer.getCommandSenderName()));

						if (!active.isDurationBased)
						{
							if (active.name.equals("defend"))
							{
								if (!ArmorJediRobes.getIsRunning(StarWarsMod.mc.thePlayer))
								{
									if (active.run(StarWarsMod.mc.thePlayer))
									{
										StarWarsMod.network.sendToServer(new PacketRobesIntNBT(Resources.nbtActiveHealth, active.currentLevel, StarWarsMod.mc.thePlayer.dimension, StarWarsMod.mc.thePlayer.getCommandSenderName()));
										StarWarsMod.network.sendToServer(new PacketRobesBooleanNBT(Resources.nbtIsRunning, true, StarWarsMod.mc.thePlayer.dimension, StarWarsMod.mc.thePlayer.getCommandSenderName()));
									}
								}
								else
								{
									((PowerDefend)active).health = 0;
									((PowerDefend)active).isRunning = false;
									((PowerDefend)active).recharge = ((PowerDefend)active).rechargeTime;
									StarWarsMod.network.sendToServer(new PacketRobesIntNBT(Resources.nbtActiveHealth, 0, StarWarsMod.mc.thePlayer.dimension, StarWarsMod.mc.thePlayer.getCommandSenderName()));
									StarWarsMod.network.sendToServer(new PacketRobesBooleanNBT(Resources.nbtIsRunning, false, StarWarsMod.mc.thePlayer.dimension, StarWarsMod.mc.thePlayer.getCommandSenderName()));
									if (!ForceUtils.isCooling("defend"))
										ForceUtils.coolingPowers.add(active);
								}
							}
							else
							{
								active.run(StarWarsMod.mc.thePlayer);
								active.recharge = active.rechargeTime;
								if (!ForceUtils.isCooling(ArmorJediRobes.getActive(StarWarsMod.mc.thePlayer)))
									ForceUtils.coolingPowers.add(active);
							}
						}
						else
						{
							ForceUtils.isUsingDuration = true;
							StarWarsMod.network.sendToServer(new PacketRobesBooleanNBT(Resources.nbtIsUsingDuration, true, StarWarsMod.mc.thePlayer.dimension, StarWarsMod.mc.thePlayer.getCommandSenderName()));
						}
					}
				}
			}
		}
		else
		{
			StarWarsMod.network.sendToServer(new MessageSetEntityTarget(StarWarsMod.mc.thePlayer, -1));
		}
	}

	@SubscribeEvent
	public void logOut(PlayerLoggedInEvent event)
	{
		resetRobes(event);
	}

	@SubscribeEvent
	public void logOut(PlayerLoggedOutEvent event)
	{
		resetRobes(event);
	}

	@SubscribeEvent
	public void logOut(PlayerRespawnEvent event)
	{
		resetRobes(event);
	}

	public void resetRobes(PlayerEvent event)
	{
		ArmorJediRobes.setActive(event.player, "");
		ArmorJediRobes.setDuration(event.player, false);
		ArmorJediRobes.setEntityTarget(event.player, -1);
		ArmorJediRobes.setRunning(event.player, false);
		ForceUtils.activePower = null;
		ForceUtils.isUsingDuration = false;
	}

	@SubscribeEvent
	public void onTick(TickEvent.ServerTickEvent event)
	{
		Iterator<EntityCooldownEntry> i = ForceUtils.entitiesWithEffects.iterator();
		while (i.hasNext())
		{
			EntityCooldownEntry entry = i.next();

			if (entry.effect.equals("disable"))
			{
				entry.entity.motionX = 0;
				entry.entity.motionY = 0;
				entry.entity.motionZ = 0;
			}
			else if (entry.effect.equals("slow"))
			{
				entry.entity.motionX = Math.min(Math.max(entry.entity.motionX, -0.005d), 0.005d);
				entry.entity.motionY = Math.min(Math.max(entry.entity.motionY, -0.005d), 0.005d);
				entry.entity.motionZ = Math.min(Math.max(entry.entity.motionZ, -0.005d), 0.005d);
			}

			entry.cooldownLeft--;

			if (entry.cooldownLeft <= 0)
				i.remove();
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onTick(TickEvent.ClientTickEvent event)
	{
		GuiManager.tick();

		AnimationManager.tick();

		ClientEventHandler.soundManager.tick();

		if (StarWarsMod.mc.theWorld == null || StarWarsMod.mc.thePlayer == null)
			return;

		if (ArmorJediRobes.getActive(StarWarsMod.mc.thePlayer).equals("lightning") || ArmorJediRobes.getActive(StarWarsMod.mc.thePlayer).equals("grab"))
		{
			Power power = Power.getPowerFromName(ArmorJediRobes.getActive(StarWarsMod.mc.thePlayer));

			Entity e;

			if (ArmorJediRobes.getEntityTarget(StarWarsMod.mc.thePlayer) == -1)
			{
				e = EntityUtils.rayTrace(power.getRange(), StarWarsMod.mc.thePlayer, new Entity[0]);
			}
			else
				e = StarWarsMod.mc.thePlayer.worldObj.getEntityByID(ArmorJediRobes.getEntityTarget(StarWarsMod.mc.thePlayer));

			if (e != null)
			{
				ArmorJediRobes.setEntityTarget(StarWarsMod.mc.thePlayer, e.getEntityId());
				if (ArmorJediRobes.getActive(StarWarsMod.mc.thePlayer).equals("grab") && ArmorJediRobes.getUsingDuration(StarWarsMod.mc.thePlayer))
				{
					if (ForceUtils.distanceToEntity == -1)
						ForceUtils.distanceToEntity = (float)Vec3.createVectorHelper(StarWarsMod.mc.thePlayer.posX, StarWarsMod.mc.thePlayer.posY, StarWarsMod.mc.thePlayer.posZ).distanceTo(Vec3.createVectorHelper(e.posX, e.posY, e.posZ));

					if (!e.worldObj.isRemote)
					{
						StarWarsMod.network.sendToServer(new MessageEntityGrab(e, StarWarsMod.mc.thePlayer, ForceUtils.distanceToEntity));
					}
					else
					{
						Vec3 look = StarWarsMod.mc.thePlayer.getLookVec();
						look.xCoord *= ForceUtils.distanceToEntity;
						look.yCoord *= ForceUtils.distanceToEntity;
						look.zCoord *= ForceUtils.distanceToEntity;
						look.xCoord += StarWarsMod.mc.thePlayer.posX;
						look.yCoord += StarWarsMod.mc.thePlayer.posY;
						look.zCoord += StarWarsMod.mc.thePlayer.posZ;
						e.fallDistance = 0.0f;
						e.onGround = false;
						e.isAirBorne = true;
						e.timeUntilPortal = 5;
						e.setVelocity(0, 0, 0);
						e.setLocationAndAngles(look.xCoord, look.yCoord, look.zCoord, StarWarsMod.mc.thePlayer.rotationYawHead, StarWarsMod.mc.thePlayer.rotationPitch);
						StarWarsMod.network.sendToServer(new MessageEntityGrab(e, StarWarsMod.mc.thePlayer, ForceUtils.distanceToEntity));
					}
				}
			}
			else
			{
				ArmorJediRobes.setEntityTarget(StarWarsMod.mc.thePlayer, -1);
				ForceUtils.distanceToEntity = -1;
			}
		}

		Item i = StarWarsMod.mc.thePlayer.inventory.getCurrentItem() == null ? null : StarWarsMod.mc.thePlayer.inventory.getCurrentItem().getItem();
		if (i != ClientEventHandler.lastItem && (i == StarWarsMod.lightsaber || i == StarWarsMod.sequelLightsaber))
			Minecraft.getMinecraft().getSoundHandler().playSound(new SoundLightsaberHum(StarWarsMod.mc.thePlayer));
		ClientEventHandler.lastItem = i;

		if (ArmorJediRobes.getActive(StarWarsMod.mc.thePlayer).equals("deflect") && ArmorJediRobes.getUsingDuration(StarWarsMod.mc.thePlayer))
			for (Object entityObj : StarWarsMod.mc.theWorld.getEntitiesWithinAABB(Entity.class, StarWarsMod.mc.thePlayer.boundingBox.expand(3, 3, 3)))
				if (entityObj instanceof EntityArrow || entityObj instanceof EntityBlasterRifleBolt || entityObj instanceof EntityBlasterHeavyBolt || entityObj instanceof EntityBlasterPistolBolt || entityObj instanceof EntityBlasterProbeBolt || entityObj instanceof EntitySpeederBlasterRifleBolt)
				{
					Entity entity = (Entity)entityObj;
					StarWarsMod.network.sendToServer(new PacketReverseEntity(entity.getEntityId(), entity.dimension));
				}

		Iterator<Power> it = ForceUtils.coolingPowers.iterator();
		while (it.hasNext())
		{
			Power cooling = it.next();
			cooling.recharge--;
			if (cooling.recharge <= 0)
				it.remove();
		}

		if (StarWarsMod.mc.thePlayer.inventory.armorItemInSlot(2) != null && StarWarsMod.mc.thePlayer.inventory.armorItemInSlot(2).getItem() == StarWarsMod.jediRobes)
		{
			ItemStack robes = StarWarsMod.mc.thePlayer.inventory.armorItemInSlot(2);
			int level = ArmorJediRobes.getLevel(robes);
			int xp = ArmorJediRobes.getXP(robes);
			int maxxp = ArmorJediRobes.getMaxXP(robes);

			if (StarWarsMod.mc.thePlayer.ticksExisted % 20 == 0)
			{
				double percent = 1 + 0.1f * Math.floor(level / 10);

				if (percent > 6)
					percent = 6;

				int addition = (int)(maxxp / 100 * percent);

				int total = 0;

				if (xp + addition < maxxp)
					total = xp + addition;
				else
					total = maxxp;

				StarWarsMod.network.sendToServer(new PacketRobesIntNBT(Resources.nbtXp, total, StarWarsMod.mc.thePlayer.dimension, StarWarsMod.mc.thePlayer.getCommandSenderName()));
			}

			if (ForceUtils.activePower != null && ArmorJediRobes.getUsingDuration(StarWarsMod.mc.thePlayer) && !ForceUtils.isCooling(ForceUtils.activePower.name))
			{
				ForceUtils.activePower.duration++;

				ForceUtils.isUsingDuration = ForceUtils.isUsingDuration && KeybindRegistry.keyRobePower.getIsKeyPressed();
				StarWarsMod.network.sendToServer(new PacketRobesBooleanNBT(Resources.nbtIsUsingDuration, ForceUtils.isUsingDuration && KeybindRegistry.keyRobePower.getIsKeyPressed(), StarWarsMod.mc.thePlayer.dimension, StarWarsMod.mc.thePlayer.getCommandSenderName()));

				if (ForceUtils.activePower.duration > ForceUtils.activePower.getDuration() || !ArmorJediRobes.getUsingDuration(StarWarsMod.mc.thePlayer))
				{
					if (ArmorJediRobes.getActive(StarWarsMod.mc.thePlayer).equals("lightning") || ArmorJediRobes.getActive(StarWarsMod.mc.thePlayer).equals("grab"))
						if (ClientEventHandler.lastPlayerTarget instanceof EntityPlayer)
							try
							{
								StarWarsMod.network.sendToServer(new MessageSetEntityTarget(StarWarsMod.mc.thePlayer, -1));
								ClientEventHandler.lastPlayerTarget = null;
							}
							catch (Exception e)
							{
							}
					ForceUtils.activePower.duration = 0;
					StarWarsMod.network.sendToServer(new PacketRobesBooleanNBT(Resources.nbtIsUsingDuration, false, StarWarsMod.mc.thePlayer.dimension, StarWarsMod.mc.thePlayer.getCommandSenderName()));
					ForceUtils.activePower.recharge = ForceUtils.activePower.rechargeTime;
					ForceUtils.coolingPowers.add(ForceUtils.activePower);
				}
				else if (ArmorJediRobes.getActive(StarWarsMod.mc.thePlayer).equals("lightning") || ArmorJediRobes.getActive(StarWarsMod.mc.thePlayer).equals("grab"))
				{
					Power power = Power.getPowerFromName(ArmorJediRobes.getActive(StarWarsMod.mc.thePlayer));
					if (ArmorJediRobes.getEntityTarget(StarWarsMod.mc.thePlayer) != -1)
					{
						Entity e = StarWarsMod.mc.thePlayer.worldObj.getEntityByID(ArmorJediRobes.getEntityTarget(StarWarsMod.mc.thePlayer));

						if (e != null)
						{
							if (ArmorJediRobes.getActive(StarWarsMod.mc.thePlayer).equals("lightning"))
							{
								StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "force.lightning", 1.0F, 1.0F);
								StarWarsMod.network.sendToServer(new PacketEntityHurt(e.getEntityId(), e.dimension, power.getDamage()));
							}
							if (e instanceof EntityPlayer)
								try
								{
									ClientEventHandler.lastPlayerTarget = (EntityPlayer)e;
									StarWarsMod.network.sendToServer(new MessageSetEntityTarget(StarWarsMod.mc.thePlayer, e.getEntityId()));
								}
								catch (Exception exc)
								{
								}
						}
					}
					else if (ClientEventHandler.lastPlayerTarget instanceof EntityPlayer)
						try
						{
							StarWarsMod.network.sendToServer(new MessageSetEntityTarget(StarWarsMod.mc.thePlayer, -1));
							ClientEventHandler.lastPlayerTarget = null;
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

		// if (ForceUtils.activePower != null &&
		// ForceUtils.activePower.name.equals("defend") &&
		// ((PowerDefend)ForceUtils.activePower).health <= 0 &&
		// ((PowerDefend)ForceUtils.activePower).isRunning)
		if (ArmorJediRobes.getActive(StarWarsMod.mc.thePlayer).equals("defend") && ArmorJediRobes.getHealth(StarWarsMod.mc.thePlayer) <= 0 && ArmorJediRobes.getIsRunning(StarWarsMod.mc.thePlayer))

		{
			PowerDefend active = (PowerDefend)Power.getPowerFromName(ArmorJediRobes.getActive(StarWarsMod.mc.thePlayer));
			active.health = 0;
			active.isRunning = false;
			active.recharge = active.rechargeTime;
			StarWarsMod.network.sendToServer(new PacketRobesIntNBT(Resources.nbtActiveHealth, 0, StarWarsMod.mc.thePlayer.dimension, StarWarsMod.mc.thePlayer.getCommandSenderName()));
			StarWarsMod.network.sendToServer(new PacketRobesBooleanNBT(Resources.nbtIsRunning, false, StarWarsMod.mc.thePlayer.dimension, StarWarsMod.mc.thePlayer.getCommandSenderName()));
			if (!ForceUtils.isCooling("defend"))
				ForceUtils.coolingPowers.add(active);
		}
	}
}
