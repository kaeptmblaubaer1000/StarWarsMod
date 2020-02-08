package com.parzivail.pswm.turrets;

import com.parzivail.pswm.ai.AiTurretAttack;
import com.parzivail.pswm.entities.EntityBlasterProbeBolt;
import com.parzivail.pswm.mobs.IShootThings;
import com.parzivail.pswm.vehicles.VehicXWing;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import static com.parzivail.pswm.Resources.MODID;

public abstract class TurretBase extends EntityCreature implements IMob, IShootThings
{
	private AiTurretAttack turretAttack;

	public TurretBase(World world)
	{
		super(world);
		setSize(5.0f, 5.0f);
		tasks.addTask(0, turretAttack = new AiTurretAttack(this, 0.0D, 20, 60, 15.0F));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, VehicXWing.class, 0, true));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0D);
		getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(100.0D);
	}

	public void rangeAttack(EntityLivingBase p_82196_1_, float p_82196_2_)
	{
		playSound(MODID + ":" + "item.blasterRifle.use", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(rand, -0.2D, 0.2D));
		worldObj.spawnEntityInWorld(new EntityBlasterProbeBolt(worldObj, this, p_82196_1_));
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
	}

	@Override
	public String getCommandSenderName()
	{
		return "Turret";
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	protected boolean canDespawn()
	{
		return false;
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		getDataWatcher().addObject(25, rand.nextInt(2));
	}

	@Override
	protected String getDeathSound()
	{
		return null;
	}

	@Override
	protected String getHurtSound()
	{
		// TODO add sound effect
		return null;
	}
}
