package com.parzivail.pswm.rendering;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.ModelDeathStarDoor;
import com.parzivail.pswm.tileentities.TileEntityDeathStarDoor;

public class RenderDeathStarDoor extends TileEntitySpecialRenderer
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID + ":" + "textures/blocks/deathStarDoor.png");

	private final ModelDeathStarDoor model;

	public RenderDeathStarDoor()
	{
		this.model = new ModelDeathStarDoor();
	}

	private void adjustRotatePivotViaMeta(World world, int x, int y, int z)
	{
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float p)
	{
		GL11.glPushMatrix();
		TileEntityDeathStarDoor door = (TileEntityDeathStarDoor)te;
		GL11.glTranslatef((float)x + 0.5f, (float)y + 2.55F, (float)z + 0.5f);
		switch (door.getFacing())
		{
			case 0:
				GL11.glTranslatef(0.11f, 0, 0); // south
				GL11.glScaled(0.943f, 0.995f, 1.255f);
				break;
			case 1:
				GL11.glTranslatef(0, 0, 0.11f); // west
				GL11.glScaled(1.255f, 0.995f, 0.943f);
				break;
			case 2:
				GL11.glTranslatef(-0.11f, 0, 0); // north
				GL11.glScaled(0.943f, 0.995f, 1.255f);
				break;
			case 3:
				GL11.glTranslatef(0, 0, -0.11f); // east
				GL11.glScaled(1.255f, 0.995f, 0.943f);
				break;
		}
		GL11.glScalef(1, 1.15f, 1);
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(door.getFacing() * 90, 0.0F, 1.0F, 0.0F);

		if (te.getWorldObj().getEntitiesWithinAABB(Entity.class, te.getRenderBoundingBox().expand(6, 3, 6)).size() > 0)
		{
			door.isClosing = false;
			door.isOpening = true;
		}
		else
		{
			door.isClosing = true;
			door.isOpening = false;
		}

		p = door.isMoving ? door.isOpening ? p : -p : 0;

		p = door.progressTicks + 1 > door.totalTicks || door.progressTicks - 1 <= 0 ? 0 : p;

		float percent = (door.progressTicks + p) / door.totalTicks;

		this.model.SplitFrontTopParent.offsetX = -3.25f * percent;
		this.model.SplitFrontBottomParent.offsetX = 3.25f * percent;
		this.model.SplitBackTopParent.offsetX = -3.25f * percent;
		this.model.SplitBackBottomParent.offsetX = 3.25f * percent;
		this.model.SplitMiddleTopParent.offsetX = -3.25f * percent;
		this.model.SplitMiddleBottomParent.offsetX = 3.25f * percent;

		this.model.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.05F);
		GL11.glPopMatrix();
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\RenderMV.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */