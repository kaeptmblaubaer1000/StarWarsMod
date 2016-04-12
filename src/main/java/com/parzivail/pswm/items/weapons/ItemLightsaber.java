package com.parzivail.pswm.items.weapons;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.network.MessageSetPlayerHolding;
import com.parzivail.util.MathUtils;
import com.parzivail.util.ui.GLPalette;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemLightsaber extends ItemSword
{
	public static final String nbtHilt = "hilt";
	public static final String nbtBladeLength = "bladeLength";
	public static final String nbtBladeColor = "bladeColor";
	public static final String nbtHiltSkin = "skin";
	public static final String nbtBladeWaterproof = "waterproof";
	public static final String nbtBladeDistortion = "distortion";
	public static final String nbtBladeOn = "on";
	public static final String nbtBladeTimeout = "timeout";

	// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
	public static final String[] hilts = { "dooku", "ezra", "kanan", "maul", "padawan", "shoto", "doubleSith", "vader2", "luke1", "luke2", "crossguard", "malgus", "obiwan", "quigon", "revan", "starkiller" };
	public static int[] colorHex = { 0xFFFFFF00, 0xFFFF4F89, 0xFFE066FF, 0xFFF2F2F2, 0xFF595959, 0xFFFF5A00, 0xFF00E5EE, 0xFF191919, 0xFFFF0000, 0xFF00FF00, 0xFF0000FF };
	public static int[] colorHexNew = { 0xFFFFFF00, 0xFFFF00DC, 0xFFB20078, 0xFFFFFFFF, 0xFFA0A0A0, 0xFF202020, 0xFFFF6A00, 0xFF00CC9C, 0xFFFF0000, 0xFF00FF00, 0xFF0000FF, 0xFFFF5200 };
	//public static final String[] colorName = { "yellow", "pink", "purple", "white", "gray", "orange", "teal", "black", "red", "green", "blue" };

	static
	{
		colorHex = colorHexNew;
		ArrayList<Integer> n = new ArrayList<>();
		for (int i = 0; i < colorHex.length; i++)
			n.add(colorHex[i]);
		Collections.sort(n, new Comparator<Integer>()
		{
			@Override
			public int compare(Integer i1, Integer i2)
			{
				Color c1 = GLPalette.intToColor(i1);
				Color c2 = GLPalette.intToColor(i2);
				float[] hsb1 = Color.RGBtoHSB(c1.getRed(), c1.getGreen(), c1.getBlue(), null);
		        float[] hsb2 = Color.RGBtoHSB(c2.getRed(), c2.getGreen(), c2.getBlue(), null);
		        if (hsb1[0] < hsb2[0])
		            return -1;
		        if (hsb1[0] > hsb2[0])
		            return 1;
		        if (hsb1[1] < hsb2[1])
		            return -1;
		        if (hsb1[1] > hsb2[1])
		            return 1;
		        if (hsb1[2] < hsb2[2])
		            return -1;
		        if (hsb1[2] > hsb2[2])
		            return 1;
		        return 0;
			}
		});
		colorHex = MathUtils.toIntArray(n);
	}

	public int hiltIndex;

	private String name = "lightsaberNew";

	public ItemLightsaber(int hiltIndex)
	{
		super(StarWarsMod.materialPlasma);
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.setTextureName(Resources.MODID + ":" + "blank");

		this.hiltIndex = hiltIndex;
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity holder, int a, boolean b)
	{
		super.onUpdate(stack, world, holder, a, b);

		if (!stack.hasTagCompound())
		{
			setupNBT(this.hiltIndex, stack);
		}

		if (stack.stackTagCompound.getInteger(nbtBladeTimeout) > 0)
			stack.stackTagCompound.setInteger(nbtBladeTimeout, stack.stackTagCompound.getInteger(nbtBladeTimeout) - 1);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		// if (stack.stackTagCompound != null)
		// {
		// list.add("Hilt: " + stack.stackTagCompound.getString(nbtHilt));
		// }
	}

	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.getBoolean(nbtBladeOn))
			entityLiving.playSound(Resources.MODID + ":" + "item.lightsaber.swing", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(Item.itemRand, -0.2D, 0.2D));
		return super.onEntitySwing(entityLiving, stack);

	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World p_77659_2_, EntityPlayer player)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.getInteger(nbtBladeTimeout) <= 0 && player.isSneaking())
		{
			if (stack.stackTagCompound.getBoolean(nbtBladeOn))
				player.playSound(Resources.MODID + ":" + "item.lightsaber.close", 1.0F, 1.0F);
			else
				player.playSound(Resources.MODID + ":" + "item.lightsaber.open", 1.0F, 1.0F);
			stack.stackTagCompound.setBoolean(nbtBladeOn, !stack.stackTagCompound.getBoolean(nbtBladeOn));
			stack.stackTagCompound.setInteger(nbtBladeTimeout, 10);
			StarWarsMod.network.sendToServer(new MessageSetPlayerHolding(player, stack));
		}
		return super.onItemRightClick(stack, p_77659_2_, player);
	}

	public static void setupNBT(int hilt, ItemStack stack)
	{
		NBTTagCompound nbt = new NBTTagCompound();

		nbt.setString(nbtHilt, hilts[hilt]);

		/*
		 * Blade Length (int - 0: short, 1: medium, 2: long)
		 */
		if (hilt == 4)
			nbt.setInteger(nbtBladeLength, 1);
		else
			nbt.setInteger(nbtBladeLength, 2);

		/*
		 * Blade Color (int - 0xRRGGBB)
		 */
		if (hilt == 0 || hilt == 3 || hilt == 5 || hilt == 6 || hilt == 7 || hilt == 10 || hilt == 11 || hilt == 15)
			nbt.setInteger(nbtBladeColor, 0xFF0000); // red
		else if (hilt == 4 || hilt == 9 || hilt == 13 || hilt == 14)
			nbt.setInteger(nbtBladeColor, 0x00FF00); // green
		else if (hilt == 1 || hilt == 2 || hilt == 8 || hilt == 12)
			nbt.setInteger(nbtBladeColor, 0x0000FF); // blue
		else
			nbt.setInteger(nbtBladeColor, 0xFFFFFF); // blue

		/*
		 * Blade Skin (int - 0: normal, 1: alternate)
		 */
		nbt.setInteger(nbtHiltSkin, 0);

		/*
		 * Blade Waterproofing (boolean - true: on, false: off)
		 */
		nbt.setBoolean(nbtBladeWaterproof, false);

		/*
		 * Blade Distortion ["kylo rendering"] (boolean)
		 */
		if (hilt == 10)
			nbt.setBoolean(nbtBladeDistortion, true);
		else
			nbt.setBoolean(nbtBladeDistortion, false);

		nbt.setBoolean(nbtBladeOn, false);

		nbt.setInteger(nbtBladeTimeout, 0);

		stack.stackTagCompound = nbt;
	}
}