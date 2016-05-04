package com.parzivail.pswm.tileentities;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.mobs.trooper.MobDefaultBiped;
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

	String id = "";

	public TileEntityStaticNpc()
	{
		this.setId("no-faction:no-quest:default-skin");
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
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
		this.setId(p_145839_1_.getString("quest-id"));
		super.readFromNBT(p_145839_1_);
	}

	@Override
	public void writeToNBT(NBTTagCompound p_145841_1_)
	{
		super.writeToNBT(p_145841_1_);
		p_145841_1_.setString("quest-id", getId());
	}

	public MobDefaultBiped getInternalEntity()
	{
		if (internalBiped == null)
		{
			internalBiped = new MobDefaultBiped(this.worldObj);

			internalBiped.setCurrentItemOrArmor(4, new ItemStack(StarWarsMod.snowtrooperHelmet, 1));
			internalBiped.setCurrentItemOrArmor(3, new ItemStack(StarWarsMod.snowtrooperChest, 1));
			internalBiped.setCurrentItemOrArmor(2, new ItemStack(StarWarsMod.snowtrooperLegs, 1));
			internalBiped.setCurrentItemOrArmor(1, new ItemStack(StarWarsMod.snowtrooperBoots, 1));
			internalBiped.setCurrentItemOrArmor(0, StarWarsMod.blasterRifle.getMeta("Stormtrooper"));
		}
		return internalBiped;
	}
}