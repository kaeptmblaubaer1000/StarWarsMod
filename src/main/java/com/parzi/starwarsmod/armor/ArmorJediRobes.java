package com.parzi.starwarsmod.armor;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.BlockWorkbench;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.gui.JediGUI;
import com.parzi.starwarsmod.utils.TextEffects;
import com.parzi.starwarsmod.utils.TextUtils;

public class ArmorJediRobes extends ItemArmor {
	private String name = "jediRobes";

	private List plantMatter = new ArrayList();

	public ArmorJediRobes(ArmorMaterial par2EnumArmorMaterial, int par3,
			int par4) {
		super(par2EnumArmorMaterial, par3, par4);
		setUnlocalizedName(StarWarsMod.MODID + "." + name);
		setTextureName(StarWarsMod.MODID + ":" + name);
		setCreativeTab(StarWarsMod.StarWarsTab);

		plantMatter.add(Blocks.grass);
		plantMatter.add(Blocks.dirt);
		plantMatter.add(Blocks.farmland);
		plantMatter.add(Blocks.leaves);
	}

	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
		itemStack.stackTagCompound = new NBTTagCompound();
		itemStack.stackTagCompound.setString("owner",
				player.getCommandSenderName());
		itemStack.stackTagCompound.setInteger("plants", 0);
		itemStack.stackTagCompound.setInteger("animals", 0);
		itemStack.stackTagCompound.setInteger("earth", 0);
		itemStack.stackTagCompound.setInteger("water", 0);

		itemStack.stackTagCompound.setInteger("effectStepUp", 10);
		itemStack.stackTagCompound.setInteger("effectGrabBlock", 0);
		itemStack.stackTagCompound.setInteger("effectLevitate", 0);
		itemStack.stackTagCompound.setInteger("effectAnimalWhisper", 0);

		itemStack.stackTagCompound.setInteger("opx",
				player.getPlayerCoordinates().posX);
		itemStack.stackTagCompound.setInteger("opz",
				player.getPlayerCoordinates().posZ);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		if (stack.stackTagCompound == null)
			onCreated(stack, world, player);

		if (world.rand.nextInt(100) != 10)
			return;

		if (hasMoved(stack, player)) {
			if (isStandingOn(plantMatter, world, player)) {
				incrementTagInNBT(stack, "plants");
			} else if (player.isInWater()) {
				incrementTagInNBT(stack, "water");
			}
		}

		if (stack.stackTagCompound.getInteger("effectStepUp") > 0) {
			player.stepHeight = stack.stackTagCompound.getInteger("effectStepUp") + 0.001F;
		} else {
			player.stepHeight = 0.5001F;
		}
		
		addInformation(stack, player, stack.getTooltip(player, false), false);

		setPositionInNBT(stack, player);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (world.isRemote && player.isSneaking() && stack.stackTagCompound != null) {
			Minecraft.getMinecraft().displayGuiScreen(new JediGUI(stack));
		}
		if (stack.stackTagCompound == null) {
			onCreated(stack, world, player);		
		}
		return stack;
	}

	private boolean isStandingOn(List blockList, World world,
			EntityPlayer player) {
		return blockList.contains(world.getBlock((int) player.posX,
				(int) player.posY - 1, (int) player.posZ));
	}

	private void incrementTagInNBT(ItemStack stack, String tag) {
		stack.stackTagCompound.setInteger(tag,
				stack.stackTagCompound.getInteger(tag) + 1);
	}

	private void setPositionInNBT(ItemStack stack, EntityPlayer player) {
		stack.stackTagCompound.setInteger("opx",
				player.getPlayerCoordinates().posX);
		stack.stackTagCompound.setInteger("opz",
				player.getPlayerCoordinates().posZ);
	}

	private boolean hasMoved(ItemStack stack, EntityPlayer player) {
		return (player.getPlayerCoordinates().posX != stack.stackTagCompound
				.getInteger("opx") && player.getPlayerCoordinates().posZ != stack.stackTagCompound
				.getInteger("opz"));
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list,
			boolean par4) {
		list.add(TextUtils.makeItalic("Learn the Way of the Force"));
		if (stack.stackTagCompound != null) {
			String owner = stack.stackTagCompound.getString("owner");
			list.add("Jedi Master: " + owner);
			list.add("Flora: "
					+ TextUtils.addEffect(String.valueOf(stack.stackTagCompound
							.getInteger("plants")), TextEffects.COLOR_GREEN));
			list.add("Fauna: "
					+ TextUtils.addEffect(String.valueOf(stack.stackTagCompound
							.getInteger("animals")), TextEffects.COLOR_YELLOW));
			list.add("Terra: "
					+ TextUtils.addEffect(String.valueOf(stack.stackTagCompound
							.getInteger("earth")), TextEffects.COLOR_DARK_GREEN));
			list.add("Aqua: "
					+ TextUtils.addEffect(String.valueOf(stack.stackTagCompound
							.getInteger("water")), TextEffects.COLOR_BLUE));
		} else {
			list.add("Owner not set!");
		}
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String type) {
		return StarWarsMod.MODID + ":" + "textures/models/jediRobes.png";
	}
}
