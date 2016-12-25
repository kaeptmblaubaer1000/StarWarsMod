package com.parzivail.pswm.registry;

import com.parzivail.pswm.Resources;
import com.parzivail.util.common.Lumberjack;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

/**
 * Created by colby on 12/23/2016.
 */
public class KeybindRegistry
{
	@SideOnly(Side.CLIENT)
	public static KeyBinding keyDebug;

	public static void register()
	{
		if (Resources.IS_DEV_ENVIRONMENT)
		{
			KeybindRegistry.keyDebug = registerKeybind("debug", Keyboard.KEY_N);
		}

		Lumberjack.log("[KEYS] All wings report in.");
	}

	private static KeyBinding registerKeybind(String keyName, int keyCode)
	{
		KeyBinding b = new KeyBinding("key." + Resources.MODID + "." + keyName, keyCode, "key." + Resources.MODID);
		ClientRegistry.registerKeyBinding(b);
		return b;
	}
}
