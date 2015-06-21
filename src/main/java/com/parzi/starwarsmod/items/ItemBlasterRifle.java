package com.parzi.starwarsmod.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.entities.EntityBlasterBolt;

public class ItemBlasterRifle extends Item
{
	private String name = "blasterRifle";
	private int timeSinceLastShot = 0;
	private int timeToRecharge = 15;

	public ItemBlasterRifle()
	{
		setCreativeTab(StarWarsMod.StarWarsTab);
		setUnlocalizedName(StarWarsMod.MODID + "." + name);
		setTextureName(StarWarsMod.MODID + ":" + name);
		setMaxDamage(timeToRecharge + 1);
	}

	@Override
	public void onUpdate(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_)
	{
		if (timeSinceLastShot > 0)
			timeSinceLastShot--;
		this.setDamage(p_77663_1_, timeSinceLastShot);
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack p_77615_1_, World p_77615_2_, EntityPlayer p_77615_3_, int p_77615_4_)
	{
		timeSinceLastShot = 0;
		this.setDamage(p_77615_1_, timeSinceLastShot);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer entityPlayer)
	{
		if (!par2World.isRemote && timeSinceLastShot == 0)
		{
			par2World.spawnEntityInWorld(new EntityBlasterBolt(par2World, entityPlayer));
			timeSinceLastShot = timeToRecharge;
		}

		entityPlayer.playSound(StarWarsMod.MODID + ":" + "item.blasterRifle.use", 1f, 1f + (float)MathHelper.getRandomDoubleInRange(Item.itemRand, -0.2D, 0.2D));

		return par1ItemStack;
	}
}
