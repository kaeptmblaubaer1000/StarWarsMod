package com.parzivail.pswm.render.block.hoth;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.hoth.ModelMedicalConsole;
import com.parzivail.pswm.render.block.RenderPTile;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderMedicalConsole extends RenderPTile
{
	public RenderMedicalConsole()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/medicalconsole.png"), new ModelMedicalConsole());
	}
}
