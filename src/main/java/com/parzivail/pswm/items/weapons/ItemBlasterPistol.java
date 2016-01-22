package com.parzivail.pswm.items.weapons;

import java.util.Arrays;
import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.achievement.StarWarsAchievements;
import com.parzivail.pswm.entities.EntityBlasterPistolBolt;
import com.parzivail.util.ui.KeyboardUtils;
import com.parzivail.util.ui.TextUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlasterPistol extends Item
{
	public String name = "blasterPistol";
	private int timeSinceLastShot = 0;
	private int timeToRecharge = 6;
	public String[] versions = { "Dl44", "Dl18", "Dh17", "Sporting", "Dl21", "Scout", "Se14c" };
	public int subtypes = this.versions.length;
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public ItemBlasterPistol()
	{
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.setHasSubtypes(true);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.maxStackSize = 1;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		if (KeyboardUtils.isShiftDown())
		{
			list.add(TextUtils.makeItalic("The blaster rifle was the staple"));
			list.add(TextUtils.makeItalic("infantry weapon since before the"));
			list.add(TextUtils.makeItalic("formation of the Galactic Republic"));
		}
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("shotsLeft"))
			list.add("Shots Remaining: " + stack.stackTagCompound.getInteger("shotsLeft"));
	}

	@Override
	public IIcon getIconFromDamage(int par1)
	{
		return this.icons[par1];
	}

	public ItemStack getMeta(String string)
	{
		return new ItemStack(StarWarsMod.blasterPistol, 1, this.indexOfMeta(string));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int x = 0; x < this.versions.length; x++)
			par3List.add(new ItemStack(this, 1, x));
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		int metadata = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
		return "item.starwarsmod." + this.name + "." + this.versions[metadata];
	}

	private int indexOfMeta(String needle)
	{
		return Arrays.asList(this.versions).indexOf(needle);
	}

	@Override
	public boolean isFull3D()
	{
		return true;
	}

	@Override
	public boolean hasEffect(ItemStack stack, int pass)
	{
		return getCooldown(stack) >= 15;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (getCooldown(stack) < 15)
		{
			if (stack.stackTagCompound.getInteger("shotsLeft") > 1)
				player.playSound(Resources.MODID + ":" + "fx.shoot." + this.versions[MathHelper.clamp_int(stack.getItemDamage(), 0, 15)].toLowerCase(), 1.0F, 1.0F);
			else
				player.playSound(Resources.MODID + ":" + "item.blasterRifle.break", 1.0F, 1.0F);
		}

		if (!world.isRemote && getCooldown(stack) < 15)
		{
			world.spawnEntityInWorld(new EntityBlasterPistolBolt(world, player));

			setCooldown(stack, getCooldown(stack) + 1);
			setTicksSinceLastShot(stack, 0);

			stack.stackTagCompound.setInteger("shotsLeft", stack.stackTagCompound.getInteger("shotsLeft") - 1);

			if (stack.stackTagCompound.getInteger("shotsLeft") <= 0)
				player.inventory.mainInventory[player.inventory.currentItem] = null;
		}

		player.addStat(StarWarsAchievements.fireBlaster, 1);

		return stack;
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_)
	{
		if (!world.isRemote)
		{
			if (!stack.hasTagCompound())
				stack.stackTagCompound = new NBTTagCompound();

			if (!stack.stackTagCompound.hasKey("shotsLeft"))
				switch (stack.getItemDamage())
			{
				case 0:
						stack.stackTagCompound.setInteger("shotsLeft", 180);
					break;
				case 3:
				case 4:
						stack.stackTagCompound.setInteger("shotsLeft", 80);
					break;
				case 1:
				case 2:
				default:
						stack.stackTagCompound.setInteger("shotsLeft", 100);
				}

			if (getTicksSinceLastShot(stack) <= 40 * ((getCooldown(stack) + 1) / 15f))
				this.setTicksSinceLastShot(stack, getTicksSinceLastShot(stack) + 1);

			if (getTicksSinceLastShot(stack) > 40 * ((getCooldown(stack) + 1) / 15f))
			{
				this.setTicksSinceLastShot(stack, 0);
				this.setCooldown(stack, 0);
			}
		}
	}

	public static int getShotsLeft(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtShotsLeft))
			return stack.stackTagCompound.getInteger(Resources.nbtShotsLeft);
		return 0;
	}

	public static void setShotsLeft(ItemStack stack, int i)
	{
		if (stack.stackTagCompound != null)
			stack.stackTagCompound.setInteger(Resources.nbtShotsLeft, i);
	}

	public static int getCooldown(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtCooldown))
			return stack.stackTagCompound.getInteger(Resources.nbtCooldown);
		return 0;
	}

	public static void setCooldown(ItemStack stack, int i)
	{
		if (stack.stackTagCompound != null)
			stack.stackTagCompound.setInteger(Resources.nbtCooldown, i);
	}

	public static int getTicksSinceLastShot(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtTicksSince))
			return stack.stackTagCompound.getInteger(Resources.nbtTicksSince);
		return 0;
	}

	public static void setTicksSinceLastShot(ItemStack stack, int i)
	{
		if (stack.stackTagCompound != null)
			stack.stackTagCompound.setInteger(Resources.nbtTicksSince, i);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.icons = new IIcon[this.versions.length];
		for (int i = 0; i < this.icons.length; i++)
			this.icons[i] = par1IconRegister.registerIcon(Resources.MODID + ":" + this.name + "_" + this.versions[i]);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\items\weapons\ItemBlasterPistol.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */