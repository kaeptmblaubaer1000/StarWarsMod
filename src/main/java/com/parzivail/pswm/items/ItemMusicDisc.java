package com.parzivail.pswm.items;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class ItemMusicDisc extends ItemRecord
{
	private static final Map records = new HashMap();

	public static ItemMusicDisc getRecord(String par0Str)
	{
		return (ItemMusicDisc)records.get(par0Str);
	}

	public String name = "musicDisc";
	public final String field_150929_a;

	public ItemMusicDisc(String songName)
	{
		super(songName);
		this.field_150929_a = songName;
		this.maxStackSize = 1;
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		records.put(this.field_150929_a, this);
	}

	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		par3List.add(this.func_150927_i());
	}

	public String func_150927_i()
	{
		return StatCollector.translateToLocal(this.getUnlocalizedName() + this.field_150929_a + ".desc");
	}

	@Override
	public EnumRarity getRarity(ItemStack itemStack)
	{
		return EnumRarity.rare;
	}

	@Override
	public ResourceLocation getRecordResource(String name)
	{
		return new ResourceLocation(Resources.MODID + ":" + "item." + name);
	}

	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(Resources.MODID + ":" + "record" + this.field_150929_a);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\items\ItemMusicDisc.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */