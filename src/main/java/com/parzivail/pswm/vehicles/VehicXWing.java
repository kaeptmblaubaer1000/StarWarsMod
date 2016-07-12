package com.parzivail.pswm.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.items.ItemSpawnAstromech;
import com.parzivail.pswm.items.ItemSpawnAstromech2;
import com.parzivail.pswm.network.MessageSFoil;
import com.parzivail.pswm.network.MessageSetPlayerHolding;
import com.parzivail.pswm.network.MessageShipAstroDetails;
import com.parzivail.util.IDebugProvider;
import com.parzivail.util.math.MathUtils;
import com.parzivail.util.ui.LangUtils;
import com.parzivail.util.vehicle.VehicleAirBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

public class VehicXWing extends VehicleAirBase implements IDebugProvider
{
	private static int SFOIL_DW = 23;
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
	public List<String> getDebugText(List<String> list, EntityPlayer player, World world, int x, int y, int z)
	{
		list.add(String.format(LangUtils.translate("has.astro.s"), getHasAstro()));
		list.add(String.format(LangUtils.translate("astro.type.s"), getAstroType()));
		return list;
	}

	@Override
	public void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(SFOIL_DW, 0f);
		this.dataWatcher.setObjectWatched(SFOIL_DW);
		this.dataWatcher.addObject(SFOIL_DW + 1, 0);
		this.dataWatcher.setObjectWatched(SFOIL_DW + 1);
		this.dataWatcher.addObject(SFOIL_DW + 2, 0);
		this.dataWatcher.setObjectWatched(SFOIL_DW + 2);
	}

	@Override
	public String getCommandSenderName()
	{
		if (this.hasCustomNameTag())
			return this.getCustomNameTag();
		return LangUtils.translate("t.65b.x.wing.starfighter");
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

	public boolean getHasAstro()
	{
		return this.dataWatcher.getWatchableObjectInt(SFOIL_DW + 1) == 1;
	}

	public int getAstroType()
	{
		return this.dataWatcher.getWatchableObjectInt(SFOIL_DW + 2);
	}

	@Override
	public boolean interact(EntityPlayer player)
	{
		ItemStack itemstack = player.inventory.getCurrentItem();

		if (player.isSneaking())
		{
			if (getHasAstro())
			{
				if (worldObj.isRemote)
				{
					StarWarsMod.network.sendToServer(new MessageShipAstroDetails(this, player, false, 0));
					StarWarsMod.network.sendToServer(new MessageSetPlayerHolding(player, new ItemStack(getAstroType() == 0 ? StarWarsItems.spawnAstromech : StarWarsItems.spawnAstromech2), true));
					setHasAstro(false);
				}
			}
			else if (itemstack != null)
			{
				if (itemstack.getItem() instanceof ItemSpawnAstromech)
				{
					StarWarsMod.network.sendToServer(new MessageShipAstroDetails(this, player, true, 0));
					setHasAstro(true);
					setAstroType(0);
				}
				else if (itemstack.getItem() instanceof ItemSpawnAstromech2)
				{
					StarWarsMod.network.sendToServer(new MessageShipAstroDetails(this, player, true, 1));
					setHasAstro(true);
					setAstroType(1);
				}
			}
			else
			{
				if (!worldObj.isRemote)
					player.openGui(StarWarsMod.instance, Resources.GUI_HYPERDRIVE, this.worldObj, 0, 0, 0);
			}
			return true;
		}

		return super.interact(player);
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

		if (this.riddenByEntity != null && this.getHasAstro() && MathUtils.oneIn(300))
			this.worldObj.playSoundAtEntity(this.riddenByEntity, Resources.MODID + ":" + "mob.astromech.say", 1, 1);

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
		this.dataWatcher.setObjectWatched(SFOIL_DW);
	}

	public void setHasAstro(boolean hasAstro)
	{
		this.dataWatcher.updateObject(SFOIL_DW + 1, hasAstro ? 1 : 0);
		this.dataWatcher.setObjectWatched(SFOIL_DW + 1);
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		compound.setBoolean("hasAstro", getHasAstro());
		compound.setInteger("astroType", getAstroType());
		super.writeToNBT(compound);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		setHasAstro(compound.getBoolean("hasAstro"));
		setAstroType(compound.getInteger("astroType"));
		super.readFromNBT(compound);
	}

	/**
	 * 0 = r2, 1 = r5
	 *
	 * @param astroType
	 */
	public void setAstroType(int astroType)
	{
		this.dataWatcher.updateObject(SFOIL_DW + 2, astroType);
		this.dataWatcher.setObjectWatched(SFOIL_DW + 2);
	}
}
