package com.parzivail.pswm.gui;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.mobs.*;
import com.parzivail.pswm.network.MessagePlayerBuyItem;
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
public class GuiScreenJawa extends GuiScreen
{
	private EntityPlayer player;
	private static final ResourceLocation background = new ResourceLocation(Resources.MODID, "textures/gui/space.png");

	private OutlineButton bTabDroids;
	private OutlineButton bTabWeapons;
	private OutlineButton bTabMisc;

	private Map<String, OutlineButton> listBDroids;
	private Map<String, OutlineButton> listBWeapons;
	private Map<String, OutlineButton> listBMisc;

	private ItemStack stackShowing;
	private Entity entityShowing;
	private TileEntity tileShowing;
	private ItemRenderer renderItem = RenderManager.instance.itemRenderer;

	private String showingTitle = "";
	private String showingDesc = "";

	Consumer<OutlineButton> fixA280;
	Consumer<OutlineButton> fixItem;
	Consumer<OutlineButton> currentFix = null;

	private OutlineButtonCreditCounter bBuy;
	private ItemStack[] buyItemStacks;

	public GuiScreenJawa(EntityPlayer player)
	{
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
		bTabDroids = new OutlineButton(id++, xTab += 50, 10, 40, 20, LangUtils.translate("droids"), false);
		bTabWeapons = new OutlineButton(id++, xTab += 50, 10, 40, 20, LangUtils.translate("guns"), false);
		bTabMisc = new OutlineButton(id++, xTab += 50, 10, 40, 20, LangUtils.translate("misc"), false);

		buttonList.add(bTabDroids);
		buttonList.add(bTabWeapons);
		buttonList.add(bTabMisc);

		ScaledResolution r = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		bBuy = new OutlineButtonCreditCounter(id++, r.getScaledWidth() - 100, 10, 80, 20, player);
		buttonList.add(bBuy);

		listBDroids = new HashMap<>();
		listBWeapons = new HashMap<>();
		listBMisc = new HashMap<>();

		int x = 0;
		int y = 0;

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

		Consumer<OutlineButton> postRenderEmpty = outlineButton ->
		{
		};

		OutlineButtonEntity bDroidAstromech = new OutlineButtonEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bDroidAstromech.setup(new MobDroidAstromech(player.worldObj), preRenderDroidsButton, postRenderEmpty);
		listBDroids.put("bDroidAstromech", bDroidAstromech);

		OutlineButtonEntity bDroidAstromech2 = new OutlineButtonEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bDroidAstromech2.setup(new MobDroidAstromech2(player.worldObj), preRenderDroidsButton, postRenderEmpty);
		listBDroids.put("bDroidAstromech2", bDroidAstromech2);

		x = 0;
		y++;

		OutlineButtonEntity bDroidProtocol = new OutlineButtonEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bDroidProtocol.setup(new MobDroidProtocol(player.worldObj), preRenderDroidsButton, postRenderEmpty);
		listBDroids.put("bDroidProtocol", bDroidProtocol);

		OutlineButtonEntity bDroidAstromechBb8 = new OutlineButtonEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bDroidAstromechBb8.setup(new MobDroidAstromechBb8(player.worldObj), preRenderDroidsButton, postRenderEmpty);
		listBDroids.put("bDroidAstromechBb8", bDroidAstromechBb8);

		x = 0;
		y++;

		OutlineButtonEntity bDroidGonk = new OutlineButtonEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bDroidGonk.setup(new MobDroidGNK(player.worldObj), preRenderDroidsButton, postRenderEmpty);
		listBDroids.put("bDroidGonk", bDroidGonk);

		x = 0;
		y = 0;

		OutlineButtonItemStack bGunIonization = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bGunIonization.setup(new ItemStack(StarWarsItems.blasterRifle, 1, 2), fixA280 = outlineButton ->
		{
			if (outlineButton != null)
				GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 30f, 50);
			P3D.glScalef(24f);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(10, 1, 0, 0);
			GL11.glRotatef((System.currentTimeMillis() / (outlineButton == null ? 30 : 15)) % 360, 0, 1, 0);
			GL11.glTranslatef(0.25f, 0, 0.55f);
		}, postRenderEmpty);
		listBWeapons.put("bGunIonization", bGunIonization);

		x = 0;
		y = 0;

		OutlineButtonItemStack bMiscCaller = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bMiscCaller.setup(new ItemStack(StarWarsItems.droidCaller), fixItem = outlineButton ->
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
		}, postRenderEmpty, false, player);
		listBMisc.put("bMiscCaller", bMiscCaller);

		OutlineButtonItemStack bMiscHacker = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bMiscHacker.setup(new ItemStack(StarWarsItems.droidHacker), fixItem, postRenderEmpty, false, player);
		listBMisc.put("bMiscHacker", bMiscHacker);

		setTabDroids();
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
			else if (button.id == bTabDroids.id)
			{
				setTabDroids();
			}
			else if (button.id == bTabWeapons.id)
			{
				setTabGuns();
			}
			else if (button.id == bTabMisc.id)
			{
				setTabMisc();
			}
			else if (button.id == listBDroids.get("bDroidAstromech").id)
			{
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBDroids.get("bDroidAstromech")).entity;

				showingTitle = "R2-Series Astromech Droid";
				showingDesc = "beep";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.spawnAstromech, 1) };
			}
			else if (button.id == listBDroids.get("bDroidAstromech2").id)
			{
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBDroids.get("bDroidAstromech2")).entity;

				showingTitle = "R5-Series Astromech Droid";
				showingDesc = "boop";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.spawnAstromech2, 1) };
			}
			else if (button.id == listBDroids.get("bDroidProtocol").id)
			{
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBDroids.get("bDroidProtocol")).entity;

				showingTitle = "3PO-Series Protocol Droid";
				showingDesc = "boop";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.spawnProtocol, 1) };
			}
			else if (button.id == listBDroids.get("bDroidAstromechBb8").id)
			{
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBDroids.get("bDroidAstromechBb8")).entity;

				showingTitle = "BB-Series Astromech Droid";
				showingDesc = "boop";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.spawnAstromechBb8, 1) };
			}
			else if (button.id == listBDroids.get("bDroidGonk").id)
			{
				stackShowing = null;
				tileShowing = null;
				entityShowing = ((OutlineButtonEntity)listBDroids.get("bDroidGonk")).entity;

				showingTitle = "GNK Power Droid";
				showingDesc = "boop";

				bBuy.setCurrentCost(48);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.spawnGonk, 1) };
			}
			else if (button.id == listBWeapons.get("bGunIonization").id)
			{
				currentFix = fixA280;
				stackShowing = ((OutlineButtonItemStack)listBWeapons.get("bGunIonization")).itemStack;
				entityShowing = null;
				tileShowing = null;

				showingTitle = "Ionization Blaster";
				showingDesc = "shooty";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.blasterRifle, 1, 2) };
			}
			else if (button.id == listBMisc.get("bMiscCaller").id)
			{
				currentFix = fixItem;
				tileShowing = null;
				entityShowing = null;
				stackShowing = ((OutlineButtonItemStack)listBMisc.get("bMiscCaller")).itemStack;

				showingTitle = "Droid Caller";
				showingDesc = "zip";

				bBuy.setCurrentCost(32);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.droidCaller, 1) };
			}
			else if (button.id == listBMisc.get("bMiscHacker").id)
			{
				currentFix = fixItem;
				tileShowing = null;
				entityShowing = null;
				stackShowing = ((OutlineButtonItemStack)listBMisc.get("bMiscHacker")).itemStack;

				showingTitle = "Droid Hacker";
				showingDesc = "*hacker voice* i'm in";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.droidHacker, 1) };
			}
		}
	}

	private void setTabDroids()
	{
		bTabDroids.selected = true;
		bTabWeapons.selected = false;
		bTabMisc.selected = false;

		buttonList.addAll(listBDroids.values());
		buttonList.removeAll(listBWeapons.values());
		buttonList.removeAll(listBMisc.values());
	}

	private void setTabGuns()
	{
		bTabDroids.selected = false;
		bTabWeapons.selected = true;
		bTabMisc.selected = false;

		buttonList.removeAll(listBDroids.values());
		buttonList.addAll(listBWeapons.values());
		buttonList.removeAll(listBMisc.values());
	}

	private void setTabMisc()
	{
		bTabDroids.selected = false;
		bTabWeapons.selected = false;
		bTabMisc.selected = true;

		buttonList.removeAll(listBDroids.values());
		buttonList.removeAll(listBWeapons.values());
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