package com.parzivail.pswm.gui;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.network.MessagePlayerBuyItem;
import com.parzivail.pswm.tileentities.TileEntityStaticNpc;
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

	private OutlineButton bTabMisc;

	private Map<String, OutlineButton> listBMisc;

	private ItemStack stackShowing;
	private Entity entityShowing;
	private TileEntity tileShowing;
	private ItemRenderer renderItem = RenderManager.instance.itemRenderer;
	private TileEntityStaticNpc staticNpc;

	private String showingTitle = "";
	private String showingDesc = "";

	Consumer<OutlineButton> fixItem;
	Consumer<OutlineButton> currentFix = null;

	private OutlineButtonCreditCounter bBuy;
	private ItemStack[] buyItemStacks;

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
		bTabMisc = new OutlineButton(id++, xTab += 50, 10, 40, 20, LangUtils.translate("misc"), false);

		buttonList.add(bTabMisc);

		ScaledResolution r = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		bBuy = new OutlineButtonCreditCounter(id++, r.getScaledWidth() - 100, 10, 80, 20, player);
		buttonList.add(bBuy);

		listBMisc = new HashMap<>();

		int x = 0;
		int y = 0;

		Consumer<OutlineButton> postRenderEmpty = outlineButton ->
		{
		};

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

		OutlineButtonItemStack bBanthaChop = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bBanthaChop.setup(new ItemStack(StarWarsItems.banthaChop), fixItem, postRenderEmpty, false, player);
		listBMisc.put("bBanthaChop", bBanthaChop);

		OutlineButtonItemStack bBanthaChopCooked = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bBanthaChopCooked.setup(new ItemStack(StarWarsItems.banthaChopCooked), fixItem, postRenderEmpty, false, player);
		listBMisc.put("bBanthaChopCooked", bBanthaChopCooked);

		OutlineButtonItemStack bBanthaPlatter = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bBanthaPlatter.setup(new ItemStack(StarWarsItems.banthaPlatter), fixItem, postRenderEmpty, false, player);
		listBMisc.put("bBanthaPlatter", bBanthaPlatter);

		x = 0;
		y++;

		OutlineButtonItemStack bDewRibs = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bDewRibs.setup(new ItemStack(StarWarsItems.dewbackRibs), fixItem, postRenderEmpty, false, player);
		listBMisc.put("bDewRibs", bDewRibs);

		OutlineButtonItemStack bChasuka = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bChasuka.setup(new ItemStack(StarWarsItems.chasuka), fixItem, postRenderEmpty, false, player);
		listBMisc.put("bChasuka", bChasuka);

		OutlineButtonItemStack bCanron = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bCanron.setup(new ItemStack(StarWarsItems.canron), fixItem, postRenderEmpty, false, player);
		listBMisc.put("bCanron", bCanron);

		x = 0;
		y++;

		OutlineButtonItemStack bAcidbeets = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bAcidbeets.setup(new ItemStack(StarWarsItems.acidBeets), fixItem, postRenderEmpty, false, player);
		listBMisc.put("bAcidbeets", bAcidbeets);

		OutlineButtonItemStack bGorrnar = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bGorrnar.setup(new ItemStack(StarWarsItems.gorrnar), fixItem, postRenderEmpty, false, player);
		listBMisc.put("bGorrnar", bGorrnar);

		OutlineButtonItemStack bBanthaMilk = new OutlineButtonItemStack(id++, x++ * 65 + 10, y * 65 + 40, 55, 55);
		bBanthaMilk.setup(new ItemStack(StarWarsItems.banthaMilk), fixItem, postRenderEmpty, false, player);
		listBMisc.put("bBanthaMilk", bBanthaMilk);

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
				StarWarsMod.network.sendToServer(new MessagePlayerBuyItem(player, buyItemStacks, bBuy.getCurrentCost()));
			}
			else if (button.id == listBMisc.get("bBanthaChop").id)
			{
				currentFix = fixItem;

				tileShowing = null;
				entityShowing = null;
				stackShowing = ((OutlineButtonItemStack)listBMisc.get("bBanthaChop")).itemStack;

				showingTitle = "saddle";
				showingDesc = "sitty";

				bBuy.setCurrentCost(8);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.banthaChop, 1) };
			}
			else if (button.id == listBMisc.get("bBanthaChopCooked").id)
			{
				currentFix = fixItem;

				tileShowing = null;
				entityShowing = null;
				stackShowing = ((OutlineButtonItemStack)listBMisc.get("bBanthaChopCooked")).itemStack;

				showingTitle = "saddle";
				showingDesc = "sitty";

				bBuy.setCurrentCost(12);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.banthaChopCooked, 1) };
			}
			else if (button.id == listBMisc.get("bBanthaPlatter").id)
			{
				currentFix = fixItem;

				tileShowing = null;
				entityShowing = null;
				stackShowing = ((OutlineButtonItemStack)listBMisc.get("bBanthaPlatter")).itemStack;

				showingTitle = "saddle";
				showingDesc = "sitty";

				bBuy.setCurrentCost(16);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.banthaPlatter, 1) };
			}
			else if (button.id == listBMisc.get("bDewRibs").id)
			{
				currentFix = fixItem;

				tileShowing = null;
				entityShowing = null;
				stackShowing = ((OutlineButtonItemStack)listBMisc.get("bDewRibs")).itemStack;

				showingTitle = "saddle";
				showingDesc = "sitty";

				bBuy.setCurrentCost(16);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.dewbackRibs, 1) };
			}
			else if (button.id == listBMisc.get("bChasuka").id)
			{
				currentFix = fixItem;

				tileShowing = null;
				entityShowing = null;
				stackShowing = ((OutlineButtonItemStack)listBMisc.get("bChasuka")).itemStack;

				showingTitle = "saddle";
				showingDesc = "sitty";

				bBuy.setCurrentCost(8);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.chasuka, 1) };
			}
			else if (button.id == listBMisc.get("bCanron").id)
			{
				currentFix = fixItem;

				tileShowing = null;
				entityShowing = null;
				stackShowing = ((OutlineButtonItemStack)listBMisc.get("bCanron")).itemStack;

				showingTitle = "saddle";
				showingDesc = "sitty";

				bBuy.setCurrentCost(8);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.canron, 1) };
			}
			else if (button.id == listBMisc.get("bAcidbeets").id)
			{
				currentFix = fixItem;

				tileShowing = null;
				entityShowing = null;
				stackShowing = ((OutlineButtonItemStack)listBMisc.get("bAcidbeets")).itemStack;

				showingTitle = "saddle";
				showingDesc = "sitty";

				bBuy.setCurrentCost(12);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.acidBeets, 1) };
			}
			else if (button.id == listBMisc.get("bGorrnar").id)
			{
				currentFix = fixItem;

				tileShowing = null;
				entityShowing = null;
				stackShowing = ((OutlineButtonItemStack)listBMisc.get("bGorrnar")).itemStack;

				showingTitle = "saddle";
				showingDesc = "sitty";

				bBuy.setCurrentCost(16);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.gorrnar, 1) };
			}
			else if (button.id == listBMisc.get("bBanthaMilk").id)
			{
				currentFix = fixItem;

				tileShowing = null;
				entityShowing = null;
				stackShowing = ((OutlineButtonItemStack)listBMisc.get("bBanthaMilk")).itemStack;

				showingTitle = "saddle";
				showingDesc = "sitty";

				bBuy.setCurrentCost(8);
				buyItemStacks = new ItemStack[] { new ItemStack(StarWarsItems.banthaMilk, 1) };
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