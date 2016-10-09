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
	public boolean foundParent;
	private int parentId;
	private int seatID;
	public Pilotable parent;

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
		parent = d;
		parentId = d.getEntityId();
		seatInfo = parent.getSeatData(id);
		driver = id == 0;
		setPosition(d.posX, d.posY, d.posZ);
		playerPosX = prevPlayerPosX = posX;
		playerPosY = prevPlayerPosY = posY;
		playerPosZ = prevPlayerPosZ = posZ;
		looking.setAngles((seatInfo.minYaw + seatInfo.maxYaw) / 2, 0F, 0F);
		//updatePosition();
	}

	@Override
	public void setPositionAndRotation2(double x, double y, double z, float yaw, float pitch, int i)
	{
		//setPosition(x, y, z);
	}

	private void getKeyInput()
	{
		if (!(this.getControllingEntity() instanceof EntityPlayer))
			return;

		if ($(StarWarsMod.mc.gameSettings.keyBindLeft))
		{
			this.parent.angularVelocity.z += 4;
		}
		if ($(StarWarsMod.mc.gameSettings.keyBindRight))
		{
			this.parent.angularVelocity.z -= 4;
		}
		if ($(StarWarsMod.mc.gameSettings.keyBindForward))
		{
			this.parent.angularVelocity.x -= 2;
		}
		if ($(StarWarsMod.mc.gameSettings.keyBindBack))
		{
			this.parent.angularVelocity.x += 2;
		}
		if ($(StarWarsMod.mc.gameSettings.keyBindJump))
		{
			this.parent.throttle += this.parent.maxThrottle / 10f;
			this.parent.throttle = MathHelper.clamp_float(this.parent.throttle, 0, this.parent.maxThrottle);
		}
		if ($(StarWarsMod.mc.gameSettings.keyBindSneak))
		{
			this.parent.throttle -= this.parent.maxThrottle / 10f;
			this.parent.throttle = MathHelper.clamp_float(this.parent.throttle, 0, this.parent.maxThrottle);
		}
	}

	private boolean $(KeyBinding key)
	{
		return key.getIsKeyPressed() && this.getControllingEntity() instanceof EntityPlayer && StarWarsMod.proxy.isThePlayer((EntityPlayer)this.getControllingEntity());
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		//If on the client and the drivable parent has yet to be found, search for it
		if (worldObj.isRemote && !foundParent)
		{
			parent = (Pilotable)worldObj.getEntityByID(parentId);
			if (parent == null)
				return;
			foundParent = true;
			parent.seats[seatID] = this;
			seatInfo = parent.getSeatData(seatID);
			looking.setAngles((seatInfo.minYaw + seatInfo.maxYaw) / 2, 0F, 0F);
			playerPosX = prevPlayerPosX = posX = parent.posX;
			playerPosY = prevPlayerPosY = posY = parent.posY;
			playerPosZ = prevPlayerPosZ = posZ = parent.posZ;
			setPosition(posX, posY, posZ);

			StarWarsMod.mc.thePlayer.mountEntity(this);

			Lumberjack.debug("[Seat] Searching for parent...");
		}

		getKeyInput();

		this.parent.angularVelocity.scale(Pilotable.ANGULAR_DRAG);
		if (Math.abs(this.parent.angularVelocity.x) < 0.01f)
			this.parent.angularVelocity.x = 0;
		if (Math.abs(this.parent.angularVelocity.z) < 0.01f)
			this.parent.angularVelocity.z = 0;

		this.parent.rotateRoll(this.parent.angularVelocity.z);
		this.parent.rotatePitch(this.parent.angularVelocity.x);
	}

	/**
	 * Set the position to be that of the drivable plus the local position, rotated
	 */
	public void updatePosition()
	{
		//If we haven't found our drivable, give up
		if (worldObj.isRemote && !foundParent)
			return;

		prevPlayerPosX = playerPosX;
		prevPlayerPosY = playerPosY;
		prevPlayerPosZ = playerPosZ;

		prevPlayerYaw = playerYaw;
		prevPlayerPitch = playerPitch;

		//Get the position of this seat on the drivable axes
		Vector3f localPosition = new Vector3f(seatInfo.x / 16F, seatInfo.y / 16F, seatInfo.z / 16F);

		if (parent != null)
		{
			//Rotate the offset vector by the turret yaw
			if (parent.seats != null && parent.seats[0] != null && parent.seats[0].looking != null)
			{
				RotatedAxes yawOnlyLooking = new RotatedAxes(parent.seats[0].looking.getYaw(), 0F, 0F);
				Vector3f rotatedOffset = yawOnlyLooking.findLocalVectorGlobally(seatInfo.rotatedOffset);
				Vector3f.add(localPosition, new Vector3f(rotatedOffset.x, 0F, rotatedOffset.z), localPosition);
			}

			Vector3f relativePosition = parent.axes.findLocalVectorGlobally(localPosition);
			setPosition(parent.posX + relativePosition.x, parent.posY + relativePosition.y, parent.posZ + relativePosition.z);
		}

		if (riddenByEntity != null)
		{
			Vec3 yOffset = parent.rotate(0, riddenByEntity.getYOffset(), 0).toVec3();

			playerPosX = posX + yOffset.xCoord;
			playerPosY = posY + yOffset.yCoord;
			playerPosZ = posZ + yOffset.zCoord;

			riddenByEntity.lastTickPosX = riddenByEntity.prevPosX = prevPlayerPosX;
			riddenByEntity.lastTickPosY = riddenByEntity.prevPosY = prevPlayerPosY;
			riddenByEntity.lastTickPosZ = riddenByEntity.prevPosZ = prevPlayerPosZ;
			riddenByEntity.setPosition(playerPosX, playerPosY, playerPosZ);

			//Calculate the local look axes globally
			RotatedAxes globalLookAxes = parent.axes.findLocalAxesGlobally(looking);
			//Set the player's rotation based on this
			playerYaw = -90F + globalLookAxes.getYaw();
			playerPitch = globalLookAxes.getRoll();

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
		riddenByEntity.posX = playerPosX;
		riddenByEntity.posY = playerPosY;
		riddenByEntity.posZ = playerPosZ;
	}

	@SideOnly(Side.CLIENT)
	public EntityLivingBase getCamera()
	{
		return parent.getCamera();
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
	public ItemStack getPickedResult(MovingObjectPosition target)
	{
		if (worldObj.isRemote && !foundParent)
			return null;
		return parent.getPickedResult(target);
	}

	public float getPlayerRoll()
	{
		playerRoll = MathHelper.wrapAngleTo180_float(playerRoll);
		return playerRoll;
	}

	public float getCameraDistance()
	{
		return foundParent && seatID == 0 ? parent.cameraDistance : 5F;
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float f)
	{
		return !(worldObj.isRemote && !foundParent) && parent.attackEntityFrom(source, f);
	}

	@Override
	public void writeSpawnData(ByteBuf data)
	{
		data.writeInt(parentId);
		data.writeInt(seatInfo.id);
	}

	@Override
	public void readSpawnData(ByteBuf data)
	{
		parentId = data.readInt();
		parent = (Pilotable)worldObj.getEntityByID(parentId);
		seatID = data.readInt();
		driver = seatID == 0;
		if (parent != null)
		{
			seatInfo = parent.getSeatData(seatID);
			looking.setAngles((seatInfo.minYaw + seatInfo.maxYaw) / 2, 0F, 0F);
			playerPosX = prevPlayerPosX = posX = parent.posX;
			playerPosY = prevPlayerPosY = posY = parent.posY;
			playerPosZ = prevPlayerPosZ = posZ = parent.posZ;
			setPosition(posX, posY, posZ);
		}

	}
}
