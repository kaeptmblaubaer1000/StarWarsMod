package com.parzivail.util.driven;

import com.parzivail.pswm.PSWM;
import com.parzivail.pswm.handler.KeyHandler;
import com.parzivail.pswm.handler.NetworkHandler;
import com.parzivail.pswm.network.MessageDrivableControl;
import com.parzivail.util.lwjgl.Vector3f;
import com.parzivail.util.math.RotatedAxes;
import com.parzivail.util.ui.GFX;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class Pilotable extends Entity implements IEntityAdditionalSpawnData
{
	public ShipData data;
	public float throttle;

	public float prevRotationRoll;
	public double serverYaw, serverPitch, serverRoll;
	public RotatedAxes prevAxes;
	public RotatedAxes axes;

	public Vector3f angularVelocity = new Vector3f(0F, 0F, 0F);

	@SideOnly(Side.CLIENT)
	public EntityCamera camera;

	public double serverPosX, serverPosY, serverPosZ;
	public int serverPositionTransitionTicker;
	public float dYaw;
	public float prevDYaw;

	public Pilotable(World world)
	{
		super(world);
		data = createShipInfo();
		axes = new RotatedAxes();
		prevAxes = new RotatedAxes();
		preventEntitySpawning = true;
		setSize(2F, 2F);
		//yOffset = 6F / 16F;
		ignoreFrustumCheck = true;
		setRenderDistanceWeight(200);
		setupShipData();
	}

	protected void setupShipData()
	{

	}

	private ShipData createShipInfo()
	{
		return new ShipData();
	}

	public Pilotable(World world, double x, double y, double z)
	{
		this(world);
		setPosition(x, y, z);
		prevPosX = x;
		prevPosY = y;
		prevPosZ = z;
	}

	@Override
	public boolean processInitialInteract(EntityPlayer player, EnumHand hand)
	{
		if (!this.world.isRemote && this.getPassengers().isEmpty())
		{
			player.startRiding(this);
			// TODO
			//StatTrack.addStat("ride-" + this.getCommandSenderName().replaceAll("\\W", ""));
			return true;
		}
		return false;
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tag)
	{
		tag.setFloat("RotationYaw", axes.getYaw());
		tag.setFloat("RotationPitch", axes.getPitch());
		tag.setFloat("RotationRoll", axes.getRoll());
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tag)
	{
		prevRotationYaw = tag.getFloat("RotationYaw");
		prevRotationPitch = tag.getFloat("RotationPitch");
		prevRotationRoll = tag.getFloat("RotationRoll");
		axes = new RotatedAxes(prevRotationYaw, prevRotationPitch, prevRotationRoll);
	}

	@Override
	public void writeSpawnData(ByteBuf data)
	{
		data.writeFloat(axes.getYaw());
		data.writeFloat(axes.getPitch());
		data.writeFloat(axes.getRoll());
	}

	@Override
	public void readSpawnData(ByteBuf data)
	{
		try
		{
			axes.setAngles(data.readFloat(), data.readFloat(), data.readFloat());
			prevRotationYaw = axes.getYaw();
			prevRotationPitch = axes.getPitch();
			prevRotationRoll = axes.getRoll();
		}
		catch (Exception e)
		{
			super.setDead();
			e.printStackTrace();
		}

		if (this.camera == null)
		{
			camera = new EntityCamera(world, this);
			world.spawnEntity(camera);
		}
	}

	@SideOnly(Side.CLIENT)
	public EntityLivingBase getCamera()
	{
		return camera;
	}

	@Override
	protected boolean canTriggerWalking()
	{
		return false;
	}

	@Override
	protected void entityInit()
	{
	}

	@Override
	public AxisAlignedBB getCollisionBox(Entity entity)
	{
		return null;
	}

	@Override
	public boolean canBePushed()
	{
		return false;
	}

	@Override
	public double getMountedYOffset()
	{
		return -0.3D;
	}

	@Override
	public void setDead()
	{
		super.setDead();

		if (world.isRemote)
			camera.setDead();
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)
	{
	}

	@Override
	public boolean canBeCollidedWith()
	{
		return !isDead;
	}

	@Override
	public void applyEntityCollision(Entity entity)
	{
		if (!isPartOfThis(entity))
			super.applyEntityCollision(entity);
	}

	public void setPositionRotationAndMotion(double x, double y, double z, float yaw, float pitch, float roll, double motX, double motY, double motZ, float velYaw, float velPitch, float velRoll, float throt, float steeringYaw)
	{
		if (world.isRemote)
		{
			serverPosX = x;
			serverPosY = y;
			serverPosZ = z;
			serverYaw = yaw;
			serverPitch = pitch;
			serverRoll = roll;
			serverPositionTransitionTicker = 5;
		}

		//setPosition(x, y, z);
		prevRotationYaw = yaw;
		prevRotationPitch = pitch;
		prevRotationRoll = roll;
		setRotation(yaw, pitch, roll);

		//Set the motions regardless of side.
		motionX = motX;
		motionY = motY;
		motionZ = motZ;
		angularVelocity = new Vector3f(velYaw, velPitch, velRoll);
		throttle = throt;
	}

	@Override
	public void setVelocity(double d, double d1, double d2)
	{
		motionX = d;
		motionY = d1;
		motionZ = d2;
	}

	public Vector3f getInWorldPositionOf(Vector3f modelCoordinate)
	{
		Vector3f localPosition = new Vector3f(modelCoordinate.x / 8f, modelCoordinate.y / 8f, modelCoordinate.z / 8f);
		Vector3f relativePosition = axes.findLocalVectorGlobally(localPosition);
		return new Vector3f(posX + relativePosition.x, posY + relativePosition.y, posZ + relativePosition.z);
	}

	public Vector3f getLookVec3f()
	{
		return axes.getXAxis();
	}

	@Override
	public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
	{
		// TODO
		//StarWarsMod.network.sendToServer(new MessageDamageShip(this, p_70097_1_, p_70097_2_));
		return true;
	}

	public void processDamage(String damageType, float amount)
	{
		if (amount > data.shieldHealth)
		{
			data.shipHealth -= amount - data.shieldHealth;
			data.shieldHealth = 0;
		}
		else
			data.shipHealth -= amount;

		// TODO: StarWarsMod.network.sendToDimension(new MessageShipData(this), dimension);
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		this.ticksExisted++;

		prevRotationYaw = axes.getYaw();
		prevRotationPitch = axes.getPitch();
		prevRotationRoll = axes.getRoll();
		prevAxes = axes.clone();
		prevDYaw = dYaw;

		if (getInternalControllingPassenger() == null && world.isRemote)
		{
			this.throttle = 0;
			NetworkHandler.INSTANCE.sendToServer(new MessageDrivableControl(this));
		}

		//Work out if this is the client side and the entity is driving
		boolean thePlayerIsDrivingThis = getInternalControllingPassenger() instanceof EntityPlayer && PSWM.proxy.isThePlayer((EntityPlayer)this.getPassengers().get(0));

		//Player is not driving this. Update its position from server update packets
		if (world.isRemote && !thePlayerIsDrivingThis)
		{
			//The drivable is currently moving towards its server position. Continue doing so.
			if (serverPositionTransitionTicker > 0)
			{
				double x = posX + (serverPosX - posX) / serverPositionTransitionTicker;
				double y = posY + (serverPosY - posY) / serverPositionTransitionTicker;
				double z = posZ + (serverPosZ - posZ) / serverPositionTransitionTicker;
				double dYaw = MathHelper.wrapDegrees(serverYaw - axes.getYaw());
				double dPitch = MathHelper.wrapDegrees(serverPitch - axes.getPitch());
				double dRoll = MathHelper.wrapDegrees(serverRoll - axes.getRoll());
				rotationYaw = (float)(axes.getYaw() + dYaw / serverPositionTransitionTicker);
				rotationPitch = (float)(axes.getPitch() + dPitch / serverPositionTransitionTicker);
				float rotationRoll = (float)(axes.getRoll() + dRoll / serverPositionTransitionTicker);
				--serverPositionTransitionTicker;
				setPosition(x, y, z);
				setRotation(rotationYaw, rotationPitch, rotationRoll);
			}
		}

		this.angularVelocity.scale(data.angularDragCoefficient);
		if (Math.abs(this.angularVelocity.x) < 0.01f)
			this.angularVelocity.x = 0;
		if (Math.abs(this.angularVelocity.z) < 0.01f)
			this.angularVelocity.z = 0;

		//Calculate movement on the client and then send position, rotation etc to the server
		if (thePlayerIsDrivingThis)
			KeyHandler.handleVehicleMovement();

		int ht = this.world.getHeight((int)this.posX, (int)this.posZ) - 1;

		if (this.world.getBlockState(new BlockPos((int)this.posX, ht, (int)this.posZ)).getBlock() == Blocks.WATER && this.world.isRemote && getControllingPassenger() != null)
		{
			for (int i = 0; i < 70; i++)
			{
				double motionX = PSWM.rngGeneral.nextGaussian() * 0.03D;
				//double motionY = 0.03 * this.move;
				double motionY = 0.03;
				motionY *= Math.max(1, 10 - (this.posY - ht));
				double motionZ = PSWM.rngGeneral.nextGaussian() * 0.03D;

				float sXa = MathHelper.cos((float)Math.toRadians(this.axes.getYaw())) * 7;
				float sZa = MathHelper.sin((float)Math.toRadians(this.axes.getYaw())) * 7;

				float sXb = MathHelper.cos((float)Math.toRadians(this.axes.getYaw() + 180)) * 7;
				float sZb = MathHelper.sin((float)Math.toRadians(this.axes.getYaw() + 180)) * 7;

				float width = 1f;

				EnumParticleTypes n = EnumParticleTypes.WATER_WAKE;
				EnumParticleTypes n2 = EnumParticleTypes.EXPLOSION_NORMAL;

				this.world.spawnParticle(n, this.posX + sXa + PSWM.rngGeneral.nextFloat() * width * 2.0F - width, ht + PSWM.rngGeneral.nextFloat() * 0.2f, this.posZ + sZa + PSWM.rngGeneral.nextFloat() * width * 2.0F - width, motionX, motionY, motionZ);
				this.world.spawnParticle(n, this.posX + sXb + PSWM.rngGeneral.nextFloat() * width * 2.0F - width, ht + PSWM.rngGeneral.nextFloat() * 0.2f, this.posZ + sZb + PSWM.rngGeneral.nextFloat() * width * 2.0F - width, motionX, motionY, motionZ);

				if (i % 5 == 0)
				{
					this.world.spawnParticle(n2, this.posX + sXa + PSWM.rngGeneral.nextFloat() * width * 2.0F - width, ht + PSWM.rngGeneral.nextFloat() * 0.2f, this.posZ + sZa + PSWM.rngGeneral.nextFloat() * width * 2.0F - width, motionX, motionY, motionZ);
					this.world.spawnParticle(n2, this.posX + sXb + PSWM.rngGeneral.nextFloat() * width * 2.0F - width, ht + PSWM.rngGeneral.nextFloat() * 0.2f, this.posZ + sZb + PSWM.rngGeneral.nextFloat() * width * 2.0F - width, motionX, motionY, motionZ);
				}

			}
		}

		this.rotateRoll(this.angularVelocity.z);
		this.rotatePitch(this.angularVelocity.x);
		this.rotateYaw(this.angularVelocity.y);

		this.rotationYaw = axes.getYaw() - 90;
		this.rotationPitch = axes.getPitch();
		this.dYaw = MathHelper.wrapDegrees(axes.getYaw() - prevAxes.getYaw());

		calculateMotion();
		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);

		if (thePlayerIsDrivingThis)
		{
			serverPosX = posX;
			serverPosY = posY;
			serverPosZ = posZ;
			serverYaw = axes.getYaw();
			NetworkHandler.INSTANCE.sendToServer(new MessageDrivableControl(this));
		}
	}

	@Override
	public void fall(float distance, float damageMultiplier)
	{
	}

	/**
	 * Takes a vector (such as the origin of a seat / gun) and translates it from local coordinates to global coordinates
	 */
	public Vector3f rotate(Vector3f inVec)
	{
		return axes.findLocalVectorGlobally(inVec);
	}

	/**
	 * Takes a vector (such as the origin of a seat / gun) and translates it from local coordinates to global coordinates
	 */
	public Vector3f rotate(Vec3d inVec)
	{
		return rotate(inVec.xCoord, inVec.yCoord, inVec.zCoord);
	}

	/**
	 * Takes a vector (such as the origin of a seat / gun) and translates it from local coordinates to global coordinates
	 */
	public Vector3f rotate(double x, double y, double z)
	{
		return rotate(new Vector3f((float)x, (float)y, (float)z));
	}

	//Rotate the plane locally by some angle about the yaw axis
	public void rotateYaw(float rotateBy)
	{
		if (Math.abs(rotateBy) < 0.01F)
			return;
		axes.rotateLocalYaw(rotateBy);
		updatePrevAngles();
	}

	//Rotate the plane locally by some angle about the pitch axis
	public void rotatePitch(float rotateBy)
	{
		if (Math.abs(rotateBy) < 0.01F)
			return;
		axes.rotateLocalPitch(rotateBy);
		updatePrevAngles();
	}

	//Rotate the plane locally by some angle about the roll axis
	public void rotateRoll(float rotateBy)
	{
		if (Math.abs(rotateBy) < 0.01F)
			return;
		axes.rotateLocalRoll(rotateBy);
		updatePrevAngles();
	}

	public void updatePrevAngles()
	{
		//Correct angles that crossed the +/- 180 line, so that rendering doesnt make them swing 360 degrees in one tick.
		double dYaw = axes.getYaw() - prevRotationYaw;
		if (dYaw > 180)
			prevRotationYaw += 360F;
		if (dYaw < -180)
			prevRotationYaw -= 360F;

		double dPitch = axes.getPitch() - prevRotationPitch;
		if (dPitch > 180)
			prevRotationPitch += 360F;
		if (dPitch < -180)
			prevRotationPitch -= 360F;

		double dRoll = axes.getRoll() - prevRotationRoll;
		if (dRoll > 180)
			prevRotationRoll += 360F;
		if (dRoll < -180)
			prevRotationRoll -= 360F;
	}

	public void setRotation(float rotYaw, float rotPitch, float rotRoll)
	{
		axes.setAngles(rotYaw, rotPitch, rotRoll);
	}

	//Used to stop self collision
	public boolean isPartOfThis(Entity ent)
	{
		return ent == this || this.getPassengers().contains(ent);
	}

	@Override
	public Entity getControllingPassenger()
	{
		return getInternalControllingPassenger();
	}

	public Entity getInternalControllingPassenger()
	{
		if (this.getPassengers().isEmpty())
			return null;
		return this.getPassengers().get(0);
	}

	public boolean isControlling(EntityPlayer thePlayer)
	{
		return getInternalControllingPassenger() != null && thePlayer != null && getInternalControllingPassenger().getEntityId() == thePlayer.getEntityId();
	}

	public void acceptInput(ShipInput input)
	{
		if (this.getInternalControllingPassenger() == null)
			return;

		switch (input)
		{
			case RollLeft:
				this.angularVelocity.z += 2;
				break;
			case RollRight:
				this.angularVelocity.z -= 2;
				break;
			case PitchDown:
				this.angularVelocity.x += 1;
				break;
			case PitchUp:
				this.angularVelocity.x -= 1;
				break;
			case BankLeft:
				this.angularVelocity.y -= 1;
				break;
			case BankRight:
				this.angularVelocity.y += 1;
				break;
			case ThrottleUp:
				this.throttle += this.data.maxThrottle * this.data.throttleStep;
				this.throttle = MathHelper.clamp(this.throttle, 0, this.data.maxThrottle);
				break;
			case ThrottleDown:
				this.throttle -= this.data.maxThrottle * this.data.throttleStep;
				this.throttle = MathHelper.clamp(this.throttle, 0, this.data.maxThrottle);
				break;
			case BlasterFire:
				break;
			case SFoil:
				this.getDataManager().set(PilotableSFoils.S_FOILS_OPEN, !this.getDataManager().get(PilotableSFoils.S_FOILS_OPEN));
				break;
			case SpecialWeapon:
				break;
		}
	}

	public void keyTyped(char eventCharacter, int eventKey, boolean eventKeyState)
	{
		if (this.getControllingPassenger() == null)
			return;

		if (eventKey == PSWM.mc.gameSettings.keyBindSneak.getKeyCode() && getControllingPassenger() != null)
		{
			getControllingPassenger().dismountRidingEntity();
			// TODO: PSWM.network.sendToServer(new MessageSetMount(this.riddenByEntity, null));
			GFX.changeCameraRoll(0);
			PSWM.mc.displayGuiScreen(null);
		}
		else if (eventKey == 1)
		{
			PSWM.mc.displayGuiScreen(null);
			PSWM.mc.displayInGameMenu();
		}
		else if (eventKey == 59)
		{
			PSWM.mc.gameSettings.hideGUI = !PSWM.mc.gameSettings.hideGUI;
		}
		else if (eventKey == 61)
		{
			PSWM.mc.gameSettings.showDebugInfo = !PSWM.mc.gameSettings.showDebugInfo;
		}
		else if (eventKey == 63)
		{
			PSWM.mc.gameSettings.thirdPersonView = (PSWM.mc.gameSettings.thirdPersonView + 1) % 2;
		}
		else if (eventKey == 66)
		{
			PSWM.mc.gameSettings.smoothCamera = !PSWM.mc.gameSettings.smoothCamera;
		}
		else if (eventKey == PSWM.mc.gameSettings.keyBindInventory.getKeyCode())
		{
			PSWM.mc.displayGuiScreen(new GuiInventory(PSWM.mc.player));
		}
		else if (eventKey == PSWM.mc.gameSettings.keyBindChat.getKeyCode())
		{
			PSWM.mc.displayGuiScreen(new GuiChat());
		}
		else if (eventKey == PSWM.mc.gameSettings.keyBindCommand.getKeyCode())
		{
			PSWM.mc.displayGuiScreen(new GuiChat("/"));
		}
	}

	protected void calculateMotion()
	{
		Vector3f forwards = (Vector3f)axes.getXAxis().normalise();

		// TODO: Apply gravity
		//		PlanetInformation info = PlanetInformation.getPlanet(this.worldObj.provider.dimensionId);
		//		float g = info == null ? 0.98f / 20f : info.getGravity();
		float g = 0.98f / 20f;

		motionY -= g;

		float amountOfLift = 2F * g * throttle;
		if (amountOfLift > g)
			amountOfLift = g;

		motionY += amountOfLift;

		//Add the corrected pos
		motionX += throttle * forwards.x;
		motionY += throttle * forwards.y;
		motionZ += throttle * forwards.z;

		// TODO: float drag = info == null ? 0.75f : info.getAtmosphericDrag();
		float drag = 0.75f;

		//Apply drag
		motionX *= drag;
		motionY *= drag;
		motionZ *= drag;
	}

	@Override
	public void updatePassenger(Entity passenger)
	{
		super.updatePassenger(passenger);
		applyYawToEntity(passenger);
	}

	protected void applyYawToEntity(Entity entityToUpdate)
	{
		float rYaw = this.axes.getYaw() - 90;
		entityToUpdate.setRenderYawOffset(rYaw);
		float f = MathHelper.wrapDegrees(entityToUpdate.rotationYaw - rYaw);
		float f1 = MathHelper.clamp(f, -105.0F, 105.0F);
		entityToUpdate.prevRotationYaw += f1 - f;
		entityToUpdate.rotationYaw += f1 - f;
		entityToUpdate.setRotationYawHead(entityToUpdate.rotationYaw);
	}
}
