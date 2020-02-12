package com.parzivail.pswm.items.weapons;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.achievement.StarWarsAchievements;
import com.parzivail.pswm.entities.EntityBlasterBoltPlayer;
import com.parzivail.pswm.utils.BlasterUtils;
import com.parzivail.util.entity.EntityUtils;
import com.parzivail.util.math.RaytraceHit;
import com.parzivail.util.math.RaytraceHitEntity;
import com.parzivail.util.math.RotatedAxes;
import com.parzivail.util.ui.KeyboardUtils;
import com.parzivail.util.ui.LangUtils;
import com.parzivail.util.ui.TextUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.List;

public class ItemWookieeBowcaster extends Item
{
	public String name = "bowcaster";

	private int timeSinceLastShot = 0;

	private int timeToRecharge = 6;

	public ItemWookieeBowcaster()
	{
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.maxStackSize = 1;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		if (KeyboardUtils.isShiftDown())
		{
			list.add(TextUtils.makeItalic(LangUtils.translate("blaster.rifle1")));
			list.add(TextUtils.makeItalic(LangUtils.translate("blaster.rifle2")));
			list.add(TextUtils.makeItalic(LangUtils.translate("blaster.rifle3")));
		}
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("shotsLeft"))
			list.add("Shots Remaining: " + stack.stackTagCompound.getInteger("shotsLeft"));
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		return "item.starwarsmod." + this.name;
	}

	@Override
	public boolean hasEffect(ItemStack stack, int pass)
	{
		return BlasterUtils.getCooldown(stack) >= 15;
	}

	@Override
	public boolean isFull3D()
	{
		return true;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (BlasterUtils.getCooldown(stack) < 15)
			if (stack.stackTagCompound.getInteger("shotsLeft") > 0)
			{
				player.playSound(Resources.MODID + ":" + "item.blasterBow.use", 1.0F, 1.0F);

				if (!world.isRemote && BlasterUtils.getCooldown(stack) < 15)
					{
						if (!world.isRemote)
						{
						//			float spread = getSpreadAmount(stack, player);
							RotatedAxes ra = new RotatedAxes(270 - player.rotationYaw, -player.rotationPitch, 0);

							float hS = (world.rand.nextFloat() * 2 - 1) * 2;
							float vS = (world.rand.nextFloat() * 2 - 1) * 2;

							float hSR = 1 - 5;
							float vSR = 1 - 5;

							ra.rotateGlobalYaw(hS * hSR);
							ra.rotateGlobalPitch(vS * vSR);

							Vec3 look = Vec3.createVectorHelper(Math.cos(ra.getPitch() / 180f * Math.PI) * Math.cos(ra.getYaw() / 180f * Math.PI), Math.sin(ra.getPitch() / 180f * Math.PI), Math.cos(ra.getPitch() / 180f * Math.PI) * Math.sin(-ra.getYaw() / 180f * Math.PI));
							RaytraceHit hit = EntityUtils.rayTrace(look, 100, player, new Entity[0], true);

						//			Sfx.play(player, Resources.modColon("swg.fx." + name), 1 + (float)world.rand.nextGaussian() / 10, 1 - 5);

//							Entity e = new EntityBlasterBoltTest(world, (float)look.xCoord, (float)look.yCoord, (float)look.zCoord, 10, 0xFF0000, 5.0f)

							Entity e = new EntityBlasterBoltPlayer(world, (float)look.xCoord, (float)look.yCoord, (float)look.zCoord, 10, 0xFF0000, 5.0f);
							e.setPosition(player.posX, player.posY + player.getEyeHeight(), player.posZ);
							world.spawnEntityInWorld(e);

							if (hit instanceof RaytraceHitEntity && ((RaytraceHitEntity)hit).entity instanceof EntityLiving)
							{
								EntityLiving entity = (EntityLiving)((RaytraceHitEntity)hit).entity;
								entity.attackEntityFrom(DamageSource.causePlayerDamage(player), 10);
							}

							BlasterUtils.setCooldown(stack, BlasterUtils.getCooldown(stack) + 1);
							BlasterUtils.setTicksSinceLastShot(stack, 0);

							stack.stackTagCompound.setInteger("shotsLeft", stack.stackTagCompound.getInteger("shotsLeft") - 1);
							}
						player.addStat(StarWarsAchievements.fireBlaster, 1);
						}
					}
					else if (!BlasterUtils.refillShots(stack, world, player))
						player.playSound(Resources.MODID + ":" + "item.blasterRifle.break", 1.0F, 1.0F);

			return stack;


			//			if (hit instanceof RaytraceHitBlock)
			//			{
			//				RaytraceHitBlock block = (RaytraceHitBlock)hit;
			//				for (int i = 0; i < 10; i++)
			//					StarWarsMod.proxy.spawnParticle(world, "smoke", block.hitVec.xCoord + (world.rand.nextDouble() * 0.2 - 0.1), block.hitVec.yCoord + (world.rand.nextDouble() * 0.2 - 0.1), block.hitVec.zCoord + (world.rand.nextDouble() * 0.2 - 0.1), 0, world.rand.nextDouble() * 0.2, 0);
			//				StarWarsMod.proxy.createDecal(world, Decal.BULLET_IMPACT, block.blockX, block.blockY, block.blockZ, (float)block.hitVec.xCoord, (float)block.hitVec.yCoord, (float)block.hitVec.zCoord, 1, block.sideHitFace);
			//			}
		//			bd.shotTimer += descriptor.autofireTimeTicks;
		//			bd.heat += 10;
		//			if (bd.heat >= 10 * descriptor.roundsBeforeOverheat)
		//			{
		//				bd.heat = 0;
		//				bd.cooldownTimer = descriptor.cooldownTimeTicks;
		//			}
		//
		//			bd.serialize(stack.stackTagCompound);
	}

		@Override
		public void onUpdate(ItemStack stack, World world, Entity entityIn, int p_77663_4_, boolean p_77663_5_)
		{
			if (!world.isRemote)
			{
				if (!stack.hasTagCompound())
					stack.stackTagCompound = new NBTTagCompound();

				if (!stack.stackTagCompound.hasKey("shotsLeft"))
					BlasterUtils.refillShots(stack, world, entityIn);

				if (BlasterUtils.getTicksSinceLastShot(stack) <= 40 * ((BlasterUtils.getCooldown(stack) + 1) / 15f))
					BlasterUtils.setTicksSinceLastShot(stack, BlasterUtils.getTicksSinceLastShot(stack) + 1);

				if (BlasterUtils.getTicksSinceLastShot(stack) > 40 * ((BlasterUtils.getCooldown(stack) + 1) / 15f))
				{
					BlasterUtils.setTicksSinceLastShot(stack, 0);
					BlasterUtils.setCooldown(stack, 0);
				}
			}
		}
}