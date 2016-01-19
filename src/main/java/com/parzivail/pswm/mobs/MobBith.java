package com.parzivail.pswm.mobs;

import java.util.ArrayList;
import java.util.Arrays;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.entity.trade.WeightedTradeItem;

import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class MobBith extends EntityVillager
{
	private EntityPlayer buyingPlayer;
	private MerchantRecipeList buyingList;
	private String[] types = { "bith" };
	private String[] officialNames = { "Bith" };
	private float baseRarity = 1.0F;
	private DataWatcher dw;
	private int bithsNear = 0;

	// public boolean playing = false;

	public MobBith(World p_i1748_1_)
	{
		super(p_i1748_1_);
		this.dw = super.getDataWatcher();
	}

	@Override
	public EntityVillager createChild(EntityAgeable p_90011_1_)
	{
		return null;
	}

	public MerchantRecipeList createTradesByProfession(MerchantRecipeList list, int type)
	{
		new ArrayList();
		MerchantRecipeList fn = new MerchantRecipeList();
		fn.add(new MerchantRecipe(new ItemStack(StarWarsMod.goldImperialCredit, 10), new ItemStack(StarWarsMod.recordCantina, 1)));
		return fn;
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.getDataWatcher().addObject(25, Integer.valueOf(0));
		this.getDataWatcher().addObject(26, Integer.valueOf(0));
	}

	@Override
	public void func_110297_a_(ItemStack p_110297_1_)
	{
		if (!this.worldObj.isRemote && this.livingSoundTime > -this.getTalkInterval() + 20)
		{
			this.livingSoundTime = -this.getTalkInterval();

			if (p_110297_1_ != null)
				this.playSound(Resources.MODID + ":" + "mob.bith.trade", this.getSoundVolume(), this.getSoundPitch());
			else
				this.playSound(Resources.MODID + ":" + "mob.bith.notrade", this.getSoundVolume(), this.getSoundPitch());
		}
	}

	@Override
	public String getCommandSenderName()
	{
		return this.officialNames[this.getType()];
	}

	@Override
	public EntityPlayer getCustomer()
	{
		return this.buyingPlayer;
	}

	@Override
	public String getCustomNameTag()
	{
		return this.getCommandSenderName();
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound()
	{
		return Resources.MODID + ":" + "mob.commoner.die";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected String getHurtSound()
	{
		return Resources.MODID + ":" + "mob.commoner.hit";
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	@Override
	protected String getLivingSound()
	{
		return Resources.MODID + ":" + "mob.bith.say";
	}

	public boolean getPlaying()
	{
		return this.dw.getWatchableObjectInt(26) == 1;
	}

	@Override
	public MerchantRecipeList getRecipes(EntityPlayer p_70934_1_)
	{
		if (this.buyingList == null)
		{
			this.buyingList = new MerchantRecipeList();
			this.buyingList = this.createTradesByProfession(this.buyingList, this.getType());
		}
		return this.buyingList;
	}

	@Override
	public int getTalkInterval()
	{
		return 400;
	}

	private int getType()
	{
		return this.getDataWatcher().getWatchableObjectInt(25);
	}

	private int indexOf(String[] haystack, String needle)
	{
		return Arrays.asList(haystack).indexOf(needle);
	}

	public boolean isAlreadyTrading(WeightedTradeItem item, MerchantRecipeList trades)
	{
		for (Object x : trades.toArray())
			if (((MerchantRecipe)x).getItemToSell() == item.item)
				return true;
		return false;
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		/*
		 * bithsNear = 0; boolean shouldPlay = true;
		 *
		 * for (Object oEntity :
		 * this.worldObj.getEntitiesWithinAABB(this.getClass(),
		 * this.boundingBox.expand(8, 8, 8))) if (oEntity instanceof MobBith) {
		 * bithsNear++; shouldPlay = !((MobBith)oEntity).getPlaying() &&
		 * shouldPlay; }
		 *
		 * if (bithsNear >= 5) if (!this.getPlaying() && shouldPlay)
		 *
		 * { this.playSound(StarWarsMod.MODID + ":" + "item.records.Cantina", 1,
		 * 1); this.setPlaying(true); } else if (this.getPlaying() &&
		 * !shouldPlay)
		 *
		 * { Minecraft.getMinecraft().getSoundHandler().stopSound(song);
		 * this.setPlaying(false); }
		 */

	}

	@Override
	public void setCustomer(EntityPlayer p_70932_1_)
	{
		this.buyingPlayer = p_70932_1_;
	}

	@Override
	public void setPlaying(boolean b)
	{
		this.dw.updateObject(26, Integer.valueOf(b ? 1 : 0));
	}

	@Override
	public void useRecipe(MerchantRecipe p_70933_1_)
	{
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\mobs\MobBith.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */