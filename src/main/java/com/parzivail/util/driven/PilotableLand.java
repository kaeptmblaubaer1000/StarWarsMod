package com.parzivail.util.driven;

import com.parzivail.util.lwjgl.Vector3f;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public abstract class PilotableLand extends Pilotable
{
	public PilotableLand(World world)
	{
		super(world);
	}

	public PilotableLand(World world, double x, double y, double z)
	{
		super(world, x, y, z);
	}

	@Override
	public void acceptInput(ShipInput input)
	{
		if (this.getInternalControllingPassenger() == null)
			return;

		switch (input)
		{
			case RollLeft:
				this.angularVelocity.y -= 1;
				break;
			case RollRight:
				this.angularVelocity.y += 1;
				break;
			case PitchDown:
				break;
			case PitchUp:
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
				break;
			case SpecialWeapon:
				break;
		}
	}

	@Override
	protected void calculateMotion()
	{
		Vector3f forwards = (Vector3f)axes.getXAxis().normalise();

		// TODO: Apply gravity
		//		PlanetInformation info = PlanetInformation.getPlanet(this.worldObj.provider.dimensionId);
		//		float g = info == null ? 0.98f / 20f : info.getGravity();
		float g = 0.98f / 20f;

		motionY -= g;

		//float amountOfLift = 2F * g * throttle;
		//if (amountOfLift > g)
		//	amountOfLift = g;

		//motionY += amountOfLift;

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
	protected void setupShipData()
	{
		this.data.cameraDistance = 1;
		this.data.throttleStep = 0.1f;
		this.data.maxThrottle = 0.3f;
		this.stepHeight = 2;
	}

	@Override
	public double getMountedYOffset()
	{
		return 0.5f;
	}

	public float getCameraY()
	{
		return 2;
	}
}
