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
import com.parzi.starwarsmod.entities.EntityBlasterRifleBolt;
import com.parzi.starwarsmod.utils.KeyboardUtils;
import com.parzi.starwarsmod.utils.TextUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSequelBlasterRifle extends Item
{
	public String name = "sequelBlasterRifle";
	private int timeSinceLastShot = 0;
	private int timeToRecharge = 8;
	public String[] versions = { "F11d" };
	public int subtypes = this.versions.length;
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public ItemSequelBlasterRifle()
	{
		this.setCreativeTab(StarWarsMod.SequelStarWarsTab);
		this.setHasSubtypes(true);
		this.setTextureName(StarWarsMod.MODID + ":" + this.name);
		this.maxStackSize = 1;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add(TextUtils.makeItalic("Used by legion troopers or something"));
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("shotsLeft")) list.add("Shots Remaining: " + stack.stackTagCompound.getInteger("shotsLeft"));
	}

	@Override
	public IIcon getIconFromDamage(int par1)
	{
		return this.icons[par1];
	}

	public ItemStack getMeta(String string)
	{
		return new ItemStack(StarWarsMod.blasterRifle, 1, this.indexOfMeta(string));
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
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer entityPlayer)
	{
		if (par1ItemStack.stackTagCompound.getInteger("timeout") < 2) if (par1ItemStack.stackTagCompound.getInteger("shotsLeft") > 1)
		{
			entityPlayer.playSound(StarWarsMod.MODID + ":" + "item.blasterRifle.use", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(Item.itemRand, -0.2D, 0.2D));
		}
		else
			entityPlayer.playSound(StarWarsMod.MODID + ":" + "item.blasterRifle.break", 1.0F, 1.0F);
		if (!par2World.isRemote && par1ItemStack.stackTagCompound.getInteger("timeout") == 0)
		{
			par2World.spawnEntityInWorld(new EntityBlasterRifleBolt(par2World, entityPlayer));
			if (par1ItemStack.getItemDamage() == 3)
				par1ItemStack.stackTagCompound.setInteger("timeout", this.timeToRecharge + 10);
			else
				par1ItemStack.stackTagCompound.setInteger("timeout", this.timeToRecharge);
			par1ItemStack.stackTagCompound.setInteger("shotsLeft", par1ItemStack.stackTagCompound.getInteger("shotsLeft") - 1);
			if (par1ItemStack.stackTagCompound.getInteger("shotsLeft") == 0) entityPlayer.inventory.mainInventory[entityPlayer.inventory.currentItem] = null;
		}
		entityPlayer.addStat(StarWarsAchievements.fireBlaster, 1);
		return par1ItemStack;
	}

	@Override
	public void onUpdate(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_)
	{
		if (!p_77663_1_.hasTagCompound()) p_77663_1_.stackTagCompound = new NBTTagCompound();
		if (!p_77663_1_.stackTagCompound.hasKey("timeout")) p_77663_1_.stackTagCompound.setInteger("timeout", 0);
		if (!p_77663_1_.stackTagCompound.hasKey("shotsLeft")) switch (p_77663_1_.getItemDamage())
		{
			case 0:
			case 3:
				p_77663_1_.stackTagCompound.setInteger("shotsLeft", 180);
			case 4:
				p_77663_1_.stackTagCompound.setInteger("shotsLeft", itemRand.nextBoolean() ? 500 : 100);
				break;
			case 1:
			case 2:
			default:
				p_77663_1_.stackTagCompound.setInteger("shotsLeft", 250);
		}
		if (p_77663_1_.stackTagCompound.getInteger("timeout") > 0) p_77663_1_.stackTagCompound.setInteger("timeout", p_77663_1_.stackTagCompound.getInteger("timeout") - 1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.icons = new IIcon[this.versions.length];
		for (int i = 0; i < this.icons.length; i++)
			this.icons[i] = par1IconRegister.registerIcon(StarWarsMod.MODID + ":" + this.name + "_" + this.versions[i]);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\items\weapons\ItemBlasterRifle.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */