package com.parzivail.util.camera;

import com.parzivail.pswm.PSWM;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by colby on 5/22/2017.
 */
public class EnvironmentCubemap
{
	private ResourceLocation cubemapFilename;

	public EnvironmentCubemap(ResourceLocation cubemapFilename)
	{
		this.cubemapFilename = cubemapFilename;
	}

	public void render()
	{
		PSWM.mc.getTextureManager().bindTexture(cubemapFilename);

		GL11.glPushMatrix();
		GL11.glPushAttrib(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_TEXTURE_2D);

		GL11.glPushAttrib(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_CULL_FACE);

		GL11.glBegin(GL11.GL_QUADS);
		// Left
		GL11.glTexCoord2f(0, 1 / 3f);
		GL11.glVertex3d(-1, 1, -1);

		GL11.glTexCoord2f(0, 2 / 3f);
		GL11.glVertex3d(-1, -1, -1);

		GL11.glTexCoord2f(1 / 4f, 2 / 3f);
		GL11.glVertex3d(-1, -1, 1);

		GL11.glTexCoord2f(1 / 4f, 1 / 3f);
		GL11.glVertex3d(-1, 1, 1);
		// Front
		GL11.glTexCoord2f(1 / 4f, 2 / 3f);
		GL11.glVertex3d(-1, -1, 1);

		GL11.glTexCoord2f(1 / 4f, 1 / 3f);
		GL11.glVertex3d(-1, 1, 1);

		GL11.glTexCoord2f(2 / 4f, 1 / 3f);
		GL11.glVertex3d(1, 1, 1);

		GL11.glTexCoord2f(2 / 4f, 2 / 3f);
		GL11.glVertex3d(1, -1, 1);
		// Right
		GL11.glTexCoord2f(2 / 4f, 1 / 3f);
		GL11.glVertex3d(1, 1, 1);

		GL11.glTexCoord2f(2 / 4f, 2 / 3f);
		GL11.glVertex3d(1, -1, 1);

		GL11.glTexCoord2f(3 / 4f, 2 / 3f);
		GL11.glVertex3d(1, -1, -1);

		GL11.glTexCoord2f(3 / 4f, 1 / 3f);
		GL11.glVertex3d(1, 1, -1);
		// Back
		GL11.glTexCoord2f(3 / 4f, 2 / 3f);
		GL11.glVertex3d(1, -1, -1);

		GL11.glTexCoord2f(3 / 4f, 1 / 3f);
		GL11.glVertex3d(1, 1, -1);

		GL11.glTexCoord2f(4 / 4f, 1 / 3f);
		GL11.glVertex3d(-1, 1, -1);

		GL11.glTexCoord2f(4 / 4f, 2 / 3f);
		GL11.glVertex3d(-1, -1, -1);
		// Up
		GL11.glTexCoord2f(1 / 4f, 0);
		GL11.glVertex3d(-1, 1, -1);

		GL11.glTexCoord2f(1 / 4f, 1 / 3f);
		GL11.glVertex3d(-1, 1, 1);

		GL11.glTexCoord2f(2 / 4f, 1 / 3f);
		GL11.glVertex3d(1, 1, 1);

		GL11.glTexCoord2f(2 / 4f, 0);
		GL11.glVertex3d(1, 1, -1);
		// Down
		GL11.glTexCoord2f(1 / 4f, 2 / 3f);
		GL11.glVertex3d(-1, -1, 1);

		GL11.glTexCoord2f(1 / 4f, 3 / 3f);
		GL11.glVertex3d(-1, -1, -1);

		GL11.glTexCoord2f(2 / 4f, 3 / 3f);
		GL11.glVertex3d(1, -1, -1);

		GL11.glTexCoord2f(2 / 4f, 2 / 3f);
		GL11.glVertex3d(1, -1, 1);
		GL11.glEnd();

		GL11.glPopAttrib();
		GL11.glPopAttrib();
		GL11.glPopMatrix();
	}
}
