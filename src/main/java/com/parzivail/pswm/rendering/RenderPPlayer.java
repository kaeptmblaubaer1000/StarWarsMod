package com.parzivail.pswm.rendering;

import com.parzivail.pswm.models.mobs.ModelPBiped;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderPlayer;

@SideOnly(Side.CLIENT)
public class RenderPPlayer extends RenderPlayer
{
	public RenderPPlayer()
	{
		this.mainModel = new ModelPBiped();
		this.modelBipedMain = (ModelPBiped)this.mainModel;
		this.modelArmorChestplate = new ModelPBiped(1.0F);
		this.modelArmor = new ModelPBiped(0.5F);
	}
}