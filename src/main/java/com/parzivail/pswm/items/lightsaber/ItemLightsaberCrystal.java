package com.parzivail.pswm.items.lightsaber;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemLightsaberCrystal extends Item
{
	public String name = "lightsaberCrystal";
	public String[] colors = { "red", "green", "blue", "black", "cyan", "gray", "pink", "purple", "white", "yellow", "prism", "shard" };
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public ItemLightsaberCrystal()
	{
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setHasSubtypes(true);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b)
	{
		if (stack != null && stack.getItemDamage() == 10)
		{
			list.add("As you turn it in your hand, you notice");
			list.add("it can produce many different colors...");
		}
		else if (stack != null && stack.getItemDamage() == 11)
		{
			list.add("You groan when you realize this isn't");
			list.add("the full crystal, but merely a shard");
		}
	}

	@Override
	public IIcon getIconFromDamage(int par1)
	{
		return this.icons[par1];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int x = 0; x < this.colors.length; x++)
			par3List.add(new ItemStack(this, 1, x));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.icons = new IIcon[this.colors.length];
		for (int i = 0; i < this.icons.length; i++)
			this.icons[i] = par1IconRegister.registerIcon(Resources.MODID + ":" + this.name + "_" + this.colors[i]);
	}
}
