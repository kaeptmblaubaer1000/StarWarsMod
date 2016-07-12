package com.parzivail.pswm.items;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.ui.LangUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.List;

public class ItemBinoculars extends Item
{
	public static boolean getEnabled(ItemStack stack)
	{
		if (stack.stackTagCompound == null)
		{
			stack.stackTagCompound = new NBTTagCompound();
			setEnabled(stack, false);
		}
		return stack.stackTagCompound.getBoolean("enabled");
	}

	public static int getZoom(ItemStack stack)
	{
		if (stack.stackTagCompound == null)
		{
			stack.stackTagCompound = new NBTTagCompound();
			setZoom(stack, 10);
		}
		if (!stack.stackTagCompound.hasKey("zoom"))
			setZoom(stack, 10);
		return stack.stackTagCompound.getInteger("zoom");
	}

	public static ItemStack setEnabled(ItemStack stack, boolean enabled)
	{
		if (stack.stackTagCompound == null)
			stack.stackTagCompound = new NBTTagCompound();
		stack.stackTagCompound.setBoolean("enabled", enabled);
		return stack;
	}

	public static ItemStack setZoom(ItemStack stack, int zoom)
	{
		if (stack.stackTagCompound == null)
			stack.stackTagCompound = new NBTTagCompound();
		stack.stackTagCompound.setInteger("zoom", zoom);
		return stack;
	}

	public String name = "binoculars";

	public ItemBinoculars(String type)
	{
		this.setUnlocalizedName(Resources.MODID + "." + this.name + type);
		this.setTextureName(Resources.MODID + ":" + this.name + type);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		if (stack.stackTagCompound != null && stack.getItem() instanceof ItemBinoculars)
		{
			int zoom = getZoom(stack);
			list.add(LangUtils.translate("zoom.factor.0.x", zoom));
			boolean enabled = getEnabled(stack);
			list.add(LangUtils.translate("enabled.0", enabled ? LangUtils.translate("yes") : LangUtils.translate("no")));
			list.add(LangUtils.translate("sneak.use.to.enable"));
			list.add(LangUtils.translate("use.while.enabled.to.change.zoom"));
		}
	}

	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player)
	{
		setZoom(itemStack, 10);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (!player.isSneaking())
		{
			int z = getZoom(stack) / 2;
			return setZoom(stack, z >= 2 ? z : 10);
		}
		return setEnabled(stack, !getEnabled(stack));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void onUpdate(ItemStack stack, World world, Entity player, int i, boolean b)
	{
		if (!(player instanceof EntityPlayer))
			return;
		if (stack.stackTagCompound == null)
			this.onCreated(stack, world, (EntityPlayer)player);
	}
}
