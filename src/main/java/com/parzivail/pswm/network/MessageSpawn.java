package com.parzivail.pswm.network;

import com.parzivail.util.network.PMessage;
import com.parzivail.util.ui.Lumberjack;
import com.parzivail.util.vehicle.VehicleAirBase;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class MessageSpawn extends PMessage<MessageSpawn>
{
	public World world;
	public String entityClass;
	public float x, y, z, yaw, pitch;

	public MessageSpawn()
	{
	}

	public MessageSpawn(World world, Class<? extends Entity> entityClass, float x, float y, float z, float pitch, float yaw)
	{
		this.world = world;
		this.entityClass = entityClass.getName();
		this.x = x;
		this.y = y;
		this.z = z;
		this.pitch = pitch;
		this.yaw = yaw;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		try
		{
			Class<? extends Entity> clazz = (Class<? extends Entity>)Class.forName(this.entityClass);
			Object c = clazz.getConstructor(World.class).newInstance(this.world);
			Entity entity = clazz.cast(c);
			entity.setPositionAndRotation(this.x, this.y, this.z, yaw, pitch);
			if (entity instanceof VehicleAirBase)
			{
				VehicleAirBase vehicleBase = (VehicleAirBase)entity;
				vehicleBase.rotationLast = yaw;
				vehicleBase.rotationPitchLast = pitch;
				vehicleBase.setYaw((int)yaw);
			}
			world.spawnEntityInWorld(entity);
		}
		catch (Exception e)
		{
			Lumberjack.log(this.world);
		}
		return null;
	}
}
