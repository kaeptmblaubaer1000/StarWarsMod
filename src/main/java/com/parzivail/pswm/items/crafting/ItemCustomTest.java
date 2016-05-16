package com.parzivail.pswm.items.crafting;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.MathUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;

public class ItemCustomTest extends ItemSword
{
	public String name = "customTest";
	private HashMap<String, IIcon> iconMap = new HashMap<String, IIcon>();
	private String[] blades = { "blue", "green", "purple", "red", "white" };
	private String[] hilts = { "luke_a", "luke_b", "vader" };

	public ItemCustomTest()
	{
		super(StarWarsMod.materialPlasma);
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		if (stack.stackTagCompound != null)
		{
			list.add("Blade: " + stack.stackTagCompound.getString("blade"));
			list.add("Hilt: " + stack.stackTagCompound.getString("hilt"));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int renderPass)
	{
		if (stack.stackTagCompound == null)
		{
			stack.stackTagCompound = new NBTTagCompound();
			stack.stackTagCompound.setString("blade", "blue");
			stack.stackTagCompound.setString("hilt", "luke_a");
		}

		if (renderPass == 0)
			return this.iconMap.get("blade_" + stack.stackTagCompound.getString("blade"));
		else if (renderPass == 1)
			return this.iconMap.get("hilt_" + stack.stackTagCompound.getString("hilt"));
		return this.itemIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderPasses(int metadata)
	{
		return 2;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (player.isSneaking() && stack.stackTagCompound != null)
		{
			stack.stackTagCompound.setString("blade", MathUtils.getRandomElement(this.blades));
			stack.stackTagCompound.setString("hilt", MathUtils.getRandomElement(this.hilts));
		}
		return super.onItemRightClick(stack, world, player);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(Resources.MODID + ":" + "lightsaber_blue");

		for (String blade : this.blades)
			this.iconMap.put("blade_" + blade, par1IconRegister.registerIcon(Resources.MODID + ":" + "lightsaber/blade_" + blade));

		for (String hilt : this.hilts)
			this.iconMap.put("hilt_" + hilt, par1IconRegister.registerIcon(Resources.MODID + ":" + "lightsaber/hilt_" + hilt));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses()
	{
		return true;
	}
}
