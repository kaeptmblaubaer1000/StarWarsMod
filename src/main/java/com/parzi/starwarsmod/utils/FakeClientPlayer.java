package com.parzi.starwarsmod.utils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class FakeClientPlayer extends EntityLivingBase
{

	public FakeClientPlayer(World world)
	{
		super(world);// , "fakeClientPlayer");
	}

	@Override
	public ItemStack getHeldItem()
	{
		return null;
	}

	@Override
	public void setCurrentItemOrArmor(int i, ItemStack itemstack)
	{
	}

	@Override
	public ItemStack[] getLastActiveItems()
	{
		return null;
	}

	@Override
	protected void updateFallState(double par1, boolean par3)
	{
	}

	@Override
	public void onEntityUpdate()
	{
	}

	@Override
	protected void onDeathUpdate()
	{
	}

	@Override
	protected int decreaseAirSupply(int amount)
	{
		return 0;
	}

	@Override
	public void setRevengeTarget(EntityLivingBase entity)
	{
	}

	@Override
	public void setLastAttacker(Entity entity)
	{
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound)
	{
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound)
	{
	}

	@Override
	protected void updatePotionEffects()
	{
	}

	@Override
	public void clearActivePotions()
	{
	}

	@Override
	public boolean isPotionActive(int par1)
	{
		return false;
	}

	@Override
	public boolean isPotionActive(Potion potion)
	{
		return false;
	}

	@Override
	public PotionEffect getActivePotionEffect(Potion potion)
	{
		return null;
	}

	@Override
	public void addPotionEffect(PotionEffect potion)
	{
	}

	@Override
	public boolean isPotionApplicable(PotionEffect potion)
	{
		return false;
	}

	@Override
	public void removePotionEffectClient(int id)
	{
	}

	@Override
	public void removePotionEffect(int id)
	{
	}

	@Override
	protected void onNewPotionEffect(PotionEffect potion)
	{
	}

	@Override
	protected void onChangedPotionEffect(PotionEffect potion, boolean par2)
	{
	}

	@Override
	protected void onFinishedPotionEffect(PotionEffect potion)
	{
	}

	@Override
	public void heal(float amount)
	{
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		return false;
	}

	@Override
	public void renderBrokenItemStack(ItemStack stack)
	{
	}

	@Override
	public void onDeath(DamageSource source)
	{
	}

	@Override
	public void knockBack(Entity entity, float f, double x, double z)
	{
	}

	@Override
	public boolean isOnLadder()
	{
		return false;
	}

	@Override
	protected void fall(float distance)
	{
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void performHurtAnimation()
	{
	}

	@Override
	public int getTotalArmorValue()
	{
		return 0;
	}

	@Override
	protected float applyArmorCalculations(DamageSource source, float amount)
	{
		return 0.0F;
	}

	@Override
	protected float applyPotionDamageCalculations(DamageSource source, float amount)
	{
		return 0.0F;
	}

	@Override
	protected void damageEntity(DamageSource source, float amount)
	{
	}

	@Override
	public EntityLivingBase func_94060_bK()
	{
		return null;
	}

	@Override
	public void swingItem()
	{
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void handleHealthUpdate(byte par1)
	{
	}

	@Override
	protected void kill()
	{
	}

	@Override
	protected void updateArmSwingProgress()
	{
	}

	@Override
	public void setSprinting(boolean isSprinting)
	{
	}

	@Override
	protected float getSoundPitch()
	{
		return 1.0F;
	}

	@Override
	protected boolean isMovementBlocked()
	{
		return false;
	}

	@Override
	public void dismountEntity(Entity entity)
	{
	}

	@Override
	protected void jump()
	{
	}

	@Override
	public void moveEntityWithHeading(float strafe, float forward)
	{
	}

	@Override
	public float getAIMoveSpeed()
	{
		return 0.1F;
	}

	@Override
	public boolean attackEntityAsMob(Entity entity)
	{
		return false;
	}

	@Override
	public void onUpdate()
	{
	}

	@Override
	public void onLivingUpdate()
	{
	}

	@Override
	protected void updateAITasks()
	{
	}

	@Override
	protected void collideWithNearbyEntities()
	{
	}

	@Override
	protected void collideWithEntity(Entity entity)
	{
	}

	@Override
	public void updateRidden()
	{
	}

	@Override
	protected void updateAITick()
	{
	}

	@Override
	protected void updateEntityActionState()
	{
	}

	@Override
	public void setJumping(boolean isJumping)
	{
	}

	@Override
	public void onItemPickup(Entity item, int stackSize)
	{
	}

	// @Override
	// @SideOnly(Side.CLIENT)
	// public float getSwingProgress(float par1) { return 0.0F; }
	@Override
	public boolean canBeCollidedWith()
	{
		return false;
	}

	@Override
	public boolean canBePushed()
	{
		return false;
	}

	public float getEyeHeight()
	{
		return this.height * 0.85F;
	}

	@Override
	protected void setBeenAttacked()
	{
	}

	@Override
	public void setAbsorptionAmount(float amount)
	{
	}

	@Override
	public boolean isOnSameTeam(EntityLivingBase entity)
	{
		return false;
	}

	@Override
	public boolean isOnTeam(Team team)
	{
		return false;
	}

	@Override
	public void curePotionEffects(ItemStack curativeItem)
	{
	}
	/*
	 * @Override public void sendChatToPlayer(ChatMessageComponent
	 * chatmessagecomponent) {}
	 * 
	 * @Override public boolean canCommandSenderUseCommand(int i, String s) {
	 * return false; }
	 * 
	 * @Override public ChunkCoordinates getPlayerCoordinates() { return new
	 * ChunkCoordinates(MathHelper.floor_double(this.posX + 0.5D),
	 * MathHelper.floor_double(this.posY + 0.5D),
	 * MathHelper.floor_double(this.posZ + 0.5D)); }
	 */

	@Override
	public ItemStack getEquipmentInSlot(int p_71124_1_)
	{
		// TODO Auto-generated method stub
		return null;
	}
}