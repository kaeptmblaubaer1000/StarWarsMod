package com.parzi.starwarsmod.rendering;

import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;

import org.lwjgl.opengl.GL11;

import com.mojang.authlib.GameProfile;
import com.parzi.starwarsmod.StarWarsMod;

public class RenderEwok extends RenderLiving
{
	public RenderEwok(ModelBase par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return new ResourceLocation(StarWarsMod.MODID, "textures/models/ewok.png");
	}

	@Override
	protected void renderEquippedItems(EntityLivingBase p_77029_1_, float p_77029_2_)
	{
		GL11.glColor3f(1.0F, 1.0F, 1.0F);
		super.renderEquippedItems(p_77029_1_, p_77029_2_);
		ItemStack heldItem = p_77029_1_.getHeldItem();
		ItemStack equippedItem = p_77029_1_.getEquipmentInSlot(3);
		Item item;
		float f1;

		if (equippedItem != null)
		{
			GL11.glPushMatrix();
			item = equippedItem.getItem();

			net.minecraftforge.client.IItemRenderer customRenderer = net.minecraftforge.client.MinecraftForgeClient.getItemRenderer(equippedItem, net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED);
			boolean is3D = customRenderer != null && customRenderer.shouldUseRenderHelper(net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED, equippedItem, net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D);

			if (item instanceof ItemBlock)
			{
				if (is3D || RenderBlocks.renderItemIn3d(Block.getBlockFromItem(item).getRenderType()))
				{
					f1 = 0.625F;
					GL11.glTranslatef(0.0F, -0.25F, 0.0F);
					GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
					GL11.glScalef(f1, -f1, -f1);
				}

				renderManager.itemRenderer.renderItem(p_77029_1_, equippedItem, 0);
			}
			else if (item == Items.skull)
			{
				f1 = 1.0625F;
				GL11.glScalef(f1, -f1, -f1);
				GameProfile gameprofile = null;

				if (equippedItem.hasTagCompound())
				{
					NBTTagCompound nbttagcompound = equippedItem.getTagCompound();

					if (nbttagcompound.hasKey("SkullOwner", 10))
					{
						gameprofile = NBTUtil.func_152459_a(nbttagcompound.getCompoundTag("SkullOwner"));
					}
					else if (nbttagcompound.hasKey("SkullOwner", 8) && !StringUtils.isNullOrEmpty(nbttagcompound.getString("SkullOwner")))
					{
						gameprofile = new GameProfile((UUID)null, nbttagcompound.getString("SkullOwner"));
					}
				}

				TileEntitySkullRenderer.field_147536_b.func_152674_a(-0.5F, 0.0F, -0.5F, 1, 180.0F, equippedItem.getItemDamage(), gameprofile);
			}

			GL11.glPopMatrix();
		}

		if (heldItem != null && heldItem.getItem() != null)
		{
			item = heldItem.getItem();
			GL11.glPushMatrix();

			if (mainModel.isChild)
			{
				f1 = 0.5F;
				GL11.glTranslatef(0.0F, 0.625F, 0.0F);
				GL11.glRotatef(-20.0F, -1.0F, 0.0F, 0.0F);
				GL11.glScalef(f1, f1, f1);
			}

			GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);

			net.minecraftforge.client.IItemRenderer customRenderer = net.minecraftforge.client.MinecraftForgeClient.getItemRenderer(heldItem, net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED);
			boolean is3D = customRenderer != null && customRenderer.shouldUseRenderHelper(net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED, heldItem, net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D);

			if (item instanceof ItemBlock && (is3D || RenderBlocks.renderItemIn3d(Block.getBlockFromItem(item).getRenderType())))
			{
				f1 = 0.5F;
				GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
				f1 *= 0.75F;
				GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
				GL11.glScalef(-f1, -f1, f1);
			}
			else if (item == Items.bow)
			{
				f1 = 0.625F;
				GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
				GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
				GL11.glScalef(f1, -f1, f1);
				GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			}
			else if (item.isFull3D())
			{
				f1 = 0.625F;

				if (item.shouldRotateAroundWhenRendering())
				{
					GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
					GL11.glTranslatef(0.0F, -0.125F, 0.0F);
				}

				GL11.glScalef(f1, -f1, f1);
				GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			}
			else
			{
				f1 = 0.375F;
				GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
				GL11.glScalef(f1, f1, f1);
				GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
			}

			float f2;
			int i;
			float f5;

			GL11.glTranslatef(0.5F, 0.25F, -1.0F);

			if (heldItem.getItem().requiresMultipleRenderPasses())
			{
				for (i = 0; i < heldItem.getItem().getRenderPasses(heldItem.getItemDamage()); ++i)
				{
					int j = heldItem.getItem().getColorFromItemStack(heldItem, i);
					f5 = (j >> 16 & 255) / 255.0F;
					f2 = (j >> 8 & 255) / 255.0F;
					float f3 = (j & 255) / 255.0F;
					GL11.glColor4f(f5, f2, f3, 1.0F);
					renderManager.itemRenderer.renderItem(p_77029_1_, heldItem, i);
				}
			}
			else
			{
				i = heldItem.getItem().getColorFromItemStack(heldItem, 0);
				float f4 = (i >> 16 & 255) / 255.0F;
				f5 = (i >> 8 & 255) / 255.0F;
				f2 = (i & 255) / 255.0F;
				GL11.glColor4f(f4, f5, f2, 1.0F);
				renderManager.itemRenderer.renderItem(p_77029_1_, heldItem, 0);
			}

			GL11.glPopMatrix();
		}
	}

}
