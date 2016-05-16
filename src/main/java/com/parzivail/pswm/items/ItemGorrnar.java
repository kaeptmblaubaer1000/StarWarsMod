package com.parzivail.pswm.items;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGorrnar extends ItemFood
{
	public String name = "gorrnar";

	public ItemGorrnar()
	{
		super(5, 0.0F, false);
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public ItemStack onEaten(ItemStack item, World world, EntityPlayer player)
	{
		player.setFire(2);
		return super.onEaten(item, world, player);
	}
}
