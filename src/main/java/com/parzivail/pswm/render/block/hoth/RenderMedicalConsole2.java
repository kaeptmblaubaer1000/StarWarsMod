package com.parzivail.pswm.render.block.hoth;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.hoth.ModelMedicalConsole2;
import com.parzivail.pswm.render.block.RenderPTile;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderMedicalConsole2 extends RenderPTile
{
	public RenderMedicalConsole2()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/medicalconsole2.png"), new ModelMedicalConsole2());
	}
}
