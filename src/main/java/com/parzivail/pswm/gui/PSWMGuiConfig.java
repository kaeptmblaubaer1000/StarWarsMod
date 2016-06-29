package com.parzivail.pswm.gui;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Colby on 6/28/2016.
 */
public class PSWMGuiConfig extends GuiConfig
{
	public PSWMGuiConfig(GuiScreen parent)
	{
		super(parent, getConfigElements(), Resources.MODID, StarWarsMod.configFile.getName(), true, true, "PSWM v" + Resources.VERSION);
		titleLine2 = StarWarsMod.configFile.getAbsolutePath();
	}

	private static List<IConfigElement> getConfigElements()
	{
		List<IConfigElement> list = new ArrayList<>();
		list.add(new ConfigElement(StarWarsMod.config.getCategory("core")));
		list.add(new ConfigElement(StarWarsMod.config.getCategory("dimensions")));
		list.add(new ConfigElement(StarWarsMod.config.getCategory("biomes")));
		list.add(new ConfigElement(StarWarsMod.config.getCategory("gui")));
		list.add(new ConfigElement(StarWarsMod.config.getCategory("items")));
		return list;
	}

	@Override
	public void onGuiClosed()
	{
		super.onGuiClosed();
	}
}
