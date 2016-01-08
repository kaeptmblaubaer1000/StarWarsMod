package com.parzi.starwarsmod.handlers;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.entities.EntityBlasterHeavyBolt;
import com.parzi.starwarsmod.entities.EntityBlasterPistolBolt;
import com.parzi.starwarsmod.entities.EntityBlasterProbeBolt;
import com.parzi.starwarsmod.entities.EntityBlasterRifleBolt;
import com.parzi.starwarsmod.entities.EntitySpeederBlasterRifleBolt;
import com.parzi.starwarsmod.font.FontManager;
import com.parzi.starwarsmod.items.ItemBinoculars;
import com.parzi.starwarsmod.items.ItemBinocularsTatooine;
import com.parzi.starwarsmod.jedirobes.ArmorJediRobes;
import com.parzi.starwarsmod.jedirobes.powers.PowerDefend;
import com.parzi.starwarsmod.jedirobes.powers.PowerLightning;
import com.parzi.starwarsmod.network.PacketCreateBlasterBolt;
import com.parzi.starwarsmod.network.PacketReverseEntity;
import com.parzi.starwarsmod.network.PacketShipTargetLock;
import com.parzi.starwarsmod.rendering.force.ModelJediCloak;
import com.parzi.starwarsmod.rendering.force.RenderJediDefense;
import com.parzi.starwarsmod.rendering.force.RenderSithLightning;
import com.parzi.starwarsmod.rendering.gui.GuiVehicle;
import com.parzi.starwarsmod.rendering.helper.PGui;
import com.parzi.starwarsmod.rendering.helper.VehicleLineDraw;
import com.parzi.starwarsmod.sound.PSoundBank;
import com.parzi.starwarsmod.utils.BlasterBoltType;
import com.parzi.starwarsmod.utils.ForceUtils;
import com.parzi.starwarsmod.vehicles.VehicAWing;
import com.parzi.starwarsmod.vehicles.VehicHothSpeederBike;
import com.parzi.starwarsmod.vehicles.VehicSpeederBike;
import com.parzi.starwarsmod.vehicles.VehicTIE;
import com.parzi.starwarsmod.vehicles.VehicTIEInterceptor;
import com.parzi.starwarsmod.vehicles.VehicXWing;
import com.parzi.util.MathUtils;
import com.parzi.util.entity.EntityUtils;
import com.parzi.util.entity.PlayerHelper;
import com.parzi.util.ui.GlPalette;
import com.parzi.util.ui.RenderHelper;
import com.parzi.util.ui.Text;
import com.parzi.util.ui.TextUtils;
import com.parzi.util.vehicle.VehicleAirBase;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientEventHandler
{
	public static Item lastItem = null;
	public static long lastTime = 0;

	public static EntityPlayer lightningFrom = null;
	public static EntityPlayer lastLightning = null;

	public static float blipMax = 15;
	public static float blipFrame = blipMax;
	public static boolean isFiring = false;

	public static String lookString = "";
	public static int lookStringPos = 0;
	public static long lookStringNextTime = 0;

	public static long randomCharNextTime = 0;

	@SideOnly(Side.CLIENT)
	public static PSoundBank soundBank;
	@SideOnly(Side.CLIENT)
	public static PGui pgui;
	@SideOnly(Side.CLIENT)
	public static PlayerHelper playerHelper;
	@SideOnly(Side.CLIENT)
	public static RenderHelper renderHelper;

	@SideOnly(Side.CLIENT)
	GuiVehicle guiVehicle;
	@SideOnly(Side.CLIENT)
	RenderJediDefense renderJediDefense;
	@SideOnly(Side.CLIENT)
	RenderSithLightning renderSithLightning;
	
	@SideOnly(Side.CLIENT)
	ModelJediCloak modelCloak;

	@SubscribeEvent
	public void handleConstruction(EntityConstructing event)
	{
		if (event.entity instanceof EntityPlayer)
			event.entity.getDataWatcher().addObject(StarWarsMod.lightningDatawatcherId, String.valueOf(""));
	}

	@SideOnly(Side.CLIENT)
	public void init()
	{
		ClientEventHandler.renderHelper = new RenderHelper(Minecraft.getMinecraft());
		ClientEventHandler.playerHelper = new PlayerHelper(Minecraft.getMinecraft());
		ClientEventHandler.pgui = new PGui(Minecraft.getMinecraft());
		ClientEventHandler.soundBank = new PSoundBank();
		this.renderJediDefense = new RenderJediDefense();
		this.renderSithLightning = new RenderSithLightning();
		this.modelCloak = new ModelJediCloak();
		this.guiVehicle = new GuiVehicle();
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onDrawHand(RenderHandEvent renderHandEvent)
	{
		renderHandEvent.setCanceled(StarWarsMod.isOverlayOnscreen);
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onFogify(EntityViewRenderEvent.FogDensity fogDensity)
	{
		if (fogDensity.entity.worldObj.provider.getDimensionName() == "Dagobah")
		{
			fogDensity.density = 0.075F;
			fogDensity.setCanceled(true);
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onFOVCheck(FOVUpdateEvent fovUpdateEvent)
	{
		ItemStack item = fovUpdateEvent.entity.inventory.getCurrentItem();
		if (item != null && (item.getItem() instanceof ItemBinoculars || item.getItem() instanceof com.parzi.starwarsmod.items.ItemBinocularsHoth) && ItemBinoculars.getEnabled(item) && StarWarsMod.mc.gameSettings.thirdPersonView == 0)
			fovUpdateEvent.newfov = fovUpdateEvent.fov / ItemBinoculars.getZoom(item);
	}

	@SubscribeEvent
	public void onLivingHurt(LivingHurtEvent event)
	{
		if (ForceUtils.activePower != null && event.entityLiving instanceof EntityPlayer)
		{
			if (ForceUtils.activePower.name.equals("defend") && ((PowerDefend)ForceUtils.activePower).isRunning)
			{
				PowerDefend power = (PowerDefend)ForceUtils.activePower;
				if (power.health > event.ammount)
				{
					power.health -= event.ammount;
					event.setCanceled(true);
				}
				else
				{
					event.ammount -= power.health;
					power.health = 0;
					power.isRunning = false;
					power.recharge = power.rechargeTime;
					ForceUtils.coolingPowers.add(power);
				}
			}

			if (ForceUtils.activePower.name.equals("deflect") && ForceUtils.isUsingDuration)
			{
				Entity entityObj = event.source.getEntity();
				if (entityObj instanceof EntityArrow || entityObj instanceof EntityBlasterRifleBolt || entityObj instanceof EntityBlasterHeavyBolt || entityObj instanceof EntityBlasterPistolBolt || entityObj instanceof EntityBlasterProbeBolt || entityObj instanceof EntitySpeederBlasterRifleBolt)
				{
					StarWarsMod.network.sendToServer(new PacketReverseEntity(entityObj.getEntityId(), entityObj.dimension));
					event.ammount = 0;
				}
			}
		}
	}

	@SubscribeEvent
	public void onPlayerInteract(PlayerInteractEvent playerInteractEvent)
	{
		if (playerInteractEvent.entityPlayer.ridingEntity != null && playerInteractEvent.action == net.minecraftforge.event.entity.player.PlayerInteractEvent.Action.RIGHT_CLICK_AIR && playerInteractEvent.entityPlayer.inventory.getCurrentItem() == null)
			if (playerInteractEvent.entityPlayer.ridingEntity instanceof VehicSpeederBike || playerInteractEvent.entityPlayer.ridingEntity instanceof VehicHothSpeederBike)
			{
				StarWarsMod.network.sendToServer(new PacketCreateBlasterBolt(playerInteractEvent.entityPlayer.getCommandSenderName(), playerInteractEvent.world.provider.dimensionId, BlasterBoltType.SPEEDER));
				StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "item.blasterRifle.use", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(playerInteractEvent.world.rand, -0.2D, 0.2D));
			}
			else if (playerInteractEvent.entityPlayer.ridingEntity instanceof VehicXWing || playerInteractEvent.entityPlayer.ridingEntity instanceof VehicAWing)
			{
				StarWarsMod.network.sendToServer(new PacketCreateBlasterBolt(playerInteractEvent.entityPlayer.getCommandSenderName(), playerInteractEvent.world.provider.dimensionId, BlasterBoltType.XWING));
				StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "vehicle.xwing.fire", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(playerInteractEvent.world.rand, -0.2D, 0.2D));
				isFiring = true;
				blipFrame = blipMax;
			}
			else if (playerInteractEvent.entityPlayer.ridingEntity instanceof VehicTIE || playerInteractEvent.entityPlayer.ridingEntity instanceof VehicTIEInterceptor)
			{
				StarWarsMod.network.sendToServer(new PacketCreateBlasterBolt(playerInteractEvent.entityPlayer.getCommandSenderName(), playerInteractEvent.world.provider.dimensionId, BlasterBoltType.TIE));
				StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "vehicle.tie.fire", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(playerInteractEvent.world.rand, -0.2D, 0.2D));
			}
	}

	@SubscribeEvent
	public void onPlayerLogIn(EntityJoinWorldEvent logInEvent)
	{
		if (logInEvent.entity instanceof EntityPlayer && !Resources.VERSION.equalsIgnoreCase(Resources.ONLINE_VERSION) && !StarWarsMod.hasShownNeedUpdate)
		{
			((EntityPlayer)logInEvent.entity).addChatMessage(new ChatComponentText("New version of Parzi's Star Wars Mod available: " + TextUtils.addEffect(Resources.ONLINE_VERSION, Text.COLOR_YELLOW) + "! Current: " + TextUtils.addEffect(Resources.VERSION, Text.COLOR_YELLOW)));
			StarWarsMod.hasShownNeedUpdate = true;
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onRender(RenderLivingEvent.Pre event)
	{
		if (StarWarsMod.mc.thePlayer != null && StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicleAirBase)
		{
			if (ClientEventHandler.renderHelper.isFirstPerson())
			{
				ClientEventHandler.pgui.changeCameraDist(this, 4);

				event.setCanceled(event.entity == StarWarsMod.mc.thePlayer.ridingEntity);
			}
			else
			{
				ClientEventHandler.pgui.changeCameraDist(this, 15);

				event.setCanceled(event.entity.ridingEntity instanceof VehicleAirBase);
			}
		}
		else
			ClientEventHandler.pgui.changeCameraDist(this, 4);
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onRenderGui(RenderGameOverlayEvent.Pre event)
	{
		StarWarsMod.isOverlayOnscreen = false;
		ItemStack item = ClientEventHandler.playerHelper.getHeldItemStack();
		if (ClientEventHandler.renderHelper.isFirstPerson())
		{
			if (item != null && item.getItem() instanceof ItemBinoculars && ItemBinoculars.getEnabled(item))
			{
				StarWarsMod.isOverlayOnscreen = true;
				if (event.type == RenderGameOverlayEvent.ElementType.CROSSHAIRS)
				{
					ResourceLocation guiTexture;
					if (item.getItem() instanceof ItemBinocularsTatooine)
						guiTexture = new ResourceLocation(Resources.MODID, "textures/gui/binoc_style/binoc_style_" + ItemBinoculars.getZoom(item) + ".png");
					else
						guiTexture = new ResourceLocation(Resources.MODID, "textures/gui/binoc_hoth/binoc_hoth_" + ItemBinoculars.getZoom(item) + ".png");
					ClientEventHandler.pgui.renderOverlay(guiTexture);

					if (item.getItem() instanceof ItemBinocularsTatooine)
					{
						event.resolution.getScaledWidth();
						event.resolution.getScaledHeight();

						float textCenterX = event.resolution.getScaledWidth() * (578f / 900F);
						float textCenterY = event.resolution.getScaledHeight() * (355 / 380F);

						Entity e = EntityUtils.rayTrace(100, StarWarsMod.mc.thePlayer, new Entity[0]);

						String s = e == null ? "" : TextUtils.translateAurebesh(e.getCommandSenderName());
						String block = s != "" && lookStringPos < lookString.length() ? "\u2588" : "";

						if (lookString != s)
						{
							lookString = s;
							lookStringPos = 0;
						}
						else if (lookStringNextTime <= System.currentTimeMillis() && lookStringPos < lookString.length())
						{
							lookStringPos++;
							lookStringNextTime = System.currentTimeMillis() + 50;
						}

						FontManager.aurebesh.drawString(s.substring(0, lookStringPos) + block, (int)textCenterX, (int)textCenterY, GlPalette.YELLOW, true);
					}
				}
			}
		}
		
		guiVehicle.onRenderGui(event);

		if (event.isCancelable() && (event.type == RenderGameOverlayEvent.ElementType.CROSSHAIRS || event.type == RenderGameOverlayEvent.ElementType.CHAT || event.type == RenderGameOverlayEvent.ElementType.HELMET || event.type == RenderGameOverlayEvent.ElementType.HOTBAR || event.type == RenderGameOverlayEvent.ElementType.HEALTH || event.type == RenderGameOverlayEvent.ElementType.HEALTHMOUNT || event.type == RenderGameOverlayEvent.ElementType.EXPERIENCE || event.type == RenderGameOverlayEvent.ElementType.FOOD || event.type == RenderGameOverlayEvent.ElementType.ARMOR || event.type == RenderGameOverlayEvent.ElementType.JUMPBAR))
			event.setCanceled(StarWarsMod.isOverlayOnscreen);
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onRenderPlayerSpecial(RenderPlayerEvent.Specials.Post event)
	{
		if (event.entityPlayer.inventory.armorItemInSlot(2) != null && event.entityPlayer.inventory.armorItemInSlot(2).getItem() == StarWarsMod.jediRobes)
		{
			GL11.glPushMatrix();
			GL11.glTranslatef(0.0F, -0.25F, 0.125F);
			double d3 = event.entityPlayer.field_71091_bM + (event.entityPlayer.field_71094_bP - event.entityPlayer.field_71091_bM) * event.partialRenderTick - (event.entityPlayer.prevPosX + (event.entityPlayer.posX - event.entityPlayer.prevPosX) * event.partialRenderTick);
			double d4 = event.entityPlayer.field_71096_bN + (event.entityPlayer.field_71095_bQ - event.entityPlayer.field_71096_bN) * event.partialRenderTick - (event.entityPlayer.prevPosY + (event.entityPlayer.posY - event.entityPlayer.prevPosY) * event.partialRenderTick);
			double d0 = event.entityPlayer.field_71097_bO + (event.entityPlayer.field_71085_bR - event.entityPlayer.field_71097_bO) * event.partialRenderTick - (event.entityPlayer.prevPosZ + (event.entityPlayer.posZ - event.entityPlayer.prevPosZ) * event.partialRenderTick);
			float f4 = event.entityPlayer.prevRenderYawOffset + (event.entityPlayer.renderYawOffset - event.entityPlayer.prevRenderYawOffset) * event.partialRenderTick;
			double d1 = MathHelper.sin(f4 * (float)Math.PI / 180.0F);
			double d2 = -MathHelper.cos(f4 * (float)Math.PI / 180.0F);
			float f5 = (float)d4 * 10.0F;

			if (f5 < -6.0F)
				f5 = -6.0F;

			if (f5 > 32.0F)
				f5 = 32.0F;

			float f6 = (float)(d3 * d1 + d0 * d2) * 100.0F;
			float f7 = (float)(d3 * d2 - d0 * d1) * 100.0F;

			if (f6 < 0.0F)
				f6 = 0.0F;

			float f8 = event.entityPlayer.prevCameraYaw + (event.entityPlayer.cameraYaw - event.entityPlayer.prevCameraYaw) * event.partialRenderTick;
			f5 += MathHelper.sin((event.entityPlayer.prevDistanceWalkedModified + (event.entityPlayer.distanceWalkedModified - event.entityPlayer.prevDistanceWalkedModified) * event.partialRenderTick) * 6.0F) * 32.0F * f8;

			if (event.entityPlayer.isSneaking())
				f5 += 25.0F;
			
			f6 *= 1.8f;

			GL11.glRotatef(6.0F + f6 / 2.0F + f5, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(f7 / 2.0F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(-f7 / 2.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
			GL11.glScalef(1, 1, 1);
			StarWarsMod.mc.getTextureManager().bindTexture(Resources.capeTexture);
			// rp.modelBipedMain.renderCloak(0.0625F);
			this.modelCloak.renderCape(0.0625F);
			GL11.glPopMatrix();
		}
	}

	@SubscribeEvent
	public void onXpPickup(PlayerPickupXpEvent event)
	{
		if (event.entityPlayer.inventory.armorItemInSlot(2) != null && event.entityPlayer.inventory.armorItemInSlot(2).getItem() == StarWarsMod.jediRobes)
			event.entityPlayer.inventory.armorInventory[2] = ArmorJediRobes.addLevels(event.entityPlayer.inventory.armorItemInSlot(2), 1);
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void renderWorldLastEvent(RenderWorldLastEvent event)
	{
		if (ForceUtils.activePower != null && ForceUtils.activePower.name.equals("lightning") && ForceUtils.isUsingDuration)
		{
			PowerLightning power = (PowerLightning)ForceUtils.activePower;

			if (power.duration >= power.getDuration())
				return;

			Entity e = EntityUtils.rayTrace(power.getRange(), StarWarsMod.mc.thePlayer, new Entity[0]);
			power.setTarget(e);

			if (e != null)
			{
				Random r = new Random(e.ticksExisted * 4);
				float posX2 = (float)e.posX;
				float posY2 = (float)e.posY + 2;
				float posZ2 = (float)e.posZ;
				for (int i = 0; i < 4; i++)
				{
					posX2 += (r.nextFloat() - 0.5f) * (e.boundingBox.maxX - e.posX) - (e.boundingBox.maxX - e.posX) / 2;
					posY2 += (r.nextFloat() - 0.5f) * (e.boundingBox.maxY - e.posY) - (e.boundingBox.maxY - e.posY) / 2;
					posZ2 += (r.nextFloat() - 0.5f) * (e.boundingBox.maxZ - e.posZ) - (e.boundingBox.maxZ - e.posZ) / 2;

					this.renderSithLightning.render(r, (float)StarWarsMod.mc.thePlayer.posX - 0.5f, (float)StarWarsMod.mc.thePlayer.posY - 1, (float)StarWarsMod.mc.thePlayer.posZ - 0.5f, posX2, posY2, posZ2, 8, 0.15f);
				}
			}
		}

		this.renderJediDefense.onWorldRender(event);

		this.renderSithLightning.onWorldRender(event);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\handlers\StarWarsEventHandler.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */