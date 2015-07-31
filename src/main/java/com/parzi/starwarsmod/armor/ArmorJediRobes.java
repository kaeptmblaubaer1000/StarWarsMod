package com.parzi.starwarsmod.armor;

import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
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
import com.parzi.starwarsmod.rendering.gui.JediGUI;
import com.parzi.starwarsmod.rendering.helper.IHaloRenderItem;
import com.parzi.starwarsmod.upgrades.ForceFeed;
import com.parzi.starwarsmod.upgrades.ForceLeap;
import com.parzi.starwarsmod.upgrades.ForcePunch;
import com.parzi.starwarsmod.upgrades.ForceResist;
import com.parzi.starwarsmod.upgrades.ForceStep;
import com.parzi.starwarsmod.upgrades.ForceStride;
import com.parzi.starwarsmod.upgrades.PowerBase;
import com.parzi.starwarsmod.utils.KeyboardUtils;
import com.parzi.starwarsmod.utils.TextEffects;
import com.parzi.starwarsmod.utils.TextUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorJediRobes extends ItemArmor implements IHaloRenderItem
{
	private String name = "jediRobes";

	public static int chanceElement = 100;

	public static Block[] plantMatter = { Blocks.dirt, Blocks.grass, Blocks.leaves, Blocks.farmland };

	public static Block[] earthMatter = { Blocks.stone, Blocks.gravel, Blocks.coal_ore, Blocks.diamond_ore, Blocks.emerald_ore, Blocks.gold_ore, Blocks.iron_ore, Blocks.lapis_ore, Blocks.redstone_ore };

	public PowerBase[] powers = { new ForceStep(), new ForceLeap(), new ForceStride(), new ForceResist(), new ForcePunch(), new ForceFeed() };

	private IIcon halo;
	private IIcon icon;

	public ArmorJediRobes(ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		setUnlocalizedName(StarWarsMod.MODID + "." + name);
		setTextureName(StarWarsMod.MODID + ":" + name);
		setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack stack, EntityPlayer player)
	{
		return false;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister par1IconRegister)
	{
		icon = par1IconRegister.registerIcon(StarWarsMod.MODID + ":" + name);
		halo = par1IconRegister.registerIcon(StarWarsMod.MODID + ":haloSithRobes");
	}

	@Override
	public IIcon getIconFromDamage(int i)
	{
		return icon;
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

		for (int i = 0; i < powers.length; i++)
		{
			itemStack.stackTagCompound.setInteger(powers[i].internalName, 0);
		}

		itemStack.stackTagCompound.setInteger("opx", player.getPlayerCoordinates().posX);
		itemStack.stackTagCompound.setInteger("opz", player.getPlayerCoordinates().posZ);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack)
	{
		if (stack.stackTagCompound == null) onCreated(stack, world, player);

		if (world.rand.nextInt(chanceElement) != 0) return;

		if (hasMoved(stack, player))
		{
			if (isStandingOn(plantMatter, world, player))
			{
				incrementTagInNBT(stack, "plants");
			}
			else if (player.isInWater())
			{
				incrementTagInNBT(stack, "water");
			}
		}

		for (int i = 0; i < powers.length; i++)
		{
			powers[i].doPower(world, player, stack);
		}

		addInformation(stack, player, stack.getTooltip(player, false), false);

		setPositionInNBT(stack, player);
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity player, int i, boolean b)
	{
		addInformation(stack, (EntityPlayer)player, stack.getTooltip((EntityPlayer)player, false), false);

		try
		{
			if (Minecraft.getMinecraft().thePlayer.inventory.armorInventory[2] == null)
			{
				player.stepHeight = 0.5001F;
			}
			if (!(Minecraft.getMinecraft().thePlayer.inventory.armorInventory[2].getItem() instanceof ArmorJediRobes))
			{
				player.stepHeight = 0.5001F;
			}
		}
		catch (Exception e)
		{
		}
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (world.isRemote && player.isSneaking() && stack.stackTagCompound != null)
		{
			Minecraft.getMinecraft().displayGuiScreen(new JediGUI(player));
		}
		if (stack.stackTagCompound == null)
		{
			onCreated(stack, world, player);
		}
		return stack;
	}

	private boolean isStandingOn(Block[] blockList, World world, EntityPlayer player)
	{
		return Arrays.asList(blockList).contains(world.getBlock((int)player.posX, (int)player.posY - 1, (int)player.posZ));
	}

	private void incrementTagInNBT(ItemStack stack, String tag)
	{
		stack.stackTagCompound.setInteger(tag, stack.stackTagCompound.getInteger(tag) + 1);
	}

	private void setPositionInNBT(ItemStack stack, EntityPlayer player)
	{
		stack.stackTagCompound.setInteger("opx", player.getPlayerCoordinates().posX);
		stack.stackTagCompound.setInteger("opz", player.getPlayerCoordinates().posZ);
	}

	private boolean hasMoved(ItemStack stack, EntityPlayer player)
	{
		return (player.getPlayerCoordinates().posX != stack.stackTagCompound.getInteger("opx") && player.getPlayerCoordinates().posZ != stack.stackTagCompound.getInteger("opz"));
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
				list.add("Flora: " + TextUtils.addEffect(String.valueOf(stack.stackTagCompound.getInteger("plants")), TextEffects.COLOR_GREEN));
				list.add("Fauna: " + TextUtils.addEffect(String.valueOf(stack.stackTagCompound.getInteger("animals")), TextEffects.COLOR_YELLOW));
				list.add("Terra: " + TextUtils.addEffect(String.valueOf(stack.stackTagCompound.getInteger("earth")), TextEffects.COLOR_DARK_GREEN));
				list.add("Aqua: " + TextUtils.addEffect(String.valueOf(stack.stackTagCompound.getInteger("water")), TextEffects.COLOR_BLUE));

				for (int i = 0; i < powers.length; i++)
				{
					if (stack.stackTagCompound.getInteger(powers[i].internalName) > 0)
					{
						list.add("* " + powers[i].displayName + " level " + stack.stackTagCompound.getInteger(powers[i].internalName));
					}
				}
			}
			else
			{
				list.add("Owner not set!");
			}
		}
		else
		{
			list.add(TextUtils.addEffect("<Hold Shift>", TextEffects.COLOR_AQUA));
		}
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return StarWarsMod.MODID + ":" + "textures/models/jediRobes.png";
	}

	@Override
	public boolean drawHalo(ItemStack stack)
	{
		return true;
	}

	@Override
	public IIcon getHaloTexture(ItemStack stack)
	{
		return halo;
	}

	@Override
	public int getHaloSize(ItemStack stack)
	{
		return 4;
	}

	@Override
	public boolean drawPulseEffect(ItemStack stack)
	{
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getHaloColour(ItemStack stack)
	{
		return 0xFF000000;
	}
}
