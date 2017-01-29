package com.parzivail.util.basic;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldNameable;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Created by colby on 12/18/2016.
 */
public class PBlockTE extends PBlock implements ITileEntityProvider
{
	public PBlockTE(String name, Material material)
	{
		super(name, material);
		this.isBlockContainer = true;
	}

	protected boolean isInvalidNeighbor(World worldIn, BlockPos pos, EnumFacing facing)
	{
		return worldIn.getBlockState(pos.offset(facing)).getMaterial() == Material.CACTUS;
	}

	protected boolean hasInvalidNeighbor(World worldIn, BlockPos pos)
	{
		return this.isInvalidNeighbor(worldIn, pos, EnumFacing.NORTH) || this.isInvalidNeighbor(worldIn, pos, EnumFacing.SOUTH) || this.isInvalidNeighbor(worldIn, pos, EnumFacing.WEST) || this.isInvalidNeighbor(worldIn, pos, EnumFacing.EAST);
	}

	/**
	 * Used to determine ambient occlusion and culling when rebuilding chunks for render
	 */
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}

	public boolean isFullCube(IBlockState state)
	{
		return false;
	}

	/**
	 * The type of render function called. MODEL for mixed tesr and static model, MODELBLOCK_ANIMATED for TESR-only,
	 * LIQUID for vanilla liquids, INVISIBLE to skip all rendering
	 */
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
	}

	/**
	 * Called serverside after this block is replaced with another in Chunk, but before the Tile Entity is updated
	 */
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		super.breakBlock(worldIn, pos, state);
		worldIn.removeTileEntity(pos);
	}

	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack)
	{
		if (te instanceof IWorldNameable && ((IWorldNameable)te).hasCustomName())
		{
			player.addStat(StatList.getBlockStats(this));
			player.addExhaustion(0.005F);

			if (worldIn.isRemote)
			{
				return;
			}

			int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, stack);
			Item item = this.getItemDropped(state, worldIn.rand, i);

			if (item == Items.AIR)
			{
				return;
			}

			ItemStack itemstack = new ItemStack(item, this.quantityDropped(worldIn.rand));
			itemstack.setStackDisplayName(((IWorldNameable)te).getName());
			spawnAsEntity(worldIn, pos, itemstack);
		}
		else
		{
			super.harvestBlock(worldIn, player, pos, state, null, stack);
		}
	}

	/**
	 * Called on both Client and Server when World#addBlockEvent is called. On the Server, this may perform additional
	 * changes to the world, like pistons replacing the block with an extended base. On the client, the update may
	 * involve replacing tile entities, playing sounds, or performing other visual actions to reflect the server side
	 * changes.
	 */
	public boolean eventReceived(IBlockState state, World worldIn, BlockPos pos, int id, int param)
	{
		super.eventReceived(state, worldIn, pos, id, param);
		TileEntity tileentity = worldIn.getTileEntity(pos);
		return tileentity != null && tileentity.receiveClientEvent(id, param);
	}

	@Nullable
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return null;
	}
}