package com.parzivail.pswm.registry;

import com.parzivail.pswm.bank.PBlocks;
import com.parzivail.util.block.BasicBlock;
import com.parzivail.util.common.Lumberjack;

/**
 * Created by colby on 12/21/2016.
 */
public class BlockRegister
{
	public static void register()
	{
		PBlocks.infraBlack = new BasicBlock("infra_black");
		PBlocks.infraCaution = new BasicBlock("infra_caution");
		PBlocks.infraCrate = new BasicBlock("infra_crate");
		PBlocks.infraDarkGray = new BasicBlock("infra_darkgray");
		PBlocks.infraDarkGrayLit = new BasicBlock("infra_darkgray_lit");
		PBlocks.infraDarkGrayLit2 = new BasicBlock("infra_darkgray_lit2");
		PBlocks.infraForest = new BasicBlock("infra_forest");
		PBlocks.infraForestInset = new BasicBlock("infra_forestinset");
		PBlocks.infraForestPanel1 = new BasicBlock("infra_forestpanel1");
		PBlocks.infraForestPanel2 = new BasicBlock("infra_forestpanel2");
		PBlocks.infraForestPanel3 = new BasicBlock("infra_forestpanel3");
		PBlocks.infraForestVine = new BasicBlock("infra_forestvine");
		PBlocks.infraLight = new BasicBlock("infra_light");
		PBlocks.infraLightinset = new BasicBlock("infra_lightinset");
		PBlocks.infraLightLit = new BasicBlock("infra_light_lit");
		PBlocks.infraPanel1 = new BasicBlock("infra_panel1");
		PBlocks.infraWhite = new BasicBlock("infra_white");

		Lumberjack.log("[BLOCKS] Prepare to orbit the planet Yavin.");
	}
}
