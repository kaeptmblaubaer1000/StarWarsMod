package com.parzivail.util.camera;

import com.google.gson.JsonElement;
import com.parzivail.pswm.PSWM;
import com.parzivail.util.driven.EntityCamera;
import com.parzivail.util.lwjgl.Vector3f;
import com.parzivail.util.math.Animation;
import com.parzivail.util.math.RotatedAxes;
import com.parzivail.util.math.Spline3D;
import com.parzivail.util.ui.GFX;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by colby on 2/20/2017.
 */
public class Boom extends Animation
{
	private final Minecraft minecraft;

	private List<CameraSnapshot> cameraSnapshots;
	private Spline3D positionSpline;
	private Spline3D rotationSpline;

	private EntityCamera camera;
	private JsonElement serializedSnapshots;

	/**
	 * Creates a new Boom
	 *
	 * @param length The length (in ticks) of the animation
	 */
	public Boom(Minecraft minecraft, int length)
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
		Vector3f pos = new Vector3f(entity.posX, entity.posY, entity.posZ);
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

		camera = new EntityCamera(minecraft.world);
		minecraft.world.spawnEntity(camera);

		super.start();
	}

	@Override
	public void stop()
	{
		GFX.changeRenderEntity(PSWM.mc.player);
		camera.setDead();
		super.stop();
	}

	@Override
	public void reset()
	{
		GFX.changeRenderEntity(PSWM.mc.player);
		camera.setDead();
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
}
