package com.parzivail.pswm.tileentities;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.items.weapons.ItemLightsaber;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMovingLightSource extends TileEntity
{
	@Override
	public void updateEntity()
	{
		// check if ship has moved away from the tile entity
		EntityPlayer closestPlayer = worldObj.getClosestPlayer(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D, 3.0D);

		if (((closestPlayer == null) || (closestPlayer.getCurrentEquippedItem() == null) || !(closestPlayer.getCurrentEquippedItem().getItem() instanceof ItemLightsaber) || !ItemLightsaber.isOn(closestPlayer.getCurrentEquippedItem())) && (worldObj.getBlock(xCoord, yCoord, zCoord) == StarWarsMod.blockMovingLightSource))
			worldObj.setBlockToAir(xCoord, yCoord, zCoord);
	}
}