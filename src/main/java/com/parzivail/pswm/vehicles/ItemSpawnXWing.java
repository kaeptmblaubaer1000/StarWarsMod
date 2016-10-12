package com.parzivail.pswm.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.registry.KeybindRegistry;
import com.parzivail.util.driven.Pilotable;
import com.parzivail.util.ui.LangUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

import java.util.List;

public class ItemSpawnXWing extends ItemSpawnVehicle
{
	public String name = "spawnXwing";

	public ItemSpawnXWing()
	{
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + "blank");
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.maxStackSize = 1;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		String s = KeybindRegistry.keyShootVehicle.getKeyCode() <= 0 ? "UNKNOWN" : Keyboard.getKeyName(KeybindRegistry.keyShootVehicle.getKeyCode());
		list.add(String.format(LangUtils.translate("press.s.to.fire.lasers"), s));
	}

	@Override
	protected Pilotable getVehicle(ItemStack itemstack, World world, EntityPlayer entityplayer, double i, double j, double k)
	{
		return new VehicXWing(world, i, j, k);
	}
}
