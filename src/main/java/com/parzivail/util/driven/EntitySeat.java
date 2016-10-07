package com.parzivail.util.driven;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.lwjgl.Vector3f;
import com.parzivail.util.math.RotatedAxes;
import com.parzivail.util.ui.Lumberjack;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntitySeat extends Entity implements IEntityAdditionalSpawnData
{
	/**
	 * Set this to true when the client has found the parent drivable and connected them
	 */
	@SideOnly(Side.CLIENT)
	public boolean foundPilotable;
	private int pilotableID;
	private int seatID;
	public Pilotable pilotable;

	@SideOnly(Side.CLIENT)
	public float playerRoll, prevPlayerRoll;

	public Seat seatInfo;
	public boolean driver;

	/**
	 * A set of axes used to calculate where the player is looking, x axis is the direction of looking, y is up
	 */
	public RotatedAxes looking;
	/**
	 * For smooth renderering
	 */
	public RotatedAxes prevLooking;


	private double playerPosX, playerPosY, playerPosZ;
	private float playerYaw, playerPitch;
	/**
	 * For smoothness
	 */
	private double prevPlayerPosX, prevPlayerPosY, prevPlayerPosZ;
	private float prevPlayerYaw, prevPlayerPitch;


	/**
	 * Default constructor for spawning client side
	 * Should not be called server side EVER
	 */
	public EntitySeat(World world)
	{
		super(world);
		setSize(1F, 1F);
		prevLooking = new RotatedAxes();
		looking = new RotatedAxes();
	}

	/**
	 * Server side seat constructor
	 */
	public EntitySeat(World world, Pilotable d, int id)
	{
		this(world);
		pilotable = d;
		pilotableID = d.getEntityId();
		seatInfo = pilotable.getSeatData(id);
		driver = id == 0;
		setPosition(d.posX, d.posY, d.posZ);
		playerPosX = prevPlayerPosX = posX;
		playerPosY = prevPlayerPosY = posY;
		playerPosZ = prevPlayerPosZ = posZ;
		looking.setAngles((seatInfo.minYaw + seatInfo.maxYaw) / 2, 0F, 0F);
	}

	@Override
	public void setPositionAndRotation2(double x, double y, double z, float yaw, float pitch, int i)
	{
	}

	public void getKeyInput()
	{
		if (!(this.getControllingEntity() instanceof EntityPlayer))
			return;

		if ($(StarWarsMod.mc.gameSettings.keyBindLeft))
		{
			this.pilotable.rotateRoll(10);
		}
		if ($(StarWarsMod.mc.gameSettings.keyBindRight))
		{
			this.pilotable.rotateRoll(-10);
		}
		if ($(StarWarsMod.mc.gameSettings.keyBindForward))
		{
			this.pilotable.rotatePitch(-10);
		}
		if ($(StarWarsMod.mc.gameSettings.keyBindBack))
		{
			this.pilotable.rotatePitch(10);
		}
	}

	private boolean $(KeyBinding key)
	{
		return key.getIsKeyPressed() && this.getControllingEntity() instanceof EntityPlayer/* && StarWarsMod.proxy.isThePlayer((EntityPlayer)this.getControllingEntity())*/;
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		getKeyInput();

		//If on the client and the drivable parent has yet to be found, search for it
		if (worldObj.isRemote && !foundPilotable)
		{
			pilotable = (Pilotable)worldObj.getEntityByID(pilotableID);
			if (pilotable == null)
				return;
			foundPilotable = true;
			pilotable.seats[seatID] = this;
			seatInfo = pilotable.getSeatData(seatID);
			looking.setAngles((seatInfo.minYaw + seatInfo.maxYaw) / 2, 0F, 0F);
			playerPosX = prevPlayerPosX = posX = pilotable.posX;
			playerPosY = prevPlayerPosY = posY = pilotable.posY;
			playerPosZ = prevPlayerPosZ = posZ = pilotable.posZ;
			setPosition(posX, posY, posZ);
		}

		//If on the client
		//		//DEBUG : Spawn particles along axes
		//		if (worldObj.isRemote)
		//		{
		//			if (driver && riddenByEntity == Minecraft.getMinecraft().thePlayer && Pilotable.MOUSE_CONTROL_MODE)
		//			{
		//				looking = new RotatedAxes();
		//			}
		//
		//			Vector3f xAxis = pilotable.axes.findLocalAxesGlobally(looking).getXAxis();
		//			Vector3f yAxis = pilotable.axes.findLocalAxesGlobally(looking).getYAxis();
		//			Vector3f zAxis = pilotable.axes.findLocalAxesGlobally(looking).getZAxis();
		//			Vector3f yOffset = pilotable.axes.findLocalVectorGlobally(new Vector3f(0F, riddenByEntity == null ? 0F : (float)riddenByEntity.getYOffset(), 0F));
		//			for (int i = 0; i < 10; i++)
		//			{
		//				worldObj.spawnParticle("enchantmenttable", posX + xAxis.x * i * 0.3D + yOffset.x, posY + xAxis.y * i * 0.3D + yOffset.y, posZ + xAxis.z * i * 0.3D + yOffset.z, 0, 0, 0);
		//				worldObj.spawnParticle("smoke", posX + yAxis.x * i * 0.3D + yOffset.x, posY + yAxis.y * i * 0.3D + yOffset.y, posZ + yAxis.z * i * 0.3D + yOffset.z, 0, 0, 0);
		//				worldObj.spawnParticle("reddust", posX + zAxis.x * i * 0.3D + yOffset.x, posY + zAxis.y * i * 0.3D + yOffset.y, posZ + zAxis.z * i * 0.3D + yOffset.z, 0, 0, 0);
		//			}
		//		}
	}

	/**
	 * Set the position to be that of the drivable plus the local position, rotated
	 */
	public void updatePosition()
	{
		//If we haven't found our drivable, give up
		if (worldObj.isRemote && !foundPilotable)
			return;

		prevPlayerPosX = playerPosX;
		prevPlayerPosY = playerPosY;
		prevPlayerPosZ = playerPosZ;

		prevPlayerYaw = playerYaw;
		prevPlayerPitch = playerPitch;

		//Get the position of this seat on the drivable axes
		Vector3f localPosition = new Vector3f(seatInfo.x / 16F, seatInfo.y / 16F, seatInfo.z / 16F);

		if (pilotable != null)
		{
			//Rotate the offset vector by the turret yaw
			if (pilotable.seats != null && pilotable.seats[0] != null && pilotable.seats[0].looking != null)
			{
				RotatedAxes yawOnlyLooking = new RotatedAxes(pilotable.seats[0].looking.getYaw(), 0F, 0F);
				Vector3f rotatedOffset = yawOnlyLooking.findLocalVectorGlobally(seatInfo.rotatedOffset);
				Vector3f.add(localPosition, new Vector3f(rotatedOffset.x, 0F, rotatedOffset.z), localPosition);
			}

			Vector3f relativePosition = pilotable.axes.findLocalVectorGlobally(localPosition);
			setPosition(pilotable.posX + relativePosition.x, pilotable.posY + relativePosition.y, pilotable.posZ + relativePosition.z);

			if (riddenByEntity != null)
			{
				Vec3 yOffset = pilotable.rotate(0, riddenByEntity.getYOffset(), 0).toVec3();

				playerPosX = posX + yOffset.xCoord;
				playerPosY = posY + yOffset.yCoord;
				playerPosZ = posZ + yOffset.zCoord;

				riddenByEntity.lastTickPosX = riddenByEntity.prevPosX = prevPlayerPosX;
				riddenByEntity.lastTickPosY = riddenByEntity.prevPosY = prevPlayerPosY;
				riddenByEntity.lastTickPosZ = riddenByEntity.prevPosZ = prevPlayerPosZ;
				riddenByEntity.setPosition(playerPosX, playerPosY, playerPosZ);

				//Calculate the local look axes globally
				RotatedAxes globalLookAxes = pilotable.axes.findLocalAxesGlobally(looking);
				//Set the player's rotation based on this
				playerYaw = -90F + globalLookAxes.getYaw();
				playerPitch = globalLookAxes.getRoll();

				Lumberjack.debug(playerPitch);

				double dYaw = MathHelper.wrapAngleTo180_float(playerYaw - prevPlayerYaw);

				if (riddenByEntity instanceof EntityPlayer)
				{
					riddenByEntity.prevRotationYaw = prevPlayerYaw;
					riddenByEntity.prevRotationPitch = prevPlayerPitch;

					riddenByEntity.rotationYaw = playerYaw;
					riddenByEntity.rotationPitch = playerPitch;
				}

				//If the entity is a player, roll its view accordingly
				if (worldObj.isRemote)
				{
					prevPlayerRoll = playerRoll;
					playerRoll = -globalLookAxes.getRoll();
				}
			}
		}
	}

	@Override
	public void updateRiderPosition()
	{
		if (riddenByEntity instanceof EntityPlayer)
		{
			riddenByEntity.rotationYaw = playerYaw;
			riddenByEntity.rotationPitch = playerPitch;
			riddenByEntity.prevRotationYaw = prevPlayerYaw;
			riddenByEntity.prevRotationPitch = prevPlayerPitch;
		}
		riddenByEntity.lastTickPosX = riddenByEntity.prevPosX = prevPlayerPosX;
		riddenByEntity.lastTickPosY = riddenByEntity.prevPosY = prevPlayerPosY;
		riddenByEntity.lastTickPosZ = riddenByEntity.prevPosZ = prevPlayerPosZ;
	}

	@SideOnly(Side.CLIENT)
	public EntityLivingBase getCamera()
	{
		return pilotable.getCamera();
	}

	@Override
	public boolean canBeCollidedWith()
	{
		return !isDead;
	}

	@Override
	protected void entityInit()
	{
	}

	@Override
	public float getShadowSize()
	{
		return 4.0F;
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tags)
	{
		//Do not read. Spawn with drivable
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tags)
	{
		//Do not write. Spawn with drivable
	}

	@Override
	public boolean writeToNBTOptional(NBTTagCompound tags)
	{
		return false;
	}

	@Override
	public boolean writeMountToNBT(NBTTagCompound tags)
	{
		return false;
	}

	@Override
	public boolean interactFirst(EntityPlayer entityplayer) //interact : change back when Forge updates
	{
		if (isDead)
			return false;

		if (worldObj.isRemote)
			return false;

		//Put them in the seat
		if (riddenByEntity == null)
		{
			entityplayer.mountEntity(this);
			return true;
		}

		return false;
	}

	public Entity getControllingEntity()
	{
		return riddenByEntity;
	}

	public boolean isDead()
	{
		return isDead;
	}

	@Override
	public void setDead()
	{
		super.setDead();
	}

	@Override
	public ItemStack getPickedResult(MovingObjectPosition target)
	{
		if (worldObj.isRemote && !foundPilotable)
			return null;
		return pilotable.getPickedResult(target);
	}

	public float getPlayerRoll()
	{
		playerRoll = MathHelper.wrapAngleTo180_float(playerRoll);
		return playerRoll;
	}

	public float getCameraDistance()
	{
		return foundPilotable && seatID == 0 ? pilotable.cameraDistance : 5F;
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float f)
	{
		return !(worldObj.isRemote && !foundPilotable) && pilotable.attackEntityFrom(source, f);
	}

	@Override
	public void writeSpawnData(ByteBuf data)
	{
		data.writeInt(pilotableID);
		data.writeInt(seatInfo.id);
	}

	@Override
	public void readSpawnData(ByteBuf data)
	{
		pilotableID = data.readInt();
		pilotable = (Pilotable)worldObj.getEntityByID(pilotableID);
		seatID = data.readInt();
		driver = seatID == 0;
		if (pilotable != null)
		{
			seatInfo = pilotable.getSeatData(seatID);
			looking.setAngles((seatInfo.minYaw + seatInfo.maxYaw) / 2, 0F, 0F);
			playerPosX = prevPlayerPosX = posX = pilotable.posX;
			playerPosY = prevPlayerPosY = posY = pilotable.posY;
			playerPosZ = prevPlayerPosZ = posZ = pilotable.posZ;
			setPosition(posX, posY, posZ);
		}

	}
}
