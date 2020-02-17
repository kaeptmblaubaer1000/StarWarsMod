package com.parzivail.pswm.gui;

import com.parzivail.pswm.Resources;
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
	@SuppressWarnings({"rawtypes", "unchecked"})
	public PSWMGuiConfig(GuiScreen parent)
	{
		super(parent, (List<IConfigElement>)(List)getConfigElements(), Resources.MODID, Resources.ConfigOptions.configFile.getName(), false, false, "PSWM v" + Resources.VERSION);
		titleLine2 = Resources.ConfigOptions.configFile.getAbsolutePath();
	}

	private static List<IConfigElement<?>> getConfigElements()
	{
		List<IConfigElement<?>> list = new ArrayList<>();
		list.add(new ConfigElement<>(Resources.ConfigOptions.config.getCategory("core")));
		list.add(new ConfigElement<>(Resources.ConfigOptions.config.getCategory("dimensions")));
		list.add(new ConfigElement<>(Resources.ConfigOptions.config.getCategory("biomes")));
		list.add(new ConfigElement<>(Resources.ConfigOptions.config.getCategory("gui")));
		list.add(new ConfigElement<>(Resources.ConfigOptions.config.getCategory("items")));
		return list;
	}

	@Override
	public void onGuiClosed()
	{
		super.onGuiClosed();
		Resources.ConfigOptions.config.save();
		Resources.ConfigOptions.loadConfigOptions();
	}
}
