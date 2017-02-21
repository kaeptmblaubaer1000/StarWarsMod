package com.parzivail.util.camera;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.parzivail.pswm.PSWM;
import com.parzivail.pswm.Resources;
import com.parzivail.pswm.handler.EventHandler;
import com.parzivail.util.common.Lumberjack;
import com.parzivail.util.driven.EntityCamera;
import com.parzivail.util.math.Animation;
import com.parzivail.util.math.FPoint;
import com.parzivail.util.math.RotatedAxes;
import com.parzivail.util.math.Spline3D;
import com.parzivail.util.ui.GFX;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.apache.commons.io.IOUtils;
import org.lwjgl.opengl.GL11;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by colby on 2/20/2017.
 */
public class JibAnimation extends Animation
{
	private final Minecraft minecraft;

	private List<CameraSnapshot> cameraSnapshots;
	private Spline3D positionSpline;
	private Spline3D rotationSpline;

	private EntityCamera camera;
	private JsonElement serializedSnapshots;
	private int renderList;

	/**
	 * Creates a new JibAnimation
	 *
	 * @param length The length (in ticks) of the animation
	 */
	public JibAnimation(Minecraft minecraft, int length)
	{
		super(length, false, true);
		this.minecraft = minecraft;
		cameraSnapshots = new ArrayList<>();
	}

	/**
	 * Take a snapshot of the entity's viewport and add it as a keyframe. Then, rebuild the splines.
	 *
	 * @param entity
	 */
	public void snapshotCamera(EntityPlayer entity)
	{
		FPoint pos = new FPoint(entity.posX, entity.posY, entity.posZ);
		RotatedAxes rot = new RotatedAxes(entity.rotationYaw, entity.rotationPitch, 0);
		cameraSnapshots.add(new CameraSnapshot(pos, rot));
	}

	private void rebuildSplines()
	{
		positionSpline = new Spline3D(CameraSnapshot.toPositionFPoint(cameraSnapshots));
		rotationSpline = new Spline3D(CameraSnapshot.toRotationFPoint(cameraSnapshots));
	}

	@Override
	public void start()
	{
		if (cameraSnapshots.size() < 2)
			return;

		rebuildSplines();

		renderPath();

		camera = new EntityCamera(minecraft.world);
		minecraft.world.spawnEntity(camera);

		super.start();
	}

	@Override
	public void stop()
	{
		GFX.changeRenderEntity(PSWM.mc.player);
		camera.setDead();
		GFX.changeCameraRoll(0);
		super.stop();
	}

	@Override
	public void reset()
	{
		GFX.changeRenderEntity(PSWM.mc.player);
		camera.setDead();
		GFX.changeCameraRoll(0);
		super.reset();
	}

	@Override
	public void render(RenderGameOverlayEvent event)
	{
		if (cameraSnapshots.size() < 2)
			return;

		float lerp = (tick + event.getPartialTicks()) / (float)length;

		lerp = MathHelper.clamp(lerp, 0, 1);

		camera.loadAnglesFrom(positionSpline.getSplineX().getValue(lerp), positionSpline.getSplineY().getValue(lerp), positionSpline.getSplineZ().getValue(lerp), rotationSpline.getSplineX().getValue(lerp) - 180, rotationSpline.getSplineY().getValue(lerp), rotationSpline.getSplineZ().getValue(lerp));

		GFX.changeRenderEntity(camera);
	}

	public List<CameraSnapshot> getSnapshots()
	{
		return cameraSnapshots;
	}

	public List<CameraSnapshot.SerializedCameraSnapshot> getSerializedSnapshots()
	{
		List<CameraSnapshot.SerializedCameraSnapshot> scs = new ArrayList<>();
		for (CameraSnapshot snapshot : cameraSnapshots)
			scs.add(snapshot.createdSerializedSnapshot());
		return scs;
	}

	public FPoint getPositionAt(float lerp)
	{
		lerp = MathHelper.clamp(lerp, 0, 1);

		return positionSpline.getPoint(lerp);
	}

	public String exportJson()
	{
		Gson gson = new Gson();
		return gson.toJson(EventHandler.jib.getSerializedSnapshots());
	}

	public void importJson(String json)
	{
		Gson gson = new Gson();
		CameraSnapshot.SerializedCameraSnapshot[] des = gson.fromJson(json, CameraSnapshot.SerializedCameraSnapshot[].class);

		cameraSnapshots = importSnapshots(des);
	}

	public void loadFromFile(String filename)
	{
		try
		{
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("assets/" + Resources.MODID + "/jibs/" + filename + ".jib");
			importJson(IOUtils.toString(is));
		}
		catch (Exception e)
		{
			Lumberjack.err(String.format("Unable to load jib '%s'. Stack Trace:", filename));
			e.printStackTrace();
		}
		Lumberjack.err(String.format("Loaded jib '%s'.", filename));
	}

	private List<CameraSnapshot> importSnapshots(CameraSnapshot.SerializedCameraSnapshot[] des)
	{
		List<CameraSnapshot> snapshots = new ArrayList<>();

		for (CameraSnapshot.SerializedCameraSnapshot scs : des)
		{
			RotatedAxes rotAxes = new RotatedAxes(scs.rotation.x + 180, scs.rotation.y, scs.rotation.z);
			snapshots.add(new CameraSnapshot(scs.position, rotAxes));
		}

		return snapshots;
	}

	private void renderPath()
	{
		GL11.glNewList(renderList, GL11.GL_COMPILE);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_TEXTURE_2D); // fix for dimming bug!
		GL11.glBegin(GL11.GL_LINE_STRIP);
		for (int i = 0; i < 100; i++)
		{
			FPoint point = getPositionAt(i / 100f);
			GL11.glVertex3f(point.x, point.y, point.z);
		}
		GL11.glEnd();
		GL11.glEnable(GL11.GL_TEXTURE_2D); // end of fix
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_LIGHT7);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glEndList();
	}

	public int getRenderList()
	{
		if (renderList == 0)
			renderList = GL11.glGenLists(1);
		return renderList;
	}
}
