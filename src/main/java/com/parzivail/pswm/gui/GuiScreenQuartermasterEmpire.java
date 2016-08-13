package com.parzivail.pswm.gui;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.items.ItemQuestLog;
import com.parzivail.pswm.mobs.trooper.MobDefaultBiped;
import com.parzivail.pswm.network.MessagePlayerBuyItem;
import com.parzivail.pswm.network.MessageSetQuestLogNbt;
import com.parzivail.pswm.quest.QuestBank;
import com.parzivail.pswm.quest.QuestStats;
import com.parzivail.pswm.quest.QuestUtils;
import com.parzivail.pswm.tileentities.TileEntityAntenna;
import com.parzivail.pswm.tileentities.TileEntityGunRack;
import com.parzivail.pswm.tileentities.TileEntityStaticNpc;
import com.parzivail.pswm.tileentities.TileEntityTarget;
import com.parzivail.pswm.vehicles.VehicTIE;
import com.parzivail.pswm.vehicles.VehicTIEAdvanced;
import com.parzivail.pswm.vehicles.VehicTIEBomber;
import com.parzivail.pswm.vehicles.VehicTIEInterceptor;
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
public class GuiScreenQuartermasterEmpire extends GuiScreen
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

	Consumer<OutlineButton> fixE11;
	Consumer<OutlineButton> fixDlt19;
	Consumer<OutlineButton> fixT21;
	Consumer<OutlineButton> fixRt97c;
	Consumer<OutlineButton> fixScout;
	Consumer<OutlineButton> fixTie;
	Consumer<OutlineButton> fixTIEInterceptor;
	Consumer<OutlineButton> fixTIEBomber;
	Consumer<OutlineButton> fixTIEAdvanced;
	Consumer<OutlineButton> fixTarget;
	Consumer<OutlineButton> fixGunRack;
	Consumer<OutlineButton> fixAntenna;
	Consumer<OutlineButton> fixHolotable;
	Consumer<OutlineButton> fixBacta;
	Consumer<OutlineButton> fixItem;
	Consumer<OutlineButton> currentFix = null;

	Consumer<EntityPlayer> onBuyClick = null;

	private OutlineButtonCreditCounter bBuy;
	private ItemStack[] buyItemStacks;

	public GuiScreenQuartermasterEmpire(EntityPlayer player, TileEntityStaticNpc tileEntity)
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

		buttonList.add(bTabArmor);
		buttonList.add(bTabWeapons);
		buttonList.add(bTabShips);
		buttonList.add(bTabMisc);

		ScaledResolution r = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		bBuy = new OutlineButtonCreditCounter(id++, r.getScaledWidth() - 100, 10, 80, 20, player);
		buttonList.add(bBuy);

		listBArmor = new HashMap<>();
		listBWeapons = new HashMap<>();
		listBShips = new HashMap<>();
		listBMisc = new HashMap<>();

		int x = 0;
		int y = 0;

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

		OutlineButtonEntity bArmorStorm = new OutlineButtonEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		MobDefaultBiped bipedEndor = new MobDefaultBiped(player.worldObj);
		QuestUtils.arm(bipedEndor, Resources.armors[3]);
		bArmorStorm.setup(bipedEndor, preRenderArmorButton, postRenderEmpty);
		bArmorStorm.enabled = ItemQuestLog.isQuestDone(player, QuestBank.imperial0) || player.capabilities.isCreativeMode;
		listBArmor.put("bArmorStorm", bArmorStorm);

		OutlineButtonEntity bArmorScout = new OutlineButtonEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		MobDefaultBiped bipedScout = new MobDefaultBiped(player.worldObj);
		QuestUtils.arm(bipedScout, Resources.armors[6]);
		bArmorScout.setup(bipedScout, preRenderArmorButton, postRenderEmpty);
		bArmorScout.enabled = ItemQuestLog.isQuestDone(player, QuestBank.imperial3_1) || player.capabilities.isCreativeMode;
		listBArmor.put("bArmorScout", bArmorScout);

		OutlineButtonEntity bArmorAtatPilot = new OutlineButtonEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		MobDefaultBiped bipedAtat = new MobDefaultBiped(player.worldObj);
		QuestUtils.arm(bipedAtat, Resources.armors[8]);
		bArmorAtatPilot.setup(bipedAtat, preRenderArmorButton, postRenderEmpty);
		bArmorAtatPilot.enabled = ItemQuestLog.isQuestDone(player, QuestBank.imperial10_2) || player.capabilities.isCreativeMode;
		listBArmor.put("bArmorAtatPilot", bArmorAtatPilot);

		x = 0;
		y++;

		OutlineButtonEntity bArmorSandtrooper = new OutlineButtonEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		MobDefaultBiped bipedHoth = new MobDefaultBiped(player.worldObj);
		QuestUtils.arm(bipedHoth, Resources.armors[4]);
		bArmorSandtrooper.setup(bipedHoth, preRenderArmorButton, postRenderEmpty);
		bArmorSandtrooper.enabled = ItemQuestLog.isQuestDone(player, QuestBank.imperial4_2) || player.capabilities.isCreativeMode;
		listBArmor.put("bArmorSandtrooper", bArmorSandtrooper);

		OutlineButtonEntity bArmorSnowtrooper = new OutlineButtonEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		MobDefaultBiped bipedTie = new MobDefaultBiped(player.worldObj);
		QuestUtils.arm(bipedTie, Resources.armors[5]);
		bArmorSnowtrooper.setup(bipedTie, preRenderArmorButton, postRenderEmpty);
		bArmorSnowtrooper.enabled = ItemQuestLog.isQuestDone(player, QuestBank.imperial6_2) || player.capabilities.isCreativeMode;
		listBArmor.put("bArmorSnowtrooper", bArmorSnowtrooper);

		x = 0;
		y++;

		OutlineButtonEntity bArmorTiePilot = new OutlineButtonEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		MobDefaultBiped bipedTIEInterceptor = new MobDefaultBiped(player.worldObj);
		QuestUtils.arm(bipedTIEInterceptor, Resources.armors[7]);
		bArmorTiePilot.setup(bipedTIEInterceptor, preRenderArmorButton, postRenderEmpty);
		bArmorTiePilot.enabled = ItemQuestLog.isQuestDone(player, QuestBank.imperial8_2) || player.capabilities.isCreativeMode;
		listBArmor.put("bArmorTiePilot", bArmorTiePilot);

		OutlineButtonEntity bArmorAtstPilot = new OutlineButtonEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		MobDefaultBiped bipedAtst = new MobDefaultBiped(player.worldObj);
		QuestUtils.arm(bipedAtst, Resources.armors[8]);
		bArmorAtstPilot.setup(bipedAtst, preRenderArmorButton, postRenderEmpty);
		bArmorAtstPilot.enabled = ItemQuestLog.isQuestDone(player, QuestBank.imperial2) || player.capabilities.isCreativeMode;
		listBArmor.put("bArmorAtstPilot", bArmorAtstPilot);

		x = 0;
		y = 0;

		OutlineButtonItemStack bGunE11 = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bGunE11.setup(new ItemStack(StarWarsItems.blasterRifle, 1, 4), fixE11 = outlineButton ->
		{
			if (outlineButton != null)
				GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 30f, 50);
			P3D.glScalef(20f);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(10, 1, 0, 0);
			GL11.glRotatef((System.currentTimeMillis() / (outlineButton == null ? 30 : 15)) % 360, 0, 1, 0);
			GL11.glTranslatef(0.51f, 0, 0f);
		}, postRenderEmpty);
		bGunE11.enabled = ItemQuestLog.isQuestDone(player, QuestBank.imperial1) || player.capabilities.isCreativeMode;
		listBWeapons.put("bGunE11", bGunE11);

		OutlineButtonItemStack bGunDlt19 = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bGunDlt19.setup(new ItemStack(StarWarsItems.blasterHeavy, 1, 0), fixDlt19 = outlineButton ->
		{
			if (outlineButton != null)
				GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 30f, 50);
			P3D.glScalef(11f);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(10, 1, 0, 0);
			GL11.glRotatef(90, 0, 1, 0);
			GL11.glRotatef((System.currentTimeMillis() / (outlineButton == null ? 30 : 15)) % 360, 0, 1, 0);
			GL11.glTranslatef(0.2f, 0, 0.65f);
		}, postRenderEmpty);
		bGunDlt19.enabled = ItemQuestLog.isQuestDone(player, QuestBank.imperial4_2) || player.capabilities.isCreativeMode;
		listBWeapons.put("bGunDlt19", bGunDlt19);

		x = 0;
		y++;

		OutlineButtonItemStack bGunT21 = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bGunT21.setup(new ItemStack(StarWarsItems.blasterHeavy, 1, 1), fixT21 = outlineButton ->
		{
			if (outlineButton != null)
				GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 30f, 50);
			else
				GL11.glTranslatef(0, 6, 0);
			P3D.glScalef(11f);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(10, 1, 0, 0);
			GL11.glRotatef(90, 0, 1, 0);
			GL11.glRotatef((System.currentTimeMillis() / (outlineButton == null ? 30 : 15)) % 360, 0, 1, 0);
			GL11.glTranslatef(0.51f, 0, -0.3f);
			GL11.glRotatef(90, 0, 1, 0);
		}, postRenderEmpty);
		bGunT21.enabled = ItemQuestLog.isQuestDone(player, QuestBank.imperial6_2) || player.capabilities.isCreativeMode;
		listBWeapons.put("bGunT21", bGunT21);

		OutlineButtonItemStack bGunRt97c = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bGunRt97c.setup(new ItemStack(StarWarsItems.blasterHeavy, 1, 2), fixRt97c = outlineButton ->
		{
			if (outlineButton != null)
				GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 30f, 50);
			else
				GL11.glTranslatef(0, 6, 0);
			P3D.glScalef(15f);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(10, 1, 0, 0);
			GL11.glRotatef(90, 0, 1, 0);
			GL11.glRotatef((System.currentTimeMillis() / (outlineButton == null ? 30 : 15)) % 360, 0, 1, 0);
			GL11.glTranslatef(0f, 0, -0.3f);
			GL11.glRotatef(90, 0, 1, 0);
		}, postRenderEmpty);
		bGunRt97c.enabled = ItemQuestLog.isQuestDone(player, QuestBank.imperial4_2) || player.capabilities.isCreativeMode;
		listBWeapons.put("bGunRt97c", bGunRt97c);

		x = 0;
		y++;

		OutlineButtonItemStack bGunScout = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bGunScout.setup(new ItemStack(StarWarsItems.blasterPistol, 1, 5), fixScout = outlineButton ->
		{
			if (outlineButton != null)
				GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 30f, 50);
			GL11.glTranslatef(0, -6, 0);
			P3D.glScalef(40f);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(10, 1, 0, 0);
			GL11.glRotatef(90, 0, 1, 0);
			GL11.glRotatef((System.currentTimeMillis() / (outlineButton == null ? 30 : 15)) % 360, 0, 1, 0);
			GL11.glTranslatef(0.3f, 0, 0.5f);
		}, postRenderEmpty);
		bGunScout.enabled = ItemQuestLog.isQuestDone(player, QuestBank.imperial3_1) || player.capabilities.isCreativeMode;
		listBWeapons.put("bGunScout", bGunScout);

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

		OutlineButtonEntity bShipTie = new OutlineButtonEntity(id++, x++ * 100 + 10, y * 100 + 40, 90, 90);
		VehicTIE Tie = new VehicTIE(player.worldObj);
		bShipTie.setup(Tie, fixTie = outlineButton ->
		{
			P3D.glScalef(2f);
			GL11.glTranslatef(-22f, -22, 0);
			preRenderShips.accept(outlineButton);
		}, postRenderEmpty);
		bShipTie.enabled = (ItemQuestLog.isQuestDone(player, QuestBank.imperial8_3) && ItemQuestLog.getStat(player, QuestStats.LICENSE_TIE) == 0) || player.capabilities.isCreativeMode;
		listBShips.put("bShipTie", bShipTie);

		OutlineButtonEntity bShipTIEBomber = new OutlineButtonEntity(id++, x++ * 100 + 10, y * 100 + 40, 90, 90);
		VehicTIEBomber TIEBomber = new VehicTIEBomber(player.worldObj);
		bShipTIEBomber.setup(TIEBomber, fixTIEBomber = outlineButton ->
		{
			P3D.glScalef(1.5f);
			GL11.glTranslatef(-15f, -15, 0);
			preRenderShips.accept(outlineButton);
			if (outlineButton != null)
				GL11.glTranslatef(-2.67f, 0, -0.5f);
		}, postRenderEmpty);
		bShipTIEBomber.enabled = (ItemQuestLog.isQuestDone(player, QuestBank.imperial9) && ItemQuestLog.getStat(player, QuestStats.LICENSE_TIE_BOMBER) == 0) || player.capabilities.isCreativeMode;
		listBShips.put("bShipTIEBomber", bShipTIEBomber);

		x = 0;
		y++;

		OutlineButtonEntity bShipTIEInterceptor = new OutlineButtonEntity(id++, x++ * 100 + 10, y * 100 + 40, 90, 90);
		VehicTIEInterceptor TIEInterceptor = new VehicTIEInterceptor(player.worldObj);
		bShipTIEInterceptor.setup(TIEInterceptor, fixTIEInterceptor = outlineButton ->
		{
			P3D.glScalef(1.8f);
			GL11.glTranslatef(-20f, -20, 0);
			preRenderShips.accept(outlineButton);
		}, postRenderEmpty);
		bShipTIEInterceptor.enabled = (ItemQuestLog.isQuestDone(player, QuestBank.imperial10_1) && ItemQuestLog.getStat(player, QuestStats.LICENSE_TIE_INTERCEPTOR) == 0) || player.capabilities.isCreativeMode;
		listBShips.put("bShipTIEInterceptor", bShipTIEInterceptor);

		OutlineButtonEntity bShipTIEAdvanced = new OutlineButtonEntity(id++, x++ * 100 + 10, y * 100 + 40, 90, 90);
		VehicTIEAdvanced TIEAdvanced = new VehicTIEAdvanced(player.worldObj);
		bShipTIEAdvanced.setup(TIEAdvanced, fixTIEAdvanced = outlineButton ->
		{
			P3D.glScalef(1.8f);
			GL11.glTranslatef(-20f, -20, 0);
			preRenderShips.accept(outlineButton);
		}, postRenderEmpty);
		bShipTIEAdvanced.enabled = (ItemQuestLog.isQuestDone(player, QuestBank.imperial10_2) && ItemQuestLog.getStat(player, QuestStats.LICENSE_TIE_ADVANCED) == 0) || player.capabilities.isCreativeMode;
		listBShips.put("bShipTIEAdvanced", bShipTIEAdvanced);

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
		bMiscTarget.enabled = ItemQuestLog.isQuestDone(player, QuestBank.imperial0) || player.capabilities.isCreativeMode;
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
		bMiscGunRack.enabled = ItemQuestLog.isQuestDone(player, QuestBank.imperial0) || player.capabilities.isCreativeMode;
		listBMisc.put("bMiscGunRack", bMiscGunRack);

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

		OutlineButtonItemStack bHHoth = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bHHoth.setup(new ItemStack(StarWarsItems.hyperdriveHoth), fixItem, postRenderEmpty, false, player);
		bHHoth.enabled = ItemQuestLog.isQuestDone(player, QuestBank.imperial6_1) || player.capabilities.isCreativeMode;
		listBMisc.put("bHHoth", bHHoth);

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
		bMiscAntenna.enabled = ItemQuestLog.isQuestDone(player, QuestBank.imperial4_2) || player.capabilities.isCreativeMode;
		listBMisc.put("bMiscAntenna", bMiscAntenna);

		OutlineButtonItemStack bHydrospanner = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bHydrospanner.setup(new ItemStack(StarWarsItems.hydrospanner), fixItem, postRenderEmpty, false, player);
		bHydrospanner.enabled = ItemQuestLog.isQuestDone(player, QuestBank.imperial2) || player.capabilities.isCreativeMode;
		listBMisc.put("bHydrospanner", bHydrospanner);

		OutlineButtonItemStack bHSpace = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bHSpace.setup(new ItemStack(StarWarsItems.hyperdriveSpace), fixItem, postRenderEmpty, false, player);
		bHSpace.enabled = ItemQuestLog.isQuestDone(player, QuestBank.imperial8_2) || player.capabilities.isCreativeMode;
		listBMisc.put("bHSpace", bHSpace);

		x = 0;
		y++;

		OutlineButtonItemStack bIdScanner = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bIdScanner.setup(new ItemStack(StarWarsItems.idScanner), fixItem, postRenderEmpty, false, player);
		bIdScanner.enabled = ItemQuestLog.isQuestDone(player, QuestBank.imperial4_2) || player.capabilities.isCreativeMode;
		listBMisc.put("bIdScanner", bIdScanner);

		OutlineButtonItemStack bDatapad = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bDatapad.setup(new ItemStack(StarWarsItems.dataPad), fixItem, postRenderEmpty, false, player);
		bDatapad.enabled = ItemQuestLog.isQuestDone(player, QuestBank.imperial6_2) || player.capabilities.isCreativeMode;
		listBMisc.put("bDatapad", bDatapad);

		OutlineButtonItemStack bHYavin = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bHYavin.setup(new ItemStack(StarWarsItems.hyperdriveYavin4), fixItem, postRenderEmpty, false, player);
		bHYavin.enabled = ItemQuestLog.isQuestDone(player, QuestBank.imperial10_1) || player.capabilities.isCreativeMode;
		listBMisc.put("bHYavin", bHYavin);

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
				if (onBuyClick != null && bBuy.getCurrentCost() <= QuestUtils.getPlayerBronzeCredits(player))
					onBuyClick.accept(player);
				StarWarsMod.network.sendToServer(new MessagePlayerBuyItem(player, buyItemStacks, bBuy.getCurrentCost()));
			}
			else if (button.id == listBArmor.get("bArmorStorm").id)
			{
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBArmor.get("bArmorStorm")).entity;

				onBuyClick = null;

				showingTitle = "Stormtrooper Body Armor";
				showingDesc = "Standard Stormtrooper Armor.";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.stormtrooperHelmet, 1), new ItemStack(StarWarsItems.stormtrooperChest, 1), new ItemStack(StarWarsItems.stormtrooperLegs, 1), new ItemStack(StarWarsItems.stormtrooperBoots, 1) };
			}
			else if (button.id == listBArmor.get("bArmorSandtrooper").id)
			{
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBArmor.get("bArmorSandtrooper")).entity;

				onBuyClick = null;

				showingTitle = "Sandtrooper Body Armor";
				showingDesc = "Used by troops in desert environments.";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.sandtrooperHelmet, 1), new ItemStack(StarWarsItems.sandtrooperChest, 1), new ItemStack(StarWarsItems.sandtrooperLegs, 1), new ItemStack(StarWarsItems.sandtrooperBoots, 1) };
			}
			else if (button.id == listBArmor.get("bArmorSnowtrooper").id)
			{
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBArmor.get("bArmorSnowtrooper")).entity;

				onBuyClick = null;

				showingTitle = "Snowtrooper Body Armor";
				showingDesc = "Used by troops in arctic environments.";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.snowtrooperHelmet, 1), new ItemStack(StarWarsItems.snowtrooperChest, 1), new ItemStack(StarWarsItems.snowtrooperLegs, 1), new ItemStack(StarWarsItems.snowtrooperBoots, 1) };
			}
			else if (button.id == listBArmor.get("bArmorScout").id)
			{
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBArmor.get("bArmorScout")).entity;

				onBuyClick = null;

				showingTitle = "Scout Trooper Body Armor";
				showingDesc = "Used by scouts in forest and jungle environments";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.scoutTrooperHelmet, 1), new ItemStack(StarWarsItems.scoutTrooperChest, 1), new ItemStack(StarWarsItems.scoutTrooperLegs, 1), new ItemStack(StarWarsItems.scoutTrooperBoots, 1) };
			}
			else if (button.id == listBArmor.get("bArmorTiePilot").id)
			{
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBArmor.get("bArmorTiePilot")).entity;

				onBuyClick = null;

				showingTitle = "TIE Pilot Body Armor";
				showingDesc = "Flightsuit used by our pilots.";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.tiePilotHelmet, 1), new ItemStack(StarWarsItems.tiePilotChest, 1), new ItemStack(StarWarsItems.tiePilotLegs, 1), new ItemStack(StarWarsItems.tiePilotBoots, 1) };
			}
			else if (button.id == listBArmor.get("bArmorAtstPilot").id)
			{
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBArmor.get("bArmorAtstPilot")).entity;

				onBuyClick = null;

				showingTitle = "AT-ST Pilot Body Armor";
				showingDesc = "Flightsuit used by AT-ST pilots.";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.atstPilotHelmet, 1), new ItemStack(StarWarsItems.atstPilotChest, 1), new ItemStack(StarWarsItems.atstPilotLegs, 1), new ItemStack(StarWarsItems.atstPilotBoots, 1) };
			}
			else if (button.id == listBArmor.get("bArmorAtatPilot").id)
			{
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBArmor.get("bArmorAtatPilot")).entity;

				onBuyClick = null;

				showingTitle = "AT-AT Pilot Body Armor";
				showingDesc = "Flightsuit used by AT-AT pilots.";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.atatPilotHelmet, 1), new ItemStack(StarWarsItems.atatPilotChest, 1), new ItemStack(StarWarsItems.atatPilotLegs, 1), new ItemStack(StarWarsItems.atatPilotBoots, 1) };
			}
			else if (button.id == listBWeapons.get("bGunE11").id)
			{
				currentFix = fixE11;
				stackShowing = ((OutlineButtonItemStack)listBWeapons.get("bGunE11")).itemStack;
				entityShowing = null;
				tileShowing = null;

				onBuyClick = null;

				showingTitle = "BlasTech E-11 Blaster Rifle";
				showingDesc = "The standard issue Blaster Rifle.";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.blasterRifle, 1, 4) };
			}
			else if (button.id == listBWeapons.get("bGunDlt19").id)
			{
				currentFix = fixDlt19;
				stackShowing = ((OutlineButtonItemStack)listBWeapons.get("bGunDlt19")).itemStack;
				entityShowing = null;
				tileShowing = null;

				onBuyClick = null;

				showingTitle = "BlasTech DLT-19 Heavy Blaster Rifle";
				showingDesc = "The standard issue Heavy Blaster Rifle.";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.blasterHeavy, 1, 0) };
			}
			else if (button.id == listBWeapons.get("bGunT21").id)
			{
				currentFix = outlineButton ->
				{
					GL11.glTranslatef(0, -6, 0);
					fixT21.accept(outlineButton);
				};
				stackShowing = ((OutlineButtonItemStack)listBWeapons.get("bGunT21")).itemStack;
				entityShowing = null;
				tileShowing = null;

				onBuyClick = null;

				showingTitle = "T21 Light Repeating Blaster";
				showingDesc = "An alternate Heavy Blaster Rifle fit for all tough environments.";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.blasterHeavy, 1, 1) };
			}
			else if (button.id == listBWeapons.get("bGunRt97c").id)
			{
				currentFix = outlineButton ->
				{
					GL11.glTranslatef(0, -6, 0);
					fixRt97c.accept(outlineButton);
				};
				stackShowing = ((OutlineButtonItemStack)listBWeapons.get("bGunRt97c")).itemStack;
				entityShowing = null;
				tileShowing = null;

				onBuyClick = null;

				showingTitle = "BlasTech RT-97C Heavy Blaster Rifle";
				showingDesc = "An alternate Heavy Blaster Rifle fit for all tough environments.";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.blasterHeavy, 1, 2) };
			}
			else if (button.id == listBWeapons.get("bGunScout").id)
			{
				currentFix = outlineButton ->
				{
					GL11.glTranslatef(0, -6, 0);
					fixScout.accept(outlineButton);
				};
				stackShowing = ((OutlineButtonItemStack)listBWeapons.get("bGunScout")).itemStack;
				entityShowing = null;
				tileShowing = null;

				onBuyClick = null;

				showingTitle = "BlasTech EC-17 Blaster Pistol";
				showingDesc = "The standard issue sidearm for scouts.";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.blasterPistol, 1, 5) };
			}
			else if (button.id == listBShips.get("bShipTie").id)
			{
				currentFix = fixTie;
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBShips.get("bShipTie")).entity;

				onBuyClick = player1 ->
				{
					ItemQuestLog.addStat(player1, QuestStats.LICENSE_TIE);
					StarWarsMod.network.sendToServer(new MessageSetQuestLogNbt(player1, ItemQuestLog.getQuestContainer(player1).stackTagCompound));
				};

				showingTitle = "TIE/LN Starfighter License";
				showingDesc = "The standard TIE model, equipped with 2 Laser Cannons.";

				bBuy.setCurrentCost(256);
				buyItemStacks = new ItemStack[] {};
			}
			else if (button.id == listBShips.get("bShipTIEBomber").id)
			{
				currentFix = fixTIEBomber;
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBShips.get("bShipTIEBomber")).entity;

				onBuyClick = player1 ->
				{
					ItemQuestLog.addStat(player1, QuestStats.LICENSE_TIE_BOMBER);
					StarWarsMod.network.sendToServer(new MessageSetQuestLogNbt(player1, ItemQuestLog.getQuestContainer(player1).stackTagCompound));
				};

				showingTitle = "TIE/SA Bomber License";
				showingDesc = "The Bomber variation of the TIE, equipped with 2 Laser Cannons and capable of dropping bombs.";

				bBuy.setCurrentCost(256);
				buyItemStacks = new ItemStack[] {};
			}
			else if (button.id == listBShips.get("bShipTIEInterceptor").id)
			{
				currentFix = fixTIEInterceptor;
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBShips.get("bShipTIEInterceptor")).entity;

				onBuyClick = player1 ->
				{
					ItemQuestLog.addStat(player1, QuestStats.LICENSE_TIE_INTERCEPTOR);
					StarWarsMod.network.sendToServer(new MessageSetQuestLogNbt(player1, ItemQuestLog.getQuestContainer(player1).stackTagCompound));
				};

				showingTitle = "TIE/IN Interceptor License";
				showingDesc = "The Interceptor variation of the TIE, equipped with 2 Laser Cannons and boasts a higher top speed than all other models.";

				bBuy.setCurrentCost(256);
				buyItemStacks = new ItemStack[] {};
			}
			else if (button.id == listBShips.get("bShipTIEAdvanced").id)
			{
				currentFix = fixTIEAdvanced;
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBShips.get("bShipTIEAdvanced")).entity;

				onBuyClick = player1 ->
				{
					ItemQuestLog.addStat(player1, QuestStats.LICENSE_TIE_ADVANCED);
					StarWarsMod.network.sendToServer(new MessageSetQuestLogNbt(player1, ItemQuestLog.getQuestContainer(player1).stackTagCompound));
				};

				showingTitle = "TIE Advanced x1 License";
				showingDesc = "An experimental TIE variation.  Equipped with 2 Laser Cannons.";

				bBuy.setCurrentCost(256);
				buyItemStacks = new ItemStack[] {};
			}
			else if (button.id == listBMisc.get("bMiscTarget").id)
			{
				currentFix = fixTarget;
				stackShowing = null;
				entityShowing = null;
				tileShowing = ((OutlineButtonTileEntity)listBMisc.get("bMiscTarget")).tileEntity;

				onBuyClick = null;

				showingTitle = "Target";
				showingDesc = "For training use only.";


				bBuy.setCurrentCost(16);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsMod.blockTarget, 1) };
			}
			else if (button.id == listBMisc.get("bMiscGunRack").id)
			{
				currentFix = fixGunRack;
				stackShowing = null;
				entityShowing = null;
				tileShowing = ((OutlineButtonTileEntity)listBMisc.get("bMiscGunRack")).tileEntity;

				onBuyClick = null;

				showingTitle = "Gun Rack";
				showingDesc = "Standard gun racks.";

				bBuy.setCurrentCost(32);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsMod.blockGunRack, 1) };
			}
			else if (button.id == listBMisc.get("bMiscAntenna").id)
			{
				currentFix = fixAntenna;
				stackShowing = null;
				entityShowing = null;
				tileShowing = ((OutlineButtonTileEntity)listBMisc.get("bMiscAntenna")).tileEntity;

				onBuyClick = null;

				showingTitle = "Antenna";
				showingDesc = "A mobile terrain visualizer and assessment device.  Fixable with a Hydrospanner";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsMod.blockAntenna, 1) };
			}
			else if (button.id == listBMisc.get("bHydrospanner").id)
			{
				currentFix = fixItem;
				tileShowing = null;
				entityShowing = null;
				stackShowing = ((OutlineButtonItemStack)listBMisc.get("bHydrospanner")).itemStack;

				onBuyClick = null;

				showingTitle = "Hydrospanner";
				showingDesc = "A mechanical repair tool, can be used to fix Antennas.";

				bBuy.setCurrentCost(0);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.hydrospanner, 1) };
			}
			else if (button.id == listBMisc.get("bIdScanner").id)
			{
				currentFix = fixItem;
				tileShowing = null;
				entityShowing = null;
				stackShowing = ((OutlineButtonItemStack)listBMisc.get("bIdScanner")).itemStack;

				onBuyClick = null;

				showingTitle = "ID Scanner";
				showingDesc = "Checks credentials against Imperial database.  Used to catch smugglers.";

				bBuy.setCurrentCost(0);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.idScanner, 1) };
			}
			else if (button.id == listBMisc.get("bDatapad").id)
			{
				currentFix = fixItem;
				tileShowing = null;
				entityShowing = null;
				stackShowing = ((OutlineButtonItemStack)listBMisc.get("bDatapad")).itemStack;

				onBuyClick = null;

				showingTitle = "Datapad";
				showingDesc = "Standard datapad.  Capable of scanning and storing data from Probe Droids.";

				bBuy.setCurrentCost(0);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.dataPad, 1) };
			}
			else if (button.id == listBMisc.get("bHHoth").id)
			{
				currentFix = fixItem;
				tileShowing = null;
				entityShowing = null;
				stackShowing = ((OutlineButtonItemStack)listBMisc.get("bHHoth")).itemStack;

				onBuyClick = null;

				showingTitle = "Hoth";
				showingDesc = "Arctic planet with a large Rebellion installation.";

				bBuy.setCurrentCost(0);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.hyperdriveHoth, 1) };
			}
			else if (button.id == listBMisc.get("bHSpace").id)
			{
				currentFix = fixItem;
				tileShowing = null;
				entityShowing = null;
				stackShowing = ((OutlineButtonItemStack)listBMisc.get("bHSpace")).itemStack;

				onBuyClick = null;

				showingTitle = "Wild Space";
				showingDesc = "Where pilots go to train.  Ba-Sing Station is shared with the Rebellion in the interest of fighter development";

				bBuy.setCurrentCost(0);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.hyperdriveSpace, 1) };
			}
			else if (button.id == listBMisc.get("bHYavin").id)
			{
				currentFix = fixItem;
				tileShowing = null;
				entityShowing = null;
				stackShowing = ((OutlineButtonItemStack)listBMisc.get("bHYavin")).itemStack;

				onBuyClick = null;

				showingTitle = "Yavin 4";
				showingDesc = "Forest planet and location of a large Rebellion installation.";

				bBuy.setCurrentCost(0);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.hyperdriveYavin4, 1) };
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

		GL11.glColor4f(1, 1, 1, 1);

		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_TEXTURE_2D);

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

			GFX.drawCenteredText(mc.fontRenderer, showingTitle, 330, 205, 1.5f, GLPalette.SW_YELLOW);

			String[] lines = TextUtils.splitIntoLine(showingDesc, 45);
			int i = 0;
			for (String line : lines)
			{
				GFX.drawCenteredText(mc.fontRenderer, line, 330, 225 + i * 12, 1f, GLPalette.WHITE);
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
				GL11.glTranslatef(90, 60, 0);

				if (entityShowing instanceof VehicTIEBomber)
					GL11.glTranslatef(-40, -50, 0);
				else if (entityShowing instanceof VehicTIEInterceptor || entityShowing instanceof VehicTIEAdvanced)
					GL11.glTranslatef(-15, -25, 0);

				P3D.glScalef(2);
				if (currentFix != null)
					currentFix.accept(null);
				GL11.glRotatef((System.currentTimeMillis() / -30) % 360, 0, 1, 0);
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