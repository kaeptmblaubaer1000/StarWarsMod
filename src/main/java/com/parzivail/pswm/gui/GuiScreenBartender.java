package com.parzivail.pswm.gui;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.mobs.trooper.MobDefaultBiped;
import com.parzivail.pswm.quest.QuestNpcUtils;
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
public class GuiScreenBartender extends GuiScreen
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
	Consumer<OutlineButton> fixXwing;
	Consumer<OutlineButton> fixAwing;
	Consumer<OutlineButton> fixYwing;
	Consumer<OutlineButton> fixT47;
	Consumer<OutlineButton> fixTarget;
	Consumer<OutlineButton> fixGunRack;
	Consumer<OutlineButton> fixAntenna;
	Consumer<OutlineButton> fixHolotable;
	Consumer<OutlineButton> fixBacta;
	Consumer<OutlineButton> currentFix = null;

	public GuiScreenBartender(EntityPlayer player, TileEntityStaticNpc tileEntity)
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

		OutlineButtonEntity bArmorEndor = new OutlineButtonEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		MobDefaultBiped bipedEndor = new MobDefaultBiped(player.worldObj);
		QuestNpcUtils.arm(bipedEndor, Resources.armors[2]);
		bArmorEndor.setup(bipedEndor, preRenderArmorButton, postRenderEmpty);
		listBArmor.put("bArmorEndor", bArmorEndor);

		OutlineButtonEntity bArmorHoth = new OutlineButtonEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		MobDefaultBiped bipedHoth = new MobDefaultBiped(player.worldObj);
		QuestNpcUtils.arm(bipedHoth, Resources.armors[1]);
		bArmorHoth.setup(bipedHoth, preRenderArmorButton, postRenderEmpty);
		listBArmor.put("bArmorHoth", bArmorHoth);

		x = 0;
		y++;

		OutlineButtonEntity bArmorXPilot = new OutlineButtonEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		MobDefaultBiped bipedXwing = new MobDefaultBiped(player.worldObj);
		QuestNpcUtils.arm(bipedXwing, Resources.armors[0]);
		bArmorXPilot.setup(bipedXwing, preRenderArmorButton, postRenderEmpty);
		listBArmor.put("bArmorXPilot", bArmorXPilot);

		OutlineButtonEntity bArmorYPilot = new OutlineButtonEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		MobDefaultBiped bipedYwing = new MobDefaultBiped(player.worldObj);
		QuestNpcUtils.arm(bipedYwing, Resources.armors[10]);
		bArmorYPilot.setup(bipedYwing, preRenderArmorButton, postRenderEmpty);
		listBArmor.put("bArmorYPilot", bArmorYPilot);

		x = 0;
		y++;

		OutlineButtonEntity bArmorAPilot = new OutlineButtonEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		MobDefaultBiped bipedAwing = new MobDefaultBiped(player.worldObj);
		QuestNpcUtils.arm(bipedAwing, Resources.armors[9]);
		bArmorAPilot.setup(bipedAwing, preRenderArmorButton, postRenderEmpty);
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
		listBWeapons.put("bGunA280", bGunA280);

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
		listBMisc.put("bMiscGunRack", bMiscGunRack);

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
		listBMisc.put("bMiscBacta", bMiscBacta);

		setTabArmor();
	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return true;
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
			else if (button.id == listBArmor.get("bArmorEndor").id)
			{
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBArmor.get("bArmorEndor")).entity;

				showingTitle = "Rebel Forest Gear";
				showingDesc = "Hidey";
			}
			else if (button.id == listBArmor.get("bArmorHoth").id)
			{
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBArmor.get("bArmorHoth")).entity;

				showingTitle = "Rebel Low Temperature Gear";
				showingDesc = "freezy";
			}
			else if (button.id == listBArmor.get("bArmorXPilot").id)
			{
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBArmor.get("bArmorXPilot")).entity;

				showingTitle = "Rebel X-Wing Pilot Jumpsuit";
				showingDesc = "fly-y";
			}
			else if (button.id == listBArmor.get("bArmorYPilot").id)
			{
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBArmor.get("bArmorYPilot")).entity;

				showingTitle = "Rebel Y-Wing Pilot Jumpsuit";
				showingDesc = "bomby";
			}
			else if (button.id == listBArmor.get("bArmorAPilot").id)
			{
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBArmor.get("bArmorAPilot")).entity;

				showingTitle = "Rebel A-Wing Pilot Jumpsuit";
				showingDesc = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book";
			}
			else if (button.id == listBWeapons.get("bGunA280").id)
			{
				currentFix = fixA280;
				stackShowing = ((OutlineButtonItemStack)listBWeapons.get("bGunA280")).itemStack;
				entityShowing = null;
				tileShowing = null;

				showingTitle = "BlasTech A-280C Blaster Rifle";
				showingDesc = "shooty";
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
			}
			else if (button.id == listBShips.get("bShipXwing").id)
			{
				currentFix = fixXwing;
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBShips.get("bShipXwing")).entity;

				showingTitle = "Incom T-65 X-Wing Starfighter";
				showingDesc = "BAD-X (R)";
			}
			else if (button.id == listBShips.get("bShipYwing").id)
			{
				currentFix = fixYwing;
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBShips.get("bShipYwing")).entity;

				showingTitle = "BTL Y-Wing Bomber";
				showingDesc = "boom";
			}
			else if (button.id == listBShips.get("bShipAwing").id)
			{
				currentFix = fixAwing;
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBShips.get("bShipAwing")).entity;

				showingTitle = "RZ-1 A-Wing Interceptor";
				showingDesc = "double pew";
			}
			else if (button.id == listBShips.get("bShipT47").id)
			{
				currentFix = fixT47;
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBShips.get("bShipT47")).entity;

				showingTitle = "Incom T-47 Snowspeeder";
				showingDesc = "cold";
			}
			else if (button.id == listBMisc.get("bMiscTarget").id)
			{
				currentFix = fixTarget;
				stackShowing = null;
				entityShowing = null;
				tileShowing = ((OutlineButtonTileEntity)listBMisc.get("bMiscTarget")).tileEntity;

				showingTitle = "Target";
				showingDesc = "aim better than a stormtrooper, at least";
			}
			else if (button.id == listBMisc.get("bMiscGunRack").id)
			{
				currentFix = fixGunRack;
				stackShowing = null;
				entityShowing = null;
				tileShowing = ((OutlineButtonTileEntity)listBMisc.get("bMiscGunRack")).tileEntity;

				showingTitle = "Gun Rack";
				showingDesc = "store yo guns";
			}
			else if (button.id == listBMisc.get("bMiscAntenna").id)
			{
				currentFix = fixAntenna;
				stackShowing = null;
				entityShowing = null;
				tileShowing = ((OutlineButtonTileEntity)listBMisc.get("bMiscAntenna")).tileEntity;

				showingTitle = "Antenna";
				showingDesc = "listeny";
			}
			else if (button.id == listBMisc.get("bMiscBacta").id)
			{
				currentFix = fixBacta;
				stackShowing = null;
				entityShowing = null;
				tileShowing = ((OutlineButtonTileEntity)listBMisc.get("bMiscBacta")).tileEntity;

				showingTitle = "Bacta Tank";
				showingDesc = "healy";
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