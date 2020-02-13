package com.parzivail.pswm.items.weapons;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.achievement.StarWarsAchievements;
import com.parzivail.pswm.entities.EntityBlasterVariableBolt;
import com.parzivail.pswm.utils.BlasterUtils;
import com.parzivail.util.ui.KeyboardUtils;
import com.parzivail.util.ui.LangUtils;
import com.parzivail.util.ui.TextUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.List;

public class ItemWookieeBowcaster extends Item
{
	public String name = "bowcaster";

	private int timeSinceLastShot = 0;

	private int timeToRecharge = 6;

	public ItemWookieeBowcaster()
	{
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.maxStackSize = 1;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		if (KeyboardUtils.isShiftDown())
		{
			list.add(TextUtils.makeItalic(LangUtils.translate("blaster.rifle1")));
			list.add(TextUtils.makeItalic(LangUtils.translate("blaster.rifle2")));
			list.add(TextUtils.makeItalic(LangUtils.translate("blaster.rifle3")));
		}
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("shotsLeft"))
			list.add("Shots Remaining: " + stack.stackTagCompound.getInteger("shotsLeft"));
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		return "item.starwarsmod." + this.name;
	}

	@Override
	public boolean hasEffect(ItemStack stack, int pass)
	{
		return BlasterUtils.getCooldown(stack) >= 15;
	}

	@Override
	public boolean isFull3D()
	{
		return true;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (BlasterUtils.getCooldown(stack) < 15)
			if (stack.stackTagCompound.getInteger("shotsLeft") > 0)
			{
				player.playSound(Resources.MODID + ":" + "item.blasterBow.use", 1.0F, 1.0F);

				if (!world.isRemote && BlasterUtils.getCooldown(stack) < 15)
				{
					world.spawnEntityInWorld(new EntityBlasterVariableBolt(world, player, 2));

					BlasterUtils.setCooldown(stack, BlasterUtils.getCooldown(stack) + 1);
					BlasterUtils.setTicksSinceLastShot(stack, 0);

					stack.stackTagCompound.setInteger("shotsLeft", stack.stackTagCompound.getInteger("shotsLeft") - 1);
				}

				player.addStat(StarWarsAchievements.fireBlaster, 1);
			}
			else if (!BlasterUtils.refillShots(stack, world, player))
				player.playSound(Resources.MODID + ":" + "item.blasterRifle.break", 1.0F, 1.0F);

		return stack;
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entityIn, int p_77663_4_, boolean p_77663_5_)
	{
		if (!world.isRemote)
		{
			if (!stack.hasTagCompound())
				stack.stackTagCompound = new NBTTagCompound();

			if (!stack.stackTagCompound.hasKey("shotsLeft"))
				BlasterUtils.refillShots(stack, world, entityIn);

			if (BlasterUtils.getTicksSinceLastShot(stack) <= 40 * ((BlasterUtils.getCooldown(stack) + 1) / 15f))
				BlasterUtils.setTicksSinceLastShot(stack, BlasterUtils.getTicksSinceLastShot(stack) + 1);

			if (BlasterUtils.getTicksSinceLastShot(stack) > 40 * ((BlasterUtils.getCooldown(stack) + 1) / 15f))
			{
				BlasterUtils.setTicksSinceLastShot(stack, 0);
				BlasterUtils.setCooldown(stack, 0);
			}
		}
	}
}