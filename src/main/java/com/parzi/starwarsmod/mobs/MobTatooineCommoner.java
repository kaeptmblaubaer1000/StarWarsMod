package com.parzi.starwarsmod.mobs;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.TradeUtils;
import com.parzi.starwarsmod.utils.WeightedTradeItem;

public class MobTatooineCommoner extends EntityVillager
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
		this.dw = super.getDataWatcher();
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
		if (type == this.indexOf(this.types, "weaponsDealer"))
		{
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.silverImperialCredit, 10), StarWarsMod.blasterRifle.getMeta("A280"), this.baseRarity / 2.0F));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.silverImperialCredit, 8), StarWarsMod.blasterPistol.getMeta("Dl44"), this.baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.silverImperialCredit, 5), StarWarsMod.blasterPistol.getMeta("Dh17"), this.baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.silverImperialCredit, 10), StarWarsMod.blasterPistol.getMeta("Sporting"), this.baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.silverImperialCredit, 10), new ItemStack(StarWarsMod.gaffiStick, 1), this.baseRarity / 2.0F));
			for (int i = 0; i < this.rand.nextInt(3) + 3; i++)
			{
				WeightedTradeItem item;
				do
					item = TradeUtils.getWeightedItemFromList(trades, this.rand);
				while (this.isAlreadyTrading(item, fn));
				fn.add(new MerchantRecipe(item.cost, item.cost2, item.item));
			}
		}
		else if (type == this.indexOf(this.types, "generalMerchant"))
		{
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.goldImperialCredit, 1), new ItemStack(StarWarsMod.spawnLandspeeder, 1), this.baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.silverImperialCredit, 5), new ItemStack(StarWarsMod.spawnAstromech, 1), this.baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.silverImperialCredit, 5), new ItemStack(StarWarsMod.spawnAstromech2, 1), this.baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.silverImperialCredit, 2), new ItemStack(StarWarsMod.spawnMouse, 1), this.baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.silverImperialCredit, 5), new ItemStack(StarWarsMod.spawnGonk, 1), this.baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.silverImperialCredit, 5), new ItemStack(StarWarsMod.spawnProtocol, 1), this.baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.silverImperialCredit, 5), new ItemStack(StarWarsMod.blockMV, 1), this.baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.imperialCredit, 5), new ItemStack(StarWarsMod.banthaHorn, 1), this.baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.imperialCredit, 5), new ItemStack(StarWarsMod.banthaChop, 1), this.baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.silverImperialCredit, 2), new ItemStack(Items.saddle, 1), this.baseRarity));
			for (int i = 0; i < 8; i++)
			{
				WeightedTradeItem item;
				do
					item = TradeUtils.getWeightedItemFromList(trades, this.rand);
				while (this.isAlreadyTrading(item, fn));
				fn.add(new MerchantRecipe(item.cost, item.cost2, item.item));
			}
		}
		else if (type == this.indexOf(this.types, "corellian"))
		{
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.goldImperialCredit, 2), new ItemStack(StarWarsMod.hyperdriveEarth, 1), this.baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.goldImperialCredit, 2), new ItemStack(StarWarsMod.hyperdriveEndor, 1), this.baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.goldImperialCredit, 2), new ItemStack(StarWarsMod.hyperdriveHoth, 1), this.baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.goldImperialCredit, 2), new ItemStack(StarWarsMod.hyperdriveKashyyyk, 1), this.baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.goldImperialCredit, 2), new ItemStack(StarWarsMod.hyperdriveTatooine, 1), this.baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.goldImperialCredit, 2), new ItemStack(StarWarsMod.hyperdriveYavin4, 1), this.baseRarity));
			// trades.add(new WeightedTradeItem(new
			// ItemStack(StarWarsMod.goldImperialCredit, 2), new
			// ItemStack(StarWarsMod.hyperdriveDagobah, 1), this.baseRarity));
			for (int i = 0; i < 3; i++)
			{
				WeightedTradeItem item;
				do
					item = TradeUtils.getWeightedItemFromList(trades, this.rand);
				while (this.isAlreadyTrading(item, fn));
				fn.add(new MerchantRecipe(item.cost, item.cost2, item.item));
			}
		}
		else if (type == this.indexOf(this.types, "bartender"))
		{
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.silverImperialCredit, 2), new ItemStack(StarWarsMod.canron, 1), this.baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.silverImperialCredit, 5), new ItemStack(StarWarsMod.banthaPlatter, 1), this.baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.silverImperialCredit, 3), new ItemStack(StarWarsMod.dewbackRibs, 1), this.baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.silverImperialCredit, 1), new ItemStack(StarWarsMod.banthaChopCooked, 1), this.baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.silverImperialCredit, 1), new ItemStack(StarWarsMod.banthaMilk, 1), this.baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.silverImperialCredit, 5), new ItemStack(StarWarsMod.gorrnar, 1), this.baseRarity));
			for (int i = 0; i < 4; i++)
			{
				WeightedTradeItem item;
				do
					item = TradeUtils.getWeightedItemFromList(trades, this.rand);
				while (this.isAlreadyTrading(item, fn));
				fn.add(new MerchantRecipe(item.cost, item.cost2, item.item));
			}
		}
		else if (type == this.indexOf(this.types, "shipDealer"))
		{
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.goldImperialCredit, 4), new ItemStack(StarWarsMod.spawnTie, 1), this.baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.goldImperialCredit, 4), new ItemStack(StarWarsMod.spawnAwing, 1), this.baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.goldImperialCredit, 5), new ItemStack(StarWarsMod.spawnXwing, 1), this.baseRarity));
			trades.add(new WeightedTradeItem(new ItemStack(StarWarsMod.goldImperialCredit, 5), new ItemStack(StarWarsMod.spawnTieInterceptor, 1), this.baseRarity));
			for (int i = 0; i < 4; i++)
			{
				WeightedTradeItem item;
				do
					item = TradeUtils.getWeightedItemFromList(trades, this.rand);
				while (this.isAlreadyTrading(item, fn));
				fn.add(new MerchantRecipe(item.cost, item.cost2, item.item));
			}
		}
		return fn;
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.getDataWatcher().addObject(25, Integer.valueOf(this.rand.nextInt(5)));
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

	private int getType()
	{
		return this.getDataWatcher().getWatchableObjectInt(25);
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
	public void setCustomer(EntityPlayer p_70932_1_)
	{
		this.buyingPlayer = p_70932_1_;
	}

	@Override
	public void useRecipe(MerchantRecipe p_70933_1_)
	{
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\mobs\MobTatooineCommoner.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */