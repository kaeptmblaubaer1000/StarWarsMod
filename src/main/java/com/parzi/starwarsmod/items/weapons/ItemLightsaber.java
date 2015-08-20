package com.parzi.starwarsmod.items.weapons;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.network.TogglePlayerLightsaber;
import com.parzi.starwarsmod.utils.TextUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLightsaber extends ItemSword
{
	public String name = "lightsaber";

	private String[] colors = { "red", "green", "blue" };

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public ItemLightsaber()
	{
		super(StarWarsMod.plasmaMat);
		setUnlocalizedName(StarWarsMod.MODID + "." + name);
		setTextureName(StarWarsMod.MODID + ":" + name);
		setHasSubtypes(true);
		setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add(TextUtils.makeItalic("This is the formal weapon of a Jedi Knight."));
	}

	@Override
	public boolean canHarvestBlock(Block block, ItemStack stack)
	{
		return true;
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase a, EntityLivingBase b)
	{
		if (a instanceof EntityPlayer && b instanceof EntityPlayer)
		{
			EntityPlayer pa = (EntityPlayer)a;
			EntityPlayer pb = (EntityPlayer)b;
			if (pa.inventory.mainInventory[pa.inventory.currentItem] != null && pa.inventory.mainInventory[pa.inventory.currentItem].getItem() == StarWarsMod.lightsaber && pa.isBlocking() && pb.inventory.mainInventory[pb.inventory.currentItem] != null && pb.inventory.mainInventory[pb.inventory.currentItem].getItem() == StarWarsMod.lightsaber)
			{
				a.playSound(StarWarsMod.MODID + ":" + "item.lightsaber.crash", 1F, 1F);
				b.playSound(StarWarsMod.MODID + ":" + "item.lightsaber.crash", 1F, 1F);
			}
		}
		return super.hitEntity(stack, a, b);
	}

	@Override
	public IIcon getIconFromDamage(int par1)
	{
		return icons[par1];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int x = 0; x < colors.length; x++)
		{
			par3List.add(new ItemStack(this, 1, x));
		}
	}

	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
	{
		entityLiving.playSound(StarWarsMod.MODID + ":" + "item.lightsaber.swing", 1f, 1f + (float)MathHelper.getRandomDoubleInRange(Item.itemRand, -0.2D, 0.2D));
		return super.onEntitySwing(entityLiving, stack);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (!stack.stackTagCompound.hasKey("timeout"))
		{
			stack.stackTagCompound.setInteger("timeout", 10);
		}
		if (player.isSneaking() && stack.stackTagCompound.getInteger("timeout") == 0)
		{
			player.playSound(StarWarsMod.MODID + ":" + "item.lightsaber.close", 1f, 1f);
			StarWarsMod.network.sendToServer(new TogglePlayerLightsaber(player.getCommandSenderName(), player.dimension));
		}
		return super.onItemRightClick(stack, world, player);
	}

	@Override
	public void onUpdate(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_)
	{
		super.onUpdate(p_77663_1_, p_77663_2_, p_77663_3_, p_77663_4_, p_77663_5_);
		if (!p_77663_1_.hasTagCompound())
		{
			p_77663_1_.stackTagCompound = new NBTTagCompound();
		}

		if (!p_77663_1_.stackTagCompound.hasKey("timeout"))
		{
			p_77663_1_.stackTagCompound.setInteger("timeout", 10);
		}

		if (p_77663_1_.stackTagCompound.getInteger("timeout") > 0)
		{
			p_77663_1_.stackTagCompound.setInteger("timeout", p_77663_1_.stackTagCompound.getInteger("timeout") - 1);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister par1IconRegister)
	{
		icons = new IIcon[colors.length];

		for (int i = 0; i < icons.length; i++)
		{
			icons[i] = par1IconRegister.registerIcon(StarWarsMod.MODID + ":" + name + "_" + colors[i]);
		}
	}
}
