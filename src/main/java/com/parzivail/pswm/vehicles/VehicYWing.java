package com.parzivail.pswm.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.items.ItemSpawnAstromech;
import com.parzivail.pswm.items.ItemSpawnAstromech2;
import com.parzivail.pswm.network.MessageSetPlayerHolding;
import com.parzivail.pswm.network.MessageShipAstroDetails;
import com.parzivail.pswm.quest.QuestUtils;
import com.parzivail.util.math.MathUtils;
import com.parzivail.util.vehicle.VehicleAirBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class VehicYWing extends VehicleAirBase
{

	public VehicYWing(World par1World)
	{
		super(par1World);
		this.setSize(3.0F, 6.0F);
		this.vehicYOffset = -3F;
		this.moveModifier = 1.75F;
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
	}

	@Override
	public void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(24, 0);
		this.dataWatcher.setObjectWatched(24);
		this.dataWatcher.addObject(25, 0);
		this.dataWatcher.setObjectWatched(25);
	}

	public boolean getHasAstro()
	{
		return this.dataWatcher.getWatchableObjectInt(24) == 1;
	}

	public int getAstroType()
	{
		return this.dataWatcher.getWatchableObjectInt(25);
	}

	public void setHasAstro(boolean hasAstro)
	{
		this.dataWatcher.updateObject(24, hasAstro ? 1 : 0);
		this.dataWatcher.setObjectWatched(24);
	}

	/**
	 * 0 = r2, 1 = r5
	 *
	 * @param astroType
	 */
	public void setAstroType(int astroType)
	{
		this.dataWatcher.updateObject(25, astroType);
		this.dataWatcher.setObjectWatched(25);
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

	@Override
	public String getCommandSenderName()
	{
		if (this.hasCustomNameTag())
			return this.getCustomNameTag();
		return "BTL Y-Wing Starfighter";
	}

	@Override
	public boolean interact(EntityPlayer player)
	{
		if (!QuestUtils.canRideInShip(player, this.getClass()))
			return false;
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

		if (this.riddenByEntity != null && this.getHasAstro() && MathUtils.oneIn(300))
			this.worldObj.playSoundAtEntity(this.riddenByEntity, Resources.MODID + ":" + "mob.astromech.say", 1, 1);
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
}