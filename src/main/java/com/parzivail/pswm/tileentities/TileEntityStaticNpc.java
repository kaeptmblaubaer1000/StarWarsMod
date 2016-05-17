package com.parzivail.pswm.tileentities;

import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.mobs.trooper.MobDefaultBiped;
import com.parzivail.pswm.quest.QuestNpcUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityStaticNpc extends TileEntity
{
	AxisAlignedBB bb;
	MobDefaultBiped internalBiped;

	boolean locked = false;
	int facing = 0;

	String id = "";

	public TileEntityStaticNpc()
	{
		this.setId(QuestNpcUtils.makeNpcId("welcome0", "rebel", "defaultSkin"));
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public int getFacing()
	{
		return facing;
	}

	public void setFacing(int facing)
	{
		this.facing = facing;
	}

	public boolean getLocked()
	{
		return locked;
	}

	public void setLocked(boolean locked)
	{
		this.locked = locked;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public double getMaxRenderDistanceSquared()
	{
		return 262144;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox()
	{
		if (this.bb == null)
			this.bb = AxisAlignedBB.getBoundingBox(this.xCoord + 0.1f, this.yCoord, this.zCoord + 0.1f, this.xCoord + 0.9f, this.yCoord + 1.8f, this.zCoord + 0.9f);
		return this.bb;
	}

	@Override
	public void updateEntity()
	{
		getInternalEntity().ticksExisted++;
		EntityPlayer e = getClosestPlayer();
		if (e != null)
			getInternalEntity().getLookHelper().setLookPosition(e.posX, e.posY, e.posZ, 0, 0);
		super.updateEntity();
	}

	public EntityPlayer getClosestPlayer()
	{
		return this.worldObj.getClosestPlayer(this.xCoord, this.yCoord, this.zCoord, 10);
	}

	public float getAngleToClosestPlayer()
	{
		EntityPlayer e = getClosestPlayer();
		if (e == null)
			return 0;
		return (float)Math.toDegrees(Math.atan2(e.posX - 0.5f - (float)this.xCoord, e.posZ - 0.5f - (float)this.zCoord));
	}

	@Override
	public void readFromNBT(NBTTagCompound p_145839_1_)
	{
		super.readFromNBT(p_145839_1_);
		this.setId(p_145839_1_.getString("quest-id"));
		this.setFacing(p_145839_1_.getInteger("facing"));
		this.setLocked(p_145839_1_.getBoolean("locked"));
	}

	@Override
	public void writeToNBT(NBTTagCompound p_145841_1_)
	{
		p_145841_1_.setString("quest-id", getId());
		p_145841_1_.setInteger("facing", getFacing());
		p_145841_1_.setBoolean("locked", getLocked());
		super.writeToNBT(p_145841_1_);
	}

	public MobDefaultBiped getInternalEntity()
	{
		if (internalBiped == null)
		{
			internalBiped = new MobDefaultBiped(this.worldObj);

			internalBiped.setCurrentItemOrArmor(4, new ItemStack(StarWarsItems.snowtrooperHelmet, 1));
			internalBiped.setCurrentItemOrArmor(3, new ItemStack(StarWarsItems.snowtrooperChest, 1));
			internalBiped.setCurrentItemOrArmor(2, new ItemStack(StarWarsItems.snowtrooperLegs, 1));
			internalBiped.setCurrentItemOrArmor(1, new ItemStack(StarWarsItems.snowtrooperBoots, 1));
			internalBiped.setCurrentItemOrArmor(0, StarWarsItems.blasterRifle.getMeta("Stormtrooper"));
		}
		return internalBiped;
	}
}