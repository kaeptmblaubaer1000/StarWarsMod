package com.parzivail.pswm.blocks.npc;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.quest.Quest;
import com.parzivail.pswm.quest.QuestNpcUtils;
import com.parzivail.pswm.tileentities.TileEntityStaticNpc;
import com.parzivail.util.IDebugProvider;
import com.parzivail.util.block.PBlockContainer;
import com.parzivail.util.ui.LangUtils;
import com.parzivail.util.world.HarvestLevel;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

public class BlockNpcBase extends PBlockContainer implements IDebugProvider
{
	public String id;
	String armor;

	public BlockNpcBase(String id, String armor)
	{
		super("staticNpc." + id, Material.iron);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		setBlockBounds(0, 0, 0, 1, 2, 1);
		setHardness(50.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);

		this.id = id;

		this.armor = armor;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		TileEntityStaticNpc te = new TileEntityStaticNpc();
		if (this.armor != null)
			QuestNpcUtils.arm(te.getInternalEntity(), this.armor);
		te.setId(this.id);
		return te;
	}

	public Quest getQuestForPlayer(EntityPlayer player)
	{
		return null;
	}

	@Override
	public List<String> getDebugText(List<String> list, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile instanceof TileEntityStaticNpc)
		{
			TileEntityStaticNpc t = (TileEntityStaticNpc)tile;
			list.add(t.getId());
			list.add(String.format(LangUtils.translate("facing") + ": %s", t.getFacing()));
			list.add(String.format(LangUtils.translate("locked") + ": %s", t.getLocked()));
		}

		return list;
	}

	@Override
	public int getRenderType()
	{
		return -1;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float subX, float subY, float subZ)
	{
		if (world.isRemote)
			player.openGui(StarWarsMod.instance, Resources.GUI_QUESTNPC, world, x, y, z);
		return true;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack item)
	{
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile instanceof TileEntityStaticNpc)
		{
			TileEntityStaticNpc tile1 = (TileEntityStaticNpc)tile;
			int l = Math.abs(MathHelper.floor_double(player.rotationYaw % 360 / 90f + 0.5f));
			tile1.setFacing(l);
			tile1.setLocked(player.isSneaking());
		}
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public void registerBlockIcons(IIconRegister icon)
	{
		blockIcon = icon.registerIcon(Resources.MODID + ":" + "iconStaticNpc");
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public boolean getBlocksMovement(IBlockAccess p_149655_1_, int p_149655_2_, int p_149655_3_, int p_149655_4_)
	{
		return false;
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int x, int y, int z)
	{
		return AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 2, z + 1);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z)
	{
		setBlockBounds(0, 0, 0, 1, 2, 1);
	}
}