package com.parzivail.pswm.handlers;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.achievement.StarWarsAchievements;
import com.parzivail.pswm.entities.EntityBlasterBoltBase;
import com.parzivail.pswm.exception.UserError;
import com.parzivail.pswm.force.CronUtils;
import com.parzivail.pswm.force.powers.ICanHaveEntityTarget;
import com.parzivail.pswm.force.powers.PowerBase;
import com.parzivail.pswm.force.powers.PowerDefend;
import com.parzivail.pswm.force.powers.PowerLightning;
import com.parzivail.pswm.items.weapons.ItemLightsaber;
import com.parzivail.pswm.jedi.JediUtils;
import com.parzivail.pswm.network.*;
import com.parzivail.pswm.registry.KeybindRegistry;
import com.parzivail.pswm.rendering.gui.AnimationHyperspace;
import com.parzivail.pswm.rendering.gui.GuiVehicle;
import com.parzivail.pswm.sound.SoundSFoil;
import com.parzivail.pswm.utils.BlasterBoltType;
import com.parzivail.pswm.utils.ForceUtils;
import com.parzivail.pswm.utils.ForceUtils.EntityCooldownEntry;
import com.parzivail.pswm.vehicles.*;
import com.parzivail.util.entity.EntityUtils;
import com.parzivail.util.math.AnimationManager;
import com.parzivail.util.ui.GuiManager;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static com.parzivail.pswm.utils.ForceUtils.activePower;

public class CommonEventHandler
{
	@SubscribeEvent
	public void logOut(PlayerLoggedInEvent event) throws UserError
	{
		this.resetRobes(event);
	}

	@SubscribeEvent
	public void logOut(PlayerLoggedOutEvent event)
	{
		this.resetRobes(event);
	}

	@SubscribeEvent
	public void logOut(PlayerRespawnEvent event)
	{
		this.resetRobes(event);
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onKeyInput(InputEvent.KeyInputEvent event)
	{
		if (KeybindRegistry.keyShootVehicle.isPressed())
		{
			if (StarWarsMod.mc.thePlayer.ridingEntity != null)
			{
				if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicSpeederBike || StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicHothSpeederBike)
				{
					StarWarsMod.network.sendToServer(new MessageCreateBlasterBolt(StarWarsMod.mc.thePlayer, BlasterBoltType.SPEEDER));
					StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "fx.shoot.bike", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(StarWarsMod.mc.thePlayer.worldObj.rand, -0.2D, 0.2D));
				}
				else if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicXWing)
				{
					StarWarsMod.network.sendToServer(new MessageCreateBlasterBolt(StarWarsMod.mc.thePlayer, BlasterBoltType.XWING));
					StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "vehicle.xwing.fire", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(StarWarsMod.mc.thePlayer.worldObj.rand, -0.2D, 0.2D));
				}
				else if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicYWing)
				{
					StarWarsMod.network.sendToServer(new MessageCreateBlasterBolt(StarWarsMod.mc.thePlayer, BlasterBoltType.YWING));
					StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "vehicle.xwing.fire", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(StarWarsMod.mc.thePlayer.worldObj.rand, -0.2D, 0.2D));
				}
				else if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicAWing)
				{
					StarWarsMod.network.sendToServer(new MessageCreateBlasterBolt(StarWarsMod.mc.thePlayer, BlasterBoltType.AWING));
					StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "vehicle.xwing.fire", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(StarWarsMod.mc.thePlayer.worldObj.rand, -0.2D, 0.2D));
				}
				else if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicSnowspeeder)
				{
					StarWarsMod.network.sendToServer(new MessageCreateBlasterBolt(StarWarsMod.mc.thePlayer, BlasterBoltType.SNOWSPEEDER));
					StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "vehicle.xwing.fire", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(StarWarsMod.mc.thePlayer.worldObj.rand, -0.2D, 0.2D));
				}
				else if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicSkyhopper)
				{
					StarWarsMod.network.sendToServer(new MessageCreateBlasterBolt(StarWarsMod.mc.thePlayer, BlasterBoltType.SKYHOPPER));
					StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "vehicle.xwing.fire", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(StarWarsMod.mc.thePlayer.worldObj.rand, -0.2D, 0.2D));
				}
				else if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicATST)
				{
					StarWarsMod.network.sendToServer(new MessageCreateBlasterBolt(StarWarsMod.mc.thePlayer, BlasterBoltType.ATST));
					StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "fx.shoot.bike", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(StarWarsMod.mc.thePlayer.worldObj.rand, -0.2D, 0.2D));
				}
				else if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicTIE || StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicTIEInterceptor || StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicTIEAdvanced || StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicTIEBomber)
				{
					StarWarsMod.network.sendToServer(new MessageCreateBlasterBolt(StarWarsMod.mc.thePlayer, BlasterBoltType.TIE));
					StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "vehicle.tie.fire", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(StarWarsMod.mc.thePlayer.worldObj.rand, -0.2D, 0.2D));
				}
				GuiVehicle.isFiring = true;
				GuiVehicle.blipFrame = GuiVehicle.blipMax;
			}
			else if (StarWarsMod.mc.thePlayer.inventory.getCurrentItem() != null && StarWarsMod.mc.thePlayer.inventory.getCurrentItem().getItem() instanceof ItemLightsaber)
			{
				ItemStack s = StarWarsMod.mc.thePlayer.inventory.getCurrentItem();
				EntityPlayer entityPlayer = StarWarsMod.mc.thePlayer;
				if (s.stackTagCompound.getString(ItemLightsaber.nbtHilt).equals("ezra") && s.stackTagCompound.getInteger(ItemLightsaber.nbtBlasterTimeout) == 0 && !s.stackTagCompound.getBoolean(ItemLightsaber.nbtBladeOn))
				{
					entityPlayer.addStat(StarWarsAchievements.ezraBlaster, 1);
					entityPlayer.playSound(Resources.MODID + ":" + "fx.shoot.dl44", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(StarWarsMod.rngGeneral, -0.2D, 0.2D));
					s.stackTagCompound.setInteger(ItemLightsaber.nbtBlasterTimeout, 40);
					StarWarsMod.network.sendToServer(new MessageCreateBlasterBolt(entityPlayer, BlasterBoltType.EZRA));
				}
			}
		}

		if (KeybindRegistry.keyShootProton.isPressed())
		{
			if (StarWarsMod.mc.thePlayer.ridingEntity != null && StarWarsMod.shipSpecialWeaponCooldown == 0)
			{
				if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicXWing)
				{
					StarWarsMod.network.sendToServer(new MessageCreateBlasterBolt(StarWarsMod.mc.thePlayer, BlasterBoltType.PROTON));
					StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "vehicle.xwing.proton", 1.0F, 1.0F);
					StarWarsMod.shipSpecialWeaponCooldown = 200;
				}
				else if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicTIEBomber || StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicYWing)
				{
					StarWarsMod.network.sendToServer(new MessageCreateBlasterBolt(StarWarsMod.mc.thePlayer, BlasterBoltType.BOMB));
					StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "vehicle.xwing.proton", 1.0F, 1.0F);
					StarWarsMod.shipSpecialWeaponCooldown = 0;
				}
			}
		}

		if (KeybindRegistry.keySFoil.isPressed())
			if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicXWing)
			{
				VehicXWing xwing = (VehicXWing)StarWarsMod.mc.thePlayer.ridingEntity;
				if (xwing.getSFoil() <= 0.45f && !(xwing.isOpening || xwing.isClosing))
				{
					xwing.isOpening = true;
					Minecraft.getMinecraft().getSoundHandler().playSound(new SoundSFoil(StarWarsMod.mc.thePlayer, true));
				}
				if (xwing.getSFoil() >= 0.55f && !(xwing.isOpening || xwing.isClosing))
				{
					xwing.isClosing = true;
					Minecraft.getMinecraft().getSoundHandler().playSound(new SoundSFoil(StarWarsMod.mc.thePlayer, false));
				}
			}
			else if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicSkyhopper)
			{
				VehicSkyhopper skyh = (VehicSkyhopper)StarWarsMod.mc.thePlayer.ridingEntity;
				if (skyh.getWing() <= 0.45f && !(skyh.isOpening || skyh.isClosing))
				{
					skyh.isOpening = true;
					Minecraft.getMinecraft().getSoundHandler().playSound(new SoundSFoil(StarWarsMod.mc.thePlayer, false));
				}
				if (skyh.getWing() >= 0.55f && !(skyh.isOpening || skyh.isClosing))
				{
					skyh.isClosing = true;
					Minecraft.getMinecraft().getSoundHandler().playSound(new SoundSFoil(StarWarsMod.mc.thePlayer, true));
				}
			}

		if (KeybindRegistry.keyDebug != null && KeybindRegistry.keyDebug.isPressed())
			new AnimationHyperspace(3500, false).start();

		if (KeybindRegistry.keyLSForge.isPressed())
			StarWarsMod.mc.thePlayer.openGui(StarWarsMod.instance, Resources.GUI_LSFORGE, null, 0, 0, 0);

		if (KeybindRegistry.keyLSToggle.isPressed())
		{
			EntityPlayer player = StarWarsMod.mc.thePlayer;
			ItemStack stack = player.inventory.getCurrentItem();
			if (stack != null && stack.stackTagCompound != null && stack.stackTagCompound.getInteger(ItemLightsaber.nbtBladeTimeout) <= 0)
			{
				if (!stack.stackTagCompound.getBoolean(ItemLightsaber.nbtBladeWaterproof) && player.isInsideOfMaterial(Material.water))
				{
					stack.stackTagCompound.setInteger(ItemLightsaber.nbtBladeTimeout, 10);
					player.playSound(Resources.MODID + ":" + "item.lightsaber.fizz", 1.0F, 1.0F);
				}
				else
				{
					if (stack.stackTagCompound.getBoolean(ItemLightsaber.nbtBladeOn))
						player.playSound(Resources.MODID + ":" + "item.lightsaber.close", 1.0F, 1.0F);
					else
						player.playSound(Resources.MODID + ":" + "item.lightsaber.open", 1.0F, 1.0F);
					stack.stackTagCompound.setBoolean(ItemLightsaber.nbtBladeOn, !stack.stackTagCompound.getBoolean(ItemLightsaber.nbtBladeOn));
					stack.stackTagCompound.setInteger(ItemLightsaber.nbtBladeTimeout, 10);
					StarWarsMod.network.sendToServer(new MessageSetPlayerHolding(player, stack));
				}
			}
		}

		if (KeybindRegistry.keyQuest != null && KeybindRegistry.keyQuest.isPressed())
			StarWarsMod.mc.thePlayer.openGui(StarWarsMod.instance, Resources.GUI_QUEST, null, 0, 0, 0);

		if (KeybindRegistry.keyRobeGui.isPressed())
			if (CronUtils.getHolocron(StarWarsMod.mc.thePlayer) != null)
				StarWarsMod.mc.thePlayer.openGui(StarWarsMod.instance, Resources.GUI_ROBES, null, 0, 0, 0);

		if (KeybindRegistry.keyRobePowerNext.isPressed())
		{
			if (CronUtils.getHolocron(StarWarsMod.mc.thePlayer) != null)
			{
				String current = CronUtils.getActive(StarWarsMod.mc.thePlayer).name;
				ArrayList<String> powers = ForceUtils.getPowersAvailableAtLevel(CronUtils.getSide(StarWarsMod.mc.thePlayer), CronUtils.getLevel(StarWarsMod.mc.thePlayer));
				int index = Arrays.asList(powers.toArray()).indexOf(current);
				do
				{
					index++;
					if (index >= powers.size())
						index = 0;
				}
				while (CronUtils.getLevelOf(StarWarsMod.mc.thePlayer, powers.get(index)) == 0 && !powers.get(index).equals(current));
				if (index < powers.size() - 1 && !powers.get(index).equals(current))
				{
					if (index < 0)
						index = powers.size() - 1;
					PowerBase selectedPower = CronUtils.getPower(StarWarsMod.mc.thePlayer, powers.get(index));
					activePower = selectedPower;
					CronUtils.setActive(StarWarsMod.mc.thePlayer, selectedPower);
					StarWarsMod.network.sendToServer(new MessageHolocronSetActive(StarWarsMod.mc.thePlayer, selectedPower.serialize()));
				}
			}
		}

		if (KeybindRegistry.keyRobePowerPrev.isPressed())
		{
			if (CronUtils.getHolocron(StarWarsMod.mc.thePlayer) != null)
			{
				String current = CronUtils.getActive(StarWarsMod.mc.thePlayer).name;
				ArrayList<String> powers = ForceUtils.getPowersAvailableAtLevel(CronUtils.getSide(StarWarsMod.mc.thePlayer), CronUtils.getLevel(StarWarsMod.mc.thePlayer));
				int index = Arrays.asList(powers.toArray()).indexOf(current);
				do
				{
					index--;
					if (index < 0)
						index = powers.size() - 1;
				}
				while (CronUtils.getLevelOf(StarWarsMod.mc.thePlayer, powers.get(index)) == 0 && !powers.get(index).equals(current));
				if (index > -1 && !powers.get(index).equals(current))
				{
					if (index < 0)
						index = powers.size() - 1;
					PowerBase selectedPower = CronUtils.getPower(StarWarsMod.mc.thePlayer, powers.get(index));
					activePower = selectedPower;
					CronUtils.setActive(StarWarsMod.mc.thePlayer, selectedPower);
					StarWarsMod.network.sendToServer(new MessageHolocronSetActive(StarWarsMod.mc.thePlayer, selectedPower.serialize()));
				}
			}
		}

		if (KeybindRegistry.keyRobePower.isPressed())
		{
			ItemStack cron;
			if ((cron = CronUtils.getHolocron(StarWarsMod.mc.thePlayer)) != null)
			{
				PowerBase powerBase = CronUtils.getActive(cron);
				if (powerBase != null && CronUtils.getXP(StarWarsMod.mc.thePlayer) - powerBase.getCost() >= 0 && !ForceUtils.isCooling(powerBase.name))
				{
					if (powerBase != null && powerBase.recharge <= 0)
					{
						boolean coolFlag = true;
						switch (powerBase.name)
						{
							case "defend":
								PowerDefend powerDefend = (PowerDefend)powerBase;
								if (powerDefend.isRunning)
								{
									powerDefend.isRunning = false;
									powerDefend.health = 0;
									powerDefend.recharge = powerDefend.rechargeTime;
								}
								else
									powerDefend.run(StarWarsMod.mc.thePlayer);
								coolFlag = false;
								break;
							case "lightning":
								Entity e = EntityUtils.rayTrace(powerBase.getRange(), StarWarsMod.mc.thePlayer, new Entity[0]);
								if (e != null)
								{
									((ICanHaveEntityTarget)powerBase).setEntityTargetId(e.getEntityId());
									((PowerLightning)powerBase).isRunning = true;
									coolFlag = false;
								}
								break;
							default:
								powerBase.run(StarWarsMod.mc.thePlayer);
								powerBase.recharge = powerBase.rechargeTime;
								break;
						}

						if (coolFlag && !ForceUtils.isCooling(CronUtils.getActive(StarWarsMod.mc.thePlayer).name))
							ForceUtils.coolingPowers.add(powerBase);

						StarWarsMod.network.sendToServer(new MessageRobesIntNBT(StarWarsMod.mc.thePlayer, Resources.nbtXp, CronUtils.getXP(StarWarsMod.mc.thePlayer) - powerBase.getCost()));
						StarWarsMod.network.sendToServer(new MessageHolocronSetActive(StarWarsMod.mc.thePlayer, powerBase.serialize()));
					}
				}
			}
		}
	}

	@SubscribeEvent(priority = EventPriority.NORMAL,
	                receiveCanceled = true)
	public void onEvent(TickEvent.PlayerTickEvent event)
	{
		if (!Resources.ConfigOptions.enableLightsaberLight)
			return;
		if (event.phase == TickEvent.Phase.START && !event.player.worldObj.isRemote)
		{
			if (event.player.getCurrentEquippedItem() != null)
			{
				if (ItemLightsaber.isOn(event.player.getCurrentEquippedItem()))
				{
					int blockX = MathHelper.floor_double(event.player.posX);
					int blockY = MathHelper.floor_double(event.player.posY - 0.2D -
							event.player.getYOffset());
					int blockZ = MathHelper.floor_double(event.player.posZ);

					if (event.player.worldObj.getBlock(blockX, blockY, blockZ) == Blocks.air)
						event.player.worldObj.setBlock(blockX, blockY, blockZ, StarWarsMod.blockMovingLightSource);
					else if (event.player.worldObj.getBlock(blockX + (int)event.player.getLookVec().xCoord, blockY + (int)event.player.getLookVec().yCoord, blockZ + (int)event.player.getLookVec().zCoord) == Blocks.air)
						event.player.worldObj.setBlock(blockX, blockY, blockZ, StarWarsMod.blockMovingLightSource);
				}
			}
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onTick(TickEvent.ClientTickEvent event)
	{
		GuiManager.tick();

		AnimationManager.tick();

		ClientEventHandler.soundManager.tick();

		if (StarWarsMod.shipSpecialWeaponCooldown > 0)
			StarWarsMod.shipSpecialWeaponCooldown--;

		if (StarWarsMod.mc.theWorld == null || StarWarsMod.mc.thePlayer == null)
			return;

		PowerBase power1 = CronUtils.getActive(StarWarsMod.mc.thePlayer);

		if (power1 != null && (power1.name.equals("lightning") || power1.name.equals("grab")))
		{
			ICanHaveEntityTarget targetable = (ICanHaveEntityTarget)power1;

			Entity e = StarWarsMod.mc.thePlayer.worldObj.getEntityByID(targetable.getEntityTargetId());

			if (e != null)
			{
				if (JediUtils.getActive(StarWarsMod.mc.thePlayer).equals("grab") && JediUtils.getUsingDuration(StarWarsMod.mc.thePlayer))
				{
					if (ForceUtils.distanceToEntity == -1)
						ForceUtils.distanceToEntity = (float)Vec3.createVectorHelper(StarWarsMod.mc.thePlayer.posX, StarWarsMod.mc.thePlayer.posY, StarWarsMod.mc.thePlayer.posZ).distanceTo(Vec3.createVectorHelper(e.posX, e.posY, e.posZ));

					if (!e.worldObj.isRemote)
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
				targetable.setEntityTargetId(-1);
				if (power1 instanceof PowerLightning)
					((PowerLightning)power1).isRunning = false;
				ForceUtils.distanceToEntity = -1;
				StarWarsMod.network.sendToServer(new MessageHolocronSetActive(StarWarsMod.mc.thePlayer, power1.serialize()));

				if (!ForceUtils.isCooling(power1.name))
					ForceUtils.coolingPowers.add(power1);
			}
		}

		if (JediUtils.getActive(StarWarsMod.mc.thePlayer).equals("deflect") && JediUtils.getUsingDuration(StarWarsMod.mc.thePlayer))
			StarWarsMod.mc.theWorld.getEntitiesWithinAABB(Entity.class, StarWarsMod.mc.thePlayer.boundingBox.expand(3, 3, 3)).stream().filter(entityObj -> entityObj instanceof EntityArrow || entityObj instanceof EntityBlasterBoltBase).forEach(entityObj -> {
				Entity entity = (Entity)entityObj;
				StarWarsMod.network.sendToServer(new MessageEntityReverse(entity));
			});

		NBTTagCompound powers = CronUtils.compilePowers();

		Iterator<PowerBase> powerBaseIterator = ForceUtils.coolingPowers.iterator();
		while (powerBaseIterator.hasNext())
		{
			PowerBase cooling = powerBaseIterator.next();
			cooling.recharge--;
			if (cooling.recharge <= 0)
			{
				powerBaseIterator.remove();

				if (CronUtils.getActive(StarWarsMod.mc.thePlayer).name.equals(cooling.name))
					StarWarsMod.network.sendToServer(new MessageHolocronSetActive(StarWarsMod.mc.thePlayer, cooling.serialize()));
			}

			powers.setTag(cooling.name, cooling.serialize());
		}

		StarWarsMod.network.sendToServer(new MessageHolocronRefreshPowers(StarWarsMod.mc.thePlayer, powers));

		if (CronUtils.getHolocron(StarWarsMod.mc.thePlayer) != null)
		{
			ItemStack robes = CronUtils.getHolocron(StarWarsMod.mc.thePlayer);
			int level = CronUtils.getLevel(robes);
			int xp = CronUtils.getXP(robes);
			int maxxp = CronUtils.getMaxXP(robes);

			if (StarWarsMod.mc.thePlayer.ticksExisted % 20 == 0)
			{
				double percent = 1 + 0.1f * Math.floor(level / 10);

				if (percent > 6)
					percent = 6;

				int addition = (int)(maxxp / 100 * percent);

				int total;

				if (xp + addition < maxxp)
					total = xp + addition;
				else
					total = maxxp;

				StarWarsMod.network.sendToServer(new MessageRobesIntNBT(StarWarsMod.mc.thePlayer, Resources.nbtXp, total));
			}

			powers = CronUtils.compilePowers();

			PowerBase activePower = CronUtils.getActive(StarWarsMod.mc.thePlayer);

			if (activePower != null && activePower.duration > 0 && !ForceUtils.isCooling(activePower.name))
			{
				activePower.duration++;

				ForceUtils.isUsingDuration = ForceUtils.isUsingDuration && KeybindRegistry.keyRobePower.getIsKeyPressed();

				if (activePower.duration > activePower.getDuration() || !ForceUtils.isUsingDuration)
				{
					if (activePower.name.equals("lightning") || JediUtils.getActive(StarWarsMod.mc.thePlayer).equals("grab"))
					{
						PowerLightning powerLightning = (PowerLightning)CronUtils.getActive(StarWarsMod.mc.thePlayer);
						powerLightning.targetId = -1;
					}
					activePower.duration = 0;
					activePower.recharge = activePower.rechargeTime;
					ForceUtils.coolingPowers.add(activePower);
				}
				else if (CronUtils.getActive(StarWarsMod.mc.thePlayer).name.equals("lightning") || CronUtils.getActive(StarWarsMod.mc.thePlayer).name.equals("grab"))
				{
					PowerBase power = CronUtils.getActive(StarWarsMod.mc.thePlayer);
					if (power instanceof ICanHaveEntityTarget)
					{
						ICanHaveEntityTarget targetable = (ICanHaveEntityTarget)power;

						if (targetable.hasEntityTarget())
						{
							Entity e = StarWarsMod.mc.thePlayer.worldObj.getEntityByID(targetable.getEntityTargetId());

							if (e != null)
							{
								if (activePower.name.equals("lightning"))
								{
									StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "force.lightning", 1.0F, 1.0F);
									StarWarsMod.network.sendToServer(new MessageEntityHurt(e, power.getDamage()));
								}
								if (e instanceof EntityPlayer)
									try
									{
										ClientEventHandler.lastPlayerTarget = (EntityPlayer)e;
										StarWarsMod.network.sendToServer(new MessageSetEntityTarget(StarWarsMod.mc.thePlayer, e.getEntityId()));
									}
									catch (Exception ignored)
									{
									}
							}
							else
							{
								targetable.setEntityTargetId(-1);
								ClientEventHandler.lastPlayerTarget = null;
							}
						}
						else if (ClientEventHandler.lastPlayerTarget instanceof EntityPlayer)
						{
							targetable.setEntityTargetId(-1);
							ClientEventHandler.lastPlayerTarget = null;
						}
					}
				}
				else if (activePower.name.equals("defend") && ((PowerDefend)activePower).health <= 0 && ((PowerDefend)activePower).isRunning)
				{
					PowerDefend active = (PowerDefend)activePower;
					active.health = 0;
					active.isRunning = false;
					active.recharge = active.rechargeTime;
					if (!ForceUtils.isCooling("defend"))
						ForceUtils.coolingPowers.add(active);
				}
			}

			if (activePower != null)
				powers.setTag(activePower.name, activePower.serialize());
			StarWarsMod.network.sendToServer(new MessageHolocronRefreshPowers(StarWarsMod.mc.thePlayer, powers));
		}
		else
		{
			activePower = null;
			ForceUtils.isUsingDuration = false;
		}
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

	private void resetRobes(PlayerEvent event)
	{
		StarWarsMod.network.sendToServer(new MessageHolocronRefreshPowers(event.player, CronUtils.compilePowers()));
		StarWarsMod.network.sendToServer(new MessageHolocronSetActive(event.player, new NBTTagCompound()));

		activePower = null;
		ForceUtils.isUsingDuration = false;
	}
}
