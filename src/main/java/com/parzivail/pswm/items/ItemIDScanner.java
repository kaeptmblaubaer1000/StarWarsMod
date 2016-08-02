package com.parzivail.pswm.items;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.mobs.MobTatooineCommoner;
import com.parzivail.util.ui.LangUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

import java.util.List;

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
		if (world.isRemote && StarWarsMod.mc.objectMouseOver.typeOfHit == MovingObjectType.ENTITY)
		{
			Entity e = StarWarsMod.mc.objectMouseOver.entityHit;

			if (e instanceof MobTatooineCommoner)
			{
				if (player.isSneaking())
				{
					player.openGui(StarWarsMod.instance, Resources.GUI_SCANNER, world, 0, 0, 0);
				}
			}
		}

		return super.onItemRightClick(stack, world, player);
	}

	@Override
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_)
	{
		p_77624_3_.add(LangUtils.translate("sneak.use.to.scan.someone.or.something"));
	}
}