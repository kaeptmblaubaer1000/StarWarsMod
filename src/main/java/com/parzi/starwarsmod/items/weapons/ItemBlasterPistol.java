package com.parzi.starwarsmod.items.weapons;

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

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.achievement.StarWarsAchievements;
import com.parzi.starwarsmod.entities.EntityBlasterPistolBolt;
import com.parzi.starwarsmod.utils.KeyboardUtils;
import com.parzi.starwarsmod.utils.Lumberjack;
import com.parzi.starwarsmod.utils.TextUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlasterPistol extends Item
{
	private String name = "blasterPistol";
	private int timeSinceLastShot = 0;
	private int timeToRecharge = 6;

	public String[] versions = { "Dl44", "Dl18", "Dh17", "Sporting", "Dl21", "Scout" };
	public int subtypes = versions.length;

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public ItemBlasterPistol()
	{
		setCreativeTab(StarWarsMod.StarWarsTab);
		setHasSubtypes(true);
		setTextureName(StarWarsMod.MODID + ":" + name);
		maxStackSize = 1;
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
		{
			list.add("Shots Remaining: " + stack.stackTagCompound.getInteger("shotsLeft"));
		}
	}

	@Override
	public IIcon getIconFromDamage(int par1)
	{
		return icons[par1];
	}

	public ItemStack getMeta(String string)
	{
		return new ItemStack(StarWarsMod.blasterPistol, 1, indexOfMeta(string));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int x = 0; x < versions.length; x++)
		{
			par3List.add(new ItemStack(this, 1, x));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		int metadata = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
		return "item" + "." + StarWarsMod.MODID + "." + name + "." + versions[metadata];
	}

	private int indexOfMeta(String needle)
	{
		return Arrays.asList(versions).indexOf(needle);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer entityPlayer)
	{
		if (par1ItemStack.stackTagCompound.getInteger("timeout") < 2)
		{
			if (par1ItemStack.stackTagCompound.getInteger("shotsLeft") > 1)
			{
				entityPlayer.playSound(StarWarsMod.MODID + ":" + "item.blasterPistol.use", 1f, 1f + (float)MathHelper.getRandomDoubleInRange(Item.itemRand, -0.2D, 0.2D));
			}
			else
			{
				entityPlayer.playSound(StarWarsMod.MODID + ":" + "item.blasterRifle.break", 1f, 1f);
			}
		}

		if (!par2World.isRemote && par1ItemStack.stackTagCompound.getInteger("timeout") == 0)
		{
			par2World.spawnEntityInWorld(new EntityBlasterPistolBolt(par2World, entityPlayer));
			par1ItemStack.stackTagCompound.setInteger("timeout", timeToRecharge);

			par1ItemStack.stackTagCompound.setInteger("shotsLeft", par1ItemStack.stackTagCompound.getInteger("shotsLeft") - 1);
			if (par1ItemStack.stackTagCompound.getInteger("shotsLeft") == 0)
			{
				entityPlayer.inventory.mainInventory[entityPlayer.inventory.currentItem] = null;
			}
		}

		entityPlayer.addStat(StarWarsAchievements.fireBlaster, 1);

		return par1ItemStack;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack p_77615_1_, World p_77615_2_, EntityPlayer p_77615_3_, int p_77615_4_)
	{
		p_77615_1_.stackTagCompound.setInteger("timeout", 0);
	}

	@Override
	public void onUpdate(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_)
	{
		if (!p_77663_1_.hasTagCompound())
		{
			p_77663_1_.stackTagCompound = new NBTTagCompound();
		}

		if (!p_77663_1_.stackTagCompound.hasKey("timeout"))
		{
			p_77663_1_.stackTagCompound.setInteger("timeout", 0);
		}

		if (!p_77663_1_.stackTagCompound.hasKey("shotsLeft"))
		{
			switch (p_77663_1_.getItemDamage())
			{
				case 0:
					p_77663_1_.stackTagCompound.setInteger("shotsLeft", 180);
					break;
				case 3:
				case 4:
					p_77663_1_.stackTagCompound.setInteger("shotsLeft", 80);
					break;
				default:
					p_77663_1_.stackTagCompound.setInteger("shotsLeft", 100);
					break;
			}
		}

		if (p_77663_1_.stackTagCompound.getInteger("timeout") > 0)
		{
			p_77663_1_.stackTagCompound.setInteger("timeout", p_77663_1_.stackTagCompound.getInteger("timeout") - 1);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister par1IconRegister)
	{
		icons = new IIcon[versions.length];

		for (int i = 0; i < icons.length; i++)
		{
			icons[i] = par1IconRegister.registerIcon(StarWarsMod.MODID + ":" + name + "_" + versions[i]);
		}
	}
}
