package com.parzivail.pswm.items.weapons;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.ui.LangUtils;
import com.parzivail.util.ui.TextUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

import java.util.List;

public class ItemVibroLance extends ItemSword
{
	public String name = "vibroLance";

	public ItemVibroLance()
	{
		super(StarWarsMod.materialGaffi);
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + "blank");
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
	{
		list.add(TextUtils.makeItalic(LangUtils.translate("lance.tooltip1")));
		list.add(TextUtils.makeItalic(LangUtils.translate("lance.tooltip2")));
		list.add(TextUtils.makeItalic(LangUtils.translate("lance.tooltip3")));
	}
}
