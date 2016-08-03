package com.parzivail.pswm.tileentities;

import com.parzivail.util.vehicle.VehicleBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.world.World;

public class TileEntitySensorEntity extends TileEntitySensor
{
	public Class<? extends Entity> needle;
	private int rX;
	private int rY;
	private int rZ;

	public TileEntitySensorEntity(Class<? extends Entity> needle, int rX, int rY, int rZ)
	{
		this.needle = needle;
		this.rX = rX;
		this.rY = rY;
		this.rZ = rZ;
	}

	public TileEntitySensorEntity()
	{
	}

	@Override
	boolean checkCondition()
	{
		return this.worldObj != null && this.worldObj.getEntitiesWithinAABB(needle, this.bb.expand(rX, rY, rZ)).isEmpty();
	}

	@Override
	void runConditional()
	{
		if (!worldObj.isRemote)
		{
			try
			{
				int l = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);

				Object c = this.needle.getConstructor(World.class).newInstance(this.worldObj);
				Entity entity = this.needle.cast(c);
				entity.setPositionAndRotation(this.xCoord, this.yCoord + 1, this.zCoord, l * 90, 0);
				if (entity instanceof VehicleBase)
				{
					VehicleBase vehicleBase = (VehicleBase)entity;
					vehicleBase.setRealYaw(l * 90);
					vehicleBase.rotationPitchLast = 0;
				}
				this.worldObj.spawnEntityInWorld(entity);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
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
		p_145841_1_.setInteger("rx", rX);
		p_145841_1_.setInteger("ry", rY);
		p_145841_1_.setInteger("rz", rZ);
		p_145841_1_.setString("class", needle.getCanonicalName());
	}

	@Override
	public void readFromNBT(NBTTagCompound p_145839_1_)
	{
		super.readFromNBT(p_145839_1_);
		this.rX = p_145839_1_.getInteger("rx");
		this.rY = p_145839_1_.getInteger("ry");
		this.rZ = p_145839_1_.getInteger("rz");
		try
		{
			this.needle = (Class<? extends Entity>)Class.forName(p_145839_1_.getString("class"));
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			this.needle = EntityPig.class;
		}
	}
}
