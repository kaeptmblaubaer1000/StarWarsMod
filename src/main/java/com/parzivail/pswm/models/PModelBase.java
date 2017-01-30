package com.parzivail.pswm.models;

import com.google.common.base.Function;
import com.parzivail.util.Group;
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
	ResourceLocation texture;
	ModelBase model;

	public PModelBase(ModelResourceLocation location)
	{
		try
		{
			model = location.getModelClass().newInstance();
		}
		catch (InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
		texture = location.getTexture();
	}

	@Override
	public Collection<ResourceLocation> getDependencies()
	{
		return null;
	}

	@Override
	public Collection<ResourceLocation> getTextures()
	{
		return Group.of(texture);
	}

	@Override
	public IBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter)
	{
		return new PBakedModelBase(this, state, format, bakedTextureGetter);
	}

	@Override
	public IModelState getDefaultState()
	{
		return null;
	}
}
