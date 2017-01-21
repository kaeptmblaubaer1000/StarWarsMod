package com.parzivail.pswm.network;

import com.parzivail.pswm.entity.EntityXWingBolt;
import com.parzivail.pswm.utils.BlasterBoltType;
import com.parzivail.pswm.utils.BlasterPosition;
import com.parzivail.pswm.vehicle.VehicXWing;
import com.parzivail.util.lwjgl.Vector3f;
import com.parzivail.util.network.PMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageCreateBlasterBolt extends PMessage<MessageCreateBlasterBolt>
{
	public EntityPlayer sender;
	public int type;
	public int itarget;
	public byte pos;

	public MessageCreateBlasterBolt()
	{
	}

	public MessageCreateBlasterBolt(EntityPlayer sender, int type, Entity target, byte pos)
	{
		this.sender = sender;
		this.type = type;
		this.itarget = target == null ? -1 : target.getEntityId();
		this.pos = pos;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (this.sender == null || this.sender.world == null)
			return null;

		World world = this.sender.world;

		Entity target = itarget == -1 ? null : this.sender.world.getEntityByID(itarget);

		switch (this.type)
		{
			case BlasterBoltType.XWING:
				if (this.sender.getRidingEntity() instanceof VehicXWing)
				{
					VehicXWing vehicXWing = (VehicXWing)this.sender.getRidingEntity();
					float yaw = this.sender.rotationYaw;
					float ax = (float)Math.cos(Math.toRadians(yaw));
					float az = (float)Math.sin(Math.toRadians(yaw));
					float dy = 0.5f;

					dy += vehicXWing.getSFoilAngle(0) * 1.5f;

					Vector3f center = vehicXWing.getLookVec3f();

					EntityXWingBolt bolt = new EntityXWingBolt(world); // bottom left
					Vector3f bPos;
					if ((pos & BlasterPosition.BOTTOM) == BlasterPosition.BOTTOM)
						if ((pos & BlasterPosition.RIGHT) == BlasterPosition.RIGHT)
							bPos = vehicXWing.rotateModelInWorld(VehicXWing.RIGHT_BOTTOM_LASER);
						else
							bPos = vehicXWing.rotateModelInWorld(VehicXWing.LEFT_BOTTOM_LASER);
					else if ((pos & BlasterPosition.RIGHT) == BlasterPosition.RIGHT)
						bPos = vehicXWing.rotateModelInWorld(VehicXWing.RIGHT_TOP_LASER);
					else
						bPos = vehicXWing.rotateModelInWorld(VehicXWing.LEFT_TOP_LASER);

					bolt.setPosition(bPos.x, bPos.y, bPos.z);
					bolt.setThrowableHeading(center.x, center.y, center.z, 1.0F, 1.0F);
					bolt.setSender(this.sender);
					bolt.setTarget(target);
					world.spawnEntity(bolt);
				}
				break;
			// TODO
			//			case BlasterBoltType.PROTON:
			//				if (EntityUtils.getShipRiding(this.sender) instanceof VehicXWing)
			//				{
			//					float yaw = this.sender.rotationYaw;
			//
			//					float ax = (float)Math.cos(Math.toRadians(yaw)) / 2;
			//					float az = (float)Math.sin(Math.toRadians(yaw)) / 2;
			//
			//					if ((pos & BlasterPosition.RIGHT) == BlasterPosition.RIGHT)
			//					{
			//						EntityProtonTorpedo bolt1 = new EntityProtonTorpedo(world);
			//						bolt1.setLocationAndAngles(this.sender.posX + ax, this.sender.posY, this.sender.posZ + az, this.sender.rotationYaw, this.sender.rotationPitch);
			//						bolt1.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
			//						bolt1.setSender(this.sender);
			//						bolt1.setTarget(target);
			//						world.spawnEntityInWorld(bolt1);
			//					}
			//					else
			//					{
			//						EntityProtonTorpedo bolt2 = new EntityProtonTorpedo(world);
			//						bolt2.setLocationAndAngles(this.sender.posX - ax, this.sender.posY, this.sender.posZ - az, this.sender.rotationYaw, this.sender.rotationPitch);
			//						bolt2.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
			//						bolt2.setSender(this.sender);
			//						bolt2.setTarget(target);
			//						world.spawnEntityInWorld(bolt2);
			//					}
			//				}
			//				break;
			//			case BlasterBoltType.BOMB:
			//				if (EntityUtils.getShipRiding(this.sender) instanceof VehicYWing || EntityUtils.getShipRiding(this.sender) instanceof VehicTIEBomber)
			//				{
			//					float yaw = this.sender.rotationYaw;
			//
			//					float ax = (float)Math.cos(Math.toRadians(yaw)) / 2;
			//					float az = (float)Math.sin(Math.toRadians(yaw)) / 2;
			//
			//					if (EntityUtils.getShipRiding(this.sender) instanceof VehicYWing)
			//					{
			//						ax *= 15;
			//						az *= 15;
			//					}
			//
			//					if ((pos & BlasterPosition.RIGHT) == BlasterPosition.RIGHT)
			//					{
			//						EntityBomb bolt1 = new EntityBomb(world);
			//						bolt1.setLocationAndAngles(this.sender.posX + ax, this.sender.posY, this.sender.posZ + az, this.sender.rotationYaw, this.sender.rotationPitch);
			//						bolt1.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
			//						bolt1.setSender(this.sender);
			//						bolt1.setTarget(target);
			//						world.spawnEntityInWorld(bolt1);
			//					}
			//					else
			//					{
			//						EntityBomb bolt2 = new EntityBomb(world);
			//						bolt2.setLocationAndAngles(this.sender.posX - ax, this.sender.posY, this.sender.posZ - az, this.sender.rotationYaw, this.sender.rotationPitch);
			//						bolt2.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
			//						bolt2.setSender(this.sender);
			//						bolt2.setTarget(target);
			//						world.spawnEntityInWorld(bolt2);
			//					}
			//				}
			//				break;
			//			case BlasterBoltType.SPEEDER:
			//				EntityBlasterBoltBase bolt1 = new EntitySpeederBlasterRifleBolt(world, this.sender);
			//				bolt1.setTarget(target);
			//				world.spawnEntityInWorld(bolt1);
			//				break;
			//			case BlasterBoltType.EZRA:
			//				EntityBlasterBoltBase bolt2 = new EntityBlasterEzraBolt(world, this.sender);
			//				bolt2.setTarget(target);
			//				world.spawnEntityInWorld(bolt2);
			//				break;
			//			case BlasterBoltType.ATST:
			//				if (EntityUtils.getShipRiding(this.sender) instanceof VehicATST)
			//				{
			//					float yaw = this.sender.rotationYaw;
			//					float ax = (float)Math.cos(Math.toRadians(yaw));
			//					float az = (float)Math.sin(Math.toRadians(yaw));
			//					float dy = 1.5f;
			//
			//					float r = 0.5f;
			//
			//					if ((pos & BlasterPosition.RIGHT) == BlasterPosition.RIGHT)
			//					{
			//						EntityXWingBolt bolt1x = new EntityXWingBolt(world);
			//						bolt1x.setLocationAndAngles(this.sender.posX + ax * r, this.sender.posY + this.sender.getEyeHeight() - dy, this.sender.posZ + az * r, this.sender.rotationYaw, this.sender.rotationPitch);
			//						bolt1x.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
			//						bolt1x.setSender(this.sender);
			//						bolt1x.setTarget(target);
			//						world.spawnEntityInWorld(bolt1x);
			//					}
			//					else
			//					{
			//						EntityXWingBolt bolt2x = new EntityXWingBolt(world);
			//						bolt2x.setLocationAndAngles(this.sender.posX + ax * -r, this.sender.posY + this.sender.getEyeHeight() - dy, this.sender.posZ + az * -r, this.sender.rotationYaw, this.sender.rotationPitch);
			//						bolt2x.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
			//						bolt2x.setSender(this.sender);
			//						bolt2x.setTarget(target);
			//						world.spawnEntityInWorld(bolt2x);
			//					}
			//				}
			//				break;
			//			case BlasterBoltType.AWING:
			//				if (EntityUtils.getShipRiding(this.sender) instanceof VehicAWing)
			//				{
			//					float yaw = this.sender.rotationYaw;
			//					float ax = (float)Math.cos(Math.toRadians(yaw));
			//					float az = (float)Math.sin(Math.toRadians(yaw));
			//					float dy = 0f;
			//
			//					if ((pos & BlasterPosition.RIGHT) == BlasterPosition.RIGHT)
			//					{
			//						EntityXWingBolt bolt1x = new EntityXWingBolt(world);
			//						bolt1x.setLocationAndAngles(this.sender.posX + ax * 2, this.sender.posY + this.sender.getEyeHeight() - dy, this.sender.posZ + az * 2, this.sender.rotationYaw, this.sender.rotationPitch);
			//						bolt1x.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
			//						bolt1x.setSender(this.sender);
			//						bolt1x.setTarget(target);
			//						world.spawnEntityInWorld(bolt1x);
			//					}
			//					else
			//					{
			//						EntityXWingBolt bolt2x = new EntityXWingBolt(world);
			//						bolt2x.setLocationAndAngles(this.sender.posX + ax * -2, this.sender.posY + this.sender.getEyeHeight() - dy, this.sender.posZ + az * -2, this.sender.rotationYaw, this.sender.rotationPitch);
			//						bolt2x.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
			//						bolt2x.setSender(this.sender);
			//						bolt2x.setTarget(target);
			//						world.spawnEntityInWorld(bolt2x);
			//					}
			//				}
			//				break;
			//			case BlasterBoltType.SKYHOPPER:
			//				EntityXWingBolt bolt1x = new EntityXWingBolt(world);
			//				bolt1x.setTarget(target);
			//				bolt1x.setLocationAndAngles(this.sender.posX, this.sender.posY + this.sender.getEyeHeight() - 3, this.sender.posZ, this.sender.rotationYaw, this.sender.rotationPitch);
			//				bolt1x.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
			//				bolt1x.setSender(this.sender);
			//				world.spawnEntityInWorld(bolt1x);
			//				break;
			//			case BlasterBoltType.SNOWSPEEDER:
			//				if (EntityUtils.getShipRiding(this.sender) instanceof VehicSnowspeeder)
			//				{
			//					float yaw = this.sender.rotationYaw;
			//					float ax = (float)Math.cos(Math.toRadians(yaw));
			//					float az = (float)Math.sin(Math.toRadians(yaw));
			//					float dy = 0f;
			//
			//					float r = 2.2f;
			//
			//					if ((pos & BlasterPosition.RIGHT) == BlasterPosition.RIGHT)
			//					{
			//						bolt1x = new EntityXWingBolt(world);
			//						bolt1x.setLocationAndAngles(this.sender.posX + ax * r, this.sender.posY + this.sender.getEyeHeight() - dy, this.sender.posZ + az * r, this.sender.rotationYaw, this.sender.rotationPitch);
			//						bolt1x.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
			//						bolt1x.setSender(this.sender);
			//						bolt1x.setTarget(target);
			//						world.spawnEntityInWorld(bolt1x);
			//					}
			//					else
			//					{
			//						EntityXWingBolt bolt2x = new EntityXWingBolt(world);
			//						bolt2x.setLocationAndAngles(this.sender.posX + ax * -r, this.sender.posY + this.sender.getEyeHeight() - dy, this.sender.posZ + az * -r, this.sender.rotationYaw, this.sender.rotationPitch);
			//						bolt2x.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
			//						bolt2x.setSender(this.sender);
			//						bolt2x.setTarget(target);
			//						world.spawnEntityInWorld(bolt2x);
			//					}
			//				}
			//				break;
			//			case BlasterBoltType.TIE:
			//				float yaw = this.sender.rotationYaw;
			//
			//				float ax = (float)Math.cos(Math.toRadians(yaw)) / 2;
			//				float az = (float)Math.sin(Math.toRadians(yaw)) / 2;
			//
			//				if ((pos & BlasterPosition.RIGHT) == BlasterPosition.RIGHT)
			//				{
			//					EntityTIEBolt bolt1xx = new EntityTIEBolt(world);
			//					bolt1xx.setLocationAndAngles(this.sender.posX + ax, this.sender.posY, this.sender.posZ + az, this.sender.rotationYaw, this.sender.rotationPitch);
			//					bolt1xx.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
			//					bolt1xx.setSender(this.sender);
			//					bolt1xx.setTarget(target);
			//					world.spawnEntityInWorld(bolt1xx);
			//				}
			//				else
			//				{
			//					EntityTIEBolt bolt2x = new EntityTIEBolt(world);
			//					bolt2x.setLocationAndAngles(this.sender.posX - ax, this.sender.posY, this.sender.posZ - az, this.sender.rotationYaw, this.sender.rotationPitch);
			//					bolt2x.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
			//					bolt2x.setSender(this.sender);
			//					bolt2x.setTarget(target);
			//					world.spawnEntityInWorld(bolt2x);
			//				}
			//				break;
			//			case BlasterBoltType.YWING:
			//				if (EntityUtils.getShipRiding(this.sender) instanceof VehicYWing)
			//				{
			//					yaw = this.sender.rotationYaw;
			//					ax = (float)Math.cos(Math.toRadians(yaw));
			//					az = (float)Math.sin(Math.toRadians(yaw));
			//					float dy = 0.5f;
			//
			//					float r = 0.5f;
			//
			//					if ((pos & BlasterPosition.RIGHT) == BlasterPosition.RIGHT)
			//					{
			//						bolt1x = new EntityXWingBolt(world);
			//						bolt1x.setLocationAndAngles(this.sender.posX + ax * r, this.sender.posY + this.sender.getEyeHeight() - dy, this.sender.posZ + az * r, this.sender.rotationYaw, this.sender.rotationPitch);
			//						bolt1x.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
			//						bolt1x.setSender(this.sender);
			//						bolt1x.setTarget(target);
			//						world.spawnEntityInWorld(bolt1x);
			//					}
			//					else
			//					{
			//						EntityXWingBolt bolt2xx = new EntityXWingBolt(world);
			//						bolt2xx.setLocationAndAngles(this.sender.posX + ax * -r, this.sender.posY + this.sender.getEyeHeight() - dy, this.sender.posZ + az * -r, this.sender.rotationYaw, this.sender.rotationPitch);
			//						bolt2xx.setThrowableHeading(this.sender.getLookVec().xCoord, this.sender.getLookVec().yCoord, this.sender.getLookVec().zCoord, 1.0F, 1.0F);
			//						bolt2xx.setSender(this.sender);
			//						bolt2xx.setTarget(target);
			//						world.spawnEntityInWorld(bolt2xx);
			//					}
			//				}
			//				break;
			default:
				break;
		}
		return null;
	}

}