package com.parzi.starwarsmod.tileentities;

import net.minecraft.tileentity.TileEntity;

public class TileEntityMV extends TileEntity
{
	public float frame = 0;

	@Override
	public void updateEntity()
    {
        super.updateEntity();
        if (++frame>1800) frame = 0;
    }
}