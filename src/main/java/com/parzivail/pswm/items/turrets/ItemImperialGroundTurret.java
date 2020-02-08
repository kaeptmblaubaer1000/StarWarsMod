package com.parzivail.pswm.items.turrets;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.mobs.MobDroidAstromech2;
import com.parzivail.pswm.turrets.GroundTurretImperial;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemImperialGroundTurret extends net.minecraft.item.Item
{

	public String name = "spawnImperialGroundTurret";

	public ItemImperialGroundTurret()
	{
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.maxStackSize = 1;
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par1, float par2, float par3, float par4)
	{
		if (player.capabilities.isCreativeMode || player.inventory.consumeInventoryItem(StarWarsItems.spawnImperialGroundTurret))
			if (!world.isRemote)
			{
				GroundTurretImperial newTurret = new GroundTurretImperial(world);
				newTurret.setPosition(x + 0.5D, y + 1, z + 0.5D);
				world.spawnEntityInWorld(newTurret);
			}
		return true;
	}
}
