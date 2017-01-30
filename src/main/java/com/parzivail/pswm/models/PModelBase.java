package com.parzivail.pswm.models;

import com.google.common.base.Function;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.common.model.IModelState;

import java.util.Collection;

/**
 * Created by Colby on 1/30/2017.
 */
public class PModelBase implements IModel
{
	ModelBase model;

	public PModelBase(Class<? extends ModelBase> modelClass)
	{
		try
		{
			model = modelClass.newInstance();
		}
		catch (InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public Collection<ResourceLocation> getDependencies()
	{
		return null;
	}

	@Override
	public Collection<ResourceLocation> getTextures()
	{
		return null;
	}

	@Override
	public IBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter)
	{
		return null;
	}

	@Override
	public IModelState getDefaultState()
	{
		return null;
	}
}
