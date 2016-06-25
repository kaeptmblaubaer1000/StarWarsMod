package com.parzivail.pswm.tileentities;

import com.parzivail.pswm.Resources;
import com.parzivail.util.math.MathUtils;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityConsoleHoth1 extends TileEntity
{
	int facing = 0;

	public int color1 = 0;
	public int color2 = 0;
	public int color3 = 0;
	public int color4 = 0;
	public int color5 = 0;
	public int color6 = 0;

	@Override
	public void updateEntity()
	{
		if (MathUtils.oneIn(50))
			color1 = MathUtils.getRandomElement(Resources.hothPanelLightColors);
		if (MathUtils.oneIn(100))
			color2 = MathUtils.getRandomElement(Resources.hothPanelLightColors);
		if (MathUtils.oneIn(150))
			color3 = MathUtils.getRandomElement(Resources.hothPanelLightColors);
		if (MathUtils.oneIn(25))
			color4 = MathUtils.getRandomElement(Resources.hothPanelLightColors);
		if (MathUtils.oneIn(200))
			color5 = MathUtils.getRandomElement(Resources.hothPanelLightColors);
		if (MathUtils.oneIn(250))
			color6 = MathUtils.getRandomElement(Resources.hothPanelLightColors);
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 64537, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
	{
		super.onDataPacket(net, packet);
		this.readFromNBT(packet.func_148857_g());
	}

	@Override
	public void writeToNBT(NBTTagCompound p_145841_1_)
	{
		super.writeToNBT(p_145841_1_);
		p_145841_1_.setInteger("facing", getFacing());
	}

	public int getFacing()
	{
		return facing;
	}

	public void setFacing(int facing)
	{
		this.facing = facing;
	}

	@Override
	public void readFromNBT(NBTTagCompound p_145839_1_)
	{
		super.readFromNBT(p_145839_1_);
		this.setFacing(p_145839_1_.getInteger("facing"));
	}
}
