package com.parzivail.pswm.items;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.world.PotionList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAcidBeets extends ItemFood
{
	public String name = "acidBeets";

	public ItemAcidBeets()
	{
		super(3, 0.0F, false);
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public ItemStack onEaten(ItemStack item, World world, EntityPlayer player)
	{
		PotionList.addAmbientEffect(player, PotionList.NAUSEA, 10, 10.0F);
		return super.onEaten(item, world, player);
	}
}
