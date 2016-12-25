package com.parzivail.pswm.blocks;

import com.parzivail.util.block.PBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

/**
 * Created by colby on 12/18/2016.
 */
public class BlockInfrastructure extends PBlock
{
	public static final PropertyEnum TYPE = PropertyEnum.create("type", EnumType.class);

	public BlockInfrastructure()
	{
		super("infrastructure", Material.IRON);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumType.INFRA_LIGHT));
	}

	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list)
	{
		for (EnumType t : EnumType.values())
			list.add(new ItemStack(itemIn, 1, t.getID()));
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, TYPE);
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return getDefaultState().withProperty(TYPE, EnumType.values()[meta]);
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		EnumType type = (EnumType)state.getValue(TYPE);
		return type.getID();
	}

	@Override
	public int damageDropped(IBlockState state)
	{
		return getMetaFromState(state);
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
	}

	public enum EnumType implements IStringSerializable
	{
		INFRA_BLACK(0, "infra_black"), INFRA_CAUTION(1, "infra_caution"), INFRA_CRATE(2, "infra_crate"), INFRA_DARKGRAY(3, "infra_darkgray"), INFRA_DARKGRAY_LIT(4, "infra_darkgray_lit"), INFRA_WHITE(5, "infra_white"), INFRA_FOREST(6, "infra_forest"), INFRA_FORESTINSET(7, "infra_forestinset"), INFRA_FORESTPANEL1(8, "infra_forestpanel1"), INFRA_FORESTPANEL2(9, "infra_forestpanel2"), INFRA_FORESTPANEL3(10, "infra_forestpanel3"), INFRA_FORESTVINE(11, "infra_forestvine"), INFRA_LIGHT(12, "infra_light"), INFRA_LIGHT_LIT(13, "infra_light_lit"), INFRA_LIGHTINSET(14, "infra_lightinset"), INFRA_PANEL1(15, "infra_panel1");

		private int ID;
		private String name;

		EnumType(int ID, String name)
		{
			this.ID = ID;
			this.name = name;
		}

		@Override
		public String getName()
		{
			return name;
		}

		public int getID()
		{
			return ID;
		}

		@Override
		public String toString()
		{
			return getName();
		}
	}
}
