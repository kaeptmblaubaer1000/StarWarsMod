package com.parzivail.pswm.rendering;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.items.weapons.ItemLightsaber;
import com.parzivail.pswm.models.lightsabers.*;
import com.parzivail.pswm.models.lightsabers.blades.*;
import com.parzivail.util.ui.ShaderHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;

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
		models.put("luke2", new ModelLukeNewHilt());
		models.put("crossguard", new ModelCrossbarHilt());
		models.put("malgus", new ModelMalgusHilt());
		models.put("obiwan", new ModelObiwanHilt());
		models.put("quigon", new ModelQuigonHilt());
		models.put("revan", new ModelRevanHilt());
		models.put("starkiller", new ModelStarkillerHilt());

		blades.put("dooku", new IHandlesRender[] { new ModelDookuBladeShort(), new ModelDookuBladeMedium(), new ModelDookuBladeLong() });
		blades.put("ezra", new IHandlesRender[] { new ModelEzraBladeShort(), new ModelEzraBladeMedium(), new ModelEzraBladeLong() });
		blades.put("kanan", new IHandlesRender[] { new ModelKananBladeShort(), new ModelKananBladeMedium(), new ModelKananBladeLong() });
		blades.put("maul", new IHandlesRender[] { new ModelMaulBladeShort(), new ModelMaulBladeMedium(), new ModelMaulBladeLong() });
		blades.put("padawan", new IHandlesRender[] { new ModelPadawanBladeShort(), new ModelPadawanBladeMedium(), new ModelPadawanBladeLong() });
		blades.put("shoto", new IHandlesRender[] { new ModelShotoBladeShort(), new ModelShotoBladeMedium(), new ModelShotoBladeLong() });
		blades.put("doubleSith", new IHandlesRender[] { new ModelSithDoubleBladeShort(), new ModelSithDoubleBladeMedium(), new ModelSithDoubleBladeLong() });
		blades.put("vader2", new IHandlesRender[] { new ModelVaderBladeShort(), new ModelVaderBladeMedium(), new ModelVaderBladeLong() });
		blades.put("luke1", new IHandlesRender[] { new ModelLuke1BladeShort(), new ModelLuke1BladeMedium(), new ModelLuke1BladeLong() });
		blades.put("luke2", new IHandlesRender[] { new ModelLukeNewBladeS(), new ModelLukeNewBladeM(), new ModelLukeNewBladeL() });
		blades.put("crossguard", new IHandlesRender[] { new ModelCrossguardBladeShort(), new ModelCrossguardBladeMedium(), new ModelCrossguardBladeLong() });
		blades.put("malgus", new IHandlesRender[] { new ModelMalgusBladeS(), new ModelMalgusBladeM(), new ModelMalgusBladeL() });
		blades.put("obiwan", new IHandlesRender[] { new ModelObiwanBladeS(), new ModelObiwanBladeM(), new ModelObiwanBladeL() });
		blades.put("quigon", new IHandlesRender[] { new ModelQuigonBladeS(), new ModelQuigonBladeM(), new ModelQuigonBladeL() });
		blades.put("revan", new IHandlesRender[] { new ModelRevanBladeS(), new ModelRevanBladeM(), new ModelRevanBladeL() });
		blades.put("starkiller", new IHandlesRender[] { new ModelStarkillerBladeS(), new ModelStarkillerBladeM(), new ModelStarkillerBladeL() });
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
			StarWarsMod.mc.renderEngine.bindTexture(r.getResourceLocation(item.stackTagCompound != null && item.stackTagCompound.getBoolean(ItemLightsaber.nbtHiltSkin)));
			r.renderItem(type, item, data);
			GL11.glPopMatrix();
			IHandlesRender rB = getBladeRendererForStack(item);
			if (rB != null && item.stackTagCompound.getBoolean(ItemLightsaber.nbtBladeOn) && type != ItemRenderType.INVENTORY)
			{
				GL11.glPushMatrix();
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				if (item.stackTagCompound.getBoolean(ItemLightsaber.nbtBladeDistortion))
					ShaderHelper.setLightsaberColorDistort(item.stackTagCompound.getInteger(ItemLightsaber.nbtBladeColor));
				else
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

	public void renderHiltItem(IHandlesRender item, boolean alt)
	{
		IHandlesRender r = item;
		GL11.glPushMatrix();
		StarWarsMod.mc.renderEngine.bindTexture(r.getResourceLocation(alt));
		r.renderItem(ItemRenderType.ENTITY, null);
		GL11.glPopMatrix();
	}

	@Override
	public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
	{
		IHandlesRender r = getHiltRendererForStack(item);
		if (r != null)
			return r.shouldUseRenderHelper(type, item, helper);
		return true;
	}

	public static IHandlesRender getHiltRendererForStack(ItemStack stack)
	{
		if (stack.stackTagCompound != null && models.containsKey(stack.stackTagCompound.getString(ItemLightsaber.nbtHilt)))
			return models.get(stack.stackTagCompound.getString(ItemLightsaber.nbtHilt));
		else
			return models.get(ItemLightsaber.hilts[((ItemLightsaber)stack.getItem()).hiltIndex]);
	}

	public static IHandlesRender getBladeRendererForStack(ItemStack stack)
	{
		if (stack.stackTagCompound != null && blades.containsKey(stack.stackTagCompound.getString(ItemLightsaber.nbtHilt)) && blades.get(stack.stackTagCompound.getString(ItemLightsaber.nbtHilt)).length == 3)
			return blades.get(stack.stackTagCompound.getString(ItemLightsaber.nbtHilt))[stack.stackTagCompound.getInteger(ItemLightsaber.nbtBladeLength)];
		else
			return null;
	}

	public static void applyTransformFix(String s)
	{
		if (s.equals("dooku"))
		{
			GL11.glTranslatef(0, 0.075f, 0);
		}
		else if (s.equals("ezra"))
		{
			GL11.glTranslatef(0, 0.075f, 0);
		}
		else if (s.equals("kanan"))
		{
			GL11.glTranslatef(0, 0.16f, 0);
		}
		else if (s.equals("maul"))
		{
			GL11.glScalef(0.55f, 0.55f, 0.55f);
			GL11.glTranslatef(0, 0.15f, 0);
		}
		else if (s.equals("padawan"))
		{
			GL11.glTranslatef(0, 0.4f, 0);
		}
		else if (s.equals("shoto"))
		{
			GL11.glScalef(0.9f, 0.9f, 0.9f);
			GL11.glTranslatef(0, 0.27f, 0);
		}
		else if (s.equals("doubleSith"))
		{
			GL11.glScalef(0.8f, 0.8f, 0.8f);
			GL11.glTranslatef(0, -0.27f, 0);
		}
		else if (s.equals("vader2"))
		{
			GL11.glTranslatef(0, 0.17f, 0);
			GL11.glScalef(1.4f, 1.4f, 1.4f);
		}
		else if (s.equals("luke1"))
		{
			GL11.glTranslatef(0, 0.28f, 0);
			GL11.glScalef(1.4f, 1.4f, 1.4f);
		}
		else if (s.equals("luke2"))
		{
			GL11.glTranslatef(0, 0.25f, 0);
		}
		else if (s.equals("crossguard"))
		{
			GL11.glTranslatef(0, 0.24f, 0);
			GL11.glScalef(1.2f, 1.2f, 1.2f);
		}
		else if (s.equals("malgus"))
		{
			GL11.glScalef(0.85f, 0.85f, 0.85f);
			GL11.glTranslatef(0, 0.29f, 0);
		}
		else if (s.equals("obiwan"))
		{
			GL11.glScalef(0.9f, 0.9f, 0.9f);
			GL11.glTranslatef(0, 0.27f, 0);
		}
		else if (s.equals("quigon"))
		{
			GL11.glScalef(0.9f, 0.9f, 0.9f);
			GL11.glTranslatef(0, 0.34f, 0);
		}
		else if (s.equals("revan"))
		{
			GL11.glScalef(0.9f, 0.9f, 0.9f);
			GL11.glTranslatef(0, 0.31f, 0);
		}
		else if (s.equals("starkiller"))
		{
			GL11.glTranslatef(0, 0.3f, 0);
			GL11.glScalef(1.1f, 1.1f, 1.1f);
		}
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\RenderLightsaberOff.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */