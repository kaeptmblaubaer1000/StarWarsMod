package com.parzivail.pswm.models;

import com.parzivail.pswm.Resources;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Colby on 1/30/2017.
 */
public class ModelResourceLocation extends ResourceLocation
{
	private Class<? extends ModelBase> clazz;

	public ModelResourceLocation(Class<? extends ModelBase> clazz)
	{
		super(Resources.MODID, clazz.getName());
		this.clazz = clazz;
	}

	public Class<? extends ModelBase> getModelClass()
	{
		return clazz;
	}
}
