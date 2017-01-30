package com.parzivail.pswm.models;

import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;

/**
 * Created by Colby on 1/30/2017.
 */
public class ModelBaseLoader implements ICustomModelLoader
{
	@Override
	public boolean accepts(ResourceLocation modelLocation)
	{
		return modelLocation instanceof ModelResourceLocation;
	}

	@Override
	public IModel loadModel(ResourceLocation modelLocation) throws Exception
	{
		if (!(modelLocation instanceof ModelResourceLocation))
			throw new IllegalArgumentException("modelLocation must be a ModelResourceLocation!");

		ModelResourceLocation location = (ModelResourceLocation)modelLocation;

		return new PModelBase(location);
	}

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager)
	{

	}
}
