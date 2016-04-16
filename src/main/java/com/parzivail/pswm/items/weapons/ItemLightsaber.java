package com.parzivail.pswm.items.weapons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.network.MessageSetPlayerHolding;
import com.parzivail.util.IntColorComparator;
import com.parzivail.util.MathUtils;
import com.parzivail.util.ui.GLPalette;

import net.minecraft.block.material.Material;
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
	public static final String nbtBlasterTimeout = "blasterTimeout";

	// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
	public static final String[] hilts = { "obiwan", "quigon", "maul", "padawan", "dooku", "luke1", "vader2", "luke2", "crossguard", "kanan", "ezra", "revan", "malgus", "doubleSith", "starkiller", "shoto" };
	public static int[] colorHex = { 0xFFFF00, 0xFF4F89, 0xE066FF, 0xF2F2F2, 0x595959, 0xFF5A00, 0x00E5EE, 0x191919, 0xFF0000, 0x00FF00, 0x0000FF };
	// public static final String[] colorName = { "yellow", "pink", "purple",
	// "white", "gray", "orange", "teal", "black", "red", "green", "blue" };
	public static int[] colorHexNew = { 0xFFFF2B, 0xFF00DC, 0xB069DB, 0xFFFFFF, 0xA0A0A0, 0x202020, 0xFF6A00, 0x2FD0F6, 0xFF0000, 0x00FF48, 0x2448DA, 0xFF5200 };

	static
	{
		colorHex = colorHexNew;
		ArrayList<Integer> n = new ArrayList<>();
		for (int i = 0; i < colorHex.length; i++)
			n.add(GLPalette.makeOpaque(colorHex[i]));
		Collections.sort(n, new IntColorComparator());
		colorHex = MathUtils.toIntArray(n);
	}

	public int hiltIndex;

	private String name = "lightsaberNew";

	public ItemLightsaber(int hiltIndex)
	{
		super(StarWarsMod.materialNoDamage);
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

		if (stack.stackTagCompound.getInteger(nbtBlasterTimeout) > 0)
			stack.stackTagCompound.setInteger(nbtBlasterTimeout, stack.stackTagCompound.getInteger(nbtBlasterTimeout) - 1);

		if (world.isRemote && !stack.stackTagCompound.getBoolean(nbtBladeWaterproof) && holder.isInsideOfMaterial(Material.water) && stack.stackTagCompound.getBoolean(nbtBladeOn))
		{
			stack.stackTagCompound.setBoolean(nbtBladeOn, false);
			stack.stackTagCompound.setInteger(nbtBladeTimeout, 10);
			if (holder instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer)holder;
				player.playSound(Resources.MODID + ":" + "item.lightsaber.fizz", 1.0F, 1.0F);
				StarWarsMod.network.sendToServer(new MessageSetPlayerHolding(player, stack));
			}
		}
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
			if (!stack.stackTagCompound.getBoolean(nbtBladeWaterproof) && player.isInsideOfMaterial(Material.water))
			{
				stack.stackTagCompound.setInteger(nbtBladeTimeout, 10);
				player.playSound(Resources.MODID + ":" + "item.lightsaber.fizz", 1.0F, 1.0F);
			}
			else
			{
				if (stack.stackTagCompound.getBoolean(nbtBladeOn))
					player.playSound(Resources.MODID + ":" + "item.lightsaber.close", 1.0F, 1.0F);
				else
					player.playSound(Resources.MODID + ":" + "item.lightsaber.open", 1.0F, 1.0F);
				stack.stackTagCompound.setBoolean(nbtBladeOn, !stack.stackTagCompound.getBoolean(nbtBladeOn));
				stack.stackTagCompound.setInteger(nbtBladeTimeout, 10);
				StarWarsMod.network.sendToServer(new MessageSetPlayerHolding(player, stack));
			}
		}
		return super.onItemRightClick(stack, p_77659_2_, player);
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase victim, EntityLivingBase attacker)
	{
		if (victim instanceof EntityPlayer && attacker instanceof EntityPlayer)
		{
			EntityPlayer vPlayer = (EntityPlayer)victim;
			EntityPlayer aPlayer = (EntityPlayer)attacker;
			ItemStack vHolding = vPlayer.inventory.getCurrentItem();
			ItemStack aHolding = aPlayer.inventory.getCurrentItem();
			if (vHolding != null && vHolding.getItem() instanceof ItemLightsaber && vPlayer.isBlocking() && aHolding != null && aHolding.getItem() instanceof ItemLightsaber)
			{
				vPlayer.playSound(Resources.MODID + ":" + "item.lightsaber.crash", 1, 1);
				aPlayer.playSound(Resources.MODID + ":" + "item.lightsaber.crash", 1, 1);
			}
		}
		
		if (stack.stackTagCompound != null)
		{
			float damage = stack.stackTagCompound.getBoolean(nbtBladeOn) ? 30 : 0;
			victim.attackEntityFrom(StarWarsMod.saberDamageSource, damage);
		}
		else
		{
			victim.attackEntityFrom(StarWarsMod.saberDamageSource, 0);
		}
		return true;
	}

	public static void setupNBT(int hilt, ItemStack stack)
	{
		NBTTagCompound nbt = new NBTTagCompound();

		nbt.setString(nbtHilt, hilts[hilt]);
		String s = hilts[hilt];

		/*
		 * Blade Length (int - 0: short, 1: medium, 2: long)
		 */
		if (s.equals("padawan"))
			nbt.setInteger(nbtBladeLength, 1);
		else
			nbt.setInteger(nbtBladeLength, 2);

		/*
		 * Blade Color (int - 0xRRGGBB)
		 */
		if (s.equals("maul") || s.equals("dooku") || s.equals("vader2") || s.equals("malgus") || s.equals("doubleSith") || s.equals("starkiller"))
			nbt.setInteger(nbtBladeColor, 0xFF0000); // red
		else if (s.equals("quigon") || s.equals("padawan") || s.equals("luke2"))
			nbt.setInteger(nbtBladeColor, 0x00FF48); // green
		else if (s.equals("obiwan") || s.equals("luke1") || s.equals("kanan") || s.equals("ezra") || s.equals("revan") || s.equals("shoto"))
			nbt.setInteger(nbtBladeColor, 0x2448DA); // blue
		else if (s.equals("crossguard"))
			nbt.setInteger(nbtBladeColor, 0xFF5200); // red-orange
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
		if (s.equals("crossguard"))
			nbt.setBoolean(nbtBladeDistortion, true);
		else
			nbt.setBoolean(nbtBladeDistortion, false);

		nbt.setBoolean(nbtBladeOn, false);

		nbt.setInteger(nbtBladeTimeout, 0);

		nbt.setInteger(nbtBlasterTimeout, 0);

		stack.stackTagCompound = nbt;
	}
}