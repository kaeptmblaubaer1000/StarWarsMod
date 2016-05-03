package com.parzivail.pswm.items;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.IParziNPC;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class ItemIDScanner extends Item
{
	public String name = "idScanner";

	public ItemIDScanner()
	{
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (StarWarsMod.mc.objectMouseOver.typeOfHit == MovingObjectType.ENTITY && player.isSneaking() && !world.isRemote)
		{
			Entity e = StarWarsMod.mc.objectMouseOver.entityHit;
			if (e instanceof IParziNPC)
			{
				player.openGui(StarWarsMod.instance, Resources.GUI_SCANNER, world, 0, 0, 0);
			}
		}
		return super.onItemRightClick(stack, world, player);
	}
}