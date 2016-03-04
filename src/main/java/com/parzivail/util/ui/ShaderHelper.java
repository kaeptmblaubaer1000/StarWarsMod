package com.parzivail.util.ui;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.ARBFragmentShader;
import org.lwjgl.opengl.ARBShaderObjects;
import org.lwjgl.opengl.ARBVertexShader;
import org.lwjgl.opengl.GL11;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import java.io.File;

import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreenOptionsSounds;
import net.minecraft.client.gui.GuiVideoSettings;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.shader.ShaderManager;

public final class ShaderHelper
{
	private static final int VERT = ARBVertexShader.GL_VERTEX_SHADER_ARB;
	private static final int FRAG = ARBFragmentShader.GL_FRAGMENT_SHADER_ARB;

	public static int glow = 0;
	public static int glowKylo = 0;
	public static int phosphor = 0;

	public static void initShaders()
	{
		if (!useShaders())
			return;

		glow = createProgramFor("glow");
		glowKylo = createProgramFor("glowKylo");
		phosphor = createProgramFor("sobel", "phosphor");
	}

	public static void useShader(int shader, ShaderCallback callback)
	{
		if (!useShaders())
			return;

		ARBShaderObjects.glUseProgramObjectARB(shader);
		
		if (shader != 0)
		{
			// TODO: add various uniform passthroughs for the shaders

			if (shader == phosphor)
			{
				int projMat = ARBShaderObjects.glGetUniformLocationARB(shader, "ProjMat");
				FloatBuffer fb = BufferUtils.createFloatBuffer(16);
				fb.put(1.0f);
				fb.put(0.0f);
				fb.put(0.0f);
				fb.put(0.0f);
				fb.put(0.0f);
				fb.put(1.0f);
				fb.put(0.0f);
				fb.put(0.0f);
				fb.put(0.0f);
				fb.put(0.0f);
				fb.put(1.0f);
				fb.put(0.0f);
				fb.put(0.0f);
				fb.put(0.0f);
				fb.put(0.0f);
				fb.put(1.0f);
				ARBShaderObjects.glUniformMatrix4ARB(projMat, true, fb);

				int inSize = ARBShaderObjects.glGetUniformLocationARB(shader, "InSize");
				ARBShaderObjects.glUniform2fARB(inSize, 1, 1);

				int outSize = ARBShaderObjects.glGetUniformLocationARB(shader, "OutSize");
				ARBShaderObjects.glUniform2fARB(outSize, 1, 1);

				int psphr = ARBShaderObjects.glGetUniformLocationARB(shader, "Phosphor");
				ARBShaderObjects.glUniform3fARB(psphr, 0.3f, 0.3f, 0.3f);
			}
			else
			{
				int time = ARBShaderObjects.glGetUniformLocationARB(shader, "time");
				ARBShaderObjects.glUniform1iARB(time, StarWarsMod.mc.thePlayer.ticksExisted);
			}

			if (callback != null)
				callback.call(shader);
		}
	}

	public static void useShader(int shader)
	{
		useShader(shader, null);
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
			Lumberjack.log(getLogInfo(program));
			return 0;
		}

		ARBShaderObjects.glValidateProgramARB(program);
		if (ARBShaderObjects.glGetObjectParameteriARB(program, ARBShaderObjects.GL_OBJECT_VALIDATE_STATUS_ARB) == GL11.GL_FALSE)
		{
			Lumberjack.log(getLogInfo(program));
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