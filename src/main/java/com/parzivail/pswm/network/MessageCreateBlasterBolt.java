package com.parzivail.pswm.network;

import com.parzivail.pswm.entities.*;
import com.parzivail.pswm.utils.BlasterBoltType;
import com.parzivail.pswm.vehicles.*;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MessageCreateBlasterBolt extends PMessage<MessageCreateBlasterBolt>
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
		if (this.sender == null || this.sender.worldObj == null)
			return null;

		World world = this.sender.worldObj;

		switch (this.type)
		{
			case BlasterBoltType.XWING:
				if (this.sender.ridingEntity instanceof VehicXWing)
				{
					float yaw = this.sender.rotationYaw;
					float ax = (float)Math.cos(Math.toRadians(yaw));
					float az = (float)Math.sin(Math.toRadians(yaw));
					float dy = 0.5f;

					VehicXWing vehicXWing = (VehicXWing)this.sender.ridingEntity;
					dy += vehicXWing.getSFoil() * 1.5f;

					float r = 5.5f;

					EntityXWingBolt bolt1 = new EntityXWingBolt(world);
					bolt1.setLocationAndAngles(this.sender.posX + ax * r, this.sender.posY + this.sender.getEyeHeight() - dy, this.sender.posZ + az * r, this.sender.rotationYaw, this.sender.rotationPitch);
					bolt1.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
					bolt1.setSender(this.sender);
					world.spawnEntityInWorld(bolt1);

					EntityXWingBolt bolt2 = new EntityXWingBolt(world);
					bolt2.setLocationAndAngles(this.sender.posX + ax * -r, this.sender.posY + this.sender.getEyeHeight() - dy, this.sender.posZ + az * -r, this.sender.rotationYaw, this.sender.rotationPitch);
					bolt2.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
					bolt2.setSender(this.sender);
					world.spawnEntityInWorld(bolt2);

					EntityXWingBolt bolt3 = new EntityXWingBolt(world);
					bolt3.setLocationAndAngles(this.sender.posX + ax * r, this.sender.posY + this.sender.getEyeHeight() + dy, this.sender.posZ + az * r, this.sender.rotationYaw, this.sender.rotationPitch);
					bolt3.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
					bolt3.setSender(this.sender);
					world.spawnEntityInWorld(bolt3);

					EntityXWingBolt bolt4 = new EntityXWingBolt(world);
					bolt4.setLocationAndAngles(this.sender.posX + ax * -r, this.sender.posY + this.sender.getEyeHeight() + dy, this.sender.posZ + az * -r, this.sender.rotationYaw, this.sender.rotationPitch);
					bolt4.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
					bolt4.setSender(this.sender);
					world.spawnEntityInWorld(bolt4);
				}
				break;
			case BlasterBoltType.PROTON:
				if (this.sender.ridingEntity instanceof VehicXWing)
				{
					float yaw = this.sender.rotationYaw;

					float ax = (float)Math.cos(Math.toRadians(yaw)) / 2;
					float az = (float)Math.sin(Math.toRadians(yaw)) / 2;

					EntityProtonTorpedo bolt1 = new EntityProtonTorpedo(world);
					bolt1.setLocationAndAngles(this.sender.posX + ax, this.sender.posY, this.sender.posZ + az, this.sender.rotationYaw, this.sender.rotationPitch);
					bolt1.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
					bolt1.setSender(this.sender);
					world.spawnEntityInWorld(bolt1);

					EntityProtonTorpedo bolt2 = new EntityProtonTorpedo(world);
					bolt2.setLocationAndAngles(this.sender.posX - ax, this.sender.posY, this.sender.posZ - az, this.sender.rotationYaw, this.sender.rotationPitch);
					bolt2.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
					bolt2.setSender(this.sender);
					world.spawnEntityInWorld(bolt2);
				}
				break;
			case BlasterBoltType.BOMB:
				if (this.sender.ridingEntity instanceof VehicYWing || this.sender.ridingEntity instanceof VehicTIEBomber)
				{
					float yaw = this.sender.rotationYaw;

					float ax = (float)Math.cos(Math.toRadians(yaw)) / 2;
					float az = (float)Math.sin(Math.toRadians(yaw)) / 2;

					if (this.sender.ridingEntity instanceof VehicYWing)
					{
						ax *= 15;
						az *= 15;
					}

					EntityBomb bolt1 = new EntityBomb(world);
					bolt1.setLocationAndAngles(this.sender.posX + ax, this.sender.posY, this.sender.posZ + az, this.sender.rotationYaw, this.sender.rotationPitch);
					bolt1.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
					bolt1.setSender(this.sender);
					world.spawnEntityInWorld(bolt1);

					EntityBomb bolt2 = new EntityBomb(world);
					bolt2.setLocationAndAngles(this.sender.posX - ax, this.sender.posY, this.sender.posZ - az, this.sender.rotationYaw, this.sender.rotationPitch);
					bolt2.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
					bolt2.setSender(this.sender);
					world.spawnEntityInWorld(bolt2);
				}
				break;
			case BlasterBoltType.SPEEDER:
				world.spawnEntityInWorld(new EntitySpeederBlasterRifleBolt(world, this.sender));
				break;
			case BlasterBoltType.EZRA:
				world.spawnEntityInWorld(new EntityBlasterEzraBolt(world, this.sender));
				break;
			case BlasterBoltType.ATST:
				if (this.sender.ridingEntity instanceof VehicATST)
				{
					float yaw = this.sender.rotationYaw;
					float ax = (float)Math.cos(Math.toRadians(yaw));
					float az = (float)Math.sin(Math.toRadians(yaw));
					float dy = 1.5f;

					float r = 0.5f;

					EntityXWingBolt bolt1x = new EntityXWingBolt(world);
					bolt1x.setLocationAndAngles(this.sender.posX + ax * r, this.sender.posY + this.sender.getEyeHeight() - dy, this.sender.posZ + az * r, this.sender.rotationYaw, this.sender.rotationPitch);
					bolt1x.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
					bolt1x.setSender(this.sender);
					world.spawnEntityInWorld(bolt1x);

					EntityXWingBolt bolt2x = new EntityXWingBolt(world);
					bolt2x.setLocationAndAngles(this.sender.posX + ax * -r, this.sender.posY + this.sender.getEyeHeight() - dy, this.sender.posZ + az * -r, this.sender.rotationYaw, this.sender.rotationPitch);
					bolt2x.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
					bolt2x.setSender(this.sender);
					world.spawnEntityInWorld(bolt2x);
				}
				break;
			case BlasterBoltType.AWING:
				if (this.sender.ridingEntity instanceof VehicAWing)
				{
					float yaw = this.sender.rotationYaw;
					float ax = (float)Math.cos(Math.toRadians(yaw));
					float az = (float)Math.sin(Math.toRadians(yaw));
					float dy = 0f;

					EntityXWingBolt bolt1 = new EntityXWingBolt(world);
					bolt1.setLocationAndAngles(this.sender.posX + ax * 2, this.sender.posY + this.sender.getEyeHeight() - dy, this.sender.posZ + az * 2, this.sender.rotationYaw, this.sender.rotationPitch);
					bolt1.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
					bolt1.setSender(this.sender);
					world.spawnEntityInWorld(bolt1);

					EntityXWingBolt bolt2 = new EntityXWingBolt(world);
					bolt2.setLocationAndAngles(this.sender.posX + ax * -2, this.sender.posY + this.sender.getEyeHeight() - dy, this.sender.posZ + az * -2, this.sender.rotationYaw, this.sender.rotationPitch);
					bolt2.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
					bolt2.setSender(this.sender);
					world.spawnEntityInWorld(bolt2);
				}
				break;
			case BlasterBoltType.SKYHOPPER:
				EntityXWingBolt bolt1x = new EntityXWingBolt(world);
				bolt1x.setLocationAndAngles(this.sender.posX, this.sender.posY + this.sender.getEyeHeight() - 3, this.sender.posZ, this.sender.rotationYaw, this.sender.rotationPitch);
				bolt1x.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
				bolt1x.setSender(this.sender);
				world.spawnEntityInWorld(bolt1x);
				break;
			case BlasterBoltType.SNOWSPEEDER:
				if (this.sender.ridingEntity instanceof VehicSnowspeeder)
				{
					float yaw = this.sender.rotationYaw;
					float ax = (float)Math.cos(Math.toRadians(yaw));
					float az = (float)Math.sin(Math.toRadians(yaw));
					float dy = 0f;

					float r = 2.2f;

					bolt1x = new EntityXWingBolt(world);
					bolt1x.setLocationAndAngles(this.sender.posX + ax * r, this.sender.posY + this.sender.getEyeHeight() - dy, this.sender.posZ + az * r, this.sender.rotationYaw, this.sender.rotationPitch);
					bolt1x.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
					bolt1x.setSender(this.sender);
					world.spawnEntityInWorld(bolt1x);

					EntityXWingBolt bolt2x = new EntityXWingBolt(world);
					bolt2x.setLocationAndAngles(this.sender.posX + ax * -r, this.sender.posY + this.sender.getEyeHeight() - dy, this.sender.posZ + az * -r, this.sender.rotationYaw, this.sender.rotationPitch);
					bolt2x.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
					bolt2x.setSender(this.sender);
					world.spawnEntityInWorld(bolt2x);
				}
				break;
			case BlasterBoltType.TIE:
				float yaw = this.sender.rotationYaw;

				float ax = (float)Math.cos(Math.toRadians(yaw)) / 2;
				float az = (float)Math.sin(Math.toRadians(yaw)) / 2;

				EntityTIEBolt bolt1 = new EntityTIEBolt(world);
				bolt1.setLocationAndAngles(this.sender.posX + ax, this.sender.posY, this.sender.posZ + az, this.sender.rotationYaw, this.sender.rotationPitch);
				bolt1.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
				bolt1.setSender(this.sender);
				world.spawnEntityInWorld(bolt1);

				EntityTIEBolt bolt2 = new EntityTIEBolt(world);
				bolt2.setLocationAndAngles(this.sender.posX - ax, this.sender.posY, this.sender.posZ - az, this.sender.rotationYaw, this.sender.rotationPitch);
				bolt2.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
				bolt2.setSender(this.sender);
				world.spawnEntityInWorld(bolt2);
				break;
			case BlasterBoltType.YWING:
				if (this.sender.ridingEntity instanceof VehicYWing)
				{
					yaw = this.sender.rotationYaw;
					ax = (float)Math.cos(Math.toRadians(yaw));
					az = (float)Math.sin(Math.toRadians(yaw));
					float dy = 0.5f;

					float r = 0.5f;

					bolt1x = new EntityXWingBolt(world);
					bolt1x.setLocationAndAngles(this.sender.posX + ax * r, this.sender.posY + this.sender.getEyeHeight() - dy, this.sender.posZ + az * r, this.sender.rotationYaw, this.sender.rotationPitch);
					bolt1x.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
					bolt1x.setSender(this.sender);
					world.spawnEntityInWorld(bolt1x);

					EntityXWingBolt bolt2x = new EntityXWingBolt(world);
					bolt2x.setLocationAndAngles(this.sender.posX + ax * -r, this.sender.posY + this.sender.getEyeHeight() - dy, this.sender.posZ + az * -r, this.sender.rotationYaw, this.sender.rotationPitch);
					bolt2x.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
					bolt2x.setSender(this.sender);
					world.spawnEntityInWorld(bolt2x);
				}
				break;
			default:
				break;
		}
		return null;
	}

}