package com.parzivail.pswm.rendering;

import java.util.HashMap;

import org.lwjgl.opengl.GL11;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.items.weapons.ItemLightsaber;
import com.parzivail.pswm.models.lightsabers.ModelAncientSithHilt;
import com.parzivail.pswm.models.lightsabers.ModelCrossbarHilt;
import com.parzivail.pswm.models.lightsabers.ModelDookuHilt;
import com.parzivail.pswm.models.lightsabers.ModelEzraHilt;
import com.parzivail.pswm.models.lightsabers.ModelKananHilt;
import com.parzivail.pswm.models.lightsabers.ModelLuke1Hilt;
import com.parzivail.pswm.models.lightsabers.ModelLuke2Hilt;
import com.parzivail.pswm.models.lightsabers.ModelMaulHilt;
import com.parzivail.pswm.models.lightsabers.ModelPadawanHilt;
import com.parzivail.pswm.models.lightsabers.ModelShotoHilt;
import com.parzivail.pswm.models.lightsabers.ModelVader2Hilt;
import com.parzivail.pswm.models.lightsabers.blades.ModelCrossguardBladeLong;
import com.parzivail.pswm.models.lightsabers.blades.ModelCrossguardBladeMedium;
import com.parzivail.pswm.models.lightsabers.blades.ModelCrossguardBladeShort;
import com.parzivail.pswm.models.lightsabers.blades.ModelDookuBladeLong;
import com.parzivail.pswm.models.lightsabers.blades.ModelDookuBladeMedium;
import com.parzivail.pswm.models.lightsabers.blades.ModelDookuBladeShort;
import com.parzivail.pswm.models.lightsabers.blades.ModelEzraBladeLong;
import com.parzivail.pswm.models.lightsabers.blades.ModelEzraBladeMedium;
import com.parzivail.pswm.models.lightsabers.blades.ModelEzraBladeShort;
import com.parzivail.pswm.models.lightsabers.blades.ModelKananBladeLong;
import com.parzivail.pswm.models.lightsabers.blades.ModelKananBladeMedium;
import com.parzivail.pswm.models.lightsabers.blades.ModelKananBladeShort;
import com.parzivail.pswm.models.lightsabers.blades.ModelLuke2BladeLong;
import com.parzivail.pswm.models.lightsabers.blades.ModelLuke2BladeMedium;
import com.parzivail.pswm.models.lightsabers.blades.ModelLuke2BladeShort;
import com.parzivail.pswm.models.lightsabers.blades.ModelMaulBladeLong;
import com.parzivail.pswm.models.lightsabers.blades.ModelMaulBladeMedium;
import com.parzivail.pswm.models.lightsabers.blades.ModelMaulBladeShort;
import com.parzivail.pswm.models.lightsabers.blades.ModelPadawanBladeLong;
import com.parzivail.pswm.models.lightsabers.blades.ModelPadawanBladeMedium;
import com.parzivail.pswm.models.lightsabers.blades.ModelPadawanBladeShort;
import com.parzivail.pswm.models.lightsabers.blades.ModelShotoBladeLong;
import com.parzivail.pswm.models.lightsabers.blades.ModelShotoBladeMedium;
import com.parzivail.pswm.models.lightsabers.blades.ModelShotoBladeShort;
import com.parzivail.pswm.models.lightsabers.blades.ModelSithDoubleBladeLong;
import com.parzivail.pswm.models.lightsabers.blades.ModelSithDoubleBladeMedium;
import com.parzivail.pswm.models.lightsabers.blades.ModelSithDoubleBladeShort;
import com.parzivail.pswm.models.lightsabers.blades.ModelVaderBladeLong;
import com.parzivail.pswm.models.lightsabers.blades.ModelVaderBladeMedium;
import com.parzivail.pswm.models.lightsabers.blades.ModelVaderBladeShort;
import com.parzivail.util.ui.ShaderHelper;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class RenderLightsaber implements IItemRenderer
{
	public static final HashMap<String, IHandlesRender> models = new HashMap<>();
	public static final HashMap<String, IHandlesRender[]> blades = new HashMap<>();

	static
	{
		models.put("dooku", new ModelDookuHilt());
		models.put("ezra", new ModelEzraHilt());
		models.put("kanan", new ModelKananHilt());
		models.put("maul", new ModelMaulHilt());
		models.put("padawan", new ModelPadawanHilt());
		models.put("shoto", new ModelShotoHilt());
		models.put("doubleSith", new ModelAncientSithHilt());
		models.put("vader2", new ModelVader2Hilt());
		models.put("luke1", new ModelLuke1Hilt());
		models.put("luke2", new ModelLuke2Hilt());
		models.put("crossguard", new ModelCrossbarHilt());

		blades.put("dooku", new IHandlesRender[] { new ModelDookuBladeShort(), new ModelDookuBladeMedium(), new ModelDookuBladeLong() });
		blades.put("ezra", new IHandlesRender[] { new ModelEzraBladeShort(), new ModelEzraBladeMedium(), new ModelEzraBladeLong() });
		blades.put("kanan", new IHandlesRender[] { new ModelKananBladeShort(), new ModelKananBladeMedium(), new ModelKananBladeLong() });
		blades.put("maul", new IHandlesRender[] { new ModelMaulBladeShort(), new ModelMaulBladeMedium(), new ModelMaulBladeLong() });
		blades.put("padawan", new IHandlesRender[] { new ModelPadawanBladeShort(), new ModelPadawanBladeMedium(), new ModelPadawanBladeLong() });
		blades.put("shoto", new IHandlesRender[] { new ModelShotoBladeShort(), new ModelShotoBladeMedium(), new ModelShotoBladeLong() });
		blades.put("doubleSith", new IHandlesRender[] { new ModelSithDoubleBladeShort(), new ModelSithDoubleBladeMedium(), new ModelSithDoubleBladeLong() });
		blades.put("vader2", new IHandlesRender[] { new ModelVaderBladeShort(), new ModelVaderBladeMedium(), new ModelVaderBladeLong() });
		blades.put("luke1", new IHandlesRender[] {});
		blades.put("luke2", new IHandlesRender[] { new ModelLuke2BladeShort(), new ModelLuke2BladeMedium(), new ModelLuke2BladeLong() });
		blades.put("crossguard", new IHandlesRender[] { new ModelCrossguardBladeShort(), new ModelCrossguardBladeMedium(), new ModelCrossguardBladeLong() });
	}

	public RenderLightsaber()
	{
	}

	@Override
	public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
	{
		IHandlesRender r = getHiltRendererForStack(item);
		if (r != null)
			return r.handleRenderType(item, type);
		return true;
	}

	@Override
	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data)
	{
		IHandlesRender r = getHiltRendererForStack(item);
		if (r != null)
		{
			GL11.glPushMatrix();
			StarWarsMod.mc.renderEngine.bindTexture(r.getResourceLocation(item.stackTagCompound == null ? false : item.stackTagCompound.getBoolean(ItemLightsaber.nbtBladeSkin)));
			r.renderItem(type, item, data);
			GL11.glPopMatrix();
			IHandlesRender rB = getBladeRendererForStack(item);
			if (rB != null && item.stackTagCompound.getBoolean(ItemLightsaber.nbtBladeOn) && type != ItemRenderType.INVENTORY)
			{
				GL11.glPushMatrix();
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				ShaderHelper.setLightsaberColor(item.stackTagCompound.getInteger(ItemLightsaber.nbtBladeColor));
				ShaderHelper.useShader(ShaderHelper.glowSolid);
				rB.renderItem(type, item, data);
				ShaderHelper.releaseShader();
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glPopMatrix();
			}
		}
		else
		{
			r = models.get("luke2");
			StarWarsMod.mc.renderEngine.bindTexture(r.getResourceLocation(false));
			r.renderItem(type, item, data);
		}
	}

	@Override
	public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
	{
		IHandlesRender r = getHiltRendererForStack(item);
		if (r != null)
			return r.shouldUseRenderHelper(type, item, helper);
		return true;
	}

	private IHandlesRender getHiltRendererForStack(ItemStack stack)
	{
		if (stack.stackTagCompound != null && models.containsKey(stack.stackTagCompound.getString(ItemLightsaber.nbtHilt)))
			return models.get(stack.stackTagCompound.getString(ItemLightsaber.nbtHilt));
		else
			return models.get(ItemLightsaber.hilts[((ItemLightsaber)stack.getItem()).hiltIndex]);
	}

	private IHandlesRender getBladeRendererForStack(ItemStack stack)
	{
		if (stack.stackTagCompound != null && blades.containsKey(stack.stackTagCompound.getString(ItemLightsaber.nbtHilt)) && blades.get(stack.stackTagCompound.getString(ItemLightsaber.nbtHilt)).length == 3)
			return blades.get(stack.stackTagCompound.getString(ItemLightsaber.nbtHilt))[stack.stackTagCompound.getInteger(ItemLightsaber.nbtBladeLength)];
		else
			return null;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\RenderLightsaberOff.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */