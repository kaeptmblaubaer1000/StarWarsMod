package com.parzi.starwarsmod.items;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import com.parzi.starwarsmod.StarWarsMod;

public class ItemMusicDisc extends ItemRecord {
	private String name = "musicDisc";
	private static final Map records = new HashMap();
	public final String recordName;

	public ItemMusicDisc(String songName) {
		super(songName);
		this.recordName = songName;
		this.maxStackSize = 1;
		setUnlocalizedName(StarWarsMod.MODID + "." + name);
		setCreativeTab(StarWarsMod.StarWarsTab);
		records.put(recordName, this);
	}

	@Override
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(StarWarsMod.MODID + ":" + "record"
				+ recordName);
	}

	@Override
	public void addInformation(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(this.getRecordNameLocal());
	}

	@Override
	// TODO: getRecordTitle()
	public String getRecordNameLocal() {
		return StatCollector.translateToLocal(this.getUnlocalizedName()
				+ recordName + ".desc");
	}

	@Override
	public EnumRarity getRarity(ItemStack itemStack) {
		return EnumRarity.rare;
	}

	public static ItemMusicDisc getRecord(String par0Str) {
		return (ItemMusicDisc) records.get(par0Str);
	}

	@Override
	public ResourceLocation getRecordResource(String name) {
		return new ResourceLocation(StarWarsMod.MODID + ":" + "item." + name);
	}
}