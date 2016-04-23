package com.parzivail.pswm.items;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.IParziNPC;
import com.parzivail.util.MathUtils;

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
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
	{
		if (StarWarsMod.mc.objectMouseOver.typeOfHit == MovingObjectType.ENTITY)
		{
			Entity e = StarWarsMod.mc.objectMouseOver.entityHit;
			if (e instanceof IParziNPC)
			{
				if (MathUtils.oneIn(10)) // fraudulent
				{
					// show bad gui
				}
				else
				{
					// show good gui
				}
			}
		}
		return super.onItemRightClick(p_77659_1_, p_77659_2_, p_77659_3_);
	}
}