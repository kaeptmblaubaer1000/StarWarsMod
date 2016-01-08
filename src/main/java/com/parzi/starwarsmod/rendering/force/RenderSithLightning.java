package com.parzi.starwarsmod.rendering.force;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderWorldLastEvent;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.jedirobes.ArmorJediRobes;

public class RenderSithLightning
{
	Minecraft mc = Minecraft.getMinecraft();

	public RenderSithLightning()
	{

	}

	public void onWorldRender(RenderWorldLastEvent event)
	{
		for (Object entity : this.mc.theWorld.playerEntities)
		{
			EntityPlayer player = (EntityPlayer)entity;

			Entity e = player.worldObj.getPlayerEntityByName(player.getDataWatcher().getWatchableObjectString(StarWarsMod.lightningDatawatcherId).trim());

			if (e == null)
				e = player.worldObj.getPlayerEntityByName(ArmorJediRobes.getLightningTarget(player));

			if (e != null)
			{
				Random r = new Random(e.ticksExisted * 4);
				float posX2 = (float)player.posX - 0.5f;
				float posY2 = (float)player.posY - 1;
				float posZ2 = (float)player.posZ - 0.5f;
				for (int i = 0; i < 4; i++)
				{
					posX2 += (r.nextFloat() - 0.5f) * (player.boundingBox.maxX - player.posX) - (player.boundingBox.maxX - player.posX) / 2;
					posY2 += (r.nextFloat() - 0.5f) * (player.boundingBox.maxY - player.posY) - (player.boundingBox.maxY - player.posY) / 2;
					posZ2 += (r.nextFloat() - 0.5f) * (player.boundingBox.maxZ - player.posZ) - (player.boundingBox.maxZ - player.posZ) / 2;

					this.render(r, posX2, posY2, posZ2, (float)e.posX, (float)e.posY + 2, (float)e.posZ, 8, 0.15f);
				}
			}
		}
	}

	public void render(Random r, float posX, float posY, float posZ, float posX2, float posY2, float posZ2, float distance, float curDetail)
	{
		if (distance < curDetail)
		{
			GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_TEXTURE_2D); // fix for dimming bug!
			GL11.glEnable(GL11.GL_LINE_SMOOTH);
			GL11.glTranslated(-(this.mc.thePlayer.posX - 0.5), -(this.mc.thePlayer.posY - 0.5f), -(this.mc.thePlayer.posZ - 0.5));

			GL11.glLineWidth(8);
			GL11.glColor3f(0f, 0f, 1f);

			GL11.glBegin(GL11.GL_LINES);
			GL11.glVertex3d(posX, posY, posZ);
			GL11.glVertex3d(posX2, posY2, posZ2);
			GL11.glEnd();

			GL11.glLineWidth(6);
			GL11.glColor3f(0.5f, 0.5f, 1f);

			GL11.glBegin(GL11.GL_LINES);
			GL11.glVertex3d(posX, posY, posZ);
			GL11.glVertex3d(posX2, posY2, posZ2);
			GL11.glEnd();

			GL11.glLineWidth(2);
			GL11.glColor3f(1, 1, 1);

			GL11.glBegin(GL11.GL_LINES);
			GL11.glVertex3d(posX, posY, posZ);
			GL11.glVertex3d(posX2, posY2, posZ2);
			GL11.glEnd();

			GL11.glDisable(GL11.GL_LINE_SMOOTH);
			GL11.glEnable(GL11.GL_TEXTURE_2D); // end of fix
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glColor3f(1, 1, 1);
			GL11.glPopMatrix();
		}
		else
		{
			float mid_x = (posX2 + posX) / 2f;
			float mid_y = (posY2 + posY) / 2f;
			float mid_z = (posZ2 + posZ) / 2f;
			mid_x += (r.nextFloat() - 0.5f) / 10f * distance;
			mid_y += (r.nextFloat() - 0.5f) / 10f * distance;
			mid_z += (r.nextFloat() - 0.5f) / 10f * distance;

			this.render(r, posX, posY, posZ, mid_x, mid_y, mid_z, distance / 2f, curDetail);
			this.render(r, posX2, posY2, posZ2, mid_x, mid_y, mid_z, distance / 2f, curDetail);
		}
	}
}
