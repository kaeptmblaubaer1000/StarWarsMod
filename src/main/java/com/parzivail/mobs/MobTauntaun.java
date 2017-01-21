package com.parzivail.mobs;

import com.parzivail.ai.AiFreqMove;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class MobTauntaun extends AbstractHorse
{
	private int field_110285_bP = 0;

	public MobTauntaun(World par1World)
	{
		super(par1World);
		setSize(1.0F, 3.0F);
		tasks.addTask(0, new AiFreqMove(this, 1.25f, 0));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1D);
	}

	@Override
	public boolean canMateWith(EntityAnimal p_70878_1_)
	{
		return false;
	}

	// TODO
	//	@Override
	//	protected void func_145780_a(int x, int y, int z, Block blockIn)
	//	{
	//		Block.SoundType soundtype = blockIn.stepSound;
	//		if (worldObj.getBlock(x, y + 1, z) == Blocks.snow_layer)
	//			soundtype = Blocks.snow_layer.stepSound;
	//		if (!blockIn.getMaterial().isLiquid())
	//		{
	//			int l = getHorseType();
	//			if (riddenByEntity != null && l != 1 && l != 2)
	//			{
	//				field_110285_bP += 1;
	//				if (field_110285_bP > 5 && field_110285_bP % 3 == 0)
	//					playSound(Resources.MODID + ":" + "mob.tauntaun.move", soundtype.getVolume() * 0.15F, soundtype.getPitch());
	//				else if (field_110285_bP <= 5)
	//					playSound(Resources.MODID + ":" + "mob.tauntaun.move", soundtype.getVolume() * 0.15F, soundtype.getPitch());
	//			}
	//			else if (soundtype == Block.soundTypeWood)
	//				playSound(Resources.MODID + ":" + "mob.tauntaun.move", soundtype.getVolume() * 0.15F, soundtype.getPitch());
	//			else
	//				playSound(Resources.MODID + ":" + "mob.tauntaun.move", soundtype.getVolume() * 0.15F, soundtype.getPitch());
	//		}
	//	}

	// TODO
	//	@Override
	//	protected String getAngrySoundName()
	//	{
	//		return Resources.MODID + ":" + "mob.tauntaun.hit";
	//	}

	//	@Override
	//	protected String getDeathSound()
	//	{
	//		return Resources.MODID + ":" + "mob.tauntaun.die";
	//	}

	//	@Override
	//	protected String getHurtSound()
	//	{
	//		return Resources.MODID + ":" + "mob.tauntaun.hit";
	//	}
	//
	//	@Override
	//	protected String getLivingSound()
	//	{
	//		return Resources.MODID + ":" + "mob.tauntaun.say";
	//	}

	@Override
	public boolean getCanSpawnHere()
	{
		return isValidLightLevel() && rand.nextInt(20) == 0;
	}


	@Override
	public String getName()
	{
		return "Tauntaun";
	}

	@Override
	public int getMaxSpawnedInChunk()
	{
		return 1;
	}

	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand)
	{
		ItemStack itemstack = player.inventory.getCurrentItem();
		if (itemstack.getItem() == Items.SPAWN_EGG)
			return false;
		if (!isTame())
		{
			setHorseTamed(true);
			playLivingSound();
			if (player.world.isRemote)
				spawnHorseParticles(true);
		}
		if (isTame())
			this.mountTo(player);
		return super.processInteract(player, hand);
	}

	protected boolean isValidLightLevel()
	{
		return true;
	}

	@Override
	public void updatePassenger(Entity passenger)
	{
		passenger.setPosition(posX, posY + getMountedYOffset() + passenger.getYOffset() - 0.6f, posZ);
	}
}
