package com.parzivail.pswm.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.network.MessageSFoil;
import com.parzivail.util.vehicle.VehicleAirBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class VehicXWing extends VehicleAirBase
{
	public static int SFOIL_DW = 13;
	public boolean isOpening = false;
	public boolean isClosing = false;

	public VehicXWing(World par1World)
	{
		super(par1World);
		this.setSize(3.0F, 6.0F);
		this.vehicYOffset = -3F;
		this.moveModifier = 1.75F;
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
	}

	@Override
	public void dropFewItems(boolean par1, int par2)
	{
		this.dropItem(StarWarsItems.spawnXwing, 1);
	}

	@Override
	public void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(SFOIL_DW, Float.valueOf(0));
		this.dataWatcher.setObjectWatched(SFOIL_DW);
	}

	@Override
	public String getCommandSenderName()
	{
		if (this.hasCustomNameTag())
			return this.getCustomNameTag();
		return "T-65B X-Wing Starfighter";
	}

	@Override
	public String getDeathSound()
	{
		return Resources.MODID + ":" + "vehicle.xwing.die";
	}

	@Override
	public String getMovingSound()
	{
		return "vehicle.xwing.move";
	}

	public float getSFoil()
	{
		return this.dataWatcher.getWatchableObjectFloat(SFOIL_DW);
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if (this.isOpening)
		{
			this.setSFoil(this.getSFoil() + 1 / 30f);
			this.isOpening = this.getSFoil() < 0.8f;
		}

		if (this.isClosing)
		{
			this.setSFoil(this.getSFoil() - 1 / 30f);
			this.isClosing = this.getSFoil() > 0;
		}

		if ((this.isOpening || this.isClosing) && this.riddenByEntity instanceof EntityPlayer)
			StarWarsMod.network.sendToServer(new MessageSFoil((EntityPlayer)this.riddenByEntity, this.getSFoil()));

		int ht = this.worldObj.getHeightValue((int)this.posX, (int)this.posZ) - 1;

		if (this.worldObj.getBlock((int)this.posX, ht, (int)this.posZ) == Blocks.water && this.worldObj.isRemote && this.riddenByEntity instanceof EntityPlayer)
		{
			for (int i = 0; i < 70; i++)
			{
				double motionX = StarWarsMod.rngGeneral.nextGaussian() * 0.03D;
				double motionY = 0.03 * this.move;
				motionY *= Math.max(1, 10 - (this.posY - ht));
				double motionZ = StarWarsMod.rngGeneral.nextGaussian() * 0.03D;

				float sXa = MathHelper.cos((float)Math.toRadians(this.rotationYaw)) * 7;
				float sZa = MathHelper.sin((float)Math.toRadians(this.rotationYaw)) * 7;

				float sXb = MathHelper.cos((float)Math.toRadians(this.rotationYaw + 180)) * 7;
				float sZb = MathHelper.sin((float)Math.toRadians(this.rotationYaw + 180)) * 7;

				float width = 1f;

				String n = "wake";
				String n2 = "explode";

				this.worldObj.spawnParticle(n, this.posX + sXa + StarWarsMod.rngGeneral.nextFloat() * width * 2.0F - width, ht + StarWarsMod.rngGeneral.nextFloat() * 0.2f, this.posZ + sZa + StarWarsMod.rngGeneral.nextFloat() * width * 2.0F - width, motionX, motionY, motionZ);
				this.worldObj.spawnParticle(n, this.posX + sXb + StarWarsMod.rngGeneral.nextFloat() * width * 2.0F - width, ht + StarWarsMod.rngGeneral.nextFloat() * 0.2f, this.posZ + sZb + StarWarsMod.rngGeneral.nextFloat() * width * 2.0F - width, motionX, motionY, motionZ);

				if (i % 5 == 0)
				{
					this.worldObj.spawnParticle(n2, this.posX + sXa + StarWarsMod.rngGeneral.nextFloat() * width * 2.0F - width, ht + StarWarsMod.rngGeneral.nextFloat() * 0.2f, this.posZ + sZa + StarWarsMod.rngGeneral.nextFloat() * width * 2.0F - width, motionX, motionY, motionZ);
					this.worldObj.spawnParticle(n2, this.posX + sXb + StarWarsMod.rngGeneral.nextFloat() * width * 2.0F - width, ht + StarWarsMod.rngGeneral.nextFloat() * 0.2f, this.posZ + sZb + StarWarsMod.rngGeneral.nextFloat() * width * 2.0F - width, motionX, motionY, motionZ);
				}

			}
		}
	}

	public void setSFoil(float f)
	{
		this.dataWatcher.updateObject(SFOIL_DW, f);
	}
}
