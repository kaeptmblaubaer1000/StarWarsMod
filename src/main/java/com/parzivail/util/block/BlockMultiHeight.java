package com.parzivail.util.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMultiHeight extends PBlock
{
	private String texture;

	public BlockMultiHeight(String texture)
	{
		super("multiHeight" + "." + texture, Material.rock);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
		this.setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		this.setBlockBoundsFromHeight(0);

		this.texture = texture;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register)
	{
		this.blockIcon = register.registerIcon(Resources.MODID + ":" + this.texture);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		int l = (world.getBlockMetadata(x, y, z) & 15) + 1;
		float f = 1 / 16f;
		return AxisAlignedBB.getBoundingBox((double)x + this.minX, (double)y + this.minY, (double)z + this.minZ, (double)x + this.maxX, (float)y + (float)l * f, (double)z + this.maxZ);
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public void setBlockBoundsForItemRender()
	{
		this.setBlockBoundsFromHeight(0);
	}

	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z)
	{
		this.setBlockBoundsFromHeight(blockAccess.getBlockMetadata(x, y, z));
	}

	private void setBlockBoundsFromHeight(int height)
	{
		int j = height & 15;
		float f = (float)(1 + j) / 16.0F;
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
	}

	public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int meta)
	{
		super.harvestBlock(world, player, x, y, z, meta);
		world.setBlockToAir(x, y, z);
	}

	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
		return side == 1 || super.shouldSideBeRendered(blockAccess, x, y, z, side);
	}

	public boolean isReplaceable(IBlockAccess world, int x, int y, int z)
	{
		return false;
	}
}