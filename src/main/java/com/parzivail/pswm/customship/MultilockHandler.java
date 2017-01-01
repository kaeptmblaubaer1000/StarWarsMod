package com.parzivail.pswm.customship;

import com.parzivail.pswm.PSWM;
import com.parzivail.util.lwjgl.Vector3f;
import com.parzivail.util.math.Cone;
import com.parzivail.util.ui.GFX;
import com.parzivail.util.ui.GLPalette;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

import java.util.List;

import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;

/**
 * Created by Colby on 12/5/2016.
 */
public class MultilockHandler
{
	public static Entity lockedEntity;
	public static float lockedDistance;

	public static boolean lockEnabled;

	public static void renderMultiLock(float partialTicks)
	{
		float angle = getDistance() / 2f; // targetLock -> range / 2
		float distance = getDistance(); // targetLock -> range

		List<Entity> entitiesNearPlayer = PSWM.mc.player.world.getEntitiesWithinAABB(Entity.class, PSWM.mc.player.getEntityBoundingBox().expand(distance, distance, distance));
		List<Entity> ents = Cone.getEntitiesInCone(entitiesNearPlayer, Vector3f.fromVec3(PSWM.mc.player.getPosition()), distance, angle, PSWM.mc.player.getLookVec());

		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_TEXTURE_2D); // fix for dimming bug!
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);

		float lowAngle = angle;
		Entity lowEntity = null;

		Vec3d pos = new Vec3d(PSWM.mc.player.getPosition());

		for (Entity e : ents)
		{
			if (e == PSWM.mc.getRenderViewEntity() || e.getDistanceSqToEntity(PSWM.mc.getRenderViewEntity()) < 1)
				continue;

			float a = Cone.getAngleBetween(PSWM.mc.getRenderViewEntity(), e);

			if (a <= lowAngle)
			{
				lowAngle = a;
				lowEntity = e;
			}

			GL11.glPushMatrix();
			GL11.glTranslated(-(pos.xCoord - 0.5), -(pos.yCoord - 0.5f), -(pos.zCoord - 0.5));
			GL11.glTranslated(e.posX - 0.5f, e.posY, e.posZ - 0.5f);
			GL11.glRotatef(-PSWM.mc.getRenderManager().playerViewY, 0, 1, 0);
			GL11.glRotatef(PSWM.mc.getRenderManager().playerViewX, 1, 0, 0);

			GLPalette.lerpColor3(1 - a / angle, GLPalette.ANALOG_RED, GLPalette.YELLOW, GLPalette.ANALOG_GREEN);
			renderLockShape();
			GL11.glPopMatrix();
		}

		if (lowEntity != null)
		{
			GLPalette.lerpColor3(1 - lowAngle / angle, GLPalette.ANALOG_RED, GLPalette.YELLOW, GLPalette.ANALOG_GREEN);
			GL11.glTranslated(-(pos.xCoord - 0.5), -(pos.yCoord - 0.5f), -(pos.zCoord - 0.5));
			GL11.glPushMatrix();
			glBegin(GL11.GL_LINE_STRIP);
			GL11.glVertex3d(lowEntity.posX - 0.5f, lowEntity.posY, lowEntity.posZ - 0.5f);
			GL11.glVertex3d(pos.xCoord - 0.5, pos.yCoord - 0.5f, pos.zCoord - 0.5);
			glEnd();
			GL11.glPopMatrix();
		}

		lockedEntity = lockEnabled ? lowEntity : null;
		lockedDistance = lockEnabled ? lowAngle : -1;

		GL11.glDisable(GL11.GL_LINE_SMOOTH);
		GL11.glEnable(GL11.GL_TEXTURE_2D); // end of fix
		GL11.glPopMatrix();
	}

	private static void renderLockShape()
	{
		GFX.drawLine(-0.5f, -0.5f, -0.5f, -0.25f);
		GFX.drawLine(-0.5f, -0.5f, -0.25f, -0.5f);

		GFX.drawLine(0.5f, 0.5f, 0.5f, 0.25f);
		GFX.drawLine(0.5f, 0.5f, 0.25f, 0.5f);

		GFX.drawLine(-0.5f, 0.5f, -0.5f, 0.25f);
		GFX.drawLine(-0.5f, 0.5f, -0.25f, 0.5f);

		GFX.drawLine(0.5f, -0.5f, 0.5f, -0.25f);
		GFX.drawLine(0.5f, -0.5f, 0.25f, -0.5f);
	}

	public static float getDistance()
	{
		// TODO: replace with targetLock ship component
		return 100;
	}
}
