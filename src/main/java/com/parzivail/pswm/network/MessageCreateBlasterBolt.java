package com.parzivail.pswm.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.parzivail.pswm.entities.EntitySpeederBlasterRifleBolt;
import com.parzivail.pswm.entities.EntityTIEBolt;
import com.parzivail.pswm.entities.EntityXWingBolt;
import com.parzivail.pswm.utils.BlasterBoltType;
import com.parzivail.pswm.vehicles.VehicXWing;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageCreateBlasterBolt extends Message<MessageCreateBlasterBolt>
{
	public EntityPlayer sender;
	public int type;

	public MessageCreateBlasterBolt()
	{
	}

	public MessageCreateBlasterBolt(EntityPlayer sender, int type)
	{
		this.sender = sender;
		this.type = type;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		World world = this.sender.worldObj;
		if (this.type == BlasterBoltType.SPEEDER)
			world.spawnEntityInWorld(new EntitySpeederBlasterRifleBolt(world, this.sender));
		else if (this.type == BlasterBoltType.XWING)
		{
			float yaw = this.sender.rotationYaw;

			float ax = (float)Math.cos(Math.toRadians(yaw));
			float az = (float)Math.sin(Math.toRadians(yaw));

			float dy = 0.5f;

			if (this.sender.ridingEntity instanceof VehicXWing)
			{
				VehicXWing vehicXWing = (VehicXWing)this.sender.ridingEntity;
				dy += vehicXWing.getSFoil();

				EntityXWingBolt bolt1 = new EntityXWingBolt(world);
				bolt1.setLocationAndAngles(sender.posX + (ax * 4), sender.posY + sender.getEyeHeight() - dy, sender.posZ + (az * 4), sender.rotationYaw, sender.rotationPitch);
				bolt1.setThrowableHeading(sender.getLookVec().xCoord, sender.getLookVec().yCoord, sender.getLookVec().zCoord, 1.0F, 1.0F);
				bolt1.setSender(sender);
				world.spawnEntityInWorld(bolt1);

				EntityXWingBolt bolt2 = new EntityXWingBolt(world);
				bolt2.setLocationAndAngles(sender.posX + (ax * -4), sender.posY + sender.getEyeHeight() - dy, sender.posZ + (az * -4), sender.rotationYaw, sender.rotationPitch);
				bolt2.setThrowableHeading(sender.getLookVec().xCoord, sender.getLookVec().yCoord, sender.getLookVec().zCoord, 1.0F, 1.0F);
				bolt2.setSender(sender);
				world.spawnEntityInWorld(bolt2);

				EntityXWingBolt bolt3 = new EntityXWingBolt(world);
				bolt3.setLocationAndAngles(sender.posX + (ax * 4), sender.posY + sender.getEyeHeight() + dy, sender.posZ + (az * 4), sender.rotationYaw, sender.rotationPitch);
				bolt3.setThrowableHeading(sender.getLookVec().xCoord, sender.getLookVec().yCoord, sender.getLookVec().zCoord, 1.0F, 1.0F);
				bolt3.setSender(sender);
				world.spawnEntityInWorld(bolt3);

				EntityXWingBolt bolt4 = new EntityXWingBolt(world);
				bolt4.setLocationAndAngles(sender.posX + (ax * -4), sender.posY + sender.getEyeHeight() + dy, sender.posZ + (az * -4), sender.rotationYaw, sender.rotationPitch);
				bolt4.setThrowableHeading(sender.getLookVec().xCoord, sender.getLookVec().yCoord, sender.getLookVec().zCoord, 1.0F, 1.0F);
				bolt4.setSender(sender);
				world.spawnEntityInWorld(bolt4);
			}
			else
			{
				EntityXWingBolt bolt1 = new EntityXWingBolt(world);
				bolt1.setLocationAndAngles(sender.posX, sender.posY + sender.getEyeHeight() - dy, sender.posZ, sender.rotationYaw, sender.rotationPitch);
				bolt1.setThrowableHeading(sender.getLookVec().xCoord, sender.getLookVec().yCoord, sender.getLookVec().zCoord, 1.0F, 1.0F);
				bolt1.setSender(sender);
				world.spawnEntityInWorld(bolt1);
			}
		}
		else if (this.type == BlasterBoltType.TIE)
		{
			float yaw = this.sender.rotationYaw;

			float ax = (float)Math.cos(Math.toRadians(yaw)) / 2;
			float az = (float)Math.sin(Math.toRadians(yaw)) / 2;

			EntityTIEBolt bolt1 = new EntityTIEBolt(world);
			bolt1.setLocationAndAngles(sender.posX + ax, sender.posY, sender.posZ + az, sender.rotationYaw, sender.rotationPitch);
			bolt1.setThrowableHeading(sender.getLookVec().xCoord, sender.getLookVec().yCoord, sender.getLookVec().zCoord, 1.0F, 1.0F);
			bolt1.setSender(sender);
			world.spawnEntityInWorld(bolt1);

			EntityTIEBolt bolt2 = new EntityTIEBolt(world);
			bolt2.setLocationAndAngles(sender.posX - ax, sender.posY, sender.posZ - az, sender.rotationYaw, sender.rotationPitch);
			bolt2.setThrowableHeading(sender.getLookVec().xCoord, sender.getLookVec().yCoord, sender.getLookVec().zCoord, 1.0F, 1.0F);
			bolt2.setSender(sender);
			world.spawnEntityInWorld(bolt2);
		}
		return null;
	}

}