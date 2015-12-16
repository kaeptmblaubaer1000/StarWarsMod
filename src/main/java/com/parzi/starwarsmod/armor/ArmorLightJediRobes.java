package com.parzi.starwarsmod.armor;

import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.helper.IHaloRenderItem;
import com.parzi.starwarsmod.upgrades.ForceFeed;
import com.parzi.starwarsmod.upgrades.ForceResist;
import com.parzi.starwarsmod.upgrades.ForceStep;
import com.parzi.starwarsmod.upgrades.ForceStride;
import com.parzi.starwarsmod.upgrades.PowerBase;
import com.parzi.starwarsmod.utils.KeyboardUtils;
import com.parzi.starwarsmod.utils.Text;
import com.parzi.starwarsmod.utils.TextUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorLightJediRobes extends ItemArmor implements IHaloRenderItem
{
	public static int chanceElement = 100;
	public static Block[] plantMatter = { Blocks.dirt, Blocks.grass, Blocks.leaves, Blocks.farmland };
	public static Block[] earthMatter = { Blocks.stone, Blocks.gravel, Blocks.coal_ore, Blocks.diamond_ore, Blocks.emerald_ore, Blocks.gold_ore, Blocks.iron_ore, Blocks.lapis_ore, Blocks.redstone_ore };
	public String name = "lightJediRobes";
	public PowerBase[] powers = { new ForceStep(), new ForceStride(), new ForceResist(), new ForceFeed() };
	private IIcon halo;
	private IIcon icon;

	public ArmorLightJediRobes(ItemArmor.ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.setUnlocalizedName(StarWarsMod.MODID + "." + this.name);
		this.setTextureName(StarWarsMod.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add(TextUtils.makeItalic("Learn the Way of the Force"));
		if (KeyboardUtils.isShiftDown())
		{
			if (stack.stackTagCompound != null)
			{
				String owner = stack.stackTagCompound.getString("owner");
				list.add("Jedi Master: " + owner);
				list.add("Flora: " + TextUtils.addEffect(String.valueOf(stack.stackTagCompound.getInteger("plants")), Text.COLOR_GREEN));
				list.add("Fauna: " + TextUtils.addEffect(String.valueOf(stack.stackTagCompound.getInteger("animals")), Text.COLOR_YELLOW));
				list.add("Terra: " + TextUtils.addEffect(String.valueOf(stack.stackTagCompound.getInteger("earth")), Text.COLOR_DARK_GREEN));
				list.add("Aqua: " + TextUtils.addEffect(String.valueOf(stack.stackTagCompound.getInteger("water")), Text.COLOR_BLUE));
				for (PowerBase power : this.powers)
					if (stack.stackTagCompound.getInteger(power.internalName) > 0)
						list.add("* " + power.displayName + " level " + stack.stackTagCompound.getInteger(power.internalName));
			}
			else
				list.add("Owner not set!");
		}
		else
			list.add(TextUtils.addEffect("<Hold Shift>", Text.COLOR_AQUA));
	}

	@Override
	public boolean drawHalo(ItemStack stack)
	{
		return true;
	}

	@Override
	public boolean drawPulseEffect(ItemStack stack)
	{
		return false;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return StarWarsMod.MODID + ":" + "textures/models/lightJediRobes.png";
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getHaloColour(ItemStack stack)
	{
		return -1;
	}

	@Override
	public int getHaloSize(ItemStack stack)
	{
		return 4;
	}

	@Override
	public IIcon getHaloTexture(ItemStack stack)
	{
		return this.halo;
	}

	@Override
	public IIcon getIconFromDamage(int i)
	{
		return this.icon;
	}

	private boolean hasMoved(ItemStack stack, EntityPlayer player)
	{
		return player.getPlayerCoordinates().posX != stack.stackTagCompound.getInteger("opx") && player.getPlayerCoordinates().posZ != stack.stackTagCompound.getInteger("opz");
	}

	private void incrementTagInNBT(ItemStack stack, String tag)
	{
		stack.stackTagCompound.setInteger(tag, stack.stackTagCompound.getInteger(tag) + 1);
	}

	private boolean isStandingOn(Block[] blockList, World world, EntityPlayer player)
	{
		return Arrays.asList(blockList).contains(world.getBlock((int)player.posX, (int)player.posY - 1, (int)player.posZ));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack)
	{
		if (stack.stackTagCompound == null)
			this.onCreated(stack, world, player);
		if (world.rand.nextInt(chanceElement) != 0)
			return;
		if (this.hasMoved(stack, player))
			if (this.isStandingOn(plantMatter, world, player))
				this.incrementTagInNBT(stack, "plants");
			else if (player.isInWater())
				this.incrementTagInNBT(stack, "water");
		for (PowerBase power : this.powers)
			power.doPower(world, player, stack);
		this.addInformation(stack, player, stack.getTooltip(player, false), false);
		this.setPositionInNBT(stack, player);
	}

	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player)
	{
		itemStack.stackTagCompound = new NBTTagCompound();
		itemStack.stackTagCompound.setString("owner", player.getCommandSenderName());
		itemStack.stackTagCompound.setInteger("plants", 0);
		itemStack.stackTagCompound.setInteger("animals", 0);
		itemStack.stackTagCompound.setInteger("earth", 0);
		itemStack.stackTagCompound.setInteger("water", 0);
		for (PowerBase power : this.powers)
			itemStack.stackTagCompound.setInteger(power.internalName, 0);
		itemStack.stackTagCompound.setInteger("opx", player.getPlayerCoordinates().posX);
		itemStack.stackTagCompound.setInteger("opz", player.getPlayerCoordinates().posZ);
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack stack, EntityPlayer player)
	{
		return false;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (world.isRemote && player.isSneaking() && stack.stackTagCompound != null)
			player.openGui(StarWarsMod.instance, 2, world, 0, 0, 0);
		if (stack.stackTagCompound == null)
			this.onCreated(stack, world, player);
		return stack;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void onUpdate(ItemStack stack, World world, Entity player, int i, boolean b)
	{
		if (!(player instanceof EntityPlayer))
			return;
		try
		{
			this.addInformation(stack, (EntityPlayer)player, stack.getTooltip((EntityPlayer)player, false), false);
		}
		catch (Throwable localThrowable)
		{
		}
		if (stack.stackTagCompound == null)
			this.onCreated(stack, world, (EntityPlayer)player);
		try
		{
			if (net.minecraft.client.Minecraft.getMinecraft().thePlayer.inventory.armorInventory[2] == null)
				player.stepHeight = 0.5001F;
			if (!(net.minecraft.client.Minecraft.getMinecraft().thePlayer.inventory.armorInventory[2].getItem() instanceof ArmorLightJediRobes) && !(net.minecraft.client.Minecraft.getMinecraft().thePlayer.inventory.armorInventory[2].getItem() instanceof ArmorJediRobes))
				player.stepHeight = 0.5001F;
		}
		catch (Exception localException)
		{
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.icon = par1IconRegister.registerIcon(StarWarsMod.MODID + ":" + this.name);
		this.halo = par1IconRegister.registerIcon(StarWarsMod.MODID + ":" + "haloSithRobes");
	}

	private void setPositionInNBT(ItemStack stack, EntityPlayer player)
	{
		stack.stackTagCompound.setInteger("opx", player.getPlayerCoordinates().posX);
		stack.stackTagCompound.setInteger("opz", player.getPlayerCoordinates().posZ);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\armor\ArmorLightJediRobes.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */