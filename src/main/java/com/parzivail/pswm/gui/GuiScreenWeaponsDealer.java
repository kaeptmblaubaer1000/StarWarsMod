package com.parzivail.pswm.gui;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.network.MessagePlayerBuyItem;
import com.parzivail.pswm.tileentities.TileEntityStaticNpc;
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
public class GuiScreenWeaponsDealer extends GuiScreen
{
	private EntityPlayer player;
	private static final ResourceLocation background = new ResourceLocation(Resources.MODID, "textures/gui/space.png");

	private OutlineButton bTabWeapons;
	private OutlineButton bTabMelee;
	private OutlineButton bTabMisc;

	private Map<String, OutlineButton> listBWeapons;
	private Map<String, OutlineButton> listBMelee;
	private Map<String, OutlineButton> listBMisc;

	private ItemStack stackShowing;
	private Entity entityShowing;
	private TileEntity tileShowing;
	private ItemRenderer renderItem = RenderManager.instance.itemRenderer;
	private TileEntityStaticNpc staticNpc;

	private String showingTitle = "";
	private String showingDesc = "";

	Consumer<OutlineButton> fixEe3;
	Consumer<OutlineButton> fixDl44;
	Consumer<OutlineButton> fixDl18;
	Consumer<OutlineButton> fixSe14c;
	Consumer<OutlineButton> fixDh17;
	Consumer<OutlineButton> fixGaffi;
	Consumer<OutlineButton> fixVibroLance;
	Consumer<OutlineButton> currentFix = null;
	Consumer<OutlineButton> fixPowerPack;

	private OutlineButtonCreditCounter bBuy;
	private ItemStack[] buyItemStacks;

	public GuiScreenWeaponsDealer(EntityPlayer player, TileEntityStaticNpc tileEntity)
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
		bTabWeapons = new OutlineButton(id++, xTab += 50, 10, 40, 20, LangUtils.translate("guns"), false);
		bTabMelee = new OutlineButton(id++, xTab += 50, 10, 40, 20, LangUtils.translate("melee"), false);
		bTabMisc = new OutlineButton(id++, xTab += 50, 10, 40, 20, LangUtils.translate("misc"), false);

		buttonList.add(bTabWeapons);
		buttonList.add(bTabMelee);
		buttonList.add(bTabMisc);

		ScaledResolution r = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		bBuy = new OutlineButtonCreditCounter(id++, r.getScaledWidth() - 100, 10, 80, 20, player);
		buttonList.add(bBuy);

		listBWeapons = new HashMap<>();
		listBMelee = new HashMap<>();
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

		OutlineButtonItemStack bGunEe3 = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bGunEe3.setup(new ItemStack(StarWarsItems.blasterRifle, 1, 1), fixEe3 = outlineButton ->
		{
			if (outlineButton != null)
				GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 30f, 50);
			else
				GL11.glTranslatef(0, -1, 0);
			P3D.glScalef(18f);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(10, 1, 0, 0);
			GL11.glRotatef((System.currentTimeMillis() / (outlineButton == null ? 30 : 15)) % 360, 0, 1, 0);
			GL11.glTranslatef(0.4f, 0, -0.25f);
		}, postRenderEmpty);
		listBWeapons.put("bGunEe3", bGunEe3);

		OutlineButtonItemStack bGunDl44 = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bGunDl44.setup(new ItemStack(StarWarsItems.blasterPistol, 1, 0), fixDl44 = outlineButton ->
		{
			if (outlineButton != null)
				GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 34f, 50);
			else
			{
				GL11.glTranslatef(0, -4, 0);
				P3D.glScalef(0.8f);
			}
			P3D.glScalef(28f);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(10, 1, 0, 0);
			GL11.glRotatef((System.currentTimeMillis() / (outlineButton == null ? 30 : 15)) % 360 + 180, 0, 1, 0);
			GL11.glTranslatef(0.4f, 0, 0.25f);
		}, postRenderEmpty);
		listBWeapons.put("bGunDl44", bGunDl44);

		x = 0;
		y++;

		OutlineButtonItemStack bGunDl18 = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bGunDl18.setup(new ItemStack(StarWarsItems.blasterPistol, 1, 1), fixDl18 = outlineButton ->
		{
			if (outlineButton != null)
				GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 30f, 50);
			else
				GL11.glTranslatef(0, -4, 0);
			P3D.glScalef(24f);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(10, 1, 0, 0);
			GL11.glRotatef((System.currentTimeMillis() / (outlineButton == null ? 30 : 15)) % 360 - 90, 0, 1, 0);
			GL11.glTranslatef(0.5f, 0, 0.5f);
		}, postRenderEmpty);
		listBWeapons.put("bGunDl18", bGunDl18);

		OutlineButtonItemStack bGunSe14c = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bGunSe14c.setup(new ItemStack(StarWarsItems.blasterPistol, 1, 6), fixSe14c = outlineButton ->
		{
			if (outlineButton != null)
				GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 30f, 50);
			else
				GL11.glTranslatef(0, -5, 0);
			P3D.glScalef(28f);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(10, 1, 0, 0);
			GL11.glRotatef((System.currentTimeMillis() / (outlineButton == null ? 30 : 15)) % 360 - 90, 0, 1, 0);
			GL11.glTranslatef(0.2f, 0, 0.5f);
		}, postRenderEmpty);
		listBWeapons.put("bGunSe14c", bGunSe14c);

		x = 0;
		y++;

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
			GL11.glRotatef((System.currentTimeMillis() / (outlineButton == null ? 30 : 15)) % 360, 0, 1, 0);
			GL11.glTranslatef(0.4f, 0, 0.3f);
		}, postRenderEmpty);
		listBWeapons.put("bGunDh17", bGunDh17);

		x = 0;
		y = 0;

		OutlineButtonItemStack bMeleeGaffi = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bMeleeGaffi.setup(new ItemStack(StarWarsItems.gaffiStick), fixGaffi = outlineButton ->
		{
			if (outlineButton != null)
				GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 30f, 50);
			else
			{
				GL11.glTranslatef(0, -3, 0);
				P3D.glScalef(0.6f);
			}
			GL11.glTranslatef(0, -13, 0);
			P3D.glScalef(16f);
			GL11.glRotatef(10, 1, 0, 0);
			GL11.glRotatef((System.currentTimeMillis() / (outlineButton == null ? 30 : 15)) % 360, 0, 1, 0);
			GL11.glTranslatef(0.45f, 0, 0.57f);
		}, postRenderEmpty);
		listBMelee.put("bMeleeGaffi", bMeleeGaffi);

		OutlineButtonItemStack bMeleeVibroLance = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bMeleeVibroLance.setup(new ItemStack(StarWarsItems.vibroLance), fixVibroLance = outlineButton ->
		{
			if (outlineButton != null)
				GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 30f, 50);
			else
			{
				GL11.glTranslatef(0, -3, 0);
				P3D.glScalef(0.55f);
			}
			GL11.glTranslatef(0, 18, 0);
			P3D.glScalef(16f);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(10, 1, 0, 0);
			GL11.glRotatef((System.currentTimeMillis() / (outlineButton == null ? 30 : 15)) % 360, 0, 1, 0);
			GL11.glTranslatef(0.45f, 0, 0.57f);
		}, postRenderEmpty);
		listBMelee.put("bMeleeVibroLance", bMeleeVibroLance);

		x = 0;
		y = 0;

		fixPowerPack = outlineButton ->
		{
			if (outlineButton != null)
				GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 30f, 50);
			else
			{
				P3D.glScalef(0.75f);
				GL11.glTranslatef(-1, -4, 0);
			}
			GL11.glRotatef((System.currentTimeMillis() / (outlineButton == null ? 30 : 15)) % 360, 0, 1, 0);
			GL11.glTranslatef(10, -5, 8);
			if (outlineButton == null)
			{
				GL11.glTranslatef(2, 0, 4);
			}
			P3D.glScalef(24f);
			GL11.glScalef(1, -1, 1);
		};

		OutlineButtonItemStack bPowerPack = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bPowerPack.setup(new ItemStack(StarWarsItems.powerpack), fixPowerPack, postRenderEmpty, false, player);
		bPowerPack.enabled = true;
		bPowerPack.setRenderType(ItemRenderType.INVENTORY);
		listBMisc.put("bPowerPack", bPowerPack);

		setTabGuns();
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
			if (button.id == bBuy.id && bBuy.getCurrentCost() != -1)
			{
				StarWarsMod.network.sendToServer(new MessagePlayerBuyItem(player, buyItemStacks, bBuy.getCurrentCost()));
			}
			else if (button.id == bTabWeapons.id)
			{
				setTabGuns();
			}
			else if (button.id == bTabMelee.id)
			{
				setTabMelee();
			}
			else if (button.id == bTabMisc.id)
			{
				setTabMisc();
			}
			else if (button.id == listBWeapons.get("bGunEe3").id)
			{
				currentFix = fixEe3;
				stackShowing = ((OutlineButtonItemStack)listBWeapons.get("bGunEe3")).itemStack;
				entityShowing = null;
				tileShowing = null;

				showingTitle = "BlasTech EE-3 Blaster Rifle";
				showingDesc = "A rifle that packs more punch than the normal stuff.  It's perfect for bounty hunters and scoundrels alike.";

				bBuy.setCurrentCost(128);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.blasterRifle, 1, 1) };
			}
			else if (button.id == listBWeapons.get("bGunDl44").id)
			{
				currentFix = fixDl44;
				stackShowing = ((OutlineButtonItemStack)listBWeapons.get("bGunDl44")).itemStack;
				entityShowing = null;
				tileShowing = null;

				showingTitle = "BlasTech DL-44 Heavy Blaster Pistol";
				showingDesc = "A pistol famous for it's powerful punch and supposedly used by a famous smuggler.";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.blasterPistol, 1, 0) };
			}
			else if (button.id == listBWeapons.get("bGunDl18").id)
			{
				currentFix = fixDl18;
				stackShowing = ((OutlineButtonItemStack)listBWeapons.get("bGunDl18")).itemStack;
				entityShowing = null;
				tileShowing = null;

				showingTitle = "BlasTech DL-18 Blaster Pistol";
				showingDesc = "The standard sidearm of the sleemos of the galaxy.";

				bBuy.setCurrentCost(32);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.blasterPistol, 1, 1) };
			}
			else if (button.id == listBWeapons.get("bGunSe14c").id)
			{
				currentFix = fixSe14c;
				stackShowing = ((OutlineButtonItemStack)listBWeapons.get("bGunSe14c")).itemStack;
				entityShowing = null;
				tileShowing = null;

				showingTitle = "BlasTech SE-14C";
				showingDesc = "A bigger pistol that lacks the punch of the DL-44.  Again, traditionally favored by scoundrels.";

				bBuy.setCurrentCost(32);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.blasterPistol, 1, 6) };
			}
			else if (button.id == listBWeapons.get("bGunDh17").id)
			{
				currentFix = fixDh17;
				stackShowing = ((OutlineButtonItemStack)listBWeapons.get("bGunDh17")).itemStack;
				entityShowing = null;
				tileShowing = null;

				showingTitle = "BlasTech DH-17 Blaster Pistol";
				showingDesc = "A fairly common and well-liked blaster pistol.  I even hear the Rebellion uses it.";

				bBuy.setCurrentCost(32);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.blasterPistol, 1, 2) };
			}
			else if (button.id == listBMelee.get("bMeleeGaffi").id)
			{
				currentFix = fixGaffi;
				stackShowing = ((OutlineButtonItemStack)listBMelee.get("bMeleeGaffi")).itemStack;
				entityShowing = null;
				tileShowing = null;

				showingTitle = "Tusken Gaffi Stick";
				showingDesc = "Tuskens make these by hand and they hurt like heck if you get hit by one.";

				bBuy.setCurrentCost(128);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.gaffiStick, 1) };
			}
			else if (button.id == listBMelee.get("bMeleeVibroLance").id)
			{
				currentFix = fixVibroLance;
				stackShowing = ((OutlineButtonItemStack)listBMelee.get("bMeleeVibroLance")).itemStack;
				entityShowing = null;
				tileShowing = null;

				showingTitle = "Vibro-Lance";
				showingDesc = "It's a big stick with a blade on it.  I think you get the idea.";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.vibroLance, 1) };
			}
			else if (button.id == listBMisc.get("bPowerPack").id)
			{
				currentFix = fixPowerPack;
				stackShowing = ((OutlineButtonItemStack)listBMisc.get("bPowerPack")).itemStack;
				entityShowing = null;
				tileShowing = null;

				showingTitle = "Power Pack";
				showingDesc = "Power packs for your blaster. Essential for all use. Each pack powers your blaster for 15 shots.";

				bBuy.setCurrentCost(10);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.powerpack, 1) };
			}
		}
	}

	private void setTabGuns()
	{
		bTabWeapons.selected = true;
		bTabMisc.selected = false;
		bTabMelee.selected = false;

		buttonList.addAll(listBWeapons.values());
		buttonList.removeAll(listBMisc.values());
		buttonList.removeAll(listBMelee.values());
	}

	private void setTabMelee()
	{
		bTabWeapons.selected = false;
		bTabMisc.selected = false;
		bTabMelee.selected = true;

		buttonList.removeAll(listBWeapons.values());
		buttonList.removeAll(listBMisc.values());
		buttonList.addAll(listBMelee.values());
	}

	private void setTabMisc()
	{
		bTabWeapons.selected = false;
		bTabMelee.selected = false;
		bTabMisc.selected = true;

		buttonList.removeAll(listBWeapons.values());
		buttonList.removeAll(listBMelee.values());
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