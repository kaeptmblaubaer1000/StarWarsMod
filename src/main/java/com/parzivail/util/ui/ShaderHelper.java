package com.parzivail.util.ui;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import net.minecraft.client.renderer.OpenGlHelper;
import org.lwjgl.opengl.ARBFragmentShader;
import org.lwjgl.opengl.ARBShaderObjects;
import org.lwjgl.opengl.ARBVertexShader;
import org.lwjgl.opengl.GL11;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class ShaderHelper
{
	private static final int VERT = ARBVertexShader.GL_VERTEX_SHADER_ARB;
	private static final int FRAG = ARBFragmentShader.GL_FRAGMENT_SHADER_ARB;

	public static int glowSolid = 0;

	private static float r;
	private static float g;
	private static float b;
	private static float a;

	public static void setColor(float r, float g, float b, float a)
	{
		ShaderHelper.r = r;
		ShaderHelper.g = g;
		ShaderHelper.b = b;
		ShaderHelper.a = a;
	}

	public static void setLightsaberColor(int color)
	{
		int red = color >> 16 & 0xFF;
		int green = color >> 8 & 0xFF;
		int blue = color & 0xFF;
		setColor(red / 255f, green / 255f, blue / 255f, 0.98f);
	}

	public static void setLightsaberColorDistort(int color)
	{
		float rN = (StarWarsMod.rngGeneral.nextFloat() * 0.2f + 0.8f);
		int red = color >> 16 & 0xFF;
		int green = color >> 8 & 0xFF;
		int blue = color & 0xFF;
		setColor(red / 255f * rN, green / 255f * rN, blue / 255f * rN, 0.98f);
	}

	public static void initShaders()
	{
		if (!useShaders())
			return;

		glowSolid = createProgramFor("glowSolid");
	}

	public static void useShader(int shader)
	{
		if (!useShaders())
			return;

		ARBShaderObjects.glUseProgramObjectARB(shader);

		if (shader != 0)
		{
			if (shader == glowSolid)
			{
				int r0 = ARBShaderObjects.glGetUniformLocationARB(shader, "r");
				ARBShaderObjects.glUniform1fARB(r0, r);

				int g0 = ARBShaderObjects.glGetUniformLocationARB(shader, "g");
				ARBShaderObjects.glUniform1fARB(g0, g);

				int b0 = ARBShaderObjects.glGetUniformLocationARB(shader, "b");
				ARBShaderObjects.glUniform1fARB(b0, b);

				int a0 = ARBShaderObjects.glGetUniformLocationARB(shader, "a");
				ARBShaderObjects.glUniform1fARB(a0, a);
			}
			else
			{
				int time = ARBShaderObjects.glGetUniformLocationARB(shader, "time");
				ARBShaderObjects.glUniform1iARB(time, StarWarsMod.mc.thePlayer.ticksExisted);
			}
		}
	}

	public static void releaseShader()
	{
		useShader(0);
	}

	public static boolean useShaders()
	{
		return OpenGlHelper.shadersSupported;
	}

	// Most of the code taken from the LWJGL wiki
	// http://lwjgl.org/wiki/index.php?title=GLSL_Shaders_with_LWJGL

	private static int createProgram(String vert, String frag)
	{
		int vertId = 0, fragId = 0, program = 0;
		if (vert != null)
			vertId = createShader(vert, VERT);
		if (frag != null)
			fragId = createShader(frag, FRAG);

		program = ARBShaderObjects.glCreateProgramObjectARB();
		if (program == 0)
			return 0;

		if (vert != null)
			ARBShaderObjects.glAttachObjectARB(program, vertId);
		if (frag != null)
			ARBShaderObjects.glAttachObjectARB(program, fragId);

		ARBShaderObjects.glLinkProgramARB(program);
		if (ARBShaderObjects.glGetObjectParameteriARB(program, ARBShaderObjects.GL_OBJECT_LINK_STATUS_ARB) == GL11.GL_FALSE)
		{
			Lumberjack.debug(getLogInfo(program));
			return 0;
		}

		ARBShaderObjects.glValidateProgramARB(program);
		if (ARBShaderObjects.glGetObjectParameteriARB(program, ARBShaderObjects.GL_OBJECT_VALIDATE_STATUS_ARB) == GL11.GL_FALSE)
		{
			Lumberjack.debug(getLogInfo(program));
			return 0;
		}

		return program;
	}

	private static int createProgramFor(String name)
	{
		String vert = null;
		String frag = null;
		if (ShaderHelper.class.getResourceAsStream("/assets/" + Resources.MODID + "/shaders/" + name + ".vert") != null)
		{
			vert = "/assets/" + Resources.MODID + "/shaders/" + name + ".vert";
		}
		if (ShaderHelper.class.getResourceAsStream("/assets/" + Resources.MODID + "/shaders/" + name + ".frag") != null)
		{
			frag = "/assets/" + Resources.MODID + "/shaders/" + name + ".frag";
		}
		return createProgram(vert, frag);
	}

	private static int createProgramFor(String v, String f)
	{
		String vert = null;
		String frag = null;
		if (ShaderHelper.class.getResourceAsStream("/assets/" + Resources.MODID + "/shaders/" + v + ".vert") != null)
		{
			vert = "/assets/" + Resources.MODID + "/shaders/" + v + ".vert";
		}
		if (ShaderHelper.class.getResourceAsStream("/assets/" + Resources.MODID + "/shaders/" + f + ".frag") != null)
		{
			frag = "/assets/" + Resources.MODID + "/shaders/" + f + ".frag";
		}
		return createProgram(vert, frag);
	}

	private static int createShader(String filename, int shaderType)
	{
		int shader = 0;
		try
		{
			shader = ARBShaderObjects.glCreateShaderObjectARB(shaderType);

			if (shader == 0)
				return 0;

			ARBShaderObjects.glShaderSourceARB(shader, readFileAsString(filename));
			ARBShaderObjects.glCompileShaderARB(shader);

			if (ARBShaderObjects.glGetObjectParameteriARB(shader, ARBShaderObjects.GL_OBJECT_COMPILE_STATUS_ARB) == GL11.GL_FALSE)
				throw new RuntimeException("Error creating shader: " + getLogInfo(shader));

			return shader;
		}
		catch (Exception e)
		{
			ARBShaderObjects.glDeleteObjectARB(shader);
			e.printStackTrace();
			return -1;
		}
	}

	private static String getLogInfo(int obj)
	{
		return ARBShaderObjects.glGetInfoLogARB(obj, ARBShaderObjects.glGetObjectParameteriARB(obj, ARBShaderObjects.GL_OBJECT_INFO_LOG_LENGTH_ARB));
	}

	private static String readFileAsString(String filename) throws Exception
	{
		StringBuilder source = new StringBuilder();
		InputStream in = ShaderHelper.class.getResourceAsStream(filename);
		Exception exception = null;
		BufferedReader reader;

		if (in == null)
			return "";

		try
		{
			reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));

			Exception innerExc = null;
			try
			{
				String line;
				while ((line = reader.readLine()) != null)
					source.append(line).append('\n');
			}
			catch (Exception exc)
			{
				exception = exc;
			}
			finally
			{
				try
				{
					reader.close();
				}
				catch (Exception exc)
				{
					if (innerExc == null)
						innerExc = exc;
					else
						exc.printStackTrace();
				}
			}

			if (innerExc != null)
				throw innerExc;
		}
		catch (Exception exc)
		{
			exception = exc;
		}
		finally
		{
			try
			{
				in.close();
			}
			catch (Exception exc)
			{
				if (exception == null)
					exception = exc;
				else
					exc.printStackTrace();
			}

			if (exception != null)
				throw exception;
		}

		return source.toString();
	}

}