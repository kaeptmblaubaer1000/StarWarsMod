package com.parzivail.pswm.gui;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.items.ItemQuestLog;
import com.parzivail.pswm.mobs.MobDroidAstromech;
import com.parzivail.pswm.mobs.MobDroidAstromech2;
import com.parzivail.pswm.mobs.MobDroidProtocol;
import com.parzivail.pswm.mobs.trooper.MobDefaultBiped;
import com.parzivail.pswm.network.MessagePlayerBuyItem;
import com.parzivail.pswm.quest.QuestBank;
import com.parzivail.pswm.quest.QuestUtils;
import com.parzivail.pswm.tileentities.*;
import com.parzivail.pswm.vehicles.VehicAWing;
import com.parzivail.pswm.vehicles.VehicSnowspeeder;
import com.parzivail.pswm.vehicles.VehicXWing;
import com.parzivail.pswm.vehicles.VehicYWing;
import com.parzivail.util.ui.*;
import com.parzivail.util.vehicle.VehicleAirBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@SideOnly(Side.CLIENT)
public class GuiScreenQuartermaster extends GuiScreen
{
	private EntityPlayer player;
	private static final ResourceLocation background = new ResourceLocation(Resources.MODID, "textures/gui/space.png");

	private OutlineButton bTabArmor;
	private OutlineButton bTabWeapons;
	private OutlineButton bTabShips;
	private OutlineButton bTabMisc;

	private Map<String, OutlineButton> listBArmor;
	private Map<String, OutlineButton> listBWeapons;
	private Map<String, OutlineButton> listBShips;
	private Map<String, OutlineButton> listBMisc;

	private ItemStack stackShowing;
	private Entity entityShowing;
	private TileEntity tileShowing;
	private ItemRenderer renderItem = RenderManager.instance.itemRenderer;
	private TileEntityStaticNpc staticNpc;

	private String showingTitle = "";
	private String showingDesc = "";

	Consumer<OutlineButton> fixA280;
	Consumer<OutlineButton> fixDefender;
	Consumer<OutlineButton> fixDl21;
	Consumer<OutlineButton> fixDh17;
	Consumer<OutlineButton> fixXwing;
	Consumer<OutlineButton> fixAwing;
	Consumer<OutlineButton> fixYwing;
	Consumer<OutlineButton> fixT47;
	Consumer<OutlineButton> fixTarget;
	Consumer<OutlineButton> fixGunRack;
	Consumer<OutlineButton> fixAntenna;
	Consumer<OutlineButton> fixHolotable;
	Consumer<OutlineButton> fixBacta;
	Consumer<OutlineButton> fixItem;
	Consumer<OutlineButton> currentFix = null;

	private OutlineButtonCreditCounter bBuy;
	private ItemStack[] buyItemStacks;

	public GuiScreenQuartermaster(EntityPlayer player, TileEntityStaticNpc tileEntity)
	{
		this.staticNpc = tileEntity;
		this.mc = Minecraft.getMinecraft();
		this.player = player;
	}

	@Override
	public void initGui()
	{
		stackShowing = null;
		entityShowing = null;

		int id = 0;
		int xTab = -40;
		bTabArmor = new OutlineButton(id++, xTab += 50, 10, 40, 20, LangUtils.translate("armor"), false);
		bTabWeapons = new OutlineButton(id++, xTab += 50, 10, 40, 20, LangUtils.translate("guns"), false);
		bTabShips = new OutlineButton(id++, xTab += 50, 10, 40, 20, LangUtils.translate("ships"), false);
		bTabMisc = new OutlineButton(id++, xTab += 50, 10, 40, 20, LangUtils.translate("misc"), false);

		ScaledResolution r = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		bBuy = new OutlineButtonCreditCounter(id++, r.getScaledWidth() - 100, 10, 80, 20, player);
		buttonList.add(bBuy);

		buttonList.add(bTabArmor);
		buttonList.add(bTabWeapons);
		buttonList.add(bTabShips);
		buttonList.add(bTabMisc);

		listBArmor = new HashMap<>();
		listBWeapons = new HashMap<>();
		listBShips = new HashMap<>();
		listBMisc = new HashMap<>();

		int x = 0;
		int y = 0;

		fixItem = outlineButton ->
		{
			if (outlineButton != null)
				GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 30f, 50);
			else
			{
				P3D.glScalef(0.75f);
				GL11.glTranslatef(-1, -4, 0);
			}
			GL11.glTranslatef(0, 12, 0);
			GL11.glRotatef((System.currentTimeMillis() / (outlineButton == null ? 30 : 15)) % 360, 0, 1, 0);
			GL11.glTranslatef(-14, 0, -1);
			P3D.glScalef(24f);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(90, 0, 1, 0);
			GL11.glRotatef(45, 0, 1, 0);
			GL11.glRotatef(18, 1, 0, 0);
			GL11.glRotatef(18, 0, 0, 1);
			GL11.glRotatef(-1, 0, 0, 1);
			GL11.glRotatef(-2, 0, 1, 0);
		};

		Consumer<OutlineButton> preRenderArmorButton = outlineButton ->
		{
			GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 3f, 50);
			P3D.glScalef(23.25f);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(10, 1, 0, 0);
			GL11.glRotatef((System.currentTimeMillis() / 15) % 360, 0, 1, 0);
		};

		Consumer<OutlineButton> postRenderEmpty = outlineButton ->
		{
		};

		OutlineButtonEntity bArmorEndor = new OutlineButtonEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		MobDefaultBiped bipedEndor = new MobDefaultBiped(player.worldObj);
		QuestUtils.arm(bipedEndor, Resources.armors[2]);
		bArmorEndor.setup(bipedEndor, preRenderArmorButton, postRenderEmpty);
		bArmorEndor.enabled = ItemQuestLog.isQuestDone(player, QuestBank.rebel0) || player.capabilities.isCreativeMode;
		listBArmor.put("bArmorEndor", bArmorEndor);

		OutlineButtonEntity bArmorHoth = new OutlineButtonEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		MobDefaultBiped bipedHoth = new MobDefaultBiped(player.worldObj);
		QuestUtils.arm(bipedHoth, Resources.armors[1]);
		bArmorHoth.setup(bipedHoth, preRenderArmorButton, postRenderEmpty);
		bArmorHoth.enabled = ItemQuestLog.isQuestDone(player, QuestBank.rebel3) || player.capabilities.isCreativeMode;
		listBArmor.put("bArmorHoth", bArmorHoth);

		x = 0;
		y++;

		OutlineButtonEntity bArmorXPilot = new OutlineButtonEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		MobDefaultBiped bipedXwing = new MobDefaultBiped(player.worldObj);
		QuestUtils.arm(bipedXwing, Resources.armors[0]);
		bArmorXPilot.setup(bipedXwing, preRenderArmorButton, postRenderEmpty);
		bArmorXPilot.enabled = ItemQuestLog.isQuestDone(player, QuestBank.rebel8_Yavin) || player.capabilities.isCreativeMode;
		listBArmor.put("bArmorXPilot", bArmorXPilot);

		OutlineButtonEntity bArmorYPilot = new OutlineButtonEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		MobDefaultBiped bipedYwing = new MobDefaultBiped(player.worldObj);
		QuestUtils.arm(bipedYwing, Resources.armors[10]);
		bArmorYPilot.setup(bipedYwing, preRenderArmorButton, postRenderEmpty);
		bArmorYPilot.enabled = ItemQuestLog.isQuestDone(player, QuestBank.rebel9) || player.capabilities.isCreativeMode;
		listBArmor.put("bArmorYPilot", bArmorYPilot);

		x = 0;
		y++;

		OutlineButtonEntity bArmorAPilot = new OutlineButtonEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		MobDefaultBiped bipedAwing = new MobDefaultBiped(player.worldObj);
		QuestUtils.arm(bipedAwing, Resources.armors[9]);
		bArmorAPilot.setup(bipedAwing, preRenderArmorButton, postRenderEmpty);
		bArmorAPilot.enabled = ItemQuestLog.isQuestDone(player, QuestBank.rebel9) || player.capabilities.isCreativeMode;
		listBArmor.put("bArmorAPilot", bArmorAPilot);

		x = 0;
		y = 0;

		OutlineButtonItemStack bGunA280 = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bGunA280.setup(new ItemStack(StarWarsItems.blasterRifle, 1, 0), fixA280 = outlineButton ->
		{
			if (outlineButton != null)
				GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 30f, 50);
			P3D.glScalef(18f);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(10, 1, 0, 0);
			GL11.glRotatef((System.currentTimeMillis() / (outlineButton == null ? 30 : 15)) % 360, 0, 1, 0);
			GL11.glTranslatef(0.51f, 0, 0.75f);
		}, postRenderEmpty);
		bGunA280.enabled = ItemQuestLog.isQuestDone(player, QuestBank.rebel1) || player.capabilities.isCreativeMode;
		listBWeapons.put("bGunA280", bGunA280);

		OutlineButtonItemStack bGunDh17 = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bGunDh17.setup(new ItemStack(StarWarsItems.blasterPistol, 1, 2), fixDh17 = outlineButton ->
		{
			if (outlineButton != null)
				GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 30f, 50);
			else
				GL11.glTranslatef(0, -4, 0);
			GL11.glTranslatef(0, 3, 0);
			P3D.glScalef(24f);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(10, 1, 0, 0);
			GL11.glRotatef((System.currentTimeMillis() / (outlineButton == null ? 30 : 15)) % 360 - 180, 0, 1, 0);
			GL11.glTranslatef(0.4f, 0, 0.3f);
		}, postRenderEmpty);
		bGunDh17.enabled = ItemQuestLog.isQuestDone(player, QuestBank.rebel3) || player.capabilities.isCreativeMode;
		listBWeapons.put("bGunDh17", bGunDh17);

		x = 0;
		y++;

		OutlineButtonItemStack bGunDefender = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bGunDefender.setup(new ItemStack(StarWarsItems.blasterPistol, 1, 3), fixDefender = outlineButton ->
		{
			if (outlineButton != null)
				GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 30f, 50);
			P3D.glScalef(22f);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(10, 1, 0, 0);
			GL11.glRotatef((System.currentTimeMillis() / (outlineButton == null ? 30 : 15)) % 360, 0, 1, 0);
			GL11.glTranslatef(0.51f, 0, -0.3f);
			GL11.glRotatef(90, 0, 1, 0);
		}, postRenderEmpty);
		bGunDefender.enabled = ItemQuestLog.isQuestDone(player, QuestBank.rebel8_Yavin) || player.capabilities.isCreativeMode;
		listBWeapons.put("bGunDefender", bGunDefender);

		OutlineButtonItemStack bGunDl21 = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bGunDl21.setup(new ItemStack(StarWarsItems.blasterPistol, 1, 4), fixDl21 = outlineButton ->
		{
			if (outlineButton != null)
				GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 30f, 50);
			P3D.glScalef(27f);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(10, 1, 0, 0);
			GL11.glRotatef((System.currentTimeMillis() / (outlineButton == null ? 30 : 15)) % 360, 0, 1, 0);
			GL11.glTranslatef(0.51f, 0, -0.5f);
			GL11.glRotatef(90, 0, 1, 0);
		}, postRenderEmpty);
		bGunDl21.enabled = ItemQuestLog.isQuestDone(player, QuestBank.rebel4) || player.capabilities.isCreativeMode;
		listBWeapons.put("bGunDl21", bGunDl21);

		x = 0;
		y = 0;

		Consumer<OutlineButton> preRenderShips = outlineButton ->
		{
			if (outlineButton != null)
				GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 35f, 50);
			P3D.glScalef(3.5f);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(30, 1, 0, 0);
			GL11.glRotatef((System.currentTimeMillis() / 15) % 360, 0, 1, 0);
		};

		OutlineButtonEntity bShipXwing = new OutlineButtonEntity(id++, x++ * 100 + 10, y * 100 + 40, 90, 90);
		VehicXWing xwing = new VehicXWing(player.worldObj);
		bShipXwing.setup(xwing, fixXwing = outlineButton ->
		{
			P3D.glScalef(1.2f);
			GL11.glTranslatef(-7.5f, -10, 0);
			preRenderShips.accept(outlineButton);
		}, postRenderEmpty);
		listBShips.put("bShipXwing", bShipXwing);

		OutlineButtonEntity bShipYwing = new OutlineButtonEntity(id++, x++ * 100 + 10, y * 100 + 40, 90, 90);
		VehicYWing ywing = new VehicYWing(player.worldObj);
		bShipYwing.setup(ywing, fixYwing = outlineButton ->
		{
			if (outlineButton != null)
				GL11.glTranslatef(0, -3f, 0);
			preRenderShips.accept(outlineButton);
			if (outlineButton != null)
				GL11.glTranslatef(0, 0, 5);
		}, postRenderEmpty);
		listBShips.put("bShipYwing", bShipYwing);

		x = 0;
		y++;

		OutlineButtonEntity bShipAwing = new OutlineButtonEntity(id++, x++ * 100 + 10, y * 100 + 40, 90, 90);
		VehicAWing awing = new VehicAWing(player.worldObj);
		bShipAwing.setup(awing, fixAwing = outlineButton ->
		{
			P3D.glScalef(2.3f);
			if (outlineButton != null)
				GL11.glTranslatef(-25.5f, -30, 0);
			preRenderShips.accept(outlineButton);
		}, postRenderEmpty);
		listBShips.put("bShipAwing", bShipAwing);

		OutlineButtonEntity bShipT47 = new OutlineButtonEntity(id++, x++ * 100 + 10, y * 100 + 40, 90, 90);
		VehicSnowspeeder t47 = new VehicSnowspeeder(player.worldObj);
		bShipT47.setup(t47, fixT47 = outlineButton ->
		{
			P3D.glScalef(2.3f);
			if (outlineButton != null)
				GL11.glTranslatef(-25.5f, -32, 0);
			preRenderShips.accept(outlineButton);
		}, postRenderEmpty);
		listBShips.put("bShipT47", bShipT47);

		x = 0;
		y = 0;

		OutlineButtonTileEntity bMiscTarget = new OutlineButtonTileEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bMiscTarget.setup(new TileEntityTarget(), fixTarget = outlineButton ->
		{
			if (outlineButton != null)
				GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 27f, 50);
			GL11.glTranslatef(0, 22, 0);
			P3D.glScalef(22f);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(10, 1, 0, 0);
			GL11.glRotatef((System.currentTimeMillis() / (outlineButton == null ? 30 : 15)) % 360, 0, 1, 0);
		}, postRenderEmpty);
		bMiscTarget.enabled = ItemQuestLog.isQuestDone(player, QuestBank.rebel0) || player.capabilities.isCreativeMode;
		listBMisc.put("bMiscTarget", bMiscTarget);

		OutlineButtonTileEntity bMiscGunRack = new OutlineButtonTileEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bMiscGunRack.setup(new TileEntityGunRack(), fixGunRack = outlineButton ->
		{
			if (outlineButton != null)
				GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 27f, 50);
			GL11.glTranslatef(0, 20, 0);
			P3D.glScalef(22f);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(10, 1, 0, 0);
			GL11.glRotatef((System.currentTimeMillis() / (outlineButton == null ? 30 : 15)) % 360, 0, 1, 0);
		}, postRenderEmpty);
		bMiscGunRack.enabled = ItemQuestLog.isQuestDone(player, QuestBank.rebel0) || player.capabilities.isCreativeMode;
		listBMisc.put("bMiscGunRack", bMiscGunRack);

		OutlineButtonItemStack bHEndor = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bHEndor.setup(new ItemStack(StarWarsItems.hyperdriveEndor), fixItem, postRenderEmpty, false, player);
		bHEndor.enabled = ItemQuestLog.isQuestDone(player, QuestBank.rebel6) || player.capabilities.isCreativeMode;
		listBMisc.put("bHEndor", bHEndor);

		x = 0;
		y++;

		OutlineButtonTileEntity bMiscAntenna = new OutlineButtonTileEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bMiscAntenna.setup(new TileEntityAntenna(), fixAntenna = outlineButton ->
		{
			if (outlineButton != null)
				GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 27f, 50);
			GL11.glTranslatef(0, 20, 0);
			P3D.glScalef(18f);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(10, 1, 0, 0);
			GL11.glRotatef((System.currentTimeMillis() / (outlineButton == null ? 30 : 15)) % 360 + 90, 0, 1, 0);
			GL11.glTranslatef(0, 0, 0.5f);
		}, postRenderEmpty);
		bMiscAntenna.enabled = ItemQuestLog.isQuestDone(player, QuestBank.rebel6) || player.capabilities.isCreativeMode;
		listBMisc.put("bMiscAntenna", bMiscAntenna);

		OutlineButtonTileEntity bMiscBacta = new OutlineButtonTileEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bMiscBacta.setup(new TileEntityBactaTank(), fixBacta = outlineButton ->
		{
			if (outlineButton != null)
				GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 27f, 50);
			GL11.glTranslatef(0, 20, 0);
			P3D.glScalef(10.5f);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(10, 1, 0, 0);
			GL11.glRotatef((System.currentTimeMillis() / (outlineButton == null ? 30 : 15)) % 360 + 90, 0, 1, 0);
		}, postRenderEmpty);
		bMiscBacta.enabled = ItemQuestLog.isQuestDone(player, QuestBank.rebel6) || player.capabilities.isCreativeMode;
		listBMisc.put("bMiscBacta", bMiscBacta);

		OutlineButtonItemStack bHHoth = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bHHoth.setup(new ItemStack(StarWarsItems.hyperdriveHoth), fixItem, postRenderEmpty, false, player);
		bHHoth.enabled = ItemQuestLog.isQuestDone(player, QuestBank.rebel3) || player.capabilities.isCreativeMode;
		listBMisc.put("bHHoth", bHHoth);

		x = 0;
		y++;

		Consumer<OutlineButton> preRenderDroidsButton = outlineButton ->
		{
			GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 3f, 50);
			if (outlineButton instanceof OutlineButtonEntity && !(((OutlineButtonEntity)outlineButton).entity instanceof MobDroidProtocol))
				GL11.glTranslatef(0, -4, 0);
			P3D.glScalef(23.25f);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(10, 1, 0, 0);
			GL11.glRotatef((System.currentTimeMillis() / 15) % 360, 0, 1, 0);
		};

		OutlineButtonEntity bDroidAstromech = new OutlineButtonEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bDroidAstromech.setup(new MobDroidAstromech(player.worldObj), preRenderDroidsButton, postRenderEmpty);
		bDroidAstromech.enabled = ItemQuestLog.isQuestDone(player, QuestBank.rebel8_Yavin) || player.capabilities.isCreativeMode;
		listBMisc.put("bDroidAstromech", bDroidAstromech);

		OutlineButtonEntity bDroidAstromech2 = new OutlineButtonEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bDroidAstromech2.setup(new MobDroidAstromech2(player.worldObj), preRenderDroidsButton, postRenderEmpty);
		bDroidAstromech2.enabled = ItemQuestLog.isQuestDone(player, QuestBank.rebel8_Yavin) || player.capabilities.isCreativeMode;
		listBMisc.put("bDroidAstromech2", bDroidAstromech2);

		OutlineButtonItemStack bHSpace = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bHSpace.setup(new ItemStack(StarWarsItems.hyperdriveSpace), fixItem, postRenderEmpty, false, player);
		bHSpace.enabled = ItemQuestLog.isQuestDone(player, QuestBank.rebel8_Yavin) || player.capabilities.isCreativeMode;
		listBMisc.put("bHSpace", bHSpace);

		setTabArmor();
	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if (button.enabled && button.visible)
		{
			if (button.id == bTabArmor.id)
			{
				setTabArmor();
			}
			else if (button.id == bTabWeapons.id)
			{
				setTabGuns();
			}
			else if (button.id == bTabShips.id)
			{
				setTabShips();
			}
			else if (button.id == bTabMisc.id)
			{
				setTabMisc();
			}
			else if (button.id == bBuy.id && bBuy.getCurrentCost() != -1)
			{
				StarWarsMod.network.sendToServer(new MessagePlayerBuyItem(player, buyItemStacks, bBuy.getCurrentCost()));
			}
			else if (button.id == listBArmor.get("bArmorEndor").id)
			{
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBArmor.get("bArmorEndor")).entity;

				showingTitle = "Rebel Forest Gear";
				showingDesc = "Hidey";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.endorHelmet, 1), new ItemStack(StarWarsItems.endorChest, 1), new ItemStack(StarWarsItems.endorLegs, 1), new ItemStack(StarWarsItems.endorBoots, 1) };
			}
			else if (button.id == listBArmor.get("bArmorHoth").id)
			{
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBArmor.get("bArmorHoth")).entity;

				showingTitle = "Rebel Low Temperature Gear";
				showingDesc = "freezy";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.hothHelmet, 1), new ItemStack(StarWarsItems.hothChest, 1), new ItemStack(StarWarsItems.hothLegs, 1), new ItemStack(StarWarsItems.hothBoots, 1) };

			}
			else if (button.id == listBArmor.get("bArmorXPilot").id)
			{
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBArmor.get("bArmorXPilot")).entity;

				showingTitle = "Rebel X-Wing Pilot Jumpsuit";
				showingDesc = "fly-y";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.rebelPilotHelmet, 1), new ItemStack(StarWarsItems.rebelPilotChest, 1), new ItemStack(StarWarsItems.rebelPilotLegs, 1), new ItemStack(StarWarsItems.rebelPilotBoots, 1) };
			}
			else if (button.id == listBArmor.get("bArmorYPilot").id)
			{
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBArmor.get("bArmorYPilot")).entity;

				showingTitle = "Rebel Y-Wing Pilot Jumpsuit";
				showingDesc = "bomby";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.rebelYPilotHelmet, 1), new ItemStack(StarWarsItems.rebelYPilotChest, 1), new ItemStack(StarWarsItems.rebelYPilotLegs, 1), new ItemStack(StarWarsItems.rebelYPilotBoots, 1) };
			}
			else if (button.id == listBArmor.get("bArmorAPilot").id)
			{
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBArmor.get("bArmorAPilot")).entity;

				showingTitle = "Rebel A-Wing Pilot Jumpsuit";
				showingDesc = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.rebelAPilotHelmet, 1), new ItemStack(StarWarsItems.rebelAPilotChest, 1), new ItemStack(StarWarsItems.rebelAPilotLegs, 1), new ItemStack(StarWarsItems.rebelAPilotBoots, 1) };
			}
			else if (button.id == listBWeapons.get("bGunA280").id)
			{
				currentFix = fixA280;
				stackShowing = ((OutlineButtonItemStack)listBWeapons.get("bGunA280")).itemStack;
				entityShowing = null;
				tileShowing = null;

				showingTitle = "BlasTech A-280C Blaster Rifle";
				showingDesc = "shooty";

				bBuy.setCurrentCost(32);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.blasterRifle, 1, 0) };
			}
			else if (button.id == listBWeapons.get("bGunDefender").id)
			{
				currentFix = outlineButton ->
				{
					GL11.glTranslatef(0, -6, 0);
					fixDefender.accept(outlineButton);
				};
				stackShowing = ((OutlineButtonItemStack)listBWeapons.get("bGunDefender")).itemStack;
				entityShowing = null;
				tileShowing = null;

				showingTitle = "DDC Defender Sporting Pistol";
				showingDesc = "pew pew";
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.blasterPistol, 1, 3) };

				bBuy.setCurrentCost(24);
			}
			else if (button.id == listBWeapons.get("bGunDl21").id)
			{
				currentFix = outlineButton ->
				{
					GL11.glTranslatef(0, -6, 0);
					fixDl21.accept(outlineButton);
				};
				stackShowing = ((OutlineButtonItemStack)listBWeapons.get("bGunDl21")).itemStack;
				entityShowing = null;
				tileShowing = null;

				showingTitle = "BlasTech DL-21 Blaster Pistol";
				showingDesc = "shooty mc'booty";

				bBuy.setCurrentCost(24);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.blasterPistol, 1, 4) };
			}
			else if (button.id == listBWeapons.get("bGunDh17").id)
			{
				currentFix = fixDh17;
				stackShowing = ((OutlineButtonItemStack)listBWeapons.get("bGunDh17")).itemStack;
				entityShowing = null;
				tileShowing = null;

				showingTitle = "dh17";
				showingDesc = "shooty mc'booty";

				bBuy.setCurrentCost(24);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.blasterPistol, 1, 2) };
			}
			else if (button.id == listBShips.get("bShipXwing").id)
			{
				currentFix = fixXwing;
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBShips.get("bShipXwing")).entity;

				showingTitle = "Incom T-65 X-Wing Starfighter";
				showingDesc = "BAD-X (R)";

				bBuy.setCurrentCost(-1);
			}
			else if (button.id == listBShips.get("bShipYwing").id)
			{
				currentFix = fixYwing;
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBShips.get("bShipYwing")).entity;

				showingTitle = "BTL Y-Wing Bomber";
				showingDesc = "boom";

				bBuy.setCurrentCost(-1);
			}
			else if (button.id == listBShips.get("bShipAwing").id)
			{
				currentFix = fixAwing;
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBShips.get("bShipAwing")).entity;

				showingTitle = "RZ-1 A-Wing Interceptor";
				showingDesc = "double pew";

				bBuy.setCurrentCost(-1);
			}
			else if (button.id == listBShips.get("bShipT47").id)
			{
				currentFix = fixT47;
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBShips.get("bShipT47")).entity;

				showingTitle = "Incom T-47 Snowspeeder";
				showingDesc = "cold";

				bBuy.setCurrentCost(-1);
			}
			else if (button.id == listBMisc.get("bMiscTarget").id)
			{
				currentFix = fixTarget;
				stackShowing = null;
				entityShowing = null;
				tileShowing = ((OutlineButtonTileEntity)listBMisc.get("bMiscTarget")).tileEntity;

				showingTitle = "Target";
				showingDesc = "aim better than a stormtrooper, at least";

				bBuy.setCurrentCost(16);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsMod.blockTarget, 1) };
			}
			else if (button.id == listBMisc.get("bMiscGunRack").id)
			{
				currentFix = fixGunRack;
				stackShowing = null;
				entityShowing = null;
				tileShowing = ((OutlineButtonTileEntity)listBMisc.get("bMiscGunRack")).tileEntity;

				showingTitle = "Gun Rack";
				showingDesc = "store yo guns";

				bBuy.setCurrentCost(32);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsMod.blockGunRack, 1) };
			}
			else if (button.id == listBMisc.get("bMiscAntenna").id)
			{
				currentFix = fixAntenna;
				stackShowing = null;
				entityShowing = null;
				tileShowing = ((OutlineButtonTileEntity)listBMisc.get("bMiscAntenna")).tileEntity;

				showingTitle = "Antenna";
				showingDesc = "listeny";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsMod.blockAntenna, 1) };
			}
			else if (button.id == listBMisc.get("bMiscBacta").id)
			{
				currentFix = fixBacta;
				stackShowing = null;
				entityShowing = null;
				tileShowing = ((OutlineButtonTileEntity)listBMisc.get("bMiscBacta")).tileEntity;

				showingTitle = "Bacta Tank";
				showingDesc = "healy";

				bBuy.setCurrentCost(128);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsMod.blockBactaTank, 1) };
			}
			else if (button.id == listBMisc.get("bDroidAstromech").id)
			{
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBMisc.get("bDroidAstromech")).entity;

				showingTitle = "R2-Series Astromech Droid";
				showingDesc = "beep";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.spawnAstromech, 1) };
			}
			else if (button.id == listBMisc.get("bDroidAstromech2").id)
			{
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBMisc.get("bDroidAstromech2")).entity;

				showingTitle = "R5-Series Astromech Droid";
				showingDesc = "boop";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.spawnAstromech2, 1) };
			}
			else if (button.id == listBMisc.get("bHHoth").id)
			{
				currentFix = fixItem;
				tileShowing = null;
				entityShowing = null;
				stackShowing = ((OutlineButtonItemStack)listBMisc.get("bHHoth")).itemStack;

				showingTitle = "hoth";
				showingDesc = "2QR3qertag80[ohihofhg";

				bBuy.setCurrentCost(0);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.hyperdriveHoth, 1) };
			}
			else if (button.id == listBMisc.get("bHSpace").id)
			{
				currentFix = fixItem;
				tileShowing = null;
				entityShowing = null;
				stackShowing = ((OutlineButtonItemStack)listBMisc.get("bHSpace")).itemStack;

				showingTitle = "space";
				showingDesc = "dobuipsfh;bskjdfbnskjbg";

				bBuy.setCurrentCost(0);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.hyperdriveSpace, 1) };
			}
			else if (button.id == listBMisc.get("bHEndor").id)
			{
				currentFix = fixItem;
				tileShowing = null;
				entityShowing = null;
				stackShowing = ((OutlineButtonItemStack)listBMisc.get("bHEndor")).itemStack;

				showingTitle = "endor";
				showingDesc = "theoforestmoon";

				bBuy.setCurrentCost(0);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.hyperdriveEndor, 1) };
			}
		}
	}

	private void setTabArmor()
	{
		bTabArmor.selected = true;
		bTabWeapons.selected = false;
		bTabShips.selected = false;
		bTabMisc.selected = false;

		buttonList.addAll(listBArmor.values());
		buttonList.removeAll(listBWeapons.values());
		buttonList.removeAll(listBShips.values());
		buttonList.removeAll(listBMisc.values());
	}

	private void setTabGuns()
	{
		bTabArmor.selected = false;
		bTabWeapons.selected = true;
		bTabShips.selected = false;
		bTabMisc.selected = false;

		buttonList.removeAll(listBArmor.values());
		buttonList.addAll(listBWeapons.values());
		buttonList.removeAll(listBShips.values());
		buttonList.removeAll(listBMisc.values());
	}

	private void setTabShips()
	{
		bTabArmor.selected = false;
		bTabWeapons.selected = false;
		bTabShips.selected = true;
		bTabMisc.selected = false;

		buttonList.removeAll(listBArmor.values());
		buttonList.removeAll(listBWeapons.values());
		buttonList.addAll(listBShips.values());
		buttonList.removeAll(listBMisc.values());
	}

	private void setTabMisc()
	{
		bTabArmor.selected = false;
		bTabWeapons.selected = false;
		bTabShips.selected = false;
		bTabMisc.selected = true;

		buttonList.removeAll(listBArmor.values());
		buttonList.removeAll(listBWeapons.values());
		buttonList.removeAll(listBShips.values());
		buttonList.addAll(listBMisc.values());
	}

	public void drawBg2()
	{
		Tessellator tessellator = Tessellator.instance;
		this.mc.getTextureManager().bindTexture(background);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		float f = 200.0F;
		tessellator.startDrawingQuads();
		tessellator.setColorOpaque_I(0xFFFFFFFF);
		tessellator.addVertexWithUV(0.0D, this.height, 0.0D, 0.0D, this.height / f + 1);
		tessellator.addVertexWithUV(this.width, this.height, 0.0D, this.width / f, this.height / f + 1);
		tessellator.addVertexWithUV(this.width, 0.0D, 0.0D, this.width / f, 1);
		tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 1);
		tessellator.draw();
	}

	@Override
	public void drawScreen(int mX, int mY, float p)
	{
		this.drawBg2();

		if (stackShowing != null)
		{
			GL11.glPushMatrix();

			GFX.drawCenteredText(mc.fontRenderer, showingTitle, 320, 165, 1.5f, GLPalette.SW_YELLOW);

			String[] lines = TextUtils.splitIntoLine(showingDesc, 45);
			int i = 0;
			for (String line : lines)
			{
				GFX.drawCenteredText(mc.fontRenderer, line, 320, 185 + i * 12, 1f, GLPalette.WHITE);
				i++;
			}

			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glEnable(GL11.GL_LIGHTING);
			RenderHelper.enableStandardItemLighting();

			GLPalette.glColorI(GLPalette.WHITE);

			GL11.glTranslatef(320, 90, 200);

			P3D.glScalef(5);

			if (currentFix != null)
				currentFix.accept(null);

			renderItem.renderItem(player, stackShowing, 0, ItemRenderType.ENTITY);

			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_TEXTURE_2D);

			GL11.glPopMatrix();
		}
		else if (entityShowing != null)
		{
			GL11.glPushMatrix();

			GL11.glPushMatrix();
			if (entityShowing instanceof VehicleAirBase)
			{
				GL11.glTranslatef(0, -30, 0);
			}

			GFX.drawCenteredText(mc.fontRenderer, showingTitle, 330, 170, 1.5f, GLPalette.SW_YELLOW);

			String[] lines = TextUtils.splitIntoLine(showingDesc, 45);
			int i = 0;
			for (String line : lines)
			{
				GFX.drawCenteredText(mc.fontRenderer, line, 330, 190 + i * 12, 1f, GLPalette.WHITE);
				i++;
			}
			GL11.glPopMatrix();

			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glEnable(GL11.GL_LIGHTING);
			RenderHelper.enableStandardItemLighting();

			GLPalette.glColorI(GLPalette.WHITE);

			GL11.glTranslatef(330, 160, 130);
			if (entityShowing instanceof VehicleAirBase)
			{
				if (entityShowing instanceof VehicXWing)
					GL11.glTranslatef(19, -40, 0);
				else
					GL11.glTranslatef(0, -70, 0);
				P3D.glScalef(2);
				if (currentFix != null)
					currentFix.accept(null);
				GL11.glRotatef((System.currentTimeMillis() / -30) % 360, 0, 1, 0);
				if (entityShowing instanceof VehicYWing)
					GL11.glTranslatef(0, 0, 5);
			}
			else
			{
				GL11.glScalef(60, -60, 60);
				GL11.glRotatef((System.currentTimeMillis() / 30) % 360, 0, 1, 0);
			}

			com.parzivail.util.ui.RenderHelper.renderEntity(entityShowing);

			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_TEXTURE_2D);

			GL11.glPopMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);
		}
		else if (tileShowing != null)
		{
			GL11.glPushMatrix();

			GFX.drawCenteredText(mc.fontRenderer, showingTitle, 320, 165, 1.5f, GLPalette.SW_YELLOW);

			String[] lines = TextUtils.splitIntoLine(showingDesc, 45);
			int i = 0;
			for (String line : lines)
			{
				GFX.drawCenteredText(mc.fontRenderer, line, 320, 185 + i * 12, 1f, GLPalette.WHITE);
				i++;
			}

			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glEnable(GL11.GL_LIGHTING);
			RenderHelper.enableStandardItemLighting();

			GLPalette.glColorI(GLPalette.WHITE);

			GL11.glTranslatef(320, 90, 200);

			P3D.glScalef(2.75f);

			if (currentFix != null)
				currentFix.accept(null);

			GL11.glTranslatef(-0.5f, 0, -0.5f);

			GFX.renderTileEntityAt(tileShowing, 0, 0, 0, 0);

			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_TEXTURE_2D);

			GL11.glPopMatrix();
		}

		super.drawScreen(mX, mY, p);
	}
}