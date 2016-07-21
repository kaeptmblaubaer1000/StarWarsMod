package com.parzivail.pswm.tileentities;

import com.parzivail.pswm.mobs.trooper.MobDefaultBiped;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityStaticNpc extends TileEntity
{
	AxisAlignedBB bb;
	MobDefaultBiped internalBiped;

	boolean locked = false;
	int facing = 0;

	String id = "";
	String aff = "";

	public TileEntityStaticNpc()
	{
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

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getAff()
	{
		return aff;
	}

	public void setAff(String aff)
	{
		this.aff = aff;
	}

	public int getFacing()
	{
		return facing;
	}

	public void setFacing(int facing)
	{
		this.facing = facing;
	}

	public boolean getLocked()
	{
		return locked;
	}

	public void setLocked(boolean locked)
	{
		this.locked = locked;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public double getMaxRenderDistanceSquared()
	{
		return 262144;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox()
	{
		if (this.bb == null)
			this.bb = AxisAlignedBB.getBoundingBox(this.xCoord + 0.1f, this.yCoord, this.zCoord + 0.1f, this.xCoord + 0.9f, this.yCoord + 1.8f, this.zCoord + 0.9f);
		return this.bb;
	}

	@Override
	public void updateEntity()
	{
		if (this.internalBiped != null)
		{
			if (this.internalBiped.worldObj == null)
				this.internalBiped.worldObj = this.worldObj;
			this.internalBiped.ticksExisted++;
		}
		super.updateEntity();
	}

	@Override
	public void readFromNBT(NBTTagCompound p_145839_1_)
	{
		super.readFromNBT(p_145839_1_);
		this.setId(p_145839_1_.getString("quest-id"));
		this.setFacing(p_145839_1_.getInteger("facing"));
		this.setLocked(p_145839_1_.getBoolean("locked"));
	}

	@Override
	public void writeToNBT(NBTTagCompound p_145841_1_)
	{
		super.writeToNBT(p_145841_1_);
		p_145841_1_.setString("quest-id", getId());
		p_145841_1_.setInteger("facing", getFacing());
		p_145841_1_.setBoolean("locked", getLocked());
	}

	public MobDefaultBiped getInternalEntity()
	{
		if (internalBiped == null)
			internalBiped = new MobDefaultBiped(this.worldObj);
		return internalBiped;
	}
}