package com.parzivail.pswm.items.weapons;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.achievement.StarWarsAchievements;
import com.parzivail.pswm.entities.EntityBlasterRifleBolt;
import com.parzivail.util.ui.LangUtils;
import com.parzivail.util.ui.TextUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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

import java.util.Arrays;
import java.util.List;

public class ItemSequelBlasterRifle extends Item
{
	public static int getCooldown(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtCooldown))
			return stack.stackTagCompound.getInteger(Resources.nbtCooldown);
		return 0;
	}

	public static int getShotsLeft(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtShotsLeft))
			return stack.stackTagCompound.getInteger(Resources.nbtShotsLeft);
		return 0;
	}

	public static int getTicksSinceLastShot(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtTicksSince))
			return stack.stackTagCompound.getInteger(Resources.nbtTicksSince);
		return 0;
	}

	public static void setCooldown(ItemStack stack, int i)
	{
		if (stack.stackTagCompound != null)
			stack.stackTagCompound.setInteger(Resources.nbtCooldown, i);
	}

	public static void setShotsLeft(ItemStack stack, int i)
	{
		if (stack.stackTagCompound != null)
			stack.stackTagCompound.setInteger(Resources.nbtShotsLeft, i);
	}

	public static void setTicksSinceLastShot(ItemStack stack, int i)
	{
		if (stack.stackTagCompound != null)
			stack.stackTagCompound.setInteger(Resources.nbtTicksSince, i);
	}

	public String name = "sequelBlasterRifle";

	private int timeSinceLastShot = 0;

	private int timeToRecharge = 8;

	public String[] versions = { "F11d", "6", "Capt", "Projectile", "Trandoshan" };

	public int subtypes = this.versions.length;

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public ItemSequelBlasterRifle()
	{
		this.setCreativeTab(StarWarsMod.SequelStarWarsTab);
		this.setHasSubtypes(true);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.maxStackSize = 1;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add(TextUtils.makeItalic(LangUtils.translate("blaster.firstOrder")));
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
		return new ItemStack(StarWarsItems.blasterRifle, 1, this.indexOfMeta(string));
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

	@Override
	public boolean hasEffect(ItemStack stack, int pass)
	{
		return getCooldown(stack) >= 15;
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
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (getCooldown(stack) < 15)
			if (stack.stackTagCompound.getInteger("shotsLeft") > 1)
				player.playSound(Resources.MODID + ":" + "fx.shoot.e11", 1.0F, 1.0F);
			else
				player.playSound(Resources.MODID + ":" + "item.blasterRifle.break", 1.0F, 1.0F);

		if (!world.isRemote && getCooldown(stack) < 15)
		{
			world.spawnEntityInWorld(new EntityBlasterRifleBolt(world, player));

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
	public void onUpdate(ItemStack stack, World world, Entity entityIn, int p_77663_4_, boolean p_77663_5_)
	{
		if (!world.isRemote)
		{
			if (!stack.hasTagCompound())
				stack.stackTagCompound = new NBTTagCompound();

			if (!stack.stackTagCompound.hasKey("shotsLeft"))
			{
				stack.stackTagCompound.setInteger("shotsLeft", 250);
			}

			if (getTicksSinceLastShot(stack) <= 40 * ((getCooldown(stack) + 1) / 15f))
				ItemSequelBlasterRifle.setTicksSinceLastShot(stack, getTicksSinceLastShot(stack) + 1);

			if (getTicksSinceLastShot(stack) > 40 * ((getCooldown(stack) + 1) / 15f))
			{
				ItemSequelBlasterRifle.setTicksSinceLastShot(stack, 0);
				ItemSequelBlasterRifle.setCooldown(stack, 0);
			}
		}
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
