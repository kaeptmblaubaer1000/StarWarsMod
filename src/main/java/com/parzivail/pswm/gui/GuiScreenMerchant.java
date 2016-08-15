package com.parzivail.pswm.gui;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.items.ItemQuestLog;
import com.parzivail.pswm.network.MessagePlayerBuyItem;
import com.parzivail.pswm.network.MessageSetQuestLogNbt;
import com.parzivail.pswm.quest.QuestStats;
import com.parzivail.pswm.quest.QuestUtils;
import com.parzivail.pswm.tileentities.TileEntityMV;
import com.parzivail.pswm.tileentities.TileEntityStaticNpc;
import com.parzivail.pswm.vehicles.VehicJakkuSpeeder;
import com.parzivail.pswm.vehicles.VehicLandspeeder;
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
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@SideOnly(Side.CLIENT)
public class GuiScreenMerchant extends GuiScreen
{
	private EntityPlayer player;
	private static final ResourceLocation background = new ResourceLocation(Resources.MODID, "textures/gui/space.png");

	private OutlineButton bTabMisc;

	private Map<String, OutlineButton> listBMisc;

	private ItemStack stackShowing;
	private Entity entityShowing;
	private TileEntity tileShowing;
	private ItemRenderer renderItem = RenderManager.instance.itemRenderer;
	private TileEntityStaticNpc staticNpc;

	private String showingTitle = "";
	private String showingDesc = "";

	Consumer<OutlineButton> fixMV;
	Consumer<OutlineButton> fixLandspeeder;
	Consumer<OutlineButton> fixSaddle;
	Consumer<OutlineButton> fixBinocs;
	Consumer<OutlineButton> currentFix = null;

	Consumer<EntityPlayer> onBuyClick = null;

	private OutlineButtonCreditCounter bBuy;
	private ItemStack[] buyItemStacks;

	public GuiScreenMerchant(EntityPlayer player, TileEntityStaticNpc tileEntity)
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
		bTabMisc = new OutlineButton(id++, xTab += 50, 10, 40, 20, LangUtils.translate("misc"), false);

		buttonList.add(bTabMisc);

		ScaledResolution r = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		bBuy = new OutlineButtonCreditCounter(id++, r.getScaledWidth() - 100, 10, 80, 20, player);
		buttonList.add(bBuy);

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

		OutlineButtonTileEntity bMiscMV = new OutlineButtonTileEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bMiscMV.setup(new TileEntityMV(), fixMV = outlineButton ->
		{
			if (outlineButton != null)
				GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 27f, 50);
			GL11.glTranslatef(0, 22, 0);
			P3D.glScalef(9f);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(10, 1, 0, 0);
			GL11.glRotatef((System.currentTimeMillis() / (outlineButton == null ? 30 : 15)) % 360, 0, 1, 0);
		}, postRenderEmpty);
		listBMisc.put("bMiscMV", bMiscMV);

		OutlineButtonItemStack bMiscSaddle = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bMiscSaddle.setup(new ItemStack(Items.saddle), fixSaddle = outlineButton ->
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
		listBMisc.put("bMiscSaddle", bMiscSaddle);

		x = 0;
		y++;

		OutlineButtonItemStack bMiscBinocs = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bMiscBinocs.setup(new ItemStack(StarWarsItems.binoculars), fixBinocs = outlineButton ->
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
		listBMisc.put("bMiscBinocs", bMiscBinocs);

		OutlineButtonEntity bShipLandspeeder = new OutlineButtonEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		VehicLandspeeder landspeeder = new VehicLandspeeder(player.worldObj);
		bShipLandspeeder.setup(landspeeder, fixLandspeeder = outlineButton ->
		{
			if (outlineButton != null)
			{
				GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 35f, 50);
				GL11.glTranslatef(0, 14, 0);
			}
			else
			{
				GL11.glTranslatef(0, -28, 0);
				P3D.glScalef(4f);
			}
			P3D.glScalef(7f);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(30, 1, 0, 0);
			GL11.glRotatef((System.currentTimeMillis() / (outlineButton == null ? 30 : 15)) % 360, 0, 1, 0);
			GL11.glTranslatef(0, 0, -1f);
		}, postRenderEmpty);
		listBMisc.put("bShipLandspeeder", bShipLandspeeder);

		x = 0;
		y++;

		OutlineButtonEntity bShipjakku = new OutlineButtonEntity(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		VehicJakkuSpeeder jakku = new VehicJakkuSpeeder(player.worldObj);
		bShipjakku.setup(jakku, fixLandspeeder = outlineButton ->
		{
			if (outlineButton != null)
			{
				GL11.glTranslatef(outlineButton.width / 2f, outlineButton.height - 35f, 50);
				GL11.glTranslatef(0, 18, 0);
			}
			else
			{
				GL11.glTranslatef(0, -30, 0);
				P3D.glScalef(4f);
			}
			P3D.glScalef(7f);
			GL11.glScalef(1, -1, 1);
			GL11.glRotatef(30, 1, 0, 0);
			GL11.glRotatef((System.currentTimeMillis() / (outlineButton == null ? 30 : 15)) % 360, 0, 1, 0);
			GL11.glTranslatef(0, 0, -1f);
		}, postRenderEmpty);
		listBMisc.put("bShipjakku", bShipjakku);

		OutlineButtonItemStack bMiscShard = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bMiscShard.setup(new ItemStack(StarWarsItems.lightsaberCrystal, 1, 11), fixBinocs = outlineButton ->
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
		listBMisc.put("bMiscShard", bMiscShard);

		setTabMisc();
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
				if (onBuyClick != null && bBuy.getCurrentCost() <= QuestUtils.getPlayerBronzeCredits(player))
					onBuyClick.accept(player);
				StarWarsMod.network.sendToServer(new MessagePlayerBuyItem(player, buyItemStacks, bBuy.getCurrentCost()));
			}
			else if (button.id == listBMisc.get("bMiscMV").id)
			{
				currentFix = fixMV;

				stackShowing = null;
				entityShowing = null;
				tileShowing = ((OutlineButtonTileEntity)listBMisc.get("bMiscMV")).tileEntity;

				onBuyClick = null;

				showingTitle = "GX-8 Moisture Vaporator";
				showingDesc = "The standard model and a hard worker, well worth the investment.";

				bBuy.setCurrentCost(16);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsMod.blockMV, 1) };
			}
			else if (button.id == listBMisc.get("bMiscSaddle").id)
			{
				currentFix = fixSaddle;

				tileShowing = null;
				entityShowing = null;
				stackShowing = ((OutlineButtonItemStack)listBMisc.get("bMiscSaddle")).itemStack;

				onBuyClick = null;

				showingTitle = "Saddle";
				showingDesc = "Just what you need if you're going to be riding any Banthas or Dewbacks.";

				bBuy.setCurrentCost(32);
				buyItemStacks = new ItemStack[] { new ItemStack(Items.saddle, 1) };
			}
			else if (button.id == listBMisc.get("bMiscBinocs").id)
			{
				currentFix = fixBinocs;

				tileShowing = null;
				entityShowing = null;
				stackShowing = ((OutlineButtonItemStack)listBMisc.get("bMiscBinocs")).itemStack;

				onBuyClick = null;

				showingTitle = "Macrobinoculars";
				showingDesc = "Always keep a pair of these on ya if you wanna be safe from Tusken attacks.";

				bBuy.setCurrentCost(64);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.binoculars, 1) };
			}
			else if (button.id == listBMisc.get("bShipLandspeeder").id)
			{
				currentFix = fixLandspeeder;

				tileShowing = null;
				stackShowing = null;
				entityShowing = ((OutlineButtonEntity)listBMisc.get("bShipLandspeeder")).entity;

				onBuyClick = player1 ->
				{
					ItemQuestLog.addStat(player1, QuestStats.LICENSE_LANDSPEEDER);
					StarWarsMod.network.sendToServer(new MessageSetQuestLogNbt(player1, ItemQuestLog.getQuestContainer(player1).stackTagCompound));
				};

				showingTitle = "X-34 Landspeeder";
				showingDesc = "A great work-horse speeder that'll last for a long time.  It's not as fast as the Swoop Speeder I've got, but it'll get the job done.";

				bBuy.setCurrentCost(256);
				buyItemStacks = new ItemStack[] {};
			}
			else if (button.id == listBMisc.get("bShipjakku").id)
			{
				currentFix = fixLandspeeder;

				tileShowing = null;
				stackShowing = null;
				entityShowing = ((OutlineButtonEntity)listBMisc.get("bShipjakku")).entity;

				onBuyClick = player1 ->
				{
					ItemQuestLog.addStat(player1, QuestStats.LICENSE_JAKKU_SPEEDER);
					StarWarsMod.network.sendToServer(new MessageSetQuestLogNbt(player1, ItemQuestLog.getQuestContainer(player1).stackTagCompound));
				};

				showingTitle = "Swoop Speeder";
				showingDesc = "Some scavenger girl came through here and sold this for cheap.  This machine is fast and lean, you won't find anything else like it in Mos Eisley.";

				bBuy.setCurrentCost(320);
				buyItemStacks = new ItemStack[] {};
			}
			else if (button.id == listBMisc.get("bMiscShard").id)
			{
				currentFix = fixBinocs;

				tileShowing = null;
				entityShowing = null;
				stackShowing = ((OutlineButtonItemStack)listBMisc.get("bMiscShard")).itemStack;

				onBuyClick = null;

				showingTitle = "Unknown";
				showingDesc = "I don't know what this thing is, but it seems to have some kind of dark energy coming from it.";

				bBuy.setCurrentCost(640);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.lightsaberCrystal, 1, 11) };
			}
		}
	}

	private void setTabMisc()
	{
		bTabMisc.selected = true;

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

			if (currentFix != null)
				currentFix.accept(null);

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