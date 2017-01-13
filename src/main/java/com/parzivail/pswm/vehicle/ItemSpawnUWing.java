package com.parzivail.pswm.vehicle;

import com.parzivail.pswm.PSWM;
import com.parzivail.util.driven.Pilotable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ItemSpawnUWing extends ItemSpawnVehicle
{
	public static String name = "spawnUwing";

	public ItemSpawnUWing()
	{
		super(name);
		this.setCreativeTab(PSWM.tabBlocks);
		this.maxStackSize = 1;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		//		String s = KeybindRegistry.keyShootVehicle.getKeyCode() <= 0 ? "UNKNOWN" : Keyboard.getKeyName(KeybindRegistry.keyShootVehicle.getKeyCode());
		//		list.add(String.format(LangUtils.translate("press.s.to.fire.lasers"), s));
	}

	@Override
	protected Pilotable getVehicle(World world, EntityPlayer entityplayer, double i, double j, double k)
	{
		return new VehicUWing(world, i, j, k);
	}
}
