package com.parzivail.pswm.rendering.fx;

import com.parzivail.pswm.StarWarsItems;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

public class ParticleBlasterBolt extends EntityFX
{
	public ParticleBlasterBolt(World world, double x, double y, double z, double motionX, double motionY, double motionZ)
	{
		super(world, x, y, z, motionX, motionY, motionZ);
		this.motionX *= 0.30000001192092896D;
		this.motionY = (float)Math.random() * 0.2F + 0.1F;
		this.motionZ *= 0.30000001192092896D;
		this.particleRed = 1.0F;
		this.particleGreen = 1.0F;
		this.particleBlue = 1.0F;
		this.setParticleTextureIndex(19);
		this.setSize(0.01F, 0.01F);
		this.particleMaxAge = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
		this.particleGravity = 1.0F;
		this.particleScale = 1.0F;
		this.setRBGColorF(0xFF, 0x00, 0x00);

		this.particleIcon = StarWarsItems.blasterBolt.getIconFromDamage(0);
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void onUpdate()
	{
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		this.motionY -= this.particleGravity;
		try
		{
			this.moveEntity(this.motionX, this.motionY, this.motionZ);
		}
		catch (Exception e)
		{
			this.setDead();
		}
		this.motionX *= 0.9800000190734863D;
		this.motionY *= 0.9800000190734863D;
		this.motionZ *= 0.9800000190734863D;
		int i = 60 - this.particleMaxAge;
		float f = i * 0.001F;
		this.setSize(f, f);
		// this.setParticleTextureIndex(19 + i % 4);

		if (this.particleMaxAge-- <= 0)
			this.setDead();
	}
}