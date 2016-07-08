package com.parzivail.pswm.mobs;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.ai.AiFollowEntity;
import com.parzivail.util.IParziNPC;
import com.parzivail.util.entity.trade.TradeUtils;
import com.parzivail.util.entity.trade.WeightedTradeItem;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class MobTatooineCommoner extends EntityVillager implements IParziNPC
{
	private EntityPlayer buyingPlayer;
	private MerchantRecipeList buyingList;
	private String[] types = { "weaponsDealer", "generalMerchant", "corellian", "bartender", "shipDealer" };
	private String[] officialNames = { "Weapons Dealer", "General Merchant", "Corellian", "Bartender", "Ship Dealer" };
	private float baseRarity = 1.0F;
	private DataWatcher dw;

	public MobTatooineCommoner(World p_i1748_1_)
	{
		super(p_i1748_1_);
		dw = super.getDataWatcher();
		this.tasks.addTask(0, new AiFollowEntity(this, null, 0.5f));
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	public EntityVillager createChild(EntityAgeable p_90011_1_)
	{
		return null;
	}

	public MerchantRecipeList createTradesByProfession(MerchantRecipeList list, int type)
	{
		List<WeightedTradeItem> trades = new ArrayList();
		MerchantRecipeList fn = new MerchantRecipeList();
		if (type == indexOf(types, "weaponsDealer"))
		{
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.silverImperialCredit, 10), StarWarsItems.blasterRifle.getMeta("A280"), baseRarity / 2.0F));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.silverImperialCredit, 8), StarWarsItems.blasterPistol.getMeta("Dl44"), baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.silverImperialCredit, 5), StarWarsItems.blasterPistol.getMeta("Dh17"), baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.silverImperialCredit, 10), StarWarsItems.blasterPistol.getMeta("Sporting"), baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.silverImperialCredit, 10), new ItemStack(StarWarsItems.gaffiStick, 1), baseRarity / 2.0F));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.silverImperialCredit, 10), new ItemStack(StarWarsItems.vibroLance, 1), baseRarity / 2.0F));
			for (int i = 0; i < rand.nextInt(3) + 3; i++)
			{
				WeightedTradeItem item;
				do
					item = TradeUtils.getWeightedItemFromList(trades, rand);
				while (isAlreadyTrading(item, fn));
				fn.add(new MerchantRecipe(item.cost, item.cost2, item.item));
			}
		}
		else if (type == indexOf(types, "generalMerchant"))
		{
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.goldImperialCredit, 1), new ItemStack(StarWarsItems.spawnLandspeeder, 1), baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.silverImperialCredit, 5), new ItemStack(StarWarsItems.spawnAstromech, 1), baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.silverImperialCredit, 5), new ItemStack(StarWarsItems.spawnAstromech2, 1), baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.silverImperialCredit, 2), new ItemStack(StarWarsItems.spawnMouse, 1), baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.silverImperialCredit, 5), new ItemStack(StarWarsItems.spawnGonk, 1), baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.silverImperialCredit, 5), new ItemStack(StarWarsItems.spawnProtocol, 1), baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.silverImperialCredit, 5), new ItemStack(StarWarsMod.blockMV, 1), baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.imperialCredit, 5), new ItemStack(StarWarsItems.banthaHorn, 1), baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.imperialCredit, 5), new ItemStack(StarWarsItems.banthaChop, 1), baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.silverImperialCredit, 2), new ItemStack(Items.saddle, 1), baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.silverImperialCredit, 5), new ItemStack(StarWarsItems.binoculars, 1), baseRarity));
			for (int i = 0; i < 8; i++)
			{
				WeightedTradeItem item;
				do
					item = TradeUtils.getWeightedItemFromList(trades, rand);
				while (isAlreadyTrading(item, fn));
				fn.add(new MerchantRecipe(item.cost, item.cost2, item.item));
			}
		}
		else if (type == indexOf(types, "corellian"))
		{
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.goldImperialCredit, 2), new ItemStack(StarWarsItems.hyperdriveEarth, 1), baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.goldImperialCredit, 2), new ItemStack(StarWarsItems.hyperdriveEndor, 1), baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.goldImperialCredit, 2), new ItemStack(StarWarsItems.hyperdriveHoth, 1), baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.goldImperialCredit, 2), new ItemStack(StarWarsItems.hyperdriveKashyyyk, 1), baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.goldImperialCredit, 2), new ItemStack(StarWarsItems.hyperdriveTatooine, 1), baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.goldImperialCredit, 2), new ItemStack(StarWarsItems.hyperdriveYavin4, 1), baseRarity));
			// trades.add(new WeightedTradeItem(new
			// ItemStack(StarWarsMod.goldImperialCredit, 2), new
			// ItemStack(StarWarsMod.hyperdriveDagobah, 1), this.baseRarity));
			for (int i = 0; i < 3; i++)
			{
				WeightedTradeItem item;
				do
					item = TradeUtils.getWeightedItemFromList(trades, rand);
				while (isAlreadyTrading(item, fn));
				fn.add(new MerchantRecipe(item.cost, item.cost2, item.item));
			}
		}
		else if (type == indexOf(types, "bartender"))
		{
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.silverImperialCredit, 2), new ItemStack(StarWarsItems.canron, 1), baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.silverImperialCredit, 5), new ItemStack(StarWarsItems.banthaPlatter, 1), baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.silverImperialCredit, 3), new ItemStack(StarWarsItems.dewbackRibs, 1), baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.silverImperialCredit, 1), new ItemStack(StarWarsItems.banthaChopCooked, 1), baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.silverImperialCredit, 1), new ItemStack(StarWarsItems.banthaMilk, 1), baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.silverImperialCredit, 5), new ItemStack(StarWarsItems.gorrnar, 1), baseRarity));
			for (int i = 0; i < 4; i++)
			{
				WeightedTradeItem item;
				do
					item = TradeUtils.getWeightedItemFromList(trades, rand);
				while (isAlreadyTrading(item, fn));
				fn.add(new MerchantRecipe(item.cost, item.cost2, item.item));
			}
		}
		else if (type == indexOf(types, "shipDealer"))
		{
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.goldImperialCredit, 4), new ItemStack(StarWarsItems.spawnTie, 1), baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.goldImperialCredit, 4), new ItemStack(StarWarsItems.spawnAwing, 1), baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.goldImperialCredit, 5), new ItemStack(StarWarsItems.spawnXwing, 1), baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsItems.goldImperialCredit, 5), new ItemStack(StarWarsItems.spawnTieInterceptor, 1), baseRarity));
			for (int i = 0; i < 4; i++)
			{
				WeightedTradeItem item;
				do
					item = TradeUtils.getWeightedItemFromList(trades, rand);
				while (isAlreadyTrading(item, fn));
				fn.add(new MerchantRecipe(item.cost, item.cost2, item.item));
			}
		}
		return fn;
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		getDataWatcher().addObject(25, Integer.valueOf(rand.nextInt(5)));
	}

	@Override
	public void func_110297_a_(ItemStack p_110297_1_)
	{
		if (!worldObj.isRemote && livingSoundTime > -getTalkInterval() + 20)
		{
			livingSoundTime = -getTalkInterval();

			if (p_110297_1_ != null)
				playSound(Resources.MODID + ":" + "mob.commoner.trade", getSoundVolume(), getSoundPitch());
			else
				playSound(Resources.MODID + ":" + "mob.commoner.notrade", getSoundVolume(), getSoundPitch());
		}
	}

	@Override
	public String getCommandSenderName()
	{
		return officialNames[getType()];
	}

	@Override
	public EntityPlayer getCustomer()
	{
		return buyingPlayer;
	}

	@Override
	public String getCustomNameTag()
	{
		return getCommandSenderName();
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
		return Resources.MODID + ":" + (isTrading() ? "mob.commoner.haggle" : "mob.commoner.say");
	}

	@Override
	public MerchantRecipeList getRecipes(EntityPlayer p_70934_1_)
	{
		if (buyingList == null)
		{
			buyingList = new MerchantRecipeList();
			buyingList = createTradesByProfession(buyingList, getType());
		}
		return buyingList;
	}

	@Override
	public int getTalkInterval()
	{
		return 400;
	}

	@Override
	public boolean interact(EntityPlayer entityPlayer)
	{
		if (entityPlayer.isSneaking())
		{

		}
		return super.interact(entityPlayer);
	}

	private int getType()
	{
		return getDataWatcher().getWatchableObjectInt(25);
	}

	private int indexOf(String[] haystack, String needle)
	{
		return java.util.Arrays.asList(haystack).indexOf(needle);
	}

	public boolean isAlreadyTrading(WeightedTradeItem item, MerchantRecipeList trades)
	{
		for (Object x : trades.toArray())
			if (((MerchantRecipe)x).getItemToSell() == item.item)
				return true;
		return false;
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound tagCompund)
	{
		super.readEntityFromNBT(tagCompund);
		if (tagCompund.hasKey("type"))
			setType(tagCompund.getInteger("type"));
	}

	@Override
	public void setCustomer(EntityPlayer p_70932_1_)
	{
		buyingPlayer = p_70932_1_;
	}

	private void setType(int t)
	{
		getDataWatcher().updateObject(25, Integer.valueOf(t));
	}

	@Override
	public void useRecipe(MerchantRecipe p_70933_1_)
	{
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound tagCompound)
	{
		super.writeEntityToNBT(tagCompound);
		tagCompound.setInteger("type", getType());
	}

	@Override
	public String getName()
	{
		return this.getCommandSenderName();
	}

	@Override
	public String getSpecies()
	{
		return Resources.speciesHuman;
	}

	@Override
	public String getAllegiance()
	{
		return Resources.allegianceNone;
	}

	@Override
	public String getJob()
	{
		return this.getCommandSenderName();
	}
}
