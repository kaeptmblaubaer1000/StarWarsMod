package com.parzivail.pswm.items.weapons;

import java.util.List;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.ui.TextUtils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ItemGaffiStick extends ItemSword
{
	public String name = "gaffiStick";

	public ItemGaffiStick()
	{
		super(StarWarsMod.materialGaffi);
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add(TextUtils.makeItalic("Whoever has two hands can hold a gaderffi."));
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
	{
		entityPlayer.playSound(Resources.MODID + ":" + "item.gaffi.rightclick", 1.0F, 1.0F);
		return itemStack;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\items\weapons\ItemGaffiStick.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */