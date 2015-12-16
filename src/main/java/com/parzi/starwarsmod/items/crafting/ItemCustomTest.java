package com.parzi.starwarsmod.items.crafting;

import java.util.HashMap;
import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.MathUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCustomTest extends ItemSword
{
	public String name = "customTest";
	private HashMap<String, IIcon> iconMap = new HashMap<String, IIcon>();
	private String[] blades = { "blue", "green", "purple", "red", "white" };
	private String[] hilts = { "luke_a", "luke_b", "vader" };

	public ItemCustomTest()
	{
		super(StarWarsMod.materialPlasma);
		this.setUnlocalizedName(StarWarsMod.MODID + "." + this.name);
		this.setTextureName(StarWarsMod.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		if (stack.stackTagCompound != null)
		{
			list.add("Blade: " + stack.stackTagCompound.getString("blade"));
			list.add("Hilt: " + stack.stackTagCompound.getString("hilt"));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int renderPass)
	{
		if (stack.stackTagCompound == null)
		{
			stack.stackTagCompound = new NBTTagCompound();
			stack.stackTagCompound.setString("blade", "blue");
			stack.stackTagCompound.setString("hilt", "luke_a");
		}

		if (renderPass == 0)
			return this.iconMap.get("blade_" + stack.stackTagCompound.getString("blade"));
		else if (renderPass == 1)
			return this.iconMap.get("hilt_" + stack.stackTagCompound.getString("hilt"));
		return this.itemIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderPasses(int metadata)
	{
		return 2;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (player.isSneaking() && stack.stackTagCompound != null)
		{
			stack.stackTagCompound.setString("blade", MathUtils.getRandomElement(Item.itemRand, this.blades));
			stack.stackTagCompound.setString("hilt", MathUtils.getRandomElement(Item.itemRand, this.hilts));
		}
		return super.onItemRightClick(stack, world, player);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(StarWarsMod.MODID + ":" + "lightsaber_blue");

		for (String blade : this.blades)
			this.iconMap.put("blade_" + blade, par1IconRegister.registerIcon(StarWarsMod.MODID + ":" + "lightsaber/blade_" + blade));

		for (String hilt : this.hilts)
			this.iconMap.put("hilt_" + hilt, par1IconRegister.registerIcon(StarWarsMod.MODID + ":" + "lightsaber/hilt_" + hilt));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses()
	{
		return true;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\items\crafting\ItemPlasmaEmitter.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */