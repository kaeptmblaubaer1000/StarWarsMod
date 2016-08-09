package com.parzivail.pswm.blocks;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.items.weapons.ItemBlasterHeavy;
import com.parzivail.pswm.items.weapons.ItemBlasterRifle;
import com.parzivail.pswm.tileentities.TileEntityGunRack;
import com.parzivail.util.IDebugProvider;
import com.parzivail.util.block.PBlockContainer;
import com.parzivail.util.block.TileEntityRotate;
import com.parzivail.util.ui.LangUtils;
import com.parzivail.util.world.HarvestLevel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

public class BlockGunRack extends PBlockContainer implements IDebugProvider
{
	public BlockGunRack()
	{
		super("gunRack", Material.iron);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		setHardness(50.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntityGunRack();
	}

	@Override
	public int getRenderType()
	{
		return -1;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public List<String> getDebugText(List<String> list, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile instanceof TileEntityGunRack)
		{
			TileEntityGunRack t = (TileEntityGunRack)tile;
			list.add(LangUtils.translate("facing.0", t.getFacing()));
			for (ItemStack s : t.getGuns())
				list.add(String.valueOf(s));
		}

		return list;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int wut)
	{
		TileEntityGunRack rack = (TileEntityGunRack)world.getTileEntity(x, y, z);
		if (rack != null)
		{
			for (ItemStack gun : rack.getGuns())
			{
				if (gun != null)
				{
					EntityItem entityitem = new EntityItem(world, x, y, z, gun);
					if (gun.hasTagCompound())
						entityitem.getEntityItem().setTagCompound((NBTTagCompound)gun.getTagCompound().copy());
					world.spawnEntityInWorld(entityitem);
				}
			}
			world.func_147453_f(x, y, z, block);
		}
		super.breakBlock(world, x, y, z, block, wut);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float sX, float sY, float sZ)
	{
		if (!world.isRemote)
		{
			if (player.getHeldItem() == null)
			{
				TileEntityGunRack gunRack = (TileEntityGunRack)world.getTileEntity(x, y, z);
				ItemStack itemStack = gunRack.popGun();
				player.inventory.mainInventory[player.inventory.currentItem] = itemStack;
			}
			else if (player.getHeldItem().getItem() instanceof ItemBlasterRifle || player.getHeldItem().getItem() instanceof ItemBlasterHeavy)
			{
				if (!(player.getHeldItem().getItemDamage() == 2 && player.getHeldItem().getItem() instanceof ItemBlasterRifle))
				{
					TileEntityGunRack gunRack = (TileEntityGunRack)world.getTileEntity(x, y, z);
					if (gunRack.pushGun(player.getHeldItem()))
						player.inventory.mainInventory[player.inventory.currentItem] = null;
				}
			}
		}
		world.markBlockForUpdate(x, y, z);
		return true;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
	{
		if (p_149719_1_.getTileEntity(p_149719_2_, p_149719_3_, p_149719_4_) instanceof TileEntityRotate)
		{
			int meta = ((TileEntityRotate)p_149719_1_.getTileEntity(p_149719_2_, p_149719_3_, p_149719_4_)).getFacing();
			if (meta % 2 == 0)
				setBlockBounds(0, 0, 0.2f, 1, 1.3f, 0.8f);
			else
				setBlockBounds(0.2f, 0, 0, 0.8f, 1.3f, 1);
		}
	}

	@Override
	public void registerBlockIcons(IIconRegister icon)
	{
		blockIcon = icon.registerIcon(Resources.MODID + ":" + "blank");
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack item)
	{
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile instanceof TileEntityRotate)
		{
			TileEntityRotate te = (TileEntityRotate)tile;
			int l = MathHelper.floor_double(player.rotationYaw * 4.0F / 360.0F + 0.5D) & 0x3;
			te.setFacing(l);
		}
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
}
