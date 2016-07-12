package com.parzivail.pswm.items.weapons;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.achievement.StarWarsAchievements;
import com.parzivail.pswm.entities.EntityBlasterPistolBolt;
import com.parzivail.pswm.utils.BlasterUtils;
import com.parzivail.util.ui.KeyboardUtils;
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
			list.add(TextUtils.makeItalic(LangUtils.translate("blaster.rifle1")));
			list.add(TextUtils.makeItalic(LangUtils.translate("blaster.rifle2")));
			list.add(TextUtils.makeItalic(LangUtils.translate("blaster.rifle3")));
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
		return new ItemStack(StarWarsItems.blasterPistol, 1, this.indexOfMeta(string));
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
		return BlasterUtils.getCooldown(stack) >= 15;
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
		if (BlasterUtils.getCooldown(stack) < 15)
			if (stack.stackTagCompound.getInteger("shotsLeft") > 0)
			{
				player.playSound(Resources.MODID + ":" + "fx.shoot." + this.versions[MathHelper.clamp_int(stack.getItemDamage(), 0, 15)].toLowerCase(), 1.0F, 1.0F);

				if (!world.isRemote && BlasterUtils.getCooldown(stack) < 15)
				{
					world.spawnEntityInWorld(new EntityBlasterPistolBolt(world, player));

					BlasterUtils.setCooldown(stack, BlasterUtils.getCooldown(stack) + 1);
					BlasterUtils.setTicksSinceLastShot(stack, 0);

					stack.stackTagCompound.setInteger("shotsLeft", stack.stackTagCompound.getInteger("shotsLeft") - 1);
				}

				player.addStat(StarWarsAchievements.fireBlaster, 1);
			}
			else if (!BlasterUtils.refillShots(stack, world, player))
				player.playSound(Resources.MODID + ":" + "item.blasterRifle.break", 1.0F, 1.0F);

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
				BlasterUtils.refillShots(stack, world, entityIn);

			if (BlasterUtils.getTicksSinceLastShot(stack) <= 40 * ((BlasterUtils.getCooldown(stack) + 1) / 15f))
				BlasterUtils.setTicksSinceLastShot(stack, BlasterUtils.getTicksSinceLastShot(stack) + 1);

			if (BlasterUtils.getTicksSinceLastShot(stack) > 40 * ((BlasterUtils.getCooldown(stack) + 1) / 15f))
			{
				BlasterUtils.setTicksSinceLastShot(stack, 0);
				BlasterUtils.setCooldown(stack, 0);
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
