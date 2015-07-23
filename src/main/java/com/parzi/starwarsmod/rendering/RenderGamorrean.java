package com.parzi.starwarsmod.rendering;

import java.util.UUID;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
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

import com.mojang.authlib.GameProfile;
import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.models.mobs.ModelGamorrean;
import com.parzi.starwarsmod.rendering.models.mobs.ModelWampa;

public class RenderGamorrean extends RenderLiving
{
	public RenderGamorrean(ModelGamorrean par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return new ResourceLocation(StarWarsMod.MODID, "textures/models/gamorrean.png");
	}
}
