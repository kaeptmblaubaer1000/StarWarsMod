package com.parzivail.pswm.rendering.force;

import com.parzivail.pswm.force.Cron;
import com.parzivail.pswm.force.powers.PowerBase;
import com.parzivail.pswm.force.powers.PowerLightning;
import com.parzivail.util.ui.Lumberjack;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import org.lwjgl.opengl.GL11;

import java.util.Random;

public class RenderSithLightning
{
	Minecraft mc = Minecraft.getMinecraft();

	private boolean isClient(EntityPlayer player)
	{
		return player == mc.thePlayer;
	}

	public void onWorldRender(RenderWorldLastEvent event)
	{
		for (Object entity : this.mc.theWorld.playerEntities)
		{
			EntityPlayer player = (EntityPlayer)entity;

			PowerBase active = Cron.getActive(player);

			Lumberjack.log(active);

			if (active != null && active.name.equals("lightning") && active.isRunning)
			{
				PowerLightning powerLightning = (PowerLightning)active;
				Entity e = player.worldObj.getEntityByID(powerLightning.getEntityTargetId());

				if (e != null)
				{
					float dx = MathHelper.cos((float)Math.toRadians(player.rotationYaw)) / 2;
					float dz = MathHelper.sin((float)Math.toRadians(player.rotationYaw)) / 2;

					Random r = new Random(e.ticksExisted * 4);
					float posX2 = (float)e.posX;
					float posY2 = (float)e.posY + 2;
					float posZ2 = (float)e.posZ;
					for (int i = 0; i < 4; i++)
					{
						posX2 += (r.nextFloat() - 0.5f) * (e.boundingBox.maxX - e.boundingBox.minX) / 2;
						posY2 += (r.nextFloat() - 0.5f) * (e.boundingBox.maxY - e.boundingBox.minY) / 2;
						posZ2 += (r.nextFloat() - 0.5f) * (e.boundingBox.maxZ - e.boundingBox.minZ) / 2;

						if (this.isClient(player))
							this.render(r, posX2 - 0.5f, posY2 - 1f, posZ2 - 0.5f, (float)(player.posX - 0.5f + dx), (float)player.posY - 1, (float)(player.posZ - 0.5f + dz), 8, 0.15f);
						else
							this.render(r, posX2 - 0.5f, posY2 - 2.5f, posZ2 - 0.5f, (float)(player.posX + dx), (float)player.posY + 0.5f, (float)(player.posZ + dz), 8, 0.15f);

					}

					posX2 = (float)e.posX;
					posY2 = (float)e.posY + 2;
					posZ2 = (float)e.posZ;
					for (int i = 0; i < 4; i++)
					{
						posX2 += (r.nextFloat() - 0.5f) * (e.boundingBox.maxX - e.boundingBox.minX) / 2;
						posY2 += (r.nextFloat() - 0.5f) * (e.boundingBox.maxY - e.boundingBox.minY) / 2;
						posZ2 += (r.nextFloat() - 0.5f) * (e.boundingBox.maxZ - e.boundingBox.minZ) / 2;

						if (this.isClient(player))
							this.render(r, posX2 - 0.5f, posY2 - 1f, posZ2 - 0.5f, (float)(player.posX - 0.5f - dx), (float)player.posY - 1, (float)(player.posZ - 0.5f - dz), 8, 0.15f);
						else
							this.render(r, posX2 - 0.5f, posY2 - 2.5f, posZ2 - 0.5f, (float)(player.posX + dx * 2), (float)player.posY + 0.5f, (float)(player.posZ + dz * 2), 8, 0.15f);

					}
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
